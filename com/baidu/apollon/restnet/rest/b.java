package com.baidu.apollon.restnet.rest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f3768b = "b";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3769c = false;

    /* renamed from: a  reason: collision with root package name */
    public String f3770a;

    /* renamed from: d  reason: collision with root package name */
    public String f3771d;

    /* renamed from: e  reason: collision with root package name */
    public String f3772e;

    /* renamed from: f  reason: collision with root package name */
    public String f3773f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3774g;

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
        return this.f3771d;
    }

    public String c() {
        return this.f3772e;
    }

    public String d() {
        return this.f3773f;
    }

    public String e() {
        return this.f3770a;
    }

    public boolean a() {
        return this.f3774g;
    }
}
