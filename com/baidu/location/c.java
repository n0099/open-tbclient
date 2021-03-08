package com.baidu.location;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LocationClient f1960a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LocationClient locationClient) {
        this.f1960a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.baidu.location.a.c cVar;
        com.baidu.location.a.c cVar2;
        com.baidu.location.a.c cVar3;
        Context context;
        LocationClientOption locationClientOption;
        cVar = this.f1960a.C;
        if (cVar == null) {
            LocationClient locationClient = this.f1960a;
            context = this.f1960a.f;
            locationClientOption = this.f1960a.d;
            locationClient.C = new com.baidu.location.a.c(context, locationClientOption, this.f1960a);
        }
        cVar2 = this.f1960a.C;
        if (cVar2 != null) {
            cVar3 = this.f1960a.C;
            cVar3.c();
        }
    }
}
