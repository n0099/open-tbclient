package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s FN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.FN = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.FN.Fz;
        if (textView != null) {
            textView2 = this.FN.Fz;
            textView2.setVisibility(4);
            textView3 = this.FN.Fz;
            textView3.setText("");
        }
    }
}
