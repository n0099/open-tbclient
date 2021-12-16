package c.a.s0.s2.u.f;

import android.view.View;
import android.widget.TextView;
import c.a.r0.s.r.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class g extends u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23003c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23003c = null;
    }

    @Override // c.a.s0.s2.u.f.u0
    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            TextView textView = (TextView) this.f23220b.findViewById(c.a.s0.s2.i.icon_push);
            this.f23003c = textView;
            textView.setVisibility(8);
        }
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23003c : (TextView) invokeV.objValue;
    }

    public void f(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) || d2Var == null || d2Var.P0() == null) {
            return;
        }
        int status = d2Var.P0().getStatus();
        if (status == 1) {
            g(true);
        } else if (status == 2) {
            g(false);
        }
    }

    public void g(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (textView = this.f23003c) == null) {
            return;
        }
        if (z) {
            textView.setText(c.a.s0.s2.l.push);
            SkinManager.setViewTextColor(this.f23003c, c.a.s0.s2.h.push_text_selector);
            SkinManager.setBackgroundResource(this.f23003c, c.a.s0.s2.h.push_bg_selector);
            this.f23003c.setClickable(true);
        } else {
            textView.setText(c.a.s0.s2.l.already_push);
            SkinManager.setBackgroundResource(this.f23003c, c.a.s0.s2.h.label_bg_gray80);
            SkinManager.setViewTextColor(this.f23003c, c.a.s0.s2.f.CAM_X0109);
            this.f23003c.setClickable(false);
        }
        this.f23003c.setVisibility(0);
    }
}
