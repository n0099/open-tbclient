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
/* loaded from: classes7.dex */
public class AlbumActivity extends BaseActivity implements View.OnClickListener, a.InterfaceC0210a {
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    private boolean boD;
    private com.baidu.live.tieba.c.a boE;
    private FrameLayout boF;
    private FrameLayout boG;
    private c bou;
    private com.baidu.live.tieba.write.album.a bov;
    private e box;
    private int aRK = 0;
    private boolean bow = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int boy = 0;
    private boolean boz = false;
    private boolean boA = false;
    private int boB = 0;
    private View boC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.h.sdk_ph_album_activity);
            this.boC = findViewById(a.g.statebar_view);
            this.boF = (FrameLayout) findViewById(a.g.imageList_layout);
            this.boG = (FrameLayout) findViewById(a.g.imageBrowse_layout);
            this.boD = UtilHelper.canUseStyleImmersiveSticky();
            Oo();
            initData(bundle);
            this.bov = new com.baidu.live.tieba.write.album.a(this);
            this.bov.OB();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.boF.addView(this.bov.OJ().getView(), layoutParams);
            this.boG.addView(this.bov.OI().getView(), layoutParams);
            fn(0);
        }
    }

    public void showTip(View view) {
        if (this.boE == null && view != null) {
            this.boE = new com.baidu.live.tieba.c.a(getPageContext(), view);
            this.boE.eL(a.f.sdk_ph_bg_tip_blue_up_left);
            this.boE.c(new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.boE.NG();
                }
            });
            this.boE.eK(16);
            this.boE.eM(5000);
        }
        if (this.boE != null) {
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.boE.aG(getString(a.i.sdk_ph_album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Oo() {
        if (this.boC != null) {
            if (this.boD && this.boC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.boC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.boC.setLayoutParams(layoutParams);
                cx(true);
                return;
            }
            cx(false);
        }
    }

    private void cx(boolean z) {
        if (this.boC != null) {
            if (this.boD && z && this.boC.getVisibility() != 0) {
                this.boC.setVisibility(0);
            } else if (!z && this.boC.getVisibility() != 8) {
                this.boC.setVisibility(8);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("write_images_info", this.bou.OO().toJsonString());
        bundle.putBoolean("use_original_img", this.boz);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.boy);
        bundle.putBoolean("from_write", this.boA);
    }

    private void initData(Bundle bundle) {
        this.bou = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.bou.a(writeImagesInfo);
            this.boz = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.boy = bundle.getInt("album_thread");
            this.boA = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.boB = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.bou.a(writeImagesInfo2);
                this.bou.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.boz = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.boy = intent.getIntExtra("album_thread", 0);
                this.boA = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.boB = intent.getIntExtra("from_type", 0);
            }
        }
        Op();
    }

    private void Op() {
        if (this.requestFrom == 2) {
            this.box = new e() { // from class: com.baidu.live.tieba.write.album.AlbumActivity.2
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
        if (this.bov != null) {
            this.bov.onChangeSkinType(i);
        }
        SkinManager.setBackgroundColor(this.boC, a.d.sdk_cp_bg_line_d, i);
    }

    public void Oq() {
        if (this.requestFrom == 3) {
            TiebaInitialize.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.bou != null) {
            if (ListUtils.getCount(this.bou.ON()) == 1 && this.boB == 0) {
                Or();
            } else {
                n(null);
            }
        }
    }

    private void n(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.bou.OO().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.boB);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private void Or() {
        WriteImagesInfo OO;
        if (this.bou != null && (OO = this.bou.OO()) != null) {
            Intent intent = new Intent();
            intent.putExtra("album_result", OO.toJsonString());
            n(intent);
        }
    }

    private void o(Intent intent) {
        if (intent == null || this.bou == null) {
            n(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo OO = this.bou.OO();
            OO.parseJson(stringExtra);
            OO.updateQuality();
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
        if (view == this.bov.OD()) {
            Oq();
        } else if (view == this.bov.OF()) {
            Oq();
        } else if (view == this.bov.OC()) {
            if (this.bou != null) {
                this.bou.setLastAlbumId(null);
            }
            Ox();
        } else if (view == this.bov.OE()) {
            fn(0);
        } else if (view == this.bov.OG()) {
            fl(2);
        } else if (view == this.bov.OH()) {
            fl(1);
        }
    }

    private void fl(int i) {
        if (this.bov != null && this.bou != null) {
            this.bou.setOriginalImg(!this.bou.isOriginalImg());
            Os();
            fm(i);
        }
    }

    private void fm(int i) {
        if (this.bou != null && this.bou.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaInitialize.log(new StatisticItem("c10349").param("fid", this.forumId).param("obj_type", this.from).param("obj_locate", i));
        }
    }

    public void Os() {
        if (this.bou != null && this.bov != null) {
            this.bov.cy(this.bou.isOriginalImg());
        }
    }

    public View Ot() {
        return this.boC;
    }

    public int Ou() {
        return this.boy;
    }

    public c Ov() {
        return this.bou;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fn(int i) {
        if (!this.bow) {
            this.aRK = i;
            if (i == 0) {
                this.boF.setVisibility(0);
                this.boG.setVisibility(8);
                this.bov.OJ().onResume();
                return;
            }
            this.boF.setVisibility(8);
            this.boG.setVisibility(0);
            this.bov.OI().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.bou.getMaxImagesAllowed();
        if (this.bou.size() < maxImagesAllowed) {
            if (this.box == null || this.box.c(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.bou.a((VideoFileInfo) null);
                this.bou.addChooseFile(imageFileInfo2);
                Os();
                return true;
            }
            return false;
        } else if (Ow()) {
            return a(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(a.i.sdk_ph_album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Ow() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.bou.getMaxImagesAllowed();
            if (this.bou.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.bou.ON(), 0);
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
        this.bou.a((VideoFileInfo) null);
        this.bou.delChooseFile(imageFileInfo);
        Os();
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aRK == 0) {
                if (this.bou != null) {
                    this.bou.setLastAlbumId(null);
                }
                Ox();
                return true;
            } else if (this.aRK == 1) {
                fn(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bov != null) {
            this.bov.OJ().c(imageFileInfo, z);
        }
    }

    void b(ImageFileInfo imageFileInfo, boolean z) {
        if (this.bov != null) {
            this.bov.OI().c(imageFileInfo, z);
        }
    }

    private void Ox() {
        Intent intent = new Intent();
        String lastAlbumId = this.bou.getLastAlbumId();
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
        this.bow = true;
        closeLoadingDialog();
        dismissAllDialog();
        d.OS().destory();
        if (this.boC != null) {
            this.boC.setBackgroundDrawable(null);
        }
        if (this.bov != null) {
            this.bov.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(AlbumActivity.this.bou.OO(), true);
            return AlbumActivity.this.bou.OO().toJsonString();
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
