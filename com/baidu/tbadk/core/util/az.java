package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements Runnable {
    final /* synthetic */ av Jp;
    private final /* synthetic */ String Jq;
    private final /* synthetic */ String Jt;
    private final /* synthetic */ int Ju;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(av avVar, String str, String str2, int i) {
        this.Jp = avVar;
        this.Jt = str;
        this.Jq = str2;
        this.Ju = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Jp.d(this.Jt, this.Jq, this.Ju);
    }
}
