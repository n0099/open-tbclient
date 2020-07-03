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
    private static a cI;
    private Handler cL;
    private SparseArray<com.baidu.ar.mdl.a> cG = new SparseArray<>();
    private SparseArray<Integer> cH = new SparseArray<>();
    private boolean cJ = false;
    e cN = new e();
    private Handler cK = new Handler(Looper.getMainLooper());
    private HandlerThread cM = new HandlerThread("callBackThread");

    private a() {
        this.cM.start();
        this.cL = new Handler(this.cM.getLooper());
    }

    public static synchronized a aq() {
        a aVar;
        synchronized (a.class) {
            if (cI == null) {
                cI = new a();
                cI.cN.start();
            }
            aVar = cI;
        }
        return aVar;
    }

    private void b(Context context) {
        if (this.cJ) {
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
            this.cJ = true;
        } catch (Exception e) {
            b.b(TAG, "setup error");
            e.printStackTrace();
        }
    }

    public void a(Context context, SparseArray<com.baidu.ar.mdl.a> sparseArray) {
        this.cG = sparseArray;
        b(context);
    }

    public void a(Runnable runnable) {
        this.cK.post(runnable);
    }

    public boolean a(d dVar) {
        if (this.cJ) {
            return this.cN.b(dVar);
        }
        b.b(TAG, "please setup(Context context) first!");
        return false;
    }

    public void b(Runnable runnable) {
        this.cL.post(runnable);
    }

    public boolean b(int i) {
        return this.cN.i(i);
    }

    public boolean c(int i) {
        return this.cN.c(i);
    }

    public synchronized boolean d(int i) {
        return this.cH.get(i) != null;
    }

    public synchronized void e(int i) {
        this.cH.put(i, Integer.valueOf(i));
    }

    public synchronized void f(int i) {
        this.cH.remove(i);
    }

    public com.baidu.ar.mdl.a g(int i) {
        return this.cG.get(i);
    }
}
