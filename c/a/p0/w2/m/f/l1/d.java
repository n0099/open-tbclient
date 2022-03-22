package c.a.p0.w2.m.f.l1;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.l.a;
import c.a.p0.h0.b0;
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
    public LinearLayout f20217f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20218g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.w2.m.f.l1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d021b, (ViewGroup) null);
            this.f20217f = linearLayout;
            this.f20218g = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f1b);
            return this.f20217f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.p0.w2.m.f.l1.a
    public void b(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) || this.f20210e == i) {
            return;
        }
        this.f20210e = i;
        SkinManager.setBackgroundColor(this.f20217f, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f20218g, (int) R.color.CAM_X0105);
    }

    @Override // c.a.p0.w2.m.f.l1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20218g.setText(new SpannableString(this.a.getString(R.string.obfuscated_res_0x7f0f0ce2)));
            SkinManager.setViewTextColor(this.f20218g, (int) R.color.CAM_X0105);
        }
    }

    @Override // c.a.p0.w2.m.f.l1.a
    public void d(a.InterfaceC0194a interfaceC0194a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0194a) == null) {
            super.d(interfaceC0194a);
        }
    }

    @Override // c.a.p0.w2.m.f.l1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
        }
    }
}
