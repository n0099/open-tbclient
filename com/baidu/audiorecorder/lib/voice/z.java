package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ u Ly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.Ly = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Ly.Li;
        if (textView != null) {
            textView2 = this.Ly.Li;
            textView2.setVisibility(4);
            textView3 = this.Ly.Li;
            textView3.setText("");
        }
    }
}
