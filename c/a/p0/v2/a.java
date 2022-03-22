package c.a.p0.v2;

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
/* loaded from: classes2.dex */
public class a extends c.a.d.a.d<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PayVcodeActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f19201b;

    /* renamed from: c  reason: collision with root package name */
    public View f19202c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f19203d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19204e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f19205f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19206g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f19207h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payVcodeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.obfuscated_res_0x7f0d0672);
        j(payVcodeActivity);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19202c : (View) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19206g : (TextView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19204e : (TextView) invokeV.objValue;
    }

    public ViewGroup h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19203d : (ViewGroup) invokeV.objValue;
    }

    public BaseWebView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19205f : (BaseWebView) invokeV.objValue;
    }

    public final void j(PayVcodeActivity payVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, payVcodeActivity) == null) {
            this.f19201b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091681);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09167b);
            this.f19204e = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f19204e, R.color.CAM_X0101, 1);
            this.f19205f = (BaseWebView) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f0922f0);
            this.f19206g = (TextView) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f092451);
            this.f19202c = payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f09167f);
            this.f19203d = (ViewGroup) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f091680);
            this.f19207h = (ProgressBar) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f091682);
            this.f19205f.setHorizontalScrollBarEnabled(false);
            this.f19205f.setHorizontalScrollbarOverlay(false);
            this.f19205f.setScrollBarStyle(33554432);
            this.f19205f.getSettings().setJavaScriptEnabled(true);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f19206g.setVisibility(z ? 0 : 8);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f19207h.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            c.a.o0.w0.a.a(this.a.getPageContext(), this.f19201b);
            SkinManager.setBgColor(this.f19206g, i);
            SkinManager.setBackgroundResource(this.f19204e, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f19204e, R.color.CAM_X0101, 1);
        }
    }
}
