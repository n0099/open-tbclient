package c.a.p0.v0.p1.a;

import c.a.e.k.e.n;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
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
    public final List<c.a.e.k.e.a> f26491a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26492b;

    /* renamed from: c  reason: collision with root package name */
    public d f26493c;

    /* renamed from: d  reason: collision with root package name */
    public c f26494d;

    /* renamed from: e  reason: collision with root package name */
    public b f26495e;

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
        this.f26491a = new ArrayList();
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumRulesShowActivity, bdTypeRecyclerView) == null) {
            this.f26492b = bdTypeRecyclerView;
            this.f26493c = new d(forumRulesShowActivity, c.a.p0.v0.p1.c.b.q);
            this.f26494d = new c(forumRulesShowActivity, c.a.p0.v0.p1.c.c.f26512h);
            this.f26495e = new b(forumRulesShowActivity, c.a.p0.v0.p1.c.a.f26500j);
            this.f26491a.add(this.f26493c);
            this.f26491a.add(this.f26494d);
            this.f26491a.add(this.f26495e);
            bdTypeRecyclerView.addAdapters(this.f26491a);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f26492b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            c cVar = this.f26494d;
            if (cVar != null) {
                cVar.l0(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d dVar = this.f26493c;
            if (dVar != null) {
                dVar.setFrom(str);
            }
            b bVar = this.f26495e;
            if (bVar != null) {
                bVar.setFrom(str);
            }
        }
    }
}
