package c.a.q0.v.e.a;

import c.a.e.l.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f25460a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25461b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f25462c;

    /* renamed from: d  reason: collision with root package name */
    public f f25463d;

    /* renamed from: e  reason: collision with root package name */
    public c f25464e;

    /* renamed from: f  reason: collision with root package name */
    public a f25465f;

    /* renamed from: g  reason: collision with root package name */
    public b f25466g;

    public g(c.a.e.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25462c = new ArrayList();
        this.f25460a = fVar;
        this.f25461b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f25460a, c.a.q0.v.h.b.a.f25573g);
                this.f25464e = cVar;
                this.f25462c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f25460a, c.a.q0.v.h.b.a.f25573g);
                this.f25463d = fVar;
                this.f25462c.add(fVar);
            }
            this.f25465f = new a((TbPageContext) this.f25460a, c.a.q0.v.e.b.a.f25467e);
            this.f25466g = new b((TbPageContext) this.f25460a, c.a.q0.v.e.b.b.f25468e);
            this.f25462c.add(this.f25465f);
            this.f25462c.add(this.f25466g);
            this.f25461b.addAdapters(this.f25462c);
        }
    }

    public void b(c.a.q0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            f fVar = this.f25463d;
            if (fVar != null) {
                fVar.j0(cVar);
            }
            c cVar2 = this.f25464e;
            if (cVar2 != null) {
                cVar2.j0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f25461b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
