package c.a.r0.a0.f.c.f.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.m.e.n;
import c.a.q0.s.g0.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f13981b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f13982c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f13983d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f13984e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f13985f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.g0.g f13986g;

    /* renamed from: h  reason: collision with root package name */
    public View f13987h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.a0.f.c.f.a.a f13988i;

    /* renamed from: j  reason: collision with root package name */
    public f f13989j;

    /* renamed from: k  reason: collision with root package name */
    public AlphaAnimation f13990k;
    public AlphaAnimation l;
    public RecyclerView.OnScrollListener m;

    /* renamed from: c.a.r0.a0.f.c.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0847a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13991e;

        public C0847a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13991e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13991e.f13989j == null) {
                return;
            }
            this.f13991e.f13989j.onScrollToBottom();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13992e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13992e = aVar;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f13992e.f13989j == null) {
                return;
            }
            this.f13992e.f13989j.onListPullRefresh(z);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13993e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13993e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13993e.a == null || this.f13993e.a.getPageActivity() == null) {
                return;
            }
            this.f13993e.a.getPageActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.f13987h.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f13994b;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13994b = aVar;
            this.a = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.a == i2) {
                return;
            }
            this.a = i2;
            if (i2 != 1) {
                if (this.f13994b.n(recyclerView)) {
                    this.f13994b.e();
                    return;
                } else {
                    this.f13994b.s();
                    return;
                }
            }
            this.f13994b.s();
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new e(this);
        this.a = tbPageContext;
        this.f13981b = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        j();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && k()) {
            if (this.l == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.l = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.l.setDuration(300L);
                this.l.setAnimationListener(new d(this));
            }
            this.f13987h.startAnimation(this.l);
        }
    }

    public RelativeLayout f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13983d : (RelativeLayout) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13983d : (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13981b : (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f13981b.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
            this.f13982c = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getResources().getString(R.string.live_tab_my_concern));
            this.f13982c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i();
            this.f13983d = (RelativeLayout) this.f13981b.findViewById(R.id.ala_live_tab_my_concern_container);
            this.f13987h = this.f13981b.findViewById(R.id.divider_shadow);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f13981b.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
            this.f13984e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            this.f13984e.setFadingEdgeLength(0);
            this.f13984e.setOverScrollMode(2);
            this.f13984e.addOnScrollListener(this.m);
            this.f13984e.setOnSrollToBottomListener(new C0847a(this));
            c.a.q0.s.g0.g gVar = new c.a.q0.s.g0.g(this.a);
            this.f13986g = gVar;
            gVar.a(new b(this));
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f13981b.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
            this.f13985f = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f13986g);
            c.a.r0.a0.f.c.f.a.a aVar = new c.a.r0.a0.f.c.f.a.a(this.a);
            this.f13988i = aVar;
            this.f13984e.addAdapters(aVar.a());
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13987h.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            NavigationBar navigationBar = this.f13982c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i2);
            }
            SkinManager.setBackgroundColor(this.f13981b, R.color.CAM_X0201);
            c.a.q0.s.g0.g gVar = this.f13986g;
            if (gVar != null) {
                gVar.C(i2);
            }
            SkinManager.setBackgroundColor(this.f13985f, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f13984e, R.color.CAM_X0201);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f13984e;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.m);
                this.f13984e.setOnSrollToBottomListener(null);
                this.f13984e.setScrollable(null);
            }
            c.a.q0.s.g0.g gVar = this.f13986g;
            if (gVar != null) {
                gVar.a(null);
                this.f13986g.T();
            }
        }
    }

    public final boolean n(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void o(Class<? extends BaseCardInfo> cls) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, cls) == null) || (bdTypeRecyclerView = this.f13984e) == null) {
            return;
        }
        for (int count = bdTypeRecyclerView.getCount() - 1; count >= 0; count--) {
            n item = this.f13984e.getItem(count);
            if (item != null && item.getClass().equals(cls)) {
                this.f13984e.removeItem(count);
            }
        }
    }

    public void p(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f13984e.setData(list);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || z) {
            return;
        }
        this.f13985f.setRefreshing(false);
    }

    public void r(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.f13989j = fVar;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || k()) {
            return;
        }
        this.f13987h.setVisibility(0);
        if (this.f13990k == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.f13990k = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.f13990k.setDuration(300L);
        }
        this.f13987h.startAnimation(this.f13990k);
    }
}
