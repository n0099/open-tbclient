package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements Runnable {
    final /* synthetic */ av Js;
    private final /* synthetic */ String Jt;
    private final /* synthetic */ String Jw;
    private final /* synthetic */ int Jx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(av avVar, String str, String str2, int i) {
        this.Js = avVar;
        this.Jw = str;
        this.Jt = str2;
        this.Jx = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Js.d(this.Jw, this.Jt, this.Jx);
    }
}
