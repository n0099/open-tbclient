package com.baidu.android.pushservice.h.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.c.a.d;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.h.a.a.a;
import com.baidu.android.pushservice.i.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public final class a {
    private static final List<a.c> a = new CopyOnWriteArrayList();

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
        return a.c.s().a(a.e.ACK).a(a.C0049a.m().a(str).b(str2).a(j).c(str3).b(j2).build()).build();
    }

    private a.c a(String str, String str2, String str3, String str4, long j, long j2, long j3, String str5, long j4) {
        return a.c.s().a(a.e.DB).a(a.n.u().a(str).b(str2).c(str3).d(str4).a(j).b(j2).c(j3).e(str5).d(j4).build()).build();
    }

    private void a(a.c cVar) {
        a.add(cVar);
    }

    private a.h c(Context context) {
        a.p build = a.p.e().a(DeviceId.getCUID(context)).build();
        return a.h.t().a(build).a(-1L).b(System.currentTimeMillis()).a(d(context)).a(e(context)).a(a.f.i().a(context.getPackageName()).b("" + m.a(context)).c("").build()).build();
    }

    private a.ac d(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                i4 = displayMetrics.widthPixels;
                i3 = displayMetrics.heightPixels;
            } else {
                i3 = displayMetrics.widthPixels;
                i4 = displayMetrics.heightPixels;
            }
            int i6 = displayMetrics.densityDpi;
            i2 = i4;
            i5 = i3;
            i = i6;
        } else {
            i = 0;
            i2 = 0;
        }
        return a.ac.q().a(a.x.ANDROID).a(Build.VERSION.RELEASE).b(Build.MANUFACTURER.toUpperCase()).c(Build.MODEL).a(i2).b(i5).c(i).build();
    }

    private static a.v e(Context context) {
        String str;
        String str2;
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            str = "";
            str2 = "";
        } else {
            String str3 = "" + activeNetworkInfo.getTypeName();
            str = "" + activeNetworkInfo.getExtraInfo();
            str2 = str3;
        }
        return a.v.g().a(str2).b(str).build();
    }

    private void f(Context context) {
        for (com.baidu.android.pushservice.c.a.c cVar : e.a(context).a()) {
            a(a(cVar.b, cVar.a, cVar.c, cVar.d));
        }
    }

    private void g(Context context) {
        for (d dVar : e.a(context).b()) {
            a(a(dVar.a, dVar.b, dVar.c, dVar.d, dVar.e, dVar.f, dVar.g, dVar.h, dVar.i));
        }
    }

    private void h(Context context) {
        for (com.baidu.android.pushservice.c.a.b bVar : e.a(context).c()) {
            a(a(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g));
        }
    }

    private void i(Context context) {
        for (com.baidu.android.pushservice.c.a.e eVar : e.a(context).d()) {
            a(a(eVar.a, eVar.b, eVar.c, eVar.d, eVar.e, eVar.f, eVar.g));
        }
    }

    private void j(Context context) {
        for (com.baidu.android.pushservice.c.a.a aVar : e.a(context).e()) {
            a(a(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a(Context context) {
        try {
            a();
            f(context);
            g(context);
            h(context);
            i(context);
            j(context);
            if (a.size() <= 0) {
                return null;
            }
            return a.y.k().a(c(context)).a("push").a(com.baidu.android.pushservice.a.a()).a(a).build().toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a("startWork", "", System.currentTimeMillis(), -1L, -1L, "", 501020L));
            return a.y.k().a(c(context)).a("push").a(com.baidu.android.pushservice.a.a()).a(arrayList).build().toByteArray();
        } catch (Exception e) {
            return null;
        }
    }
}
