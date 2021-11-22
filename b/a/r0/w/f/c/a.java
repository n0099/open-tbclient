package b.a.r0.w.f.c;

import android.content.Context;
import b.a.e.m.e.n;
import b.a.r0.w.f.c.d.d;
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

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26103a;

    /* renamed from: b  reason: collision with root package name */
    public Context f26104b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f26105c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.m.e.a> f26106d;

    /* renamed from: e  reason: collision with root package name */
    public d f26107e;

    /* renamed from: f  reason: collision with root package name */
    public d f26108f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.w.f.c.d.c f26109g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.w.f.c.d.b f26110h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.w.f.c.d.a f26111i;
    public int j;

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
        this.f26103a = tbPageContext;
        this.f26104b = tbPageContext.getPageActivity();
        this.f26105c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26106d = new ArrayList();
            this.f26107e = new d(this.f26103a, this.j, false);
            this.f26108f = new d(this.f26103a, this.j, true);
            this.f26109g = new b.a.r0.w.f.c.d.c(this.f26103a);
            this.f26110h = new b.a.r0.w.f.c.d.b(this.f26103a);
            this.f26111i = new b.a.r0.w.f.c.d.a(this.f26103a);
            this.f26106d.add(this.f26107e);
            this.f26106d.add(this.f26108f);
            this.f26106d.add(this.f26109g);
            this.f26106d.add(this.f26110h);
            this.f26106d.add(this.f26111i);
            this.f26105c.addAdapters(this.f26106d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f26105c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f26105c.setData(list);
        }
    }
}
