package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s FK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.FK = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.FK.Fw;
        if (textView != null) {
            textView2 = this.FK.Fw;
            textView2.setVisibility(4);
            textView3 = this.FK.Fw;
            textView3.setText("");
        }
    }
}
