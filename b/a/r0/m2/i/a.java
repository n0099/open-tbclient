package b.a.r0.m2.i;

import b.a.r0.b0.d0;
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
    public d f22352a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f22353b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.m.e.a> f22354c;

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
        this.f22354c = new ArrayList();
        this.f22353b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f22352a = dVar;
        dVar.i0(d0Var);
        this.f22354c.add(this.f22352a);
        this.f22353b.addAdapters(this.f22354c);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22352a.O();
        }
    }
}
