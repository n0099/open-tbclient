package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ s LN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.LN = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.LN.Lx;
        if (textView != null) {
            textView2 = this.LN.Lx;
            textView2.setVisibility(4);
            textView3 = this.LN.Lx;
            textView3.setText("");
        }
    }
}
