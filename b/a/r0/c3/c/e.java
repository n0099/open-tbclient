package b.a.r0.c3.c;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.s.i;
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
/* loaded from: classes4.dex */
public class e extends b.a.e.a.d<MoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public View C;
    public RelativeLayout D;
    public BdSwitchView E;
    public RelativeLayout F;
    public BdSwitchView G;

    /* renamed from: a  reason: collision with root package name */
    public MoreActivity f15246a;

    /* renamed from: b  reason: collision with root package name */
    public d f15247b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15248c;

    /* renamed from: d  reason: collision with root package name */
    public PopupDialog f15249d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.s.i f15250e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15251f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15252g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15253h;

    /* renamed from: i  reason: collision with root package name */
    public SettingTextNormalImageView f15254i;
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

    /* loaded from: classes4.dex */
    public class a implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.f f15255e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f15256f;

        public a(e eVar, b.a.q0.s.s.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15256f = eVar;
            this.f15255e = fVar;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) && i2 == this.f15255e.e()) {
                this.f15256f.t();
                this.f15256f.f15247b.a(12);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15257a;

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
            this.f15257a = eVar;
        }

        @Override // b.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15257a.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15258e;

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
            this.f15258e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15258e.x) {
                    this.f15258e.f15247b.a(0);
                } else if (view == this.f15258e.j) {
                    this.f15258e.f15247b.a(1);
                } else if (view == this.f15258e.k) {
                    this.f15258e.f15247b.a(15);
                } else if (view == this.f15258e.l) {
                    this.f15258e.f15247b.a(2);
                } else if (view == this.f15258e.m) {
                    this.f15258e.f15247b.a(3);
                } else if (view == this.f15258e.o) {
                    this.f15258e.f15247b.a(4);
                } else if (view == this.f15258e.p) {
                    this.f15258e.f15247b.a(9);
                } else if (view == this.f15258e.q) {
                    this.f15258e.f15247b.a(6);
                } else if (view == this.f15258e.r) {
                    this.f15258e.f15247b.a(7);
                } else if (view == this.f15258e.s) {
                    this.f15258e.f15247b.a(8);
                } else if (view == this.f15258e.t) {
                    this.f15258e.f15247b.a(5);
                } else if (view == this.f15258e.u) {
                    this.f15258e.f15247b.a(10);
                } else if (view == this.f15258e.f15254i) {
                    this.f15258e.f15247b.a(13);
                } else if (view == this.f15258e.n) {
                    this.f15258e.f15247b.a(16);
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
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
        this.f15246a = moreActivity;
        this.f15247b = dVar;
        moreActivity.setContentView(R.layout.more_activity);
        z();
        P();
    }

    public void A(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            if (str != null && str.length() > 0) {
                this.j.displayImage();
                this.j.setIcon(str, z);
                return;
            }
            SettingTextImageView settingTextImageView = this.j;
            if (settingTextImageView != null) {
                settingTextImageView.hideImage();
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f15246a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.o;
            if (tbSettingTextTipView != null) {
                tbSettingTextTipView.setTipViewColor(R.color.CAM_X0105);
                this.o.setTip(areNotificationsEnabled ? "" : this.f15246a.getString(R.string.may_lose_important_msg));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j.recycle();
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

    public void I() {
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

    public void J(int i2) {
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

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f15249d == null) {
                r();
            }
            this.f15249d.showDialog();
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
            this.f15248c.onChangeSkinType(getPageContext(), i2);
            this.f15246a.getLayoutMode().k(i2 == 1);
            this.f15246a.getLayoutMode().j(this.v);
            this.f15248c.onChangeSkinType(getPageContext(), i2);
            I();
            this.E.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.G.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
            this.f15254i.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
            b.a.q0.s.s.i iVar = this.f15250e;
            if (iVar != null) {
                iVar.i();
            }
            this.f15254i.switchSkinType(i2);
            this.j.switchSkinType(i2);
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

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.E.turnOn();
            } else {
                this.E.turnOff();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            M(i2);
            if (this.f15250e != null) {
                this.f15246a.getLayoutMode().k(i2 == 1);
                this.f15246a.getLayoutMode().j(this.f15250e.f());
            }
            if (i2 == 1) {
                this.E.turnOnNoCallback();
            } else {
                this.E.turnOffNoCallback();
            }
            b.a.q0.s.u.c.d(this.f15251f).v(R.color.CAM_X0105);
            b.a.q0.s.u.c.d(this.f15252g).v(R.color.CAM_X0105);
            b.a.q0.s.u.c.d(this.f15253h).v(R.color.CAM_X0109);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.u);
            d2.v(R.color.CAM_X0301);
            d2.f(R.color.CAM_X0205);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(getPageContext().getPageActivity());
            this.f15250e = iVar;
            iVar.p(getPageContext().getString(R.string.quit_account_tip));
            ArrayList arrayList = new ArrayList();
            b.a.q0.s.s.f fVar = new b.a.q0.s.s.f(getPageContext().getString(R.string.quite_current_account), this.f15250e);
            fVar.o(R.color.CAM_X0301);
            arrayList.add(fVar);
            this.f15246a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f15246a.getLayoutMode().j(this.f15250e.f());
            a aVar = new a(this, fVar);
            b bVar = new b(this);
            this.f15250e.j(arrayList);
            this.f15250e.m(aVar);
            this.f15250e.l(bVar);
            PopupDialog popupDialog = new PopupDialog(this.mContext);
            this.f15249d = popupDialog;
            popupDialog.setCanceledOnTouchOutside(true);
            this.f15249d.setContentView(this.f15250e);
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            return (runTask == null || StringUtils.isNull((String) runTask.getData())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void t() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (popupDialog = this.f15249d) == null) {
            return;
        }
        popupDialog.dismiss();
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (s()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return b.a.q0.s.e0.b.j().g("key_is_dark_mode_notify_shown", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.E : (BdSwitchView) invokeV.objValue;
    }

    public final View.OnClickListener w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    public BdSwitchView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.G : (BdSwitchView) invokeV.objValue;
    }

    public final void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.f15254i.setOnClickListener(onClickListener);
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
            this.E.setOnSwitchStateChangeListener(this.f15246a);
            this.G.setOnSwitchStateChangeListener(this.f15246a);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            View.OnClickListener w = w();
            this.v = (RelativeLayout) this.f15246a.findViewById(R.id.parent);
            this.w = this.f15246a.findViewById(R.id.scroll);
            this.f15246a.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.f15246a.findViewById(R.id.view_navigation_bar);
            this.f15248c = navigationBar;
            this.x = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15248c.setCenterTextTitle(this.f15246a.getPageContext().getString(R.string.setup));
            this.f15248c.showBottomLine();
            this.f15254i = (SettingTextNormalImageView) this.f15246a.findViewById(R.id.accountSafeSetting);
            this.j = (SettingTextImageView) this.f15246a.findViewById(R.id.personInfo);
            this.k = (TbSettingTextTipView) this.f15246a.findViewById(R.id.interest_label_setting);
            this.l = (TbSettingTextTipView) this.f15246a.findViewById(R.id.accountManager);
            this.m = (TbSettingTextTipView) this.f15246a.findViewById(R.id.browseSetting);
            this.n = (TbSettingTextTipView) this.f15246a.findViewById(R.id.adSetting);
            this.o = (TbSettingTextTipView) this.f15246a.findViewById(R.id.messageSetting);
            this.p = (TbSettingTextTipView) this.f15246a.findViewById(R.id.secretSetting);
            this.q = (SettingTextVersionView) this.f15246a.findViewById(R.id.versionInfo);
            this.r = (TbSettingTextTipView) this.f15246a.findViewById(R.id.feedBack);
            this.s = (TbSettingTextTipView) this.f15246a.findViewById(R.id.recommend);
            if (!TbadkCoreApplication.getInst().getIsAppOn()) {
                this.s.setVisibility(8);
            } else {
                this.s.setVisibility(0);
            }
            this.t = (TbSettingTextNewDotView) this.f15246a.findViewById(R.id.systemhelpsetting);
            this.u = (TextView) this.f15246a.findViewById(R.id.quit);
            this.D = (RelativeLayout) this.f15246a.findViewById(R.id.eyeshield_mode);
            this.E = (BdSwitchView) this.f15246a.findViewById(R.id.item_switch);
            l.c(this.f15246a.getPageContext().getPageActivity(), this.E, 10, 10, 10, 10);
            this.F = (RelativeLayout) this.f15246a.findViewById(R.id.follow_system_day_night_mode);
            this.f15251f = (TextView) this.f15246a.findViewById(R.id.follow_system_item_name);
            this.f15252g = (TextView) this.f15246a.findViewById(R.id.item_name);
            this.f15253h = (TextView) this.f15246a.findViewById(R.id.follow_system_item_tip);
            this.G = (BdSwitchView) this.f15246a.findViewById(R.id.follow_system_item_switch);
            l.c(this.f15246a.getPageContext().getPageActivity(), this.G, 10, 10, 10, 10);
            this.y = this.f15246a.findViewById(R.id.divide_view2);
            this.z = this.f15246a.findViewById(R.id.divide_view1);
            this.A = this.f15246a.findViewById(R.id.divide_view3);
            this.B = this.f15246a.findViewById(R.id.divide_view4);
            this.C = this.f15246a.findViewById(R.id.divide_view5);
            I();
            O();
            this.j.hideImage();
            M(TbadkCoreApplication.getInst().getSkinType());
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            y(w);
            if (!s()) {
                this.m.setTip(this.f15246a.getResources().getString(R.string.browsing_settings_tip_no_night));
                this.y.setVisibility(8);
                this.D.setVisibility(8);
            } else {
                this.y.setVisibility(0);
                this.D.setVisibility(0);
            }
            this.F.setVisibility(u() ? 0 : 8);
            if (b.a.q0.s.e0.b.j().g("key_is_follow_system_mode", false)) {
                this.G.turnOnNoCallback();
            } else {
                this.G.turnOffNoCallback();
            }
        }
    }
}
