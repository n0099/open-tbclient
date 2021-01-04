package com.baidu.mobads.utils;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes3.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SharedPreferences f3546a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3547b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, SharedPreferences sharedPreferences, String str) {
        this.c = pVar;
        this.f3546a = sharedPreferences;
        this.f3547b = str;
    }

    @Override // java.lang.Runnable
    @TargetApi(9)
    public void run() {
        if (Build.VERSION.SDK_INT >= 9) {
            this.f3546a.edit().putString("deviceid", this.f3547b).apply();
        } else {
            this.f3546a.edit().putString("deviceid", this.f3547b).commit();
        }
    }
}
