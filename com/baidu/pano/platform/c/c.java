package com.baidu.pano.platform.c;

import android.content.Context;
import com.baidu.pano.platform.a.a.l;
import com.baidu.pano.platform.a.a.m;
import com.baidu.pano.platform.a.a.n;
import com.baidu.pano.platform.a.p;
import java.util.concurrent.ExecutionException;
/* loaded from: classes26.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f2673a = null;
    private static Context b;
    private p c = n.a(b);

    private c() {
    }

    public static c a(Context context) {
        if (f2673a == null) {
            synchronized (c.class) {
                if (f2673a == null) {
                    b = context;
                    f2673a = new c();
                }
            }
        }
        return f2673a;
    }

    public byte[] a(String str) {
        l a2 = l.a();
        com.baidu.pano.platform.a.a.d dVar = new com.baidu.pano.platform.a.a.d(str, a2, a2);
        dVar.a(true);
        this.c.a(dVar);
        try {
            return (byte[]) a2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b(String str) {
        l a2 = l.a();
        m mVar = new m(str, a2, a2);
        mVar.a(true);
        this.c.a(mVar);
        try {
            return (String) a2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
