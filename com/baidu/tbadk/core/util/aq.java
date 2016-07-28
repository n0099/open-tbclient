package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements Runnable {
    final /* synthetic */ am Yp;
    private final /* synthetic */ String Yq;
    private final /* synthetic */ String Yt;
    private final /* synthetic */ int Yu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(am amVar, String str, String str2, int i) {
        this.Yp = amVar;
        this.Yt = str;
        this.Yq = str2;
        this.Yu = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yp.c(this.Yt, this.Yq, this.Yu);
    }
}
