package c.a.s0.o1.k.a.b;

import c.a.d.m.e.n;
import c.a.d.m.e.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.m.e.a> f21168b;

    /* renamed from: c  reason: collision with root package name */
    public s f21169c;

    /* renamed from: d  reason: collision with root package name */
    public c f21170d;

    /* renamed from: e  reason: collision with root package name */
    public a f21171e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.o1.k.b.b.c f21172f;

    public b(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f21169c = sVar;
        a();
        this.f21169c.addAdapters(this.f21168b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21168b = new ArrayList();
            this.f21170d = new c(this.a);
            this.f21171e = new a(this.a);
            this.f21172f = new c.a.s0.o1.k.b.b.c(this.a);
            this.f21168b.add(this.f21170d);
            this.f21168b.add(this.f21171e);
            this.f21168b.add(this.f21172f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f21169c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f21169c.setData(list);
        }
    }
}
