package com.baidu.live.tieba.write.album;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.ImageUploader;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import com.baidu.m.a.a;
import com.baidu.megapp.ma.Util;
/* loaded from: classes4.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0224a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private boolean bvD;
    private com.baidu.live.tieba.c.a bvE;
    private FrameLayout bvF;
    private FrameLayout bvG;
    private c bvu;
    private com.baidu.live.tieba.write.album.a bvv;
    private e bvx;
    private int aXa = 0;
    private boolean bvw = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bvy = 0;
    private boolean bvz = false;
    private boolean bvA = false;
    private int bvB = 0;
    private View bvC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.h.sdk_ph_album_activity);
            this.bvC = findViewById(a.g.statebar_view);
            this.bvF = (FrameLayout) findViewById(a.g.imageList_layout);
            this.bvG = (FrameLayout) findViewById(a.g.imageBrowse_layout);
            this.bvD = UtilHelper.canUseStyleImmersiveSticky();
            PW();
            initData(bundle);
            this.bvv = new com.baidu.live.tieba.write.album.a(this);
            this.bvv.Qj();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bvF.addView(this.bvv.Qr().getView(), layoutParams);
            this.bvG.addView(this.bvv.Qq().getView(), layoutParams);
            fH(0);
        }
    }

    public void showTip(View view) {
        if (this.bvE == null && view != null) {
            this.bvE = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bvE.ff(a.f.sdk_ph_bg_tip_blue_up_left);
            this.bvE.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bvE.Po();
                }
            });
            this.bvE.fe(16);
            this.bvE.fg(5000);
        }
        if (this.bvE != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bvE.aJ(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void PW() {
        if (this.bvC != null) {
            if (this.bvD && this.bvC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bvC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bvC.setLayoutParams(layoutParams);
                cC(true);
                return;
            }
            cC(false);
        }
    }

    private void cC(boolean z) {
        if (this.bvC != null) {
            if (this.bvD && z && this.bvC.getVisibility() != 0) {
                this.bvC.setVisibility(0);
            } else if (!z && this.bvC.getVisibility() != 8) {
                this.bvC.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bvu.Qw().toJsonString());
        bundle.putBoolean("use_original_img", this.bvz);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bvy);
        bundle.putBoolean("from_write", this.bvA);
    }

    private void initData(Bundle bundle) {
        this.bvu = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bvu.a(writeImagesInfo);
            this.bvz = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bvy = bundle.getInt("album_thread");
            this.bvA = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bvB = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bvu.a(writeImagesInfo2);
                this.bvu.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bvz = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bvy = intent.getIntExtra("album_thread", 0);
                this.bvA = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bvB = intent.getIntExtra("from_type", 0);
            }
        }
        PX();
    }

    private void PX() {
        if (this.requestFrom == 2) {
            this.bvx = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
                @Override // com.baidu.live.tieba.write.album.e
                public boolean c(ImageFileInfo imageFileInfo) {
                    if (imageFileInfo != null) {
                        String filePath = imageFileInfo.getFilePath();
                        if (!StringUtils.isNullObject(filePath)) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeFile(filePath, options);
                            int i = options.outWidth;
                            if (options.outHeight >= 200 && i >= 200) {
                                return true;
                            }
                        }
                    }
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(a.i.sdk_ph_uploade_attation), a.f.sdk_icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.bvv != null) {
            this.bvv.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bvC, a.d.sdk_cp_bg_line_d, i);
    }

    public void PY() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bvu != null) {
            if (ListUtils.getCount(this.bvu.Qv()) == 1 && this.bvB == 0) {
                PZ();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bvu.Qw().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bvB);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void PZ() {
        WriteImagesInfo Qw;
        if (this.bvu != null && (Qw = this.bvu.Qw()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", Qw.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bvu == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo Qw = this.bvu.Qw();
            Qw.parseJson(stringExtra);
            Qw.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            o(intent);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvv.Ql()) {
            PY();
        } else if (view == this.bvv.Qn()) {
            PY();
        } else if (view == this.bvv.Qk()) {
            if (this.bvu != null) {
                this.bvu.setLastAlbumId(null);
            }
            Qf();
        } else if (view == this.bvv.Qm()) {
            fH(0);
        } else if (view == this.bvv.Qo()) {
            fF(2);
        } else if (view == this.bvv.Qp()) {
            fF(1);
        }
    }

    private void fF(int i) {
        if (this.bvv != null && this.bvu != null) {
            this.bvu.setOriginalImg(!this.bvu.isOriginalImg());
            Qa();
            fG(i);
        }
    }

    private void fG(int i) {
        if (this.bvu != null && this.bvu.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Qa() {
        if (this.bvu != null && this.bvv != null) {
            this.bvv.cD(this.bvu.isOriginalImg());
        }
    }

    public View Qb() {
        return this.bvC;
    }

    public int Qc() {
        return this.bvy;
    }

    public c Qd() {
        return this.bvu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fH(int i) {
        if (!this.bvw) {
            this.aXa = i;
            if (i == 0) {
                this.bvF.setVisibility(0);
                this.bvG.setVisibility(8);
                this.bvv.Qr().onResume();
                return;
            }
            this.bvF.setVisibility(8);
            this.bvG.setVisibility(0);
            this.bvv.Qq().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bvu.getMaxImagesAllowed();
        if (this.bvu.size() < maxImagesAllowed) {
            if (this.bvx == null || this.bvx.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bvu.a((VideoFileInfo) null);
                this.bvu.addChooseFile(imageFileInfo2);
                Qa();
                return true;
            }
            return false;
        } else if (Qe()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Qe() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bvu.getMaxImagesAllowed();
            if (this.bvu.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bvu.Qv(), 0);
                    if (b(imageFileInfo)) {
                        a(imageFileInfo, false);
                        b(imageFileInfo, false);
                        return true;
                    }
                } catch (Exception e) {
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.bvu.a((VideoFileInfo) null);
        this.bvu.delChooseFile(imageFileInfo);
        Qa();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aXa == 0) {
                if (this.bvu != null) {
                    this.bvu.setLastAlbumId(null);
                }
                Qf();
                return true;
            } else if (this.aXa == 1) {
                fH(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bvv != null) {
            this.bvv.Qr().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bvv != null) {
            this.bvv.Qq().c(imageFileInfo, z);
        }
    }

    private void Qf() {
        Intent intent = new Intent();
        String lastAlbumId = this.bvu.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bvw = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.QA().destory();
        if (this.bvC != null) {
            this.bvC.setBackgroundDrawable(null);
        }
        if (this.bvv != null) {
            this.bvv.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bvu.Qw(), true);
            return AlbumActivity.this.bvu.Qw().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
            AlbumActivity.this.setResult(-1, intent);
            AlbumActivity.this.finish();
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
        } else {
            aK("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo()) {
            aK("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aK(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
