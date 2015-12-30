package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s Mk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.Mk = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Mk.LW;
        if (textView != null) {
            textView2 = this.Mk.LW;
            textView2.setVisibility(4);
            textView3 = this.Mk.LW;
            textView3.setText("");
        }
    }
}
