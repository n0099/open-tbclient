package b.a.r0.j2;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
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
/* loaded from: classes4.dex */
public class a extends b.a.e.a.d<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f18577a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f18578b;

    /* renamed from: c  reason: collision with root package name */
    public View f18579c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f18580d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18581e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f18582f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18583g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f18584h;

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
        this.f18577a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        h(payVcodeActivity);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18579c : (View) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18583g : (TextView) invokeV.objValue;
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18581e : (TextView) invokeV.objValue;
    }

    public ViewGroup f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18580d : (ViewGroup) invokeV.objValue;
    }

    public BaseWebView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18582f : (BaseWebView) invokeV.objValue;
    }

    public final void h(PayVcodeActivity payVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, payVcodeActivity) == null) {
            this.f18578b = (ViewGroup) this.f18577a.findViewById(R.id.payvcode_parent);
            TextView textView = (TextView) this.f18577a.findViewById(R.id.payment_performance);
            this.f18581e = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f18581e, R.color.CAM_X0101, 1);
            this.f18582f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
            this.f18583g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
            this.f18579c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
            this.f18580d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
            this.f18584h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
            this.f18582f.setHorizontalScrollBarEnabled(false);
            this.f18582f.setHorizontalScrollbarOverlay(false);
            this.f18582f.setScrollBarStyle(33554432);
            this.f18582f.getSettings().setJavaScriptEnabled(true);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f18583g.setVisibility(z ? 0 : 8);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f18584h.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            b.a.q0.w0.a.a(this.f18577a.getPageContext(), this.f18578b);
            SkinManager.setBgColor(this.f18583g, i2);
            SkinManager.setBackgroundResource(this.f18581e, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f18581e, R.color.CAM_X0101, 1);
        }
    }
}
