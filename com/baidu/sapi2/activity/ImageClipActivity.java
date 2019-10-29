package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.baidu.d.a.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.ZoomImageView;
import java.io.ByteArrayOutputStream;
/* loaded from: classes2.dex */
public class ImageClipActivity extends Activity {
    public static final int BUSSINESS_FROM_INVOICE_BUILD = 1;
    public static final int BUSSINESS_SET_PORTRAIT = 0;
    public static final int DEFAULT_CLIP_IMAGE_MAX_SIDE_LENGTH = 1000;
    public static final int DEFAULT_UPLOAD_IMAGE_MAX_SIZE = 512;
    public static String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_PARAM_FROM_BUSINESS = "extra_business_from";
    public static final String EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE = "extra_upload_image_max_size";
    private static final String PUBLIC_DOWNLOADS = "content://downloads/public_downloads";
    public static final int UPLOAD_IMAGE_HEIGHT = 160;
    public static final int UPLOAD_IMAGE_WIDTH = 160;
    private static final String URI_AUTHORITY_DOWNLOADS_DOCUMENTS = "com.android.providers.downloads.documents";
    private static final String URI_AUTHORITY_MEDIA_DOCUMENTS = "com.android.providers.media.documents";
    private int businessType;
    private ClipBoxView mClipBoxView;
    private ZoomImageView mZoomImageView;
    private int uploadImageMaxSize;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    private void setupViews() {
        setContentView(a.f.layout_sapi_sdk_image_clip);
        this.businessType = getIntent().getIntExtra(EXTRA_PARAM_FROM_BUSINESS, 0);
        this.uploadImageMaxSize = getIntent().getIntExtra(EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, 512);
        if (this.uploadImageMaxSize <= 0) {
            this.uploadImageMaxSize = 512;
        }
        this.uploadImageMaxSize *= 1024;
        this.mClipBoxView = (ClipBoxView) findViewById(a.e.sapi_clip_box);
        this.mZoomImageView = (ZoomImageView) findViewById(a.e.sapi_background_picture);
        if (this.businessType == 1) {
            this.mClipBoxView.mType = ClipBoxView.CLIP_IMAGE_FREEDOM;
        }
        Button button = (Button) findViewById(a.e.sure_clip_btn);
        Button button2 = (Button) findViewById(a.e.cancel_clip_btn);
        if (Build.VERSION.SDK_INT >= 19) {
            handleImageOnKitkat(getIntent());
        } else {
            handleImageBeforeKitkat(getIntent());
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.activity.ImageClipActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageClipActivity.this.setResult(0);
                ImageClipActivity.this.finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.activity.ImageClipActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageClipActivity.this.compressImage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.sapi2.activity.ImageClipActivity$3] */
    @TargetApi(3)
    public void compressImage() {
        Bitmap cropImage = ZoomImageView.getInstance().cropImage();
        if (cropImage != null && !cropImage.isRecycled()) {
            new AsyncTask<Bitmap, Void, byte[]>() { // from class: com.baidu.sapi2.activity.ImageClipActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public byte[] doInBackground(Bitmap... bitmapArr) {
                    int i;
                    int i2 = 160;
                    if (bitmapArr[0] != null && !bitmapArr[0].isRecycled()) {
                        if (ImageClipActivity.this.businessType != 0) {
                            i = bitmapArr[0].getWidth();
                            i2 = bitmapArr[0].getHeight();
                        } else {
                            i = 160;
                        }
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapArr[0], i, i2, true);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int i3 = 100;
                        createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        while (byteArrayOutputStream.toByteArray().length > ImageClipActivity.this.uploadImageMaxSize && i3 > 0 && i3 - 5 > 0) {
                            byteArrayOutputStream.reset();
                            createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                        }
                        if (createScaledBitmap != bitmapArr[0]) {
                            createScaledBitmap.recycle();
                        }
                        bitmapArr[0].recycle();
                        return byteArrayOutputStream.toByteArray();
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(byte[] bArr) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray(ImageClipActivity.EXTRA_IMAGE, bArr);
                    intent.putExtras(bundle);
                    ImageClipActivity.this.setResult(-1, intent);
                    ImageClipActivity.this.finish();
                }
            }.execute(cropImage);
        }
    }

    @TargetApi(19)
    private void handleImageOnKitkat(Intent intent) {
        String str = null;
        Uri data = intent.getData();
        if (DocumentsContract.isDocumentUri(this, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if (URI_AUTHORITY_MEDIA_DOCUMENTS.equals(data.getAuthority())) {
                str = getImgePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
            } else if (URI_AUTHORITY_DOWNLOADS_DOCUMENTS.equals(data.getAuthority())) {
                str = getImgePath(ContentUris.withAppendedId(Uri.parse(PUBLIC_DOWNLOADS), Long.valueOf(documentId).longValue()), null);
            }
        } else if ("content".equalsIgnoreCase(data.getScheme())) {
            str = getImgePath(data, null);
        } else if (BdStatsConstant.OpSubType.FILE.equalsIgnoreCase(data.getScheme())) {
            str = data.getPath();
        }
        loadImage(str);
    }

    private void handleImageBeforeKitkat(Intent intent) {
        loadImage(getImgePath(intent.getData(), null));
    }

    private String getImgePath(Uri uri, String str) {
        Cursor query = getContentResolver().query(uri, null, str, null, null);
        if (query != null) {
            r2 = query.moveToFirst() ? query.getString(query.getColumnIndex("_data")) : null;
            query.close();
        }
        return r2;
    }

    private void loadImage(String str) {
        Bitmap compressImageBeforeClip = compressImageBeforeClip(str);
        if (compressImageBeforeClip != null) {
            this.mZoomImageView.setImageBitmap(compressImageBeforeClip);
        } else {
            Toast.makeText(this, "加载图片失败", 0).show();
        }
    }

    @TargetApi(12)
    private Bitmap compressImageBeforeClip(String str) {
        if (str != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outHeight;
            int i2 = options.outWidth;
            if (i2 <= i) {
                i2 = i;
            }
            int i3 = 1;
            while (i2 / i3 > 1000) {
                i3++;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = i3;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return BitmapFactory.decodeFile(str, options);
        }
        return null;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ClipBoxView.clearInstance();
        ZoomImageView.clearInstance();
    }
}
