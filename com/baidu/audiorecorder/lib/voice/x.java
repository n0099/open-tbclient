package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ u LA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.LA = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.LA.Lm;
        if (textView != null) {
            textView2 = this.LA.Lm;
            textView2.setVisibility(4);
            textView3 = this.LA.Lm;
            textView3.setText("");
        }
    }
}
