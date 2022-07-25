package com.baidu.sapi2.views.logindialog.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
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
public class HistoryLoginView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String j = "quick_login";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Activity b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public LoginHistoryModel h;
    public ILoginConfirmCallback i;

    /* loaded from: classes2.dex */
    public class a implements AsyncImageLoader.IAsyncImageLoaderListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HistoryLoginView a;

        public a(HistoryLoginView historyLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {historyLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = historyLoginView;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
        public void onComplete(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                this.a.d.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HistoryLoginView(Context context) {
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

    public TextView getTvButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HistoryLoginView(Context context, @Nullable AttributeSet attributeSet) {
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

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04b9, this);
            this.c = findViewById(R.id.obfuscated_res_0x7f091c69);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f091bdc);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091bdb);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091bdd);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091c5d);
            View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: com.baidu.sapi2.views.logindialog.view.HistoryLoginView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HistoryLoginView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.a.b != null) {
                            if (this.a.h != null) {
                                if (this.a.i != null) {
                                    if (!this.a.i.onPreStart(false)) {
                                        Log.e(QuickLoginDialog.STAG, "sharelogin privacy is not agree");
                                        return;
                                    }
                                    SapiAccountManager.getInstance().loadHistoryActionLoginFromNa(this.a.h, new LoginHistoryCallback(this, System.currentTimeMillis()) { // from class: com.baidu.sapi2.views.logindialog.view.HistoryLoginView.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ long a;
                                        public final /* synthetic */ AnonymousClass1 b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, Long.valueOf(r7)};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.b = this;
                                            this.a = r7;
                                        }

                                        @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                                        public void onLoginFailure() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                if (this.b.a.i == null) {
                                                    Log.e(QuickLoginDialog.STAG, "sharelogin mWebAuthListener is null");
                                                    return;
                                                }
                                                com.baidu.sapi2.views.logindialog.utils.a.a("history_login", System.currentTimeMillis() - this.a, 1, "失败");
                                                QuickLoginResult quickLoginResult = new QuickLoginResult();
                                                quickLoginResult.setResultCode(-202);
                                                quickLoginResult.setResultMsg("网络连接失败，请检查网络设置");
                                                quickLoginResult.mLoginType = QuickLoginType.HISTORY;
                                                this.b.a.i.onFailure(quickLoginResult);
                                            }
                                        }

                                        @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                                        public void onLoginSuccess(SapiAccount sapiAccount) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiAccount) == null) {
                                                if (this.b.a.i == null) {
                                                    Log.e(QuickLoginDialog.STAG, "sharelogin mWebAuthListener is null");
                                                    return;
                                                }
                                                com.baidu.sapi2.views.logindialog.utils.a.a("history_login", System.currentTimeMillis() - this.a, 0, "成功");
                                                QuickLoginResult quickLoginResult = new QuickLoginResult();
                                                quickLoginResult.setResultCode(0);
                                                quickLoginResult.setResultMsg("成功");
                                                quickLoginResult.mLoginType = QuickLoginType.HISTORY;
                                                this.b.a.i.onSuccess(quickLoginResult);
                                            }
                                        }
                                    });
                                    return;
                                }
                                Log.e(QuickLoginDialog.STAG, "sharelogin mWebAuthListener is null");
                                return;
                            }
                            Log.e(QuickLoginDialog.STAG, "sharelogin mShareModel is null");
                            return;
                        }
                        Log.e(QuickLoginDialog.STAG, "sharelogin mActivity is null");
                    }
                }
            };
            this.c.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.h == null || this.a == null) {
            return;
        }
        ImageManager.getInstance().loadImage(this.a, Uri.parse(this.h.portrait), new a(this));
        this.e.setText(this.h.displayname);
        this.f.setText("最近登录帐号，可一键登录");
    }

    public void a(Activity activity, LoginHistoryModel loginHistoryModel, ILoginConfirmCallback iLoginConfirmCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, loginHistoryModel, iLoginConfirmCallback) == null) {
            this.b = activity;
            this.h = loginHistoryModel;
            this.i = iLoginConfirmCallback;
            c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryLoginView(Context context, @Nullable AttributeSet attributeSet, int i) {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.setTextColor(Color.parseColor("#CCFFFFFF"));
            this.f.setTextColor(Color.parseColor("#80FFFFFF"));
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e17));
        }
    }
}
