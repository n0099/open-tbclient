package c.a.r0.k2.k.e.d1;

import android.view.View;
import c.a.l.a;
import c.a.r0.b0.c0;
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
    public TbPageContext f20175a;

    /* renamed from: b  reason: collision with root package name */
    public c0 f20176b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0093a f20177c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f20178d;

    /* renamed from: e  reason: collision with root package name */
    public int f20179e;

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
        this.f20179e = 3;
        this.f20175a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i2);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC0093a interfaceC0093a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0093a) == null) {
            this.f20177c = interfaceC0093a;
        }
    }

    public void e(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0Var) == null) {
            this.f20176b = c0Var;
        }
    }
}
