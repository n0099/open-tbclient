package com.baidu.ar.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import com.baidu.ar.b.b.d;
import com.baidu.ar.b.b.e;
import com.baidu.ar.f.b;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a cv;
    private Handler cy;
    private SparseArray<com.baidu.ar.mdl.a> ct = new SparseArray<>();
    private SparseArray<Integer> cu = new SparseArray<>();
    private boolean cw = false;
    e cA = new e();
    private Handler cx = new Handler(Looper.getMainLooper());
    private HandlerThread cz = new HandlerThread("callBackThread");

    private a() {
        this.cz.start();
        this.cy = new Handler(this.cz.getLooper());
    }

    public static synchronized a ac() {
        a aVar;
        synchronized (a.class) {
            if (cv == null) {
                cv = new a();
                cv.cA.start();
            }
            aVar = cv;
        }
        return aVar;
    }

    private void b(Context context) {
        if (this.cw) {
            return;
        }
        if (context == null) {
            b.b(TAG, "setup context = null");
            return;
        }
        try {
            File file = new File(context.getFilesDir(), "snpe");
            if (!file.exists()) {
                file.mkdirs();
            }
            ARMdlInterfaceJNI.setAssetManager(context.getAssets());
            ARMdlInterfaceJNI.setCacheDir(file.getAbsolutePath());
            this.cw = true;
        } catch (Exception e) {
            b.b(TAG, "setup error");
            e.printStackTrace();
        }
    }

    public void a(Context context, SparseArray<com.baidu.ar.mdl.a> sparseArray) {
        this.ct = sparseArray;
        b(context);
    }

    public void a(Runnable runnable) {
        this.cx.post(runnable);
    }

    public boolean a(int i) {
        return this.cA.h(i);
    }

    public boolean a(d dVar) {
        if (this.cw) {
            return this.cA.b(dVar);
        }
        b.b(TAG, "please setup(Context context) first!");
        return false;
    }

    public void b(Runnable runnable) {
        this.cy.post(runnable);
    }

    public boolean b(int i) {
        return this.cA.b(i);
    }

    public synchronized boolean c(int i) {
        return this.cu.get(i) != null;
    }

    public synchronized void d(int i) {
        this.cu.put(i, Integer.valueOf(i));
    }

    public synchronized void e(int i) {
        this.cu.remove(i);
    }

    public com.baidu.ar.mdl.a f(int i) {
        return this.ct.get(i);
    }
}
