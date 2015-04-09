package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ u LA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.LA = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.LA.Lk;
        if (textView != null) {
            textView2 = this.LA.Lk;
            textView2.setVisibility(4);
            textView3 = this.LA.Lk;
            textView3.setText("");
        }
    }
}
