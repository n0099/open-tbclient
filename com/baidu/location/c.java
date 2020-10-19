package com.baidu.location;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LocationClient f1918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LocationClient locationClient) {
        this.f1918a = locationClient;
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
            dVar = this.f1918a.C;
            if (dVar == null) {
                LocationClient locationClient = this.f1918a;
                context = this.f1918a.f;
                locationClientOption = this.f1918a.d;
                locationClient.C = new com.baidu.location.b.d(context, locationClientOption, this.f1918a);
            }
            dVar2 = this.f1918a.C;
            if (dVar2 != null) {
                dVar3 = this.f1918a.C;
                dVar3.a();
                dVar4 = this.f1918a.C;
                dVar4.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
