package c.a.r0.q2.u.f.e1;

import android.view.View;
import c.a.k.a;
import c.a.r0.g0.d0;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public d0 f21930b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0129a f21931c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f21932d;

    /* renamed from: e  reason: collision with root package name */
    public int f21933e;

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21933e = 3;
        this.a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i2);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC0129a interfaceC0129a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0129a) == null) {
            this.f21931c = interfaceC0129a;
        }
    }

    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            this.f21930b = d0Var;
        }
    }
}
