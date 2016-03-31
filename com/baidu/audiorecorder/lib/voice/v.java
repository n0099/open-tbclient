package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s MF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.MF = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.MF.Mr;
        if (textView != null) {
            textView2 = this.MF.Mr;
            textView2.setVisibility(4);
            textView3 = this.MF.Mr;
            textView3.setText("");
        }
    }
}
