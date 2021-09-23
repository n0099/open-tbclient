package c.a.r0.v.f.c;

import android.content.Context;
import c.a.e.l.e.n;
import c.a.r0.v.f.c.d.d;
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
    public TbPageContext f25566a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25567b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f25568c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25569d;

    /* renamed from: e  reason: collision with root package name */
    public d f25570e;

    /* renamed from: f  reason: collision with root package name */
    public d f25571f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.v.f.c.d.c f25572g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.v.f.c.d.b f25573h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.v.f.c.d.a f25574i;

    /* renamed from: j  reason: collision with root package name */
    public int f25575j;

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
        this.f25566a = tbPageContext;
        this.f25567b = tbPageContext.getPageActivity();
        this.f25568c = bdTypeRecyclerView;
        this.f25575j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25569d = new ArrayList();
            this.f25570e = new d(this.f25566a, this.f25575j, false);
            this.f25571f = new d(this.f25566a, this.f25575j, true);
            this.f25572g = new c.a.r0.v.f.c.d.c(this.f25566a);
            this.f25573h = new c.a.r0.v.f.c.d.b(this.f25566a);
            this.f25574i = new c.a.r0.v.f.c.d.a(this.f25566a);
            this.f25569d.add(this.f25570e);
            this.f25569d.add(this.f25571f);
            this.f25569d.add(this.f25572g);
            this.f25569d.add(this.f25573h);
            this.f25569d.add(this.f25574i);
            this.f25568c.addAdapters(this.f25569d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f25568c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f25568c.setData(list);
        }
    }
}
