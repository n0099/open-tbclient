package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ aj abg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.abg = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.tW().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tW().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tW().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tW().remove("pullview_background_color_night");
        this.abg.vc();
        this.abg.uX();
    }
}
