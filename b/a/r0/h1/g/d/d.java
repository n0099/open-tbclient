package b.a.r0.h1.g.d;

import b.a.e.m.e.n;
import b.a.e.m.e.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18704a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.e.m.e.a> f18705b;

    /* renamed from: c  reason: collision with root package name */
    public s f18706c;

    /* renamed from: d  reason: collision with root package name */
    public c f18707d;

    /* renamed from: e  reason: collision with root package name */
    public h f18708e;

    /* renamed from: f  reason: collision with root package name */
    public b f18709f;

    /* renamed from: g  reason: collision with root package name */
    public f f18710g;

    /* renamed from: h  reason: collision with root package name */
    public e f18711h;

    /* renamed from: i  reason: collision with root package name */
    public g f18712i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
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
        this.f18704a = tbPageContext;
        this.f18706c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18705b = new ArrayList();
            c cVar = new c(this.f18704a);
            this.f18707d = cVar;
            cVar.j0(this.f18706c);
            this.f18705b.add(this.f18707d);
            h hVar = new h(this.f18704a);
            this.f18708e = hVar;
            hVar.j0(this.f18706c);
            this.f18705b.add(this.f18708e);
            b bVar = new b(this.f18704a);
            this.f18709f = bVar;
            bVar.j0(this.f18706c);
            this.f18705b.add(this.f18709f);
            f fVar = new f(this.f18704a);
            this.f18710g = fVar;
            fVar.j0(this.f18706c);
            this.f18705b.add(this.f18710g);
            e eVar = new e(this.f18704a);
            this.f18711h = eVar;
            eVar.j0(this.f18706c);
            this.f18705b.add(this.f18711h);
            g gVar = new g(this.f18704a);
            this.f18712i = gVar;
            gVar.j0(this.f18706c);
            this.f18705b.add(this.f18712i);
            i iVar = new i(this.f18704a);
            this.j = iVar;
            iVar.j0(this.f18706c);
            this.f18705b.add(this.j);
            this.f18706c.addAdapters(this.f18705b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f18706c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f18706c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(b.a.q0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (b.a.e.m.e.a aVar : this.f18705b) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (b.a.e.m.e.a aVar : this.f18705b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
