package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ s FN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.FN = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.FN.Fx;
        if (textView != null) {
            textView2 = this.FN.Fx;
            textView2.setVisibility(4);
            textView3 = this.FN.Fx;
            textView3.setText("");
        }
    }
}
