package c.a.p0.f1.s1.a;

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
    public BdTypeRecyclerView f14509b;

    /* renamed from: c  reason: collision with root package name */
    public d f14510c;

    /* renamed from: d  reason: collision with root package name */
    public c f14511d;

    /* renamed from: e  reason: collision with root package name */
    public b f14512e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.f14509b = bdTypeRecyclerView;
            this.f14510c = new d(forumRulesShowActivity, c.a.p0.f1.s1.c.b.m);
            this.f14511d = new c(forumRulesShowActivity, c.a.p0.f1.s1.c.c.f14527d);
            this.f14512e = new b(forumRulesShowActivity, c.a.p0.f1.s1.c.a.f14515f);
            this.a.add(this.f14510c);
            this.a.add(this.f14511d);
            this.a.add(this.f14512e);
            bdTypeRecyclerView.a(this.a);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f14509b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            c cVar = this.f14511d;
            if (cVar != null) {
                cVar.d0(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d dVar = this.f14510c;
            if (dVar != null) {
                dVar.setFrom(str);
            }
            b bVar = this.f14512e;
            if (bVar != null) {
                bVar.setFrom(str);
            }
        }
    }
}
