package com.baidu.location;

import android.os.Messenger;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f474a;

    private i(e eVar) {
        this.f474a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(e eVar, g gVar) {
        this(eVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Messenger messenger;
        Messenger messenger2;
        ArrayList arrayList;
        ArrayList arrayList2;
        h hVar;
        obj = this.f474a.s;
        synchronized (obj) {
            this.f474a.o = false;
            messenger = this.f474a.h;
            if (messenger != null) {
                messenger2 = this.f474a.j;
                if (messenger2 != null) {
                    arrayList = this.f474a.k;
                    if (arrayList != null) {
                        arrayList2 = this.f474a.k;
                        if (arrayList2.size() >= 1) {
                            ap.a("baidu_location_Client", "request location ...");
                            hVar = this.f474a.i;
                            hVar.obtainMessage(4).sendToTarget();
                        }
                    }
                }
            }
        }
    }
}
