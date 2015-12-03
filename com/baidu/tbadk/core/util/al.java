package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ak abB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.abB = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.tZ().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tZ().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tZ().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tZ().remove("pullview_background_color_night");
        this.abB.vg();
        this.abB.vb();
    }
}
