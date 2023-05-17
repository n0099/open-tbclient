package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.baidu.sapi2.result.GetCertStatusResult;
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.ZoomImageView;
import com.baidu.tieba.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class ImageClipActivity extends Activity {
    public static final int BUSSINESS_FROM_INVOICE_BUILD = 1;
    public static final int BUSSINESS_ID_CARD_OCR = 2;
    public static final int BUSSINESS_SET_PORTRAIT = 0;
    public static final int DEFAULT_CLIP_IMAGE_MAX_SIDE_LENGTH = 1000;
    public static final int DEFAULT_UPLOAD_IMAGE_MAX_SIZE = 512;
    public static final String EXTRA_PARAM_FROM_BUSINESS = "extra_business_from";
    public static final String EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE = "extra_upload_image_max_size";
    public static final int INVALID_ANIM = 0;
    public static final int UPLOAD_IMAGE_HEIGHT = 160;
    public static final int UPLOAD_IMAGE_WIDTH = 160;
    public static final String k = "com.android.providers.media.documents";
    public static final String l = "com.android.providers.downloads.documents";
    public static final String m = "com.android.externalstorage.documents";
    public static final String n = "content://downloads/public_downloads";
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e;
    public int f;
    public String g;
    public ClipBoxView h;
    public ZoomImageView i;
    public static final String j = ImageClipActivity.class.getSimpleName();
    public static String EXTRA_IMAGE = "extra_image";

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(3)
    public void a() {
        Bitmap a;
        if (ZoomImageView.getInstance() == null) {
            a = null;
        } else {
            a = ZoomImageView.getInstance().a();
        }
        if (a != null && !a.isRecycled()) {
            new AsyncTask<Bitmap, Void, byte[]>() { // from class: com.baidu.sapi2.activity.ImageClipActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public byte[] doInBackground(Bitmap... bitmapArr) {
                    int i;
                    if (bitmapArr[0] != null && !bitmapArr[0].isRecycled()) {
                        int i2 = 160;
                        if (ImageClipActivity.this.e != 0) {
                            i2 = bitmapArr[0].getWidth();
                            i = bitmapArr[0].getHeight();
                        } else {
                            i = 160;
                        }
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapArr[0], i2, i, true);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int i3 = 100;
                        createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        while (byteArrayOutputStream.toByteArray().length > ImageClipActivity.this.f && i3 > 0 && i3 - 5 > 0) {
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
                @Override // android.os.AsyncTask
                public void onPostExecute(byte[] bArr) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray(ImageClipActivity.EXTRA_IMAGE, bArr);
                    intent.putExtras(bundle);
                    ImageClipActivity.this.setResult(-1, intent);
                    ImageClipActivity.this.finish();
                }
            }.execute(a);
        }
    }

    private void c() {
        if (this.a != 0 || this.b != 0) {
            overridePendingTransition(this.a, this.b);
            this.a = 0;
            this.b = 0;
        }
    }

    private void d() {
        if (this.c != 0 || this.d != 0) {
            overridePendingTransition(this.c, this.d);
            this.c = 0;
            this.d = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ClipBoxView.b();
        ZoomImageView.c();
    }

    @TargetApi(12)
    private Bitmap a(String str) {
        if (str != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outHeight;
            int i3 = options.outWidth;
            if (i3 > i2) {
                i2 = i3;
            }
            while (i2 / i > 1000) {
                i++;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return BitmapFactory.decodeFile(str, options);
        }
        return null;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c();
    }

    private String a(Context context, Uri uri) {
        String a = a(uri);
        if (!TextUtils.isEmpty(a)) {
            File file = new File(context.getExternalCacheDir().getPath() + File.separator + "pass_temp_" + a);
            a(context, uri, file);
            return file.getAbsolutePath();
        }
        return null;
    }

    private String a(Uri uri) {
        String path;
        int lastIndexOf;
        if (uri == null || (lastIndexOf = (path = uri.getPath()).lastIndexOf(47)) == -1) {
            return null;
        }
        return path.substring(lastIndexOf + 1);
    }

    private void b(String str) {
        Bitmap operateBitmap = operateBitmap(str);
        if (operateBitmap != null) {
            this.i.setImageBitmap(operateBitmap);
            if (!TextUtils.isEmpty(this.g)) {
                FileUtil.deleteFile(new File(this.g));
                return;
            }
            return;
        }
        Toast.makeText(this, "加载图片失败", 0).show();
    }

    private String a(Uri uri, String str) {
        String a;
        Cursor query = getContentResolver().query(uri, null, str, null, null);
        String str2 = null;
        if (query != null) {
            if (query.moveToFirst()) {
                if (query.getColumnIndex("_data") > -1) {
                    a = query.getString(query.getColumnIndex("_data"));
                } else {
                    a = a(getBaseContext(), uri);
                    this.g = a;
                }
                str2 = a;
            }
            query.close();
        }
        return str2;
    }

    private void a(Context context, Uri uri, File file) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileUtil.copy(openInputStream, fileOutputStream);
            openInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            Log.e(e);
        }
    }

    private void a(Intent intent) {
        b(a(intent.getData(), (String) null));
    }

    private void b() {
        setContentView(R.layout.layout_sapi_sdk_image_clip);
        this.e = getIntent().getIntExtra(EXTRA_PARAM_FROM_BUSINESS, 0);
        int intExtra = getIntent().getIntExtra(EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, 512);
        this.f = intExtra;
        if (intExtra <= 0) {
            this.f = 512;
        }
        this.f *= 1024;
        this.h = (ClipBoxView) findViewById(R.id.sapi_clip_box);
        this.i = (ZoomImageView) findViewById(R.id.sapi_background_picture);
        if (this.e == 1) {
            ClipBoxView clipBoxView = this.h;
            clipBoxView.E = ClipBoxView.G;
            clipBoxView.F = false;
        }
        if (this.e == 2) {
            ClipBoxView clipBoxView2 = this.h;
            clipBoxView2.E = ClipBoxView.G;
            clipBoxView2.F = false;
        }
        setPendingTransition(R.anim.sapi_sdk_slide_right_in, R.anim.sapi_sdk_slide_left_out, R.anim.sapi_sdk_slide_left_in, R.anim.sapi_sdk_slide_right_out);
        Button button = (Button) findViewById(R.id.sure_clip_btn);
        Button button2 = (Button) findViewById(R.id.cancel_clip_btn);
        if (Build.VERSION.SDK_INT >= 19) {
            b(getIntent());
        } else {
            a(getIntent());
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.activity.ImageClipActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ImageClipActivity.this.setResult(0);
                ImageClipActivity.this.finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.activity.ImageClipActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ImageClipActivity.this.a();
            }
        });
    }

    @TargetApi(19)
    private void b(Intent intent) {
        String[] split;
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            if (DocumentsContract.isDocumentUri(this, data)) {
                String documentId = DocumentsContract.getDocumentId(data);
                if (k.equals(data.getAuthority())) {
                    str = a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
                } else if (l.equals(data.getAuthority())) {
                    str = a(ContentUris.withAppendedId(Uri.parse(n), Long.valueOf(documentId).longValue()), (String) null);
                } else if (m.equals(data.getAuthority())) {
                    if (GetCertStatusResult.VALUE_PRIMARY_REAL_NAME.equalsIgnoreCase(documentId.split(":")[0])) {
                        str = getExternalCacheDir() + "/" + split[1];
                    }
                }
            } else if ("content".equalsIgnoreCase(data.getScheme())) {
                str = a(data, (String) null);
            } else if ("file".equalsIgnoreCase(data.getScheme())) {
                str = data.getPath();
            }
        }
        b(str);
    }

    public Bitmap operateBitmap(String str) {
        Bitmap a = a(str);
        if (a == null) {
            return null;
        }
        float f = 0.0f;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt == 8) {
                        f = 270.0f;
                    }
                } else {
                    f = 90.0f;
                }
            } else {
                f = 180.0f;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(f, a.getWidth() / 2, a.getHeight() / 2);
        return Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
    }

    public void setPendingTransition(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }
}
