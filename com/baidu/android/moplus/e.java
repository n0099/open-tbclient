package com.baidu.android.moplus;

import java.util.ArrayList;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MoPlusService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MoPlusService moPlusService) {
        this.a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.baidu.android.a.g.ALL_USER);
        com.baidu.android.systemmonitor.a.a.a(this.a.getApplicationContext()).a(arrayList);
    }
}
