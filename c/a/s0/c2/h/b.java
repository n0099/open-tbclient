package c.a.s0.c2.h;

import android.content.Context;
import c.a.d.m.e.n;
import c.a.s0.c2.h.d.d;
import c.a.s0.c2.h.d.e;
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
    public final List<c.a.d.m.e.a> f15453b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.c2.h.d.a f15454c;

    /* renamed from: d  reason: collision with root package name */
    public d f15455d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.c2.h.d.b f15456e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.c2.h.d.c f15457f;

    /* renamed from: g  reason: collision with root package name */
    public e f15458g;

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
        this.f15453b = new ArrayList();
        this.f15454c = null;
        this.f15455d = null;
        this.f15456e = null;
        this.f15457f = null;
        this.f15458g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f15454c = new c.a.s0.c2.h.d.a(context, c.a.s0.c2.h.e.a.f15469g);
            this.f15455d = new d(context, c.a.s0.c2.h.e.d.p);
            this.f15456e = new c.a.s0.c2.h.d.b(context, c.a.s0.c2.h.e.b.f15472k);
            this.f15457f = new c.a.s0.c2.h.d.c(context, c.a.s0.c2.h.e.c.f15479k);
            this.f15458g = new e(context, c.a.s0.c2.h.e.e.f15493i);
            this.f15453b.add(this.f15454c);
            this.f15453b.add(this.f15455d);
            this.f15453b.add(this.f15456e);
            this.f15453b.add(this.f15457f);
            this.f15453b.add(this.f15458g);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f15453b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.s0.c2.h.d.a aVar = this.f15454c;
            if (aVar != null) {
                aVar.K();
            }
            d dVar = this.f15455d;
            if (dVar != null) {
                dVar.K();
            }
            c.a.s0.c2.h.d.b bVar = this.f15456e;
            if (bVar != null) {
                bVar.K();
            }
            c.a.s0.c2.h.d.c cVar = this.f15457f;
            if (cVar != null) {
                cVar.K();
            }
            e eVar = this.f15458g;
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
        List<n> a = c.a.s0.c2.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a)) {
            return;
        }
        this.a.setData(a);
    }
}
