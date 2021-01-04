package com.baidu.location;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LocationClient f2671a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LocationClient locationClient) {
        this.f2671a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.baidu.location.b.d dVar;
        com.baidu.location.b.d dVar2;
        com.baidu.location.b.d dVar3;
        com.baidu.location.b.d dVar4;
        Context context;
        LocationClientOption locationClientOption;
        try {
            dVar = this.f2671a.C;
            if (dVar == null) {
                LocationClient locationClient = this.f2671a;
                context = this.f2671a.f;
                locationClientOption = this.f2671a.d;
                locationClient.C = new com.baidu.location.b.d(context, locationClientOption, this.f2671a);
            }
            dVar2 = this.f2671a.C;
            if (dVar2 != null) {
                dVar3 = this.f2671a.C;
                dVar3.a();
                dVar4 = this.f2671a.C;
                dVar4.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
