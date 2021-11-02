package b.a.r0.x0.a2.a;

import b.a.e.l.e.n;
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
    public final List<b.a.e.l.e.a> f25436a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f25437b;

    /* renamed from: c  reason: collision with root package name */
    public d f25438c;

    /* renamed from: d  reason: collision with root package name */
    public c f25439d;

    /* renamed from: e  reason: collision with root package name */
    public b f25440e;

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
        this.f25436a = new ArrayList();
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumRulesShowActivity, bdTypeRecyclerView) == null) {
            this.f25437b = bdTypeRecyclerView;
            this.f25438c = new d(forumRulesShowActivity, b.a.r0.x0.a2.c.b.q);
            this.f25439d = new c(forumRulesShowActivity, b.a.r0.x0.a2.c.c.f25455h);
            this.f25440e = new b(forumRulesShowActivity, b.a.r0.x0.a2.c.a.j);
            this.f25436a.add(this.f25438c);
            this.f25436a.add(this.f25439d);
            this.f25436a.add(this.f25440e);
            bdTypeRecyclerView.addAdapters(this.f25436a);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f25437b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            c cVar = this.f25439d;
            if (cVar != null) {
                cVar.k0(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d dVar = this.f25438c;
            if (dVar != null) {
                dVar.setFrom(str);
            }
            b bVar = this.f25440e;
            if (bVar != null) {
                bVar.setFrom(str);
            }
        }
    }
}
