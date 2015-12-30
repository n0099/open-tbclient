package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ak acf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.acf = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.tJ().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tJ().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tJ().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tJ().remove("pullview_background_color_night");
        this.acf.uQ();
        this.acf.uL();
    }
}
