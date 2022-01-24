package c.a.t0.e1.c2.f;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.d.n.e.n;
import c.a.s0.g0.h;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.e1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends d<ForumRulesShowActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ForumRulesShowActivity f16237e;

    /* renamed from: f  reason: collision with root package name */
    public int f16238f;

    /* renamed from: g  reason: collision with root package name */
    public String f16239g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f16240h;

    /* renamed from: i  reason: collision with root package name */
    public NavigationBar f16241i;

    /* renamed from: j  reason: collision with root package name */
    public View f16242j;
    public ImageView k;
    public View l;
    public ImageView m;
    public c.a.t0.e1.c2.a.a n;
    public c.a.t0.e1.c2.d.b o;
    public c.a.t0.e1.c2.d.a p;
    public BdTypeRecyclerView q;
    public List<n> r;
    public View s;
    public h t;
    public int u;
    public int v;
    public c.a.t0.e1.c2.c.b w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f16243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f16244f;

        public a(c cVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16244f = cVar;
            this.f16243e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.c.a(this.f16243e.t);
                c.a.d.f.p.n.N(this.f16244f.f16237e, this.f16244f.f16237e.getResources().getString(i1.copy_pb_url_success));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16238f = 3;
        this.r = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.f16237e = forumRulesShowActivity;
        this.f16239g = str;
        forumRulesShowActivity.setContentView(g1.activity_forum_rules_show);
        this.o = new c.a.t0.e1.c2.d.b(forumRulesShowActivity);
        this.p = new c.a.t0.e1.c2.d.a(forumRulesShowActivity);
        this.u = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), d1.ds88);
        this.v = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), d1.ds14);
        p(forumRulesShowActivity);
    }

    public void d(c.a.t0.e1.c2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.w = bVar;
            this.r.add(bVar);
        }
    }

    public void e(c.a.t0.e1.c2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.r.add(aVar);
        }
    }

    public void f(List<c.a.t0.e1.c2.c.c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.r.addAll(list);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            w(str);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16237e = null;
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.s : (View) invokeV.objValue;
    }

    public ViewGroup j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16240h : (ViewGroup) invokeV.objValue;
    }

    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.q) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(8);
    }

    public void l() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view = this.s) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void m() {
        c.a.t0.e1.c2.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.o) == null) {
            return;
        }
        bVar.d(this.q);
    }

    public void n() {
        c.a.t0.e1.c2.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.d(this.q);
    }

    public final void o(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, navigationBar) == null) {
            View addSystemImageButton = this.f16241i.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.f16242j = addSystemImageButton;
            this.k = (ImageView) addSystemImageButton.findViewById(f1.widget_navi_back_button);
            this.f16241i.setCenterTextTitle(this.f16237e.getResources().getString(i1.forum_rules_local));
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, g1.nb_item_floor_more, this);
            this.l = addCustomView;
            this.m = (ImageView) addCustomView.findViewById(f1.navigationBarBtnMore);
            int i2 = this.u;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            layoutParams.rightMargin = this.v;
            this.l.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, e1.icon_pure_topbar_more44_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            t();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f16241i.onChangeSkinType(this.f16237e.getPageContext(), i2);
            if (this.f16238f == i2) {
                this.f16241i.getCenterText().setTextSize(d1.L_X06);
                TextView centerText = this.f16241i.getCenterText();
                int i3 = c1.CAM_X0611;
                SkinManager.setNavbarTitleColor(centerText, i3, i3);
                WebPManager.setPureDrawable(this.k, e1.icon_pure_topbar_return40, c1.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.m, e1.icon_pure_topbar_more40, c1.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.o.c(i2);
                this.p.c(i2);
                this.n.b(i2);
                this.f16238f = i2;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || this.f16237e == null) {
            return;
        }
        if (view.getId() == f1.root_pb_more) {
            int i2 = -1;
            c.a.t0.e1.c2.c.b bVar = this.w;
            if (bVar == null || bVar.h() == null) {
                str = "";
            } else {
                i2 = this.w.h().forum_id.intValue();
                str = this.w.h().forum_name;
            }
            c.a.t0.e1.c2.c.b bVar2 = this.w;
            String o = bVar2 != null ? bVar2.o() : "";
            String str2 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i2;
            ShareItem shareItem = new ShareItem();
            shareItem.r = o;
            shareItem.s = String.format(this.f16237e.getResources().getString(i1.forum_rules_share_text), str);
            shareItem.t = str2;
            shareItem.h0 = false;
            c.a.t0.e1.c2.c.b bVar3 = this.w;
            if (bVar3 != null && !StringUtils.isNull(bVar3.h().avatar)) {
                shareItem.v = Uri.parse(this.w.h().avatar);
                shareItem.g();
            }
            shareItem.P = o;
            shareItem.Q = str2;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f16237e, shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            this.f16237e.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        } else if (view.getId() == f1.navigationBarGoBack) {
            this.f16237e.finish();
        } else if (this.t == null || view.getId() != this.t.c().getId()) {
        } else {
            this.f16237e.requestNet();
        }
    }

    public final void p(ForumRulesShowActivity forumRulesShowActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, forumRulesShowActivity) == null) {
            this.f16240h = (ViewGroup) forumRulesShowActivity.findViewById(f1.forum_rule_rootview);
            NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(f1.navigationbar);
            this.f16241i = navigationBar;
            o(navigationBar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(f1.forum_rules_list_info);
            this.q = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
            this.n = new c.a.t0.e1.c2.a.a(forumRulesShowActivity, this.q);
            this.s = forumRulesShowActivity.findViewById(f1.forum_rules_net_refresh_layout);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            n();
            m();
        }
    }

    public void r() {
        c.a.t0.e1.c2.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (aVar = this.n) == null) {
            return;
        }
        aVar.c(this.r);
    }

    public void s(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hVar) == null) {
            this.t = hVar;
            hVar.c().setOnClickListener(this);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f16239g = str;
            c.a.t0.e1.c2.a.a aVar = this.n;
            if (aVar != null) {
                aVar.d(str);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (((baseSwitchs == null || !baseSwitchs.containsKey("is_disable_forumrule_share")) ? -1 : baseSwitchs.get("is_disable_forumrule_share").intValue()) == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f16239g)) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
        }
    }

    public void u() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (bdTypeRecyclerView = this.q) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(0);
    }

    public void v() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (view = this.s) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || this.o == null || StringUtils.isNull(str)) {
            return;
        }
        this.o.a(this.q);
        this.o.e(str);
    }

    public void x(String str) {
        c.a.t0.e1.c2.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.a(this.q);
        this.p.e(str);
    }
}
