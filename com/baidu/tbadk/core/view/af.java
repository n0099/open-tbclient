package com.baidu.tbadk.core.view;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ TextureVideoView ahh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(TextureVideoView textureVideoView) {
        this.ahh = textureVideoView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        String str;
        Context context;
        String str2;
        z = this.ahh.agZ;
        if (!z) {
            str = this.ahh.agw;
            com.baidu.tieba.play.m.hb(str);
            context = this.ahh.mContext;
            str2 = this.ahh.agw;
            com.baidu.tieba.play.m.G(context, str2);
        }
    }
}
