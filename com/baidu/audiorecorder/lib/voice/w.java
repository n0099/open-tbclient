package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ s CW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.CW = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.CW.CG;
        if (textView != null) {
            textView2 = this.CW.CG;
            textView2.setVisibility(4);
            textView3 = this.CW.CG;
            textView3.setText("");
        }
    }
}
