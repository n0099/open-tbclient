package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s EY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.EY = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.EY.EK;
        if (textView != null) {
            textView2 = this.EY.EK;
            textView2.setVisibility(4);
            textView3 = this.EY.EK;
            textView3.setText("");
        }
    }
}
