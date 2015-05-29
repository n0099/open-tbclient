package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements Runnable {
    final /* synthetic */ aq VI;
    private final /* synthetic */ String VJ;
    private final /* synthetic */ String VM;
    private final /* synthetic */ int VN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(aq aqVar, String str, String str2, int i) {
        this.VI = aqVar;
        this.VM = str;
        this.VJ = str2;
        this.VN = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.VI.d(this.VM, this.VJ, this.VN);
    }
}
