package c.a.t0.a0.f.c;

import android.content.Context;
import c.a.d.n.e.n;
import c.a.t0.a0.f.c.d.d;
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
    public Context f14767b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f14768c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.n.e.a> f14769d;

    /* renamed from: e  reason: collision with root package name */
    public d f14770e;

    /* renamed from: f  reason: collision with root package name */
    public d f14771f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.a0.f.c.d.c f14772g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.a0.f.c.d.b f14773h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.a0.f.c.d.a f14774i;

    /* renamed from: j  reason: collision with root package name */
    public int f14775j;

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
        this.f14767b = tbPageContext.getPageActivity();
        this.f14768c = bdTypeRecyclerView;
        this.f14775j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14769d = new ArrayList();
            this.f14770e = new d(this.a, this.f14775j, false);
            this.f14771f = new d(this.a, this.f14775j, true);
            this.f14772g = new c.a.t0.a0.f.c.d.c(this.a);
            this.f14773h = new c.a.t0.a0.f.c.d.b(this.a);
            this.f14774i = new c.a.t0.a0.f.c.d.a(this.a);
            this.f14769d.add(this.f14770e);
            this.f14769d.add(this.f14771f);
            this.f14769d.add(this.f14772g);
            this.f14769d.add(this.f14773h);
            this.f14769d.add(this.f14774i);
            this.f14768c.addAdapters(this.f14769d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f14768c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f14768c.setData(list);
        }
    }
}
