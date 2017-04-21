package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ s LP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(s sVar) {
        this.LP = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.LP.Lz;
        if (textView != null) {
            textView2 = this.LP.Lz;
            textView2.setVisibility(4);
            textView3 = this.LP.Lz;
            textView3.setText("");
        }
    }
}
