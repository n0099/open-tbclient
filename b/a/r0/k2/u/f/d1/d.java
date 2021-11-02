package b.a.r0.k2.u.f.d1;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.l.a;
import b.a.r0.b0.c0;
import b.a.r0.k2.j;
import b.a.r0.k2.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19194f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19195g;

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

    @Override // b.a.r0.k2.u.f.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f19178a.getPageActivity().getLayoutInflater().inflate(j.delete_original_thread_view, (ViewGroup) null);
            this.f19194f = linearLayout;
            this.f19195g = (TextView) linearLayout.findViewById(b.a.r0.k2.i.text);
            return this.f19194f;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19182e == i2) {
            return;
        }
        this.f19182e = i2;
        SkinManager.setBackgroundColor(this.f19194f, b.a.r0.k2.f.CAM_X0204);
        SkinManager.setViewTextColor(this.f19195g, b.a.r0.k2.f.CAM_X0105);
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19195g.setText(new SpannableString(this.f19178a.getString(l.origin_thread_deleted_title)));
            SkinManager.setViewTextColor(this.f19195g, b.a.r0.k2.f.CAM_X0105);
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void d(a.InterfaceC0088a interfaceC0088a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0088a) == null) {
            super.d(interfaceC0088a);
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void e(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0Var) == null) {
            super.e(c0Var);
        }
    }
}
