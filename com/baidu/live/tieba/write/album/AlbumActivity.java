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
/* loaded from: classes10.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0154a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c bMB;
    private com.baidu.live.tieba.write.album.a bMC;
    private e bME;
    private boolean bMK;
    private com.baidu.live.tieba.c.a bML;
    private FrameLayout bMM;
    private FrameLayout bMN;
    private int bcY = 0;
    private boolean bMD = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bMF = 0;
    private boolean bMG = false;
    private boolean bMH = false;
    private int bMI = 0;
    private View bMJ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.g.sdk_ph_album_activity);
            this.bMJ = findViewById(a.f.statebar_view);
            this.bMM = (FrameLayout) findViewById(a.f.imageList_layout);
            this.bMN = (FrameLayout) findViewById(a.f.imageBrowse_layout);
            this.bMK = UtilHelper.canUseStyleImmersiveSticky();
            Uk();
            initData(bundle);
            this.bMC = new com.baidu.live.tieba.write.album.a(this);
            this.bMC.Ux();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bMM.addView(this.bMC.UF().getView(), layoutParams);
            this.bMN.addView(this.bMC.UE().getView(), layoutParams);
            eQ(0);
        }
    }

    public void showTip(View view) {
        if (this.bML == null && view != null) {
            this.bML = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bML.eo(a.e.sdk_ph_bg_tip_blue_up_left);
            this.bML.e(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bML.TC();
                }
            });
            this.bML.en(16);
            this.bML.ep(5000);
        }
        if (this.bML != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bML.aJ(getString(a.h.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Uk() {
        if (this.bMJ != null) {
            if (this.bMK && this.bMJ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMJ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMJ.setLayoutParams(layoutParams);
                dm(true);
                return;
            }
            dm(false);
        }
    }

    private void dm(boolean z) {
        if (this.bMJ != null) {
            if (this.bMK && z && this.bMJ.getVisibility() != 0) {
                this.bMJ.setVisibility(0);
            } else if (!z && this.bMJ.getVisibility() != 8) {
                this.bMJ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bMB.UK().toJsonString());
        bundle.putBoolean("use_original_img", this.bMG);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bMF);
        bundle.putBoolean("from_write", this.bMH);
    }

    private void initData(Bundle bundle) {
        this.bMB = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bMB.a(writeImagesInfo);
            this.bMG = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bMF = bundle.getInt("album_thread");
            this.bMH = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bMI = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bMB.a(writeImagesInfo2);
                this.bMB.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bMG = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bMF = intent.getIntExtra("album_thread", 0);
                this.bMH = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bMI = intent.getIntExtra("from_type", 0);
            }
        }
        Ul();
    }

    private void Ul() {
        if (this.requestFrom == 2) {
            this.bME = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.bMC != null) {
            this.bMC.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bMJ, a.c.sdk_cp_bg_line_d, i);
    }

    public void Um() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bMB != null) {
            if (ListUtils.getCount(this.bMB.UJ()) == 1 && this.bMI == 0) {
                Un();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bMB.UK().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bMI);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Un() {
        WriteImagesInfo UK;
        if (this.bMB != null && (UK = this.bMB.UK()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", UK.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bMB == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo UK = this.bMB.UK();
            UK.parseJson(stringExtra);
            UK.updateQuality();
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
        if (view == this.bMC.Uz()) {
            Um();
        } else if (view == this.bMC.UB()) {
            Um();
        } else if (view == this.bMC.Uy()) {
            if (this.bMB != null) {
                this.bMB.setLastAlbumId(null);
            }
            Ut();
        } else if (view == this.bMC.UA()) {
            eQ(0);
        } else if (view == this.bMC.UC()) {
            eO(2);
        } else if (view == this.bMC.UD()) {
            eO(1);
        }
    }

    private void eO(int i) {
        if (this.bMC != null && this.bMB != null) {
            this.bMB.setOriginalImg(!this.bMB.isOriginalImg());
            Uo();
            eP(i);
        }
    }

    private void eP(int i) {
        if (this.bMB != null && this.bMB.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Uo() {
        if (this.bMB != null && this.bMC != null) {
            this.bMC.dn(this.bMB.isOriginalImg());
        }
    }

    public View Up() {
        return this.bMJ;
    }

    public int Uq() {
        return this.bMF;
    }

    public c Ur() {
        return this.bMB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eQ(int i) {
        if (!this.bMD) {
            this.bcY = i;
            if (i == 0) {
                this.bMM.setVisibility(0);
                this.bMN.setVisibility(8);
                this.bMC.UF().onResume();
                return;
            }
            this.bMM.setVisibility(8);
            this.bMN.setVisibility(0);
            this.bMC.UE().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bMB.getMaxImagesAllowed();
        if (this.bMB.size() < maxImagesAllowed) {
            if (this.bME == null || this.bME.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bMB.a((VideoFileInfo) null);
                this.bMB.addChooseFile(imageFileInfo2);
                Uo();
                return true;
            }
            return false;
        } else if (Us()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.h.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Us() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bMB.getMaxImagesAllowed();
            if (this.bMB.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bMB.UJ(), 0);
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
        this.bMB.a((VideoFileInfo) null);
        this.bMB.delChooseFile(imageFileInfo);
        Uo();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.bcY == 0) {
                if (this.bMB != null) {
                    this.bMB.setLastAlbumId(null);
                }
                Ut();
                return true;
            } else if (this.bcY == 1) {
                eQ(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bMC != null) {
            this.bMC.UF().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bMC != null) {
            this.bMC.UE().c(imageFileInfo, z);
        }
    }

    private void Ut() {
        Intent intent = new Intent();
        String lastAlbumId = this.bMB.getLastAlbumId();
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
        this.bMD = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.UO().destory();
        if (this.bMJ != null) {
            this.bMJ.setBackgroundDrawable(null);
        }
        if (this.bMC != null) {
            this.bMC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bMB.UK(), true);
            return AlbumActivity.this.bMB.UK().toJsonString();
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
