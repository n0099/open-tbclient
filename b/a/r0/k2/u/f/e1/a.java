package b.a.r0.k2.u.f.e1;

import android.view.View;
import b.a.l.a;
import b.a.r0.b0.d0;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f20744a;

    /* renamed from: b  reason: collision with root package name */
    public d0 f20745b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0090a f20746c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f20747d;

    /* renamed from: e  reason: collision with root package name */
    public int f20748e;

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
        this.f20748e = 3;
        this.f20744a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i2);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC0090a interfaceC0090a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0090a) == null) {
            this.f20746c = interfaceC0090a;
        }
    }

    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            this.f20745b = d0Var;
        }
    }
}
