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
import com.baidu.megapp.ma.Util;
import com.baidu.n.a.a;
/* loaded from: classes4.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0276a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private com.baidu.live.tieba.c.a bHA;
    private FrameLayout bHB;
    private FrameLayout bHC;
    private c bHq;
    private com.baidu.live.tieba.write.album.a bHr;
    private e bHt;
    private boolean bHz;
    private int bbx = 0;
    private boolean bHs = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bHu = 0;
    private boolean bHv = false;
    private boolean bHw = false;
    private int bHx = 0;
    private View bHy = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.g.sdk_ph_album_activity);
            this.bHy = findViewById(a.f.statebar_view);
            this.bHB = (FrameLayout) findViewById(a.f.imageList_layout);
            this.bHC = (FrameLayout) findViewById(a.f.imageBrowse_layout);
            this.bHz = UtilHelper.canUseStyleImmersiveSticky();
            Vq();
            initData(bundle);
            this.bHr = new com.baidu.live.tieba.write.album.a(this);
            this.bHr.VD();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bHB.addView(this.bHr.VL().getView(), layoutParams);
            this.bHC.addView(this.bHr.VK().getView(), layoutParams);
            gr(0);
        }
    }

    public void showTip(View view) {
        if (this.bHA == null && view != null) {
            this.bHA = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bHA.fO(a.e.sdk_ph_bg_tip_blue_up_left);
            this.bHA.d(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bHA.UG();
                }
            });
            this.bHA.fN(16);
            this.bHA.fP(5000);
        }
        if (this.bHA != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bHA.aP(getString(a.h.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Vq() {
        if (this.bHy != null) {
            if (this.bHz && this.bHy.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHy.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHy.setLayoutParams(layoutParams);
                df(true);
                return;
            }
            df(false);
        }
    }

    private void df(boolean z) {
        if (this.bHy != null) {
            if (this.bHz && z && this.bHy.getVisibility() != 0) {
                this.bHy.setVisibility(0);
            } else if (!z && this.bHy.getVisibility() != 8) {
                this.bHy.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bHq.VQ().toJsonString());
        bundle.putBoolean("use_original_img", this.bHv);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bHu);
        bundle.putBoolean("from_write", this.bHw);
    }

    private void initData(Bundle bundle) {
        this.bHq = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bHq.a(writeImagesInfo);
            this.bHv = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bHu = bundle.getInt("album_thread");
            this.bHw = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bHx = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bHq.a(writeImagesInfo2);
                this.bHq.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bHv = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bHu = intent.getIntExtra("album_thread", 0);
                this.bHw = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bHx = intent.getIntExtra("from_type", 0);
            }
        }
        Vr();
    }

    private void Vr() {
        if (this.requestFrom == 2) {
            this.bHt = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(a.h.sdk_ph_uploade_attation), a.e.sdk_icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.bHr != null) {
            this.bHr.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bHy, a.c.sdk_cp_bg_line_d, i);
    }

    public void Vs() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bHq != null) {
            if (ListUtils.getCount(this.bHq.VP()) == 1 && this.bHx == 0) {
                Vt();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bHq.VQ().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bHx);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Vt() {
        WriteImagesInfo VQ;
        if (this.bHq != null && (VQ = this.bHq.VQ()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", VQ.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bHq == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo VQ = this.bHq.VQ();
            VQ.parseJson(stringExtra);
            VQ.updateQuality();
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
        if (view == this.bHr.VF()) {
            Vs();
        } else if (view == this.bHr.VH()) {
            Vs();
        } else if (view == this.bHr.VE()) {
            if (this.bHq != null) {
                this.bHq.setLastAlbumId(null);
            }
            Vz();
        } else if (view == this.bHr.VG()) {
            gr(0);
        } else if (view == this.bHr.VI()) {
            gp(2);
        } else if (view == this.bHr.VJ()) {
            gp(1);
        }
    }

    private void gp(int i) {
        if (this.bHr != null && this.bHq != null) {
            this.bHq.setOriginalImg(!this.bHq.isOriginalImg());
            Vu();
            gq(i);
        }
    }

    private void gq(int i) {
        if (this.bHq != null && this.bHq.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Vu() {
        if (this.bHq != null && this.bHr != null) {
            this.bHr.dg(this.bHq.isOriginalImg());
        }
    }

    public View Vv() {
        return this.bHy;
    }

    public int Vw() {
        return this.bHu;
    }

    public c Vx() {
        return this.bHq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gr(int i) {
        if (!this.bHs) {
            this.bbx = i;
            if (i == 0) {
                this.bHB.setVisibility(0);
                this.bHC.setVisibility(8);
                this.bHr.VL().onResume();
                return;
            }
            this.bHB.setVisibility(8);
            this.bHC.setVisibility(0);
            this.bHr.VK().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bHq.getMaxImagesAllowed();
        if (this.bHq.size() < maxImagesAllowed) {
            if (this.bHt == null || this.bHt.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bHq.a((VideoFileInfo) null);
                this.bHq.addChooseFile(imageFileInfo2);
                Vu();
                return true;
            }
            return false;
        } else if (Vy()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.h.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Vy() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bHq.getMaxImagesAllowed();
            if (this.bHq.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bHq.VP(), 0);
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
        this.bHq.a((VideoFileInfo) null);
        this.bHq.delChooseFile(imageFileInfo);
        Vu();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.bbx == 0) {
                if (this.bHq != null) {
                    this.bHq.setLastAlbumId(null);
                }
                Vz();
                return true;
            } else if (this.bbx == 1) {
                gr(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bHr != null) {
            this.bHr.VL().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bHr != null) {
            this.bHr.VK().c(imageFileInfo, z);
        }
    }

    private void Vz() {
        Intent intent = new Intent();
        String lastAlbumId = this.bHq.getLastAlbumId();
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
        this.bHs = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.VU().destory();
        if (this.bHy != null) {
            this.bHy.setBackgroundDrawable(null);
        }
        if (this.bHr != null) {
            this.bHr.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bHq.VQ(), true);
            return AlbumActivity.this.bHq.VQ().toJsonString();
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
            aS("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo()) {
            aS("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aS(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }
}
