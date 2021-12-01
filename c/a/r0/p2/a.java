package c.a.r0.p2;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.PayVcodeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class a extends c.a.d.a.d<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PayVcodeActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f21277b;

    /* renamed from: c  reason: collision with root package name */
    public View f21278c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f21279d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21280e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f21281f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21282g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f21283h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payVcodeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        h(payVcodeActivity);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21278c : (View) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21282g : (TextView) invokeV.objValue;
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21280e : (TextView) invokeV.objValue;
    }

    public ViewGroup f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21279d : (ViewGroup) invokeV.objValue;
    }

    public BaseWebView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21281f : (BaseWebView) invokeV.objValue;
    }

    public final void h(PayVcodeActivity payVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, payVcodeActivity) == null) {
            this.f21277b = (ViewGroup) this.a.findViewById(R.id.payvcode_parent);
            TextView textView = (TextView) this.a.findViewById(R.id.payment_performance);
            this.f21280e = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f21280e, R.color.CAM_X0101, 1);
            this.f21281f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
            this.f21282g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
            this.f21278c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
            this.f21279d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
            this.f21283h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
            this.f21281f.setHorizontalScrollBarEnabled(false);
            this.f21281f.setHorizontalScrollbarOverlay(false);
            this.f21281f.setScrollBarStyle(33554432);
            this.f21281f.getSettings().setJavaScriptEnabled(true);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f21282g.setVisibility(z ? 0 : 8);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f21283h.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            c.a.q0.w0.a.a(this.a.getPageContext(), this.f21277b);
            SkinManager.setBgColor(this.f21282g, i2);
            SkinManager.setBackgroundResource(this.f21280e, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f21280e, R.color.CAM_X0101, 1);
        }
    }
}
