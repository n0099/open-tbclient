package c.a.p0.g2.h;

import android.content.Context;
import c.a.d.o.e.n;
import c.a.p0.g2.h.d.d;
import c.a.p0.g2.h.d.e;
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
    public final List<c.a.d.o.e.a> f15165b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.g2.h.d.a f15166c;

    /* renamed from: d  reason: collision with root package name */
    public d f15167d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.g2.h.d.b f15168e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.g2.h.d.c f15169f;

    /* renamed from: g  reason: collision with root package name */
    public e f15170g;

    public b(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15165b = new ArrayList();
        this.f15166c = null;
        this.f15167d = null;
        this.f15168e = null;
        this.f15169f = null;
        this.f15170g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f15166c = new c.a.p0.g2.h.d.a(context, c.a.p0.g2.h.e.a.f15175c);
            this.f15167d = new d(context, c.a.p0.g2.h.e.d.l);
            this.f15168e = new c.a.p0.g2.h.d.b(context, c.a.p0.g2.h.e.b.f15177g);
            this.f15169f = new c.a.p0.g2.h.d.c(context, c.a.p0.g2.h.e.c.f15183g);
            this.f15170g = new e(context, c.a.p0.g2.h.e.e.f15196e);
            this.f15165b.add(this.f15166c);
            this.f15165b.add(this.f15167d);
            this.f15165b.add(this.f15168e);
            this.f15165b.add(this.f15169f);
            this.f15165b.add(this.f15170g);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.a(this.f15165b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.g2.h.d.a aVar = this.f15166c;
            if (aVar != null) {
                aVar.H();
            }
            d dVar = this.f15167d;
            if (dVar != null) {
                dVar.H();
            }
            c.a.p0.g2.h.d.b bVar = this.f15168e;
            if (bVar != null) {
                bVar.H();
            }
            c.a.p0.g2.h.d.c cVar = this.f15169f;
            if (cVar != null) {
                cVar.H();
            }
            e eVar = this.f15170g;
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
        List<n> a = c.a.p0.g2.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a)) {
            return;
        }
        this.a.setData(a);
    }
}
