package c.a.p0.a3.c;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.o0.s.s.i;
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
/* loaded from: classes3.dex */
public class e extends c.a.e.a.d<MoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public View C;
    public View D;
    public RelativeLayout E;
    public BdSwitchView F;
    public RelativeLayout G;
    public BdSwitchView H;

    /* renamed from: a  reason: collision with root package name */
    public MoreActivity f15229a;

    /* renamed from: b  reason: collision with root package name */
    public d f15230b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15231c;

    /* renamed from: d  reason: collision with root package name */
    public PopupDialog f15232d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.s.s.i f15233e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15234f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15235g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15236h;

    /* renamed from: i  reason: collision with root package name */
    public SettingTextNormalImageView f15237i;

    /* renamed from: j  reason: collision with root package name */
    public SettingTextImageView f15238j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TbSettingTextTipView m;
    public TbSettingTextTipView n;
    public TbSettingTextTipView o;
    public TbSettingTextTipView p;
    public TbSettingTextTipView q;
    public SettingTextVersionView r;
    public TbSettingTextTipView s;
    public TbSettingTextTipView t;
    public TbSettingTextNewDotView u;
    public TextView v;
    public RelativeLayout w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes3.dex */
    public class a implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.s.s.f f15239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f15240f;

        public a(e eVar, c.a.o0.s.s.f fVar) {
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
            this.f15240f = eVar;
            this.f15239e = fVar;
        }

        @Override // c.a.o0.s.s.i.e
        public void onItemClick(c.a.o0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) && i2 == this.f15239e.e()) {
                this.f15240f.u();
                this.f15240f.f15230b.a(12);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15241a;

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
            this.f15241a = eVar;
        }

        @Override // c.a.o0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15241a.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15242e;

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
            this.f15242e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15242e.y) {
                    this.f15242e.f15230b.a(0);
                } else if (view == this.f15242e.f15238j) {
                    this.f15242e.f15230b.a(1);
                } else if (view == this.f15242e.k) {
                    this.f15242e.f15230b.a(15);
                } else if (view == this.f15242e.l) {
                    this.f15242e.f15230b.a(2);
                } else if (view == this.f15242e.m) {
                    this.f15242e.f15230b.a(3);
                } else if (view == this.f15242e.n) {
                    this.f15242e.f15230b.a(17);
                } else if (view == this.f15242e.p) {
                    this.f15242e.f15230b.a(4);
                } else if (view == this.f15242e.q) {
                    this.f15242e.f15230b.a(9);
                } else if (view == this.f15242e.r) {
                    this.f15242e.f15230b.a(6);
                } else if (view == this.f15242e.s) {
                    this.f15242e.f15230b.a(7);
                } else if (view == this.f15242e.t) {
                    this.f15242e.f15230b.a(8);
                } else if (view == this.f15242e.u) {
                    this.f15242e.f15230b.a(5);
                } else if (view == this.f15242e.v) {
                    this.f15242e.f15230b.a(10);
                } else if (view == this.f15242e.f15237i) {
                    this.f15242e.f15230b.a(13);
                } else if (view == this.f15242e.o) {
                    this.f15242e.f15230b.a(16);
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.f15229a = moreActivity;
        this.f15230b = dVar;
        moreActivity.setContentView(R.layout.more_activity);
        A();
        Q();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View.OnClickListener x = x();
            this.w = (RelativeLayout) this.f15229a.findViewById(R.id.parent);
            this.x = this.f15229a.findViewById(R.id.scroll);
            this.f15229a.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.f15229a.findViewById(R.id.view_navigation_bar);
            this.f15231c = navigationBar;
            this.y = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15231c.setCenterTextTitle(this.f15229a.getPageContext().getString(R.string.setup));
            this.f15231c.showBottomLine();
            this.f15237i = (SettingTextNormalImageView) this.f15229a.findViewById(R.id.accountSafeSetting);
            this.f15238j = (SettingTextImageView) this.f15229a.findViewById(R.id.personInfo);
            this.k = (TbSettingTextTipView) this.f15229a.findViewById(R.id.interest_label_setting);
            this.l = (TbSettingTextTipView) this.f15229a.findViewById(R.id.accountManager);
            this.m = (TbSettingTextTipView) this.f15229a.findViewById(R.id.browseSetting);
            this.n = (TbSettingTextTipView) this.f15229a.findViewById(R.id.youngsterSetting);
            if (c.a.o0.e1.b.e.d()) {
                this.n.setTip(this.f15229a.getString(R.string.youngster_settings_tip_open));
            } else {
                this.n.setTip(this.f15229a.getString(R.string.youngster_settings_tip_close));
            }
            this.o = (TbSettingTextTipView) this.f15229a.findViewById(R.id.adSetting);
            this.p = (TbSettingTextTipView) this.f15229a.findViewById(R.id.messageSetting);
            this.q = (TbSettingTextTipView) this.f15229a.findViewById(R.id.secretSetting);
            this.r = (SettingTextVersionView) this.f15229a.findViewById(R.id.versionInfo);
            this.s = (TbSettingTextTipView) this.f15229a.findViewById(R.id.feedBack);
            this.t = (TbSettingTextTipView) this.f15229a.findViewById(R.id.recommend);
            if (!TbadkCoreApplication.getInst().getIsAppOn()) {
                this.t.setVisibility(8);
            } else {
                this.t.setVisibility(0);
            }
            this.u = (TbSettingTextNewDotView) this.f15229a.findViewById(R.id.systemhelpsetting);
            this.v = (TextView) this.f15229a.findViewById(R.id.quit);
            this.E = (RelativeLayout) this.f15229a.findViewById(R.id.eyeshield_mode);
            this.F = (BdSwitchView) this.f15229a.findViewById(R.id.item_switch);
            l.c(this.f15229a.getPageContext().getPageActivity(), this.F, 10, 10, 10, 10);
            this.G = (RelativeLayout) this.f15229a.findViewById(R.id.follow_system_day_night_mode);
            this.f15234f = (TextView) this.f15229a.findViewById(R.id.follow_system_item_name);
            this.f15235g = (TextView) this.f15229a.findViewById(R.id.item_name);
            this.f15236h = (TextView) this.f15229a.findViewById(R.id.follow_system_item_tip);
            this.H = (BdSwitchView) this.f15229a.findViewById(R.id.follow_system_item_switch);
            l.c(this.f15229a.getPageContext().getPageActivity(), this.H, 10, 10, 10, 10);
            this.z = this.f15229a.findViewById(R.id.divide_view2);
            this.A = this.f15229a.findViewById(R.id.divide_view1);
            this.B = this.f15229a.findViewById(R.id.divide_view3);
            this.C = this.f15229a.findViewById(R.id.divide_view4);
            this.D = this.f15229a.findViewById(R.id.divide_view5);
            K();
            P();
            this.f15238j.hideImage();
            O(TbadkCoreApplication.getInst().getSkinType());
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
            z(x);
            if (!t()) {
                this.m.setTip(this.f15229a.getResources().getString(R.string.browsing_settings_tip_no_night));
                this.z.setVisibility(8);
                this.E.setVisibility(8);
            } else {
                this.z.setVisibility(0);
                this.E.setVisibility(0);
            }
            this.G.setVisibility(v() ? 0 : 8);
            if (c.a.o0.s.d0.b.j().g("key_is_follow_system_mode", false)) {
                this.H.turnOnNoCallback();
            } else {
                this.H.turnOffNoCallback();
            }
        }
    }

    public void B(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            if (str != null && str.length() > 0) {
                this.f15238j.displayImage();
                this.f15238j.setIcon(str, z);
                return;
            }
            SettingTextImageView settingTextImageView = this.f15238j;
            if (settingTextImageView != null) {
                settingTextImageView.hideImage();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f15229a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.p;
            if (tbSettingTextTipView != null) {
                tbSettingTextTipView.setTipViewColor(R.color.CAM_X0105);
                this.p.setTip(areNotificationsEnabled ? "" : this.f15229a.getString(R.string.may_lose_important_msg));
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15238j.recycle();
            this.k.recycle();
            this.l.recycle();
            this.m.recycle();
            this.n.recycle();
            this.p.recycle();
            this.q.recycle();
            this.r.recycle();
            this.s.recycle();
            this.t.recycle();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SettingTextVersionView settingTextVersionView = this.r;
            if (settingTextVersionView != null) {
                settingTextVersionView.refresh();
            }
            TbSettingTextNewDotView tbSettingTextNewDotView = this.u;
            if (tbSettingTextNewDotView != null) {
                tbSettingTextNewDotView.refresh();
            }
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || TbadkCoreApplication.getInst().getSkinType() == i2) {
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

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f15232d == null) {
                s();
            }
            this.f15232d.showDialog();
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
            this.f15231c.onChangeSkinType(getPageContext(), i2);
            this.f15229a.getLayoutMode().k(i2 == 1);
            this.f15229a.getLayoutMode().j(this.w);
            this.f15231c.onChangeSkinType(getPageContext(), i2);
            K();
            this.F.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.H.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
            this.f15237i.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
            c.a.o0.s.s.i iVar = this.f15233e;
            if (iVar != null) {
                iVar.j();
            }
            this.f15237i.switchSkinType(i2);
            this.f15238j.switchSkinType(i2);
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
            this.u.onChangeSkinType(i2);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.f15238j.setVisibility(0);
            } else {
                this.f15238j.setVisibility(8);
            }
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.F.turnOn();
            } else {
                this.F.turnOff();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            O(i2);
            if (this.f15233e != null) {
                this.f15229a.getLayoutMode().k(i2 == 1);
                this.f15229a.getLayoutMode().j(this.f15233e.g());
            }
            if (i2 == 1) {
                this.F.turnOnNoCallback();
            } else {
                this.F.turnOffNoCallback();
            }
            c.a.o0.s.u.c.d(this.f15234f).t(R.color.CAM_X0105);
            c.a.o0.s.u.c.d(this.f15235g).t(R.color.CAM_X0105);
            c.a.o0.s.u.c.d(this.f15236h).t(R.color.CAM_X0109);
            c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(this.v);
            d2.t(R.color.CAM_X0301);
            d2.f(R.color.CAM_X0205);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.o0.s.s.i iVar = new c.a.o0.s.s.i(getPageContext().getPageActivity());
            this.f15233e = iVar;
            iVar.q(getPageContext().getString(R.string.quit_account_tip));
            ArrayList arrayList = new ArrayList();
            c.a.o0.s.s.f fVar = new c.a.o0.s.s.f(getPageContext().getString(R.string.quite_current_account), this.f15233e);
            fVar.n(R.color.CAM_X0301);
            arrayList.add(fVar);
            this.f15229a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f15229a.getLayoutMode().j(this.f15233e.g());
            a aVar = new a(this, fVar);
            b bVar = new b(this);
            this.f15233e.k(arrayList);
            this.f15233e.n(aVar);
            this.f15233e.m(bVar);
            PopupDialog popupDialog = new PopupDialog(this.mContext);
            this.f15232d = popupDialog;
            popupDialog.setCanceledOnTouchOutside(true);
            this.f15232d.setContentView(this.f15233e);
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            return (runTask == null || StringUtils.isNull((String) runTask.getData())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (popupDialog = this.f15232d) == null) {
            return;
        }
        popupDialog.dismiss();
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (t()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return c.a.o0.s.d0.b.j().g("key_is_dark_mode_notify_shown", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.F : (BdSwitchView) invokeV.objValue;
    }

    public final View.OnClickListener x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    public BdSwitchView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.H : (BdSwitchView) invokeV.objValue;
    }

    public final void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.f15237i.setOnClickListener(onClickListener);
            this.y.setOnClickListener(onClickListener);
            this.f15238j.setOnClickListener(onClickListener);
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
            this.v.setOnClickListener(onClickListener);
            this.F.setOnSwitchStateChangeListener(this.f15229a);
            this.H.setOnSwitchStateChangeListener(this.f15229a);
        }
    }
}
