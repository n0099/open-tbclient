package b.a.r0.s0.y.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
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
    public TbPageContext f23480a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f23481b;

    /* renamed from: c  reason: collision with root package name */
    public g f23482c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f23483d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f23484e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f23485f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.s0.x.a f23486g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f23487h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.g0.g f23488i;
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
        this.f23480a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f23483d = relativeLayout;
        this.f23484e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f23483d.findViewById(R.id.forum_emotion_list);
        this.f23481b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f23481b.setDivider(null);
        g gVar = new g(this.f23480a);
        this.f23482c = gVar;
        gVar.U(bdUniqueId);
        this.f23481b.setPullRefresh(this.f23482c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f23485f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23481b.completePullRefresh();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23481b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23484e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23483d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23487h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f23485f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f23481b.setNextPage(null);
        }
    }

    public void g() {
        b.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f23488i) == null) {
            return;
        }
        gVar.dettachView(this.f23483d);
        this.f23488i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f23486g.c().setVisibility(0);
            this.f23487h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.r0.s0.x.a aVar = new b.a.r0.s0.x.a(this.f23480a);
            this.f23486g = aVar;
            aVar.c().setVisibility(8);
            this.f23481b.addHeaderView(this.f23486g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f23480a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f23481b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f23480a.getPageActivity());
            this.f23487h = forumEmotionVoteEntryView;
            this.f23481b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f23485f.p(R.color.CAM_X0204);
            this.f23485f.d(i2);
            this.f23482c.C(i2);
            this.f23481b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f23483d, R.color.CAM_X0201);
            this.f23484e.onChangeSkinType(this.f23480a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f23487h;
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
            this.f23486g.c().setVisibility(0);
            this.f23486g.f(this.f23480a.getUniqueId());
            this.f23486g.e(new c(forumEmotionData.banner));
            this.f23486g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f23487h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f23482c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f23481b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f23485f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f23481b.setNextPage(this.f23485f);
        }
        this.f23485f.O();
        this.f23485f.Q();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f23480a) == null || this.f23483d == null) {
            return;
        }
        b.a.q0.g0.g gVar = new b.a.q0.g0.g(tbPageContext.getPageActivity());
        this.f23488i = gVar;
        gVar.attachView(this.f23483d, false);
        this.f23488i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.j == null) {
                this.j = NoDataViewFactory.b(this.f23480a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f23480a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f23480a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.j.setVisibility(0);
            this.f23486g.c().setVisibility(4);
            this.f23487h.setVisibility(4);
            this.j.onChangeSkinType(this.f23480a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f23485f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f23481b.setNextPage(this.f23485f);
        }
        this.f23485f.C(this.f23480a.getResources().getString(R.string.list_no_more));
        this.f23485f.f();
    }
}
