package c.a.p0.k2.i;

import c.a.p0.a0.b0;
import c.a.p0.l2.c.d;
import c.a.p0.l2.e.h;
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
    public d f21186a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f21187b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.k.e.a> f21188c;

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
        this.f21188c = new ArrayList();
        this.f21187b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f21186a = dVar;
        dVar.j0(b0Var);
        this.f21188c.add(this.f21186a);
        this.f21187b.addAdapters(this.f21188c);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21186a.P();
        }
    }
}
