package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ am abq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.abq = amVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.uh().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.uh().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.uh().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.uh().remove("pullview_background_color_night");
        this.abq.vo();
        this.abq.vj();
    }
}
