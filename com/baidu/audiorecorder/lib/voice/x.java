package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ s Mz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(s sVar) {
        this.Mz = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Mz.Mj;
        if (textView != null) {
            textView2 = this.Mz.Mj;
            textView2.setVisibility(4);
            textView3 = this.Mz.Mj;
            textView3.setText("");
        }
    }
}
