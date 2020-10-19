package com.baidu.ar.b;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.ar.g.b;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import java.io.File;
/* loaded from: classes14.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a cB;
    private SparseArray<com.baidu.ar.mdl.a> cy = new SparseArray<>();
    private SparseArray<Integer> cz = new SparseArray<>();
    private SparseArray<Boolean> cA = new SparseArray<>();
    private boolean cC = false;

    private a() {
    }

    public static synchronized a ar() {
        a aVar;
        synchronized (a.class) {
            if (cB == null) {
                cB = new a();
            }
            aVar = cB;
        }
        return aVar;
    }

    private void b(Context context) {
        if (this.cC) {
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
            this.cC = true;
        } catch (Exception e) {
            b.b(TAG, "setup error");
            e.printStackTrace();
        }
    }

    public void a(int i, boolean z) {
        synchronized (this.cA) {
            this.cA.put(i, Boolean.valueOf(z));
        }
    }

    public void a(Context context, SparseArray<com.baidu.ar.mdl.a> sparseArray) {
        this.cy = sparseArray;
        b(context);
    }

    public synchronized boolean b(int i) {
        return this.cz.get(i) != null;
    }

    public synchronized void c(int i) {
        this.cz.put(i, Integer.valueOf(i));
    }

    public synchronized void d(int i) {
        this.cz.remove(i);
    }

    public boolean e(int i) {
        Boolean bool;
        synchronized (this.cA) {
            bool = this.cA.get(i);
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public com.baidu.ar.mdl.a f(int i) {
        return this.cy.get(i);
    }
}
