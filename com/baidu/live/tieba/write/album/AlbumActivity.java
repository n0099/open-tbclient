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
import com.baidu.h.a.a;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
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
import com.baidu.live.u.a;
import com.baidu.megapp.ma.Util;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0125a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private c bdi;
    private com.baidu.live.tieba.write.album.a bdj;
    private e bdl;
    private boolean bdr;
    private com.baidu.live.tieba.c.a bds;
    private FrameLayout bdt;
    private FrameLayout bdu;
    private int aIx = 0;
    private boolean bdk = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bdm = 0;
    private boolean bdn = false;
    private boolean bdo = false;
    private int bdp = 0;
    private View bdq = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.h.sdk_ph_album_activity);
            this.bdq = findViewById(a.g.statebar_view);
            this.bdt = (FrameLayout) findViewById(a.g.imageList_layout);
            this.bdu = (FrameLayout) findViewById(a.g.imageBrowse_layout);
            this.bdr = UtilHelper.canUseStyleImmersiveSticky();
            Hc();
            initData(bundle);
            this.bdj = new com.baidu.live.tieba.write.album.a(this);
            this.bdj.Hp();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.bdt.addView(this.bdj.Hx().getView(), layoutParams);
            this.bdu.addView(this.bdj.Hw().getView(), layoutParams);
            di(0);
        }
    }

    public void showTip(View view) {
        if (this.bds == null && view != null) {
            this.bds = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.bds.cG(a.f.sdk_ph_bg_tip_blue_up_left);
            this.bds.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.bds.Gu();
                }
            });
            this.bds.cF(16);
            this.bds.cH(5000);
        }
        if (this.bds != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.bds.aA(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Hc() {
        if (this.bdq != null) {
            if (this.bdr && this.bdq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bdq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bdq.setLayoutParams(layoutParams);
                ch(true);
                return;
            }
            ch(false);
        }
    }

    private void ch(boolean z) {
        if (this.bdq != null) {
            if (this.bdr && z && this.bdq.getVisibility() != 0) {
                this.bdq.setVisibility(0);
            } else if (!z && this.bdq.getVisibility() != 8) {
                this.bdq.setVisibility(8);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bdi.HC().toJsonString());
        bundle.putBoolean("use_original_img", this.bdn);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bdm);
        bundle.putBoolean("from_write", this.bdo);
    }

    private void initData(Bundle bundle) {
        this.bdi = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bdi.a(writeImagesInfo);
            this.bdn = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bdm = bundle.getInt("album_thread");
            this.bdo = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bdp = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bdi.a(writeImagesInfo2);
                this.bdi.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bdn = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bdm = intent.getIntExtra("album_thread", 0);
                this.bdo = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bdp = intent.getIntExtra("from_type", 0);
            }
        }
        Hd();
    }

    private void Hd() {
        if (this.requestFrom == 2) {
            this.bdl = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.bdj != null) {
            this.bdj.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.bdq, a.d.sdk_cp_bg_line_d, i);
    }

    public void He() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bdi != null) {
            if (ListUtils.getCount(this.bdi.HB()) == 1 && this.bdp == 0) {
                Hf();
            } else {
                l(null);
            }
        }
    }

    private void l(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bdi.HC().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bdp);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Hf() {
        WriteImagesInfo HC;
        if (this.bdi != null && (HC = this.bdi.HC()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", HC.toJsonString());
            l(intent);
        }
    }

    private void m(Intent intent) {
        if (intent == null || this.bdi == null) {
            l(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo HC = this.bdi.HC();
            HC.parseJson(stringExtra);
            HC.updateQuality();
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
        if (view == this.bdj.Hr()) {
            He();
        } else if (view == this.bdj.Ht()) {
            He();
        } else if (view == this.bdj.Hq()) {
            if (this.bdi != null) {
                this.bdi.setLastAlbumId(null);
            }
            Hl();
        } else if (view == this.bdj.Hs()) {
            di(0);
        } else if (view == this.bdj.Hu()) {
            dg(2);
        } else if (view == this.bdj.Hv()) {
            dg(1);
        }
    }

    private void dg(int i) {
        if (this.bdj != null && this.bdi != null) {
            this.bdi.setOriginalImg(!this.bdi.isOriginalImg());
            Hg();
            dh(i);
        }
    }

    private void dh(int i) {
        if (this.bdi != null && this.bdi.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Hg() {
        if (this.bdi != null && this.bdj != null) {
            this.bdj.ci(this.bdi.isOriginalImg());
        }
    }

    public View Hh() {
        return this.bdq;
    }

    public int Hi() {
        return this.bdm;
    }

    public c Hj() {
        return this.bdi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void di(int i) {
        if (!this.bdk) {
            this.aIx = i;
            if (i == 0) {
                this.bdt.setVisibility(0);
                this.bdu.setVisibility(8);
                this.bdj.Hx().onResume();
                return;
            }
            this.bdt.setVisibility(8);
            this.bdu.setVisibility(0);
            this.bdj.Hw().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bdi.getMaxImagesAllowed();
        if (this.bdi.size() < maxImagesAllowed) {
            if (this.bdl == null || this.bdl.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bdi.a((VideoFileInfo) null);
                this.bdi.addChooseFile(imageFileInfo2);
                Hg();
                return true;
            }
            return false;
        } else if (Hk()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Hk() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bdi.getMaxImagesAllowed();
            if (this.bdi.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bdi.HB(), 0);
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
        this.bdi.a((VideoFileInfo) null);
        this.bdi.delChooseFile(imageFileInfo);
        Hg();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aIx == 0) {
                if (this.bdi != null) {
                    this.bdi.setLastAlbumId(null);
                }
                Hl();
                return true;
            } else if (this.aIx == 1) {
                di(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bdj != null) {
            this.bdj.Hx().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bdj != null) {
            this.bdj.Hw().c(imageFileInfo, z);
        }
    }

    private void Hl() {
        Intent intent = new Intent();
        String lastAlbumId = this.bdi.getLastAlbumId();
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
        this.bdk = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.HH().destory();
        if (this.bdq != null) {
            this.bdq.setBackgroundDrawable(null);
        }
        if (this.bdj != null) {
            this.bdj.onDestroy();
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
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bdi.HC(), true);
            return AlbumActivity.this.bdi.HC().toJsonString();
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
            aB("sdk_in_from_bottom", "sdk_fade_out");
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else if (!TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
            aB("sdk_fade_in", "sdk_out_to_bottom");
        }
    }

    public void aB(String str, String str2) {
        overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str, ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, str2, ResUtils.ANIM));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bdj.Hx().onResume();
        this.bdj.Hw().onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bdj.Hx().onPause();
    }
}
