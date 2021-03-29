package com.baidu.pano.platform.c;

import android.content.Context;
import com.baidu.pano.platform.a.a.l;
import com.baidu.pano.platform.a.a.m;
import com.baidu.pano.platform.a.a.n;
import com.baidu.pano.platform.a.p;
import java.util.concurrent.ExecutionException;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f9439a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f9440b;

    /* renamed from: c  reason: collision with root package name */
    public p f9441c = n.a(f9440b);

    public static c a(Context context) {
        if (f9439a == null) {
            synchronized (c.class) {
                if (f9439a == null) {
                    f9440b = context;
                    f9439a = new c();
                }
            }
        }
        return f9439a;
    }

    public String b(String str) {
        l a2 = l.a();
        m mVar = new m(str, a2, a2);
        mVar.a(true);
        this.f9441c.a(mVar);
        try {
            return (String) a2.get();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public byte[] a(String str) {
        l a2 = l.a();
        com.baidu.pano.platform.a.a.d dVar = new com.baidu.pano.platform.a.a.d(str, a2, a2);
        dVar.a(true);
        this.f9441c.a(dVar);
        try {
            return (byte[]) a2.get();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
