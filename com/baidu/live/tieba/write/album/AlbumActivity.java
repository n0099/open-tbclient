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
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0238a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c bxI;
    private com.baidu.live.tieba.write.album.a bxJ;
    private e bxL;
    private boolean bxR;
    private com.baidu.live.tieba.c.a bxS;
    private FrameLayout bxT;
    private FrameLayout bxU;
    private int aYv = 0;
    private boolean bxK = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bxM = 0;
    private boolean bxN = false;
    private boolean bxO = false;
    private int bxP = 0;
    private View bxQ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.h.sdk_ph_album_activity);
            this.bxQ = findViewById(a.g.statebar_view);
            this.bxT = (FrameLayout) findViewById(a.g.imageList_layout);
            this.bxU = (FrameLayout) findViewById(a.g.imageBrowse_layout);
            this.bxR = UtilHelper.canUseStyleImmersiveSticky();
            QR();
            initData(bundle);
            this.bxJ = new com.baidu.live.tieba.write.album.a(this);
            this.bxJ.Re();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bxT.addView(this.bxJ.Rm().getView(), layoutParams);
            this.bxU.addView(this.bxJ.Rl().getView(), layoutParams);
            fJ(0);
        }
    }

    public void showTip(View view) {
        if (this.bxS == null && view != null) {
            this.bxS = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bxS.fh(a.f.sdk_ph_bg_tip_blue_up_left);
            this.bxS.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bxS.Qh();
                }
            });
            this.bxS.fg(16);
            this.bxS.fi(5000);
        }
        if (this.bxS != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bxS.aL(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void QR() {
        if (this.bxQ != null) {
            if (this.bxR && this.bxQ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bxQ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bxQ.setLayoutParams(layoutParams);
                cI(true);
                return;
            }
            cI(false);
        }
    }

    private void cI(boolean z) {
        if (this.bxQ != null) {
            if (this.bxR && z && this.bxQ.getVisibility() != 0) {
                this.bxQ.setVisibility(0);
            } else if (!z && this.bxQ.getVisibility() != 8) {
                this.bxQ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bxI.Rr().toJsonString());
        bundle.putBoolean("use_original_img", this.bxN);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bxM);
        bundle.putBoolean("from_write", this.bxO);
    }

    private void initData(Bundle bundle) {
        this.bxI = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bxI.a(writeImagesInfo);
            this.bxN = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bxM = bundle.getInt("album_thread");
            this.bxO = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bxP = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bxI.a(writeImagesInfo2);
                this.bxI.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bxN = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bxM = intent.getIntExtra("album_thread", 0);
                this.bxO = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bxP = intent.getIntExtra("from_type", 0);
            }
        }
        QS();
    }

    private void QS() {
        if (this.requestFrom == 2) {
            this.bxL = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.bxJ != null) {
            this.bxJ.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bxQ, a.d.sdk_cp_bg_line_d, i);
    }

    public void QT() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bxI != null) {
            if (ListUtils.getCount(this.bxI.Rq()) == 1 && this.bxP == 0) {
                QU();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bxI.Rr().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bxP);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void QU() {
        WriteImagesInfo Rr;
        if (this.bxI != null && (Rr = this.bxI.Rr()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", Rr.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bxI == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo Rr = this.bxI.Rr();
            Rr.parseJson(stringExtra);
            Rr.updateQuality();
            n(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            o(intent);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bxJ.Rg()) {
            QT();
        } else if (view == this.bxJ.Ri()) {
            QT();
        } else if (view == this.bxJ.Rf()) {
            if (this.bxI != null) {
                this.bxI.setLastAlbumId(null);
            }
            Ra();
        } else if (view == this.bxJ.Rh()) {
            fJ(0);
        } else if (view == this.bxJ.Rj()) {
            fH(2);
        } else if (view == this.bxJ.Rk()) {
            fH(1);
        }
    }

    private void fH(int i) {
        if (this.bxJ != null && this.bxI != null) {
            this.bxI.setOriginalImg(!this.bxI.isOriginalImg());
            QV();
            fI(i);
        }
    }

    private void fI(int i) {
        if (this.bxI != null && this.bxI.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void QV() {
        if (this.bxI != null && this.bxJ != null) {
            this.bxJ.cJ(this.bxI.isOriginalImg());
        }
    }

    public View QW() {
        return this.bxQ;
    }

    public int QX() {
        return this.bxM;
    }

    public c QY() {
        return this.bxI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fJ(int i) {
        if (!this.bxK) {
            this.aYv = i;
            if (i == 0) {
                this.bxT.setVisibility(0);
                this.bxU.setVisibility(8);
                this.bxJ.Rm().onResume();
                return;
            }
            this.bxT.setVisibility(8);
            this.bxU.setVisibility(0);
            this.bxJ.Rl().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bxI.getMaxImagesAllowed();
        if (this.bxI.size() < maxImagesAllowed) {
            if (this.bxL == null || this.bxL.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bxI.a((VideoFileInfo) null);
                this.bxI.addChooseFile(imageFileInfo2);
                QV();
                return true;
            }
            return false;
        } else if (QZ()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean QZ() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bxI.getMaxImagesAllowed();
            if (this.bxI.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bxI.Rq(), 0);
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
        this.bxI.a((VideoFileInfo) null);
        this.bxI.delChooseFile(imageFileInfo);
        QV();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aYv == 0) {
                if (this.bxI != null) {
                    this.bxI.setLastAlbumId(null);
                }
                Ra();
                return true;
            } else if (this.aYv == 1) {
                fJ(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bxJ != null) {
            this.bxJ.Rm().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bxJ != null) {
            this.bxJ.Rl().c(imageFileInfo, z);
        }
    }

    private void Ra() {
        Intent intent = new Intent();
        String lastAlbumId = this.bxI.getLastAlbumId();
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bxK = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.Rv().destory();
        if (this.bxQ != null) {
            this.bxQ.setBackgroundDrawable(null);
        }
        if (this.bxJ != null) {
            this.bxJ.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bxI.Rr(), true);
            return AlbumActivity.this.bxI.Rr().toJsonString();
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
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
        } else {
            aO("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo()) {
            aO("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aO(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
