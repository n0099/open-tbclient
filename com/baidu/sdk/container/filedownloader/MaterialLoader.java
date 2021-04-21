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
import d.b.d0.a.c.a;
import d.b.d0.a.h.a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class MaterialLoader {

    /* renamed from: c  reason: collision with root package name */
    public static volatile MaterialLoader f11177c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f11178d = "MaterialLoader";

    /* renamed from: a  reason: collision with root package name */
    public Context f11179a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.d0.a.e.a f11180b = new a(this);

    /* loaded from: classes2.dex */
    public enum MaterialCacheType {
        PICTURE("normal"),
        VIDEO("video"),
        CUSTOM("custom");
        
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
    public class a implements d.b.d0.a.e.a {
        public a(MaterialLoader materialLoader) {
        }

        @Override // d.b.d0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
        }

        @Override // d.b.d0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }

        @Override // d.b.d0.a.e.a
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f11181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f11182f;

        public b(MaterialLoader materialLoader, ImageView imageView, Bitmap bitmap) {
            this.f11181e = imageView;
            this.f11182f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11181e.setImageBitmap(this.f11182f);
            this.f11181e.setBackgroundResource(17170445);
            this.f11181e.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MaterialCacheType f11183a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11184b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f11185c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f11186d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.d0.a.e.a f11187e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ImageView f11188f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f11189g;

        /* loaded from: classes2.dex */
        public class a implements a.c {
            public a() {
            }

            @Override // d.b.d0.a.c.a.c
            public void onCacheComplete() {
                c cVar = c.this;
                cVar.f11187e.onLoadingComplete(cVar.f11184b, null, null);
            }

            @Override // d.b.d0.a.c.a.c
            public void onCacheFailed() {
                c cVar = c.this;
                cVar.f11187e.a(cVar.f11184b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements a.c {
            public b() {
            }

            @Override // d.b.d0.a.c.a.c
            public void onCacheComplete() {
                c cVar = c.this;
                cVar.f11187e.onLoadingComplete(cVar.f11184b, null, null);
            }

            @Override // d.b.d0.a.c.a.c
            public void onCacheFailed() {
                c cVar = c.this;
                cVar.f11187e.a(cVar.f11184b, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
            }
        }

        /* renamed from: com.baidu.sdk.container.filedownloader.MaterialLoader$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0149c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f11193e;

            public RunnableC0149c(Bitmap bitmap) {
                this.f11193e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = c.this.f11188f;
                if (imageView != null) {
                    imageView.setImageBitmap(this.f11193e);
                    c.this.f11188f.setBackgroundResource(17170445);
                    c.this.f11188f.setVisibility(0);
                }
            }
        }

        public c(MaterialCacheType materialCacheType, String str, String str2, int i, d.b.d0.a.e.a aVar, ImageView imageView, boolean z) {
            this.f11183a = materialCacheType;
            this.f11184b = str;
            this.f11185c = str2;
            this.f11186d = i;
            this.f11187e = aVar;
            this.f11188f = imageView;
            this.f11189g = z;
        }

        @Override // d.b.d0.a.h.a.c
        public void onFail(String str, int i) {
            String str2 = MaterialLoader.f11178d;
            Log.e(str2, "素材请求失败，onFail: " + str);
            this.f11187e.a(this.f11184b, this.f11188f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
        }

        @Override // d.b.d0.a.h.a.c
        public void onSuccess(InputStream inputStream, String str) {
            try {
                if (inputStream != null) {
                    if (this.f11183a != MaterialCacheType.VIDEO && !MaterialLoader.this.p(this.f11184b)) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPurgeable = true;
                        options.inInputShareable = true;
                        Bitmap decodeStream = BitmapFactory.decodeStream(new d(inputStream), null, options);
                        if (decodeStream != null) {
                            Bitmap r = !this.f11184b.substring(this.f11184b.lastIndexOf("/") + 1).toUpperCase().contains("PNG") ? MaterialLoader.r(MaterialLoader.s(decodeStream, 100 - (MaterialLoader.this.t(decodeStream) * 10)), MaterialLoader.v(options)) : decodeStream;
                            if (r != null) {
                                decodeStream = r;
                            }
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                if (this.f11188f != null) {
                                    this.f11188f.setImageBitmap(decodeStream);
                                    this.f11188f.setBackgroundResource(17170445);
                                    this.f11188f.setVisibility(0);
                                }
                            } else {
                                new Handler(Looper.getMainLooper()).post(new RunnableC0149c(decodeStream));
                            }
                            MaterialLoader.this.y(decodeStream, this.f11184b, this.f11189g);
                            this.f11187e.onLoadingComplete(this.f11184b, this.f11188f, decodeStream);
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
                        if (TextUtils.isEmpty(this.f11185c) || this.f11186d <= 0) {
                            MaterialLoader.this.w(byteArrayOutputStream.toByteArray(), this.f11184b, new b());
                        } else {
                            MaterialLoader.this.x(byteArrayOutputStream.toByteArray(), this.f11184b, this.f11185c, this.f11186d, new a());
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
                Log.e(MaterialLoader.f11178d, "素材请求失败，无数据流");
                this.f11187e.a(this.f11184b, this.f11188f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
            } catch (OutOfMemoryError unused) {
                Log.e(MaterialLoader.f11178d, "素材请求失败，OOM");
                this.f11187e.a(this.f11184b, this.f11188f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
            } catch (Throwable unused2) {
                Log.e(MaterialLoader.f11178d, "素材请求失败，解析异常");
                this.f11187e.a(this.f11184b, this.f11188f, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
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
        this.f11179a = context.getApplicationContext();
    }

    public static int j(Bitmap bitmap) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (i >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static MaterialLoader k(Context context) {
        if (f11177c == null) {
            synchronized (MaterialLoader.class) {
                if (f11177c == null) {
                    f11177c = new MaterialLoader(context);
                }
            }
        }
        return f11177c;
    }

    public static Bitmap r(Bitmap bitmap, int i) {
        if (i <= 1) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float f2 = 1.0f / i;
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap s(Bitmap bitmap, int i) {
        if (i == 100) {
            return bitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
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
        int i;
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 > 1140 || i3 > 1140) {
            int i4 = 2;
            int i5 = i2 / 2;
            int i6 = i3 / 2;
            while (true) {
                if (i5 < 1140 && i6 < 1140) {
                    break;
                }
                i4 *= 2;
            }
            i = i4;
        } else {
            i = 1;
        }
        if (i > 6) {
            return 6;
        }
        return i;
    }

    public void e(String str, MaterialCacheType materialCacheType, d.b.d0.a.e.a aVar) {
        if (aVar == null) {
            aVar = this.f11180b;
        }
        if (o(str, materialCacheType)) {
            aVar.onLoadingComplete(str, null, materialCacheType == MaterialCacheType.PICTURE ? u(str) : null);
        } else {
            g(str, null, materialCacheType, aVar);
        }
    }

    public void f(String str, d.b.d0.a.e.a aVar) {
        if (p(str)) {
            e(str, MaterialCacheType.VIDEO, aVar);
        } else {
            e(str, MaterialCacheType.PICTURE, aVar);
        }
    }

    public final void g(String str, ImageView imageView, MaterialCacheType materialCacheType, d.b.d0.a.e.a aVar) {
        h(str, imageView, materialCacheType, false, null, 0, aVar);
    }

    public final void h(String str, ImageView imageView, MaterialCacheType materialCacheType, boolean z, String str2, int i, d.b.d0.a.e.a aVar) {
        d.b.d0.a.h.a aVar2 = new d.b.d0.a.h.a(1, str);
        aVar2.c(new c(materialCacheType, str, str2, i, aVar, imageView, z));
        aVar2.d();
    }

    public Bitmap i(String str, d.b.d0.a.e.a aVar) {
        if (aVar == null) {
            aVar = this.f11180b;
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
        return d.b.d0.a.c.a.e(this.f11179a).d(str, materialCacheType);
    }

    public boolean n(String str) {
        if (p(str)) {
            return o(str, MaterialCacheType.VIDEO);
        }
        return o(str, MaterialCacheType.PICTURE);
    }

    public boolean o(String str, MaterialCacheType materialCacheType) {
        return d.b.d0.a.c.a.e(this.f11179a).f(str, materialCacheType);
    }

    public boolean p(String str) {
        return str.indexOf(".mp4") > 0 || str.indexOf(".gif") > 0;
    }

    public void q(ImageView imageView, String str, d.b.d0.a.e.a aVar) {
        if (aVar == null) {
            try {
                aVar = this.f11180b;
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
            int i = j / com.baidu.mobads.container.util.filedownloader.MaterialLoader.MAX_IMAGE_SIZE;
            if (i > 6) {
                return 6;
            }
            return i;
        }
        return 0;
    }

    public final Bitmap u(String str) {
        return d.b.d0.a.c.a.e(this.f11179a).j(str);
    }

    public final void w(byte[] bArr, String str, a.c cVar) {
        d.b.d0.a.c.a.e(this.f11179a).n(str, bArr, MaterialCacheType.VIDEO, false, cVar);
    }

    public final void x(byte[] bArr, String str, String str2, int i, a.c cVar) {
        d.b.d0.a.c.a.e(this.f11179a).o(str, bArr, str2, i, false, cVar);
    }

    public final void y(Bitmap bitmap, String str, boolean z) {
        d.b.d0.a.c.a.e(this.f11179a).l(str, bitmap, z);
    }
}
