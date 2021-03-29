package com.baidu.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.imagemanager.a;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.ChannelUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class ImageLoader {

    /* renamed from: c  reason: collision with root package name */
    public static final String f3672c = "baidu/wallet/image_cache";

    /* renamed from: d  reason: collision with root package name */
    public static final long f3673d = 864000000;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3674e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f3675f = 6;

    /* renamed from: g  reason: collision with root package name */
    public static final int f3676g = 10;
    public Context i;
    public b j;
    public a k;
    public ImageProcessor l;
    public ThreadPoolExecutor m = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3670a = ApollonConstants.DEBUG;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3671b = ImageLoader.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    public static ImageLoader f3677h = null;

    /* loaded from: classes.dex */
    public interface OnGetBitmapListener {
        boolean needCancel(String str, Object obj);

        void onError(String str, Object obj);

        void onGetBitmap(String str, Object obj, Bitmap bitmap);
    }

    public ImageLoader(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.i = applicationContext;
        this.l = new ImageProcessor(applicationContext);
        this.j = new b();
        this.k = new a(this.i, f3672c, new a.InterfaceC0062a() { // from class: com.baidu.apollon.imagemanager.ImageLoader.1
            @Override // com.baidu.apollon.imagemanager.a.InterfaceC0062a
            public List<File> a(File file) {
                if (file.exists() && file.isDirectory()) {
                    LinkedList linkedList = new LinkedList();
                    File[] listFiles = file.listFiles();
                    long currentTimeMillis = System.currentTimeMillis() - ImageLoader.f3673d;
                    for (File file2 : listFiles) {
                        if (file2.lastModified() < currentTimeMillis) {
                            linkedList.add(file2);
                        }
                    }
                    return linkedList;
                }
                return null;
            }
        });
    }

    public static ImageLoader getInstance(Context context) {
        if (f3670a) {
            Log.d(f3671b, "getInstance()");
        }
        if (f3677h == null) {
            synchronized (ImageLoader.class) {
                if (f3677h == null) {
                    f3677h = new ImageLoader(context.getApplicationContext());
                }
            }
        }
        return f3677h;
    }

    public void getBitmap(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i) {
        if (a(str)) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
            if (bitmapFromMemCache != null) {
                if (f3670a) {
                    Log.d(f3671b, "find in memory");
                }
                onGetBitmapListener.onGetBitmap(str, obj, bitmapFromMemCache);
                return;
            }
            getBitmapFromDiskOrNet(str, onGetBitmapListener, obj, i);
        }
    }

    public void getBitmapFromDiskOrNet(final String str, final OnGetBitmapListener onGetBitmapListener, final Object obj, final int i) {
        a(new Runnable() { // from class: com.baidu.apollon.imagemanager.ImageLoader.3
            @Override // java.lang.Runnable
            public void run() {
                if (ImageLoader.this.a(str, onGetBitmapListener, obj, i)) {
                    return;
                }
                ImageLoader.this.b(str, onGetBitmapListener, obj, i);
            }
        });
    }

    public Bitmap getBitmapFromMemCache(String str) {
        if (f3670a) {
            Log.d(f3671b, "check memory");
        }
        if (a(str)) {
            return this.j.a(str);
        }
        return null;
    }

    public Bitmap getBitmapFromMemCacheOrDeskSynch(String str, Object obj, int i) {
        if (a(str)) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
            if (bitmapFromMemCache != null) {
                if (f3670a) {
                    Log.d(f3671b, "find in memory");
                }
                return bitmapFromMemCache;
            }
            Bitmap a2 = a(str, obj, i);
            if (a2 != null && f3670a) {
                Log.d(f3671b, "find in disk");
            }
            return a2;
        }
        return null;
    }

    private void a(Runnable runnable) {
        if (this.m == null) {
            this.m = new ThreadPoolExecutor(3, 6, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.baidu.apollon.imagemanager.ImageLoader.2
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable2) {
                    AtomicInteger atomicInteger = new AtomicInteger(1);
                    return new Thread(runnable2, "ImageLoader #" + atomicInteger.getAndIncrement());
                }
            }, new ThreadPoolExecutor.DiscardOldestPolicy());
            if (ChannelUtils.isSpecailPackage()) {
                this.m.allowCoreThreadTimeOut(true);
            }
        }
        this.m.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i) {
        byte[] bArr;
        if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
            if (f3670a) {
                Log.d(f3671b, "download from net");
            }
            Context context = this.i;
            RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "image load http request");
            restTemplate.setMessageConverter(new com.baidu.apollon.restnet.converter.a());
            Bitmap bitmap = null;
            try {
                bArr = (byte[]) restTemplate.a(str, null, "utf-8", byte[].class);
            } catch (RestRuntimeException e2) {
                e2.printStackTrace();
                bArr = null;
            }
            if (bArr == null) {
                return;
            }
            this.k.a(str, bArr);
            File a2 = this.k.a(str);
            if (a2 == null || !a2.exists()) {
                return;
            }
            try {
                bitmap = this.l.decode(a2, i);
            } catch (FileNotFoundException unused) {
            }
            if (bitmap != null) {
                if (f3670a) {
                    Log.d(f3671b, "find in file");
                }
                this.j.a(str, bitmap);
                this.j.a();
                if (onGetBitmapListener != null) {
                    onGetBitmapListener.onGetBitmap(str, obj, bitmap);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i) {
        Bitmap bitmap;
        if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
            if (f3670a) {
                Log.d(f3671b, "chech file async ");
            }
            File a2 = this.k.a(str);
            if (a2 == null || !a2.exists()) {
                return false;
            }
            if (f3670a) {
                Log.d(f3671b, "file is not null ");
            }
            try {
                bitmap = this.l.decode(a2, i);
            } catch (FileNotFoundException unused) {
                bitmap = null;
            }
            if (bitmap != null) {
                if (f3670a) {
                    Log.d(f3671b, "find in file");
                }
                this.j.a(str, bitmap);
                this.j.a();
                if (onGetBitmapListener != null) {
                    onGetBitmapListener.onGetBitmap(str, obj, bitmap);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private Bitmap a(String str, Object obj, int i) {
        if (f3670a) {
            Log.d(f3671b, "chech file async ");
        }
        File a2 = this.k.a(str);
        Bitmap bitmap = null;
        if (a2 != null && a2.exists()) {
            if (f3670a) {
                Log.d(f3671b, "file is not null ");
            }
            try {
                bitmap = this.l.decode(a2, i);
            } catch (FileNotFoundException unused) {
            }
            if (bitmap != null) {
                if (f3670a) {
                    Log.d(f3671b, "find in file");
                }
                this.j.a(str, bitmap);
                this.j.a();
            }
        }
        return bitmap;
    }
}
