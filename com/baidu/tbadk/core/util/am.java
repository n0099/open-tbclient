package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ai afp;
    private final /* synthetic */ String afq;
    private final /* synthetic */ String aft;
    private final /* synthetic */ int afu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar, String str, String str2, int i) {
        this.afp = aiVar;
        this.aft = str;
        this.afq = str2;
        this.afu = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afp.c(this.aft, this.afq, this.afu);
    }
}
