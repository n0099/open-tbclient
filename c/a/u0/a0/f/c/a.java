package c.a.u0.a0.f.c;

import android.content.Context;
import c.a.d.o.e.n;
import c.a.u0.a0.f.c.d.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14829b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f14830c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f14831d;

    /* renamed from: e  reason: collision with root package name */
    public d f14832e;

    /* renamed from: f  reason: collision with root package name */
    public d f14833f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.u0.a0.f.c.d.c f14834g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.u0.a0.f.c.d.b f14835h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.u0.a0.f.c.d.a f14836i;

    /* renamed from: j  reason: collision with root package name */
    public int f14837j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f14829b = tbPageContext.getPageActivity();
        this.f14830c = bdTypeRecyclerView;
        this.f14837j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14831d = new ArrayList();
            this.f14832e = new d(this.a, this.f14837j, false);
            this.f14833f = new d(this.a, this.f14837j, true);
            this.f14834g = new c.a.u0.a0.f.c.d.c(this.a);
            this.f14835h = new c.a.u0.a0.f.c.d.b(this.a);
            this.f14836i = new c.a.u0.a0.f.c.d.a(this.a);
            this.f14831d.add(this.f14832e);
            this.f14831d.add(this.f14833f);
            this.f14831d.add(this.f14834g);
            this.f14831d.add(this.f14835h);
            this.f14831d.add(this.f14836i);
            this.f14830c.addAdapters(this.f14831d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f14830c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f14830c.setData(list);
        }
    }
}
