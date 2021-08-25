package c.a.q0.i2.k.e.b1;

import android.view.View;
import c.a.l.a;
import c.a.q0.a0.b0;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19273a;

    /* renamed from: b  reason: collision with root package name */
    public b0 f19274b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0094a f19275c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f19276d;

    /* renamed from: e  reason: collision with root package name */
    public int f19277e;

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
        this.f19277e = 3;
        this.f19273a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i2);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC0094a interfaceC0094a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0094a) == null) {
            this.f19275c = interfaceC0094a;
        }
    }

    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            this.f19274b = b0Var;
        }
    }
}
