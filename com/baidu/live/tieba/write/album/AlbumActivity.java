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
import com.baidu.m.a.a;
import com.baidu.megapp.ma.Util;
/* loaded from: classes4.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0209a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c brG;
    private com.baidu.live.tieba.write.album.a brH;
    private e brJ;
    private boolean brP;
    private com.baidu.live.tieba.c.a brQ;
    private FrameLayout brR;
    private FrameLayout brS;
    private int aTP = 0;
    private boolean brI = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int brK = 0;
    private boolean brL = false;
    private boolean brM = false;
    private int brN = 0;
    private View brO = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.h.sdk_ph_album_activity);
            this.brO = findViewById(a.g.statebar_view);
            this.brR = (FrameLayout) findViewById(a.g.imageList_layout);
            this.brS = (FrameLayout) findViewById(a.g.imageBrowse_layout);
            this.brP = UtilHelper.canUseStyleImmersiveSticky();
            OR();
            initData(bundle);
            this.brH = new com.baidu.live.tieba.write.album.a(this);
            this.brH.Pe();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.brR.addView(this.brH.Pm().getView(), layoutParams);
            this.brS.addView(this.brH.Pl().getView(), layoutParams);
            fy(0);
        }
    }

    public void showTip(View view) {
        if (this.brQ == null && view != null) {
            this.brQ = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.brQ.eW(a.f.sdk_ph_bg_tip_blue_up_left);
            this.brQ.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.brQ.Oj();
                }
            });
            this.brQ.eV(16);
            this.brQ.eX(5000);
        }
        if (this.brQ != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.brQ.aG(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void OR() {
        if (this.brO != null) {
            if (this.brP && this.brO.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.brO.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.brO.setLayoutParams(layoutParams);
                cz(true);
                return;
            }
            cz(false);
        }
    }

    private void cz(boolean z) {
        if (this.brO != null) {
            if (this.brP && z && this.brO.getVisibility() != 0) {
                this.brO.setVisibility(0);
            } else if (!z && this.brO.getVisibility() != 8) {
                this.brO.setVisibility(8);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.brG.Pr().toJsonString());
        bundle.putBoolean("use_original_img", this.brL);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.brK);
        bundle.putBoolean("from_write", this.brM);
    }

    private void initData(Bundle bundle) {
        this.brG = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.brG.a(writeImagesInfo);
            this.brL = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.brK = bundle.getInt("album_thread");
            this.brM = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.brN = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.brG.a(writeImagesInfo2);
                this.brG.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.brL = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.brK = intent.getIntExtra("album_thread", 0);
                this.brM = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.brN = intent.getIntExtra("from_type", 0);
            }
        }
        OS();
    }

    private void OS() {
        if (this.requestFrom == 2) {
            this.brJ = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.brH != null) {
            this.brH.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.brO, a.d.sdk_cp_bg_line_d, i);
    }

    public void OT() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.brG != null) {
            if (ListUtils.getCount(this.brG.Pq()) == 1 && this.brN == 0) {
                OU();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.brG.Pr().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.brN);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void OU() {
        WriteImagesInfo Pr;
        if (this.brG != null && (Pr = this.brG.Pr()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", Pr.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.brG == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo Pr = this.brG.Pr();
            Pr.parseJson(stringExtra);
            Pr.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            o(intent);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.brH.Pg()) {
            OT();
        } else if (view == this.brH.Pi()) {
            OT();
        } else if (view == this.brH.Pf()) {
            if (this.brG != null) {
                this.brG.setLastAlbumId(null);
            }
            Pa();
        } else if (view == this.brH.Ph()) {
            fy(0);
        } else if (view == this.brH.Pj()) {
            fw(2);
        } else if (view == this.brH.Pk()) {
            fw(1);
        }
    }

    private void fw(int i) {
        if (this.brH != null && this.brG != null) {
            this.brG.setOriginalImg(!this.brG.isOriginalImg());
            OV();
            fx(i);
        }
    }

    private void fx(int i) {
        if (this.brG != null && this.brG.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void OV() {
        if (this.brG != null && this.brH != null) {
            this.brH.cA(this.brG.isOriginalImg());
        }
    }

    public View OW() {
        return this.brO;
    }

    public int OX() {
        return this.brK;
    }

    public c OY() {
        return this.brG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fy(int i) {
        if (!this.brI) {
            this.aTP = i;
            if (i == 0) {
                this.brR.setVisibility(0);
                this.brS.setVisibility(8);
                this.brH.Pm().onResume();
                return;
            }
            this.brR.setVisibility(8);
            this.brS.setVisibility(0);
            this.brH.Pl().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.brG.getMaxImagesAllowed();
        if (this.brG.size() < maxImagesAllowed) {
            if (this.brJ == null || this.brJ.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.brG.a((VideoFileInfo) null);
                this.brG.addChooseFile(imageFileInfo2);
                OV();
                return true;
            }
            return false;
        } else if (OZ()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean OZ() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.brG.getMaxImagesAllowed();
            if (this.brG.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.brG.Pq(), 0);
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
        this.brG.a((VideoFileInfo) null);
        this.brG.delChooseFile(imageFileInfo);
        OV();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aTP == 0) {
                if (this.brG != null) {
                    this.brG.setLastAlbumId(null);
                }
                Pa();
                return true;
            } else if (this.aTP == 1) {
                fy(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.brH != null) {
            this.brH.Pm().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.brH != null) {
            this.brH.Pl().c(imageFileInfo, z);
        }
    }

    private void Pa() {
        Intent intent = new Intent();
        String lastAlbumId = this.brG.getLastAlbumId();
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
        this.brI = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.Pv().destory();
        if (this.brO != null) {
            this.brO.setBackgroundDrawable(null);
        }
        if (this.brH != null) {
            this.brH.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.brG.Pr(), true);
            return AlbumActivity.this.brG.Pr().toJsonString();
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
            aH("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
            aH("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aH(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
