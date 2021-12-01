package c.a.r0.a0.f.c;

import android.content.Context;
import c.a.d.m.e.n;
import c.a.r0.a0.f.c.d.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f13928b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f13929c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.m.e.a> f13930d;

    /* renamed from: e  reason: collision with root package name */
    public d f13931e;

    /* renamed from: f  reason: collision with root package name */
    public d f13932f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a0.f.c.d.c f13933g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.a0.f.c.d.b f13934h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.a0.f.c.d.a f13935i;

    /* renamed from: j  reason: collision with root package name */
    public int f13936j;

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
        this.f13928b = tbPageContext.getPageActivity();
        this.f13929c = bdTypeRecyclerView;
        this.f13936j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13930d = new ArrayList();
            this.f13931e = new d(this.a, this.f13936j, false);
            this.f13932f = new d(this.a, this.f13936j, true);
            this.f13933g = new c.a.r0.a0.f.c.d.c(this.a);
            this.f13934h = new c.a.r0.a0.f.c.d.b(this.a);
            this.f13935i = new c.a.r0.a0.f.c.d.a(this.a);
            this.f13930d.add(this.f13931e);
            this.f13930d.add(this.f13932f);
            this.f13930d.add(this.f13933g);
            this.f13930d.add(this.f13934h);
            this.f13930d.add(this.f13935i);
            this.f13929c.addAdapters(this.f13930d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f13929c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f13929c.setData(list);
        }
    }
}
