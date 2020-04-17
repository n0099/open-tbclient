package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.baidu.f.a.a;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.ZoomImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class ImageClipActivity extends Activity {
    public static final int BUSSINESS_FROM_INVOICE_BUILD = 1;
    public static final int BUSSINESS_SET_PORTRAIT = 0;
    public static final int DEFAULT_CLIP_IMAGE_MAX_SIDE_LENGTH = 1000;
    public static final int DEFAULT_UPLOAD_IMAGE_MAX_SIZE = 512;
    public static String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_PARAM_FROM_BUSINESS = "extra_business_from";
    public static final String EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE = "extra_upload_image_max_size";
    protected static final int INVALID_ANIM = 0;
    public static final int UPLOAD_IMAGE_HEIGHT = 160;
    public static final int UPLOAD_IMAGE_WIDTH = 160;
    private static final String a = "ImageClipActivity";
    private static final String b = "com.android.providers.media.documents";
    private static final String c = "com.android.providers.downloads.documents";
    private static final String d = "com.android.externalstorage.documents";
    private static final String e = "content://downloads/public_downloads";
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j;
    private int k;
    private String l;
    private ClipBoxView m;
    private ZoomImageView n;

    private void d() {
        if (this.h == 0 && this.i == 0) {
            return;
        }
        overridePendingTransition(this.h, this.i);
        this.h = 0;
        this.i = 0;
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
    protected void onDestroy() {
        super.onDestroy();
        ClipBoxView.a();
        ZoomImageView.a();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c();
    }

    protected void setPendingTransition(int i, int i2, int i3, int i4) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(3)
    public void a() {
        Bitmap b2 = ZoomImageView.getInstance() == null ? null : ZoomImageView.getInstance().b();
        if (b2 == null || b2.isRecycled()) {
            return;
        }
        new AsyncTask<Bitmap, Void, byte[]>() { // from class: com.baidu.sapi2.activity.ImageClipActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public byte[] doInBackground(Bitmap... bitmapArr) {
                int i;
                int i2 = 160;
                if (bitmapArr[0] != null && !bitmapArr[0].isRecycled()) {
                    if (ImageClipActivity.this.j != 0) {
                        i = bitmapArr[0].getWidth();
                        i2 = bitmapArr[0].getHeight();
                    } else {
                        i = 160;
                    }
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapArr[0], i, i2, true);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int i3 = 100;
                    createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    while (byteArrayOutputStream.toByteArray().length > ImageClipActivity.this.k && i3 > 0 && i3 - 5 > 0) {
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
        }.execute(b2);
    }

    private void b() {
        setContentView(a.f.layout_sapi_sdk_image_clip);
        this.j = getIntent().getIntExtra(EXTRA_PARAM_FROM_BUSINESS, 0);
        this.k = getIntent().getIntExtra(EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, 512);
        if (this.k <= 0) {
            this.k = 512;
        }
        this.k *= 1024;
        this.m = (ClipBoxView) findViewById(a.e.sapi_clip_box);
        this.n = (ZoomImageView) findViewById(a.e.sapi_background_picture);
        if (this.j == 1) {
            ClipBoxView clipBoxView = this.m;
            clipBoxView.aa = ClipBoxView.a;
            clipBoxView.ba = false;
        }
        setPendingTransition(a.C0090a.sapi_sdk_slide_right_in, a.C0090a.sapi_sdk_slide_left_out, a.C0090a.sapi_sdk_slide_left_in, a.C0090a.sapi_sdk_slide_right_out);
        Button button = (Button) findViewById(a.e.sure_clip_btn);
        Button button2 = (Button) findViewById(a.e.cancel_clip_btn);
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
        if (this.f == 0 && this.g == 0) {
            return;
        }
        overridePendingTransition(this.f, this.g);
        this.f = 0;
        this.g = 0;
    }

    private void a(Intent intent) {
        b(a(intent.getData(), (String) null));
    }

    private String a(Uri uri, String str) {
        String str2 = null;
        Cursor query = getContentResolver().query(uri, null, str, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                if (query.getColumnIndex("_data") > -1) {
                    str2 = query.getString(query.getColumnIndex("_data"));
                } else {
                    str2 = a(getBaseContext(), uri);
                    this.l = str2;
                }
            }
            query.close();
        }
        return str2;
    }

    @TargetApi(12)
    private Bitmap a(String str) {
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

    @TargetApi(19)
    private void b(Intent intent) {
        String[] split;
        String str = null;
        Uri data = intent.getData();
        if (DocumentsContract.isDocumentUri(this, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if (b.equals(data.getAuthority())) {
                str = a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
            } else if (c.equals(data.getAuthority())) {
                str = a(ContentUris.withAppendedId(Uri.parse(e), Long.valueOf(documentId).longValue()), (String) null);
            } else if (d.equals(data.getAuthority())) {
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
            if (openInputStream != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                com.baidu.sapi2.utils.a.a(openInputStream, fileOutputStream);
                openInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    private void b(String str) {
        Bitmap a2 = a(str);
        if (a2 != null) {
            this.n.setImageBitmap(a2);
            if (!TextUtils.isEmpty(this.l)) {
                com.baidu.sapi2.utils.a.a(new File(this.l));
                return;
            }
            return;
        }
        Toast.makeText(this, "加载图片失败", 0).show();
    }
}
