package b.a.r0.m2.i;

import b.a.r0.b0.c0;
import b.a.r0.n2.c.d;
import b.a.r0.n2.e.h;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f21197a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f21198b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.l.e.a> f21199c;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, c0<h> c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, c0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21199c = new ArrayList();
        this.f21198b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f21197a = dVar;
        dVar.i0(c0Var);
        this.f21199c.add(this.f21197a);
        this.f21198b.addAdapters(this.f21199c);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21197a.O();
        }
    }
}
