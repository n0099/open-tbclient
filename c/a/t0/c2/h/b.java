package c.a.t0.c2.h;

import android.content.Context;
import c.a.d.n.e.n;
import c.a.t0.c2.h.d.d;
import c.a.t0.c2.h.d.e;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f15379b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.c2.h.d.a f15380c;

    /* renamed from: d  reason: collision with root package name */
    public d f15381d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.c2.h.d.b f15382e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.c2.h.d.c f15383f;

    /* renamed from: g  reason: collision with root package name */
    public e f15384g;

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
        this.f15379b = new ArrayList();
        this.f15380c = null;
        this.f15381d = null;
        this.f15382e = null;
        this.f15383f = null;
        this.f15384g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f15380c = new c.a.t0.c2.h.d.a(context, c.a.t0.c2.h.e.a.f15395g);
            this.f15381d = new d(context, c.a.t0.c2.h.e.d.p);
            this.f15382e = new c.a.t0.c2.h.d.b(context, c.a.t0.c2.h.e.b.k);
            this.f15383f = new c.a.t0.c2.h.d.c(context, c.a.t0.c2.h.e.c.k);
            this.f15384g = new e(context, c.a.t0.c2.h.e.e.f15416i);
            this.f15379b.add(this.f15380c);
            this.f15379b.add(this.f15381d);
            this.f15379b.add(this.f15382e);
            this.f15379b.add(this.f15383f);
            this.f15379b.add(this.f15384g);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f15379b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.t0.c2.h.d.a aVar = this.f15380c;
            if (aVar != null) {
                aVar.H();
            }
            d dVar = this.f15381d;
            if (dVar != null) {
                dVar.H();
            }
            c.a.t0.c2.h.d.b bVar = this.f15382e;
            if (bVar != null) {
                bVar.H();
            }
            c.a.t0.c2.h.d.c cVar = this.f15383f;
            if (cVar != null) {
                cVar.H();
            }
            e eVar = this.f15384g;
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
        List<n> a = c.a.t0.c2.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a)) {
            return;
        }
        this.a.setData(a);
    }
}
