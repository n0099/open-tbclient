package c.a.p0.c0.f.c;

import android.content.Context;
import c.a.d.o.e.n;
import c.a.p0.c0.f.c.d.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12916b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f12917c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f12918d;

    /* renamed from: e  reason: collision with root package name */
    public d f12919e;

    /* renamed from: f  reason: collision with root package name */
    public d f12920f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.c0.f.c.d.c f12921g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.c0.f.c.d.b f12922h;
    public c.a.p0.c0.f.c.d.a i;
    public int j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f12916b = tbPageContext.getPageActivity();
        this.f12917c = bdTypeRecyclerView;
        this.j = i;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12918d = new ArrayList();
            this.f12919e = new d(this.a, this.j, false);
            this.f12920f = new d(this.a, this.j, true);
            this.f12921g = new c.a.p0.c0.f.c.d.c(this.a);
            this.f12922h = new c.a.p0.c0.f.c.d.b(this.a);
            this.i = new c.a.p0.c0.f.c.d.a(this.a);
            this.f12918d.add(this.f12919e);
            this.f12918d.add(this.f12920f);
            this.f12918d.add(this.f12921g);
            this.f12918d.add(this.f12922h);
            this.f12918d.add(this.i);
            this.f12917c.a(this.f12918d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f12917c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f12917c.setData(list);
        }
    }
}
