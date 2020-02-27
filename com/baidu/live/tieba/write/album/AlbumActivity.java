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
    private c aBS;
    private com.baidu.live.tieba.write.album.a aBT;
    private e aBV;
    private boolean aCb;
    private com.baidu.live.tieba.c.a aCc;
    private int akj = 0;
    private boolean aBU = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int aBW = 0;
    private boolean aBX = false;
    private boolean aBY = false;
    private int aBZ = 0;
    private View aCa = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(a.h.sdk_ph_album_activity);
        this.aCa = findViewById(a.g.statebar_view);
        this.aCb = UtilHelper.canUseStyleImmersiveSticky();
        Af();
        initData(bundle);
        this.aBT = new com.baidu.live.tieba.write.album.a(this);
        this.aBT.Ap();
        cM(0);
    }

    public void showTip(View view) {
        if (this.aCc == null && view != null) {
            this.aCc = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.aCc.ck(a.f.sdk_ph_bg_tip_blue_up_left);
            this.aCc.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.aCc.zx();
                }
            });
            this.aCc.cj(16);
            this.aCc.cl(5000);
        }
        if (this.aCc != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.aCc.aj(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Af() {
        if (this.aCa != null) {
            if (this.aCb && this.aCa.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCa.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCa.setLayoutParams(layoutParams);
                bs(true);
                return;
            }
            bs(false);
        }
    }

    private void bs(boolean z) {
        if (this.aCa != null) {
            if (this.aCb && z && this.aCa.getVisibility() != 0) {
                this.aCa.setVisibility(0);
            } else if (!z && this.aCa.getVisibility() != 8) {
                this.aCa.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.aBS.AF().toJsonString());
        bundle.putBoolean("use_original_img", this.aBX);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.aBW);
        bundle.putBoolean("from_write", this.aBY);
    }

    private void initData(Bundle bundle) {
        this.aBS = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.aBS.a(writeImagesInfo);
            this.aBX = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.aBW = bundle.getInt("album_thread");
            this.aBY = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.aBZ = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.aBS.a(writeImagesInfo2);
                this.aBS.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.aBX = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.aBW = intent.getIntExtra("album_thread", 0);
                this.aBY = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.aBZ = intent.getIntExtra("from_type", 0);
            }
        }
        Ag();
    }

    private void Ag() {
        if (this.requestFrom == 2) {
            this.aBV = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.aBT != null) {
            this.aBT.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.aCa, a.d.sdk_cp_bg_line_d, i);
    }

    public void Ah() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.aBS != null) {
            if (ListUtils.getCount(this.aBS.AE()) == 1 && this.aBZ == 0) {
                Ai();
            } else {
                z(null);
            }
        }
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.aBS.AF().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.aBZ);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Ai() {
        WriteImagesInfo AF;
        if (this.aBS != null && (AF = this.aBS.AF()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", AF.toJsonString());
            z(intent);
        }
    }

    private void A(Intent intent) {
        if (intent == null || this.aBS == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo AF = this.aBS.AF();
            AF.parseJson(stringExtra);
            AF.updateQuality();
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
        if (view == this.aBT.Ar()) {
            Ah();
        } else if (view == this.aBT.At()) {
            Ah();
        } else if (view == this.aBT.Aq()) {
            if (this.aBS != null) {
                this.aBS.setLastAlbumId(null);
            }
            Ao();
        } else if (view == this.aBT.As()) {
            cM(0);
        } else if (view == this.aBT.Au()) {
            cK(2);
        } else if (view == this.aBT.Av()) {
            cK(1);
        }
    }

    private void cK(int i) {
        if (this.aBT != null && this.aBS != null) {
            this.aBS.setOriginalImg(!this.aBS.isOriginalImg());
            Aj();
            cL(i);
        }
    }

    private void cL(int i) {
        if (this.aBS != null && this.aBS.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Aj() {
        if (this.aBS != null && this.aBT != null) {
            this.aBT.bt(this.aBS.isOriginalImg());
        }
    }

    public View Ak() {
        return this.aCa;
    }

    public int Al() {
        return this.aBW;
    }

    public c Am() {
        return this.aBS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(int i) {
        if (!this.aBU) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.aBT.cO(this.akj));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.akj = i;
            if (getSupportFragmentManager().findFragmentByTag(this.aBT.cO(i)) != null) {
                beginTransaction.show(this.aBT.cN(i));
            } else {
                beginTransaction.add(a.g.fragment, this.aBT.cN(i), this.aBT.cO(i));
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
        int maxImagesAllowed = this.aBS.getMaxImagesAllowed();
        if (this.aBS.size() < maxImagesAllowed) {
            if (this.aBV == null || this.aBV.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.aBS.a((VideoFileInfo) null);
                this.aBS.addChooseFile(imageFileInfo2);
                Aj();
                return true;
            }
            return false;
        } else if (An()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean An() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.aBS.getMaxImagesAllowed();
            if (this.aBS.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.aBS.AE(), 0);
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
        this.aBS.a((VideoFileInfo) null);
        this.aBS.delChooseFile(imageFileInfo);
        Aj();
        return true;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.akj == 0) {
                if (this.aBS != null) {
                    this.aBS.setLastAlbumId(null);
                }
                Ao();
                return true;
            } else if (this.akj == 1) {
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
        if (this.aBT != null && (cN = this.aBT.cN(0)) != null && (cN instanceof ImageListFragment)) {
            ((ImageListFragment) cN).c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cN;
        if (this.aBT != null && (cN = this.aBT.cN(1)) != null && (cN instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) cN).c(imageFileInfo, z);
        }
    }

    private void Ao() {
        Intent intent = new Intent();
        String lastAlbumId = this.aBS.getLastAlbumId();
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
        this.aBU = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.AK().destory();
        if (this.aCa != null) {
            this.aCa.setBackgroundDrawable(null);
        }
        if (this.aBT != null) {
            this.aBT.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.aBS.AF(), true);
            return AlbumActivity.this.aBS.AF().toJsonString();
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
