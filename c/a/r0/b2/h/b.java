package c.a.r0.b2.h;

import android.content.Context;
import c.a.d.m.e.n;
import c.a.r0.b2.h.d.d;
import c.a.r0.b2.h.d.e;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f14800b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.b2.h.d.a f14801c;

    /* renamed from: d  reason: collision with root package name */
    public d f14802d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.b2.h.d.b f14803e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.b2.h.d.c f14804f;

    /* renamed from: g  reason: collision with root package name */
    public e f14805g;

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
        this.f14800b = new ArrayList();
        this.f14801c = null;
        this.f14802d = null;
        this.f14803e = null;
        this.f14804f = null;
        this.f14805g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f14801c = new c.a.r0.b2.h.d.a(context, c.a.r0.b2.h.e.a.f14816g);
            this.f14802d = new d(context, c.a.r0.b2.h.e.d.p);
            this.f14803e = new c.a.r0.b2.h.d.b(context, c.a.r0.b2.h.e.b.f14819k);
            this.f14804f = new c.a.r0.b2.h.d.c(context, c.a.r0.b2.h.e.c.f14826k);
            this.f14805g = new e(context, c.a.r0.b2.h.e.e.f14840i);
            this.f14800b.add(this.f14801c);
            this.f14800b.add(this.f14802d);
            this.f14800b.add(this.f14803e);
            this.f14800b.add(this.f14804f);
            this.f14800b.add(this.f14805g);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f14800b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.b2.h.d.a aVar = this.f14801c;
            if (aVar != null) {
                aVar.K();
            }
            d dVar = this.f14802d;
            if (dVar != null) {
                dVar.K();
            }
            c.a.r0.b2.h.d.b bVar = this.f14803e;
            if (bVar != null) {
                bVar.K();
            }
            c.a.r0.b2.h.d.c cVar = this.f14804f;
            if (cVar != null) {
                cVar.K();
            }
            e eVar = this.f14805g;
            if (eVar != null) {
                eVar.K();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.a == null) {
            return;
        }
        List<n> a = c.a.r0.b2.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a)) {
            return;
        }
        this.a.setData(a);
    }
}
