package c.a.q0.v.d.c;

import android.content.Context;
import c.a.e.l.e.n;
import c.a.q0.v.d.c.d.d;
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
    public TbPageContext f25065a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25066b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f25067c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25068d;

    /* renamed from: e  reason: collision with root package name */
    public d f25069e;

    /* renamed from: f  reason: collision with root package name */
    public d f25070f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.v.d.c.d.c f25071g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.v.d.c.d.b f25072h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.v.d.c.d.a f25073i;

    /* renamed from: j  reason: collision with root package name */
    public int f25074j;

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
        this.f25065a = tbPageContext;
        this.f25066b = tbPageContext.getPageActivity();
        this.f25067c = bdTypeRecyclerView;
        this.f25074j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25068d = new ArrayList();
            this.f25069e = new d(this.f25065a, this.f25074j, false);
            this.f25070f = new d(this.f25065a, this.f25074j, true);
            this.f25071g = new c.a.q0.v.d.c.d.c(this.f25065a);
            this.f25072h = new c.a.q0.v.d.c.d.b(this.f25065a);
            this.f25073i = new c.a.q0.v.d.c.d.a(this.f25065a);
            this.f25068d.add(this.f25069e);
            this.f25068d.add(this.f25070f);
            this.f25068d.add(this.f25071g);
            this.f25068d.add(this.f25072h);
            this.f25068d.add(this.f25073i);
            this.f25067c.addAdapters(this.f25068d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f25067c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f25067c.setData(list);
        }
    }
}
