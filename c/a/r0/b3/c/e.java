package c.a.r0.b3.c;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.s.i;
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
    public MoreActivity f16048a;

    /* renamed from: b  reason: collision with root package name */
    public d f16049b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16050c;

    /* renamed from: d  reason: collision with root package name */
    public PopupDialog f16051d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.s.i f16052e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16053f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16054g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16055h;

    /* renamed from: i  reason: collision with root package name */
    public SettingTextNormalImageView f16056i;

    /* renamed from: j  reason: collision with root package name */
    public SettingTextImageView f16057j;
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
        public final /* synthetic */ c.a.q0.s.s.f f16058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f16059f;

        public a(e eVar, c.a.q0.s.s.f fVar) {
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
            this.f16059f = eVar;
            this.f16058e = fVar;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) && i2 == this.f16058e.e()) {
                this.f16059f.u();
                this.f16059f.f16049b.a(12);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f16060a;

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
            this.f16060a = eVar;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16060a.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16061e;

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
            this.f16061e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f16061e.y) {
                    this.f16061e.f16049b.a(0);
                } else if (view == this.f16061e.f16057j) {
                    this.f16061e.f16049b.a(1);
                } else if (view == this.f16061e.k) {
                    this.f16061e.f16049b.a(15);
                } else if (view == this.f16061e.l) {
                    this.f16061e.f16049b.a(2);
                } else if (view == this.f16061e.m) {
                    this.f16061e.f16049b.a(3);
                } else if (view == this.f16061e.n) {
                    this.f16061e.f16049b.a(17);
                } else if (view == this.f16061e.p) {
                    this.f16061e.f16049b.a(4);
                } else if (view == this.f16061e.q) {
                    this.f16061e.f16049b.a(9);
                } else if (view == this.f16061e.r) {
                    this.f16061e.f16049b.a(6);
                } else if (view == this.f16061e.s) {
                    this.f16061e.f16049b.a(7);
                } else if (view == this.f16061e.t) {
                    this.f16061e.f16049b.a(8);
                } else if (view == this.f16061e.u) {
                    this.f16061e.f16049b.a(5);
                } else if (view == this.f16061e.v) {
                    this.f16061e.f16049b.a(10);
                } else if (view == this.f16061e.f16056i) {
                    this.f16061e.f16049b.a(13);
                } else if (view == this.f16061e.o) {
                    this.f16061e.f16049b.a(16);
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
        this.f16048a = moreActivity;
        this.f16049b = dVar;
        moreActivity.setContentView(R.layout.more_activity);
        A();
        Q();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View.OnClickListener x = x();
            this.w = (RelativeLayout) this.f16048a.findViewById(R.id.parent);
            this.x = this.f16048a.findViewById(R.id.scroll);
            this.f16048a.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.f16048a.findViewById(R.id.view_navigation_bar);
            this.f16050c = navigationBar;
            this.y = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16050c.setCenterTextTitle(this.f16048a.getPageContext().getString(R.string.setup));
            this.f16050c.showBottomLine();
            this.f16056i = (SettingTextNormalImageView) this.f16048a.findViewById(R.id.accountSafeSetting);
            this.f16057j = (SettingTextImageView) this.f16048a.findViewById(R.id.personInfo);
            this.k = (TbSettingTextTipView) this.f16048a.findViewById(R.id.interest_label_setting);
            this.l = (TbSettingTextTipView) this.f16048a.findViewById(R.id.accountManager);
            this.m = (TbSettingTextTipView) this.f16048a.findViewById(R.id.browseSetting);
            this.n = (TbSettingTextTipView) this.f16048a.findViewById(R.id.youngsterSetting);
            if (c.a.q0.g1.b.e.d()) {
                this.n.setTip(this.f16048a.getString(R.string.youngster_settings_tip_open));
            } else {
                this.n.setTip(this.f16048a.getString(R.string.youngster_settings_tip_close));
            }
            this.o = (TbSettingTextTipView) this.f16048a.findViewById(R.id.adSetting);
            this.p = (TbSettingTextTipView) this.f16048a.findViewById(R.id.messageSetting);
            this.q = (TbSettingTextTipView) this.f16048a.findViewById(R.id.secretSetting);
            this.r = (SettingTextVersionView) this.f16048a.findViewById(R.id.versionInfo);
            this.s = (TbSettingTextTipView) this.f16048a.findViewById(R.id.feedBack);
            this.t = (TbSettingTextTipView) this.f16048a.findViewById(R.id.recommend);
            if (!TbadkCoreApplication.getInst().getIsAppOn()) {
                this.t.setVisibility(8);
            } else {
                this.t.setVisibility(0);
            }
            this.u = (TbSettingTextNewDotView) this.f16048a.findViewById(R.id.systemhelpsetting);
            this.v = (TextView) this.f16048a.findViewById(R.id.quit);
            this.E = (RelativeLayout) this.f16048a.findViewById(R.id.eyeshield_mode);
            this.F = (BdSwitchView) this.f16048a.findViewById(R.id.item_switch);
            l.c(this.f16048a.getPageContext().getPageActivity(), this.F, 10, 10, 10, 10);
            this.G = (RelativeLayout) this.f16048a.findViewById(R.id.follow_system_day_night_mode);
            this.f16053f = (TextView) this.f16048a.findViewById(R.id.follow_system_item_name);
            this.f16054g = (TextView) this.f16048a.findViewById(R.id.item_name);
            this.f16055h = (TextView) this.f16048a.findViewById(R.id.follow_system_item_tip);
            this.H = (BdSwitchView) this.f16048a.findViewById(R.id.follow_system_item_switch);
            l.c(this.f16048a.getPageContext().getPageActivity(), this.H, 10, 10, 10, 10);
            this.z = this.f16048a.findViewById(R.id.divide_view2);
            this.A = this.f16048a.findViewById(R.id.divide_view1);
            this.B = this.f16048a.findViewById(R.id.divide_view3);
            this.C = this.f16048a.findViewById(R.id.divide_view4);
            this.D = this.f16048a.findViewById(R.id.divide_view5);
            K();
            P();
            this.f16057j.hideImage();
            O(TbadkCoreApplication.getInst().getSkinType());
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
            z(x);
            if (!t()) {
                this.m.setTip(this.f16048a.getResources().getString(R.string.browsing_settings_tip_no_night));
                this.z.setVisibility(8);
                this.E.setVisibility(8);
            } else {
                this.z.setVisibility(0);
                this.E.setVisibility(0);
            }
            this.G.setVisibility(v() ? 0 : 8);
            if (c.a.q0.s.d0.b.j().g("key_is_follow_system_mode", false)) {
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
                this.f16057j.displayImage();
                this.f16057j.setIcon(str, z);
                return;
            }
            SettingTextImageView settingTextImageView = this.f16057j;
            if (settingTextImageView != null) {
                settingTextImageView.hideImage();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f16048a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.p;
            if (tbSettingTextTipView != null) {
                tbSettingTextTipView.setTipViewColor(R.color.CAM_X0105);
                this.p.setTip(areNotificationsEnabled ? "" : this.f16048a.getString(R.string.may_lose_important_msg));
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16057j.recycle();
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
            if (this.f16051d == null) {
                s();
            }
            this.f16051d.showDialog();
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
            this.f16050c.onChangeSkinType(getPageContext(), i2);
            this.f16048a.getLayoutMode().k(i2 == 1);
            this.f16048a.getLayoutMode().j(this.w);
            this.f16050c.onChangeSkinType(getPageContext(), i2);
            K();
            this.F.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.H.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
            this.f16056i.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
            c.a.q0.s.s.i iVar = this.f16052e;
            if (iVar != null) {
                iVar.j();
            }
            this.f16056i.switchSkinType(i2);
            this.f16057j.switchSkinType(i2);
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
                this.f16057j.setVisibility(0);
            } else {
                this.f16057j.setVisibility(8);
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
            if (this.f16052e != null) {
                this.f16048a.getLayoutMode().k(i2 == 1);
                this.f16048a.getLayoutMode().j(this.f16052e.g());
            }
            if (i2 == 1) {
                this.F.turnOnNoCallback();
            } else {
                this.F.turnOffNoCallback();
            }
            c.a.q0.s.u.c.d(this.f16053f).w(R.color.CAM_X0105);
            c.a.q0.s.u.c.d(this.f16054g).w(R.color.CAM_X0105);
            c.a.q0.s.u.c.d(this.f16055h).w(R.color.CAM_X0109);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.v);
            d2.w(R.color.CAM_X0301);
            d2.f(R.color.CAM_X0205);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(getPageContext().getPageActivity());
            this.f16052e = iVar;
            iVar.q(getPageContext().getString(R.string.quit_account_tip));
            ArrayList arrayList = new ArrayList();
            c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(getPageContext().getString(R.string.quite_current_account), this.f16052e);
            fVar.o(R.color.CAM_X0301);
            arrayList.add(fVar);
            this.f16048a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f16048a.getLayoutMode().j(this.f16052e.g());
            a aVar = new a(this, fVar);
            b bVar = new b(this);
            this.f16052e.k(arrayList);
            this.f16052e.n(aVar);
            this.f16052e.m(bVar);
            PopupDialog popupDialog = new PopupDialog(this.mContext);
            this.f16051d = popupDialog;
            popupDialog.setCanceledOnTouchOutside(true);
            this.f16051d.setContentView(this.f16052e);
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (popupDialog = this.f16051d) == null) {
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
                return c.a.q0.s.d0.b.j().g("key_is_dark_mode_notify_shown", false);
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
            this.f16056i.setOnClickListener(onClickListener);
            this.y.setOnClickListener(onClickListener);
            this.f16057j.setOnClickListener(onClickListener);
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
            this.F.setOnSwitchStateChangeListener(this.f16048a);
            this.H.setOnSwitchStateChangeListener(this.f16048a);
        }
    }
}
