package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ u Ly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.Ly = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.Ly.Lk;
        if (textView != null) {
            textView2 = this.Ly.Lk;
            textView2.setVisibility(4);
            textView3 = this.Ly.Lk;
            textView3.setText("");
        }
    }
}
