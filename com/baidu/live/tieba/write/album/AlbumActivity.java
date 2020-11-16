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
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0248a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c bCi;
    private com.baidu.live.tieba.write.album.a bCj;
    private e bCl;
    private boolean bCr;
    private com.baidu.live.tieba.c.a bCs;
    private FrameLayout bCt;
    private FrameLayout bCu;
    private int aYc = 0;
    private boolean bCk = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bCm = 0;
    private boolean bCn = false;
    private boolean bCo = false;
    private int bCp = 0;
    private View bCq = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.g.sdk_ph_album_activity);
            this.bCq = findViewById(a.f.statebar_view);
            this.bCt = (FrameLayout) findViewById(a.f.imageList_layout);
            this.bCu = (FrameLayout) findViewById(a.f.imageBrowse_layout);
            this.bCr = UtilHelper.canUseStyleImmersiveSticky();
            SQ();
            initData(bundle);
            this.bCj = new com.baidu.live.tieba.write.album.a(this);
            this.bCj.Td();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bCt.addView(this.bCj.Tl().getView(), layoutParams);
            this.bCu.addView(this.bCj.Tk().getView(), layoutParams);
            fS(0);
        }
    }

    public void showTip(View view) {
        if (this.bCs == null && view != null) {
            this.bCs = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bCs.fq(a.e.sdk_ph_bg_tip_blue_up_left);
            this.bCs.d(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bCs.Si();
                }
            });
            this.bCs.fp(16);
            this.bCs.fr(5000);
        }
        if (this.bCs != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bCs.aL(getString(a.h.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void SQ() {
        if (this.bCq != null) {
            if (this.bCr && this.bCq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bCq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bCq.setLayoutParams(layoutParams);
                cR(true);
                return;
            }
            cR(false);
        }
    }

    private void cR(boolean z) {
        if (this.bCq != null) {
            if (this.bCr && z && this.bCq.getVisibility() != 0) {
                this.bCq.setVisibility(0);
            } else if (!z && this.bCq.getVisibility() != 8) {
                this.bCq.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bCi.Tq().toJsonString());
        bundle.putBoolean("use_original_img", this.bCn);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bCm);
        bundle.putBoolean("from_write", this.bCo);
    }

    private void initData(Bundle bundle) {
        this.bCi = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bCi.a(writeImagesInfo);
            this.bCn = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bCm = bundle.getInt("album_thread");
            this.bCo = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bCp = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bCi.a(writeImagesInfo2);
                this.bCi.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bCn = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bCm = intent.getIntExtra("album_thread", 0);
                this.bCo = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bCp = intent.getIntExtra("from_type", 0);
            }
        }
        SR();
    }

    private void SR() {
        if (this.requestFrom == 2) {
            this.bCl = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(a.h.sdk_ph_uploade_attation), a.e.sdk_icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.bCj != null) {
            this.bCj.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bCq, a.c.sdk_cp_bg_line_d, i);
    }

    public void SS() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bCi != null) {
            if (ListUtils.getCount(this.bCi.Tp()) == 1 && this.bCp == 0) {
                ST();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bCi.Tq().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bCp);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void ST() {
        WriteImagesInfo Tq;
        if (this.bCi != null && (Tq = this.bCi.Tq()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", Tq.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bCi == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo Tq = this.bCi.Tq();
            Tq.parseJson(stringExtra);
            Tq.updateQuality();
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
        if (view == this.bCj.Tf()) {
            SS();
        } else if (view == this.bCj.Th()) {
            SS();
        } else if (view == this.bCj.Te()) {
            if (this.bCi != null) {
                this.bCi.setLastAlbumId(null);
            }
            SZ();
        } else if (view == this.bCj.Tg()) {
            fS(0);
        } else if (view == this.bCj.Ti()) {
            fQ(2);
        } else if (view == this.bCj.Tj()) {
            fQ(1);
        }
    }

    private void fQ(int i) {
        if (this.bCj != null && this.bCi != null) {
            this.bCi.setOriginalImg(!this.bCi.isOriginalImg());
            SU();
            fR(i);
        }
    }

    private void fR(int i) {
        if (this.bCi != null && this.bCi.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void SU() {
        if (this.bCi != null && this.bCj != null) {
            this.bCj.cS(this.bCi.isOriginalImg());
        }
    }

    public View SV() {
        return this.bCq;
    }

    public int SW() {
        return this.bCm;
    }

    public c SX() {
        return this.bCi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fS(int i) {
        if (!this.bCk) {
            this.aYc = i;
            if (i == 0) {
                this.bCt.setVisibility(0);
                this.bCu.setVisibility(8);
                this.bCj.Tl().onResume();
                return;
            }
            this.bCt.setVisibility(8);
            this.bCu.setVisibility(0);
            this.bCj.Tk().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bCi.getMaxImagesAllowed();
        if (this.bCi.size() < maxImagesAllowed) {
            if (this.bCl == null || this.bCl.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bCi.a((VideoFileInfo) null);
                this.bCi.addChooseFile(imageFileInfo2);
                SU();
                return true;
            }
            return false;
        } else if (SY()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.h.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean SY() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bCi.getMaxImagesAllowed();
            if (this.bCi.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bCi.Tp(), 0);
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
        this.bCi.a((VideoFileInfo) null);
        this.bCi.delChooseFile(imageFileInfo);
        SU();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aYc == 0) {
                if (this.bCi != null) {
                    this.bCi.setLastAlbumId(null);
                }
                SZ();
                return true;
            } else if (this.aYc == 1) {
                fS(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bCj != null) {
            this.bCj.Tl().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bCj != null) {
            this.bCj.Tk().c(imageFileInfo, z);
        }
    }

    private void SZ() {
        Intent intent = new Intent();
        String lastAlbumId = this.bCi.getLastAlbumId();
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
        this.bCk = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.Tu().destory();
        if (this.bCq != null) {
            this.bCq.setBackgroundDrawable(null);
        }
        if (this.bCj != null) {
            this.bCj.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bCi.Tq(), true);
            return AlbumActivity.this.bCi.Tq().toJsonString();
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
            aO("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo()) {
            aO("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aO(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
