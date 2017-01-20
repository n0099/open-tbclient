package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ s EY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.EY = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.EY.EI;
        if (textView != null) {
            textView2 = this.EY.EI;
            textView2.setVisibility(4);
            textView3 = this.EY.EI;
            textView3.setText("");
        }
    }
}
