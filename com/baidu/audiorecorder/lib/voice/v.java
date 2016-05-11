package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s CW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.CW = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.CW.CI;
        if (textView != null) {
            textView2 = this.CW.CI;
            textView2.setVisibility(4);
            textView3 = this.CW.CI;
            textView3.setText("");
        }
    }
}
