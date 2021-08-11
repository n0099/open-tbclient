package c.a.p0.t1.h;

import android.content.Context;
import c.a.e.k.e.n;
import c.a.p0.t1.h.d.d;
import c.a.p0.t1.h.d.e;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f24314a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.e.k.e.a> f24315b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.t1.h.d.a f24316c;

    /* renamed from: d  reason: collision with root package name */
    public d f24317d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.t1.h.d.b f24318e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.t1.h.d.c f24319f;

    /* renamed from: g  reason: collision with root package name */
    public e f24320g;

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
        this.f24315b = new ArrayList();
        this.f24316c = null;
        this.f24317d = null;
        this.f24318e = null;
        this.f24319f = null;
        this.f24320g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f24316c = new c.a.p0.t1.h.d.a(context, c.a.p0.t1.h.e.a.f24331g);
            this.f24317d = new d(context, c.a.p0.t1.h.e.d.p);
            this.f24318e = new c.a.p0.t1.h.d.b(context, c.a.p0.t1.h.e.b.k);
            this.f24319f = new c.a.p0.t1.h.d.c(context, c.a.p0.t1.h.e.c.k);
            this.f24320g = new e(context, c.a.p0.t1.h.e.e.f24352i);
            this.f24315b.add(this.f24316c);
            this.f24315b.add(this.f24317d);
            this.f24315b.add(this.f24318e);
            this.f24315b.add(this.f24319f);
            this.f24315b.add(this.f24320g);
            this.f24314a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f24315b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.t1.h.d.a aVar = this.f24316c;
            if (aVar != null) {
                aVar.P();
            }
            d dVar = this.f24317d;
            if (dVar != null) {
                dVar.P();
            }
            c.a.p0.t1.h.d.b bVar = this.f24318e;
            if (bVar != null) {
                bVar.P();
            }
            c.a.p0.t1.h.d.c cVar = this.f24319f;
            if (cVar != null) {
                cVar.P();
            }
            e eVar = this.f24320g;
            if (eVar != null) {
                eVar.P();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.f24314a == null) {
            return;
        }
        List<n> a2 = c.a.p0.t1.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        this.f24314a.setData(a2);
    }
}
