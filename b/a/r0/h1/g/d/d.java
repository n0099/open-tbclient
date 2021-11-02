package b.a.r0.h1.g.d;

import b.a.e.l.e.n;
import b.a.e.l.e.s;
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
    public TbPageContext f17236a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.e.l.e.a> f17237b;

    /* renamed from: c  reason: collision with root package name */
    public s f17238c;

    /* renamed from: d  reason: collision with root package name */
    public c f17239d;

    /* renamed from: e  reason: collision with root package name */
    public h f17240e;

    /* renamed from: f  reason: collision with root package name */
    public b f17241f;

    /* renamed from: g  reason: collision with root package name */
    public f f17242g;

    /* renamed from: h  reason: collision with root package name */
    public e f17243h;

    /* renamed from: i  reason: collision with root package name */
    public g f17244i;
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
        this.f17236a = tbPageContext;
        this.f17238c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17237b = new ArrayList();
            c cVar = new c(this.f17236a);
            this.f17239d = cVar;
            cVar.j0(this.f17238c);
            this.f17237b.add(this.f17239d);
            h hVar = new h(this.f17236a);
            this.f17240e = hVar;
            hVar.j0(this.f17238c);
            this.f17237b.add(this.f17240e);
            b bVar = new b(this.f17236a);
            this.f17241f = bVar;
            bVar.j0(this.f17238c);
            this.f17237b.add(this.f17241f);
            f fVar = new f(this.f17236a);
            this.f17242g = fVar;
            fVar.j0(this.f17238c);
            this.f17237b.add(this.f17242g);
            e eVar = new e(this.f17236a);
            this.f17243h = eVar;
            eVar.j0(this.f17238c);
            this.f17237b.add(this.f17243h);
            g gVar = new g(this.f17236a);
            this.f17244i = gVar;
            gVar.j0(this.f17238c);
            this.f17237b.add(this.f17244i);
            i iVar = new i(this.f17236a);
            this.j = iVar;
            iVar.j0(this.f17238c);
            this.f17237b.add(this.j);
            this.f17238c.addAdapters(this.f17237b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f17238c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f17238c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(b.a.q0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (b.a.e.l.e.a aVar : this.f17237b) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (b.a.e.l.e.a aVar : this.f17237b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
