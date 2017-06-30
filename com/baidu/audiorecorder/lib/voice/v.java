package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes2.dex */
class v implements Runnable {
    final /* synthetic */ s KU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.KU = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.KU.KG;
        if (textView != null) {
            textView2 = this.KU.KG;
            textView2.setVisibility(4);
            textView3 = this.KU.KG;
            textView3.setText("");
        }
    }
}
