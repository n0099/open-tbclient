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
import com.baidu.megapp.ma.Util;
import com.baidu.n.a.a;
/* loaded from: classes11.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0277a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c bMd;
    private com.baidu.live.tieba.write.album.a bMe;
    private e bMg;
    private boolean bMm;
    private com.baidu.live.tieba.c.a bMn;
    private FrameLayout bMo;
    private FrameLayout bMp;
    private int bdf = 0;
    private boolean bMf = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bMh = 0;
    private boolean bMi = false;
    private boolean bMj = false;
    private int bMk = 0;
    private View bMl = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.g.sdk_ph_album_activity);
            this.bMl = findViewById(a.f.statebar_view);
            this.bMo = (FrameLayout) findViewById(a.f.imageList_layout);
            this.bMp = (FrameLayout) findViewById(a.f.imageBrowse_layout);
            this.bMm = UtilHelper.canUseStyleImmersiveSticky();
            Wt();
            initData(bundle);
            this.bMe = new com.baidu.live.tieba.write.album.a(this);
            this.bMe.WG();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bMo.addView(this.bMe.WO().getView(), layoutParams);
            this.bMp.addView(this.bMe.WN().getView(), layoutParams);
            gs(0);
        }
    }

    public void showTip(View view) {
        if (this.bMn == null && view != null) {
            this.bMn = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bMn.fP(a.e.sdk_ph_bg_tip_blue_up_left);
            this.bMn.e(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bMn.VL();
                }
            });
            this.bMn.fO(16);
            this.bMn.fQ(5000);
        }
        if (this.bMn != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bMn.aK(getString(a.h.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Wt() {
        if (this.bMl != null) {
            if (this.bMm && this.bMl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMl.setLayoutParams(layoutParams);
                di(true);
                return;
            }
            di(false);
        }
    }

    private void di(boolean z) {
        if (this.bMl != null) {
            if (this.bMm && z && this.bMl.getVisibility() != 0) {
                this.bMl.setVisibility(0);
            } else if (!z && this.bMl.getVisibility() != 8) {
                this.bMl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bMd.WT().toJsonString());
        bundle.putBoolean("use_original_img", this.bMi);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bMh);
        bundle.putBoolean("from_write", this.bMj);
    }

    private void initData(Bundle bundle) {
        this.bMd = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bMd.a(writeImagesInfo);
            this.bMi = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bMh = bundle.getInt("album_thread");
            this.bMj = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bMk = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bMd.a(writeImagesInfo2);
                this.bMd.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bMi = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bMh = intent.getIntExtra("album_thread", 0);
                this.bMj = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bMk = intent.getIntExtra("from_type", 0);
            }
        }
        Wu();
    }

    private void Wu() {
        if (this.requestFrom == 2) {
            this.bMg = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.bMe != null) {
            this.bMe.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bMl, a.c.sdk_cp_bg_line_d, i);
    }

    public void Wv() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bMd != null) {
            if (ListUtils.getCount(this.bMd.WS()) == 1 && this.bMk == 0) {
                Ww();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bMd.WT().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bMk);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Ww() {
        WriteImagesInfo WT;
        if (this.bMd != null && (WT = this.bMd.WT()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", WT.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bMd == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo WT = this.bMd.WT();
            WT.parseJson(stringExtra);
            WT.updateQuality();
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
        if (view == this.bMe.WI()) {
            Wv();
        } else if (view == this.bMe.WK()) {
            Wv();
        } else if (view == this.bMe.WH()) {
            if (this.bMd != null) {
                this.bMd.setLastAlbumId(null);
            }
            WC();
        } else if (view == this.bMe.WJ()) {
            gs(0);
        } else if (view == this.bMe.WL()) {
            gq(2);
        } else if (view == this.bMe.WM()) {
            gq(1);
        }
    }

    private void gq(int i) {
        if (this.bMe != null && this.bMd != null) {
            this.bMd.setOriginalImg(!this.bMd.isOriginalImg());
            Wx();
            gr(i);
        }
    }

    private void gr(int i) {
        if (this.bMd != null && this.bMd.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Wx() {
        if (this.bMd != null && this.bMe != null) {
            this.bMe.dj(this.bMd.isOriginalImg());
        }
    }

    public View Wy() {
        return this.bMl;
    }

    public int Wz() {
        return this.bMh;
    }

    public c WA() {
        return this.bMd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gs(int i) {
        if (!this.bMf) {
            this.bdf = i;
            if (i == 0) {
                this.bMo.setVisibility(0);
                this.bMp.setVisibility(8);
                this.bMe.WO().onResume();
                return;
            }
            this.bMo.setVisibility(8);
            this.bMp.setVisibility(0);
            this.bMe.WN().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bMd.getMaxImagesAllowed();
        if (this.bMd.size() < maxImagesAllowed) {
            if (this.bMg == null || this.bMg.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bMd.a((VideoFileInfo) null);
                this.bMd.addChooseFile(imageFileInfo2);
                Wx();
                return true;
            }
            return false;
        } else if (WB()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.h.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean WB() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bMd.getMaxImagesAllowed();
            if (this.bMd.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bMd.WS(), 0);
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
        this.bMd.a((VideoFileInfo) null);
        this.bMd.delChooseFile(imageFileInfo);
        Wx();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.bdf == 0) {
                if (this.bMd != null) {
                    this.bMd.setLastAlbumId(null);
                }
                WC();
                return true;
            } else if (this.bdf == 1) {
                gs(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bMe != null) {
            this.bMe.WO().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bMe != null) {
            this.bMe.WN().c(imageFileInfo, z);
        }
    }

    private void WC() {
        Intent intent = new Intent();
        String lastAlbumId = this.bMd.getLastAlbumId();
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
        this.bMf = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.WX().destory();
        if (this.bMl != null) {
            this.bMl.setBackgroundDrawable(null);
        }
        if (this.bMe != null) {
            this.bMe.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bMd.WT(), true);
            return AlbumActivity.this.bMd.WT().toJsonString();
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
            aN("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo()) {
            aN("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aN(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
