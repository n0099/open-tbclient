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
import androidx.core.view.InputDeviceCompat;
import c.a.e0.a.a;
import c.a.e0.a.e;
import c.a.e0.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.ZoomImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public class ImageClipActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUSSINESS_FROM_INVOICE_BUILD = 1;
    public static final int BUSSINESS_ID_CARD_OCR = 2;
    public static final int BUSSINESS_SET_PORTRAIT = 0;
    public static final int DEFAULT_CLIP_IMAGE_MAX_SIDE_LENGTH = 1000;
    public static final int DEFAULT_UPLOAD_IMAGE_MAX_SIZE = 512;
    public static String EXTRA_IMAGE = null;
    public static final String EXTRA_PARAM_FROM_BUSINESS = "extra_business_from";
    public static final String EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE = "extra_upload_image_max_size";
    public static final int INVALID_ANIM = 0;
    public static final int UPLOAD_IMAGE_HEIGHT = 160;
    public static final int UPLOAD_IMAGE_WIDTH = 160;

    /* renamed from: j  reason: collision with root package name */
    public static final String f39153j;

    /* renamed from: k  reason: collision with root package name */
    public static final String f39154k = "com.android.providers.media.documents";
    public static final String l = "com.android.providers.downloads.documents";
    public static final String m = "com.android.externalstorage.documents";
    public static final String n = "content://downloads/public_downloads";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f39155b;

    /* renamed from: c  reason: collision with root package name */
    public int f39156c;

    /* renamed from: d  reason: collision with root package name */
    public int f39157d;

    /* renamed from: e  reason: collision with root package name */
    public int f39158e;

    /* renamed from: f  reason: collision with root package name */
    public int f39159f;

    /* renamed from: g  reason: collision with root package name */
    public String f39160g;

    /* renamed from: h  reason: collision with root package name */
    public ClipBoxView f39161h;

    /* renamed from: i  reason: collision with root package name */
    public ZoomImageView f39162i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1021222415, "Lcom/baidu/sapi2/activity/ImageClipActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1021222415, "Lcom/baidu/sapi2/activity/ImageClipActivity;");
                return;
            }
        }
        f39153j = ImageClipActivity.class.getSimpleName();
        EXTRA_IMAGE = "extra_image";
    }

    public ImageClipActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f39155b = 0;
        this.f39156c = 0;
        this.f39157d = 0;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (this.f39156c == 0 && this.f39157d == 0) {
                return;
            }
            overridePendingTransition(this.f39156c, this.f39157d);
            this.f39156c = 0;
            this.f39157d = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            d();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            c();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            b();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            ClipBoxView.b();
            ZoomImageView.c();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            super.onNewIntent(intent);
            c();
        }
    }

    public Bitmap operateBitmap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Bitmap a = a(str);
            if (a == null) {
                return null;
            }
            float f2 = 0.0f;
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
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
            matrix.setRotate(f2, a.getWidth() / 2, a.getHeight() / 2);
            return Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    public void setPendingTransition(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            this.a = i2;
            this.f39155b = i3;
            this.f39156c = i4;
            this.f39157d = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(3)
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            Bitmap a = ZoomImageView.getInstance() == null ? null : ZoomImageView.getInstance().a();
            if (a == null || a.isRecycled()) {
                return;
            }
            new AsyncTask<Bitmap, Void, byte[]>(this) { // from class: com.baidu.sapi2.activity.ImageClipActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageClipActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public byte[] doInBackground(Bitmap... bitmapArr) {
                    InterceptResult invokeL;
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmapArr)) == null) {
                        if (bitmapArr[0] == null || bitmapArr[0].isRecycled()) {
                            return null;
                        }
                        int i3 = 160;
                        if (this.a.f39158e != 0) {
                            i3 = bitmapArr[0].getWidth();
                            i2 = bitmapArr[0].getHeight();
                        } else {
                            i2 = 160;
                        }
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapArr[0], i3, i2, true);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int i4 = 100;
                        createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        while (byteArrayOutputStream.toByteArray().length > this.a.f39159f && i4 > 0 && i4 - 5 > 0) {
                            byteArrayOutputStream.reset();
                            createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                        }
                        if (createScaledBitmap != bitmapArr[0]) {
                            createScaledBitmap.recycle();
                        }
                        bitmapArr[0].recycle();
                        return byteArrayOutputStream.toByteArray();
                    }
                    return (byte[]) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public void onPostExecute(byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, bArr) == null) {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray(ImageClipActivity.EXTRA_IMAGE, bArr);
                        intent.putExtras(bundle);
                        this.a.setResult(-1, intent);
                        this.a.finish();
                    }
                }
            }.execute(a);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            setContentView(f.layout_sapi_sdk_image_clip);
            this.f39158e = getIntent().getIntExtra(EXTRA_PARAM_FROM_BUSINESS, 0);
            int intExtra = getIntent().getIntExtra(EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, 512);
            this.f39159f = intExtra;
            if (intExtra <= 0) {
                this.f39159f = 512;
            }
            this.f39159f *= 1024;
            this.f39161h = (ClipBoxView) findViewById(e.sapi_clip_box);
            this.f39162i = (ZoomImageView) findViewById(e.sapi_background_picture);
            if (this.f39158e == 1) {
                ClipBoxView clipBoxView = this.f39161h;
                clipBoxView.E = ClipBoxView.G;
                clipBoxView.F = false;
            }
            if (this.f39158e == 2) {
                ClipBoxView clipBoxView2 = this.f39161h;
                clipBoxView2.E = ClipBoxView.G;
                clipBoxView2.F = false;
            }
            setPendingTransition(a.sapi_sdk_slide_right_in, a.sapi_sdk_slide_left_out, a.sapi_sdk_slide_left_in, a.sapi_sdk_slide_right_out);
            Button button = (Button) findViewById(e.sure_clip_btn);
            Button button2 = (Button) findViewById(e.cancel_clip_btn);
            if (Build.VERSION.SDK_INT >= 19) {
                b(getIntent());
            } else {
                a(getIntent());
            }
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.ImageClipActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageClipActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.setResult(0);
                        this.a.finish();
                    }
                }
            });
            button.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.ImageClipActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageClipActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.a();
                    }
                }
            });
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (this.a == 0 && this.f39155b == 0) {
                return;
            }
            overridePendingTransition(this.a, this.f39155b);
            this.a = 0;
            this.f39155b = 0;
        }
    }

    private void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, intent) == null) {
            b(a(intent.getData(), (String) null));
        }
    }

    private String a(Uri uri, String str) {
        InterceptResult invokeLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, uri, str)) == null) {
            Cursor query = getContentResolver().query(uri, null, str, null, null);
            String str2 = null;
            if (query != null) {
                if (query.moveToFirst()) {
                    if (query.getColumnIndex("_data") > -1) {
                        a = query.getString(query.getColumnIndex("_data"));
                    } else {
                        a = a(getBaseContext(), uri);
                        this.f39160g = a;
                    }
                    str2 = a;
                }
                query.close();
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    @TargetApi(12)
    private Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (str != null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i2 = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i3 = options.outHeight;
                int i4 = options.outWidth;
                if (i4 > i3) {
                    i3 = i4;
                }
                while (i3 / i2 > 1000) {
                    i2++;
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = i2;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                return BitmapFactory.decodeFile(str, options);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    @TargetApi(19)
    private void b(Intent intent) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, intent) == null) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                if (DocumentsContract.isDocumentUri(this, data)) {
                    String documentId = DocumentsContract.getDocumentId(data);
                    if (f39154k.equals(data.getAuthority())) {
                        str = a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
                    } else if (l.equals(data.getAuthority())) {
                        str = a(ContentUris.withAppendedId(Uri.parse(n), Long.valueOf(documentId).longValue()), (String) null);
                    } else if (m.equals(data.getAuthority())) {
                        if ("primary".equalsIgnoreCase(documentId.split(":")[0])) {
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
    }

    private String a(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, uri)) == null) {
            String a = a(uri);
            if (TextUtils.isEmpty(a)) {
                return null;
            }
            File file = new File(context.getExternalCacheDir().getPath() + File.separator + "pass_temp_" + a);
            a(context, uri, file);
            return file.getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    private String a(Uri uri) {
        InterceptResult invokeL;
        String path;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, uri)) == null) {
            if (uri == null || (lastIndexOf = (path = uri.getPath()).lastIndexOf(47)) == -1) {
                return null;
            }
            return path.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    private void a(Context context, Uri uri, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, context, uri, file) == null) {
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                if (openInputStream == null) {
                    return;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                FileUtil.copy(openInputStream, fileOutputStream);
                openInputStream.close();
                fileOutputStream.close();
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            Bitmap operateBitmap = operateBitmap(str);
            if (operateBitmap != null) {
                this.f39162i.setImageBitmap(operateBitmap);
                if (TextUtils.isEmpty(this.f39160g)) {
                    return;
                }
                FileUtil.deleteFile(new File(this.f39160g));
                return;
            }
            Toast.makeText(this, "加载图片失败", 0).show();
        }
    }
}
