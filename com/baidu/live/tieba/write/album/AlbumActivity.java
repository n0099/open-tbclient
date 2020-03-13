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
import com.baidu.live.adp.base.BdBaseApplication;
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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0078a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c aBU;
    private com.baidu.live.tieba.write.album.a aBV;
    private e aBX;
    private boolean aCd;
    private com.baidu.live.tieba.c.a aCe;
    private int akk = 0;
    private boolean aBW = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int aBY = 0;
    private boolean aBZ = false;
    private boolean aCa = false;
    private int aCb = 0;
    private View aCc = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        setSwipeBackEnabled(false);
        setContentView(a.h.sdk_ph_album_activity);
        this.aCc = findViewById(a.g.statebar_view);
        this.aCd = UtilHelper.canUseStyleImmersiveSticky();
        Ah();
        initData(bundle);
        this.aBV = new com.baidu.live.tieba.write.album.a(this);
        this.aBV.Ar();
        cM(0);
    }

    public void showTip(View view) {
        if (this.aCe == null && view != null) {
            this.aCe = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.aCe.ck(a.f.sdk_ph_bg_tip_blue_up_left);
            this.aCe.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.aCe.zz();
                }
            });
            this.aCe.cj(16);
            this.aCe.cl(5000);
        }
        if (this.aCe != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.aCe.aj(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Ah() {
        if (this.aCc != null) {
            if (this.aCd && this.aCc.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCc.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCc.setLayoutParams(layoutParams);
                bs(true);
                return;
            }
            bs(false);
        }
    }

    private void bs(boolean z) {
        if (this.aCc != null) {
            if (this.aCd && z && this.aCc.getVisibility() != 0) {
                this.aCc.setVisibility(0);
            } else if (!z && this.aCc.getVisibility() != 8) {
                this.aCc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.aBU.AH().toJsonString());
        bundle.putBoolean("use_original_img", this.aBZ);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.aBY);
        bundle.putBoolean("from_write", this.aCa);
    }

    private void initData(Bundle bundle) {
        this.aBU = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.aBU.a(writeImagesInfo);
            this.aBZ = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.aBY = bundle.getInt("album_thread");
            this.aCa = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.aCb = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.aBU.a(writeImagesInfo2);
                this.aBU.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.aBZ = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.aBY = intent.getIntExtra("album_thread", 0);
                this.aCa = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.aCb = intent.getIntExtra("from_type", 0);
            }
        }
        Ai();
    }

    private void Ai() {
        if (this.requestFrom == 2) {
            this.aBX = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.aBV != null) {
            this.aBV.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.aCc, a.d.sdk_cp_bg_line_d, i);
    }

    public void Aj() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.aBU != null) {
            if (ListUtils.getCount(this.aBU.AG()) == 1 && this.aCb == 0) {
                Ak();
            } else {
                z(null);
            }
        }
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.aBU.AH().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.aCb);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Ak() {
        WriteImagesInfo AH;
        if (this.aBU != null && (AH = this.aBU.AH()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", AH.toJsonString());
            z(intent);
        }
    }

    private void A(Intent intent) {
        if (intent == null || this.aBU == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo AH = this.aBU.AH();
            AH.parseJson(stringExtra);
            AH.updateQuality();
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
        if (view == this.aBV.At()) {
            Aj();
        } else if (view == this.aBV.Av()) {
            Aj();
        } else if (view == this.aBV.As()) {
            if (this.aBU != null) {
                this.aBU.setLastAlbumId(null);
            }
            Aq();
        } else if (view == this.aBV.Au()) {
            cM(0);
        } else if (view == this.aBV.Aw()) {
            cK(2);
        } else if (view == this.aBV.Ax()) {
            cK(1);
        }
    }

    private void cK(int i) {
        if (this.aBV != null && this.aBU != null) {
            this.aBU.setOriginalImg(!this.aBU.isOriginalImg());
            Al();
            cL(i);
        }
    }

    private void cL(int i) {
        if (this.aBU != null && this.aBU.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Al() {
        if (this.aBU != null && this.aBV != null) {
            this.aBV.bt(this.aBU.isOriginalImg());
        }
    }

    public View Am() {
        return this.aCc;
    }

    public int An() {
        return this.aBY;
    }

    public c Ao() {
        return this.aBU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(int i) {
        if (!this.aBW) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.aBV.cO(this.akk));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.akk = i;
            if (getSupportFragmentManager().findFragmentByTag(this.aBV.cO(i)) != null) {
                beginTransaction.show(this.aBV.cN(i));
            } else {
                beginTransaction.add(a.g.fragment, this.aBV.cN(i), this.aBV.cO(i));
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
        int maxImagesAllowed = this.aBU.getMaxImagesAllowed();
        if (this.aBU.size() < maxImagesAllowed) {
            if (this.aBX == null || this.aBX.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.aBU.a((VideoFileInfo) null);
                this.aBU.addChooseFile(imageFileInfo2);
                Al();
                return true;
            }
            return false;
        } else if (Ap()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Ap() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.aBU.getMaxImagesAllowed();
            if (this.aBU.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.aBU.AG(), 0);
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
        this.aBU.a((VideoFileInfo) null);
        this.aBU.delChooseFile(imageFileInfo);
        Al();
        return true;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.akk == 0) {
                if (this.aBU != null) {
                    this.aBU.setLastAlbumId(null);
                }
                Aq();
                return true;
            } else if (this.akk == 1) {
                cM(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cN;
        if (this.aBV != null && (cN = this.aBV.cN(0)) != null && (cN instanceof ImageListFragment)) {
            ((ImageListFragment) cN).c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cN;
        if (this.aBV != null && (cN = this.aBV.cN(1)) != null && (cN instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) cN).c(imageFileInfo, z);
        }
    }

    private void Aq() {
        Intent intent = new Intent();
        String lastAlbumId = this.aBU.getLastAlbumId();
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
        this.aBW = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.AM().destory();
        if (this.aCc != null) {
            this.aCc.setBackgroundDrawable(null);
        }
        if (this.aBV != null) {
            this.aBV.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.aBU.AH(), true);
            return AlbumActivity.this.aBU.AH().toJsonString();
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
            ak("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
            ak("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void ak(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
