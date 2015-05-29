package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ u Ls;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.Ls = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Ls.Lc;
        if (textView != null) {
            textView2 = this.Ls.Lc;
            textView2.setVisibility(4);
            textView3 = this.Ls.Lc;
            textView3.setText("");
        }
    }
}
