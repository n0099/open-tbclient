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
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0148a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private boolean bHA;
    private com.baidu.live.tieba.c.a bHB;
    private FrameLayout bHC;
    private FrameLayout bHD;
    private c bHr;
    private com.baidu.live.tieba.write.album.a bHs;
    private e bHu;
    private int aYr = 0;
    private boolean bHt = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bHv = 0;
    private boolean bHw = false;
    private boolean bHx = false;
    private int bHy = 0;
    private View bHz = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.g.sdk_ph_album_activity);
            this.bHz = findViewById(a.f.statebar_view);
            this.bHC = (FrameLayout) findViewById(a.f.imageList_layout);
            this.bHD = (FrameLayout) findViewById(a.f.imageBrowse_layout);
            this.bHA = UtilHelper.canUseStyleImmersiveSticky();
            SA();
            initData(bundle);
            this.bHs = new com.baidu.live.tieba.write.album.a(this);
            this.bHs.SN();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bHC.addView(this.bHs.SV().getView(), layoutParams);
            this.bHD.addView(this.bHs.SU().getView(), layoutParams);
            eL(0);
        }
    }

    public void showTip(View view) {
        if (this.bHB == null && view != null) {
            this.bHB = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bHB.ej(a.e.sdk_ph_bg_tip_blue_up_left);
            this.bHB.e(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bHB.RS();
                }
            });
            this.bHB.ei(16);
            this.bHB.ek(5000);
        }
        if (this.bHB != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bHB.aJ(getString(a.h.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void SA() {
        if (this.bHz != null) {
            if (this.bHA && this.bHz.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHz.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHz.setLayoutParams(layoutParams);
                de(true);
                return;
            }
            de(false);
        }
    }

    private void de(boolean z) {
        if (this.bHz != null) {
            if (this.bHA && z && this.bHz.getVisibility() != 0) {
                this.bHz.setVisibility(0);
            } else if (!z && this.bHz.getVisibility() != 8) {
                this.bHz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bHr.Ta().toJsonString());
        bundle.putBoolean("use_original_img", this.bHw);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bHv);
        bundle.putBoolean("from_write", this.bHx);
    }

    private void initData(Bundle bundle) {
        this.bHr = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bHr.a(writeImagesInfo);
            this.bHw = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bHv = bundle.getInt("album_thread");
            this.bHx = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bHy = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bHr.a(writeImagesInfo2);
                this.bHr.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bHw = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bHv = intent.getIntExtra("album_thread", 0);
                this.bHx = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bHy = intent.getIntExtra("from_type", 0);
            }
        }
        SB();
    }

    private void SB() {
        if (this.requestFrom == 2) {
            this.bHu = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.bHs != null) {
            this.bHs.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bHz, a.c.sdk_cp_bg_line_d, i);
    }

    public void SC() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bHr != null) {
            if (ListUtils.getCount(this.bHr.SZ()) == 1 && this.bHy == 0) {
                SD();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bHr.Ta().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bHy);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void SD() {
        WriteImagesInfo Ta;
        if (this.bHr != null && (Ta = this.bHr.Ta()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", Ta.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bHr == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo Ta = this.bHr.Ta();
            Ta.parseJson(stringExtra);
            Ta.updateQuality();
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
        if (view == this.bHs.SP()) {
            SC();
        } else if (view == this.bHs.SR()) {
            SC();
        } else if (view == this.bHs.SO()) {
            if (this.bHr != null) {
                this.bHr.setLastAlbumId(null);
            }
            SJ();
        } else if (view == this.bHs.SQ()) {
            eL(0);
        } else if (view == this.bHs.SS()) {
            eJ(2);
        } else if (view == this.bHs.ST()) {
            eJ(1);
        }
    }

    private void eJ(int i) {
        if (this.bHs != null && this.bHr != null) {
            this.bHr.setOriginalImg(!this.bHr.isOriginalImg());
            SE();
            eK(i);
        }
    }

    private void eK(int i) {
        if (this.bHr != null && this.bHr.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void SE() {
        if (this.bHr != null && this.bHs != null) {
            this.bHs.df(this.bHr.isOriginalImg());
        }
    }

    public View SF() {
        return this.bHz;
    }

    public int SG() {
        return this.bHv;
    }

    public c SH() {
        return this.bHr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eL(int i) {
        if (!this.bHt) {
            this.aYr = i;
            if (i == 0) {
                this.bHC.setVisibility(0);
                this.bHD.setVisibility(8);
                this.bHs.SV().onResume();
                return;
            }
            this.bHC.setVisibility(8);
            this.bHD.setVisibility(0);
            this.bHs.SU().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bHr.getMaxImagesAllowed();
        if (this.bHr.size() < maxImagesAllowed) {
            if (this.bHu == null || this.bHu.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bHr.a((VideoFileInfo) null);
                this.bHr.addChooseFile(imageFileInfo2);
                SE();
                return true;
            }
            return false;
        } else if (SI()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.h.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean SI() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bHr.getMaxImagesAllowed();
            if (this.bHr.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bHr.SZ(), 0);
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
        this.bHr.a((VideoFileInfo) null);
        this.bHr.delChooseFile(imageFileInfo);
        SE();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aYr == 0) {
                if (this.bHr != null) {
                    this.bHr.setLastAlbumId(null);
                }
                SJ();
                return true;
            } else if (this.aYr == 1) {
                eL(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bHs != null) {
            this.bHs.SV().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bHs != null) {
            this.bHs.SU().c(imageFileInfo, z);
        }
    }

    private void SJ() {
        Intent intent = new Intent();
        String lastAlbumId = this.bHr.getLastAlbumId();
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
        this.bHt = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.Te().destory();
        if (this.bHz != null) {
            this.bHz.setBackgroundDrawable(null);
        }
        if (this.bHs != null) {
            this.bHs.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bHr.Ta(), true);
            return AlbumActivity.this.bHr.Ta().toJsonString();
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
