package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ ae aaF;
    private final /* synthetic */ String aaG;
    private final /* synthetic */ String aaJ;
    private final /* synthetic */ int aaK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ae aeVar, String str, String str2, int i) {
        this.aaF = aeVar;
        this.aaJ = str;
        this.aaG = str2;
        this.aaK = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaF.d(this.aaJ, this.aaG, this.aaK);
    }
}
