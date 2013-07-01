package com.baidu.android.pushservice.richmedia;

import android.util.Log;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f345a = true;
    private static Hashtable b = new Hashtable();
    private String c;

    private l(String str) {
        this.c = str;
    }

    public static l a(String str) {
        l lVar = (l) b.get(str);
        if (lVar == null) {
            l lVar2 = new l(str);
            b.put(str, lVar2);
            return lVar2;
        }
        return lVar;
    }

    public void b(String str) {
        if (f345a) {
            Log.d("[Channel]", "{Thread:" + Thread.currentThread().getName() + "}[" + this.c + ":] " + str);
        }
    }

    public void c(String str) {
        if (f345a) {
            Log.w("[Channel]", "{Thread:" + Thread.currentThread().getName() + "}[" + this.c + ":] " + str);
        }
    }
}
