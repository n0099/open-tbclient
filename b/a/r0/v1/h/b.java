package b.a.r0.v1.h;

import android.content.Context;
import b.a.e.m.e.n;
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
    public BdTypeRecyclerView f25820a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f25821b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.v1.h.d.a f25822c;

    /* renamed from: d  reason: collision with root package name */
    public d f25823d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.v1.h.d.b f25824e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.v1.h.d.c f25825f;

    /* renamed from: g  reason: collision with root package name */
    public e f25826g;

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
        this.f25821b = new ArrayList();
        this.f25822c = null;
        this.f25823d = null;
        this.f25824e = null;
        this.f25825f = null;
        this.f25826g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.f25822c = new b.a.r0.v1.h.d.a(context, b.a.r0.v1.h.e.a.f25837g);
            this.f25823d = new d(context, b.a.r0.v1.h.e.d.p);
            this.f25824e = new b.a.r0.v1.h.d.b(context, b.a.r0.v1.h.e.b.k);
            this.f25825f = new b.a.r0.v1.h.d.c(context, b.a.r0.v1.h.e.c.k);
            this.f25826g = new e(context, b.a.r0.v1.h.e.e.f25855i);
            this.f25821b.add(this.f25822c);
            this.f25821b.add(this.f25823d);
            this.f25821b.add(this.f25824e);
            this.f25821b.add(this.f25825f);
            this.f25821b.add(this.f25826g);
            this.f25820a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.f25821b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.r0.v1.h.d.a aVar = this.f25822c;
            if (aVar != null) {
                aVar.O();
            }
            d dVar = this.f25823d;
            if (dVar != null) {
                dVar.O();
            }
            b.a.r0.v1.h.d.b bVar = this.f25824e;
            if (bVar != null) {
                bVar.O();
            }
            b.a.r0.v1.h.d.c cVar = this.f25825f;
            if (cVar != null) {
                cVar.O();
            }
            e eVar = this.f25826g;
            if (eVar != null) {
                eVar.O();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.f25820a == null) {
            return;
        }
        List<n> a2 = b.a.r0.v1.h.f.a.a(dataRes, str);
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        this.f25820a.setData(a2);
    }
}
