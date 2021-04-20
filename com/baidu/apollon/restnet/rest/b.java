package com.baidu.apollon.restnet.rest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f3804b = "b";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3805c = false;

    /* renamed from: a  reason: collision with root package name */
    public String f3806a;

    /* renamed from: d  reason: collision with root package name */
    public String f3807d;

    /* renamed from: e  reason: collision with root package name */
    public String f3808e;

    /* renamed from: f  reason: collision with root package name */
    public String f3809f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3810g;

    public b(Context context) {
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
        return this.f3807d;
    }

    public String c() {
        return this.f3808e;
    }

    public String d() {
        return this.f3809f;
    }

    public String e() {
        return this.f3806a;
    }

    public boolean a() {
        return this.f3810g;
    }
}
