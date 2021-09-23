package c.a.r0.u1.h;

import android.content.Context;
import c.a.e.l.e.n;
import c.a.r0.u1.h.d.d;
import c.a.r0.u1.h.d.e;
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
    public BdTypeRecyclerView f25350a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f25351b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.u1.h.d.a f25352c;

    /* renamed from: d  reason: collision with root package name */
    public d f25353d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.u1.h.d.b f25354e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.u1.h.d.c f25355f;

    /* renamed from: g  reason: collision with root package name */
    public e f25356g;

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
        this.f25351b = new ArrayList();
        this.f25352c = null;
        this.f25353d = null;
        this.f25354e = null;
        this.f25355f = null;
        this.f25356g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f25352c = new c.a.r0.u1.h.d.a(context, c.a.r0.u1.h.e.a.f25367g);
            this.f25353d = new d(context, c.a.r0.u1.h.e.d.p);
            this.f25354e = new c.a.r0.u1.h.d.b(context, c.a.r0.u1.h.e.b.k);
            this.f25355f = new c.a.r0.u1.h.d.c(context, c.a.r0.u1.h.e.c.k);
            this.f25356g = new e(context, c.a.r0.u1.h.e.e.f25388i);
            this.f25351b.add(this.f25352c);
            this.f25351b.add(this.f25353d);
            this.f25351b.add(this.f25354e);
            this.f25351b.add(this.f25355f);
            this.f25351b.add(this.f25356g);
            this.f25350a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f25351b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.u1.h.d.a aVar = this.f25352c;
            if (aVar != null) {
                aVar.P();
            }
            d dVar = this.f25353d;
            if (dVar != null) {
                dVar.P();
            }
            c.a.r0.u1.h.d.b bVar = this.f25354e;
            if (bVar != null) {
                bVar.P();
            }
            c.a.r0.u1.h.d.c cVar = this.f25355f;
            if (cVar != null) {
                cVar.P();
            }
            e eVar = this.f25356g;
            if (eVar != null) {
                eVar.P();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.f25350a == null) {
            return;
        }
        List<n> a2 = c.a.r0.u1.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        this.f25350a.setData(a2);
    }
}
