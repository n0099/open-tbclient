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
    public static final boolean f3692a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3693b = "ImageMemoryCache";

    /* renamed from: c  reason: collision with root package name */
    public static final int f3694c = 15;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3695d = 10000;

    /* renamed from: e  reason: collision with root package name */
    public static final float f3696e = 0.75f;

    /* renamed from: h  reason: collision with root package name */
    public static HandlerThread f3699h;
    public static Handler i;

    /* renamed from: f  reason: collision with root package name */
    public static ConcurrentHashMap<String, SoftReference<Bitmap>> f3697f = new ConcurrentHashMap<>(7);

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, Bitmap> f3698g = new LinkedHashMap<String, Bitmap>(7, 0.75f, true) { // from class: com.baidu.apollon.imagemanager.ImageMemoryCache$1
        public static final long serialVersionUID = 1;

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
            ConcurrentHashMap concurrentHashMap;
            if (size() > 15) {
                concurrentHashMap = b.f3697f;
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
            HandlerThread unused = b.f3699h = new HandlerThread("sb_imagecache_loop", 10);
            b.f3699h.start();
            Handler unused2 = b.i = new Handler(b.f3699h.getLooper());
        }

        public a() {
        }
    }

    public static void e() {
        synchronized (f3698g) {
            for (Map.Entry<String, Bitmap> entry : f3698g.entrySet()) {
                f3697f.put(entry.getKey(), new SoftReference<>(entry.getValue()));
            }
            f3698g.clear();
        }
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, SoftReference<Bitmap>> entry2 : f3697f.entrySet()) {
            if (entry2.getValue().get() == null) {
                linkedList.add(entry2.getKey());
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f3697f.remove((String) it.next());
        }
    }

    public void a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (f3698g) {
                f3698g.put(str, bitmap);
            }
        }
    }

    public Bitmap a(String str) {
        synchronized (f3698g) {
            Bitmap bitmap = f3698g.get(str);
            if (bitmap != null) {
                return bitmap;
            }
            SoftReference<Bitmap> softReference = f3697f.get(str);
            if (softReference != null) {
                Bitmap bitmap2 = softReference.get();
                if (bitmap2 != null) {
                    a(str, bitmap2);
                    return bitmap2;
                }
                f3697f.remove(str);
                return null;
            }
            return null;
        }
    }

    public void a() {
        if (i == null) {
            new a();
        }
        Handler handler = i;
        if (handler != null) {
            handler.removeCallbacks(j);
            i.postDelayed(j, 10000L);
        }
    }
}
