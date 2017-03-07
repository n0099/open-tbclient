package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ s Mm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.Mm = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Mm.LW;
        if (textView != null) {
            textView2 = this.Mm.LW;
            textView2.setVisibility(4);
            textView3 = this.Mm.LW;
            textView3.setText("");
        }
    }
}
