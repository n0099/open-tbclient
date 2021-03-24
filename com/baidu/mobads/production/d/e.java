package com.baidu.mobads.production.d;

import android.os.CountDownTimer;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class e extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f8457a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, long j, long j2) {
        super(j, j2);
        this.f8457a = bVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f8457a.A.d("CountDownTimer finished");
        this.f8457a.u();
        this.f8457a.f8440h.stop();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        int i = (int) (j / 1000);
        if (i > 5) {
            i = 5;
        }
        textView = this.f8457a.C;
        textView.setText(String.valueOf(i));
    }
}
