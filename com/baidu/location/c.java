package com.baidu.location;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c extends Thread {
    final /* synthetic */ LocationClient a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LocationClient locationClient) {
        this.a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.baidu.location.a.c cVar;
        com.baidu.location.a.c cVar2;
        com.baidu.location.a.c cVar3;
        Context context;
        LocationClientOption locationClientOption;
        cVar = this.a.C;
        if (cVar == null) {
            LocationClient locationClient = this.a;
            context = this.a.f;
            locationClientOption = this.a.d;
            locationClient.C = new com.baidu.location.a.c(context, locationClientOption, this.a);
        }
        cVar2 = this.a.C;
        if (cVar2 != null) {
            cVar3 = this.a.C;
            cVar3.c();
        }
    }
}
