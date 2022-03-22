package c.a.p0.p3.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.more.MsgRemindActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class g extends c.a.d.a.d<MsgRemindActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public boolean B;
    public MsgRemindActivity C;
    public TbSettingTextTipView D;
    public View E;
    public BdSwitchView F;
    public View G;
    public MsgSettingItemView H;
    public MsgSettingItemView I;
    public MsgSettingItemView J;
    public MsgSettingItemView K;
    public TextView L;
    public TextView M;
    public MsgSettingItemView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f16973b;

    /* renamed from: c  reason: collision with root package name */
    public MsgSettingItemView f16974c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f16975d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f16976e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f16977f;

    /* renamed from: g  reason: collision with root package name */
    public MsgSettingItemView f16978g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f16979h;
    public MsgSettingItemView i;
    public MsgSettingItemView j;
    public MsgSettingItemView k;
    public MsgSettingItemView l;
    public MsgSettingItemView m;
    public LinearLayout n;
    public TextView o;
    public MsgSettingItemView p;
    public LinearLayout q;
    public TextView r;
    public LinearLayout s;
    public NavigationBar t;
    public View u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;
    public TextView y;
    public LinearLayout z;

    /* loaded from: classes2.dex */
    public class a implements OfficialAccountPushModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, arrayList, i, str) == null) {
                Iterator<OfficialAccountPushInfo> it = arrayList.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    OfficialAccountPushInfo next = it.next();
                    if (next.uid == 1501754229) {
                        if (next.is_on == 1) {
                            z = true;
                        }
                    }
                }
                if (c.a.o0.s.d.d.d().l() != z) {
                    this.a.K.setSwitchStateNoCallback(z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgRemindActivity};
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
        this.s = null;
        this.t = null;
        this.B = true;
        this.C = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.obfuscated_res_0x7f0d056a);
    }

    public BdSwitchView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16974c.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public BdSwitchView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.I.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16975d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void I(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, msgRemindActivity) == null) {
            T(msgRemindActivity);
            N();
            P();
            S();
            Q();
            O();
            M(msgRemindActivity);
            j();
        }
    }

    public final void K() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (msgSettingItemView = this.J) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(c.a.o0.s.d.d.d().m());
    }

    public final void L() {
        MsgSettingItemView msgSettingItemView;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (msgSettingItemView = this.H) == null || this.I == null || (i = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i != 1) {
            msgSettingItemView.getSwitchView().h();
            this.H.setLineVisibility(false);
            this.I.setVisibility(8);
            this.I.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().l();
        this.H.setLineVisibility(true);
        this.I.getSwitchView().h();
    }

    public final void M(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, msgRemindActivity) == null) {
            this.u.setOnClickListener(msgRemindActivity);
            this.f16974c.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f16976e.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f16975d.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f16977f.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f16978g.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f16979h.setOnSwitchStateChangeListener(msgRemindActivity);
            this.i.setOnSwitchStateChangeListener(msgRemindActivity);
            this.j.setOnSwitchStateChangeListener(msgRemindActivity);
            this.k.setOnSwitchStateChangeListener(msgRemindActivity);
            this.l.setOnSwitchStateChangeListener(msgRemindActivity);
            this.m.setOnSwitchStateChangeListener(msgRemindActivity);
            this.n.setOnClickListener(msgRemindActivity);
            this.p.setOnSwitchStateChangeListener(msgRemindActivity);
            this.q.setOnClickListener(msgRemindActivity);
            this.x.setOnClickListener(msgRemindActivity);
            this.z.setOnClickListener(msgRemindActivity);
            this.D.setOnClickListener(msgRemindActivity);
            this.t.getCenterText().setOnClickListener(msgRemindActivity);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f16974c.setSwitchStateNoCallback(c.a.o0.s.d.d.d().v());
            this.f16975d.setSwitchStateNoCallback(c.a.o0.s.d.d.d().y());
            this.f16976e.setSwitchStateNoCallback(c.a.o0.s.d.d.d().q());
            this.f16977f.setSwitchStateNoCallback(c.a.o0.s.d.d.d().t());
            this.f16978g.setSwitchStateNoCallback(c.a.o0.s.d.d.d().r());
            this.f16979h.setSwitchStateNoCallback(c.a.o0.s.d.d.d().p());
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (c.a.o0.s.d.d.d().z()) {
                this.p.g();
                this.q.setVisibility(0);
                f0();
                return;
            }
            this.p.e();
            this.q.setVisibility(8);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (c.a.o0.s.d.d.d().A()) {
                this.m.f();
                this.n.setVisibility(0);
                this.m.setLineVisibility(true);
                g0();
                return;
            }
            this.m.d();
            this.m.setLineVisibility(false);
            this.n.setVisibility(8);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (c.a.o0.s.d.d.d().w()) {
                this.j.g();
            } else {
                this.j.e();
            }
            if (c.a.o0.s.d.d.d().x()) {
                this.k.g();
            } else {
                this.k.e();
            }
            if (c.a.o0.s.d.d.d().s()) {
                this.l.g();
            } else {
                this.l.e();
            }
        }
    }

    public void T(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, msgRemindActivity) == null) {
            this.s = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091647);
            NavigationBar navigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.t = navigationBar;
            navigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ad9));
            this.t.showBottomLine();
            this.u = this.t.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.v = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f090aba);
            this.w = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0902f2);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0919d4);
            this.a = msgSettingItemView;
            msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f0f32);
            this.a.setLineVisibility(false);
            this.f16973b = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0919d3);
            MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091a59);
            this.f16974c = msgSettingItemView2;
            msgSettingItemView2.setText(R.string.obfuscated_res_0x7f0f0f88);
            MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0924ce);
            this.f16975d = msgSettingItemView3;
            msgSettingItemView3.setVisibility(0);
            this.f16975d.setText(R.string.obfuscated_res_0x7f0f0087);
            MsgSettingItemView msgSettingItemView4 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0902b3);
            this.f16976e = msgSettingItemView4;
            msgSettingItemView4.setText(R.string.obfuscated_res_0x7f0f0ab4);
            MsgSettingItemView msgSettingItemView5 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091546);
            this.f16977f = msgSettingItemView5;
            msgSettingItemView5.setText(R.string.obfuscated_res_0x7f0f0c19);
            MsgSettingItemView msgSettingItemView6 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0905fd);
            this.f16978g = msgSettingItemView6;
            msgSettingItemView6.setText(R.string.obfuscated_res_0x7f0f03a4);
            MsgSettingItemView msgSettingItemView7 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f090cf1);
            this.f16979h = msgSettingItemView7;
            msgSettingItemView7.setLineVisibility(false);
            this.f16979h.setText(R.string.obfuscated_res_0x7f0f07d2);
            MsgSettingItemView msgSettingItemView8 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091bfd);
            this.i = msgSettingItemView8;
            msgSettingItemView8.setText(R.string.obfuscated_res_0x7f0f0f6d);
            this.i.setLineVisibility(false);
            MsgSettingItemView msgSettingItemView9 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092098);
            this.j = msgSettingItemView9;
            msgSettingItemView9.setText(R.string.obfuscated_res_0x7f0f0f75);
            MsgSettingItemView msgSettingItemView10 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0922f5);
            this.k = msgSettingItemView10;
            msgSettingItemView10.setText(R.string.obfuscated_res_0x7f0f0f76);
            MsgSettingItemView msgSettingItemView11 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f09124b);
            this.l = msgSettingItemView11;
            msgSettingItemView11.setLineVisibility(true);
            this.l.setText(R.string.obfuscated_res_0x7f0f0f6c);
            MsgSettingItemView msgSettingItemView12 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d04);
            this.m = msgSettingItemView12;
            msgSettingItemView12.setText(R.string.obfuscated_res_0x7f0f115f);
            this.n = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d02);
            this.o = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d05);
            MsgSettingItemView msgSettingItemView13 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091591);
            this.p = msgSettingItemView13;
            msgSettingItemView13.setText(R.string.obfuscated_res_0x7f0f0c30);
            this.p.setLineVisibility(false);
            this.q = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f09158c);
            this.r = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f09158d);
            this.x = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f09158e);
            this.y = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091590);
            this.L = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0921c4);
            this.M = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092179);
            this.z = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091588);
            this.A = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f09158a);
            this.D = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f09145d);
            this.E = msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0911fa);
            boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
            this.E.setVisibility(areNotificationsEnabled ? 8 : 0);
            TiebaStatic.log(new StatisticItem("c13890").param("obj_type", areNotificationsEnabled ? 1 : 2));
            this.F = (BdSwitchView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091e2b);
            View findViewById = msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091e2c);
            this.G = findViewById;
            findViewById.setOnClickListener(msgRemindActivity);
            MsgSettingItemView msgSettingItemView14 = (MsgSettingItemView) this.C.findViewById(R.id.obfuscated_res_0x7f090fb4);
            this.H = msgSettingItemView14;
            msgSettingItemView14.setText(R.string.obfuscated_res_0x7f0f06b0);
            this.H.setOnSwitchStateChangeListener(this.C);
            MsgSettingItemView msgSettingItemView15 = (MsgSettingItemView) this.C.findViewById(R.id.obfuscated_res_0x7f090fb6);
            this.I = msgSettingItemView15;
            msgSettingItemView15.setText(R.string.obfuscated_res_0x7f0f11df);
            this.I.setOnSwitchStateChangeListener(this.C);
            this.I.setLineVisibility(false);
            L();
            MsgSettingItemView msgSettingItemView16 = (MsgSettingItemView) this.C.findViewById(R.id.obfuscated_res_0x7f090fb3);
            this.J = msgSettingItemView16;
            msgSettingItemView16.setText(R.string.obfuscated_res_0x7f0f0f30);
            this.J.setOnSwitchStateChangeListener(this.C);
            this.J.setLineVisibility(false);
            K();
            MsgSettingItemView msgSettingItemView17 = (MsgSettingItemView) this.C.findViewById(R.id.obfuscated_res_0x7f090fb7);
            this.K = msgSettingItemView17;
            msgSettingItemView17.setText(R.string.obfuscated_res_0x7f0f0ca8);
            this.K.setOnSwitchStateChangeListener(this.C);
            this.K.setLineVisibility(false);
            U();
        }
    }

    public final void U() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (msgSettingItemView = this.K) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(c.a.o0.s.d.d.d().l());
        new OfficialAccountPushModel(new a(this)).z();
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public void W() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.C).areNotificationsEnabled();
            if (areNotificationsEnabled) {
                this.F.j();
                i = 1;
            } else {
                this.F.f();
                i = 2;
            }
            this.E.setVisibility(areNotificationsEnabled ? 8 : 0);
            X(areNotificationsEnabled);
            TiebaStatic.log(new StatisticItem("c13889").param("obj_locate", i).param("obj_source", 8));
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                this.f16974c.getSwitchView().setEnabled(true);
                this.f16975d.getSwitchView().setEnabled(true);
                this.f16977f.getSwitchView().setEnabled(true);
                this.f16976e.getSwitchView().setEnabled(true);
                this.H.getSwitchView().setEnabled(true);
                this.I.getSwitchView().setEnabled(true);
                this.J.getSwitchView().setEnabled(true);
                this.K.getSwitchView().setEnabled(true);
                this.m.getSwitchView().setEnabled(true);
                this.p.getSwitchView().setEnabled(true);
                this.f16974c.getSwitchView().setAlpha(1.0f);
                this.f16975d.getSwitchView().setAlpha(1.0f);
                this.f16977f.getSwitchView().setAlpha(1.0f);
                this.f16976e.getSwitchView().setAlpha(1.0f);
                this.H.getSwitchView().setAlpha(1.0f);
                this.I.getSwitchView().setAlpha(1.0f);
                this.J.getSwitchView().setAlpha(1.0f);
                this.K.getSwitchView().setAlpha(1.0f);
                this.m.getSwitchView().setAlpha(1.0f);
                this.p.getSwitchView().setAlpha(1.0f);
                return;
            }
            this.f16974c.getSwitchView().setEnabled(false);
            this.f16975d.getSwitchView().setEnabled(false);
            this.f16977f.getSwitchView().setEnabled(false);
            this.f16976e.getSwitchView().setEnabled(false);
            this.H.getSwitchView().setEnabled(false);
            this.I.getSwitchView().setEnabled(false);
            this.J.getSwitchView().setEnabled(false);
            this.K.getSwitchView().setEnabled(false);
            this.m.getSwitchView().setEnabled(false);
            this.p.getSwitchView().setEnabled(false);
            this.f16974c.getSwitchView().setAlpha(0.3f);
            this.f16975d.getSwitchView().setAlpha(0.3f);
            this.f16977f.getSwitchView().setAlpha(0.3f);
            this.f16976e.getSwitchView().setAlpha(0.3f);
            this.H.getSwitchView().setAlpha(0.3f);
            this.I.getSwitchView().setAlpha(0.3f);
            this.J.getSwitchView().setAlpha(0.3f);
            this.K.getSwitchView().setAlpha(0.3f);
            this.m.getSwitchView().setAlpha(0.3f);
            this.p.getSwitchView().setAlpha(0.3f);
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.H.setLineVisibility(z);
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || this.B == z) {
            return;
        }
        this.B = z;
        if (z) {
            this.t.setCenterTextTitle(this.C.getString(R.string.obfuscated_res_0x7f0f0ad9));
            this.v.setVisibility(0);
            this.w.setVisibility(8);
            return;
        }
        this.t.setCenterTextTitle(this.C.getString(R.string.obfuscated_res_0x7f0f0c31));
        this.w.setVisibility(0);
        this.v.setVisibility(8);
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.p.setLineVisibility(z);
            if (z) {
                this.q.setVisibility(0);
                f0();
                SkinManager.setBackgroundResource(this.q, R.drawable.more_all);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (z) {
                this.n.setVisibility(0);
                this.m.setLineVisibility(true);
                SkinManager.setBackgroundResource(this.n, R.drawable.more_all);
                return;
            }
            this.n.setVisibility(8);
            this.m.setLineVisibility(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                this.p.setVisibility(8);
                this.q.setVisibility(8);
                this.a.setVisibility(8);
                this.f16973b.setVisibility(8);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.i.setVisibility(8);
            }
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (z) {
                this.I.setVisibility(0);
            } else {
                this.I.setVisibility(8);
            }
        }
    }

    public void e0() {
        MsgRemindActivity msgRemindActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (msgRemindActivity = this.C) == null) {
            return;
        }
        c.a.o0.s.d.f.c().k(this.C.getActivity(), (ViewGroup) msgRemindActivity.findViewById(16908290));
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            String g2 = c.a.o0.s.d.d.d().g();
            String f2 = c.a.o0.s.d.d.d().f();
            TextView textView = this.r;
            textView.setText(g2 + "-" + f2);
            this.y.setText(g2);
            this.A.setText(f2);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f16978g.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
        }
    }

    public void g0() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (c.a.o0.s.d.d.d().A()) {
                int i = c.a.o0.s.d.d.d().i();
                int j = c.a.o0.s.d.d.d().j();
                if (i > 9) {
                    str = String.valueOf(i);
                } else {
                    str = "0" + i;
                }
                if (j > 9) {
                    str2 = String.valueOf(j);
                } else {
                    str2 = "0" + j;
                }
                this.o.setText(this.C.getString(R.string.obfuscated_res_0x7f0f1160, new Object[]{str, str2}));
                this.n.setVisibility(0);
                if (this.m.b()) {
                    return;
                }
                this.m.g();
                return;
            }
            this.o.setText(R.string.obfuscated_res_0x7f0f03e1);
            this.n.setVisibility(8);
            if (this.m.b()) {
                this.m.e();
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f16976e.setOnSwitchStateChangeListener(null);
            this.f16976e.setSwitchStateNoCallback(c.a.o0.s.d.d.d().q());
            this.f16976e.setOnSwitchStateChangeListener(this.C);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (!TbadkCoreApplication.getInst().isMIUIRom()) {
                this.i.setLineVisibility(true);
            } else {
                this.i.setLineVisibility(false);
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f16978g.setOnSwitchStateChangeListener(null);
            this.f16978g.setSwitchStateNoCallback(c.a.o0.s.d.d.d().r());
            this.f16978g.setOnSwitchStateChangeListener(this.C);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            d();
            i();
            g();
            h();
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f16979h.setOnSwitchStateChangeListener(null);
            this.f16979h.setSwitchStateNoCallback(c.a.o0.s.d.d.d().p());
            this.f16979h.setOnSwitchStateChangeListener(this.C);
        }
    }

    public BdSwitchView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f16976e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.f16977f.setOnSwitchStateChangeListener(null);
            this.f16977f.setSwitchStateNoCallback(c.a.o0.s.d.d.d().t());
            this.f16977f.setOnSwitchStateChangeListener(this.C);
        }
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.u : (View) invokeV.objValue;
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.f16974c.setOnSwitchStateChangeListener(null);
            this.f16974c.setSwitchStateNoCallback(c.a.o0.s.d.d.d().v());
            this.f16974c.setOnSwitchStateChangeListener(this.C);
        }
    }

    public BdSwitchView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f16978g.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f16975d.setOnSwitchStateChangeListener(null);
            this.f16975d.setSwitchStateNoCallback(c.a.o0.s.d.d.d().y());
            this.f16975d.setOnSwitchStateChangeListener(this.C);
        }
    }

    public BdSwitchView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.J.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.H.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.C.getLayoutMode().k(i == 1);
            this.C.getLayoutMode().j(this.s);
            this.t.onChangeSkinType(this.C.getPageContext(), i);
            this.a.c(this.C.getPageContext(), i);
            this.f16974c.c(this.C.getPageContext(), i);
            this.f16975d.c(this.C.getPageContext(), i);
            this.f16976e.c(this.C.getPageContext(), i);
            this.f16977f.c(this.C.getPageContext(), i);
            this.f16978g.c(this.C.getPageContext(), i);
            this.f16979h.c(this.C.getPageContext(), i);
            this.i.c(this.C.getPageContext(), i);
            this.j.c(this.C.getPageContext(), i);
            this.k.c(this.C.getPageContext(), i);
            this.l.c(this.C.getPageContext(), i);
            this.m.c(this.C.getPageContext(), i);
            this.p.c(this.C.getPageContext(), i);
            this.H.c(this.C.getPageContext(), i);
            this.I.c(this.C.getPageContext(), i);
            this.J.c(this.C.getPageContext(), i);
            this.K.c(this.C.getPageContext(), i);
            SkinManager.setBackgroundResource(this.q, R.drawable.more_all);
            SkinManager.setBackgroundResource(this.x, R.drawable.more_all);
            SkinManager.setBackgroundResource(this.z, R.drawable.more_all);
            SkinManager.setBackgroundResource(this.n, R.drawable.more_all);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.q.findViewById(R.id.obfuscated_res_0x7f09158b), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.n.findViewById(R.id.obfuscated_res_0x7f091d03), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.x.findViewById(R.id.obfuscated_res_0x7f09158f), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.z.findViewById(R.id.obfuscated_res_0x7f091589), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.L);
            d2.v(R.color.CAM_X0109);
            d2.f(R.color.CAM_X0204);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.M);
            d3.v(R.color.CAM_X0109);
            d3.f(R.color.CAM_X0204);
        }
    }

    public BdSwitchView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f16979h.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.a.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextTipView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.D : (TbSettingTextTipView) invokeV.objValue;
    }

    public TextView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.t.getCenterText() : (TextView) invokeV.objValue;
    }

    public BdSwitchView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f16977f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public LinearLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.z : (LinearLayout) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    public LinearLayout w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.x : (LinearLayout) invokeV.objValue;
    }

    public BdSwitchView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.p.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.K.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.l.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }
}
