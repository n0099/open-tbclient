package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ av Js;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.Js = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.oj().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.oj().remove("pull_image_num");
        this.Js.pC();
        this.Js.px();
    }
}
