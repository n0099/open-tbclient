package c.a.r0.d1.b2.a;

import c.a.d.m.e.n;
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
    public final List<c.a.d.m.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f15219b;

    /* renamed from: c  reason: collision with root package name */
    public d f15220c;

    /* renamed from: d  reason: collision with root package name */
    public c f15221d;

    /* renamed from: e  reason: collision with root package name */
    public b f15222e;

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
        this.a = new ArrayList();
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumRulesShowActivity, bdTypeRecyclerView) == null) {
            this.f15219b = bdTypeRecyclerView;
            this.f15220c = new d(forumRulesShowActivity, c.a.r0.d1.b2.c.b.q);
            this.f15221d = new c(forumRulesShowActivity, c.a.r0.d1.b2.c.c.f15240h);
            this.f15222e = new b(forumRulesShowActivity, c.a.r0.d1.b2.c.a.f15227j);
            this.a.add(this.f15220c);
            this.a.add(this.f15221d);
            this.a.add(this.f15222e);
            bdTypeRecyclerView.addAdapters(this.a);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f15219b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            c cVar = this.f15221d;
            if (cVar != null) {
                cVar.k0(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d dVar = this.f15220c;
            if (dVar != null) {
                dVar.setFrom(str);
            }
            b bVar = this.f15222e;
            if (bVar != null) {
                bVar.setFrom(str);
            }
        }
    }
}
