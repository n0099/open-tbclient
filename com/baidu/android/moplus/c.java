package com.baidu.android.moplus;

import java.util.ArrayList;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ MoPlusService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MoPlusService moPlusService) {
        this.a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.android.systemmonitor.util.e.b(this.a.getApplicationContext())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.baidu.android.a.g.ACTIVE_EVENT);
        com.baidu.android.systemmonitor.a.a.a(this.a.getApplicationContext()).a(arrayList);
    }
}
