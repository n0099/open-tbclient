package com.baidu.apollon.imagemanager;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3797a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3798b = "ImageMemoryCache";

    /* renamed from: c  reason: collision with root package name */
    public static final int f3799c = 15;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3800d = 10000;

    /* renamed from: e  reason: collision with root package name */
    public static final float f3801e = 0.75f;

    /* renamed from: h  reason: collision with root package name */
    public static HandlerThread f3804h;

    /* renamed from: i  reason: collision with root package name */
    public static Handler f3805i;

    /* renamed from: f  reason: collision with root package name */
    public static ConcurrentHashMap<String, SoftReference<Bitmap>> f3802f = new ConcurrentHashMap<>(7);

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, Bitmap> f3803g = new LinkedHashMap<String, Bitmap>(7, 0.75f, true) { // from class: com.baidu.apollon.imagemanager.ImageMemoryCache$1
        public static final long serialVersionUID = 1;

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
            ConcurrentHashMap concurrentHashMap;
            if (size() > 15) {
                concurrentHashMap = b.f3802f;
                concurrentHashMap.put(entry.getKey(), new SoftReference(entry.getValue()));
                return true;
            }
            return false;
        }
    };
    public static Runnable j = new Runnable() { // from class: com.baidu.apollon.imagemanager.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.e();
        }
    };

    /* loaded from: classes.dex */
    public static class a {
        static {
            HandlerThread unused = b.f3804h = new HandlerThread("sb_imagecache_loop", 10);
            b.f3804h.start();
            Handler unused2 = b.f3805i = new Handler(b.f3804h.getLooper());
        }

        public a() {
        }
    }

    public static void e() {
        synchronized (f3803g) {
            for (Map.Entry<String, Bitmap> entry : f3803g.entrySet()) {
                f3802f.put(entry.getKey(), new SoftReference<>(entry.getValue()));
            }
            f3803g.clear();
        }
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, SoftReference<Bitmap>> entry2 : f3802f.entrySet()) {
            if (entry2.getValue().get() == null) {
                linkedList.add(entry2.getKey());
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f3802f.remove((String) it.next());
        }
    }

    public void a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (f3803g) {
                f3803g.put(str, bitmap);
            }
        }
    }

    public Bitmap a(String str) {
        synchronized (f3803g) {
            Bitmap bitmap = f3803g.get(str);
            if (bitmap != null) {
                return bitmap;
            }
            SoftReference<Bitmap> softReference = f3802f.get(str);
            if (softReference != null) {
                Bitmap bitmap2 = softReference.get();
                if (bitmap2 != null) {
                    a(str, bitmap2);
                    return bitmap2;
                }
                f3802f.remove(str);
                return null;
            }
            return null;
        }
    }

    public void a() {
        if (f3805i == null) {
            new a();
        }
        Handler handler = f3805i;
        if (handler != null) {
            handler.removeCallbacks(j);
            f3805i.postDelayed(j, 10000L);
        }
    }
}
