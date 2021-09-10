package c.a.r0.i2;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
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
/* loaded from: classes3.dex */
public class a extends c.a.e.a.d<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f19418a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f19419b;

    /* renamed from: c  reason: collision with root package name */
    public View f19420c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f19421d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19422e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f19423f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19424g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f19425h;

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
        this.f19418a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        h(payVcodeActivity);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19420c : (View) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19424g : (TextView) invokeV.objValue;
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19422e : (TextView) invokeV.objValue;
    }

    public ViewGroup f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19421d : (ViewGroup) invokeV.objValue;
    }

    public BaseWebView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19423f : (BaseWebView) invokeV.objValue;
    }

    public final void h(PayVcodeActivity payVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, payVcodeActivity) == null) {
            this.f19419b = (ViewGroup) this.f19418a.findViewById(R.id.payvcode_parent);
            TextView textView = (TextView) this.f19418a.findViewById(R.id.payment_performance);
            this.f19422e = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f19422e, R.color.CAM_X0101, 1);
            this.f19423f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
            this.f19424g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
            this.f19420c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
            this.f19421d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
            this.f19425h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
            this.f19423f.setHorizontalScrollBarEnabled(false);
            this.f19423f.setHorizontalScrollbarOverlay(false);
            this.f19423f.setScrollBarStyle(33554432);
            this.f19423f.getSettings().setJavaScriptEnabled(true);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f19424g.setVisibility(z ? 0 : 8);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f19425h.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            c.a.q0.w0.a.a(this.f19418a.getPageContext(), this.f19419b);
            SkinManager.setBgColor(this.f19424g, i2);
            SkinManager.setBackgroundResource(this.f19422e, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f19422e, R.color.CAM_X0101, 1);
        }
    }
}
