package c.a.r0.w.f.c.f.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.l.e.n;
import c.a.q0.s.f0.f;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25805a;

    /* renamed from: b  reason: collision with root package name */
    public View f25806b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f25807c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f25808d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f25809e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f25810f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.f0.g f25811g;

    /* renamed from: h  reason: collision with root package name */
    public View f25812h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.w.f.c.f.a.a f25813i;

    /* renamed from: j  reason: collision with root package name */
    public f f25814j;
    public AlphaAnimation k;
    public AlphaAnimation l;
    public RecyclerView.OnScrollListener m;

    /* renamed from: c.a.r0.w.f.c.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1202a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25815e;

        public C1202a(a aVar) {
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
            this.f25815e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25815e.f25814j == null) {
                return;
            }
            this.f25815e.f25814j.onScrollToBottom();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25816e;

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
            this.f25816e = aVar;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25816e.f25814j == null) {
                return;
            }
            this.f25816e.f25814j.onListPullRefresh(z);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25817e;

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
            this.f25817e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25817e.f25805a == null || this.f25817e.f25805a.getPageActivity() == null) {
                return;
            }
            this.f25817e.f25805a.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25818a;

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
            this.f25818a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f25818a.f25812h.setVisibility(8);
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

    /* loaded from: classes4.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f25819a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f25820b;

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
            this.f25820b = aVar;
            this.f25819a = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f25819a == i2) {
                return;
            }
            this.f25819a = i2;
            if (i2 != 1) {
                if (this.f25820b.n(recyclerView)) {
                    this.f25820b.e();
                    return;
                } else {
                    this.f25820b.s();
                    return;
                }
            }
            this.f25820b.s();
        }
    }

    /* loaded from: classes4.dex */
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
        this.f25805a = tbPageContext;
        this.f25806b = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
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
            this.f25812h.startAnimation(this.l);
        }
    }

    public RelativeLayout f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25808d : (RelativeLayout) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25808d : (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25806b : (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f25806b.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
            this.f25807c = navigationBar;
            navigationBar.setCenterTextTitle(this.f25805a.getResources().getString(R.string.live_tab_my_concern));
            this.f25807c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i();
            this.f25808d = (RelativeLayout) this.f25806b.findViewById(R.id.ala_live_tab_my_concern_container);
            this.f25812h = this.f25806b.findViewById(R.id.divider_shadow);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f25806b.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
            this.f25809e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f25805a.getPageActivity()));
            this.f25809e.setFadingEdgeLength(0);
            this.f25809e.setOverScrollMode(2);
            this.f25809e.addOnScrollListener(this.m);
            this.f25809e.setOnSrollToBottomListener(new C1202a(this));
            c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(this.f25805a);
            this.f25811g = gVar;
            gVar.a(new b(this));
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f25806b.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
            this.f25810f = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f25811g);
            c.a.r0.w.f.c.f.a.a aVar = new c.a.r0.w.f.c.f.a.a(this.f25805a);
            this.f25813i = aVar;
            this.f25809e.addAdapters(aVar.a());
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25812h.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            NavigationBar navigationBar = this.f25807c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f25805a, i2);
            }
            SkinManager.setBackgroundColor(this.f25806b, R.color.CAM_X0201);
            c.a.q0.s.f0.g gVar = this.f25811g;
            if (gVar != null) {
                gVar.D(i2);
            }
            SkinManager.setBackgroundColor(this.f25810f, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f25809e, R.color.CAM_X0201);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f25809e;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.m);
                this.f25809e.setOnSrollToBottomListener(null);
                this.f25809e.setScrollable(null);
            }
            c.a.q0.s.f0.g gVar = this.f25811g;
            if (gVar != null) {
                gVar.a(null);
                this.f25811g.T();
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, cls) == null) || (bdTypeRecyclerView = this.f25809e) == null) {
            return;
        }
        for (int count = bdTypeRecyclerView.getCount() - 1; count >= 0; count--) {
            n item = this.f25809e.getItem(count);
            if (item != null && item.getClass().equals(cls)) {
                this.f25809e.removeItem(count);
            }
        }
    }

    public void p(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f25809e.setData(list);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || z) {
            return;
        }
        this.f25810f.setRefreshing(false);
    }

    public void r(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.f25814j = fVar;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || k()) {
            return;
        }
        this.f25812h.setVisibility(0);
        if (this.k == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.k = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.k.setDuration(300L);
        }
        this.f25812h.startAnimation(this.k);
    }
}
