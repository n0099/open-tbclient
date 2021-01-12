package com.baidu.mobads.production.e;

import android.os.CountDownTimer;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class e extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3441a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, long j, long j2) {
        super(j, j2);
        this.f3441a = bVar;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        int i = (int) (j / 1000);
        int i2 = i <= 5 ? i : 5;
        textView = this.f3441a.z;
        textView.setText(String.valueOf(i2));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f3441a.x.d("CountDownTimer finished");
        this.f3441a.u();
        this.f3441a.h.stop();
    }
}
