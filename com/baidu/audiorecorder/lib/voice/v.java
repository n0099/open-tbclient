package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s Mz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.Mz = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Mz.Ml;
        if (textView != null) {
            textView2 = this.Mz.Ml;
            textView2.setVisibility(4);
            textView3 = this.Mz.Ml;
            textView3.setText("");
        }
    }
}
