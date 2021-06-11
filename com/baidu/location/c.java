package com.baidu.location;

import android.content.Context;
/* loaded from: classes2.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationClient f6641a;

    public c(LocationClient locationClient) {
        this.f6641a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.baidu.location.b.c cVar;
        com.baidu.location.b.c cVar2;
        com.baidu.location.b.c cVar3;
        Context context;
        LocationClientOption locationClientOption;
        cVar = this.f6641a.C;
        if (cVar == null) {
            LocationClient locationClient = this.f6641a;
            context = this.f6641a.f6460f;
            locationClientOption = this.f6641a.f6458d;
            locationClient.C = new com.baidu.location.b.c(context, locationClientOption, this.f6641a);
        }
        cVar2 = this.f6641a.C;
        if (cVar2 != null) {
            cVar3 = this.f6641a.C;
            cVar3.c();
        }
    }
}
