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
import com.baidu.h.a.a;
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
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0127a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private boolean biE;
    private com.baidu.live.tieba.c.a biF;
    private FrameLayout biG;
    private FrameLayout biH;
    private c biv;
    private com.baidu.live.tieba.write.album.a biw;
    private e biy;
    private int aLb = 0;
    private boolean bix = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int biz = 0;
    private boolean biA = false;
    private boolean biB = false;
    private int biC = 0;
    private View biD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.h.sdk_ph_album_activity);
            this.biD = findViewById(a.g.statebar_view);
            this.biG = (FrameLayout) findViewById(a.g.imageList_layout);
            this.biH = (FrameLayout) findViewById(a.g.imageBrowse_layout);
            this.biE = UtilHelper.canUseStyleImmersiveSticky();
            Ip();
            initData(bundle);
            this.biw = new com.baidu.live.tieba.write.album.a(this);
            this.biw.IC();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.biG.addView(this.biw.IK().getView(), layoutParams);
            this.biH.addView(this.biw.IJ().getView(), layoutParams);
            du(0);
        }
    }

    public void showTip(View view) {
        if (this.biF == null && view != null) {
            this.biF = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.biF.cS(a.f.sdk_ph_bg_tip_blue_up_left);
            this.biF.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.biF.HH();
                }
            });
            this.biF.cR(16);
            this.biF.cT(5000);
        }
        if (this.biF != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.biF.aC(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Ip() {
        if (this.biD != null) {
            if (this.biE && this.biD.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.biD.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.biD.setLayoutParams(layoutParams);
                cm(true);
                return;
            }
            cm(false);
        }
    }

    private void cm(boolean z) {
        if (this.biD != null) {
            if (this.biE && z && this.biD.getVisibility() != 0) {
                this.biD.setVisibility(0);
            } else if (!z && this.biD.getVisibility() != 8) {
                this.biD.setVisibility(8);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.biv.IP().toJsonString());
        bundle.putBoolean("use_original_img", this.biA);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.biz);
        bundle.putBoolean("from_write", this.biB);
    }

    private void initData(Bundle bundle) {
        this.biv = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.biv.a(writeImagesInfo);
            this.biA = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.biz = bundle.getInt("album_thread");
            this.biB = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.biC = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.biv.a(writeImagesInfo2);
                this.biv.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.biA = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.biz = intent.getIntExtra("album_thread", 0);
                this.biB = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.biC = intent.getIntExtra("from_type", 0);
            }
        }
        Iq();
    }

    private void Iq() {
        if (this.requestFrom == 2) {
            this.biy = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.biw != null) {
            this.biw.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.biD, a.d.sdk_cp_bg_line_d, i);
    }

    public void Ir() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.biv != null) {
            if (ListUtils.getCount(this.biv.IO()) == 1 && this.biC == 0) {
                Is();
            } else {
                l(null);
            }
        }
    }

    private void l(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.biv.IP().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.biC);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Is() {
        WriteImagesInfo IP;
        if (this.biv != null && (IP = this.biv.IP()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", IP.toJsonString());
            l(intent);
        }
    }

    private void m(Intent intent) {
        if (intent == null || this.biv == null) {
            l(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo IP = this.biv.IP();
            IP.parseJson(stringExtra);
            IP.updateQuality();
            l(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            m(intent);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.biw.IE()) {
            Ir();
        } else if (view == this.biw.IG()) {
            Ir();
        } else if (view == this.biw.ID()) {
            if (this.biv != null) {
                this.biv.setLastAlbumId(null);
            }
            Iy();
        } else if (view == this.biw.IF()) {
            du(0);
        } else if (view == this.biw.IH()) {
            ds(2);
        } else if (view == this.biw.II()) {
            ds(1);
        }
    }

    private void ds(int i) {
        if (this.biw != null && this.biv != null) {
            this.biv.setOriginalImg(!this.biv.isOriginalImg());
            It();
            dt(i);
        }
    }

    private void dt(int i) {
        if (this.biv != null && this.biv.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void It() {
        if (this.biv != null && this.biw != null) {
            this.biw.cn(this.biv.isOriginalImg());
        }
    }

    public View Iu() {
        return this.biD;
    }

    public int Iv() {
        return this.biz;
    }

    public c Iw() {
        return this.biv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void du(int i) {
        if (!this.bix) {
            this.aLb = i;
            if (i == 0) {
                this.biG.setVisibility(0);
                this.biH.setVisibility(8);
                this.biw.IK().onResume();
                return;
            }
            this.biG.setVisibility(8);
            this.biH.setVisibility(0);
            this.biw.IJ().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.biv.getMaxImagesAllowed();
        if (this.biv.size() < maxImagesAllowed) {
            if (this.biy == null || this.biy.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.biv.a((VideoFileInfo) null);
                this.biv.addChooseFile(imageFileInfo2);
                It();
                return true;
            }
            return false;
        } else if (Ix()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Ix() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.biv.getMaxImagesAllowed();
            if (this.biv.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.biv.IO(), 0);
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
        this.biv.a((VideoFileInfo) null);
        this.biv.delChooseFile(imageFileInfo);
        It();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aLb == 0) {
                if (this.biv != null) {
                    this.biv.setLastAlbumId(null);
                }
                Iy();
                return true;
            } else if (this.aLb == 1) {
                du(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.biw != null) {
            this.biw.IK().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.biw != null) {
            this.biw.IJ().c(imageFileInfo, z);
        }
    }

    private void Iy() {
        Intent intent = new Intent();
        String lastAlbumId = this.biv.getLastAlbumId();
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bix = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.IU().destory();
        if (this.biD != null) {
            this.biD.setBackgroundDrawable(null);
        }
        if (this.biw != null) {
            this.biw.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.biv.IP(), true);
            return AlbumActivity.this.biv.IP().toJsonString();
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
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
        } else {
            aD("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
            aD("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aD(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.biw.IK().onResume();
        this.biw.IJ().onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.biw.IK().onPause();
    }
}
