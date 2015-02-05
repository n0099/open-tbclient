package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ av Jp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.Jp = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.oc().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.oc().remove("pull_image_num");
        this.Jp.pv();
        this.Jp.pq();
    }
}
