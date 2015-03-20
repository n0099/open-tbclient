package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements Runnable {
    final /* synthetic */ at Vb;
    private final /* synthetic */ String Vc;
    private final /* synthetic */ String Vf;
    private final /* synthetic */ int Vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(at atVar, String str, String str2, int i) {
        this.Vb = atVar;
        this.Vf = str;
        this.Vc = str2;
        this.Vg = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Vb.d(this.Vf, this.Vc, this.Vg);
    }
}
