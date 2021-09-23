package c.a.r0.r0.y.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
import c.a.r0.r0.x.c.c;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f24454a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24455b;

    /* renamed from: c  reason: collision with root package name */
    public g f24456c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f24457d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f24458e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f24459f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.r0.x.a f24460g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f24461h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.g0.g f24462i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f24463j;
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
        this.f24454a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f24457d = relativeLayout;
        this.f24458e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f24457d.findViewById(R.id.forum_emotion_list);
        this.f24455b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f24455b.setDivider(null);
        g gVar = new g(this.f24454a);
        this.f24456c = gVar;
        gVar.V(bdUniqueId);
        this.f24455b.setPullRefresh(this.f24456c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f24459f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24455b.completePullRefresh();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24455b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24458e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24457d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f24461h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f24459f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f24455b.setNextPage(null);
        }
    }

    public void g() {
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f24462i) == null) {
            return;
        }
        gVar.dettachView(this.f24457d);
        this.f24462i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.f24463j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f24460g.c().setVisibility(0);
            this.f24461h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.r0.x.a aVar = new c.a.r0.r0.x.a(this.f24454a);
            this.f24460g = aVar;
            aVar.c().setVisibility(8);
            this.f24455b.addHeaderView(this.f24460g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f24454a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f24455b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f24454a.getPageActivity());
            this.f24461h = forumEmotionVoteEntryView;
            this.f24455b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f24459f.o(R.color.CAM_X0204);
            this.f24459f.d(i2);
            this.f24456c.D(i2);
            this.f24455b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f24457d, R.color.CAM_X0201);
            this.f24458e.onChangeSkinType(this.f24454a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f24461h;
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
            this.f24460g.c().setVisibility(0);
            this.f24460g.f(this.f24454a.getUniqueId());
            this.f24460g.e(new c(forumEmotionData.banner));
            this.f24460g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f24461h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f24456c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f24455b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f24459f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24455b.setNextPage(this.f24459f);
        }
        this.f24459f.M();
        this.f24459f.O();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f24454a) == null || this.f24457d == null) {
            return;
        }
        c.a.q0.g0.g gVar = new c.a.q0.g0.g(tbPageContext.getPageActivity());
        this.f24462i = gVar;
        gVar.attachView(this.f24457d, false);
        this.f24462i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f24463j == null) {
                this.f24463j = NoDataViewFactory.b(this.f24454a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f24454a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f24454a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.f24463j.setVisibility(0);
            this.f24460g.c().setVisibility(4);
            this.f24461h.setVisibility(4);
            this.f24463j.onChangeSkinType(this.f24454a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f24459f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24455b.setNextPage(this.f24459f);
        }
        this.f24459f.A(this.f24454a.getResources().getString(R.string.list_no_more));
        this.f24459f.f();
    }
}
