package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ s LU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.LU = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.LU.LE;
        if (textView != null) {
            textView2 = this.LU.LE;
            textView2.setVisibility(4);
            textView3 = this.LU.LE;
            textView3.setText("");
        }
    }
}
