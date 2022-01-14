package c.a.t0.s2.u.f.e1;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.l.a;
import c.a.t0.g0.d0;
import c.a.t0.s2.j;
import c.a.t0.s2.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f22814f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22815g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.t0.s2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.getPageActivity().getLayoutInflater().inflate(j.delete_original_thread_view, (ViewGroup) null);
            this.f22814f = linearLayout;
            this.f22815g = (TextView) linearLayout.findViewById(c.a.t0.s2.i.text);
            return this.f22814f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.t0.s2.u.f.e1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f22802e == i2) {
            return;
        }
        this.f22802e = i2;
        SkinManager.setBackgroundColor(this.f22814f, c.a.t0.s2.f.CAM_X0204);
        SkinManager.setViewTextColor(this.f22815g, c.a.t0.s2.f.CAM_X0105);
    }

    @Override // c.a.t0.s2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f22815g.setText(new SpannableString(this.a.getString(l.origin_thread_deleted_title)));
            SkinManager.setViewTextColor(this.f22815g, c.a.t0.s2.f.CAM_X0105);
        }
    }

    @Override // c.a.t0.s2.u.f.e1.a
    public void d(a.InterfaceC0193a interfaceC0193a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0193a) == null) {
            super.d(interfaceC0193a);
        }
    }

    @Override // c.a.t0.s2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
        }
    }
}
