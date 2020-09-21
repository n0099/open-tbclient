package com.baidu.mobads.production.e;

import android.os.CountDownTimer;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e extends CountDownTimer {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, long j, long j2) {
        super(j, j2);
        this.a = bVar;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        int i = (int) (j / 1000);
        int i2 = i <= 5 ? i : 5;
        textView = this.a.z;
        textView.setText(String.valueOf(i2));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.a.x.d("CountDownTimer finished");
        this.a.u();
        this.a.h.stop();
    }
}
