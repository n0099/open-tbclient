package c.a.t0.u2.i;

import c.a.t0.g0.d0;
import c.a.t0.v2.b.d;
import c.a.t0.v2.d.h;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25141b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.n.e.a> f25142c;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, d0<h> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, d0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25142c = new ArrayList();
        this.f25141b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.a = dVar;
        dVar.b0(d0Var);
        this.f25142c.add(this.a);
        this.f25141b.addAdapters(this.f25142c);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.H();
        }
    }
}
