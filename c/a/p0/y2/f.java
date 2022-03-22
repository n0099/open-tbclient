package c.a.p0.y2;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f extends c.a.d.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RoundLinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20786b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20787c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20788d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20789e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f20790f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20791g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20792h;
    public TextView i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20790f = tbPageContext;
        k(tbPageContext, onClickListener);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20788d : (View) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20786b : (View) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20789e : (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20787c : (View) invokeV.objValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final void k(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, tbPageContext, onClickListener) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06c5, (ViewGroup) null);
            this.a = roundLinearLayout;
            roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0917d4);
            this.f20786b = textView;
            textView.setOnClickListener(onClickListener);
            TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0917d6);
            this.f20787c = textView2;
            textView2.setOnClickListener(onClickListener);
            TextView textView3 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0917d2);
            this.f20788d = textView3;
            textView3.setOnClickListener(onClickListener);
            TextView textView4 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0917d5);
            this.f20789e = textView4;
            textView4.setOnClickListener(onClickListener);
            TextView textView5 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0917d3);
            this.f20791g = textView5;
            textView5.setOnClickListener(onClickListener);
            this.f20792h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0917d7);
            TextView textView6 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0917d0);
            this.i = textView6;
            textView6.setOnClickListener(onClickListener);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundResource(this.a, R.color.CAM_X0211);
            SkinManager.setViewTextColorSelector(this.f20788d, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.f20786b, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.f20787c, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.f20789e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f20792h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColorSelector(this.i, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.f20791g, R.color.CAM_X0107);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f20789e.setVisibility(0);
            if (i == 0) {
                this.f20789e.setText(this.f20790f.getResources().getString(R.string.obfuscated_res_0x7f0f0b13));
            } else if (i == 1) {
                this.f20789e.setText(this.f20790f.getResources().getString(R.string.obfuscated_res_0x7f0f1460));
            }
        }
    }

    public void n(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.f20786b.setText(R.string.obfuscated_res_0x7f0f0f7f);
            } else {
                this.f20786b.setText(R.string.obfuscated_res_0x7f0f0722);
            }
            if (z2) {
                this.f20788d.setText(R.string.obfuscated_res_0x7f0f0f79);
            } else {
                this.f20788d.setText(R.string.obfuscated_res_0x7f0f030a);
            }
            if (z3) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f20792h.setVisibility(8);
                return;
            }
            this.f20792h.setVisibility(0);
            this.f20792h.setText(String.format(this.f20790f.getResources().getString(R.string.obfuscated_res_0x7f0f0ad0), str));
        }
    }
}
