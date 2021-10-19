package c.a.r0.w.f.c;

import android.content.Context;
import c.a.e.l.e.n;
import c.a.r0.w.f.c.d.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25741a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25742b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f25743c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25744d;

    /* renamed from: e  reason: collision with root package name */
    public d f25745e;

    /* renamed from: f  reason: collision with root package name */
    public d f25746f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.w.f.c.d.c f25747g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.w.f.c.d.b f25748h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.w.f.c.d.a f25749i;

    /* renamed from: j  reason: collision with root package name */
    public int f25750j;

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
        this.f25741a = tbPageContext;
        this.f25742b = tbPageContext.getPageActivity();
        this.f25743c = bdTypeRecyclerView;
        this.f25750j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25744d = new ArrayList();
            this.f25745e = new d(this.f25741a, this.f25750j, false);
            this.f25746f = new d(this.f25741a, this.f25750j, true);
            this.f25747g = new c.a.r0.w.f.c.d.c(this.f25741a);
            this.f25748h = new c.a.r0.w.f.c.d.b(this.f25741a);
            this.f25749i = new c.a.r0.w.f.c.d.a(this.f25741a);
            this.f25744d.add(this.f25745e);
            this.f25744d.add(this.f25746f);
            this.f25744d.add(this.f25747g);
            this.f25744d.add(this.f25748h);
            this.f25744d.add(this.f25749i);
            this.f25743c.addAdapters(this.f25744d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f25743c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f25743c.setData(list);
        }
    }
}
