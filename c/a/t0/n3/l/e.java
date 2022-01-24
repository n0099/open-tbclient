package c.a.t0.n3.l;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.s.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
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
/* loaded from: classes8.dex */
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
    public d f19805b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19806c;

    /* renamed from: d  reason: collision with root package name */
    public PopupDialog f19807d;

    /* renamed from: e  reason: collision with root package name */
    public j f19808e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19809f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19810g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19811h;

    /* renamed from: i  reason: collision with root package name */
    public SettingTextNormalImageView f19812i;

    /* renamed from: j  reason: collision with root package name */
    public SettingTextImageView f19813j;
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

    /* loaded from: classes8.dex */
    public class a implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.g f19814e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19815f;

        public a(e eVar, c.a.s0.s.s.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19815f = eVar;
            this.f19814e = gVar;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) && i2 == this.f19814e.e()) {
                this.f19815f.t();
                this.f19815f.f19805b.a(12);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements j.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.s0.s.s.j.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f19816e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19816e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f19816e.x) {
                    this.f19816e.f19805b.a(0);
                } else if (view == this.f19816e.f19813j) {
                    this.f19816e.f19805b.a(1);
                } else if (view == this.f19816e.k) {
                    this.f19816e.f19805b.a(15);
                } else if (view == this.f19816e.l) {
                    this.f19816e.f19805b.a(2);
                } else if (view == this.f19816e.m) {
                    this.f19816e.f19805b.a(3);
                } else if (view == this.f19816e.o) {
                    this.f19816e.f19805b.a(4);
                } else if (view == this.f19816e.p) {
                    this.f19816e.f19805b.a(9);
                } else if (view == this.f19816e.q) {
                    this.f19816e.f19805b.a(6);
                } else if (view == this.f19816e.r) {
                    this.f19816e.f19805b.a(7);
                } else if (view == this.f19816e.s) {
                    this.f19816e.f19805b.a(8);
                } else if (view == this.f19816e.t) {
                    this.f19816e.f19805b.a(5);
                } else if (view == this.f19816e.u) {
                    this.f19816e.f19805b.a(10);
                } else if (view == this.f19816e.f19812i) {
                    this.f19816e.f19805b.a(13);
                } else if (view == this.f19816e.n) {
                    this.f19816e.f19805b.a(16);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.f19805b = dVar;
        moreActivity.setContentView(c.a.t0.n3.f.more_activity);
        z();
        J();
    }

    public void A(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            if (str != null && str.length() > 0) {
                this.f19813j.displayImage();
                this.f19813j.setIcon(str, z);
                return;
            }
            SettingTextImageView settingTextImageView = this.f19813j;
            if (settingTextImageView != null) {
                settingTextImageView.hideImage();
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.o;
            if (tbSettingTextTipView != null) {
                tbSettingTextTipView.setTipViewColor(c.a.t0.n3.b.CAM_X0105);
                this.o.setTip(areNotificationsEnabled ? "" : this.a.getString(c.a.t0.n3.g.may_lose_important_msg));
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19813j.recycle();
            this.k.recycle();
            this.l.recycle();
            this.m.recycle();
            this.o.recycle();
            this.p.recycle();
            this.q.recycle();
            this.r.recycle();
            this.s.recycle();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SettingTextVersionView settingTextVersionView = this.q;
            if (settingTextVersionView != null) {
                settingTextVersionView.refresh();
            }
            TbSettingTextNewDotView tbSettingTextNewDotView = this.t;
            if (tbSettingTextNewDotView != null) {
                tbSettingTextNewDotView.refresh();
            }
        }
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || TbadkCoreApplication.getInst().getSkinType() == i2) {
            return;
        }
        if (i2 == 1) {
            onChangeSkinType(i2);
            TbadkCoreApplication.getInst().setSkinType(i2);
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "1").param("obj_source", "0"));
        } else if (i2 == 0 || i2 == 4) {
            onChangeSkinType(i2);
            TbadkCoreApplication.getInst().setSkinType(i2);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "0").param("obj_source", "0"));
        }
        BitmapHelper.clearCashBitmap();
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f19807d == null) {
                r();
            }
            this.f19807d.showDialog();
        }
    }

    public void G() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.u) == null || textView.getVisibility() == 0) {
            return;
        }
        this.u.setVisibility(0);
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.v, c.a.t0.n3.b.CAM_X0201);
            this.f19806c.onChangeSkinType(getPageContext(), i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.v);
            this.f19806c.onChangeSkinType(getPageContext(), i2);
            D();
            this.E.setBackgroundRes(SkinManager.getBitmap(c.a.t0.n3.d.bg_switch_open), SkinManager.getBitmap(c.a.t0.n3.d.bg_switch_close), SkinManager.getBitmap(c.a.t0.n3.d.btn_handle));
            this.G.setBackgroundRes(SkinManager.getBitmap(c.a.t0.n3.d.bg_switch_open), SkinManager.getBitmap(c.a.t0.n3.d.bg_switch_close), SkinManager.getBitmap(c.a.t0.n3.d.btn_handle));
            SkinManager.setBackgroundColor(this.w, c.a.t0.n3.b.CAM_X0201);
            this.f19812i.setLocalIcon(SkinManager.getResourceId(c.a.t0.n3.d.icon_mine_list_baidu));
            j jVar = this.f19808e;
            if (jVar != null) {
                jVar.i();
            }
            this.f19812i.switchSkinType(i2);
            this.f19813j.switchSkinType(i2);
            this.k.onChangeSkinType(i2);
            this.l.onChangeSkinType(i2);
            this.m.onChangeSkinType(i2);
            this.n.onChangeSkinType(i2);
            this.o.onChangeSkinType(i2);
            this.p.onChangeSkinType(i2);
            this.q.onChangeSkinType(i2);
            this.r.onChangeSkinType(i2);
            this.s.onChangeSkinType(i2);
            this.t.onChangeSkinType(i2);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.f19813j.setVisibility(0);
            } else {
                this.f19813j.setVisibility(8);
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.E.turnOn();
            } else {
                this.E.turnOff();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            H(i2);
            if (this.f19808e != null) {
                this.a.getLayoutMode().k(i2 == 1);
                this.a.getLayoutMode().j(this.f19808e.f());
            }
            if (i2 == 1) {
                this.E.turnOnNoCallback();
            } else {
                this.E.turnOffNoCallback();
            }
            c.a.s0.s.u.c.d(this.f19809f).v(c.a.t0.n3.b.CAM_X0105);
            c.a.s0.s.u.c.d(this.f19810g).v(c.a.t0.n3.b.CAM_X0105);
            c.a.s0.s.u.c.d(this.f19811h).v(c.a.t0.n3.b.CAM_X0109);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.u);
            d2.v(c.a.t0.n3.b.CAM_X0301);
            d2.f(c.a.t0.n3.b.CAM_X0205);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            j jVar = new j(getPageContext().getPageActivity());
            this.f19808e = jVar;
            jVar.q(getPageContext().getString(c.a.t0.n3.g.quit_account_tip));
            ArrayList arrayList = new ArrayList();
            c.a.s0.s.s.g gVar = new c.a.s0.s.s.g(getPageContext().getString(c.a.t0.n3.g.quite_current_account), this.f19808e);
            gVar.o(c.a.t0.n3.b.CAM_X0301);
            arrayList.add(gVar);
            this.a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(this.f19808e.f());
            a aVar = new a(this, gVar);
            b bVar = new b(this);
            this.f19808e.j(arrayList);
            this.f19808e.n(aVar);
            this.f19808e.m(bVar);
            PopupDialog popupDialog = new PopupDialog(this.mContext);
            this.f19807d = popupDialog;
            popupDialog.setCanceledOnTouchOutside(true);
            this.f19807d.setContentView(this.f19808e);
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            return (runTask == null || StringUtils.isNull((String) runTask.getData())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void t() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (popupDialog = this.f19807d) == null) {
            return;
        }
        popupDialog.dismiss();
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (s()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return c.a.s0.s.i0.b.k().h("key_is_dark_mode_notify_shown", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.E : (BdSwitchView) invokeV.objValue;
    }

    public final View.OnClickListener w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    public BdSwitchView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.G : (BdSwitchView) invokeV.objValue;
    }

    public final void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.f19812i.setOnClickListener(onClickListener);
            this.x.setOnClickListener(onClickListener);
            this.f19813j.setOnClickListener(onClickListener);
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

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            View.OnClickListener w = w();
            this.v = (RelativeLayout) this.a.findViewById(c.a.t0.n3.e.parent);
            this.w = this.a.findViewById(c.a.t0.n3.e.scroll);
            this.a.findViewById(c.a.t0.n3.e.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(c.a.t0.n3.e.view_navigation_bar);
            this.f19806c = navigationBar;
            this.x = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19806c.setCenterTextTitle(this.a.getPageContext().getString(c.a.t0.n3.g.setup));
            this.f19806c.showBottomLine();
            this.f19812i = (SettingTextNormalImageView) this.a.findViewById(c.a.t0.n3.e.accountSafeSetting);
            this.f19813j = (SettingTextImageView) this.a.findViewById(c.a.t0.n3.e.personInfo);
            this.k = (TbSettingTextTipView) this.a.findViewById(c.a.t0.n3.e.interest_label_setting);
            this.l = (TbSettingTextTipView) this.a.findViewById(c.a.t0.n3.e.accountManager);
            this.m = (TbSettingTextTipView) this.a.findViewById(c.a.t0.n3.e.browseSetting);
            this.n = (TbSettingTextTipView) this.a.findViewById(c.a.t0.n3.e.adSetting);
            this.o = (TbSettingTextTipView) this.a.findViewById(c.a.t0.n3.e.messageSetting);
            this.p = (TbSettingTextTipView) this.a.findViewById(c.a.t0.n3.e.secretSetting);
            this.q = (SettingTextVersionView) this.a.findViewById(c.a.t0.n3.e.versionInfo);
            this.r = (TbSettingTextTipView) this.a.findViewById(c.a.t0.n3.e.feedBack);
            this.s = (TbSettingTextTipView) this.a.findViewById(c.a.t0.n3.e.recommend);
            if (!TbadkCoreApplication.getInst().getIsAppOn()) {
                this.s.setVisibility(8);
            } else {
                this.s.setVisibility(0);
            }
            this.t = (TbSettingTextNewDotView) this.a.findViewById(c.a.t0.n3.e.systemhelpsetting);
            this.u = (TextView) this.a.findViewById(c.a.t0.n3.e.quit);
            if (!TbadkCoreApplication.isLogin()) {
                this.u.setVisibility(8);
            }
            this.D = (RelativeLayout) this.a.findViewById(c.a.t0.n3.e.eyeshield_mode);
            this.E = (BdSwitchView) this.a.findViewById(c.a.t0.n3.e.item_switch);
            n.b(this.a.getPageContext().getPageActivity(), this.E, 10, 10, 10, 10);
            this.F = (RelativeLayout) this.a.findViewById(c.a.t0.n3.e.follow_system_day_night_mode);
            this.f19809f = (TextView) this.a.findViewById(c.a.t0.n3.e.follow_system_item_name);
            this.f19810g = (TextView) this.a.findViewById(c.a.t0.n3.e.item_name);
            this.f19811h = (TextView) this.a.findViewById(c.a.t0.n3.e.follow_system_item_tip);
            this.G = (BdSwitchView) this.a.findViewById(c.a.t0.n3.e.follow_system_item_switch);
            n.b(this.a.getPageContext().getPageActivity(), this.G, 10, 10, 10, 10);
            this.y = this.a.findViewById(c.a.t0.n3.e.divide_view2);
            this.z = this.a.findViewById(c.a.t0.n3.e.divide_view1);
            this.A = this.a.findViewById(c.a.t0.n3.e.divide_view3);
            this.B = this.a.findViewById(c.a.t0.n3.e.divide_view4);
            this.C = this.a.findViewById(c.a.t0.n3.e.divide_view5);
            D();
            I();
            this.f19813j.hideImage();
            H(TbadkCoreApplication.getInst().getSkinType());
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            y(w);
            if (!s()) {
                this.m.setTip(this.a.getResources().getString(c.a.t0.n3.g.browsing_settings_tip_no_night));
                this.y.setVisibility(8);
                this.D.setVisibility(8);
            } else {
                this.y.setVisibility(0);
                this.D.setVisibility(0);
            }
            this.F.setVisibility(u() ? 0 : 8);
            if (c.a.s0.s.i0.b.k().h("key_is_follow_system_mode", false)) {
                this.G.turnOnNoCallback();
            } else {
                this.G.turnOffNoCallback();
            }
        }
    }
}
