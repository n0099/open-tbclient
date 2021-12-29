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
    public final List<c.a.d.n.e.a> f15777b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.c2.h.d.a f15778c;

    /* renamed from: d  reason: collision with root package name */
    public d f15779d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.c2.h.d.b f15780e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.c2.h.d.c f15781f;

    /* renamed from: g  reason: collision with root package name */
    public e f15782g;

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
        this.f15777b = new ArrayList();
        this.f15778c = null;
        this.f15779d = null;
        this.f15780e = null;
        this.f15781f = null;
        this.f15782g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f15778c = new c.a.t0.c2.h.d.a(context, c.a.t0.c2.h.e.a.f15793g);
            this.f15779d = new d(context, c.a.t0.c2.h.e.d.p);
            this.f15780e = new c.a.t0.c2.h.d.b(context, c.a.t0.c2.h.e.b.f15796k);
            this.f15781f = new c.a.t0.c2.h.d.c(context, c.a.t0.c2.h.e.c.f15803k);
            this.f15782g = new e(context, c.a.t0.c2.h.e.e.f15817i);
            this.f15777b.add(this.f15778c);
            this.f15777b.add(this.f15779d);
            this.f15777b.add(this.f15780e);
            this.f15777b.add(this.f15781f);
            this.f15777b.add(this.f15782g);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f15777b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.t0.c2.h.d.a aVar = this.f15778c;
            if (aVar != null) {
                aVar.H();
            }
            d dVar = this.f15779d;
            if (dVar != null) {
                dVar.H();
            }
            c.a.t0.c2.h.d.b bVar = this.f15780e;
            if (bVar != null) {
                bVar.H();
            }
            c.a.t0.c2.h.d.c cVar = this.f15781f;
            if (cVar != null) {
                cVar.H();
            }
            e eVar = this.f15782g;
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
