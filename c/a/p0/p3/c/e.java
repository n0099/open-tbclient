package c.a.p0.p3.c;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.t.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.more.SettingTextImageView;
import com.baidu.tieba.setting.more.SettingTextNormalImageView;
import com.baidu.tieba.setting.more.SettingTextVersionView;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class e extends c.a.d.a.d<MoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public View C;
    public RelativeLayout D;
    public BdSwitchView E;
    public RelativeLayout F;
    public BdSwitchView G;
    public MoreActivity a;

    /* renamed from: b  reason: collision with root package name */
    public d f16958b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16959c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.r.t.j f16960d;

    /* renamed from: e  reason: collision with root package name */
    public l f16961e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16962f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16963g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16964h;
    public SettingTextNormalImageView i;
    public SettingTextImageView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TbSettingTextTipView m;
    public TbSettingTextTipView n;
    public TbSettingTextTipView o;
    public TbSettingTextTipView p;
    public SettingTextVersionView q;
    public TbSettingTextTipView r;
    public TbSettingTextTipView s;
    public TbSettingTextNewDotView t;
    public TextView u;
    public RelativeLayout v;
    public View w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes2.dex */
    public class a implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f16965b;

        public a(e eVar, c.a.o0.r.t.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16965b = eVar;
            this.a = hVar;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) && i == this.a.f()) {
                this.f16965b.v();
                this.f16965b.f16958b.a(12);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.o0.r.t.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.a.x) {
                    this.a.f16958b.a(0);
                } else if (view == this.a.j) {
                    this.a.f16958b.a(1);
                } else if (view == this.a.k) {
                    this.a.f16958b.a(15);
                } else if (view == this.a.l) {
                    this.a.f16958b.a(2);
                } else if (view == this.a.m) {
                    this.a.f16958b.a(3);
                } else if (view == this.a.o) {
                    this.a.f16958b.a(4);
                } else if (view == this.a.p) {
                    this.a.f16958b.a(9);
                } else if (view == this.a.q) {
                    this.a.f16958b.a(6);
                } else if (view == this.a.r) {
                    this.a.f16958b.a(7);
                } else if (view == this.a.s) {
                    this.a.f16958b.a(8);
                } else if (view == this.a.t) {
                    this.a.f16958b.a(5);
                } else if (view == this.a.u) {
                    this.a.f16958b.a(10);
                } else if (view == this.a.i) {
                    this.a.f16958b.a(13);
                } else if (view == this.a.n) {
                    this.a.f16958b.a(16);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moreActivity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.a = moreActivity;
        this.f16958b = dVar;
        moreActivity.setContentView(R.layout.obfuscated_res_0x7f0d055b);
        B();
        M();
    }

    public final void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.i.setOnClickListener(onClickListener);
            this.x.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
            this.m.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.o.setOnClickListener(onClickListener);
            this.p.setOnClickListener(onClickListener);
            this.q.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            this.s.setOnClickListener(onClickListener);
            this.t.setOnClickListener(onClickListener);
            this.u.setOnClickListener(onClickListener);
            this.E.setOnSwitchStateChangeListener(this.a);
            this.G.setOnSwitchStateChangeListener(this.a);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View.OnClickListener y = y();
            this.v = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091647);
            this.w = this.a.findViewById(R.id.obfuscated_res_0x7f091c06);
            this.a.findViewById(R.id.obfuscated_res_0x7f090d2c).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f16959c = navigationBar;
            this.x = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16959c.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1103));
            this.f16959c.showBottomLine();
            this.i = (SettingTextNormalImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09004e);
            this.j = (SettingTextImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091770);
            this.k = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090f1c);
            this.l = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09004d);
            this.m = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0903f0);
            this.n = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090080);
            this.o = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0913fc);
            this.p = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091c64);
            this.q = (SettingTextVersionView) this.a.findViewById(R.id.obfuscated_res_0x7f0922f1);
            this.r = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09097e);
            this.s = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0919ec);
            if (!TbadkCoreApplication.getInst().getIsAppOn()) {
                this.s.setVisibility(8);
            } else {
                this.s.setVisibility(0);
            }
            this.t = (TbSettingTextNewDotView) this.a.findViewById(R.id.obfuscated_res_0x7f091e32);
            this.u = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0919a7);
            if (!TbadkCoreApplication.isLogin()) {
                this.u.setVisibility(8);
            }
            this.D = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090949);
            this.E = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f090fa4);
            n.b(this.a.getPageContext().getPageActivity(), this.E, 10, 10, 10, 10);
            this.F = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909fd);
            this.f16962f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909fe);
            this.f16963g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090f87);
            this.f16964h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a00);
            this.G = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f0909ff);
            n.b(this.a.getPageContext().getPageActivity(), this.G, 10, 10, 10, 10);
            this.y = this.a.findViewById(R.id.obfuscated_res_0x7f0907dd);
            this.z = this.a.findViewById(R.id.obfuscated_res_0x7f0907dc);
            this.A = this.a.findViewById(R.id.obfuscated_res_0x7f0907de);
            this.B = this.a.findViewById(R.id.obfuscated_res_0x7f0907df);
            this.C = this.a.findViewById(R.id.obfuscated_res_0x7f0907e0);
            F();
            L();
            this.j.b();
            K(TbadkCoreApplication.getInst().getSkinType());
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            A(y);
            if (!u()) {
                this.m.setTip(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0336));
                this.y.setVisibility(8);
                this.D.setVisibility(8);
            } else {
                this.y.setVisibility(0);
                this.D.setVisibility(0);
            }
            this.F.setVisibility(w() ? 0 : 8);
            if (c.a.o0.r.j0.b.k().h("key_is_follow_system_mode", false)) {
                this.G.l();
            } else {
                this.G.h();
            }
        }
    }

    public void C(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (str != null && str.length() > 0) {
                this.j.a();
                this.j.setIcon(str, z);
                return;
            }
            SettingTextImageView settingTextImageView = this.j;
            if (settingTextImageView != null) {
                settingTextImageView.b();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.o;
            if (tbSettingTextTipView != null) {
                tbSettingTextTipView.setTipViewColor(R.color.CAM_X0105);
                this.o.setTip(areNotificationsEnabled ? "" : this.a.getString(R.string.obfuscated_res_0x7f0f0a95));
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j.e();
            this.k.g();
            this.l.g();
            this.m.g();
            this.o.g();
            this.p.g();
            this.q.g();
            this.r.g();
            this.s.g();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SettingTextVersionView settingTextVersionView = this.q;
            if (settingTextVersionView != null) {
                settingTextVersionView.i();
            }
            TbSettingTextNewDotView tbSettingTextNewDotView = this.t;
            if (tbSettingTextNewDotView != null) {
                tbSettingTextNewDotView.i();
            }
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || TbadkCoreApplication.getInst().getSkinType() == i) {
            return;
        }
        if (i == 1) {
            onChangeSkinType(i);
            TbadkCoreApplication.getInst().setSkinType(i);
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "1").param("obj_source", "0"));
        } else if (i == 0 || i == 4) {
            onChangeSkinType(i);
            TbadkCoreApplication.getInst().setSkinType(i);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "0").param("obj_source", "0"));
        }
        BitmapHelper.clearCashBitmap();
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f16960d == null) {
                t();
            }
            this.f16960d.m();
        }
    }

    public void I() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (textView = this.u) == null || textView.getVisibility() == 0) {
            return;
        }
        this.u.setVisibility(0);
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
            this.f16959c.onChangeSkinType(getPageContext(), i);
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.v);
            this.f16959c.onChangeSkinType(getPageContext(), i);
            F();
            this.E.setBackgroundRes(SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e8), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e7), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f080398));
            this.G.setBackgroundRes(SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e8), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e7), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f080398));
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
            this.i.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
            l lVar = this.f16961e;
            if (lVar != null) {
                lVar.i();
            }
            this.i.c(i);
            this.j.f(i);
            this.k.f(i);
            this.l.f(i);
            this.m.f(i);
            this.n.f(i);
            this.o.f(i);
            this.p.f(i);
            this.q.f(i);
            this.r.f(i);
            this.s.f(i);
            this.t.f(i);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.E.j();
            } else {
                this.E.f();
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            K(i);
            if (this.f16961e != null) {
                this.a.getLayoutMode().k(i == 1);
                this.a.getLayoutMode().j(this.f16961e.f());
            }
            if (i == 1) {
                this.E.l();
            } else {
                this.E.h();
            }
            c.a.o0.r.v.c.d(this.f16962f).v(R.color.CAM_X0105);
            c.a.o0.r.v.c.d(this.f16963g).v(R.color.CAM_X0105);
            c.a.o0.r.v.c.d(this.f16964h).v(R.color.CAM_X0109);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.u);
            d2.v(R.color.CAM_X0301);
            d2.f(R.color.CAM_X0205);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            l lVar = new l(getPageContext().getPageActivity());
            this.f16961e = lVar;
            lVar.q(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f23));
            ArrayList arrayList = new ArrayList();
            c.a.o0.r.t.h hVar = new c.a.o0.r.t.h(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f25), this.f16961e);
            hVar.q(R.color.CAM_X0301);
            arrayList.add(hVar);
            this.a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(this.f16961e.f());
            a aVar = new a(this, hVar);
            b bVar = new b(this);
            this.f16961e.j(arrayList);
            this.f16961e.n(aVar);
            this.f16961e.m(bVar);
            c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.mContext);
            this.f16960d = jVar;
            jVar.setCanceledOnTouchOutside(true);
            this.f16960d.i(this.f16961e);
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            return (runTask == null || StringUtils.isNull((String) runTask.getData())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        c.a.o0.r.t.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (jVar = this.f16960d) == null) {
            return;
        }
        jVar.dismiss();
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (u()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return c.a.o0.r.j0.b.k().h("key_is_dark_mode_notify_shown", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.E : (BdSwitchView) invokeV.objValue;
    }

    public final View.OnClickListener y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    public BdSwitchView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.G : (BdSwitchView) invokeV.objValue;
    }
}
