package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class e implements Runnable {
    final /* synthetic */ d aqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aqi = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aqi;
        i = this.aqi.aqf;
        dVar.aqf = (i + 1) % 10;
    }
}
