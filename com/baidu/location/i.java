package com.baidu.location;

import android.os.Messenger;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ e a;

    private i(e eVar) {
        this.a = eVar;
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
        obj = this.a.s;
        synchronized (obj) {
            this.a.o = false;
            messenger = this.a.h;
            if (messenger != null) {
                messenger2 = this.a.j;
                if (messenger2 != null) {
                    arrayList = this.a.k;
                    if (arrayList != null) {
                        arrayList2 = this.a.k;
                        if (arrayList2.size() >= 1) {
                            ap.a("baidu_location_Client", "request location ...");
                            hVar = this.a.i;
                            hVar.obtainMessage(4).sendToTarget();
                        }
                    }
                }
            }
        }
    }
}
