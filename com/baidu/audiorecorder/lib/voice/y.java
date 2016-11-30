package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ s FM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.FM = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.FM.Fw;
        if (textView != null) {
            textView2 = this.FM.Fw;
            textView2.setVisibility(4);
            textView3 = this.FM.Fw;
            textView3.setText("");
        }
    }
}
