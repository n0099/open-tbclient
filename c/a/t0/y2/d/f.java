package c.a.t0.y2.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f extends c.a.t0.y2.d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f25628f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f25629g;

    /* renamed from: h  reason: collision with root package name */
    public View f25630h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.g0.h f25631i;

    /* renamed from: j  reason: collision with root package name */
    public e f25632j;
    public PbListView k;
    public NoNetworkView l;
    public PluginErrorTipView m;
    public ImageView n;
    public c.a.s0.g0.g o;
    public int p;
    public LinearLayout q;
    public FrameLayout r;
    public NoNetworkView s;
    public RelativeLayout t;
    public c.a.t0.y2.j.k u;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f25633e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25633e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f25633e.f25628f.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ViewHelper.skipToLoginActivity(this.f25633e.f25628f.getPageActivity());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f25634e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25634e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                this.f25634e.o();
                this.f25634e.B(true);
                if (this.f25634e.f25632j != null) {
                    this.f25634e.f25632j.a(view);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f25635e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25635e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f25635e.f25628f.getPageActivity(), null, c.a.t0.t2.c.a(), true)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.y2.f.b f25636e;

        /* renamed from: f  reason: collision with root package name */
        public UserData f25637f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.t0.n4.e f25638g;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25636e = new c.a.t0.y2.f.b();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UserData userData = this.f25637f;
                if (userData == null || !userData.isBaijiahaoUser()) {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                    c.a.t0.y2.f.b bVar = this.f25636e;
                    bVar.a = 10;
                    bVar.f24737b = new Bundle();
                    this.f25636e.f24737b.putSerializable(UserData.TYPE_USER, this.f25637f);
                    c.a.t0.n4.e eVar = this.f25638g;
                    if (eVar != null) {
                        eVar.a(view, this.f25636e);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(View view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        new d();
        this.p = 3;
        if (tbPageContext == null || view == null) {
            return;
        }
        this.f25628f = tbPageContext;
        this.f25630h = view;
        this.l = (NoNetworkView) view.findViewById(c.a.t0.z2.d.person_center_no_network_view);
        this.m = (PluginErrorTipView) this.f25630h.findViewById(c.a.t0.z2.d.person_center_plugin_error_tip_view);
        this.q = (LinearLayout) this.f25630h.findViewById(c.a.t0.z2.d.person_center_anti_container);
        c.a.t0.y2.j.k kVar = new c.a.t0.y2.j.k(this.f25628f, this.f25630h.findViewById(c.a.t0.z2.d.person_center_anti_navigation_bar), this.f25630h.findViewById(c.a.t0.z2.d.person_center_anti_status_bar_space), z);
        this.u = kVar;
        kVar.k(PersonStatus.GUEST_DEFAULT);
        this.r = (FrameLayout) this.f25630h.findViewById(c.a.t0.z2.d.person_center_anti_content);
        this.s = (NoNetworkView) this.f25630h.findViewById(c.a.t0.z2.d.person_center_anti_no_network_view);
        this.t = (RelativeLayout) this.f25630h.findViewById(c.a.t0.z2.d.person_center_noanti_rootview);
        PbListView pbListView = new PbListView(this.f25628f.getPageActivity());
        this.k = pbListView;
        pbListView.b();
        this.k.F(SkinManager.getColor(c.a.t0.z2.a.CAM_X0109));
        this.k.B(c.a.t0.z2.a.CAM_X0110);
        this.k.p(c.a.t0.z2.a.CAM_X0201);
        this.k.t(n.f(this.f25628f.getPageActivity(), c.a.t0.z2.b.ds140));
        this.k.r(n.f(this.f25628f.getPageActivity(), c.a.t0.z2.b.ds12));
        this.k.A();
        this.k.x(c.a.t0.z2.a.CAM_X0205);
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.r == null) {
            return;
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.q.setVisibility(0);
        int dimensionPixelSize = this.f25628f.getResources().getDimensionPixelSize(c.a.t0.z2.b.ds220);
        int dimensionPixelSize2 = this.f25628f.getResources().getDimensionPixelSize(c.a.t0.z2.b.ds480);
        int dimensionPixelSize3 = this.f25628f.getResources().getDimensionPixelSize(c.a.t0.z2.b.ds360);
        int dimensionPixelSize4 = this.f25628f.getResources().getDimensionPixelSize(c.a.t0.z2.b.ds60);
        int dimensionPixelSize5 = this.f25628f.getResources().getDimensionPixelSize(c.a.t0.z2.b.ds20);
        NoDataView a2 = NoDataViewFactory.a(this.f25628f.getPageActivity(), this.r, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, c.a.t0.z2.c.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.e(c.a.t0.z2.g.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.c.b(new NoDataViewFactory.b(this.f25628f.getString(c.a.t0.z2.g.unlogin_person_button_text), new a(this)), dimensionPixelSize5));
        this.f25629g = a2;
        a2.setVisibility(0);
        this.f25629g.onChangeSkinType(this.f25628f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
            y();
        }
    }

    public void k(c.a.t0.y2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.s0.g0.g gVar = this.o;
            if (gVar != null) {
                gVar.dettachView(this.f25630h);
                this.o = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
        }
    }

    public void o() {
        c.a.s0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hVar = this.f25631i) == null) {
            return;
        }
        hVar.dettachView(this.r);
        this.f25631i = null;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.s0.g0.h hVar = this.f25631i;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.p == i2) {
            return;
        }
        NoDataView noDataView = this.f25629g;
        if (noDataView != null) {
            noDataView.onChangeSkinType(this.f25628f, i2);
        }
        NoNetworkView noNetworkView = this.s;
        if (noNetworkView != null) {
            noNetworkView.onChangeSkinType(this.f25628f, i2);
        }
        c.a.t0.y2.j.k kVar = this.u;
        if (kVar != null) {
            kVar.g(i2);
        }
        SkinManager.setBackgroundResource(this.f25630h, c.a.t0.z2.a.CAM_X0201);
        c.a.s0.g0.h hVar = this.f25631i;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.p = i2;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.t.setVisibility(i2);
        }
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f25632j = eVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.t.setVisibility(8);
            int dimensionPixelSize = this.f25628f.getResources().getDimensionPixelSize(c.a.t0.z2.b.ds240);
            if (this.f25629g == null) {
                this.f25629g = NoDataViewFactory.a(this.f25628f.getPageActivity(), this.f25630h, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.e.d(null, this.f25628f.getString(c.a.t0.z2.g.user_to_anti)), null);
            }
            SkinManager.setViewTextColor(this.f25629g.getSuTextView(), c.a.t0.z2.a.CAM_X0106);
            this.f25629g.onChangeSkinType(this.f25628f, TbadkCoreApplication.getInst().getSkinType());
            this.f25629g.setVisibility(0);
        }
    }

    public void v(List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && ListUtils.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void w(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.o == null) {
                if (i2 < 0) {
                    this.o = new c.a.s0.g0.g(this.f25628f.getContext());
                } else {
                    this.o = new c.a.s0.g0.g(this.f25628f.getContext(), i2);
                }
                this.o.onChangeSkinType();
            }
            this.o.attachView(this.f25630h, z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
        }
    }

    public void x(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) || q()) {
            return;
        }
        this.q.setVisibility(0);
        if (this.f25631i == null) {
            this.f25631i = new c.a.s0.g0.h(this.f25628f.getPageActivity(), new b(this));
        }
        this.f25631i.h(c.a.t0.z2.c.new_pic_emotion_08);
        this.f25631i.attachView(this.r, z);
        this.f25631i.p();
        this.f25631i.onChangeSkinType();
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (NickNameActivitySwitch.isOn()) {
                if (this.n == null) {
                    ImageView imageView = new ImageView(this.f25628f.getPageActivity());
                    this.n = imageView;
                    imageView.setImageResource(c.a.t0.z2.c.icon_nichengjun);
                    this.n.setOnClickListener(new c(this));
                }
                if (this.n.getParent() != null) {
                    ((ViewGroup) this.n.getParent()).removeView(this.n);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.topMargin = n.f(this.f25628f.getPageActivity(), c.a.t0.z2.b.ds504);
                layoutParams.rightMargin = n.f(this.f25628f.getPageActivity(), c.a.t0.z2.b.ds26);
                View view = this.f25630h;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).addView(this.n, layoutParams);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.n;
            if (imageView2 == null || imageView2.getParent() == null) {
                return;
            }
            ViewParent parent = this.n.getParent();
            View view2 = this.f25630h;
            if (parent == view2) {
                ((RelativeLayout) view2).removeView(this.n);
            }
        }
    }

    public void z(boolean z, List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, list) == null) {
        }
    }
}
