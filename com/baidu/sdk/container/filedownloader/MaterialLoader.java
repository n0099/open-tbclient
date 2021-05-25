package com.baidu.sdk.container.filedownloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import d.a.f0.a.c.a;
import d.a.f0.a.h.a;
import io.reactivex.annotations.SchedulerSupport;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class MaterialLoader {

    /* renamed from: c  reason: collision with root package name */
    public static volatile MaterialLoader f9922c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f9923d = "MaterialLoader";

    /* renamed from: a  reason: collision with root package name */
    public Context f9924a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.f0.a.e.a f9925b = new a(this);

    /* loaded from: classes2.dex */
    public enum MaterialCacheType {
        PICTURE("normal"),
        VIDEO("video"),
        CUSTOM(SchedulerSupport.CUSTOM);
        
        public final String value;

        MaterialCacheType(String str) {
            this.value = str;
        }

        public static MaterialCacheType parse(String str) {
            MaterialCacheType[] values;
            for (MaterialCacheType materialCacheType : values()) {
                if (materialCacheType.value.equalsIgnoreCase(str)) {
                    return materialCacheType;
                }
            }
            return null;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements d.a.f0.a.e.a {
        public a(MaterialLoader materialLoader) {
        }

        @Override // d.a.f0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
        }

        @Override // d.a.f0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }

        @Override // d.a.f0.a.e.a
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f9926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f9927f;

        public b(MaterialLoader materialLoader, ImageView imageView, Bitmap bitmap) {
            this.f9926e = imageView;
            this.f9927f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9926e.setImageBitmap(this.f9927f);
            this.f9926e.setBackgroundResource(17170445);
            this.f9926e.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MaterialCacheType f9928a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9929b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f9930c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f9931d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.f0.a.e.a f9932e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ImageView f9933f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f9934g;

        /* loaded from: classes2.dex */
        public class a implements a.c {
            public a() {
            }

            @Override // d.a.f0.a.c.a.c
            public void onCacheComplete() {
                c cVar = c.this;
                cVar.f9932e.onLoadingComplete(cVar.f9929b, null, null);
            }

            @Override // d.a.f0.a.c.a.c
            public void onCacheFailed() {
                c cVar = c.this;
                cVar.f9932e.a(cVar.f9929b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements a.c {
            public b() {
            }

            @Override // d.a.f0.a.c.a.c
            public void onCacheComplete() {
                c cVar = c.this;
                cVar.f9932e.onLoadingComplete(cVar.f9929b, null, null);
            }

            @Override // d.a.f0.a.c.a.c
            public void onCacheFailed() {
                c cVar = c.this;
                cVar.f9932e.a(cVar.f9929b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
            }
        }

        /* renamed from: com.baidu.sdk.container.filedownloader.MaterialLoader$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0129c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f9938e;

            public RunnableC0129c(Bitmap bitmap) {
                this.f9938e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = c.this.f9933f;
                if (imageView != null) {
                    imageView.setImageBitmap(this.f9938e);
                    c.this.f9933f.setBackgroundResource(17170445);
                    c.this.f9933f.setVisibility(0);
                }
            }
        }

        public c(MaterialCacheType materialCacheType, String str, String str2, int i2, d.a.f0.a.e.a aVar, ImageView imageView, boolean z) {
            this.f9928a = materialCacheType;
            this.f9929b = str;
            this.f9930c = str2;
            this.f9931d = i2;
            this.f9932e = aVar;
            this.f9933f = imageView;
            this.f9934g = z;
        }

        @Override // d.a.f0.a.h.a.c
        public void onFail(String str, int i2) {
            String str2 = MaterialLoader.f9923d;
            Log.e(str2, "素材请求失败，onFail: " + str);
            this.f9932e.a(this.f9929b, this.f9933f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
        }

        @Override // d.a.f0.a.h.a.c
        public void onSuccess(InputStream inputStream, String str) {
            try {
                if (inputStream != null) {
                    if (this.f9928a != MaterialCacheType.VIDEO && !MaterialLoader.this.p(this.f9929b)) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPurgeable = true;
                        options.inInputShareable = true;
                        Bitmap decodeStream = BitmapFactory.decodeStream(new d(inputStream), null, options);
                        if (decodeStream != null) {
                            Bitmap r = !this.f9929b.substring(this.f9929b.lastIndexOf("/") + 1).toUpperCase().contains("PNG") ? MaterialLoader.r(MaterialLoader.s(decodeStream, 100 - (MaterialLoader.this.t(decodeStream) * 10)), MaterialLoader.v(options)) : decodeStream;
                            if (r != null) {
                                decodeStream = r;
                            }
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                if (this.f9933f != null) {
                                    this.f9933f.setImageBitmap(decodeStream);
                                    this.f9933f.setBackgroundResource(17170445);
                                    this.f9933f.setVisibility(0);
                                }
                            } else {
                                new Handler(Looper.getMainLooper()).post(new RunnableC0129c(decodeStream));
                            }
                            MaterialLoader.this.y(decodeStream, this.f9929b, this.f9934g);
                            this.f9932e.onLoadingComplete(this.f9929b, this.f9933f, decodeStream);
                            if (inputStream != null) {
                                inputStream.close();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (TextUtils.isEmpty(this.f9930c) || this.f9931d <= 0) {
                            MaterialLoader.this.w(byteArrayOutputStream.toByteArray(), this.f9929b, new b());
                        } else {
                            MaterialLoader.this.x(byteArrayOutputStream.toByteArray(), this.f9929b, this.f9930c, this.f9931d, new a());
                        }
                        byteArrayOutputStream.flush();
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    byteArrayOutputStream.close();
                    return;
                }
                Log.e(MaterialLoader.f9923d, "素材请求失败，无数据流");
                this.f9932e.a(this.f9929b, this.f9933f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
            } catch (OutOfMemoryError unused) {
                Log.e(MaterialLoader.f9923d, "素材请求失败，OOM");
                this.f9932e.a(this.f9929b, this.f9933f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
            } catch (Throwable unused2) {
                Log.e(MaterialLoader.f9923d, "素材请求失败，解析异常");
                this.f9932e.a(this.f9929b, this.f9933f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends FilterInputStream {
        public d(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                long skip = ((FilterInputStream) this).in.skip(j - j2);
                if (skip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    skip = 1;
                }
                j2 += skip;
            }
            return j2;
        }
    }

    public MaterialLoader(Context context) {
        this.f9924a = context.getApplicationContext();
    }

    public static int j(Bitmap bitmap) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (i2 >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static MaterialLoader k(Context context) {
        if (f9922c == null) {
            synchronized (MaterialLoader.class) {
                if (f9922c == null) {
                    f9922c = new MaterialLoader(context);
                }
            }
        }
        return f9922c;
    }

    public static Bitmap r(Bitmap bitmap, int i2) {
        if (i2 <= 1) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float f2 = 1.0f / i2;
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap s(Bitmap bitmap, int i2) {
        if (i2 == 100) {
            return bitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        try {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (byteArray != null) {
                return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int v(BitmapFactory.Options options) {
        int i2;
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 > 1140 || i4 > 1140) {
            int i5 = 2;
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (true) {
                if (i6 < 1140 && i7 < 1140) {
                    break;
                }
                i5 *= 2;
            }
            i2 = i5;
        } else {
            i2 = 1;
        }
        if (i2 > 6) {
            return 6;
        }
        return i2;
    }

    public void e(String str, MaterialCacheType materialCacheType, d.a.f0.a.e.a aVar) {
        if (aVar == null) {
            aVar = this.f9925b;
        }
        if (o(str, materialCacheType)) {
            aVar.onLoadingComplete(str, null, materialCacheType == MaterialCacheType.PICTURE ? u(str) : null);
        } else {
            g(str, null, materialCacheType, aVar);
        }
    }

    public void f(String str, d.a.f0.a.e.a aVar) {
        if (p(str)) {
            e(str, MaterialCacheType.VIDEO, aVar);
        } else {
            e(str, MaterialCacheType.PICTURE, aVar);
        }
    }

    public final void g(String str, ImageView imageView, MaterialCacheType materialCacheType, d.a.f0.a.e.a aVar) {
        h(str, imageView, materialCacheType, false, null, 0, aVar);
    }

    public final void h(String str, ImageView imageView, MaterialCacheType materialCacheType, boolean z, String str2, int i2, d.a.f0.a.e.a aVar) {
        d.a.f0.a.h.a aVar2 = new d.a.f0.a.h.a(1, str);
        aVar2.c(new c(materialCacheType, str, str2, i2, aVar, imageView, z));
        aVar2.d();
    }

    public Bitmap i(String str, d.a.f0.a.e.a aVar) {
        if (aVar == null) {
            aVar = this.f9925b;
        }
        if (n(str)) {
            return u(str);
        }
        g(str, null, MaterialCacheType.PICTURE, aVar);
        return null;
    }

    public String l(String str) {
        if (!p(str)) {
            return m(str, MaterialCacheType.PICTURE);
        }
        return m(str, MaterialCacheType.VIDEO);
    }

    public String m(String str, MaterialCacheType materialCacheType) {
        return d.a.f0.a.c.a.e(this.f9924a).d(str, materialCacheType);
    }

    public boolean n(String str) {
        if (p(str)) {
            return o(str, MaterialCacheType.VIDEO);
        }
        return o(str, MaterialCacheType.PICTURE);
    }

    public boolean o(String str, MaterialCacheType materialCacheType) {
        return d.a.f0.a.c.a.e(this.f9924a).f(str, materialCacheType);
    }

    public boolean p(String str) {
        return str.indexOf(".mp4") > 0 || str.indexOf(".gif") > 0;
    }

    public void q(ImageView imageView, String str, d.a.f0.a.e.a aVar) {
        if (aVar == null) {
            try {
                aVar = this.f9925b;
            } catch (Throwable unused) {
                aVar.a(str, imageView, MaterialLoadErrorCode.ERROR_CODE_PARSE_ERROR);
                return;
            }
        }
        aVar.onLoadingStarted(str, imageView);
        if (TextUtils.isEmpty(str)) {
            aVar.a(str, imageView, MaterialLoadErrorCode.ERROR_CODE_URL_NULL);
        } else if (imageView == null) {
            aVar.a(str, imageView, MaterialLoadErrorCode.ERROR_CODE_VIEW_NULL);
        } else {
            Bitmap u = u(str);
            if (u == null) {
                g(str, imageView, MaterialCacheType.PICTURE, aVar);
                return;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                imageView.setImageBitmap(u);
                imageView.setBackgroundResource(17170445);
                imageView.setVisibility(0);
            } else {
                new Handler(Looper.getMainLooper()).post(new b(this, imageView, u));
            }
            aVar.onLoadingComplete(str, imageView, u);
        }
    }

    public int t(Bitmap bitmap) {
        int j = j(bitmap);
        if (j > 2457600) {
            int i2 = j / com.baidu.mobads.container.util.filedownloader.MaterialLoader.MAX_IMAGE_SIZE;
            if (i2 > 6) {
                return 6;
            }
            return i2;
        }
        return 0;
    }

    public final Bitmap u(String str) {
        return d.a.f0.a.c.a.e(this.f9924a).j(str);
    }

    public final void w(byte[] bArr, String str, a.c cVar) {
        d.a.f0.a.c.a.e(this.f9924a).n(str, bArr, MaterialCacheType.VIDEO, false, cVar);
    }

    public final void x(byte[] bArr, String str, String str2, int i2, a.c cVar) {
        d.a.f0.a.c.a.e(this.f9924a).o(str, bArr, str2, i2, false, cVar);
    }

    public final void y(Bitmap bitmap, String str, boolean z) {
        d.a.f0.a.c.a.e(this.f9924a).l(str, bitmap, z);
    }
}
