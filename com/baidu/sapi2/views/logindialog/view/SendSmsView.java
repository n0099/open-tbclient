package com.baidu.sapi2.views.logindialog.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class SendSmsView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String i = "sdk_situation";
    public static final String j = "pop_login";
    public static final String k = "skipreg";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public EditText b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public ISendSmsCallback f;
    public ILoginConfirmCallback g;
    public ISendSmsUICallback h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendSmsView a;

        public a(SendSmsView sendSmsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendSmsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sendSmsView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b.setText("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendSmsView a;

        public b(SendSmsView sendSmsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendSmsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sendSmsView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String trim = editable.toString().trim();
                if (TextUtils.isEmpty(trim) || trim.length() == 0) {
                    this.a.c.setVisibility(8);
                    this.a.d.setVisibility(8);
                    this.a.h.onShowThirdParty();
                } else {
                    this.a.c.setVisibility(0);
                    this.a.d.setVisibility(0);
                    this.a.h.onHideThirdParty();
                }
                this.a.h.onHideErrorTip();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendSmsView a;

        public c(SendSmsView sendSmsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendSmsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sendSmsView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null) {
                    if (this.a.g.onPreStart(false)) {
                        String trim = this.a.b.getText().toString().trim();
                        if (!TextUtils.isEmpty(trim) && trim.length() == 11) {
                            this.a.b(trim);
                            return;
                        } else {
                            ToastUtil.show("请您输入正确的手机号");
                            return;
                        }
                    }
                    Log.e(QuickLoginDialog.STAG, "sharelogin privacy is not agree");
                    return;
                }
                Log.e(QuickLoginDialog.STAG, "sharelogin mWebAuthListener is null");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendSmsView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public TextView getTvSendSms() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (TextView) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendSmsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sdk_situation", "pop_login");
            hashMap.put("skipreg", "1");
            SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback(this, System.currentTimeMillis(), str) { // from class: com.baidu.sapi2.views.logindialog.view.SendSmsView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ String b;
                public final /* synthetic */ SendSmsView c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r7), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = r7;
                    this.b = str;
                }

                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    }
                }

                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, getDynamicPwdResult) == null) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("get_sms_code", System.currentTimeMillis() - this.a, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                        if (this.c.f != null) {
                            this.c.f.onSendSmsFailure(this.b, getDynamicPwdResult);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, getDynamicPwdResult) == null) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("get_sms_code", System.currentTimeMillis() - this.a, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                        if (this.c.f != null) {
                            this.c.f.onSendSmsFailure(this.b, getDynamicPwdResult);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, getDynamicPwdResult) == null) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("get_sms_code", System.currentTimeMillis() - this.a, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                        if (this.c.f != null) {
                            if (getDynamicPwdResult.getResultCode() != 0) {
                                this.c.f.onSendSmsFailure(this.b, getDynamicPwdResult);
                            } else {
                                this.c.f.onSendSmsSuccess(true, this.b, getDynamicPwdResult);
                            }
                        }
                    }
                }
            }, str, null, hashMap);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04c5, this);
            setOrientation(1);
            this.b = (EditText) findViewById(R.id.obfuscated_res_0x7f091cdc);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cf2);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091d49);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091d44);
            this.c.setOnClickListener(new a(this));
            this.b.addTextChangedListener(new b(this));
            this.d.setOnClickListener(new c(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendSmsView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = context;
        c();
    }

    public void a(ILoginConfirmCallback iLoginConfirmCallback, ISendSmsCallback iSendSmsCallback, ISendSmsUICallback iSendSmsUICallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, iLoginConfirmCallback, iSendSmsCallback, iSendSmsUICallback) == null) {
            this.g = iLoginConfirmCallback;
            this.f = iSendSmsCallback;
            this.h = iSendSmsUICallback;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setTextColor(Color.parseColor("#CCFFFFFF"));
            this.b.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e78));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.setVisibility(8);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e.setText(str);
            this.e.setVisibility(0);
        }
    }

    public void a(Activity activity) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || (editText = this.b) == null) {
            return;
        }
        editText.setFocusable(true);
        this.b.setFocusableInTouchMode(true);
        this.b.requestFocus();
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(this.b, 0);
    }
}
