package com.baidu.apollon.restnet.rest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f3858b = "b";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3859c = false;

    /* renamed from: a  reason: collision with root package name */
    public String f3860a;

    /* renamed from: d  reason: collision with root package name */
    public String f3861d;

    /* renamed from: e  reason: collision with root package name */
    public String f3862e;

    /* renamed from: f  reason: collision with root package name */
    public String f3863f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3864g;

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
        return this.f3861d;
    }

    public String c() {
        return this.f3862e;
    }

    public String d() {
        return this.f3863f;
    }

    public String e() {
        return this.f3860a;
    }

    public boolean a() {
        return this.f3864g;
    }
}
