package com.baidu.location;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LocationClient f2619a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LocationClient locationClient) {
        this.f2619a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.baidu.location.a.c cVar;
        com.baidu.location.a.c cVar2;
        com.baidu.location.a.c cVar3;
        Context context;
        LocationClientOption locationClientOption;
        cVar = this.f2619a.C;
        if (cVar == null) {
            LocationClient locationClient = this.f2619a;
            context = this.f2619a.f;
            locationClientOption = this.f2619a.d;
            locationClient.C = new com.baidu.location.a.c(context, locationClientOption, this.f2619a);
        }
        cVar2 = this.f2619a.C;
        if (cVar2 != null) {
            cVar3 = this.f2619a.C;
            cVar3.c();
        }
    }
}
