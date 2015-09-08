package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ ae aaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.aaO = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.tx().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.tx().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.tx().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.tx().remove("pullview_background_color_night");
        this.aaO.uC();
        this.aaO.ux();
    }
}
