package c.a.p0.f1.s1.f;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.d.o.e.n;
import c.a.o0.f0.h;
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
/* loaded from: classes2.dex */
public class c extends d<ForumRulesShowActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity a;

    /* renamed from: b  reason: collision with root package name */
    public int f14553b;

    /* renamed from: c  reason: collision with root package name */
    public String f14554c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f14555d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f14556e;

    /* renamed from: f  reason: collision with root package name */
    public View f14557f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f14558g;

    /* renamed from: h  reason: collision with root package name */
    public View f14559h;
    public ImageView i;
    public c.a.p0.f1.s1.a.a j;
    public c.a.p0.f1.s1.d.b k;
    public c.a.p0.f1.s1.d.a l;
    public BdTypeRecyclerView m;
    public List<n> n;
    public View o;
    public h p;
    public int q;
    public int r;
    public c.a.p0.f1.s1.c.b s;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f14560b;

        public a(c cVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14560b = cVar;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.c.a(this.a.t);
                c.a.d.f.p.n.N(this.f14560b.a, this.f14560b.a.getResources().getString(R.string.obfuscated_res_0x7f0f0438));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14553b = 3;
        this.n = new ArrayList();
        this.q = 0;
        this.r = 0;
        this.a = forumRulesShowActivity;
        this.f14554c = str;
        forumRulesShowActivity.setContentView(R.layout.obfuscated_res_0x7f0d0034);
        this.k = new c.a.p0.f1.s1.d.b(forumRulesShowActivity);
        this.l = new c.a.p0.f1.s1.d.a(forumRulesShowActivity);
        this.q = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702ff);
        this.r = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        r(forumRulesShowActivity);
    }

    public void d(c.a.p0.f1.s1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.s = bVar;
            this.n.add(bVar);
        }
    }

    public void g(c.a.p0.f1.s1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.n.add(aVar);
        }
    }

    public void h(List<c.a.p0.f1.s1.c.c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.n.addAll(list);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            y(str);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = null;
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public ViewGroup l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14555d : (ViewGroup) invokeV.objValue;
    }

    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.m) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(8);
    }

    public void n() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void o() {
        c.a.p0.f1.s1.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.k) == null) {
            return;
        }
        bVar.d(this.m);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f14556e.onChangeSkinType(this.a.getPageContext(), i);
            if (this.f14553b == i) {
                this.f14556e.getCenterText().setTextSize((float) R.dimen.L_X06);
                SkinManager.setNavbarTitleColor(this.f14556e.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
                WebPManager.setPureDrawable(this.f14558g, R.drawable.obfuscated_res_0x7f0809bd, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.i, R.drawable.obfuscated_res_0x7f0809b9, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.k.c(i);
                this.l.c(i);
                this.j.b(i);
                this.f14553b = i;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || this.a == null) {
            return;
        }
        if (view.getId() == R.id.obfuscated_res_0x7f091aea) {
            int i = -1;
            c.a.p0.f1.s1.c.b bVar = this.s;
            if (bVar == null || bVar.g() == null) {
                str = "";
            } else {
                i = this.s.g().forum_id.intValue();
                str = this.s.g().forum_name;
            }
            c.a.p0.f1.s1.c.b bVar2 = this.s;
            String n = bVar2 != null ? bVar2.n() : "";
            String str2 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
            ShareItem shareItem = new ShareItem();
            shareItem.r = n;
            shareItem.s = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f069b), str);
            shareItem.t = str2;
            shareItem.h0 = false;
            c.a.p0.f1.s1.c.b bVar3 = this.s;
            if (bVar3 != null && !StringUtils.isNull(bVar3.g().avatar)) {
                shareItem.v = Uri.parse(this.s.g().avatar);
                shareItem.g();
            }
            shareItem.P = n;
            shareItem.Q = str2;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        } else if (view.getId() == R.id.obfuscated_res_0x7f091511) {
            this.a.finish();
        } else if (this.p == null || view.getId() != this.p.c().getId()) {
        } else {
            this.a.requestNet();
        }
    }

    public void p() {
        c.a.p0.f1.s1.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.d(this.m);
    }

    public final void q(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, navigationBar) == null) {
            View addSystemImageButton = this.f14556e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.f14557f = addSystemImageButton;
            this.f14558g = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09246f);
            this.f14556e.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0698));
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e6, this);
            this.f14559h = addCustomView;
            this.i = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09150f);
            int i = this.q;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.rightMargin = this.r;
            this.f14559h.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            v();
        }
    }

    public final void r(ForumRulesShowActivity forumRulesShowActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, forumRulesShowActivity) == null) {
            this.f14555d = (ViewGroup) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090a71);
            NavigationBar navigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f09152d);
            this.f14556e = navigationBar;
            q(navigationBar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090a7e);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
            this.j = new c.a.p0.f1.s1.a.a(forumRulesShowActivity, this.m);
            this.o = forumRulesShowActivity.findViewById(R.id.obfuscated_res_0x7f090a7f);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p();
            o();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f14554c = str;
            c.a.p0.f1.s1.a.a aVar = this.j;
            if (aVar != null) {
                aVar.d(str);
            }
        }
    }

    public void t() {
        c.a.p0.f1.s1.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.c(this.n);
    }

    public void u(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hVar) == null) {
            this.p = hVar;
            hVar.c().setOnClickListener(this);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (((baseSwitchs == null || !baseSwitchs.containsKey("is_disable_forumrule_share")) ? -1 : baseSwitchs.get("is_disable_forumrule_share").intValue()) == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f14554c)) {
                this.f14559h.setVisibility(0);
            } else {
                this.f14559h.setVisibility(8);
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (bdTypeRecyclerView = this.m) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(0);
    }

    public void x() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || this.k == null || StringUtils.isNull(str)) {
            return;
        }
        this.k.a(this.m);
        this.k.e(str);
    }

    public void z(String str) {
        c.a.p0.f1.s1.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.a(this.m);
        this.l.e(str);
    }
}
