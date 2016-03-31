package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ al abO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.abO = alVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.vk().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.vk().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.vk().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.vk().remove("pullview_background_color_night");
        this.abO.wo();
        this.abO.wj();
    }
}
