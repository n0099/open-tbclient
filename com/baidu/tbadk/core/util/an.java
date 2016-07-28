package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ am Yp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.Yp = amVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.sN().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.sN().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.sN().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.sN().remove("pullview_background_color_night");
        this.Yp.tT();
        this.Yp.tO();
    }
}
