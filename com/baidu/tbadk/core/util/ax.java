package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements Runnable {
    final /* synthetic */ at Vd;
    private final /* synthetic */ String Ve;
    private final /* synthetic */ String Vh;
    private final /* synthetic */ int Vi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(at atVar, String str, String str2, int i) {
        this.Vd = atVar;
        this.Vh = str;
        this.Ve = str2;
        this.Vi = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Vd.d(this.Vh, this.Ve, this.Vi);
    }
}
