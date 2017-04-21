package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s LP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.LP = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.LP.LB;
        if (textView != null) {
            textView2 = this.LP.LB;
            textView2.setVisibility(4);
            textView3 = this.LP.LB;
            textView3.setText("");
        }
    }
}
