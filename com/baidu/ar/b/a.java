package com.baidu.ar.b;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import com.baidu.ar.h.b;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a cG;
    private SparseArray<com.baidu.ar.mdl.a> cD = new SparseArray<>();
    private SparseArray<Integer> cE = new SparseArray<>();
    private SparseArray<Boolean> cF = new SparseArray<>();
    private boolean cH = false;

    private a() {
    }

    public static synchronized a as() {
        a aVar;
        synchronized (a.class) {
            if (cG == null) {
                cG = new a();
            }
            aVar = cG;
        }
        return aVar;
    }

    private void b(Context context) {
        if (this.cH) {
            return;
        }
        if (context == null) {
            b.b(TAG, "setup context = null");
            return;
        }
        try {
            ARMdlInterfaceJNI.setAssetManager(context.getAssets());
            this.cH = true;
        } catch (Exception e) {
            b.b(TAG, "setup error");
            e.printStackTrace();
        }
    }

    public void a(int i, boolean z) {
        synchronized (this.cF) {
            this.cF.put(i, Boolean.valueOf(z));
        }
    }

    public void a(Context context, SparseArray<com.baidu.ar.mdl.a> sparseArray) {
        this.cD = sparseArray;
        b(context);
    }

    public void c(Context context) {
        if (context == null) {
            b.b(TAG, "setCacheDir context = null");
        } else if (Build.VERSION.SDK_INT < 29) {
            File file = new File(context.getFilesDir(), "snpe");
            if (!file.exists()) {
                file.mkdirs();
            }
            ARMdlInterfaceJNI.setCacheDir(file.getAbsolutePath());
        }
    }

    public synchronized boolean c(int i) {
        return this.cE.get(i) != null;
    }

    public synchronized void d(int i) {
        this.cE.put(i, Integer.valueOf(i));
    }

    public synchronized void e(int i) {
        this.cE.remove(i);
    }

    public boolean f(int i) {
        Boolean bool;
        synchronized (this.cF) {
            bool = this.cF.get(i);
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public com.baidu.ar.mdl.a g(int i) {
        return this.cD.get(i);
    }
}
