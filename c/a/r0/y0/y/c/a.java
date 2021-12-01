package c.a.r0.y0.y.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.g0.f;
import c.a.q0.s.g0.g;
import c.a.r0.y0.x.c.c;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25725b;

    /* renamed from: c  reason: collision with root package name */
    public g f25726c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f25727d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f25728e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f25729f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.y0.x.a f25730g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f25731h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.g0.g f25732i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f25733j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f25734k;

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
        this.f25727d = relativeLayout;
        this.f25728e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f25727d.findViewById(R.id.forum_emotion_list);
        this.f25725b = bdTypeListView;
        bdTypeListView.addHeaderView(this.f25734k);
        this.f25725b.setDivider(null);
        g gVar = new g(this.a);
        this.f25726c = gVar;
        gVar.V(bdUniqueId);
        this.f25725b.setPullRefresh(this.f25726c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f25729f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25725b.completePullRefresh();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25725b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25728e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25727d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25731h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f25729f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f25725b.setNextPage(null);
        }
    }

    public void g() {
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f25732i) == null) {
            return;
        }
        gVar.dettachView(this.f25727d);
        this.f25732i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.f25733j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f25730g.c().setVisibility(0);
            this.f25731h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.y0.x.a aVar = new c.a.r0.y0.x.a(this.a);
            this.f25730g = aVar;
            aVar.c().setVisibility(8);
            this.f25725b.addHeaderView(this.f25730g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
            this.f25734k = linearLayout;
            linearLayout.setGravity(17);
            this.f25725b.addHeaderView(this.f25734k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.a.getPageActivity());
            this.f25731h = forumEmotionVoteEntryView;
            this.f25725b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f25729f.p(R.color.CAM_X0204);
            this.f25729f.d(i2);
            this.f25726c.C(i2);
            this.f25725b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f25727d, R.color.CAM_X0201);
            this.f25728e.onChangeSkinType(this.a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f25731h;
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
            this.f25730g.c().setVisibility(0);
            this.f25730g.f(this.a.getUniqueId());
            this.f25730g.e(new c(forumEmotionData.banner));
            this.f25730g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f25731h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f25726c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f25725b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f25729f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25725b.setNextPage(this.f25729f);
        }
        this.f25729f.O();
        this.f25729f.Q();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.a) == null || this.f25727d == null) {
            return;
        }
        c.a.q0.g0.g gVar = new c.a.q0.g0.g(tbPageContext.getPageActivity());
        this.f25732i = gVar;
        gVar.attachView(this.f25727d, false);
        this.f25732i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f25733j == null) {
                this.f25733j = NoDataViewFactory.b(this.a.getPageActivity(), this.f25734k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.f(this.a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.f25733j.setVisibility(0);
            this.f25730g.c().setVisibility(4);
            this.f25731h.setVisibility(4);
            this.f25733j.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f25729f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25725b.setNextPage(this.f25729f);
        }
        this.f25729f.C(this.a.getResources().getString(R.string.list_no_more));
        this.f25729f.f();
    }
}
