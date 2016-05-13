package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ al Xo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.Xo = alVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.sR().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.sR().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.sR().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.sR().remove("pullview_background_color_night");
        this.Xo.tV();
        this.Xo.tQ();
    }
}
