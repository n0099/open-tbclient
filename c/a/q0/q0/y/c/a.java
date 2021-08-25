package c.a.q0.q0.y.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.f0.f;
import c.a.p0.s.f0.g;
import c.a.q0.q0.x.c.c;
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
    public TbPageContext f23864a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f23865b;

    /* renamed from: c  reason: collision with root package name */
    public g f23866c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f23867d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f23868e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f23869f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.q0.x.a f23870g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f23871h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.f0.g f23872i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f23873j;
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
        this.f23864a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f23867d = relativeLayout;
        this.f23868e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f23867d.findViewById(R.id.forum_emotion_list);
        this.f23865b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f23865b.setDivider(null);
        g gVar = new g(this.f23864a);
        this.f23866c = gVar;
        gVar.V(bdUniqueId);
        this.f23865b.setPullRefresh(this.f23866c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f23869f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23865b.completePullRefresh();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23865b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23868e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23867d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23871h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f23869f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f23865b.setNextPage(null);
        }
    }

    public void g() {
        c.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f23872i) == null) {
            return;
        }
        gVar.dettachView(this.f23867d);
        this.f23872i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.f23873j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f23870g.c().setVisibility(0);
            this.f23871h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.q0.q0.x.a aVar = new c.a.q0.q0.x.a(this.f23864a);
            this.f23870g = aVar;
            aVar.c().setVisibility(8);
            this.f23865b.addHeaderView(this.f23870g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f23864a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f23865b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f23864a.getPageActivity());
            this.f23871h = forumEmotionVoteEntryView;
            this.f23865b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f23869f.o(R.color.CAM_X0204);
            this.f23869f.d(i2);
            this.f23866c.D(i2);
            this.f23865b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f23867d, R.color.CAM_X0201);
            this.f23868e.onChangeSkinType(this.f23864a, i2);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f23871h;
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
            this.f23870g.c().setVisibility(0);
            this.f23870g.f(this.f23864a.getUniqueId());
            this.f23870g.e(new c(forumEmotionData.banner));
            this.f23870g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f23871h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f23866c.a(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f23865b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f23869f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f23865b.setNextPage(this.f23869f);
        }
        this.f23869f.M();
        this.f23869f.O();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f23864a) == null || this.f23867d == null) {
            return;
        }
        c.a.p0.f0.g gVar = new c.a.p0.f0.g(tbPageContext.getPageActivity());
        this.f23872i = gVar;
        gVar.attachView(this.f23867d, false);
        this.f23872i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f23873j == null) {
                this.f23873j = NoDataViewFactory.b(this.f23864a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f23864a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f23864a.getString(R.string.emotion_error_net_tip)), null, true);
            }
            this.f23873j.setVisibility(0);
            this.f23870g.c().setVisibility(4);
            this.f23871h.setVisibility(4);
            this.f23873j.onChangeSkinType(this.f23864a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f23869f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f23865b.setNextPage(this.f23869f);
        }
        this.f23869f.A(this.f23864a.getResources().getString(R.string.list_no_more));
        this.f23869f.f();
    }
}
