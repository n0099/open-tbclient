package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.widget.EditText;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.ap.w;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes25.dex */
public class AccountSmsLoginView extends SmsLoginView {
    private Context mContext;

    public AccountSmsLoginView(Context context) {
        super(context);
        this.mContext = context;
        aQI();
    }

    public AccountSmsLoginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aQI();
    }

    public AccountSmsLoginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        aQI();
    }

    @Override // com.baidu.sapi2.views.SmsLoginView
    public void clean() {
        super.clean();
    }

    @Override // com.baidu.sapi2.views.SmsLoginView
    public void close() {
        super.close();
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.AccountSmsLoginView.1
            @Override // java.lang.Runnable
            public void run() {
                w.forceHiddenSoftInput(AccountSmsLoginView.this.mContext, ((FragmentActivity) AccountSmsLoginView.this.mContext).getWindow().getDecorView().getWindowToken());
            }
        }, 100L);
    }

    public void aQI() {
        ((EditText) findViewById(b.e.phone)).requestFocus();
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.AccountSmsLoginView.2
            @Override // java.lang.Runnable
            public void run() {
                w.forceToggleSoftInput(AccountSmsLoginView.this.mContext, false);
            }
        }, 100L);
    }
}
