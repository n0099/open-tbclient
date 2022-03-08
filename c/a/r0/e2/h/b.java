package c.a.r0.e2.h;

import android.content.Context;
import c.a.d.o.e.n;
import c.a.r0.e2.h.d.d;
import c.a.r0.e2.h.d.e;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f17102b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.e2.h.d.a f17103c;

    /* renamed from: d  reason: collision with root package name */
    public d f17104d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.e2.h.d.b f17105e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.e2.h.d.c f17106f;

    /* renamed from: g  reason: collision with root package name */
    public e f17107g;

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
        this.f17102b = new ArrayList();
        this.f17103c = null;
        this.f17104d = null;
        this.f17105e = null;
        this.f17106f = null;
        this.f17107g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f17103c = new c.a.r0.e2.h.d.a(context, c.a.r0.e2.h.e.a.f17118g);
            this.f17104d = new d(context, c.a.r0.e2.h.e.d.p);
            this.f17105e = new c.a.r0.e2.h.d.b(context, c.a.r0.e2.h.e.b.k);
            this.f17106f = new c.a.r0.e2.h.d.c(context, c.a.r0.e2.h.e.c.k);
            this.f17107g = new e(context, c.a.r0.e2.h.e.e.f17139i);
            this.f17102b.add(this.f17103c);
            this.f17102b.add(this.f17104d);
            this.f17102b.add(this.f17105e);
            this.f17102b.add(this.f17106f);
            this.f17102b.add(this.f17107g);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f17102b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.e2.h.d.a aVar = this.f17103c;
            if (aVar != null) {
                aVar.H();
            }
            d dVar = this.f17104d;
            if (dVar != null) {
                dVar.H();
            }
            c.a.r0.e2.h.d.b bVar = this.f17105e;
            if (bVar != null) {
                bVar.H();
            }
            c.a.r0.e2.h.d.c cVar = this.f17106f;
            if (cVar != null) {
                cVar.H();
            }
            e eVar = this.f17107g;
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
        List<n> a = c.a.r0.e2.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a)) {
            return;
        }
        this.a.setData(a);
    }
}
