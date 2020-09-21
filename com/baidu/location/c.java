package com.baidu.location;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c extends Thread {
    final /* synthetic */ LocationClient a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LocationClient locationClient) {
        this.a = locationClient;
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
            dVar = this.a.C;
            if (dVar == null) {
                LocationClient locationClient = this.a;
                context = this.a.f;
                locationClientOption = this.a.d;
                locationClient.C = new com.baidu.location.b.d(context, locationClientOption, this.a);
            }
            dVar2 = this.a.C;
            if (dVar2 != null) {
                dVar3 = this.a.C;
                dVar3.a();
                dVar4 = this.a.C;
                dVar4.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
