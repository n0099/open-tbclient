package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s CX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.CX = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.CX.CJ;
        if (textView != null) {
            textView2 = this.CX.CJ;
            textView2.setVisibility(4);
            textView3 = this.CX.CJ;
            textView3.setText("");
        }
    }
}
