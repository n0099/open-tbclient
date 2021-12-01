package c.a.r0.q3;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.q0.g0.g;
import c.a.q0.g0.h;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.square.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f22590b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f22591c;

    /* renamed from: d  reason: collision with root package name */
    public ForumHeaderView f22592d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f22593e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22594f;

    /* renamed from: g  reason: collision with root package name */
    public View f22595g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.q3.k.b f22596h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f22597i;

    /* renamed from: j  reason: collision with root package name */
    public g f22598j;

    /* renamed from: k  reason: collision with root package name */
    public h f22599k;
    public NoDataView l;
    public View.OnClickListener m;
    public final TbPageContext n;
    public CustomMessageListener o;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.a(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public b(Context context, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this, 2001304);
        this.a = context;
        this.n = tbPageContext;
        this.f22590b = LayoutInflater.from(context).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        k();
        j();
    }

    public void A(String str) {
        ForumHeaderView forumHeaderView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (forumHeaderView = this.f22592d) == null) {
            return;
        }
        forumHeaderView.setSearchHint(str);
    }

    public void B(String str) {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.x(str);
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f22595g.setVisibility(z ? 0 : 8);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g();
            h();
            i();
            c.a.r0.q3.k.b bVar = this.f22596h;
            if (bVar != null) {
                bVar.y(true);
                this.f22596h.w(8);
            }
        }
    }

    public boolean E(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (z) {
                if (j.z()) {
                    o();
                    return true;
                }
                p();
                return true;
            }
            n();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
            i();
            G(true);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || l()) {
            return;
        }
        if (this.f22598j == null) {
            g gVar = new g(this.a);
            this.f22598j = gVar;
            gVar.q(l.f(this.a, R.dimen.ds250));
        }
        this.f22598j.onChangeSkinType();
        this.f22598j.attachView(this.f22597i, z);
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || m()) {
            return;
        }
        if (this.f22599k == null) {
            h hVar = new h(this.a, this.m);
            this.f22599k = hVar;
            hVar.j(l.f(this.a, R.dimen.ds250));
        }
        this.f22599k.attachView(this.f22597i, z);
        this.f22599k.o();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g();
            i();
            H(true);
            c.a.r0.q3.k.b bVar = this.f22596h;
            if (bVar != null) {
                bVar.s(8);
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g();
            h();
            i();
            c.a.r0.q3.k.b bVar = this.f22596h;
            if (bVar != null) {
                bVar.f();
                this.f22596h.s(0);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            ForumHeaderView forumHeaderView = this.f22592d;
            if (forumHeaderView != null) {
                forumHeaderView.onChangeSkinType();
            }
            NavigationBar navigationBar = this.f22593e;
            if (navigationBar != null && this.a != null) {
                navigationBar.onChangeSkinType(this.n, i2);
            }
            c.a.r0.q3.k.b bVar = this.f22596h;
            if (bVar != null) {
                bVar.m(i2);
            }
            g gVar = this.f22598j;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            h hVar = this.f22599k;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            NoDataView noDataView = this.l;
            if (noDataView != null && this.a != null) {
                noDataView.setSubTitleTextColor(R.color.CAM_X0105);
                this.l.onChangeSkinType(this.n, i2);
            }
            SkinManager.setViewTextColor(this.f22594f, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundColor(this.f22590b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f22591c, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.f22593e, R.color.CAM_X0207, i2);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f22593e.setVisibility(8);
            this.f22592d.setVisibility(8);
            this.f22591c.setVisibility(8);
            ((LinearLayout.LayoutParams) this.f22597i.getLayoutParams()).bottomMargin = l.f(this.n.getPageActivity(), R.dimen.tbds22);
        }
    }

    public Pair<Integer, Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.r0.q3.k.b bVar = this.f22596h;
            return bVar != null ? bVar.c() : new Pair<>(0, 0);
        }
        return (Pair) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f22590b : (View) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f22596h.d() : (String) invokeV.objValue;
    }

    public void f() {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.e();
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (gVar = this.f22598j) == null) {
            return;
        }
        gVar.dettachView(this.f22597i);
        this.f22598j = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (hVar = this.f22599k) == null) {
            return;
        }
        hVar.dettachView(this.f22597i);
        this.f22599k = null;
    }

    public void i() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (noDataView = this.l) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void j() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (tbPageContext = this.n) == null) {
            return;
        }
        tbPageContext.registerListener(this.o);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f22590b.findViewById(R.id.navigation_bar);
            this.f22593e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f22593e.setCenterTextTitle(this.a.getString(R.string.forum_square));
            View addCustomView = this.f22593e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            this.f22595g = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
            this.f22594f = textView;
            textView.setText(this.a.getString(R.string.forum_square_create_bar));
            this.f22591c = (RelativeLayout) this.f22590b.findViewById(R.id.forum_header_serch_container);
            ForumHeaderView forumHeaderView = (ForumHeaderView) this.f22590b.findViewById(R.id.forum_header_serch_view);
            this.f22592d = forumHeaderView;
            forumHeaderView.setFrom(1);
            this.f22592d.setSearchHint(TbSingleton.getInstance().getHotSearch());
            this.f22596h = new c.a.r0.q3.k.b(this.n, this.f22590b);
            this.f22597i = (RelativeLayout) this.f22590b.findViewById(R.id.layout_container);
            a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            g gVar = this.f22598j;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            h hVar = this.f22599k;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.j();
    }

    public void o() {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.k();
    }

    public void p() {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.l();
    }

    public void q(int i2, int i3) {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.n(i2, i3);
    }

    public void r(String str, List<String> list, boolean z) {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048603, this, str, list, z) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.o(str, list, z);
    }

    public void s(List<n> list) {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, list) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.p(list);
    }

    public void t(List<n> list, int i2) {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048605, this, list, i2) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.q(list, i2);
    }

    public void u() {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.r();
    }

    public void v(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) || (textView = this.f22594f) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void w(LeftAdapter.b bVar) {
        c.a.r0.q3.k.b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, bVar) == null) || (bVar2 = this.f22596h) == null) {
            return;
        }
        bVar2.t(bVar);
    }

    public void x(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, onScrollListener) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.u(onScrollListener);
    }

    public void z(BdListView.p pVar) {
        c.a.r0.q3.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, pVar) == null) || (bVar = this.f22596h) == null) {
            return;
        }
        bVar.v(pVar);
    }
}
