package c.a.r0.d1.s1.a;

import c.a.d.o.e.n;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.d.o.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f16243b;

    /* renamed from: c  reason: collision with root package name */
    public d f16244c;

    /* renamed from: d  reason: collision with root package name */
    public c f16245d;

    /* renamed from: e  reason: collision with root package name */
    public b f16246e;

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
            this.f16243b = bdTypeRecyclerView;
            this.f16244c = new d(forumRulesShowActivity, c.a.r0.d1.s1.c.b.q);
            this.f16245d = new c(forumRulesShowActivity, c.a.r0.d1.s1.c.c.f16263h);
            this.f16246e = new b(forumRulesShowActivity, c.a.r0.d1.s1.c.a.f16251j);
            this.a.add(this.f16244c);
            this.a.add(this.f16245d);
            this.a.add(this.f16246e);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f16243b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            c cVar = this.f16245d;
            if (cVar != null) {
                cVar.d0(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d dVar = this.f16244c;
            if (dVar != null) {
                dVar.setFrom(str);
            }
            b bVar = this.f16246e;
            if (bVar != null) {
                bVar.setFrom(str);
            }
        }
    }
}
