package c.a.r0.w0.q1.f;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.a.d;
import c.a.e.a.f;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.g0.h;
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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<ForumRulesShowActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ForumRulesShowActivity f27669e;

    /* renamed from: f  reason: collision with root package name */
    public int f27670f;

    /* renamed from: g  reason: collision with root package name */
    public String f27671g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f27672h;

    /* renamed from: i  reason: collision with root package name */
    public NavigationBar f27673i;

    /* renamed from: j  reason: collision with root package name */
    public View f27674j;
    public ImageView k;
    public View l;
    public ImageView m;
    public c.a.r0.w0.q1.a.a n;
    public c.a.r0.w0.q1.d.b o;
    public c.a.r0.w0.q1.d.a p;
    public BdTypeRecyclerView q;
    public List<n> r;
    public View s;
    public h t;
    public int u;
    public int v;
    public c.a.r0.w0.q1.c.b w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f27675e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f27676f;

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
            this.f27676f = cVar;
            this.f27675e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.a.a(this.f27675e.t);
                l.M(this.f27676f.f27669e, this.f27676f.f27669e.getResources().getString(R.string.copy_pb_url_success));
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
        this.f27670f = 3;
        this.r = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.f27669e = forumRulesShowActivity;
        this.f27671g = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.o = new c.a.r0.w0.q1.d.b(forumRulesShowActivity);
        this.p = new c.a.r0.w0.q1.d.a(forumRulesShowActivity);
        this.u = l.g(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), R.dimen.ds14);
        p(forumRulesShowActivity);
    }

    public void d(c.a.r0.w0.q1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.w = bVar;
            this.r.add(bVar);
        }
    }

    public void e(c.a.r0.w0.q1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.r.add(aVar);
        }
    }

    public void f(List<c.a.r0.w0.q1.c.c> list) {
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
            this.f27669e = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27672h : (ViewGroup) invokeV.objValue;
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
        c.a.r0.w0.q1.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.o) == null) {
            return;
        }
        bVar.d(this.q);
    }

    public void n() {
        c.a.r0.w0.q1.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.d(this.q);
    }

    public final void o(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, navigationBar) == null) {
            View addSystemImageButton = this.f27673i.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.f27674j = addSystemImageButton;
            this.k = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.f27673i.setCenterTextTitle(this.f27669e.getResources().getString(R.string.forum_rules_local));
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
            this.l = addCustomView;
            this.m = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int i2 = this.u;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            layoutParams.rightMargin = this.v;
            this.l.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            t();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f27673i.onChangeSkinType(this.f27669e.getPageContext(), i2);
            if (this.f27670f == i2) {
                this.f27673i.getCenterText().setTextSize(R.dimen.L_X06);
                TextView centerText = this.f27673i.getCenterText();
                int i3 = R.color.CAM_X0611;
                SkinManager.setNavbarTitleColor(centerText, i3, i3);
                WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.m, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.o.c(i2);
                this.p.c(i2);
                this.n.b(i2);
                this.f27670f = i2;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || this.f27669e == null) {
            return;
        }
        if (view.getId() == R.id.root_pb_more) {
            int i2 = -1;
            c.a.r0.w0.q1.c.b bVar = this.w;
            if (bVar == null || bVar.h() == null) {
                str = "";
            } else {
                i2 = this.w.h().forum_id.intValue();
                str = this.w.h().forum_name;
            }
            c.a.r0.w0.q1.c.b bVar2 = this.w;
            String o = bVar2 != null ? bVar2.o() : "";
            String str2 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i2;
            ShareItem shareItem = new ShareItem();
            shareItem.r = o;
            shareItem.s = String.format(this.f27669e.getResources().getString(R.string.forum_rules_share_text), str);
            shareItem.t = str2;
            shareItem.f0 = false;
            c.a.r0.w0.q1.c.b bVar3 = this.w;
            if (bVar3 != null && !StringUtils.isNull(bVar3.h().avatar)) {
                shareItem.v = Uri.parse(this.w.h().avatar);
                shareItem.g();
            }
            shareItem.P = o;
            shareItem.Q = str2;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f27669e, shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            this.f27669e.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        } else if (view.getId() == R.id.navigationBarGoBack) {
            this.f27669e.finish();
        } else if (this.t == null || view.getId() != this.t.c().getId()) {
        } else {
            this.f27669e.requestNet();
        }
    }

    public final void p(ForumRulesShowActivity forumRulesShowActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, forumRulesShowActivity) == null) {
            this.f27672h = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
            NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
            this.f27673i = navigationBar;
            o(navigationBar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
            this.q = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
            this.n = new c.a.r0.w0.q1.a.a(forumRulesShowActivity, this.q);
            this.s = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
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
        c.a.r0.w0.q1.a.a aVar;
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
            this.f27671g = str;
            c.a.r0.w0.q1.a.a aVar = this.n;
            if (aVar != null) {
                aVar.d(str);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (((baseSwitchs == null || !baseSwitchs.containsKey("is_disable_forumrule_share")) ? -1 : baseSwitchs.get("is_disable_forumrule_share").intValue()) == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f27671g)) {
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
        c.a.r0.w0.q1.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.a(this.q);
        this.p.e(str);
    }
}
