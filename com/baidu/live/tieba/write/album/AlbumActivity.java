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
import com.baidu.l.a.a;
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
import com.baidu.megapp.ma.Util;
/* loaded from: classes11.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0148a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c bLb;
    private com.baidu.live.tieba.write.album.a bLc;
    private e bLe;
    private boolean bLk;
    private com.baidu.live.tieba.c.a bLl;
    private FrameLayout bLm;
    private FrameLayout bLn;
    private int bby = 0;
    private boolean bLd = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bLf = 0;
    private boolean bLg = false;
    private boolean bLh = false;
    private int bLi = 0;
    private View bLj = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.g.sdk_ph_album_activity);
            this.bLj = findViewById(a.f.statebar_view);
            this.bLm = (FrameLayout) findViewById(a.f.imageList_layout);
            this.bLn = (FrameLayout) findViewById(a.f.imageBrowse_layout);
            this.bLk = UtilHelper.canUseStyleImmersiveSticky();
            Uh();
            initData(bundle);
            this.bLc = new com.baidu.live.tieba.write.album.a(this);
            this.bLc.Uu();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bLm.addView(this.bLc.UC().getView(), layoutParams);
            this.bLn.addView(this.bLc.UB().getView(), layoutParams);
            eP(0);
        }
    }

    public void showTip(View view) {
        if (this.bLl == null && view != null) {
            this.bLl = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bLl.en(a.e.sdk_ph_bg_tip_blue_up_left);
            this.bLl.e(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bLl.Tz();
                }
            });
            this.bLl.em(16);
            this.bLl.eo(5000);
        }
        if (this.bLl != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bLl.aJ(getString(a.h.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Uh() {
        if (this.bLj != null) {
            if (this.bLk && this.bLj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bLj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bLj.setLayoutParams(layoutParams);
                dm(true);
                return;
            }
            dm(false);
        }
    }

    private void dm(boolean z) {
        if (this.bLj != null) {
            if (this.bLk && z && this.bLj.getVisibility() != 0) {
                this.bLj.setVisibility(0);
            } else if (!z && this.bLj.getVisibility() != 8) {
                this.bLj.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bLb.UH().toJsonString());
        bundle.putBoolean("use_original_img", this.bLg);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bLf);
        bundle.putBoolean("from_write", this.bLh);
    }

    private void initData(Bundle bundle) {
        this.bLb = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bLb.a(writeImagesInfo);
            this.bLg = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bLf = bundle.getInt("album_thread");
            this.bLh = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bLi = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bLb.a(writeImagesInfo2);
                this.bLb.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bLg = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bLf = intent.getIntExtra("album_thread", 0);
                this.bLh = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bLi = intent.getIntExtra("from_type", 0);
            }
        }
        Ui();
    }

    private void Ui() {
        if (this.requestFrom == 2) {
            this.bLe = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.bLc != null) {
            this.bLc.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bLj, a.c.sdk_cp_bg_line_d, i);
    }

    public void Uj() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bLb != null) {
            if (ListUtils.getCount(this.bLb.UG()) == 1 && this.bLi == 0) {
                Uk();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bLb.UH().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bLi);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Uk() {
        WriteImagesInfo UH;
        if (this.bLb != null && (UH = this.bLb.UH()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", UH.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bLb == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo UH = this.bLb.UH();
            UH.parseJson(stringExtra);
            UH.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            o(intent);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLc.Uw()) {
            Uj();
        } else if (view == this.bLc.Uy()) {
            Uj();
        } else if (view == this.bLc.Uv()) {
            if (this.bLb != null) {
                this.bLb.setLastAlbumId(null);
            }
            Uq();
        } else if (view == this.bLc.Ux()) {
            eP(0);
        } else if (view == this.bLc.Uz()) {
            eN(2);
        } else if (view == this.bLc.UA()) {
            eN(1);
        }
    }

    private void eN(int i) {
        if (this.bLc != null && this.bLb != null) {
            this.bLb.setOriginalImg(!this.bLb.isOriginalImg());
            Ul();
            eO(i);
        }
    }

    private void eO(int i) {
        if (this.bLb != null && this.bLb.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Ul() {
        if (this.bLb != null && this.bLc != null) {
            this.bLc.dn(this.bLb.isOriginalImg());
        }
    }

    public View Um() {
        return this.bLj;
    }

    public int Un() {
        return this.bLf;
    }

    public c Uo() {
        return this.bLb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eP(int i) {
        if (!this.bLd) {
            this.bby = i;
            if (i == 0) {
                this.bLm.setVisibility(0);
                this.bLn.setVisibility(8);
                this.bLc.UC().onResume();
                return;
            }
            this.bLm.setVisibility(8);
            this.bLn.setVisibility(0);
            this.bLc.UB().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bLb.getMaxImagesAllowed();
        if (this.bLb.size() < maxImagesAllowed) {
            if (this.bLe == null || this.bLe.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bLb.a((VideoFileInfo) null);
                this.bLb.addChooseFile(imageFileInfo2);
                Ul();
                return true;
            }
            return false;
        } else if (Up()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.h.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Up() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bLb.getMaxImagesAllowed();
            if (this.bLb.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bLb.UG(), 0);
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
        this.bLb.a((VideoFileInfo) null);
        this.bLb.delChooseFile(imageFileInfo);
        Ul();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.bby == 0) {
                if (this.bLb != null) {
                    this.bLb.setLastAlbumId(null);
                }
                Uq();
                return true;
            } else if (this.bby == 1) {
                eP(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bLc != null) {
            this.bLc.UC().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bLc != null) {
            this.bLc.UB().c(imageFileInfo, z);
        }
    }

    private void Uq() {
        Intent intent = new Intent();
        String lastAlbumId = this.bLb.getLastAlbumId();
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bLd = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.UL().destory();
        if (this.bLj != null) {
            this.bLj.setBackgroundDrawable(null);
        }
        if (this.bLc != null) {
            this.bLc.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bLb.UH(), true);
            return AlbumActivity.this.bLb.UH().toJsonString();
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
            aM("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo()) {
            aM("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aM(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
