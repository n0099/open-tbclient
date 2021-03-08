package com.baidu.mobads.c;

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
/* loaded from: classes4.dex */
public class a {
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static a c;

    /* renamed from: a  reason: collision with root package name */
    private LruCache<String, Bitmap> f2360a = new b(this, ((int) Runtime.getRuntime().maxMemory()) / 32);

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private a() {
    }

    public void a(ImageView imageView, String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalThreadStateException("please invoke in main thread!");
        }
        if (imageView != null && str != null) {
            Bitmap bitmap = this.f2360a.get(str);
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
    }

    public void a(String str, Observer observer) {
        if (str != null && observer != null) {
            try {
                b(str, observer);
            } catch (Throwable th) {
            }
        }
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str) && this.f2360a.get(str) == null) {
            Bitmap c2 = c(b(str));
            if (c2 == null) {
                return true;
            }
            a(str, c2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Bitmap bitmap) {
        if (this.f2360a.get(str) == null && str != null && bitmap != null) {
            this.f2360a.put(str, bitmap);
        }
    }

    private void b(String str, Observer observer) {
        try {
            com.baidu.mobads.openad.download.b bVar = new com.baidu.mobads.openad.download.b(XAdSDKFoundationFacade.getInstance().getApplicationContext(), new URL(str), d(str), e(str) + ".temp", true);
            bVar.addObserver(observer);
            bVar.start();
        } catch (MalformedURLException e) {
        }
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

    private Bitmap c(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private static int a(BitmapFactory.Options options, ImageView imageView) {
        C0268a a2 = a(imageView);
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i <= a2.f2361a && i2 <= a2.b) {
            return 1;
        }
        return Math.max(Math.round((i * 1.0f) / a2.f2361a), Math.round((i2 * 1.0f) / a2.b));
    }

    private static C0268a a(ImageView imageView) {
        C0268a c0268a = new C0268a(null);
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
        c0268a.f2361a = width;
        c0268a.b = height;
        return c0268a;
    }

    public static String b(String str) {
        String storeagePath = XAdSDKFoundationFacade.getInstance().getIoUtils().getStoreagePath(XAdSDKFoundationFacade.getInstance().getApplicationContext());
        return storeagePath + XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(str) + ".temp";
    }

    private static String d(String str) {
        return XAdSDKFoundationFacade.getInstance().getIoUtils().getStoreagePath(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }

    private static String e(String str) {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mobads.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0268a {

        /* renamed from: a  reason: collision with root package name */
        int f2361a;
        int b;

        private C0268a() {
        }

        /* synthetic */ C0268a(b bVar) {
            this();
        }
    }
}
