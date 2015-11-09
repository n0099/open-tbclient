package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ af aaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.aaO = afVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.tu().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tu().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tu().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tu().remove("pullview_background_color_night");
        this.aaO.uA();
        this.aaO.uv();
    }
}
