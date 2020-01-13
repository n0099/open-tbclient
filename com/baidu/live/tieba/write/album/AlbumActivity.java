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
import com.baidu.live.r.a;
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
    private c axC;
    private com.baidu.live.tieba.write.album.a axD;
    private e axF;
    private boolean axL;
    private com.baidu.live.tieba.c.a axM;
    private int aic = 0;
    private boolean axE = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int axG = 0;
    private boolean axH = false;
    private boolean axI = false;
    private int axJ = 0;
    private View axK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(a.h.sdk_ph_album_activity);
        this.axK = findViewById(a.g.statebar_view);
        this.axL = UtilHelper.canUseStyleImmersiveSticky();
        xO();
        initData(bundle);
        this.axD = new com.baidu.live.tieba.write.album.a(this);
        this.axD.xY();
        cw(0);
    }

    public void showTip(View view) {
        if (this.axM == null && view != null) {
            this.axM = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.axM.bU(a.f.sdk_ph_bg_tip_blue_up_left);
            this.axM.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.axM.xg();
                }
            });
            this.axM.bT(16);
            this.axM.bV(5000);
        }
        if (this.axM != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.axM.Y(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void xO() {
        if (this.axK != null) {
            if (this.axL && this.axK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.axK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.axK.setLayoutParams(layoutParams);
                bk(true);
                return;
            }
            bk(false);
        }
    }

    private void bk(boolean z) {
        if (this.axK != null) {
            if (this.axL && z && this.axK.getVisibility() != 0) {
                this.axK.setVisibility(0);
            } else if (!z && this.axK.getVisibility() != 8) {
                this.axK.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.axC.yo().toJsonString());
        bundle.putBoolean("use_original_img", this.axH);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.axG);
        bundle.putBoolean("from_write", this.axI);
    }

    private void initData(Bundle bundle) {
        this.axC = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.axC.a(writeImagesInfo);
            this.axH = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.axG = bundle.getInt("album_thread");
            this.axI = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.axJ = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.axC.a(writeImagesInfo2);
                this.axC.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.axH = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.axG = intent.getIntExtra("album_thread", 0);
                this.axI = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.axJ = intent.getIntExtra("from_type", 0);
            }
        }
        xP();
    }

    private void xP() {
        if (this.requestFrom == 2) {
            this.axF = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.axD != null) {
            this.axD.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.axK, a.d.sdk_cp_bg_line_d, i);
    }

    public void xQ() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.axC != null) {
            if (ListUtils.getCount(this.axC.yn()) == 1 && this.axJ == 0) {
                xR();
            } else {
                z(null);
            }
        }
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.axC.yo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.axJ);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void xR() {
        WriteImagesInfo yo;
        if (this.axC != null && (yo = this.axC.yo()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", yo.toJsonString());
            z(intent);
        }
    }

    private void A(Intent intent) {
        if (intent == null || this.axC == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo yo = this.axC.yo();
            yo.parseJson(stringExtra);
            yo.updateQuality();
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
        if (view == this.axD.ya()) {
            xQ();
        } else if (view == this.axD.yc()) {
            xQ();
        } else if (view == this.axD.xZ()) {
            if (this.axC != null) {
                this.axC.setLastAlbumId(null);
            }
            xX();
        } else if (view == this.axD.yb()) {
            cw(0);
        } else if (view == this.axD.yd()) {
            cu(2);
        } else if (view == this.axD.ye()) {
            cu(1);
        }
    }

    private void cu(int i) {
        if (this.axD != null && this.axC != null) {
            this.axC.setOriginalImg(!this.axC.isOriginalImg());
            xS();
            cv(i);
        }
    }

    private void cv(int i) {
        if (this.axC != null && this.axC.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void xS() {
        if (this.axC != null && this.axD != null) {
            this.axD.bl(this.axC.isOriginalImg());
        }
    }

    public View xT() {
        return this.axK;
    }

    public int xU() {
        return this.axG;
    }

    public c xV() {
        return this.axC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cw(int i) {
        if (!this.axE) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.axD.cy(this.aic));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aic = i;
            if (getSupportFragmentManager().findFragmentByTag(this.axD.cy(i)) != null) {
                beginTransaction.show(this.axD.cx(i));
            } else {
                beginTransaction.add(a.g.fragment, this.axD.cx(i), this.axD.cy(i));
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
        int maxImagesAllowed = this.axC.getMaxImagesAllowed();
        if (this.axC.size() < maxImagesAllowed) {
            if (this.axF == null || this.axF.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.axC.a((VideoFileInfo) null);
                this.axC.addChooseFile(imageFileInfo2);
                xS();
                return true;
            }
            return false;
        } else if (xW()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean xW() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.axC.getMaxImagesAllowed();
            if (this.axC.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.axC.yn(), 0);
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
        this.axC.a((VideoFileInfo) null);
        this.axC.delChooseFile(imageFileInfo);
        xS();
        return true;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aic == 0) {
                if (this.axC != null) {
                    this.axC.setLastAlbumId(null);
                }
                xX();
                return true;
            } else if (this.aic == 1) {
                cw(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cx;
        if (this.axD != null && (cx = this.axD.cx(0)) != null && (cx instanceof ImageListFragment)) {
            ((ImageListFragment) cx).c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment cx;
        if (this.axD != null && (cx = this.axD.cx(1)) != null && (cx instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) cx).c(imageFileInfo, z);
        }
    }

    private void xX() {
        Intent intent = new Intent();
        String lastAlbumId = this.axC.getLastAlbumId();
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
        this.axE = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.yt().destory();
        if (this.axK != null) {
            this.axK.setBackgroundDrawable(null);
        }
        if (this.axD != null) {
            this.axD.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.axC.yo(), true);
            return AlbumActivity.this.axC.yo().toJsonString();
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
            Z("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
            Z("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void Z(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
