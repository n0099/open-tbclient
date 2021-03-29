package com.baidu.mobads.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observer;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f8170b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public static a f8171c;

    /* renamed from: a  reason: collision with root package name */
    public LruCache<String, Bitmap> f8172a = new b(this, ((int) Runtime.getRuntime().maxMemory()) / 32);

    /* renamed from: com.baidu.mobads.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0105a {

        /* renamed from: a  reason: collision with root package name */
        public int f8173a;

        /* renamed from: b  reason: collision with root package name */
        public int f8174b;

        public C0105a() {
        }

        public /* synthetic */ C0105a(b bVar) {
            this();
        }
    }

    private Bitmap c(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static String d(String str) {
        return XAdSDKFoundationFacade.getInstance().getIoUtils().getStoreagePath(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }

    public static String e(String str) {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(str);
    }

    private void b(String str, Observer observer) {
        Context applicationContext = XAdSDKFoundationFacade.getInstance().getApplicationContext();
        try {
            URL url = new URL(str);
            String d2 = d(str);
            com.baidu.mobads.openad.download.b bVar = new com.baidu.mobads.openad.download.b(applicationContext, url, d2, e(str) + ".temp", true);
            bVar.addObserver(observer);
            bVar.start();
        } catch (MalformedURLException unused) {
        }
    }

    public static a a() {
        if (f8171c == null) {
            synchronized (a.class) {
                if (f8171c == null) {
                    f8171c = new a();
                }
            }
        }
        return f8171c;
    }

    public static String b(String str) {
        String storeagePath = XAdSDKFoundationFacade.getInstance().getIoUtils().getStoreagePath(XAdSDKFoundationFacade.getInstance().getApplicationContext());
        String md5 = XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(str);
        return storeagePath + md5 + ".temp";
    }

    public void a(ImageView imageView, String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalThreadStateException("please invoke in main thread!");
        }
        if (imageView == null || str == null) {
            return;
        }
        Bitmap bitmap = this.f8172a.get(str);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        Bitmap a2 = a(b(str), imageView, true);
        if (a2 != null) {
            a(str, a2);
        } else {
            b(str, new c(this, str, imageView));
        }
    }

    public void a(String str, Observer observer) {
        if (str == null || observer == null) {
            return;
        }
        try {
            b(str, observer);
        } catch (Throwable unused) {
        }
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str) || this.f8172a.get(str) != null) {
            return false;
        }
        Bitmap c2 = c(b(str));
        if (c2 == null) {
            return true;
        }
        a(str, c2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Bitmap bitmap) {
        if (this.f8172a.get(str) != null || str == null || bitmap == null) {
            return;
        }
        this.f8172a.put(str, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(String str, ImageView imageView, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        a(imageView);
        options.inSampleSize = a(options, imageView);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (z) {
            imageView.setImageBitmap(decodeFile);
        }
        return decodeFile;
    }

    public static int a(BitmapFactory.Options options, ImageView imageView) {
        C0105a a2 = a(imageView);
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i > a2.f8173a || i2 > a2.f8174b) {
            return Math.max(Math.round((i * 1.0f) / a2.f8173a), Math.round((i2 * 1.0f) / a2.f8174b));
        }
        return 1;
    }

    public static C0105a a(ImageView imageView) {
        C0105a c0105a = new C0105a(null);
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = imageView.getMaxWidth();
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = imageView.getHeight();
        if (height <= 0) {
            height = layoutParams.height;
        }
        if (height <= 0) {
            height = imageView.getMaxHeight();
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        c0105a.f8173a = width;
        c0105a.f8174b = height;
        return c0105a;
    }
}
