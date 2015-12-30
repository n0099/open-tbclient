package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ s Mk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(s sVar) {
        this.Mk = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Mk.LU;
        if (textView != null) {
            textView2 = this.Mk.LU;
            textView2.setVisibility(4);
            textView3 = this.Mk.LU;
            textView3.setText("");
        }
    }
}
