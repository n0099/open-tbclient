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
import com.baidu.i.a.a;
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
/* loaded from: classes4.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0153a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c biP;
    private com.baidu.live.tieba.write.album.a biQ;
    private e biS;
    private boolean biY;
    private com.baidu.live.tieba.c.a biZ;
    private FrameLayout bja;
    private FrameLayout bjb;
    private int aMx = 0;
    private boolean biR = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int biT = 0;
    private boolean biU = false;
    private boolean biV = false;
    private int biW = 0;
    private View biX = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.h.sdk_ph_album_activity);
            this.biX = findViewById(a.g.statebar_view);
            this.bja = (FrameLayout) findViewById(a.g.imageList_layout);
            this.bjb = (FrameLayout) findViewById(a.g.imageBrowse_layout);
            this.biY = UtilHelper.canUseStyleImmersiveSticky();
            Iv();
            initData(bundle);
            this.biQ = new com.baidu.live.tieba.write.album.a(this);
            this.biQ.II();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bja.addView(this.biQ.IQ().getView(), layoutParams);
            this.bjb.addView(this.biQ.IP().getView(), layoutParams);
            du(0);
        }
    }

    public void showTip(View view) {
        if (this.biZ == null && view != null) {
            this.biZ = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.biZ.cS(a.f.sdk_ph_bg_tip_blue_up_left);
            this.biZ.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.biZ.HN();
                }
            });
            this.biZ.cR(16);
            this.biZ.cT(5000);
        }
        if (this.biZ != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.biZ.aC(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Iv() {
        if (this.biX != null) {
            if (this.biY && this.biX.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.biX.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.biX.setLayoutParams(layoutParams);
                co(true);
                return;
            }
            co(false);
        }
    }

    private void co(boolean z) {
        if (this.biX != null) {
            if (this.biY && z && this.biX.getVisibility() != 0) {
                this.biX.setVisibility(0);
            } else if (!z && this.biX.getVisibility() != 8) {
                this.biX.setVisibility(8);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.biP.IV().toJsonString());
        bundle.putBoolean("use_original_img", this.biU);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.biT);
        bundle.putBoolean("from_write", this.biV);
    }

    private void initData(Bundle bundle) {
        this.biP = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.biP.a(writeImagesInfo);
            this.biU = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.biT = bundle.getInt("album_thread");
            this.biV = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.biW = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.biP.a(writeImagesInfo2);
                this.biP.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.biU = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.biT = intent.getIntExtra("album_thread", 0);
                this.biV = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.biW = intent.getIntExtra("from_type", 0);
            }
        }
        Iw();
    }

    private void Iw() {
        if (this.requestFrom == 2) {
            this.biS = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.biQ != null) {
            this.biQ.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.biX, a.d.sdk_cp_bg_line_d, i);
    }

    public void Ix() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.biP != null) {
            if (ListUtils.getCount(this.biP.IU()) == 1 && this.biW == 0) {
                Iy();
            } else {
                l(null);
            }
        }
    }

    private void l(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.biP.IV().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.biW);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Iy() {
        WriteImagesInfo IV;
        if (this.biP != null && (IV = this.biP.IV()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", IV.toJsonString());
            l(intent);
        }
    }

    private void m(Intent intent) {
        if (intent == null || this.biP == null) {
            l(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo IV = this.biP.IV();
            IV.parseJson(stringExtra);
            IV.updateQuality();
            l(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            m(intent);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.biQ.IK()) {
            Ix();
        } else if (view == this.biQ.IM()) {
            Ix();
        } else if (view == this.biQ.IJ()) {
            if (this.biP != null) {
                this.biP.setLastAlbumId(null);
            }
            IE();
        } else if (view == this.biQ.IL()) {
            du(0);
        } else if (view == this.biQ.IN()) {
            ds(2);
        } else if (view == this.biQ.IO()) {
            ds(1);
        }
    }

    private void ds(int i) {
        if (this.biQ != null && this.biP != null) {
            this.biP.setOriginalImg(!this.biP.isOriginalImg());
            Iz();
            dt(i);
        }
    }

    private void dt(int i) {
        if (this.biP != null && this.biP.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Iz() {
        if (this.biP != null && this.biQ != null) {
            this.biQ.cp(this.biP.isOriginalImg());
        }
    }

    public View IA() {
        return this.biX;
    }

    public int IB() {
        return this.biT;
    }

    public c IC() {
        return this.biP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void du(int i) {
        if (!this.biR) {
            this.aMx = i;
            if (i == 0) {
                this.bja.setVisibility(0);
                this.bjb.setVisibility(8);
                this.biQ.IQ().onResume();
                return;
            }
            this.bja.setVisibility(8);
            this.bjb.setVisibility(0);
            this.biQ.IP().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.biP.getMaxImagesAllowed();
        if (this.biP.size() < maxImagesAllowed) {
            if (this.biS == null || this.biS.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.biP.a((VideoFileInfo) null);
                this.biP.addChooseFile(imageFileInfo2);
                Iz();
                return true;
            }
            return false;
        } else if (ID()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean ID() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.biP.getMaxImagesAllowed();
            if (this.biP.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.biP.IU(), 0);
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
        this.biP.a((VideoFileInfo) null);
        this.biP.delChooseFile(imageFileInfo);
        Iz();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aMx == 0) {
                if (this.biP != null) {
                    this.biP.setLastAlbumId(null);
                }
                IE();
                return true;
            } else if (this.aMx == 1) {
                du(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.biQ != null) {
            this.biQ.IQ().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.biQ != null) {
            this.biQ.IP().c(imageFileInfo, z);
        }
    }

    private void IE() {
        Intent intent = new Intent();
        String lastAlbumId = this.biP.getLastAlbumId();
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.biR = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.Ja().destory();
        if (this.biX != null) {
            this.biX.setBackgroundDrawable(null);
        }
        if (this.biQ != null) {
            this.biQ.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.biP.IV(), true);
            return AlbumActivity.this.biP.IV().toJsonString();
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
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
        } else {
            aD("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
            aD("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aD(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.biQ.IQ().onResume();
        this.biQ.IP().onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.biQ.IQ().onPause();
    }
}
