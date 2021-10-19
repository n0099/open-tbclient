package c.a.r0.k2.k.e.d1;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.l.a;
import c.a.r0.b0.c0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20192f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20193g;

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

    @Override // c.a.r0.k2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f20175a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
            this.f20192f = linearLayout;
            this.f20193g = (TextView) linearLayout.findViewById(R.id.text);
            return this.f20192f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f20179e == i2) {
            return;
        }
        this.f20179e = i2;
        SkinManager.setBackgroundColor(this.f20192f, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f20193g, R.color.CAM_X0105);
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20193g.setText(new SpannableString(originalThreadInfo.f47438g));
            SkinManager.setViewTextColor(this.f20193g, R.color.CAM_X0105);
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void d(a.InterfaceC0093a interfaceC0093a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0093a) == null) {
            super.d(interfaceC0093a);
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void e(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0Var) == null) {
            super.e(c0Var);
        }
    }
}
