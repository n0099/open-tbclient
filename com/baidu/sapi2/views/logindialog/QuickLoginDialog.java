package com.baidu.sapi2.views.logindialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.callback.QuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback;
import com.baidu.sapi2.views.logindialog.page.LoginPager;
import com.baidu.sapi2.views.logindialog.page.SmsPager;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import com.baidu.sapi2.views.logindialog.view.LoadingView;
import com.baidu.sapi2.views.logindialog.view.NoScrollViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class QuickLoginDialog extends Dialog implements View.OnClickListener, IPagerLoadCallback, ISendSmsCallback, IQuickLoginDialogCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEIGHT_HISTORY = 256;
    public static final int HEIGHT_ONEKEY = 238;
    public static final int HEIGHT_SHARE = 256;
    public static final int HEIGHT_SMS = 181;
    public static final int HEIGHT_VERITFY_CODE = 181;
    public static final String STAG = "QuickLoginDialog";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ColorType b;
    public LinearLayout c;
    public ImageView d;
    public TextView e;
    public ImageView f;
    public NoScrollViewPager g;
    public LoadingView h;
    public LoginPager i;
    public SmsPager j;
    public List<Integer> k;
    public com.baidu.sapi2.views.logindialog.a.a l;
    public int m;
    public IQuickLoginDialogCallback n;

    /* loaded from: classes2.dex */
    public static class Builder implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Activity a;
        public ColorType b;
        public QuickLoginDialogCallback c;

        public Builder(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ColorType.LIGHT;
            this.a = activity;
        }

        public QuickLoginDialog build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new QuickLoginDialog(this) : (QuickLoginDialog) invokeV.objValue;
        }

        public Builder setColorType(ColorType colorType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, colorType)) == null) {
                this.b = colorType;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDialogCallback(QuickLoginDialogCallback quickLoginDialogCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, quickLoginDialogCallback)) == null) {
                this.c = quickLoginDialogCallback;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuickLoginDialog a;

        public a(QuickLoginDialog quickLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = quickLoginDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.c();
                if (this.a.n != null) {
                    this.a.n.onDismiss();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuickLoginDialog a;

        public b(QuickLoginDialog quickLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = quickLoginDialog;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i == 0) {
                    this.a.d.setVisibility(8);
                    this.a.e.setText("登录你的百度，精彩永相随");
                    if (this.a.n != null) {
                        this.a.n.onPreShowDialog(this.a.b, this.a.c, this.a.e);
                    }
                } else {
                    this.a.d.setVisibility(0);
                    this.a.e.setText("请输入短信验证码");
                }
                ViewGroup.LayoutParams layoutParams = this.a.g.getLayoutParams();
                layoutParams.height = ((Integer) this.a.k.get(i)).intValue();
                this.a.g.setLayoutParams(layoutParams);
                this.a.m = i;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ QuickLoginDialog b;

        public c(QuickLoginDialog quickLoginDialog, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickLoginDialog, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = quickLoginDialog;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.openRegister(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuickLoginDialog a;

        public d(QuickLoginDialog quickLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = quickLoginDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuickLoginDialog a;

        public e(QuickLoginDialog quickLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = quickLoginDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                ToastUtil.show("登录失败：" + webAuthResult.getResultMsg());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                if (this.a.n != null) {
                    QuickLoginResult quickLoginResult = new QuickLoginResult();
                    quickLoginResult.setResultCode(webAuthResult.getResultCode());
                    quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                    quickLoginResult.mLoginType = QuickLoginType.FULL_SCREEN;
                    this.a.n.onLoginSuccess(quickLoginResult);
                }
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuickLoginDialog a;

        public f(QuickLoginDialog quickLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = quickLoginDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                ToastUtil.show("注册失败：" + webAuthResult.getResultMsg());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                if (this.a.n != null) {
                    QuickLoginResult quickLoginResult = new QuickLoginResult();
                    quickLoginResult.setResultCode(webAuthResult.getResultCode());
                    quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                    quickLoginResult.mLoginType = QuickLoginType.REGISTER;
                    this.a.n.onLoginSuccess(quickLoginResult);
                }
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1853163517, "Lcom/baidu/sapi2/views/logindialog/QuickLoginDialog$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1853163517, "Lcom/baidu/sapi2/views/logindialog/QuickLoginDialog$g;");
                    return;
                }
            }
            int[] iArr = new int[QuickLoginType.values().length];
            a = iArr;
            try {
                iArr[QuickLoginType.HISTORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[QuickLoginType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[QuickLoginType.ONEKEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QuickLoginDialog(@NonNull Builder builder) {
        this(builder.a, builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Builder) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                super.cancel();
            } catch (Exception e2) {
                Log.e(e2.getMessage(), new Object[0]);
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                super.dismiss();
            } catch (Exception e2) {
                Log.e(e2.getMessage(), new Object[0]);
            }
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback
    public void onChange2LoginPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j.a();
            this.g.setCurrentItem(0);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback
    public void onChange2SmsPage(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            this.j.a(str, i);
            this.j.c();
            this.g.setCurrentItem(1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091ccd) {
                com.baidu.sapi2.views.logindialog.utils.a.a("close");
                cancel();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cbe) {
                com.baidu.sapi2.views.logindialog.utils.a.a("back");
                onChange2LoginPage();
            }
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onLoginFailure(QuickLoginResult quickLoginResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, quickLoginResult) == null) {
            Log.e(STAG, "login result code : " + quickLoginResult.getResultCode() + ", result msg : " + quickLoginResult.getResultMsg());
            ToastUtil.show(quickLoginResult.getResultMsg());
            this.h.setVisibility(8);
            IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
            if (iQuickLoginDialogCallback != null) {
                iQuickLoginDialogCallback.onLoginFailure(quickLoginResult);
            }
            this.h.setVisibility(8);
            QuickLoginType quickLoginType = quickLoginResult.mLoginType;
            if (quickLoginType == QuickLoginType.HISTORY || quickLoginType == QuickLoginType.SHARE || quickLoginType == QuickLoginType.ONEKEY) {
                openScreenLogin(quickLoginResult.mLoginType, "");
            }
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onLoginSuccess(QuickLoginResult quickLoginResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, quickLoginResult) == null) {
            if (TextUtils.isEmpty(quickLoginResult.mOperator)) {
                com.baidu.sapi2.views.logindialog.utils.a.a("0", quickLoginResult.mLoginType);
            } else {
                com.baidu.sapi2.views.logindialog.utils.a.a("0", quickLoginResult.mLoginType.getValue() + "_" + quickLoginResult.mOperator.toLowerCase());
            }
            IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
            if (iQuickLoginDialogCallback != null) {
                iQuickLoginDialogCallback.onLoginSuccess(quickLoginResult);
            }
            this.h.setVisibility(8);
            Log.e(STAG, "login result code : " + quickLoginResult.getResultCode() + ", result msg : " + quickLoginResult.getResultMsg());
            cancel();
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback
    public void onPageLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
            if (iQuickLoginDialogCallback != null) {
                iQuickLoginDialogCallback.onPreShowLoading(this.b, this.h);
            }
            this.h.setVisibility(0);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback
    public void onPageShow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            int dp2px = ViewUtils.dp2px(this.a, i);
            if (this.k.isEmpty()) {
                a(i);
            } else {
                this.k.set(0, Integer.valueOf(dp2px));
            }
            ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
            layoutParams.height = dp2px;
            this.g.setLayoutParams(layoutParams);
            this.h.setVisibility(8);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowAgreement(TextView textView, SpannableStringBuilder spannableStringBuilder) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, textView, spannableStringBuilder) == null) || (iQuickLoginDialogCallback = this.n) == null) {
            return;
        }
        iQuickLoginDialogCallback.onPreShowAgreement(textView, spannableStringBuilder);
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowAgreementWithOperator(TextView textView, String str, SpannableStringBuilder spannableStringBuilder) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048587, this, textView, str, spannableStringBuilder) == null) || (iQuickLoginDialogCallback = this.n) == null) {
            return;
        }
        iQuickLoginDialogCallback.onPreShowAgreementWithOperator(textView, str, spannableStringBuilder);
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowDialog(ColorType colorType, LinearLayout linearLayout, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, colorType, linearLayout, textView) == null) {
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowLoading(ColorType colorType, LoadingView loadingView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, colorType, loadingView) == null) {
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowLogin(ColorType colorType, QuickLoginType quickLoginType, TextView textView) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, colorType, quickLoginType, textView) == null) || (iQuickLoginDialogCallback = this.n) == null) {
            return;
        }
        iQuickLoginDialogCallback.onPreShowLogin(colorType, quickLoginType, textView);
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback
    public void onSendSmsFailure(String str, GetDynamicPwdResult getDynamicPwdResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, getDynamicPwdResult) == null) {
            int resultCode = getDynamicPwdResult.getResultCode();
            if (resultCode == 4) {
                int i = this.m;
                if (i == 0) {
                    this.i.showSendMsgErrorTip(getDynamicPwdResult.getResultMsg());
                } else if (i == 1) {
                    this.j.c(getDynamicPwdResult.getResultMsg());
                }
            } else if (resultCode == 5) {
                openScreenLogin(null, str);
            } else if (resultCode != 12) {
                ToastUtil.show("发送短信失败：" + getDynamicPwdResult.getResultMsg());
                openScreenLogin(null, str);
            } else {
                a(str);
            }
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback
    public void onSendSmsSuccess(boolean z, String str, GetDynamicPwdResult getDynamicPwdResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), str, getDynamicPwdResult}) == null) {
            int i = this.m;
            if (i == 0) {
                this.i.hideSendMsgErrorTip();
            } else if (i == 1) {
                this.j.b();
            }
            onChange2SmsPage(str, getDynamicPwdResult.smsCodeLength);
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            if (a(getContext(), motionEvent) && motionEvent.getAction() == 1) {
                com.baidu.sapi2.views.logindialog.utils.a.a("cancel");
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void openRegister(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            WebRegDTO webRegDTO = new WebRegDTO();
            webRegDTO.regType = WebRegDTO.EXTRA_REGISTER_MOBILE;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("loginUserName", str));
            webRegDTO.extraParams.addAll(arrayList);
            CoreViewRouter.getInstance().startRegister(new f(this), webRegDTO);
        }
    }

    public void openScreenLogin(QuickLoginType quickLoginType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, quickLoginType, str) == null) {
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.config = null;
            if (quickLoginType != null) {
                int i = g.a[quickLoginType.ordinal()];
                if (i == 1) {
                    webLoginDTO.excludeTypes = LoginTypes.HISTORY;
                } else if (i == 2) {
                    webLoginDTO.excludeTypes = LoginTypes.SHARE;
                } else if (i == 3) {
                    webLoginDTO.excludeTypes = LoginTypes.ONE_KEY_LOGIN;
                }
            }
            webLoginDTO.isAcceptBrowseModeAgreement = true;
            if (!TextUtils.isEmpty(str)) {
                webLoginDTO.preSetUname = str;
            }
            CoreViewRouter.getInstance().startLogin(new e(this), webLoginDTO);
        }
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnCancelListener(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onCancelListener) == null) {
        }
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onDismissListener) == null) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Context context = this.a;
                if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                    return;
                }
            }
            try {
                super.show();
            } catch (Exception e2) {
                Log.e(e2.getMessage(), new Object[0]);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QuickLoginDialog(@NonNull Context context, @NonNull Builder builder) {
        this(context, R.style.obfuscated_res_0x7f1003e0, builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (Builder) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d04c2);
            Window window = getWindow();
            window.setGravity(83);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            setCancelable(true);
            setCanceledOnTouchOutside(true);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d02);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cbe);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091d50);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ccd);
            this.h = (LoadingView) findViewById(R.id.obfuscated_res_0x7f091d10);
            this.g = (NoScrollViewPager) findViewById(R.id.obfuscated_res_0x7f091d15);
            this.d.setOnClickListener(this);
            this.f.setOnClickListener(this);
            c();
            if (this.k.isEmpty()) {
                a(181);
            }
            a();
            IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
            if (iQuickLoginDialogCallback != null) {
                iQuickLoginDialogCallback.onPreShowDialog(this.b, this.c, this.e);
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.g.setScanScroll(false);
            ArrayList arrayList = new ArrayList();
            LoginPager loginPager = new LoginPager(this.a, this.b, this, this, this);
            this.i = loginPager;
            arrayList.add(loginPager);
            SmsPager smsPager = new SmsPager(this.a, this.b, this, this, this);
            this.j = smsPager;
            arrayList.add(smsPager);
            com.baidu.sapi2.views.logindialog.a.a aVar = new com.baidu.sapi2.views.logindialog.a.a(arrayList);
            this.l = aVar;
            this.g.setAdapter(aVar);
            this.g.addOnPageChangeListener(new b(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickLoginDialog(@NonNull Context context, int i, @NonNull Builder builder) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.a = context;
        this.b = builder.b;
        this.n = builder.c;
        b();
        super.setOnDismissListener(new a(this));
    }

    private void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            this.k.add(0, Integer.valueOf(ViewUtils.dp2px(this.a, i)));
            this.k.add(1, Integer.valueOf(ViewUtils.dp2px(this.a, 181.0f)));
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            new CommonDialog.Builder(this.a).setTitle("提示").setMessage("您的手机号还未注册，点击完成注册").setDarkMode(ColorType.DARK == this.b).setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new d(this)).setPositiveBtn("去注册", new c(this, str)).build().show();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && ColorType.DARK == this.b) {
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e72));
            this.e.setTextColor(Color.parseColor("#FFFFFF"));
            this.h.a();
        }
    }

    private boolean a(Context context, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, context, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int scaledWindowTouchSlop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
            View decorView = getWindow().getDecorView();
            int i = -scaledWindowTouchSlop;
            return x < i || y < i || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop;
        }
        return invokeLL.booleanValue;
    }
}
