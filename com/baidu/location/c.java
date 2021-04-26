package com.baidu.location;

import android.content.Context;
/* loaded from: classes2.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationClient f6927a;

    public c(LocationClient locationClient) {
        this.f6927a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.baidu.location.a.c cVar;
        com.baidu.location.a.c cVar2;
        com.baidu.location.a.c cVar3;
        Context context;
        LocationClientOption locationClientOption;
        cVar = this.f6927a.C;
        if (cVar == null) {
            LocationClient locationClient = this.f6927a;
            context = this.f6927a.f6693f;
            locationClientOption = this.f6927a.f6691d;
            locationClient.C = new com.baidu.location.a.c(context, locationClientOption, this.f6927a);
        }
        cVar2 = this.f6927a.C;
        if (cVar2 != null) {
            cVar3 = this.f6927a.C;
            cVar3.c();
        }
    }
}
