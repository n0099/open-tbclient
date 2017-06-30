package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes2.dex */
class y implements Runnable {
    final /* synthetic */ s KU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.KU = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.KU.KE;
        if (textView != null) {
            textView2 = this.KU.KE;
            textView2.setVisibility(4);
            textView3 = this.KU.KE;
            textView3.setText("");
        }
    }
}
