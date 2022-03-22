package c.a.p0.a1.z.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
import c.a.p0.a1.y.c.c;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f12102b;

    /* renamed from: c  reason: collision with root package name */
    public g f12103c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f12104d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f12105e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f12106f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a1.y.a f12107g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f12108h;
    public c.a.o0.f0.g i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02de, (ViewGroup) null);
        this.f12104d = relativeLayout;
        this.f12105e = (NoNetworkView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09159c);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f12104d.findViewById(R.id.obfuscated_res_0x7f090a32);
        this.f12102b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f12102b.setDivider(null);
        g gVar = new g(this.a);
        this.f12103c = gVar;
        gVar.a0(bdUniqueId);
        this.f12102b.setPullRefresh(this.f12103c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f12106f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12102b.z();
        }
    }

    public BdTypeListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12102b : (BdTypeListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12105e : (View) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12104d : (ViewGroup) invokeV.objValue;
    }

    public ForumEmotionVoteEntryView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12108h : (ForumEmotionVoteEntryView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PbListView pbListView = this.f12106f;
            if (pbListView != null) {
                pbListView.f();
            }
            this.f12102b.setNextPage(null);
        }
    }

    public void g() {
        c.a.o0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.i) == null) {
            return;
        }
        gVar.dettachView(this.f12104d);
        this.i = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.f12107g.c().setVisibility(0);
            this.f12108h.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.a1.y.a aVar = new c.a.p0.a1.y.a(this.a);
            this.f12107g = aVar;
            aVar.c().setVisibility(8);
            this.f12102b.addHeaderView(this.f12107g.c());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
            this.k = linearLayout;
            linearLayout.setGravity(17);
            this.f12102b.addHeaderView(this.k);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.a.getPageActivity());
            this.f12108h = forumEmotionVoteEntryView;
            this.f12102b.addHeaderView(forumEmotionVoteEntryView);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f12106f.p(R.color.CAM_X0204);
            this.f12106f.d(i);
            this.f12103c.H(i);
            this.f12102b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            SkinManager.setBackgroundColor(this.f12104d, R.color.CAM_X0201);
            this.f12105e.c(this.a, i);
            ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f12108h;
            if (forumEmotionVoteEntryView != null) {
                forumEmotionVoteEntryView.b(i);
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
            this.f12107g.c().setVisibility(0);
            this.f12107g.f(this.a.getUniqueId());
            this.f12107g.e(new c(forumEmotionData.banner));
            this.f12107g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f12108h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f12103c.f(gVar);
        }
    }

    public void o(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f12102b.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f12106f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f12102b.setNextPage(this.f12106f);
        }
        this.f12106f.P();
        this.f12106f.R();
    }

    public void q() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.a) == null || this.f12104d == null) {
            return;
        }
        c.a.o0.f0.g gVar = new c.a.o0.f0.g(tbPageContext.getPageActivity());
        this.i = gVar;
        gVar.attachView(this.f12104d, false);
        this.i.onChangeSkinType();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.j == null) {
                this.j = NoDataViewFactory.b(this.a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07022e)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f053c)), null, true);
            }
            this.j.setVisibility(0);
            this.f12107g.c().setVisibility(4);
            this.f12108h.setVisibility(4);
            this.j.f(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.f12106f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f12102b.setNextPage(this.f12106f);
        }
        this.f12106f.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
        this.f12106f.f();
    }
}
