package c.a.p0.v.d.c;

import android.content.Context;
import c.a.e.k.e.n;
import c.a.p0.v.d.c.d.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f24732a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24733b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f24734c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.k.e.a> f24735d;

    /* renamed from: e  reason: collision with root package name */
    public d f24736e;

    /* renamed from: f  reason: collision with root package name */
    public d f24737f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.v.d.c.d.c f24738g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.v.d.c.d.b f24739h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.v.d.c.d.a f24740i;

    /* renamed from: j  reason: collision with root package name */
    public int f24741j;

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
        this.f24732a = tbPageContext;
        this.f24733b = tbPageContext.getPageActivity();
        this.f24734c = bdTypeRecyclerView;
        this.f24741j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24735d = new ArrayList();
            this.f24736e = new d(this.f24732a, this.f24741j, false);
            this.f24737f = new d(this.f24732a, this.f24741j, true);
            this.f24738g = new c.a.p0.v.d.c.d.c(this.f24732a);
            this.f24739h = new c.a.p0.v.d.c.d.b(this.f24732a);
            this.f24740i = new c.a.p0.v.d.c.d.a(this.f24732a);
            this.f24735d.add(this.f24736e);
            this.f24735d.add(this.f24737f);
            this.f24735d.add(this.f24738g);
            this.f24735d.add(this.f24739h);
            this.f24735d.add(this.f24740i);
            this.f24734c.addAdapters(this.f24735d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f24734c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f24734c.setData(list);
        }
    }
}
