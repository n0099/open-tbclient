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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class OneKeyLoginView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public TextView c;
    public ILoginConfirmCallback d;
    public String e;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OneKeyLoginView a;

        /* renamed from: com.baidu.sapi2.views.logindialog.view.OneKeyLoginView$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0137a extends OneKeyLoginCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ a b;

            public C0137a(a aVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = j;
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onFail(OneKeyLoginResult oneKeyLoginResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                    super.onFail(oneKeyLoginResult);
                    if (this.b.a.d == null) {
                        Log.e(QuickLoginDialog.STAG, "onekey login onFail mConfirmCallback is null");
                        return;
                    }
                    if (TextUtils.isEmpty(this.b.a.e)) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login", System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                    } else {
                        com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login_" + this.b.a.e.toLowerCase(), System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                    }
                    QuickLoginResult quickLoginResult = new QuickLoginResult();
                    quickLoginResult.setResultCode(oneKeyLoginResult.getResultCode());
                    quickLoginResult.setResultMsg(oneKeyLoginResult.getResultMsg());
                    quickLoginResult.mLoginType = QuickLoginType.ONEKEY;
                    this.b.a.d.onFailure(quickLoginResult);
                }
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                    super.onSuccess(oneKeyLoginResult);
                    if (this.b.a.d == null) {
                        Log.e(QuickLoginDialog.STAG, "onekey login onSuccess mConfirmCallback is null");
                    } else if (oneKeyLoginResult == null) {
                    } else {
                        if (TextUtils.isEmpty(this.b.a.e)) {
                            com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login", System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                        } else {
                            com.baidu.sapi2.views.logindialog.utils.a.a("onekey_login_" + this.b.a.e.toLowerCase(), System.currentTimeMillis() - this.a, oneKeyLoginResult.getResultCode(), oneKeyLoginResult.getResultMsg());
                        }
                        QuickLoginResult quickLoginResult = new QuickLoginResult();
                        quickLoginResult.setResultCode(oneKeyLoginResult.getResultCode());
                        quickLoginResult.setResultMsg(oneKeyLoginResult.getResultMsg());
                        quickLoginResult.mLoginType = QuickLoginType.ONEKEY;
                        quickLoginResult.mOperator = this.b.a.e;
                        this.b.a.d.onSuccess(quickLoginResult);
                    }
                }
            }
        }

        public a(OneKeyLoginView oneKeyLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oneKeyLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oneKeyLoginView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.a != null && this.a.d != null) {
                    if (!this.a.d.onPreStart(true)) {
                        Log.e(QuickLoginDialog.STAG, "onekey login privacy is not agree");
                        return;
                    }
                    CoreViewRouter.getInstance().loadOneKeyLogin(this.a.a, new C0137a(this, System.currentTimeMillis()));
                    return;
                }
                Log.e(QuickLoginDialog.STAG, "onekey login mContext || mConfirmCallback is null");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OneKeyLoginView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OneKeyLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneKeyLoginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = context;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04d5, this);
            setOrientation(1);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091d9a);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091d99);
            this.c = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setTextColor(Color.parseColor("#CCFFFFFF"));
        }
    }

    public TextView getTvButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (TextView) invokeV.objValue;
    }

    public void a(String str, String str2, ILoginConfirmCallback iLoginConfirmCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, iLoginConfirmCallback) == null) {
            this.b.setText(str);
            this.d = iLoginConfirmCallback;
            this.e = str2;
        }
    }
}
