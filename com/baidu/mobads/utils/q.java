package com.baidu.mobads.utils;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes3.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SharedPreferences f3547a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3548b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, SharedPreferences sharedPreferences, String str) {
        this.c = pVar;
        this.f3547a = sharedPreferences;
        this.f3548b = str;
    }

    @Override // java.lang.Runnable
    @TargetApi(9)
    public void run() {
        if (Build.VERSION.SDK_INT >= 9) {
            this.f3547a.edit().putString("deviceid", this.f3548b).apply();
        } else {
            this.f3547a.edit().putString("deviceid", this.f3548b).commit();
        }
    }
}
