package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s Dx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.Dx = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Dx.Dj;
        if (textView != null) {
            textView2 = this.Dx.Dj;
            textView2.setVisibility(4);
            textView3 = this.Dx.Dj;
            textView3.setText("");
        }
    }
}
