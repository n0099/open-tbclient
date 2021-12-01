package c.a.r0.s2.i;

import c.a.r0.g0.d0;
import c.a.r0.t2.c.d;
import c.a.r0.t2.e.h;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f23498b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.m.e.a> f23499c;

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
        this.f23499c = new ArrayList();
        this.f23498b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.a = dVar;
        dVar.i0(d0Var);
        this.f23499c.add(this.a);
        this.f23498b.addAdapters(this.f23499c);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.K();
        }
    }
}
