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
import com.baidu.k.a.a;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
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
import com.baidu.megapp.ma.Util;
/* loaded from: classes2.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0072a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c awT;
    private com.baidu.live.tieba.write.album.a awU;
    private e awW;
    private boolean axc;
    private com.baidu.live.tieba.c.a axd;
    private int aht = 0;
    private boolean awV = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int awX = 0;
    private boolean awY = false;
    private boolean awZ = false;
    private int axa = 0;
    private View axb = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(a.h.sdk_ph_album_activity);
        this.axb = findViewById(a.g.statebar_view);
        this.axc = UtilHelper.canUseStyleImmersiveSticky();
        xy();
        initData(bundle);
        this.awU = new com.baidu.live.tieba.write.album.a(this);
        this.awU.xI();
        cv(0);
    }

    public void showTip(View view) {
        if (this.axd == null && view != null) {
            this.axd = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.axd.bT(a.f.sdk_ph_bg_tip_blue_up_left);
            this.axd.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.axd.wP();
                }
            });
            this.axd.bS(16);
            this.axd.bU(5000);
        }
        if (this.axd != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.axd.Z(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void xy() {
        if (this.axb != null) {
            if (this.axc && this.axb.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.axb.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.axb.setLayoutParams(layoutParams);
                bg(true);
                return;
            }
            bg(false);
        }
    }

    private void bg(boolean z) {
        if (this.axb != null) {
            if (this.axc && z && this.axb.getVisibility() != 0) {
                this.axb.setVisibility(0);
            } else if (!z && this.axb.getVisibility() != 8) {
                this.axb.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.awT.xY().toJsonString());
        bundle.putBoolean("use_original_img", this.awY);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.awX);
        bundle.putBoolean("from_write", this.awZ);
    }

    private void initData(Bundle bundle) {
        this.awT = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.awT.a(writeImagesInfo);
            this.awY = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.awX = bundle.getInt("album_thread");
            this.awZ = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.axa = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.awT.a(writeImagesInfo2);
                this.awT.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.awY = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.awX = intent.getIntExtra("album_thread", 0);
                this.awZ = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.axa = intent.getIntExtra("from_type", 0);
            }
        }
        xz();
    }

    private void xz() {
        if (this.requestFrom == 2) {
            this.awW = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
                @Override // com.baidu.live.tieba.write.album.e
                public boolean c(ImageFileInfo imageFileInfo) {
                    if (imageFileInfo != null) {
                        String filePath = imageFileInfo.getFilePath();
                        if (!StringUtils.isNULL(filePath)) {
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
        if (this.awU != null) {
            this.awU.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.axb, a.d.sdk_cp_bg_line_d, i);
    }

    public void xA() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.awT != null) {
            if (ListUtils.getCount(this.awT.xX()) == 1 && this.axa == 0) {
                xB();
            } else {
                z(null);
            }
        }
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.awT.xY().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.axa);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void xB() {
        WriteImagesInfo xY;
        if (this.awT != null && (xY = this.awT.xY()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", xY.toJsonString());
            z(intent);
        }
    }

    private void A(Intent intent) {
        if (intent == null || this.awT == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo xY = this.awT.xY();
            xY.parseJson(stringExtra);
            xY.updateQuality();
            z(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            A(intent);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.awU.xK()) {
            xA();
        } else if (view == this.awU.xM()) {
            xA();
        } else if (view == this.awU.xJ()) {
            if (this.awT != null) {
                this.awT.setLastAlbumId(null);
            }
            xH();
        } else if (view == this.awU.xL()) {
            cv(0);
        } else if (view == this.awU.xN()) {
            ct(2);
        } else if (view == this.awU.xO()) {
            ct(1);
        }
    }

    private void ct(int i) {
        if (this.awU != null && this.awT != null) {
            this.awT.setOriginalImg(!this.awT.isOriginalImg());
            xC();
            cu(i);
        }
    }

    private void cu(int i) {
        if (this.awT != null && this.awT.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void xC() {
        if (this.awT != null && this.awU != null) {
            this.awU.bh(this.awT.isOriginalImg());
        }
    }

    public View xD() {
        return this.axb;
    }

    public int xE() {
        return this.awX;
    }

    public c xF() {
        return this.awT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cv(int i) {
        if (!this.awV) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.awU.cx(this.aht));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aht = i;
            if (getSupportFragmentManager().findFragmentByTag(this.awU.cx(i)) != null) {
                beginTransaction.show(this.awU.cw(i));
            } else {
                beginTransaction.add(a.g.fragment, this.awU.cw(i), this.awU.cx(i));
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
        int maxImagesAllowed = this.awT.getMaxImagesAllowed();
        if (this.awT.size() < maxImagesAllowed) {
            if (this.awW == null || this.awW.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.awT.a((VideoFileInfo) null);
                this.awT.addChooseFile(imageFileInfo2);
                xC();
                return true;
            }
            return false;
        } else if (xG()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean xG() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.awT.getMaxImagesAllowed();
            if (this.awT.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.awT.xX(), 0);
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
        this.awT.a((VideoFileInfo) null);
        this.awT.delChooseFile(imageFileInfo);
        xC();
        return true;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aht == 0) {
                if (this.awT != null) {
                    this.awT.setLastAlbumId(null);
                }
                xH();
                return true;
            } else if (this.aht == 1) {
                cv(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cw;
        if (this.awU != null && (cw = this.awU.cw(0)) != null && (cw instanceof ImageListFragment)) {
            ((ImageListFragment) cw).c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cw;
        if (this.awU != null && (cw = this.awU.cw(1)) != null && (cw instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) cw).c(imageFileInfo, z);
        }
    }

    private void xH() {
        Intent intent = new Intent();
        String lastAlbumId = this.awT.getLastAlbumId();
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
        this.awV = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.yd().destory();
        if (this.axb != null) {
            this.axb.setBackgroundDrawable(null);
        }
        if (this.awU != null) {
            this.awU.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.awT.xY(), true);
            return AlbumActivity.this.awT.xY().toJsonString();
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
            aa("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
            aa("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aa(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
