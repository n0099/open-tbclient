package c.a.r0.y0.y.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.r.l0.f;
import c.a.q0.r.l0.g;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24877b;

    /* renamed from: c  reason: collision with root package name */
    public g f24878c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f24879d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f24880e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f24881f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.y0.x.a f24882g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f24883h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.f0.g f24884i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f24885j;
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
        this.f24879d = relativeLayout;
        this.f24880e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f24879d.findViewById(R.id.forum_emotion_list);
        this.f24877b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f24877b.setDivider(null);
        g gVar = new g(this.a);
        this.f24878c = gVar;
        gVar.V(bdUniqueId);
        this.f24877b.setPullRefresh(this.f24878c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f24881f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24877b.completePullRefresh();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24877b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24880e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24879d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f24883h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f24881f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f24877b.setNextPage(null);
        }
    }

    public void g() {
        c.a.q0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f24884i) == null) {
            return;
        }
        gVar.dettachView(this.f24879d);
        this.f24884i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.f24885j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f24882g.c().setVisibility(0);
            this.f24883h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.y0.x.a aVar = new c.a.r0.y0.x.a(this.a);
            this.f24882g = aVar;
            aVar.c().setVisibility(8);
            this.f24877b.addHeaderView(this.f24882g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f24877b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.a.getPageActivity());
            this.f24883h = forumEmotionVoteEntryView;
            this.f24877b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f24881f.p(R.color.CAM_X0204);
            this.f24881f.d(i2);
            this.f24878c.C(i2);
            this.f24877b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f24879d, R.color.CAM_X0201);
            this.f24880e.onChangeSkinType(this.a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f24883h;
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
            this.f24882g.c().setVisibility(0);
            this.f24882g.f(this.a.getUniqueId());
            this.f24882g.e(new c(forumEmotionData.banner));
            this.f24882g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f24883h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f24878c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f24877b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f24881f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24877b.setNextPage(this.f24881f);
        }
        this.f24881f.P();
        this.f24881f.R();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.a) == null || this.f24879d == null) {
            return;
        }
        c.a.q0.f0.g gVar = new c.a.q0.f0.g(tbPageContext.getPageActivity());
        this.f24884i = gVar;
        gVar.attachView(this.f24879d, false);
        this.f24884i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f24885j == null) {
                this.f24885j = NoDataViewFactory.b(this.a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, n.f(this.a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.f24885j.setVisibility(0);
            this.f24882g.c().setVisibility(4);
            this.f24883h.setVisibility(4);
            this.f24885j.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f24881f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24877b.setNextPage(this.f24881f);
        }
        this.f24881f.D(this.a.getResources().getString(R.string.list_no_more));
        this.f24881f.f();
    }
}
