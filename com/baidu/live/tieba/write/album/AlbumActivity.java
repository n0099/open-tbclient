package com.baidu.live.tieba.write.album;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.h.a.a;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
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
import com.baidu.live.u.a;
import com.baidu.megapp.ma.Util;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0121a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c aVU;
    private com.baidu.live.tieba.write.album.a aVV;
    private e aVX;
    private boolean aWd;
    private com.baidu.live.tieba.c.a aWe;
    private int aCY = 0;
    private boolean aVW = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int aVY = 0;
    private boolean aVZ = false;
    private boolean aWa = false;
    private int aWb = 0;
    private View aWc = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.h.sdk_ph_album_activity);
            this.aWc = findViewById(a.g.statebar_view);
            this.aWd = UtilHelper.canUseStyleImmersiveSticky();
            Fl();
            initData(bundle);
            this.aVV = new com.baidu.live.tieba.write.album.a(this);
            this.aVV.Fv();
            db(0);
        }
    }

    public void showTip(View view) {
        if (this.aWe == null && view != null) {
            this.aWe = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.aWe.cz(a.f.sdk_ph_bg_tip_blue_up_left);
            this.aWe.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.aWe.ED();
                }
            });
            this.aWe.cy(16);
            this.aWe.cA(5000);
        }
        if (this.aWe != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.aWe.al(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Fl() {
        if (this.aWc != null) {
            if (this.aWd && this.aWc.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aWc.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aWc.setLayoutParams(layoutParams);
                bX(true);
                return;
            }
            bX(false);
        }
    }

    private void bX(boolean z) {
        if (this.aWc != null) {
            if (this.aWd && z && this.aWc.getVisibility() != 0) {
                this.aWc.setVisibility(0);
            } else if (!z && this.aWc.getVisibility() != 8) {
                this.aWc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.aVU.FL().toJsonString());
        bundle.putBoolean("use_original_img", this.aVZ);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.aVY);
        bundle.putBoolean("from_write", this.aWa);
    }

    private void initData(Bundle bundle) {
        this.aVU = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.aVU.a(writeImagesInfo);
            this.aVZ = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.aVY = bundle.getInt("album_thread");
            this.aWa = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.aWb = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.aVU.a(writeImagesInfo2);
                this.aVU.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.aVZ = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.aVY = intent.getIntExtra("album_thread", 0);
                this.aWa = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.aWb = intent.getIntExtra("from_type", 0);
            }
        }
        Fm();
    }

    private void Fm() {
        if (this.requestFrom == 2) {
            this.aVX = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.aVV != null) {
            this.aVV.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.aWc, a.d.sdk_cp_bg_line_d, i);
    }

    public void Fn() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.aVU != null) {
            if (ListUtils.getCount(this.aVU.FK()) == 1 && this.aWb == 0) {
                Fo();
            } else {
                l(null);
            }
        }
    }

    private void l(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.aVU.FL().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.aWb);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Fo() {
        WriteImagesInfo FL;
        if (this.aVU != null && (FL = this.aVU.FL()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", FL.toJsonString());
            l(intent);
        }
    }

    private void m(Intent intent) {
        if (intent == null || this.aVU == null) {
            l(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo FL = this.aVU.FL();
            FL.parseJson(stringExtra);
            FL.updateQuality();
            l(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            m(intent);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVV.Fx()) {
            Fn();
        } else if (view == this.aVV.Fz()) {
            Fn();
        } else if (view == this.aVV.Fw()) {
            if (this.aVU != null) {
                this.aVU.setLastAlbumId(null);
            }
            Fu();
        } else if (view == this.aVV.Fy()) {
            db(0);
        } else if (view == this.aVV.FA()) {
            cZ(2);
        } else if (view == this.aVV.FB()) {
            cZ(1);
        }
    }

    private void cZ(int i) {
        if (this.aVV != null && this.aVU != null) {
            this.aVU.setOriginalImg(!this.aVU.isOriginalImg());
            Fp();
            da(i);
        }
    }

    private void da(int i) {
        if (this.aVU != null && this.aVU.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Fp() {
        if (this.aVU != null && this.aVV != null) {
            this.aVV.bY(this.aVU.isOriginalImg());
        }
    }

    public View Fq() {
        return this.aWc;
    }

    public int Fr() {
        return this.aVY;
    }

    public c Fs() {
        return this.aVU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void db(int i) {
        if (!this.aVW) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.aVV.dd(this.aCY));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aCY = i;
            if (getSupportFragmentManager().findFragmentByTag(this.aVV.dd(i)) != null) {
                beginTransaction.show(this.aVV.dc(i));
            } else {
                beginTransaction.add(a.g.fragment, this.aVV.dc(i), this.aVV.dd(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.aVU.getMaxImagesAllowed();
        if (this.aVU.size() < maxImagesAllowed) {
            if (this.aVX == null || this.aVX.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.aVU.a((VideoFileInfo) null);
                this.aVU.addChooseFile(imageFileInfo2);
                Fp();
                return true;
            }
            return false;
        } else if (Ft()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Ft() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.aVU.getMaxImagesAllowed();
            if (this.aVU.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.aVU.FK(), 0);
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
        this.aVU.a((VideoFileInfo) null);
        this.aVU.delChooseFile(imageFileInfo);
        Fp();
        return true;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aCY == 0) {
                if (this.aVU != null) {
                    this.aVU.setLastAlbumId(null);
                }
                Fu();
                return true;
            } else if (this.aCY == 1) {
                db(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dc;
        if (this.aVV != null && (dc = this.aVV.dc(0)) != null && (dc instanceof ImageListFragment)) {
            ((ImageListFragment) dc).c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dc;
        if (this.aVV != null && (dc = this.aVV.dc(1)) != null && (dc instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) dc).c(imageFileInfo, z);
        }
    }

    private void Fu() {
        Intent intent = new Intent();
        String lastAlbumId = this.aVU.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aVW = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.FQ().destory();
        if (this.aWc != null) {
            this.aWc.setBackgroundDrawable(null);
        }
        if (this.aVV != null) {
            this.aVV.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.aVU.FL(), true);
            return AlbumActivity.this.aVU.FL().toJsonString();
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

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
        } else {
            am("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
            am("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void am(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
