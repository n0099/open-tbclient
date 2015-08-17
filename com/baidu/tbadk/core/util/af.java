package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ ae aaF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.aaF = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.sharedPref.b.ts().remove("pull_image_url");
        com.baidu.tbadk.core.sharedPref.b.ts().remove("pull_image_num");
        com.baidu.tbadk.core.sharedPref.b.ts().remove("pullview_background_color_day");
        com.baidu.tbadk.core.sharedPref.b.ts().remove("pullview_background_color_night");
        this.aaF.ux();
        this.aaF.us();
    }
}
