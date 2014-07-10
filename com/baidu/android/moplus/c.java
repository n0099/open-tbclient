package com.baidu.android.moplus;

import com.baidu.android.a.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ MoPlusService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MoPlusService moPlusService) {
        this.a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.android.systemmonitor.c.b.b(this.a.getApplicationContext())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(n.ACTIVE_EVENT);
        com.baidu.android.systemmonitor.a.a.a(this.a.getApplicationContext()).a(arrayList);
    }
}
