package com.baidu.mobads.utils;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes14.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SharedPreferences f3509a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3510b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, SharedPreferences sharedPreferences, String str) {
        this.c = pVar;
        this.f3509a = sharedPreferences;
        this.f3510b = str;
    }

    @Override // java.lang.Runnable
    @TargetApi(9)
    public void run() {
        if (Build.VERSION.SDK_INT >= 9) {
            this.f3509a.edit().putString("deviceid", this.f3510b).apply();
        } else {
            this.f3509a.edit().putString("deviceid", this.f3510b).commit();
        }
    }
}
