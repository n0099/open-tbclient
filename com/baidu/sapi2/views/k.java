package com.baidu.sapi2.views;

import android.os.CountDownTimer;
import com.baidu.i.a.a;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes4.dex */
class k extends CountDownTimer {
    final /* synthetic */ SmsLoginView.c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SmsLoginView.c cVar, long j, long j2) {
        super(j, j2);
        this.a = cVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (SmsLoginView.this.h.getText().toString().length() == 11) {
            SmsLoginView.this.j.setEnabled(true);
            SmsLoginView.this.j.setText(a.g.sapi_sdk_sms_re_get_check_code);
            SmsLoginView.this.a(true);
            return;
        }
        SmsLoginView.this.j.setText(a.g.sapi_sdk_sms_get_check_code);
        SmsLoginView.this.a(false);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        SmsLoginView.this.j.setText((j / 1000) + SmsLoginView.this.e.getString(a.g.sapi_sdk_sms_second));
        SmsLoginView.this.j.setEnabled(false);
        SmsLoginView.this.a(false);
    }
}
