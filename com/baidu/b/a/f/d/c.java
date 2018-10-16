package com.baidu.b.a.f.d;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class c {
    private static c ZY;
    private SparseArray<Class<?>> mStateArray = new SparseArray<>();

    public static synchronized c rO() {
        c cVar;
        synchronized (c.class) {
            if (ZY == null) {
                ZY = new c();
            }
            cVar = ZY;
        }
        return cVar;
    }

    private c() {
        this.mStateArray.put(com.baidu.b.a.f.d.b.h.aau, com.baidu.b.a.f.d.b.h.class);
        this.mStateArray.put(com.baidu.b.a.f.d.b.b.aau, com.baidu.b.a.f.d.b.b.class);
        this.mStateArray.put(com.baidu.b.a.f.d.b.e.aau, com.baidu.b.a.f.d.b.e.class);
        this.mStateArray.put(com.baidu.b.a.f.d.b.c.aau, com.baidu.b.a.f.d.b.c.class);
        this.mStateArray.put(com.baidu.b.a.f.d.b.a.aau, com.baidu.b.a.f.d.b.a.class);
        this.mStateArray.put(com.baidu.b.a.f.d.b.g.aau, com.baidu.b.a.f.d.b.g.class);
        this.mStateArray.put(com.baidu.b.a.f.d.b.d.aau, com.baidu.b.a.f.d.b.d.class);
    }

    private synchronized com.baidu.b.a.f.d.b.f br(int i) {
        com.baidu.b.a.f.d.b.f fVar;
        if (i < 0) {
            fVar = null;
        } else {
            try {
                fVar = (com.baidu.b.a.f.d.b.f) this.mStateArray.get(i).newInstance();
            } catch (IllegalAccessException e) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    e.printStackTrace();
                }
                fVar = null;
                return fVar;
            } catch (InstantiationException e2) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    e2.printStackTrace();
                }
                fVar = null;
                return fVar;
            } catch (Exception e3) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    e3.printStackTrace();
                }
                fVar = null;
                return fVar;
            }
        }
        return fVar;
    }

    public boolean c(f fVar) {
        com.baidu.b.a.f.d.b.f br = br(fVar.rP().type);
        boolean z = true;
        while (br != null) {
            br.m(fVar);
            z = br.rY();
            if (z) {
                br = br(br.rZ());
            } else {
                br = br(br.sa());
            }
        }
        return z;
    }
}
