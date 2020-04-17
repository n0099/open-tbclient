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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0100a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c aVP;
    private com.baidu.live.tieba.write.album.a aVQ;
    private e aVS;
    private boolean aVY;
    private com.baidu.live.tieba.c.a aVZ;
    private int aCS = 0;
    private boolean aVR = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int aVT = 0;
    private boolean aVU = false;
    private boolean aVV = false;
    private int aVW = 0;
    private View aVX = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.h.sdk_ph_album_activity);
            this.aVX = findViewById(a.g.statebar_view);
            this.aVY = UtilHelper.canUseStyleImmersiveSticky();
            Fm();
            initData(bundle);
            this.aVQ = new com.baidu.live.tieba.write.album.a(this);
            this.aVQ.Fw();
            db(0);
        }
    }

    public void showTip(View view) {
        if (this.aVZ == null && view != null) {
            this.aVZ = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.aVZ.cz(a.f.sdk_ph_bg_tip_blue_up_left);
            this.aVZ.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.aVZ.EE();
                }
            });
            this.aVZ.cy(16);
            this.aVZ.cA(5000);
        }
        if (this.aVZ != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.aVZ.al(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Fm() {
        if (this.aVX != null) {
            if (this.aVY && this.aVX.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aVX.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aVX.setLayoutParams(layoutParams);
                bX(true);
                return;
            }
            bX(false);
        }
    }

    private void bX(boolean z) {
        if (this.aVX != null) {
            if (this.aVY && z && this.aVX.getVisibility() != 0) {
                this.aVX.setVisibility(0);
            } else if (!z && this.aVX.getVisibility() != 8) {
                this.aVX.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.aVP.FM().toJsonString());
        bundle.putBoolean("use_original_img", this.aVU);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.aVT);
        bundle.putBoolean("from_write", this.aVV);
    }

    private void initData(Bundle bundle) {
        this.aVP = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.aVP.a(writeImagesInfo);
            this.aVU = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.aVT = bundle.getInt("album_thread");
            this.aVV = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.aVW = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.aVP.a(writeImagesInfo2);
                this.aVP.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.aVU = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.aVT = intent.getIntExtra("album_thread", 0);
                this.aVV = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.aVW = intent.getIntExtra("from_type", 0);
            }
        }
        Fn();
    }

    private void Fn() {
        if (this.requestFrom == 2) {
            this.aVS = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.aVQ != null) {
            this.aVQ.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.aVX, a.d.sdk_cp_bg_line_d, i);
    }

    public void Fo() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.aVP != null) {
            if (ListUtils.getCount(this.aVP.FL()) == 1 && this.aVW == 0) {
                Fp();
            } else {
                y(null);
            }
        }
    }

    private void y(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.aVP.FM().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.aVW);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Fp() {
        WriteImagesInfo FM;
        if (this.aVP != null && (FM = this.aVP.FM()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", FM.toJsonString());
            y(intent);
        }
    }

    private void z(Intent intent) {
        if (intent == null || this.aVP == null) {
            y(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo FM = this.aVP.FM();
            FM.parseJson(stringExtra);
            FM.updateQuality();
            y(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            z(intent);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVQ.Fy()) {
            Fo();
        } else if (view == this.aVQ.FA()) {
            Fo();
        } else if (view == this.aVQ.Fx()) {
            if (this.aVP != null) {
                this.aVP.setLastAlbumId(null);
            }
            Fv();
        } else if (view == this.aVQ.Fz()) {
            db(0);
        } else if (view == this.aVQ.FB()) {
            cZ(2);
        } else if (view == this.aVQ.FC()) {
            cZ(1);
        }
    }

    private void cZ(int i) {
        if (this.aVQ != null && this.aVP != null) {
            this.aVP.setOriginalImg(!this.aVP.isOriginalImg());
            Fq();
            da(i);
        }
    }

    private void da(int i) {
        if (this.aVP != null && this.aVP.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Fq() {
        if (this.aVP != null && this.aVQ != null) {
            this.aVQ.bY(this.aVP.isOriginalImg());
        }
    }

    public View Fr() {
        return this.aVX;
    }

    public int Fs() {
        return this.aVT;
    }

    public c Ft() {
        return this.aVP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void db(int i) {
        if (!this.aVR) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.aVQ.dd(this.aCS));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aCS = i;
            if (getSupportFragmentManager().findFragmentByTag(this.aVQ.dd(i)) != null) {
                beginTransaction.show(this.aVQ.dc(i));
            } else {
                beginTransaction.add(a.g.fragment, this.aVQ.dc(i), this.aVQ.dd(i));
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
        int maxImagesAllowed = this.aVP.getMaxImagesAllowed();
        if (this.aVP.size() < maxImagesAllowed) {
            if (this.aVS == null || this.aVS.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.aVP.a((VideoFileInfo) null);
                this.aVP.addChooseFile(imageFileInfo2);
                Fq();
                return true;
            }
            return false;
        } else if (Fu()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Fu() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.aVP.getMaxImagesAllowed();
            if (this.aVP.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.aVP.FL(), 0);
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
        this.aVP.a((VideoFileInfo) null);
        this.aVP.delChooseFile(imageFileInfo);
        Fq();
        return true;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aCS == 0) {
                if (this.aVP != null) {
                    this.aVP.setLastAlbumId(null);
                }
                Fv();
                return true;
            } else if (this.aCS == 1) {
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
        if (this.aVQ != null && (dc = this.aVQ.dc(0)) != null && (dc instanceof ImageListFragment)) {
            ((ImageListFragment) dc).c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        Fragment dc;
        if (this.aVQ != null && (dc = this.aVQ.dc(1)) != null && (dc instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) dc).c(imageFileInfo, z);
        }
    }

    private void Fv() {
        Intent intent = new Intent();
        String lastAlbumId = this.aVP.getLastAlbumId();
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
        this.aVR = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.FR().destory();
        if (this.aVX != null) {
            this.aVX.setBackgroundDrawable(null);
        }
        if (this.aVQ != null) {
            this.aVQ.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.aVP.FM(), true);
            return AlbumActivity.this.aVP.FM().toJsonString();
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
