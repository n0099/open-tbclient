package com.baidu.live.tieba.personextra;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.atomdata.EditHeadActivityConfig;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.TbImageHelper;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.coreextra.data.PhotoUrlData;
import com.baidu.live.tbadk.img.AsyncImageUploadModel;
import com.baidu.live.tbadk.img.ImageUploadResult;
import com.baidu.live.tbadk.util.WriteUtil;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes11.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bKH;
    private View bKI;
    private TextView bKL;
    private b bKM;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String FILE_NAME = "file_name";
    private float bKD = 1.0f;
    private float bKE = 1.0f;
    private EditHeadsImageView bKF = null;
    private EditHeadsImageTopLayerView bKG = null;
    private Bitmap mBitmap = null;
    private a bKJ = null;
    private TextView mTitle = null;
    private Bitmap bKK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setSwipeBackEnabled(false);
            setContentView(a.g.sdk_ph_edit_head_activity);
            Intent intent = getIntent();
            this.bKD = intent.getFloatExtra("cut_image_height_scale", 1.0f);
            this.bKE = intent.getFloatExtra(EditHeadActivityConfig.PREVIEW_IMAGE_HEIGHT_SCALE, this.bKD);
            int intExtra = intent.getIntExtra("request", 0);
            initUI();
            this.bKM = new b(intExtra, intent.getStringExtra(FILE_NAME));
            this.bKM.execute(new Object[0]);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.bKJ != null) {
            this.bKJ.cancel();
        }
        this.bKF.setImageDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.bKF.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.bKK != null && !this.bKK.isRecycled()) {
            this.bKK.recycle();
            this.bKK = null;
        }
        if (this.bKJ != null) {
            this.bKJ.cancel();
            this.bKJ = null;
        }
        if (this.bKM != null) {
            this.bKM.cancel();
            this.bKM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.bKJ != null) {
            this.bKJ.cancel();
        }
        this.bKJ = new a();
        this.bKJ.execute(new Object[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.f.navigation_bar);
        this.bKG = (EditHeadsImageTopLayerView) findViewById(a.f.image_top_layer);
        this.bKG.setCutImageHeightScale(this.bKE);
        BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.bKF = (EditHeadsImageView) findViewById(a.f.image);
        this.bKF.setCutImageHeightScale(this.bKD);
        if (this.mBitmap != null) {
            this.bKF.setImageBitmap(this.mBitmap);
        }
        this.bKH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, a.g.sdk_widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.live.tieba.personextra.EditHeadActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        SkinManager.setNavbarIconSrc((ImageView) this.bKH.findViewById(a.f.widget_navi_back_button), a.e.sdk_icon_return_bg, a.e.sdk_icon_return_bg_s, 3);
        this.bKI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, a.g.sdk_ph_image_activity_save_button, (View.OnClickListener) null);
        this.bKI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.tieba.personextra.EditHeadActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap dc = EditHeadActivity.this.bKF.dc(false);
                if (dc == null || EditHeadActivity.this.c(TbConfig.PERSON_HEAD_FILE, dc)) {
                    AsyncImageUploadModel asyncImageUploadModel = new AsyncImageUploadModel(FileHelper.getFileDireciory(TbConfig.PERSON_HEAD_FILE), "head");
                    asyncImageUploadModel.setServerResizeForIMImage();
                    asyncImageUploadModel.setUploadPicCallback(new AsyncImageUploadModel.UploadPicCallback() { // from class: com.baidu.live.tieba.personextra.EditHeadActivity.2.1
                        @Override // com.baidu.live.tbadk.img.AsyncImageUploadModel.UploadPicCallback
                        public void callBack(String str, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(a.h.sdk_ph_upload_pic_error, false);
                                } else {
                                    PhotoUrlData photoUrlData = new PhotoUrlData();
                                    photoUrlData.setPicId(String.valueOf(imageUploadResult.picId));
                                    if (imageUploadResult.picInfo != null) {
                                        if (imageUploadResult.picInfo.bigPic != null) {
                                            photoUrlData.setBigurl(imageUploadResult.picInfo.bigPic.picUrl);
                                        }
                                        if (imageUploadResult.picInfo.smallPic != null) {
                                            photoUrlData.setSmallurl(imageUploadResult.picInfo.smallPic.picUrl);
                                        }
                                        if (imageUploadResult.getUploadedPicInfo() != null && !StringUtils.isNull(imageUploadResult.getUploadedPicInfo().toPostString())) {
                                            photoUrlData.setToServerPhotoInfo(imageUploadResult.getUploadedPicInfo().toPostString());
                                        }
                                    }
                                    intent.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent.putExtra(EditHeadActivity.PIC_INFO, PhotoUrlData.serializableJson(photoUrlData));
                                }
                            }
                            EditHeadActivity.this.setResult(-1, intent);
                            EditHeadActivity.this.finish();
                        }
                    });
                    asyncImageUploadModel.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(a.h.sdk_ph_uploading));
                }
            }
        });
        this.bKI.setEnabled(false);
        this.bKL = (TextView) this.bKI.findViewById(a.f.save);
        this.bKL.setText(a.h.sdk_ph_done);
        this.bKG.setLinePaintColor(getResources().getColor(a.c.sdk_white_alpha50));
        this.bKG.setLineWidth(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            Exception e;
            Bitmap bitmap;
            Bitmap bitmap2 = null;
            try {
                Bitmap image = FileHelper.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (image.getWidth() > 1800 || image.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(image, 1800);
                        try {
                            image.recycle();
                            bitmap = resizeBitmap;
                        } catch (Exception e2) {
                            e = e2;
                            bitmap2 = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap2;
                        }
                    } else {
                        bitmap = image;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bitmap2 = image;
                }
                try {
                    if (!isCancelled() || bitmap == null || bitmap.isRecycled()) {
                        return bitmap;
                    }
                    bitmap.recycle();
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    bitmap2 = bitmap;
                    BdLog.e(e.toString());
                    return bitmap2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.bKI.setClickable(false);
        }

        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.bKJ = null;
            EditHeadActivity.this.bKI.setClickable(true);
            EditHeadActivity.this.bKI.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            EditHeadActivity.this.bKJ = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.bKI.setClickable(true);
            EditHeadActivity.this.bKI.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.bKF.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.bKF.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            FileHelper.saveFile2(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<Object, Integer, Boolean> {
        String mFileName;
        int mRequestCode;
        String bKP = null;
        private int mMaxSize = TbImageHelper.getInstance().getPostImageSize();
        private int mDisplaySize = 0;

        public b(int i, String str) {
            this.mFileName = null;
            this.mRequestCode = 0;
            this.mRequestCode = i;
            this.mFileName = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: j */
        public Boolean doInBackground(Object... objArr) {
            boolean z = false;
            try {
                Bitmap ImageResult = WriteUtil.ImageResult(this.mRequestCode, EditHeadActivity.this, null, this.mFileName, this.mMaxSize);
                if (ImageResult != null) {
                    if (FileHelper.saveFile2(null, TbConfig.IMAGE_RESIZED_FILE, ImageResult, 85) != null) {
                        int i = 100;
                        if (this.mDisplaySize > 0) {
                            i = this.mDisplaySize;
                        }
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ImageResult, i);
                        if (resizeBitmap != null && FileHelper.saveFile2(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                            z = true;
                        } else {
                            this.bKP = EditHeadActivity.this.getString(a.h.sdk_error_sd_error);
                        }
                    } else {
                        this.bKP = EditHeadActivity.this.getString(a.h.sdk_error_sd_error);
                    }
                } else {
                    this.bKP = EditHeadActivity.this.getString(a.h.sdk_ph_pic_parser_error);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((b) bool);
            EditHeadActivity.this.releaseResouce();
            if (bool.booleanValue()) {
                EditHeadActivity.this.initData();
                return;
            }
            EditHeadActivity.this.showToast(this.bKP);
            if (EditHeadActivity.this.bKI != null) {
                EditHeadActivity.this.bKI.setEnabled(false);
            }
        }
    }
}
