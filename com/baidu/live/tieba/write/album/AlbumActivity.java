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
    private c apa;
    private com.baidu.live.tieba.write.album.a apb;
    private e apd;
    private boolean apk;
    private com.baidu.live.tieba.c.a apl;
    private int Zv = 0;
    private boolean apc = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int ape = 0;
    private int apf = 0;
    private boolean apg = false;
    private boolean aph = false;
    private int api = 0;
    private View apj = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(a.h.sdk_ph_album_activity);
        this.apj = findViewById(a.g.statebar_view);
        this.apk = UtilHelper.canUseStyleImmersiveSticky();
        vA();
        initData(bundle);
        this.apb = new com.baidu.live.tieba.write.album.a(this);
        this.apb.vK();
        cd(0);
    }

    public void showTip(View view) {
        if (this.apl == null && view != null) {
            this.apl = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.apl.bB(a.f.sdk_ph_bg_tip_blue_up_left);
            this.apl.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.apl.uQ();
                }
            });
            this.apl.bA(16);
            this.apl.bC(5000);
        }
        if (this.apl != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.apl.R(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void vA() {
        if (this.apj != null) {
            if (this.apk && this.apj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.apj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.apj.setLayoutParams(layoutParams);
                aP(true);
                return;
            }
            aP(false);
        }
    }

    private void aP(boolean z) {
        if (this.apj != null) {
            if (this.apk && z && this.apj.getVisibility() != 0) {
                this.apj.setVisibility(0);
            } else if (!z && this.apj.getVisibility() != 8) {
                this.apj.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.apa.wa().toJsonString());
        bundle.putBoolean("use_original_img", this.apg);
        bundle.putInt("camera_request_from", this.ape);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.apf);
        bundle.putBoolean("from_write", this.aph);
    }

    private void initData(Bundle bundle) {
        this.apa = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.apa.a(writeImagesInfo);
            this.apg = bundle.getBoolean("use_original_img", false);
            this.ape = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.apf = bundle.getInt("album_thread");
            this.aph = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.api = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.apa.a(writeImagesInfo2);
                this.apa.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.apg = intent.getBooleanExtra("use_original_img", false);
                this.ape = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.apf = intent.getIntExtra("album_thread", 0);
                this.aph = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.api = intent.getIntExtra("from_type", 0);
            }
        }
        vB();
    }

    private void vB() {
        if (this.ape == 2) {
            this.apd = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.apb != null) {
            this.apb.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.apj, a.d.sdk_cp_bg_line_d, i);
    }

    public void vC() {
        if (this.ape == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.ape == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.apa != null) {
            if (ListUtils.getCount(this.apa.vZ()) == 1 && this.api == 0) {
                vD();
            } else {
                z(null);
            }
        }
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.apa.wa().toJsonString());
        intent2.putExtra("camera_request_from", this.ape);
        intent2.putExtra("from_type", this.api);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void vD() {
        WriteImagesInfo wa;
        if (this.apa != null && (wa = this.apa.wa()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", wa.toJsonString());
            z(intent);
        }
    }

    private void A(Intent intent) {
        if (intent == null || this.apa == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo wa = this.apa.wa();
            wa.parseJson(stringExtra);
            wa.updateQuality();
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
        if (view == this.apb.vM()) {
            vC();
        } else if (view == this.apb.vO()) {
            vC();
        } else if (view == this.apb.vL()) {
            if (this.apa != null) {
                this.apa.setLastAlbumId(null);
            }
            vJ();
        } else if (view == this.apb.vN()) {
            cd(0);
        } else if (view == this.apb.vP()) {
            cb(2);
        } else if (view == this.apb.vQ()) {
            cb(1);
        }
    }

    private void cb(int i) {
        if (this.apb != null && this.apa != null) {
            this.apa.setOriginalImg(!this.apa.isOriginalImg());
            vE();
            cc(i);
        }
    }

    private void cc(int i) {
        if (this.apa != null && this.apa.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void vE() {
        if (this.apa != null && this.apb != null) {
            this.apb.aQ(this.apa.isOriginalImg());
        }
    }

    public View vF() {
        return this.apj;
    }

    public int vG() {
        return this.apf;
    }

    public c vH() {
        return this.apa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cd(int i) {
        if (!this.apc) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.apb.cf(this.Zv));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.Zv = i;
            if (getSupportFragmentManager().findFragmentByTag(this.apb.cf(i)) != null) {
                beginTransaction.show(this.apb.ce(i));
            } else {
                beginTransaction.add(a.g.fragment, this.apb.ce(i), this.apb.cf(i));
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
        int maxImagesAllowed = this.apa.getMaxImagesAllowed();
        if (this.apa.size() < maxImagesAllowed) {
            if (this.apd == null || this.apd.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.apa.a((VideoFileInfo) null);
                this.apa.addChooseFile(imageFileInfo2);
                vE();
                return true;
            }
            return false;
        } else if (vI()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean vI() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.apa.getMaxImagesAllowed();
            if (this.apa.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.apa.vZ(), 0);
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
        this.apa.a((VideoFileInfo) null);
        this.apa.delChooseFile(imageFileInfo);
        vE();
        return true;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.Zv == 0) {
                if (this.apa != null) {
                    this.apa.setLastAlbumId(null);
                }
                vJ();
                return true;
            } else if (this.Zv == 1) {
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
        if (this.apb != null && (ce = this.apb.ce(0)) != null && (ce instanceof ImageListFragment)) {
            ((ImageListFragment) ce).c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ce;
        if (this.apb != null && (ce = this.apb.ce(1)) != null && (ce instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) ce).c(imageFileInfo, z);
        }
    }

    private void vJ() {
        Intent intent = new Intent();
        String lastAlbumId = this.apa.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.ape);
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
        this.apc = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.wf().destory();
        if (this.apj != null) {
            this.apj.setBackgroundDrawable(null);
        }
        if (this.apb != null) {
            this.apb.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.apa.wa(), true);
            return AlbumActivity.this.apa.wa().toJsonString();
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
