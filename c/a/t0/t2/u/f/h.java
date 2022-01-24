package c.a.t0.t2.u.f;

import android.view.View;
import android.widget.TextView;
import c.a.s0.s.q.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h extends v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23163c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(BaseFragmentActivity baseFragmentActivity, View view) {
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
        this.f23163c = null;
    }

    @Override // c.a.t0.t2.u.f.v0
    public void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            TextView textView = (TextView) this.f23377b.findViewById(c.a.t0.t2.i.icon_push);
            this.f23163c = textView;
            textView.setVisibility(8);
        }
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23163c : (TextView) invokeV.objValue;
    }

    public void f(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) || e2Var == null || e2Var.Q0() == null) {
            return;
        }
        int status = e2Var.Q0().getStatus();
        if (status == 1) {
            g(true);
        } else if (status == 2) {
            g(false);
        }
    }

    public void g(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (textView = this.f23163c) == null) {
            return;
        }
        if (z) {
            textView.setText(c.a.t0.t2.l.push);
            SkinManager.setViewTextColor(this.f23163c, c.a.t0.t2.h.push_text_selector);
            SkinManager.setBackgroundResource(this.f23163c, c.a.t0.t2.h.push_bg_selector);
            this.f23163c.setClickable(true);
        } else {
            textView.setText(c.a.t0.t2.l.already_push);
            SkinManager.setBackgroundResource(this.f23163c, c.a.t0.t2.h.label_bg_gray80);
            SkinManager.setViewTextColor(this.f23163c, c.a.t0.t2.f.CAM_X0109);
            this.f23163c.setClickable(false);
        }
        this.f23163c.setVisibility(0);
    }
}
