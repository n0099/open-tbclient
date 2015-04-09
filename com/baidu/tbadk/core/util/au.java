package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements Runnable {
    final /* synthetic */ at Vd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.Vd = atVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.rB().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.rB().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.rB().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.rB().remove("pullview_background_color_night");
        this.Vd.sS();
        this.Vd.sN();
    }
}
