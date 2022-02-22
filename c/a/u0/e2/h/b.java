package c.a.u0.e2.h;

import android.content.Context;
import c.a.d.o.e.n;
import c.a.u0.e2.h.d.d;
import c.a.u0.e2.h.d.e;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.DataRes;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f17535b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.u0.e2.h.d.a f17536c;

    /* renamed from: d  reason: collision with root package name */
    public d f17537d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.u0.e2.h.d.b f17538e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.u0.e2.h.d.c f17539f;

    /* renamed from: g  reason: collision with root package name */
    public e f17540g;

    public b(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17535b = new ArrayList();
        this.f17536c = null;
        this.f17537d = null;
        this.f17538e = null;
        this.f17539f = null;
        this.f17540g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f17536c = new c.a.u0.e2.h.d.a(context, c.a.u0.e2.h.e.a.f17551g);
            this.f17537d = new d(context, c.a.u0.e2.h.e.d.p);
            this.f17538e = new c.a.u0.e2.h.d.b(context, c.a.u0.e2.h.e.b.k);
            this.f17539f = new c.a.u0.e2.h.d.c(context, c.a.u0.e2.h.e.c.k);
            this.f17540g = new e(context, c.a.u0.e2.h.e.e.f17572i);
            this.f17535b.add(this.f17536c);
            this.f17535b.add(this.f17537d);
            this.f17535b.add(this.f17538e);
            this.f17535b.add(this.f17539f);
            this.f17535b.add(this.f17540g);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f17535b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.u0.e2.h.d.a aVar = this.f17536c;
            if (aVar != null) {
                aVar.H();
            }
            d dVar = this.f17537d;
            if (dVar != null) {
                dVar.H();
            }
            c.a.u0.e2.h.d.b bVar = this.f17538e;
            if (bVar != null) {
                bVar.H();
            }
            c.a.u0.e2.h.d.c cVar = this.f17539f;
            if (cVar != null) {
                cVar.H();
            }
            e eVar = this.f17540g;
            if (eVar != null) {
                eVar.H();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.a == null) {
            return;
        }
        List<n> a = c.a.u0.e2.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a)) {
            return;
        }
        this.a.setData(a);
    }
}
