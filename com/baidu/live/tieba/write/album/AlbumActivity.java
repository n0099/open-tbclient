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
import com.baidu.e.a.a;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0055a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private boolean apD;
    private com.baidu.live.tieba.c.a apE;
    private c apt;
    private com.baidu.live.tieba.write.album.a apu;
    private e apw;
    private int ZN = 0;
    private boolean apv = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int apx = 0;
    private int apy = 0;
    private boolean apz = false;
    private boolean apA = false;
    private int apB = 0;
    private View apC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(a.h.sdk_ph_album_activity);
        this.apC = findViewById(a.g.statebar_view);
        this.apD = UtilHelper.canUseStyleImmersiveSticky();
        vz();
        initData(bundle);
        this.apu = new com.baidu.live.tieba.write.album.a(this);
        this.apu.vJ();
        cd(0);
    }

    public void showTip(View view) {
        if (this.apE == null && view != null) {
            this.apE = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.apE.bB(a.f.sdk_ph_bg_tip_blue_up_left);
            this.apE.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.apE.uP();
                }
            });
            this.apE.bA(16);
            this.apE.bC(5000);
        }
        if (this.apE != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.apE.R(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void vz() {
        if (this.apC != null) {
            if (this.apD && this.apC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.apC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.apC.setLayoutParams(layoutParams);
                aP(true);
                return;
            }
            aP(false);
        }
    }

    private void aP(boolean z) {
        if (this.apC != null) {
            if (this.apD && z && this.apC.getVisibility() != 0) {
                this.apC.setVisibility(0);
            } else if (!z && this.apC.getVisibility() != 8) {
                this.apC.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.apt.vZ().toJsonString());
        bundle.putBoolean("use_original_img", this.apz);
        bundle.putInt("camera_request_from", this.apx);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.apy);
        bundle.putBoolean("from_write", this.apA);
    }

    private void initData(Bundle bundle) {
        this.apt = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.apt.a(writeImagesInfo);
            this.apz = bundle.getBoolean("use_original_img", false);
            this.apx = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.apy = bundle.getInt("album_thread");
            this.apA = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.apB = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.apt.a(writeImagesInfo2);
                this.apt.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.apz = intent.getBooleanExtra("use_original_img", false);
                this.apx = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.apy = intent.getIntExtra("album_thread", 0);
                this.apA = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.apB = intent.getIntExtra("from_type", 0);
            }
        }
        vA();
    }

    private void vA() {
        if (this.apx == 2) {
            this.apw = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.apu != null) {
            this.apu.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.apC, a.d.sdk_cp_bg_line_d, i);
    }

    public void vB() {
        if (this.apx == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.apx == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.apt != null) {
            if (ListUtils.getCount(this.apt.vY()) == 1 && this.apB == 0) {
                vC();
            } else {
                z(null);
            }
        }
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.apt.vZ().toJsonString());
        intent2.putExtra("camera_request_from", this.apx);
        intent2.putExtra("from_type", this.apB);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void vC() {
        WriteImagesInfo vZ;
        if (this.apt != null && (vZ = this.apt.vZ()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", vZ.toJsonString());
            z(intent);
        }
    }

    private void A(Intent intent) {
        if (intent == null || this.apt == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo vZ = this.apt.vZ();
            vZ.parseJson(stringExtra);
            vZ.updateQuality();
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
        if (view == this.apu.vL()) {
            vB();
        } else if (view == this.apu.vN()) {
            vB();
        } else if (view == this.apu.vK()) {
            if (this.apt != null) {
                this.apt.setLastAlbumId(null);
            }
            vI();
        } else if (view == this.apu.vM()) {
            cd(0);
        } else if (view == this.apu.vO()) {
            cb(2);
        } else if (view == this.apu.vP()) {
            cb(1);
        }
    }

    private void cb(int i) {
        if (this.apu != null && this.apt != null) {
            this.apt.setOriginalImg(!this.apt.isOriginalImg());
            vD();
            cc(i);
        }
    }

    private void cc(int i) {
        if (this.apt != null && this.apt.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void vD() {
        if (this.apt != null && this.apu != null) {
            this.apu.aQ(this.apt.isOriginalImg());
        }
    }

    public View vE() {
        return this.apC;
    }

    public int vF() {
        return this.apy;
    }

    public c vG() {
        return this.apt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cd(int i) {
        if (!this.apv) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.apu.cf(this.ZN));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.ZN = i;
            if (getSupportFragmentManager().findFragmentByTag(this.apu.cf(i)) != null) {
                beginTransaction.show(this.apu.ce(i));
            } else {
                beginTransaction.add(a.g.fragment, this.apu.ce(i), this.apu.cf(i));
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
        int maxImagesAllowed = this.apt.getMaxImagesAllowed();
        if (this.apt.size() < maxImagesAllowed) {
            if (this.apw == null || this.apw.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.apt.a((VideoFileInfo) null);
                this.apt.addChooseFile(imageFileInfo2);
                vD();
                return true;
            }
            return false;
        } else if (vH()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean vH() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.apt.getMaxImagesAllowed();
            if (this.apt.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.apt.vY(), 0);
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
        this.apt.a((VideoFileInfo) null);
        this.apt.delChooseFile(imageFileInfo);
        vD();
        return true;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.ZN == 0) {
                if (this.apt != null) {
                    this.apt.setLastAlbumId(null);
                }
                vI();
                return true;
            } else if (this.ZN == 1) {
                cd(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ce;
        if (this.apu != null && (ce = this.apu.ce(0)) != null && (ce instanceof ImageListFragment)) {
            ((ImageListFragment) ce).c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ce;
        if (this.apu != null && (ce = this.apu.ce(1)) != null && (ce instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) ce).c(imageFileInfo, z);
        }
    }

    private void vI() {
        Intent intent = new Intent();
        String lastAlbumId = this.apt.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.apx);
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
        this.apv = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.we().destory();
        if (this.apC != null) {
            this.apC.setBackgroundDrawable(null);
        }
        if (this.apu != null) {
            this.apu.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.apt.vZ(), true);
            return AlbumActivity.this.apt.vZ().toJsonString();
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
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", "anim"), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", "anim"));
        } else {
            S("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
            S("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void S(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, "anim"), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, "anim"));
    }
}
