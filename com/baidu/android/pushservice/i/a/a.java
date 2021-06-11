package com.baidu.android.pushservice.i.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.c.a.d;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.i.a.a.a;
import com.baidu.android.pushservice.j.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final List<a.c> f3162a = new CopyOnWriteArrayList();

    private a.c a(long j, long j2, String str, long j3, long j4, String str2, long j5) {
        return a.c.s().a(a.e.CONNECTION).a(a.j.q().a(j).b(j2).a(str).c(j3).d(j4).b(str2).e(j5).build()).build();
    }

    private a.c a(long j, String str, String str2, long j2) {
        return a.c.s().a(a.e.CRASH).a(a.l.k().a(j).a(str).b(str2).b(j2).build()).build();
    }

    private a.c a(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        return a.c.s().a(a.e.REQUEST).a(a.aa.q().a(str).b(str2).a(j).b(j2).c(j3).c(str3).d(j4).build()).build();
    }

    private a.c a(String str, String str2, long j, String str3, long j2) {
        return a.c.s().a(a.e.ACK).a(a.C0037a.m().a(str).b(str2).a(j).c(str3).b(j2).build()).build();
    }

    private a.c a(String str, String str2, String str3, String str4, long j, long j2, long j3, String str5, long j4) {
        return a.c.s().a(a.e.DB).a(a.n.u().a(str).b(str2).c(str3).d(str4).a(j).b(j2).c(j3).e(str5).d(j4).build()).build();
    }

    private void a(a.c cVar) {
        f3162a.add(cVar);
    }

    private a.h c(Context context) {
        a.p build = a.p.e().a(DeviceId.getCUID(context)).build();
        a.f.C0043a a2 = a.f.i().a(context.getPackageName());
        return a.h.t().a(build).a(-1L).b(System.currentTimeMillis()).a(d(context)).a(e(context)).a(a2.b("" + m.a(context)).c("").build()).build();
    }

    private a.ac d(Context context) {
        int i2;
        int i3;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i4 = 0;
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i4 = displayMetrics.heightPixels;
            if (i2 > i4) {
                i4 = i2;
                i2 = i4;
            }
            i3 = displayMetrics.densityDpi;
        } else {
            i2 = 0;
            i3 = 0;
        }
        return a.ac.q().a(a.x.ANDROID).a(Build.VERSION.RELEASE).b(Build.MANUFACTURER.toUpperCase()).c(Build.MODEL).a(i4).b(i2).c(i3).build();
    }

    public static a.v e(Context context) {
        String str;
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        String str2 = "";
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            str = "";
        } else {
            String str3 = "" + activeNetworkInfo.getTypeName();
            str = "" + activeNetworkInfo.getExtraInfo();
            str2 = str3;
        }
        return a.v.g().a(str2).b(str).build();
    }

    private void f(Context context) {
        for (com.baidu.android.pushservice.c.a.c cVar : e.a(context).a()) {
            a(a(cVar.f2830b, cVar.f2829a, cVar.f2831c, cVar.f2832d));
        }
    }

    private void g(Context context) {
        for (d dVar : e.a(context).b()) {
            a(a(dVar.f2842a, dVar.f2843b, dVar.f2844c, dVar.f2845d, dVar.f2846e, dVar.f2847f, dVar.f2848g, dVar.f2849h, dVar.f2850i));
        }
    }

    private void h(Context context) {
        for (com.baidu.android.pushservice.c.a.b bVar : e.a(context).c()) {
            a(a(bVar.f2813a, bVar.f2814b, bVar.f2815c, bVar.f2816d, bVar.f2817e, bVar.f2818f, bVar.f2819g));
        }
    }

    private void i(Context context) {
        for (com.baidu.android.pushservice.c.a.e eVar : e.a(context).d()) {
            a(a(eVar.f2851a, eVar.f2852b, eVar.f2853c, eVar.f2854d, eVar.f2855e, eVar.f2856f, eVar.f2857g));
        }
    }

    private void j(Context context) {
        for (com.baidu.android.pushservice.c.a.a aVar : e.a(context).e()) {
            a(a(aVar.f2800a, aVar.f2801b, aVar.f2802c, aVar.f2803d, aVar.f2804e));
        }
    }

    public void a() {
        f3162a.clear();
    }

    public byte[] a(Context context) {
        try {
            a();
            f(context);
            g(context);
            h(context);
            i(context);
            j(context);
            if (f3162a.size() <= 0) {
                return null;
            }
            return a.y.k().a(c(context)).a("push").a(com.baidu.android.pushservice.a.a()).a(f3162a).build().toByteArray();
        } catch (Exception unused) {
            return null;
        }
    }

    public byte[] b(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a("startWork", "", System.currentTimeMillis(), -1L, -1L, "", 501020L));
            return a.y.k().a(c(context)).a("push").a(com.baidu.android.pushservice.a.a()).a(arrayList).build().toByteArray();
        } catch (Exception unused) {
            return null;
        }
    }
}
