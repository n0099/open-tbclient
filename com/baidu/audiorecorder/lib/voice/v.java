package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes2.dex */
class v implements Runnable {
    final /* synthetic */ s Lh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.Lh = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Lh.KT;
        if (textView != null) {
            textView2 = this.Lh.KT;
            textView2.setVisibility(4);
            textView3 = this.Lh.KT;
            textView3.setText("");
        }
    }
}
