package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ s FK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.FK = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.FK.Fu;
        if (textView != null) {
            textView2 = this.FK.Fu;
            textView2.setVisibility(4);
            textView3 = this.FK.Fu;
            textView3.setText("");
        }
    }
}
