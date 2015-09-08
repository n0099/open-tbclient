package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ ae aaO;
    private final /* synthetic */ String aaP;
    private final /* synthetic */ String aaS;
    private final /* synthetic */ int aaT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ae aeVar, String str, String str2, int i) {
        this.aaO = aeVar;
        this.aaS = str;
        this.aaP = str2;
        this.aaT = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaO.d(this.aaS, this.aaP, this.aaT);
    }
}
