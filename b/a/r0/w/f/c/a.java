package b.a.r0.w.f.c;

import android.content.Context;
import b.a.e.l.e.n;
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
    public TbPageContext f24586a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24587b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f24588c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.l.e.a> f24589d;

    /* renamed from: e  reason: collision with root package name */
    public d f24590e;

    /* renamed from: f  reason: collision with root package name */
    public d f24591f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.w.f.c.d.c f24592g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.w.f.c.d.b f24593h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.w.f.c.d.a f24594i;
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
        this.f24586a = tbPageContext;
        this.f24587b = tbPageContext.getPageActivity();
        this.f24588c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24589d = new ArrayList();
            this.f24590e = new d(this.f24586a, this.j, false);
            this.f24591f = new d(this.f24586a, this.j, true);
            this.f24592g = new b.a.r0.w.f.c.d.c(this.f24586a);
            this.f24593h = new b.a.r0.w.f.c.d.b(this.f24586a);
            this.f24594i = new b.a.r0.w.f.c.d.a(this.f24586a);
            this.f24589d.add(this.f24590e);
            this.f24589d.add(this.f24591f);
            this.f24589d.add(this.f24592g);
            this.f24589d.add(this.f24593h);
            this.f24589d.add(this.f24594i);
            this.f24588c.addAdapters(this.f24589d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f24588c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f24588c.setData(list);
        }
    }
}
