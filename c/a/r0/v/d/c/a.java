package c.a.r0.v.d.c;

import android.content.Context;
import c.a.e.l.e.n;
import c.a.r0.v.d.c.d.d;
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
    public TbPageContext f25543a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25544b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f25545c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25546d;

    /* renamed from: e  reason: collision with root package name */
    public d f25547e;

    /* renamed from: f  reason: collision with root package name */
    public d f25548f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.v.d.c.d.c f25549g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.v.d.c.d.b f25550h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.v.d.c.d.a f25551i;

    /* renamed from: j  reason: collision with root package name */
    public int f25552j;

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
        this.f25543a = tbPageContext;
        this.f25544b = tbPageContext.getPageActivity();
        this.f25545c = bdTypeRecyclerView;
        this.f25552j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25546d = new ArrayList();
            this.f25547e = new d(this.f25543a, this.f25552j, false);
            this.f25548f = new d(this.f25543a, this.f25552j, true);
            this.f25549g = new c.a.r0.v.d.c.d.c(this.f25543a);
            this.f25550h = new c.a.r0.v.d.c.d.b(this.f25543a);
            this.f25551i = new c.a.r0.v.d.c.d.a(this.f25543a);
            this.f25546d.add(this.f25547e);
            this.f25546d.add(this.f25548f);
            this.f25546d.add(this.f25549g);
            this.f25546d.add(this.f25550h);
            this.f25546d.add(this.f25551i);
            this.f25545c.addAdapters(this.f25546d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f25545c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f25545c.setData(list);
        }
    }
}
