package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class OneKeyLoginView extends LinearLayout {
    public Context a;
    public TextView b;
    public TextView c;
    public ILoginConfirmCallback d;
    public String e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: com.baidu.sapi2.views.logindialog.view.OneKeyLoginView$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0143a extends OneKeyLoginCallback {
            public final /* synthetic */ long a;

            public C0143a(long j) {
                this.a = j;
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onFail(OneKeyLoginResult oneKeyLoginResult) {
                super.onFail(oneKeyLoginResult);
                if (OneKeyLoginView.this.d == null) {
                    Log.e(QuickLoginDialog.STAG, "onekey login onFail mConfirmCallback is null");
                    return;
                }
                if (TextUtils.isEmpty(OneKeyLoginView.this.e)) {
                    com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login", System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                } else {
                    com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login_" + OneKeyLoginView.this.e.toLowerCase(), System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                }
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(oneKeyLoginResult.getResultCode());
                quickLoginResult.setResultMsg(oneKeyLoginResult.getResultMsg());
                quickLoginResult.mLoginType = QuickLoginType.ONEKEY;
                OneKeyLoginView.this.d.onFailure(quickLoginResult);
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
                super.onSuccess(oneKeyLoginResult);
                if (OneKeyLoginView.this.d == null) {
                    Log.e(QuickLoginDialog.STAG, "onekey login onSuccess mConfirmCallback is null");
                } else if (oneKeyLoginResult == null) {
                } else {
                    if (TextUtils.isEmpty(OneKeyLoginView.this.e)) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login", System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                    } else {
                        com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login_" + OneKeyLoginView.this.e.toLowerCase(), System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                    }
                    QuickLoginResult quickLoginResult = new QuickLoginResult();
                    quickLoginResult.setResultCode(oneKeyLoginResult.getResultCode());
                    quickLoginResult.setResultMsg(oneKeyLoginResult.getResultMsg());
                    quickLoginResult.mLoginType = QuickLoginType.ONEKEY;
                    quickLoginResult.mOperator = OneKeyLoginView.this.e;
                    OneKeyLoginView.this.d.onSuccess(quickLoginResult);
                }
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (OneKeyLoginView.this.a != null && OneKeyLoginView.this.d != null) {
                if (!OneKeyLoginView.this.d.onPreStart(true)) {
                    Log.e(QuickLoginDialog.STAG, "onekey login privacy is not agree");
                    return;
                }
                CoreViewRouter.getInstance().loadOneKeyLogin(OneKeyLoginView.this.a, new C0143a(System.currentTimeMillis()));
                return;
            }
            Log.e(QuickLoginDialog.STAG, "onekey login mContext || mConfirmCallback is null");
        }
    }

    public OneKeyLoginView(Context context) {
        this(context, null);
    }

    public OneKeyLoginView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OneKeyLoginView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        b();
    }

    public void a(String str, String str2, ILoginConfirmCallback iLoginConfirmCallback) {
        this.b.setText(str);
        this.d = iLoginConfirmCallback;
        this.e = str2;
    }

    private void b() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_onekey, this);
        setOrientation(1);
        this.b = (TextView) findViewById(R.id.sapi_sdk_tv_onekey_number);
        TextView textView = (TextView) findViewById(R.id.sapi_sdk_tv_onekey_button);
        this.c = textView;
        textView.setOnClickListener(new a());
    }

    public void a() {
        this.b.setTextColor(Color.parseColor("#CCFFFFFF"));
    }

    public TextView getTvButton() {
        return this.c;
    }
}
