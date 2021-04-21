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
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.ZoomImageView;
import d.b.y.a.a;
import d.b.y.a.e;
import d.b.y.a.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class ImageClipActivity extends Activity {
    public static final int BUSSINESS_FROM_INVOICE_BUILD = 1;
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

    /* renamed from: a  reason: collision with root package name */
    public int f10572a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f10573b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f10574c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f10575d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f10576e;

    /* renamed from: f  reason: collision with root package name */
    public int f10577f;

    /* renamed from: g  reason: collision with root package name */
    public String f10578g;

    /* renamed from: h  reason: collision with root package name */
    public ClipBoxView f10579h;
    public ZoomImageView i;
    public static final String j = ImageClipActivity.class.getSimpleName();
    public static String EXTRA_IMAGE = "extra_image";

    private void d() {
        if (this.f10574c == 0 && this.f10575d == 0) {
            return;
        }
        overridePendingTransition(this.f10574c, this.f10575d);
        this.f10574c = 0;
        this.f10575d = 0;
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
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ClipBoxView.b();
        ZoomImageView.c();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c();
    }

    public Bitmap operateBitmap(String str) {
        Bitmap a2 = a(str);
        if (a2 == null) {
            return null;
        }
        float f2 = 0.0f;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                f2 = 180.0f;
            } else if (attributeInt == 6) {
                f2 = 90.0f;
            } else if (attributeInt == 8) {
                f2 = 270.0f;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(f2, a2.getWidth() / 2, a2.getHeight() / 2);
        return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
    }

    public void setPendingTransition(int i, int i2, int i3, int i4) {
        this.f10572a = i;
        this.f10573b = i2;
        this.f10574c = i3;
        this.f10575d = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(3)
    public void a() {
        Bitmap a2 = ZoomImageView.getInstance() == null ? null : ZoomImageView.getInstance().a();
        if (a2 == null || a2.isRecycled()) {
            return;
        }
        new AsyncTask<Bitmap, Void, byte[]>() { // from class: com.baidu.sapi2.activity.ImageClipActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            public byte[] doInBackground(Bitmap... bitmapArr) {
                int i;
                if (bitmapArr[0] == null || bitmapArr[0].isRecycled()) {
                    return null;
                }
                int i2 = 160;
                if (ImageClipActivity.this.f10576e != 0) {
                    i2 = bitmapArr[0].getWidth();
                    i = bitmapArr[0].getHeight();
                } else {
                    i = 160;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapArr[0], i2, i, true);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i3 = 100;
                createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length > ImageClipActivity.this.f10577f && i3 > 0 && i3 - 5 > 0) {
                    byteArrayOutputStream.reset();
                    createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                }
                if (createScaledBitmap != bitmapArr[0]) {
                    createScaledBitmap.recycle();
                }
                bitmapArr[0].recycle();
                return byteArrayOutputStream.toByteArray();
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
        }.execute(a2);
    }

    private void b() {
        setContentView(f.layout_sapi_sdk_image_clip);
        this.f10576e = getIntent().getIntExtra(EXTRA_PARAM_FROM_BUSINESS, 0);
        int intExtra = getIntent().getIntExtra(EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, 512);
        this.f10577f = intExtra;
        if (intExtra <= 0) {
            this.f10577f = 512;
        }
        this.f10577f *= 1024;
        this.f10579h = (ClipBoxView) findViewById(e.sapi_clip_box);
        this.i = (ZoomImageView) findViewById(e.sapi_background_picture);
        if (this.f10576e == 1) {
            ClipBoxView clipBoxView = this.f10579h;
            clipBoxView.E = ClipBoxView.G;
            clipBoxView.F = false;
        }
        setPendingTransition(a.sapi_sdk_slide_right_in, a.sapi_sdk_slide_left_out, a.sapi_sdk_slide_left_in, a.sapi_sdk_slide_right_out);
        Button button = (Button) findViewById(e.sure_clip_btn);
        Button button2 = (Button) findViewById(e.cancel_clip_btn);
        if (Build.VERSION.SDK_INT >= 19) {
            b(getIntent());
        } else {
            a(getIntent());
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
                ImageClipActivity.this.a();
            }
        });
    }

    private void c() {
        if (this.f10572a == 0 && this.f10573b == 0) {
            return;
        }
        overridePendingTransition(this.f10572a, this.f10573b);
        this.f10572a = 0;
        this.f10573b = 0;
    }

    private void a(Intent intent) {
        b(a(intent.getData(), (String) null));
    }

    private String a(Uri uri, String str) {
        String a2;
        Cursor query = getContentResolver().query(uri, null, str, null, null);
        String str2 = null;
        if (query != null) {
            if (query.moveToFirst()) {
                if (query.getColumnIndex("_data") > -1) {
                    a2 = query.getString(query.getColumnIndex("_data"));
                } else {
                    a2 = a(getBaseContext(), uri);
                    this.f10578g = a2;
                }
                str2 = a2;
            }
            query.close();
        }
        return str2;
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

    @TargetApi(19)
    private void b(Intent intent) {
        String[] split;
        Uri data = intent.getData();
        String str = null;
        if (DocumentsContract.isDocumentUri(this, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if (k.equals(data.getAuthority())) {
                str = a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
            } else if (l.equals(data.getAuthority())) {
                str = a(ContentUris.withAppendedId(Uri.parse(n), Long.valueOf(documentId).longValue()), (String) null);
            } else if (m.equals(data.getAuthority())) {
                if ("primary".equalsIgnoreCase(documentId.split(":")[0])) {
                    str = Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
        } else if ("content".equalsIgnoreCase(data.getScheme())) {
            str = a(data, (String) null);
        } else if ("file".equalsIgnoreCase(data.getScheme())) {
            str = data.getPath();
        }
        b(str);
    }

    private String a(Context context, Uri uri) {
        String a2 = a(uri);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        File file = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "pass_temp_" + a2);
        a(context, uri, file);
        return file.getAbsolutePath();
    }

    private String a(Uri uri) {
        String path;
        int lastIndexOf;
        if (uri == null || (lastIndexOf = (path = uri.getPath()).lastIndexOf(47)) == -1) {
            return null;
        }
        return path.substring(lastIndexOf + 1);
    }

    private void a(Context context, Uri uri, File file) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            b.a(openInputStream, fileOutputStream);
            openInputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    private void b(String str) {
        Bitmap operateBitmap = operateBitmap(str);
        if (operateBitmap != null) {
            this.i.setImageBitmap(operateBitmap);
            if (TextUtils.isEmpty(this.f10578g)) {
                return;
            }
            b.a(new File(this.f10578g));
            return;
        }
        Toast.makeText(this, "加载图片失败", 0).show();
    }
}
