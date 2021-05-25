package com.baidu.fsg.base.restnet.rest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f5148b = "a";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5149c = false;

    /* renamed from: a  reason: collision with root package name */
    public String f5150a;

    /* renamed from: d  reason: collision with root package name */
    public String f5151d;

    /* renamed from: e  reason: collision with root package name */
    public String f5152e;

    /* renamed from: f  reason: collision with root package name */
    public String f5153f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5154g;

    public a(Context context) {
        b(context);
    }

    @SuppressLint({"DefaultLocale"})
    private void a(Context context, NetworkInfo networkInfo) {
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    @SuppressLint({"DefaultLocale"})
    private void b(Context context) {
    }

    public String b() {
        return this.f5151d;
    }

    public String c() {
        return this.f5152e;
    }

    public String d() {
        return this.f5153f;
    }

    public String e() {
        return this.f5150a;
    }

    public boolean a() {
        return this.f5154g;
    }
}
