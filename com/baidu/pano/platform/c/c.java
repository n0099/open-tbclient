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
    public static volatile c f8997a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f8998b;

    /* renamed from: c  reason: collision with root package name */
    public p f8999c = n.a(f8998b);

    public static c a(Context context) {
        if (f8997a == null) {
            synchronized (c.class) {
                if (f8997a == null) {
                    f8998b = context;
                    f8997a = new c();
                }
            }
        }
        return f8997a;
    }

    public String b(String str) {
        l a2 = l.a();
        m mVar = new m(str, a2, a2);
        mVar.a(true);
        this.f8999c.a(mVar);
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
        this.f8999c.a(dVar);
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
