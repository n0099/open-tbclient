package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ s Dx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(s sVar) {
        this.Dx = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Dx.Dh;
        if (textView != null) {
            textView2 = this.Dx.Dh;
            textView2.setVisibility(4);
            textView3 = this.Dx.Dh;
            textView3.setText("");
        }
    }
}
