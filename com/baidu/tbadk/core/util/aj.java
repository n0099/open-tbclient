package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ ai afp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.afp = aiVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.tX().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tX().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tX().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tX().remove("pullview_background_color_night");
        this.afp.vd();
        this.afp.uY();
    }
}
