package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes2.dex */
class w implements Runnable {
    final /* synthetic */ s Lh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.Lh = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Lh.KR;
        if (textView != null) {
            textView2 = this.Lh.KR;
            textView2.setVisibility(4);
            textView3 = this.Lh.KR;
            textView3.setText("");
        }
    }
}
