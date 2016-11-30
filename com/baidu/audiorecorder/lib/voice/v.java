package com.baidu.audiorecorder.lib.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s FM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.FM = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.FM.Fy;
        if (textView != null) {
            textView2 = this.FM.Fy;
            textView2.setVisibility(4);
            textView3 = this.FM.Fy;
            textView3.setText("");
        }
    }
}
