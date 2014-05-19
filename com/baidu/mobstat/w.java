package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ q a;
    private long b;
    private WeakReference<Context> c;
    private WeakReference<Fragment> d;
    private WeakReference<Object> e;
    private long f;
    private WeakReference<Context> g;
    private WeakReference<Fragment> h;
    private WeakReference<Object> i;
    private int j;
    private String k;

    public w(q qVar, long j, Context context, Fragment fragment, long j2, Context context2, Fragment fragment2, int i, String str, Object obj, Object obj2) {
        this.a = qVar;
        this.k = null;
        this.b = j;
        if (context != null) {
            this.c = new WeakReference<>(context);
        }
        this.f = j2;
        if (context2 != null) {
            this.g = new WeakReference<>(context2);
        }
        if (fragment != null) {
            this.d = new WeakReference<>(fragment);
        }
        if (fragment2 != null) {
            this.h = new WeakReference<>(fragment2);
        }
        if (obj != null) {
            this.i = new WeakReference<>(obj);
        }
        if (obj2 != null) {
            this.e = new WeakReference<>(obj2);
        }
        this.j = i;
        this.k = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        o oVar2;
        long j;
        o oVar3;
        long j2;
        if (this.j != 1) {
            if (this.j == 2) {
                if (this.d.get() != this.h.get()) {
                    com.baidu.mobstat.a.e.c("statsdk", " Fragment onPause() 或 onResume()安放错误||onPause() or onResume() install error.");
                    return;
                }
                long j3 = this.b - this.f;
                Fragment fragment = this.d.get();
                if (fragment == null) {
                    com.baidu.mobstat.a.e.c("statsdk", "onPause,WeakReference is already been released");
                    return;
                }
                String str = fragment.getClass().getName().toString();
                String substring = str.substring(str.lastIndexOf(".") + 1);
                com.baidu.mobstat.a.e.a("statsdk", "Fragment new page view, page name = " + str.toString() + ",stay time = " + j3 + "(ms)");
                oVar2 = this.a.k;
                oVar2.a(substring, j3, this.f);
                this.a.c(this.d.get().getActivity(), this.b);
            } else if (this.j == 3) {
                if (this.e.get() != this.i.get()) {
                    com.baidu.mobstat.a.e.c("statsdk", " Fragment onPause() 或 onResume()安放错误||onPause() or onResume() install error.");
                    return;
                }
                long j4 = this.b - this.f;
                Object obj = this.e.get();
                if (obj == null) {
                    com.baidu.mobstat.a.e.c("statsdk", "onPause,WeakReference is already been released");
                    return;
                }
                Context a = q.a(obj);
                String str2 = obj.getClass().getName().toString();
                String substring2 = str2.substring(str2.lastIndexOf(".") + 1);
                com.baidu.mobstat.a.e.a("statsdk", "android.app.Fragment new page view, page name = " + str2.toString() + ",stay time = " + j4 + "(ms)");
                oVar = this.a.k;
                oVar.a(substring2, j4, this.f);
                this.a.c(a, this.b);
            }
        } else if (this.c.get() != this.g.get()) {
            if (this.k != null) {
                com.baidu.mobstat.a.e.c("statsdk", "onPageStart() 或 onPageEnd()安放错误  || onPageStart() or onPageEnd() install error.");
            } else {
                com.baidu.mobstat.a.e.c("statsdk", "onPause() 或 onResume()安放错误  ||  onPause() or onResume() install error.");
            }
        } else {
            long j5 = this.b - this.f;
            Activity activity = (Activity) this.c.get();
            if (activity == null) {
                com.baidu.mobstat.a.e.c("statsdk", "onPause,WeakReference is already been released");
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (this.k != null) {
                sb.append(this.k);
                v b = this.a.b(this.k);
                if (b != null) {
                    j2 = b.d - b.c;
                    com.baidu.mobstat.a.e.c("sdkstat", "==============page time=" + b.a + ";time=" + j2);
                    if (j2 < 20) {
                        com.baidu.mobstat.a.e.c("sdkstat", "==============page time little than 20 milli");
                        return;
                    }
                } else {
                    j2 = j5;
                }
                j = j2;
            } else {
                sb.append(activity.getComponentName().getShortClassName());
                if (sb.charAt(0) == '.') {
                    sb.deleteCharAt(0);
                }
                j = j5;
            }
            com.baidu.mobstat.a.e.a("statsdk", "new page view, page name = " + sb.toString() + ",stay time = " + j + "(ms)");
            oVar3 = this.a.k;
            oVar3.a(sb.toString(), j, this.f);
            if (this.k == null) {
                this.a.c(this.c.get(), this.b);
                return;
            }
            v b2 = this.a.b(this.k);
            if (b2 != null) {
                this.a.c(this.c.get(), b2.d);
                this.a.c(this.k);
            }
        }
    }
}
