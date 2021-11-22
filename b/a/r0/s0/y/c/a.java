package b.a.r0.s0.y.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import b.a.r0.s0.x.c.c;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f24811a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24812b;

    /* renamed from: c  reason: collision with root package name */
    public g f24813c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f24814d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f24815e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f24816f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.s0.x.a f24817g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f24818h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.g0.g f24819i;
    public NoDataView j;
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
        this.f24811a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f24814d = relativeLayout;
        this.f24815e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f24814d.findViewById(R.id.forum_emotion_list);
        this.f24812b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f24812b.setDivider(null);
        g gVar = new g(this.f24811a);
        this.f24813c = gVar;
        gVar.U(bdUniqueId);
        this.f24812b.setPullRefresh(this.f24813c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f24816f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24812b.completePullRefresh();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24812b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24815e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24814d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f24818h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f24816f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f24812b.setNextPage(null);
        }
    }

    public void g() {
        b.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f24819i) == null) {
            return;
        }
        gVar.dettachView(this.f24814d);
        this.f24819i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f24817g.c().setVisibility(0);
            this.f24818h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.r0.s0.x.a aVar = new b.a.r0.s0.x.a(this.f24811a);
            this.f24817g = aVar;
            aVar.c().setVisibility(8);
            this.f24812b.addHeaderView(this.f24817g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f24811a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f24812b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f24811a.getPageActivity());
            this.f24818h = forumEmotionVoteEntryView;
            this.f24812b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f24816f.p(R.color.CAM_X0204);
            this.f24816f.d(i2);
            this.f24813c.C(i2);
            this.f24812b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f24814d, R.color.CAM_X0201);
            this.f24815e.onChangeSkinType(this.f24811a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f24818h;
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
            this.f24817g.c().setVisibility(0);
            this.f24817g.f(this.f24811a.getUniqueId());
            this.f24817g.e(new c(forumEmotionData.banner));
            this.f24817g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f24818h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f24813c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f24812b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f24816f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24812b.setNextPage(this.f24816f);
        }
        this.f24816f.O();
        this.f24816f.Q();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f24811a) == null || this.f24814d == null) {
            return;
        }
        b.a.q0.g0.g gVar = new b.a.q0.g0.g(tbPageContext.getPageActivity());
        this.f24819i = gVar;
        gVar.attachView(this.f24814d, false);
        this.f24819i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.j == null) {
                this.j = NoDataViewFactory.b(this.f24811a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f24811a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f24811a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.j.setVisibility(0);
            this.f24817g.c().setVisibility(4);
            this.f24818h.setVisibility(4);
            this.j.onChangeSkinType(this.f24811a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f24816f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24812b.setNextPage(this.f24816f);
        }
        this.f24816f.C(this.f24811a.getResources().getString(R.string.list_no_more));
        this.f24816f.f();
    }
}
