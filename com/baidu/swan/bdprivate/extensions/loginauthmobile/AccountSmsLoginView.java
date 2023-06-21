package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tieba.R;
import com.baidu.tieba.ap3;
/* loaded from: classes4.dex */
public class AccountSmsLoginView extends SmsLoginView {
    public Context w;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ap3.a(AccountSmsLoginView.this.w, ((FragmentActivity) AccountSmsLoginView.this.w).getWindow().getDecorView().getWindowToken());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ap3.b(AccountSmsLoginView.this.w, false);
        }
    }

    public AccountSmsLoginView(Context context) {
        super(context);
        this.w = context;
        p();
    }

    public AccountSmsLoginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = context;
        p();
    }

    public AccountSmsLoginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = context;
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
        ((EditText) findViewById(R.id.obfuscated_res_0x7f091bd5)).requestFocus();
        new Handler().postDelayed(new b(), 100L);
    }
}
