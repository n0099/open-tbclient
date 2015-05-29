package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements Runnable {
    final /* synthetic */ aq VI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.VI = aqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.sl().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.sl().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.sl().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.sl().remove("pullview_background_color_night");
        this.VI.tv();
        this.VI.tq();
    }
}
