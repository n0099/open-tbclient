package c.a.q0.k2.i;

import c.a.q0.a0.b0;
import c.a.q0.l2.c.d;
import c.a.q0.l2.e.h;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f21516a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f21517b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f21518c;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, b0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21518c = new ArrayList();
        this.f21517b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f21516a = dVar;
        dVar.j0(b0Var);
        this.f21518c.add(this.f21516a);
        this.f21517b.addAdapters(this.f21518c);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21516a.P();
        }
    }
}
