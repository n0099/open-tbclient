package b.a.r0.x0.b2.a;

import b.a.e.m.e.n;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
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
    public final List<b.a.e.m.e.a> f27030a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f27031b;

    /* renamed from: c  reason: collision with root package name */
    public d f27032c;

    /* renamed from: d  reason: collision with root package name */
    public c f27033d;

    /* renamed from: e  reason: collision with root package name */
    public b f27034e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27030a = new ArrayList();
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumRulesShowActivity, bdTypeRecyclerView) == null) {
            this.f27031b = bdTypeRecyclerView;
            this.f27032c = new d(forumRulesShowActivity, b.a.r0.x0.b2.c.b.q);
            this.f27033d = new c(forumRulesShowActivity, b.a.r0.x0.b2.c.c.f27049h);
            this.f27034e = new b(forumRulesShowActivity, b.a.r0.x0.b2.c.a.j);
            this.f27030a.add(this.f27032c);
            this.f27030a.add(this.f27033d);
            this.f27030a.add(this.f27034e);
            bdTypeRecyclerView.addAdapters(this.f27030a);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f27031b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            c cVar = this.f27033d;
            if (cVar != null) {
                cVar.k0(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d dVar = this.f27032c;
            if (dVar != null) {
                dVar.setFrom(str);
            }
            b bVar = this.f27034e;
            if (bVar != null) {
                bVar.setFrom(str);
            }
        }
    }
}
