package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements Runnable {
    final /* synthetic */ am abd;
    private final /* synthetic */ String abe;
    private final /* synthetic */ String abh;
    private final /* synthetic */ int abi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(am amVar, String str, String str2, int i) {
        this.abd = amVar;
        this.abh = str;
        this.abe = str2;
        this.abi = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abd.c(this.abh, this.abe, this.abi);
    }
}
