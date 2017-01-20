package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ ah aas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.aas = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.tQ().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tQ().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tQ().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tQ().remove("pullview_background_color_night");
        this.aas.uW();
        this.aas.uR();
    }
}
