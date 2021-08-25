package c.a.q0.t1.h;

import android.content.Context;
import c.a.e.l.e.n;
import c.a.q0.t1.h.d.d;
import c.a.q0.t1.h.d.e;
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
    public BdTypeRecyclerView f24647a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f24648b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.t1.h.d.a f24649c;

    /* renamed from: d  reason: collision with root package name */
    public d f24650d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.t1.h.d.b f24651e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.t1.h.d.c f24652f;

    /* renamed from: g  reason: collision with root package name */
    public e f24653g;

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
        this.f24648b = new ArrayList();
        this.f24649c = null;
        this.f24650d = null;
        this.f24651e = null;
        this.f24652f = null;
        this.f24653g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f24649c = new c.a.q0.t1.h.d.a(context, c.a.q0.t1.h.e.a.f24664g);
            this.f24650d = new d(context, c.a.q0.t1.h.e.d.p);
            this.f24651e = new c.a.q0.t1.h.d.b(context, c.a.q0.t1.h.e.b.k);
            this.f24652f = new c.a.q0.t1.h.d.c(context, c.a.q0.t1.h.e.c.k);
            this.f24653g = new e(context, c.a.q0.t1.h.e.e.f24685i);
            this.f24648b.add(this.f24649c);
            this.f24648b.add(this.f24650d);
            this.f24648b.add(this.f24651e);
            this.f24648b.add(this.f24652f);
            this.f24648b.add(this.f24653g);
            this.f24647a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f24648b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.q0.t1.h.d.a aVar = this.f24649c;
            if (aVar != null) {
                aVar.P();
            }
            d dVar = this.f24650d;
            if (dVar != null) {
                dVar.P();
            }
            c.a.q0.t1.h.d.b bVar = this.f24651e;
            if (bVar != null) {
                bVar.P();
            }
            c.a.q0.t1.h.d.c cVar = this.f24652f;
            if (cVar != null) {
                cVar.P();
            }
            e eVar = this.f24653g;
            if (eVar != null) {
                eVar.P();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.f24647a == null) {
            return;
        }
        List<n> a2 = c.a.q0.t1.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        this.f24647a.setData(a2);
    }
}
