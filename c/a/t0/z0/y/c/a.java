package c.a.t0.z0.y.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.k0.f;
import c.a.s0.s.k0.g;
import c.a.t0.z0.x.c.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionVoteEntryView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26111b;

    /* renamed from: c  reason: collision with root package name */
    public g f26112c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f26113d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f26114e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f26115f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.z0.x.a f26116g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f26117h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.g0.g f26118i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f26119j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f26113d = relativeLayout;
        this.f26114e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f26113d.findViewById(R.id.forum_emotion_list);
        this.f26111b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f26111b.setDivider(null);
        g gVar = new g(this.a);
        this.f26112c = gVar;
        gVar.V(bdUniqueId);
        this.f26111b.setPullRefresh(this.f26112c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f26115f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26111b.completePullRefresh();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26111b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26114e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26113d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26117h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f26115f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f26111b.setNextPage(null);
        }
    }

    public void g() {
        c.a.s0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f26118i) == null) {
            return;
        }
        gVar.dettachView(this.f26113d);
        this.f26118i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.f26119j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f26116g.c().setVisibility(0);
            this.f26117h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.t0.z0.x.a aVar = new c.a.t0.z0.x.a(this.a);
            this.f26116g = aVar;
            aVar.c().setVisibility(8);
            this.f26111b.addHeaderView(this.f26116g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f26111b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.a.getPageActivity());
            this.f26117h = forumEmotionVoteEntryView;
            this.f26111b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f26115f.p(R.color.CAM_X0204);
            this.f26115f.d(i2);
            this.f26112c.C(i2);
            this.f26111b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f26113d, R.color.CAM_X0201);
            this.f26114e.onChangeSkinType(this.a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f26117h;
            if (forumEmotionVoteEntryView != null) {
                forumEmotionVoteEntryView.onChangeSkin(i2);
            }
        }
    }

    public void m(ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, forumEmotionData) == null) || forumEmotionData == null) {
            return;
        }
        g();
        if (forumEmotionData.banner != null) {
            this.f26116g.c().setVisibility(0);
            this.f26116g.f(this.a.getUniqueId());
            this.f26116g.e(new c(forumEmotionData.banner));
            this.f26116g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f26117h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f26112c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f26111b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f26115f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f26111b.setNextPage(this.f26115f);
        }
        this.f26115f.P();
        this.f26115f.R();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.a) == null || this.f26113d == null) {
            return;
        }
        c.a.s0.g0.g gVar = new c.a.s0.g0.g(tbPageContext.getPageActivity());
        this.f26118i = gVar;
        gVar.attachView(this.f26113d, false);
        this.f26118i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f26119j == null) {
                this.f26119j = NoDataViewFactory.b(this.a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, n.f(this.a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.f26119j.setVisibility(0);
            this.f26116g.c().setVisibility(4);
            this.f26117h.setVisibility(4);
            this.f26119j.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f26115f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f26111b.setNextPage(this.f26115f);
        }
        this.f26115f.D(this.a.getResources().getString(R.string.list_no_more));
        this.f26115f.f();
    }
}
