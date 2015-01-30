package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {
    final /* synthetic */ av Js;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(av avVar) {
        this.Js = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Js.px();
    }
}
