package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.baidu.sapi2.views.SmsLoginView;
import d.a.m0.a.v2.x;
import d.a.m0.b.e;
/* loaded from: classes3.dex */
public class AccountSmsLoginView extends SmsLoginView {
    public Context v;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.a(AccountSmsLoginView.this.v, ((FragmentActivity) AccountSmsLoginView.this.v).getWindow().getDecorView().getWindowToken());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.b(AccountSmsLoginView.this.v, false);
        }
    }

    public AccountSmsLoginView(Context context) {
        super(context);
        this.v = context;
        p();
    }

    @Override // com.baidu.sapi2.views.SmsLoginView
    public void clean() {
        super.clean();
    }

    @Override // com.baidu.sapi2.views.SmsLoginView
    public void close() {
        super.close();
        new Handler().postDelayed(new a(), 100L);
    }

    public void p() {
        ((EditText) findViewById(e.phone)).requestFocus();
        new Handler().postDelayed(new b(), 100L);
    }

    public AccountSmsLoginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = context;
        p();
    }

    public AccountSmsLoginView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.v = context;
        p();
    }
}
