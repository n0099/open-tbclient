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
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0250a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c bDT;
    private com.baidu.live.tieba.write.album.a bDU;
    private e bDW;
    private boolean bEc;
    private com.baidu.live.tieba.c.a bEd;
    private FrameLayout bEe;
    private FrameLayout bEf;
    private int aZN = 0;
    private boolean bDV = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bDX = 0;
    private boolean bDY = false;
    private boolean bDZ = false;
    private int bEa = 0;
    private View bEb = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.g.sdk_ph_album_activity);
            this.bEb = findViewById(a.f.statebar_view);
            this.bEe = (FrameLayout) findViewById(a.f.imageList_layout);
            this.bEf = (FrameLayout) findViewById(a.f.imageBrowse_layout);
            this.bEc = UtilHelper.canUseStyleImmersiveSticky();
            Tz();
            initData(bundle);
            this.bDU = new com.baidu.live.tieba.write.album.a(this);
            this.bDU.TM();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bEe.addView(this.bDU.TU().getView(), layoutParams);
            this.bEf.addView(this.bDU.TT().getView(), layoutParams);
            fW(0);
        }
    }

    public void showTip(View view) {
        if (this.bEd == null && view != null) {
            this.bEd = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bEd.fu(a.e.sdk_ph_bg_tip_blue_up_left);
            this.bEd.d(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bEd.SR();
                }
            });
            this.bEd.ft(16);
            this.bEd.fv(5000);
        }
        if (this.bEd != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bEd.aM(getString(a.h.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Tz() {
        if (this.bEb != null) {
            if (this.bEc && this.bEb.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bEb.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bEb.setLayoutParams(layoutParams);
                cP(true);
                return;
            }
            cP(false);
        }
    }

    private void cP(boolean z) {
        if (this.bEb != null) {
            if (this.bEc && z && this.bEb.getVisibility() != 0) {
                this.bEb.setVisibility(0);
            } else if (!z && this.bEb.getVisibility() != 8) {
                this.bEb.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bDT.TZ().toJsonString());
        bundle.putBoolean("use_original_img", this.bDY);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bDX);
        bundle.putBoolean("from_write", this.bDZ);
    }

    private void initData(Bundle bundle) {
        this.bDT = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bDT.a(writeImagesInfo);
            this.bDY = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bDX = bundle.getInt("album_thread");
            this.bDZ = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bEa = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bDT.a(writeImagesInfo2);
                this.bDT.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bDY = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bDX = intent.getIntExtra("album_thread", 0);
                this.bDZ = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bEa = intent.getIntExtra("from_type", 0);
            }
        }
        TA();
    }

    private void TA() {
        if (this.requestFrom == 2) {
            this.bDW = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.bDU != null) {
            this.bDU.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bEb, a.c.sdk_cp_bg_line_d, i);
    }

    public void TB() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bDT != null) {
            if (ListUtils.getCount(this.bDT.TY()) == 1 && this.bEa == 0) {
                TC();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bDT.TZ().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bEa);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void TC() {
        WriteImagesInfo TZ;
        if (this.bDT != null && (TZ = this.bDT.TZ()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", TZ.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bDT == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo TZ = this.bDT.TZ();
            TZ.parseJson(stringExtra);
            TZ.updateQuality();
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
        if (view == this.bDU.TO()) {
            TB();
        } else if (view == this.bDU.TQ()) {
            TB();
        } else if (view == this.bDU.TN()) {
            if (this.bDT != null) {
                this.bDT.setLastAlbumId(null);
            }
            TI();
        } else if (view == this.bDU.TP()) {
            fW(0);
        } else if (view == this.bDU.TR()) {
            fU(2);
        } else if (view == this.bDU.TS()) {
            fU(1);
        }
    }

    private void fU(int i) {
        if (this.bDU != null && this.bDT != null) {
            this.bDT.setOriginalImg(!this.bDT.isOriginalImg());
            TD();
            fV(i);
        }
    }

    private void fV(int i) {
        if (this.bDT != null && this.bDT.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void TD() {
        if (this.bDT != null && this.bDU != null) {
            this.bDU.cQ(this.bDT.isOriginalImg());
        }
    }

    public View TE() {
        return this.bEb;
    }

    public int TF() {
        return this.bDX;
    }

    public c TG() {
        return this.bDT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fW(int i) {
        if (!this.bDV) {
            this.aZN = i;
            if (i == 0) {
                this.bEe.setVisibility(0);
                this.bEf.setVisibility(8);
                this.bDU.TU().onResume();
                return;
            }
            this.bEe.setVisibility(8);
            this.bEf.setVisibility(0);
            this.bDU.TT().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bDT.getMaxImagesAllowed();
        if (this.bDT.size() < maxImagesAllowed) {
            if (this.bDW == null || this.bDW.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bDT.a((VideoFileInfo) null);
                this.bDT.addChooseFile(imageFileInfo2);
                TD();
                return true;
            }
            return false;
        } else if (TH()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.h.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean TH() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bDT.getMaxImagesAllowed();
            if (this.bDT.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bDT.TY(), 0);
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
        this.bDT.a((VideoFileInfo) null);
        this.bDT.delChooseFile(imageFileInfo);
        TD();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aZN == 0) {
                if (this.bDT != null) {
                    this.bDT.setLastAlbumId(null);
                }
                TI();
                return true;
            } else if (this.aZN == 1) {
                fW(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bDU != null) {
            this.bDU.TU().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bDU != null) {
            this.bDU.TT().c(imageFileInfo, z);
        }
    }

    private void TI() {
        Intent intent = new Intent();
        String lastAlbumId = this.bDT.getLastAlbumId();
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
        this.bDV = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.Ud().destory();
        if (this.bEb != null) {
            this.bEb.setBackgroundDrawable(null);
        }
        if (this.bDU != null) {
            this.bDU.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bDT.TZ(), true);
            return AlbumActivity.this.bDT.TZ().toJsonString();
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
            aP("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo()) {
            aP("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aP(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
