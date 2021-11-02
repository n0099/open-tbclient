package b.a.r0.v1.h;

import android.content.Context;
import b.a.e.l.e.n;
import b.a.r0.v1.h.d.d;
import b.a.r0.v1.h.d.e;
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

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f24357a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f24358b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.v1.h.d.a f24359c;

    /* renamed from: d  reason: collision with root package name */
    public d f24360d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.v1.h.d.b f24361e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.v1.h.d.c f24362f;

    /* renamed from: g  reason: collision with root package name */
    public e f24363g;

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
        this.f24358b = new ArrayList();
        this.f24359c = null;
        this.f24360d = null;
        this.f24361e = null;
        this.f24362f = null;
        this.f24363g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f24359c = new b.a.r0.v1.h.d.a(context, b.a.r0.v1.h.e.a.f24374g);
            this.f24360d = new d(context, b.a.r0.v1.h.e.d.p);
            this.f24361e = new b.a.r0.v1.h.d.b(context, b.a.r0.v1.h.e.b.k);
            this.f24362f = new b.a.r0.v1.h.d.c(context, b.a.r0.v1.h.e.c.k);
            this.f24363g = new e(context, b.a.r0.v1.h.e.e.f24392i);
            this.f24358b.add(this.f24359c);
            this.f24358b.add(this.f24360d);
            this.f24358b.add(this.f24361e);
            this.f24358b.add(this.f24362f);
            this.f24358b.add(this.f24363g);
            this.f24357a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f24358b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.r0.v1.h.d.a aVar = this.f24359c;
            if (aVar != null) {
                aVar.O();
            }
            d dVar = this.f24360d;
            if (dVar != null) {
                dVar.O();
            }
            b.a.r0.v1.h.d.b bVar = this.f24361e;
            if (bVar != null) {
                bVar.O();
            }
            b.a.r0.v1.h.d.c cVar = this.f24362f;
            if (cVar != null) {
                cVar.O();
            }
            e eVar = this.f24363g;
            if (eVar != null) {
                eVar.O();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.f24357a == null) {
            return;
        }
        List<n> a2 = b.a.r0.v1.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        this.f24357a.setData(a2);
    }
}
