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
    public Context f14555b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f14556c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.n.e.a> f14557d;

    /* renamed from: e  reason: collision with root package name */
    public d f14558e;

    /* renamed from: f  reason: collision with root package name */
    public d f14559f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.a0.f.c.d.c f14560g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.a0.f.c.d.b f14561h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.a0.f.c.d.a f14562i;

    /* renamed from: j  reason: collision with root package name */
    public int f14563j;

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
        this.f14555b = tbPageContext.getPageActivity();
        this.f14556c = bdTypeRecyclerView;
        this.f14563j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14557d = new ArrayList();
            this.f14558e = new d(this.a, this.f14563j, false);
            this.f14559f = new d(this.a, this.f14563j, true);
            this.f14560g = new c.a.t0.a0.f.c.d.c(this.a);
            this.f14561h = new c.a.t0.a0.f.c.d.b(this.a);
            this.f14562i = new c.a.t0.a0.f.c.d.a(this.a);
            this.f14557d.add(this.f14558e);
            this.f14557d.add(this.f14559f);
            this.f14557d.add(this.f14560g);
            this.f14557d.add(this.f14561h);
            this.f14557d.add(this.f14562i);
            this.f14556c.addAdapters(this.f14557d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f14556c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f14556c.setData(list);
        }
    }
}
