package c.a.r0.w0.q1.a;

import c.a.e.l.e.n;
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
    public final List<c.a.e.l.e.a> f27579a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f27580b;

    /* renamed from: c  reason: collision with root package name */
    public d f27581c;

    /* renamed from: d  reason: collision with root package name */
    public c f27582d;

    /* renamed from: e  reason: collision with root package name */
    public b f27583e;

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
        this.f27579a = new ArrayList();
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumRulesShowActivity, bdTypeRecyclerView) == null) {
            this.f27580b = bdTypeRecyclerView;
            this.f27581c = new d(forumRulesShowActivity, c.a.r0.w0.q1.c.b.q);
            this.f27582d = new c(forumRulesShowActivity, c.a.r0.w0.q1.c.c.f27600h);
            this.f27583e = new b(forumRulesShowActivity, c.a.r0.w0.q1.c.a.f27588j);
            this.f27579a.add(this.f27581c);
            this.f27579a.add(this.f27582d);
            this.f27579a.add(this.f27583e);
            bdTypeRecyclerView.addAdapters(this.f27579a);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f27580b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            c cVar = this.f27582d;
            if (cVar != null) {
                cVar.l0(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d dVar = this.f27581c;
            if (dVar != null) {
                dVar.setFrom(str);
            }
            b bVar = this.f27583e;
            if (bVar != null) {
                bVar.setFrom(str);
            }
        }
    }
}
