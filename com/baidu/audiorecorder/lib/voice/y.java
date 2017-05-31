package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes2.dex */
class y implements Runnable {
    final /* synthetic */ s KV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.KV = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.KV.KF;
        if (textView != null) {
            textView2 = this.KV.KF;
            textView2.setVisibility(4);
            textView3 = this.KV.KF;
            textView3.setText("");
        }
    }
}
