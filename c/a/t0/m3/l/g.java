package c.a.t0.m3.l;

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
/* loaded from: classes7.dex */
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
    public LinearLayout f19433b;

    /* renamed from: c  reason: collision with root package name */
    public MsgSettingItemView f19434c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f19435d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f19436e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f19437f;

    /* renamed from: g  reason: collision with root package name */
    public MsgSettingItemView f19438g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f19439h;

    /* renamed from: i  reason: collision with root package name */
    public MsgSettingItemView f19440i;

    /* renamed from: j  reason: collision with root package name */
    public MsgSettingItemView f19441j;
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

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i2, String str) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, arrayList, i2, str) == null) {
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
                if (c.a.s0.t.d.d.d().l() != z) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        msgRemindActivity.setContentView(c.a.t0.m3.f.msg_remind_activity);
    }

    public BdSwitchView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19434c.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public BdSwitchView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.I.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19435d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void G(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, msgRemindActivity) == null) {
            P(msgRemindActivity);
            K();
            M();
            O();
            N();
            L();
            J(msgRemindActivity);
            h();
        }
    }

    public final void H() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.J) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(c.a.s0.t.d.d.d().m());
    }

    public final void I() {
        MsgSettingItemView msgSettingItemView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (msgSettingItemView = this.H) == null || this.I == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().turnOffNoCallback();
            this.H.setLineVisibility(false);
            this.I.setVisibility(8);
            this.I.getSwitchView().turnOffNoCallback();
            return;
        }
        msgSettingItemView.getSwitchView().turnOnNoCallback();
        this.H.setLineVisibility(true);
        this.I.getSwitchView().turnOffNoCallback();
    }

    public final void J(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, msgRemindActivity) == null) {
            this.u.setOnClickListener(msgRemindActivity);
            this.f19434c.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f19436e.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f19435d.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f19437f.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f19438g.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f19439h.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f19440i.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f19441j.setOnSwitchStateChangeListener(msgRemindActivity);
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

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f19434c.setSwitchStateNoCallback(c.a.s0.t.d.d.d().v());
            this.f19435d.setSwitchStateNoCallback(c.a.s0.t.d.d.d().y());
            this.f19436e.setSwitchStateNoCallback(c.a.s0.t.d.d.d().q());
            this.f19437f.setSwitchStateNoCallback(c.a.s0.t.d.d.d().t());
            this.f19438g.setSwitchStateNoCallback(c.a.s0.t.d.d.d().r());
            this.f19439h.setSwitchStateNoCallback(c.a.s0.t.d.d.d().p());
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (c.a.s0.t.d.d.d().z()) {
                this.p.turnOnNoCallback();
                this.q.setVisibility(0);
                b0();
                return;
            }
            this.p.turnOffNoCallback();
            this.q.setVisibility(8);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (c.a.s0.t.d.d.d().A()) {
                this.m.turnOn();
                this.n.setVisibility(0);
                this.m.setLineVisibility(true);
                c0();
                return;
            }
            this.m.turnOff();
            this.m.setLineVisibility(false);
            this.n.setVisibility(8);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (c.a.s0.t.d.d.d().w()) {
                this.f19441j.turnOnNoCallback();
            } else {
                this.f19441j.turnOffNoCallback();
            }
            if (c.a.s0.t.d.d.d().x()) {
                this.k.turnOnNoCallback();
            } else {
                this.k.turnOffNoCallback();
            }
            if (c.a.s0.t.d.d.d().s()) {
                this.l.turnOnNoCallback();
            } else {
                this.l.turnOffNoCallback();
            }
        }
    }

    public void P(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, msgRemindActivity) == null) {
            this.s = (LinearLayout) msgRemindActivity.findViewById(c.a.t0.m3.e.parent);
            NavigationBar navigationBar = (NavigationBar) msgRemindActivity.findViewById(c.a.t0.m3.e.view_navigation_bar);
            this.t = navigationBar;
            navigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(c.a.t0.m3.g.msg_remind));
            this.t.showBottomLine();
            this.u = this.t.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.v = (LinearLayout) msgRemindActivity.findViewById(c.a.t0.m3.e.front_container);
            this.w = (LinearLayout) msgRemindActivity.findViewById(c.a.t0.m3.e.back_container);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.receive_message_swtich);
            this.a = msgSettingItemView;
            msgSettingItemView.setText(c.a.t0.m3.g.receive_msg_text);
            this.a.setLineVisibility(false);
            this.f19433b = (LinearLayout) msgRemindActivity.findViewById(c.a.t0.m3.e.receive_message_container);
            MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.reply_check_box);
            this.f19434c = msgSettingItemView2;
            msgSettingItemView2.setText(c.a.t0.m3.g.reply);
            MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.zan_check_box);
            this.f19435d = msgSettingItemView3;
            msgSettingItemView3.setVisibility(0);
            this.f19435d.setText(c.a.t0.m3.g.action_praise_default);
            MsgSettingItemView msgSettingItemView4 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.at_me_check_box);
            this.f19436e = msgSettingItemView4;
            msgSettingItemView4.setText(c.a.t0.m3.g.mention_atme);
            MsgSettingItemView msgSettingItemView5 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.new_fans_swtich);
            this.f19437f = msgSettingItemView5;
            msgSettingItemView5.setText(c.a.t0.m3.g.new_fans);
            MsgSettingItemView msgSettingItemView6 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.chat_msg_swtich);
            this.f19438g = msgSettingItemView6;
            msgSettingItemView6.setText(c.a.t0.m3.g.chat_msg_text);
            MsgSettingItemView msgSettingItemView7 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.group_chat_swtich);
            this.f19439h = msgSettingItemView7;
            msgSettingItemView7.setLineVisibility(false);
            this.f19439h.setText(c.a.t0.m3.g.group_chat_text);
            MsgSettingItemView msgSettingItemView8 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.screen_lock_swtich);
            this.f19440i = msgSettingItemView8;
            msgSettingItemView8.setText(c.a.t0.m3.g.remind_screen_lock);
            this.f19440i.setLineVisibility(false);
            MsgSettingItemView msgSettingItemView9 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.tone_remind_swtich);
            this.f19441j = msgSettingItemView9;
            msgSettingItemView9.setText(c.a.t0.m3.g.remind_tone);
            MsgSettingItemView msgSettingItemView10 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.vibrate_remind_swtich);
            this.k = msgSettingItemView10;
            msgSettingItemView10.setText(c.a.t0.m3.g.remind_vibrate);
            MsgSettingItemView msgSettingItemView11 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.light_remind_swtich);
            this.l = msgSettingItemView11;
            msgSettingItemView11.setLineVisibility(true);
            this.l.setText(c.a.t0.m3.g.remind_light);
            MsgSettingItemView msgSettingItemView12 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.sign_remind_swtich);
            this.m = msgSettingItemView12;
            msgSettingItemView12.setText(c.a.t0.m3.g.sign_remind_outline);
            this.n = (LinearLayout) msgRemindActivity.findViewById(c.a.t0.m3.e.sign_remind);
            this.o = (TextView) msgRemindActivity.findViewById(c.a.t0.m3.e.sign_remind_time);
            MsgSettingItemView msgSettingItemView13 = (MsgSettingItemView) msgRemindActivity.findViewById(c.a.t0.m3.e.no_disturb_swtich);
            this.p = msgSettingItemView13;
            msgSettingItemView13.setText(c.a.t0.m3.g.no_disturb_mode);
            this.p.setLineVisibility(false);
            this.q = (LinearLayout) msgRemindActivity.findViewById(c.a.t0.m3.e.no_disturb_mode_time_container);
            this.r = (TextView) msgRemindActivity.findViewById(c.a.t0.m3.e.no_disturb_mode_time_value);
            this.x = (LinearLayout) msgRemindActivity.findViewById(c.a.t0.m3.e.no_disturb_start_time);
            this.y = (TextView) msgRemindActivity.findViewById(c.a.t0.m3.e.no_disturb_start_time_value);
            this.L = (TextView) msgRemindActivity.findViewById(c.a.t0.m3.e.tv_im_title);
            this.M = (TextView) msgRemindActivity.findViewById(c.a.t0.m3.e.tv_abtrct_title);
            this.z = (LinearLayout) msgRemindActivity.findViewById(c.a.t0.m3.e.no_disturb_end_time);
            this.A = (TextView) msgRemindActivity.findViewById(c.a.t0.m3.e.no_disturb_end_time_value);
            this.D = (TbSettingTextTipView) msgRemindActivity.findViewById(c.a.t0.m3.e.msg_receive_item_view);
            this.E = msgRemindActivity.findViewById(c.a.t0.m3.e.layout_system_msg_permission);
            boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
            this.E.setVisibility(areNotificationsEnabled ? 8 : 0);
            TiebaStatic.log(new StatisticItem("c13890").param("obj_type", areNotificationsEnabled ? 1 : 2));
            this.F = (BdSwitchView) msgRemindActivity.findViewById(c.a.t0.m3.e.system_msg_permission_switch);
            View findViewById = msgRemindActivity.findViewById(c.a.t0.m3.e.system_msg_permission_switch_cover);
            this.G = findViewById;
            findViewById.setOnClickListener(msgRemindActivity);
            MsgSettingItemView msgSettingItemView14 = (MsgSettingItemView) this.C.findViewById(c.a.t0.m3.e.item_view_friend_msg);
            this.H = msgSettingItemView14;
            msgSettingItemView14.setText(c.a.t0.m3.g.friend_msg_switch);
            this.H.setOnSwitchStateChangeListener(this.C);
            MsgSettingItemView msgSettingItemView15 = (MsgSettingItemView) this.C.findViewById(c.a.t0.m3.e.item_view_stranger_msg);
            this.I = msgSettingItemView15;
            msgSettingItemView15.setText(c.a.t0.m3.g.stranger_msg_switch);
            this.I.setOnSwitchStateChangeListener(this.C);
            this.I.setLineVisibility(false);
            I();
            MsgSettingItemView msgSettingItemView16 = (MsgSettingItemView) this.C.findViewById(c.a.t0.m3.e.item_view_forum_broadcast_msg);
            this.J = msgSettingItemView16;
            msgSettingItemView16.setText(c.a.t0.m3.g.receive_forum_broadcast_message);
            this.J.setOnSwitchStateChangeListener(this.C);
            this.J.setLineVisibility(false);
            H();
            MsgSettingItemView msgSettingItemView17 = (MsgSettingItemView) this.C.findViewById(c.a.t0.m3.e.item_view_tb_selection_msg);
            this.K = msgSettingItemView17;
            msgSettingItemView17.setText(c.a.t0.m3.g.official_push_message_switch_text);
            this.K.setOnSwitchStateChangeListener(this.C);
            this.K.setLineVisibility(false);
            Q();
        }
    }

    public final void Q() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (msgSettingItemView = this.K) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(c.a.s0.t.d.d.d().l());
        new OfficialAccountPushModel(new a(this)).x();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public void S() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.C).areNotificationsEnabled();
            if (areNotificationsEnabled) {
                this.F.turnOn();
                i2 = 1;
            } else {
                this.F.turnOff();
                i2 = 2;
            }
            this.E.setVisibility(areNotificationsEnabled ? 8 : 0);
            T(areNotificationsEnabled);
            TiebaStatic.log(new StatisticItem("c13889").param("obj_locate", i2).param("obj_source", 8));
        }
    }

    public final void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.f19434c.getSwitchView().setEnabled(true);
                this.f19435d.getSwitchView().setEnabled(true);
                this.f19437f.getSwitchView().setEnabled(true);
                this.f19436e.getSwitchView().setEnabled(true);
                this.H.getSwitchView().setEnabled(true);
                this.I.getSwitchView().setEnabled(true);
                this.J.getSwitchView().setEnabled(true);
                this.K.getSwitchView().setEnabled(true);
                this.m.getSwitchView().setEnabled(true);
                this.p.getSwitchView().setEnabled(true);
                this.f19434c.getSwitchView().setAlpha(1.0f);
                this.f19435d.getSwitchView().setAlpha(1.0f);
                this.f19437f.getSwitchView().setAlpha(1.0f);
                this.f19436e.getSwitchView().setAlpha(1.0f);
                this.H.getSwitchView().setAlpha(1.0f);
                this.I.getSwitchView().setAlpha(1.0f);
                this.J.getSwitchView().setAlpha(1.0f);
                this.K.getSwitchView().setAlpha(1.0f);
                this.m.getSwitchView().setAlpha(1.0f);
                this.p.getSwitchView().setAlpha(1.0f);
                return;
            }
            this.f19434c.getSwitchView().setEnabled(false);
            this.f19435d.getSwitchView().setEnabled(false);
            this.f19437f.getSwitchView().setEnabled(false);
            this.f19436e.getSwitchView().setEnabled(false);
            this.H.getSwitchView().setEnabled(false);
            this.I.getSwitchView().setEnabled(false);
            this.J.getSwitchView().setEnabled(false);
            this.K.getSwitchView().setEnabled(false);
            this.m.getSwitchView().setEnabled(false);
            this.p.getSwitchView().setEnabled(false);
            this.f19434c.getSwitchView().setAlpha(0.3f);
            this.f19435d.getSwitchView().setAlpha(0.3f);
            this.f19437f.getSwitchView().setAlpha(0.3f);
            this.f19436e.getSwitchView().setAlpha(0.3f);
            this.H.getSwitchView().setAlpha(0.3f);
            this.I.getSwitchView().setAlpha(0.3f);
            this.J.getSwitchView().setAlpha(0.3f);
            this.K.getSwitchView().setAlpha(0.3f);
            this.m.getSwitchView().setAlpha(0.3f);
            this.p.getSwitchView().setAlpha(0.3f);
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.H.setLineVisibility(z);
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.B == z) {
            return;
        }
        this.B = z;
        if (z) {
            this.t.setCenterTextTitle(this.C.getString(c.a.t0.m3.g.msg_remind));
            this.v.setVisibility(0);
            this.w.setVisibility(8);
            return;
        }
        this.t.setCenterTextTitle(this.C.getString(c.a.t0.m3.g.no_disturb_mode_time));
        this.w.setVisibility(0);
        this.v.setVisibility(8);
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.p.setLineVisibility(z);
            if (z) {
                this.q.setVisibility(0);
                b0();
                SkinManager.setBackgroundResource(this.q, c.a.t0.m3.d.more_all);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (z) {
                this.n.setVisibility(0);
                this.m.setLineVisibility(true);
                SkinManager.setBackgroundResource(this.n, c.a.t0.m3.d.more_all);
                return;
            }
            this.n.setVisibility(8);
            this.m.setLineVisibility(false);
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                this.I.setVisibility(0);
            } else {
                this.I.setVisibility(8);
            }
        }
    }

    public void a0() {
        MsgRemindActivity msgRemindActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (msgRemindActivity = this.C) == null) {
            return;
        }
        c.a.s0.t.d.f.c().k(this.C.getActivity(), (ViewGroup) msgRemindActivity.findViewById(16908290));
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            String g2 = c.a.s0.t.d.d.d().g();
            String f2 = c.a.s0.t.d.d.d().f();
            TextView textView = this.r;
            textView.setText(g2 + "-" + f2);
            this.y.setText(g2);
            this.A.setText(f2);
        }
    }

    public void c0() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (c.a.s0.t.d.d.d().A()) {
                int i2 = c.a.s0.t.d.d.d().i();
                int j2 = c.a.s0.t.d.d.d().j();
                if (i2 > 9) {
                    str = String.valueOf(i2);
                } else {
                    str = "0" + i2;
                }
                if (j2 > 9) {
                    str2 = String.valueOf(j2);
                } else {
                    str2 = "0" + j2;
                }
                this.o.setText(this.C.getString(c.a.t0.m3.g.sign_remind_time, new Object[]{str, str2}));
                this.n.setVisibility(0);
                if (this.m.isOn()) {
                    return;
                }
                this.m.turnOnNoCallback();
                return;
            }
            this.o.setText(c.a.t0.m3.g.close);
            this.n.setVisibility(8);
            if (this.m.isOn()) {
                this.m.turnOffNoCallback();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                this.p.setVisibility(8);
                this.q.setVisibility(8);
                this.a.setVisibility(8);
                this.f19433b.setVisibility(8);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.f19441j.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.f19440i.setVisibility(8);
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f19436e.setOnSwitchStateChangeListener(null);
            this.f19436e.setSwitchStateNoCallback(c.a.s0.t.d.d.d().q());
            this.f19436e.setOnSwitchStateChangeListener(this.C);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f19438g.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f19438g.setOnSwitchStateChangeListener(null);
            this.f19438g.setSwitchStateNoCallback(c.a.s0.t.d.d.d().r());
            this.f19438g.setOnSwitchStateChangeListener(this.C);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f19439h.setOnSwitchStateChangeListener(null);
            this.f19439h.setSwitchStateNoCallback(c.a.s0.t.d.d.d().p());
            this.f19439h.setOnSwitchStateChangeListener(this.C);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (!TbadkCoreApplication.getInst().isMIUIRom()) {
                this.f19440i.setLineVisibility(true);
            } else {
                this.f19440i.setLineVisibility(false);
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f19437f.setOnSwitchStateChangeListener(null);
            this.f19437f.setSwitchStateNoCallback(c.a.s0.t.d.d.d().t());
            this.f19437f.setOnSwitchStateChangeListener(this.C);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            d();
            g();
            e();
            f();
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f19434c.setOnSwitchStateChangeListener(null);
            this.f19434c.setSwitchStateNoCallback(c.a.s0.t.d.d.d().v());
            this.f19434c.setOnSwitchStateChangeListener(this.C);
        }
    }

    public BdSwitchView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f19436e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.f19435d.setOnSwitchStateChangeListener(null);
            this.f19435d.setSwitchStateNoCallback(c.a.s0.t.d.d.d().y());
            this.f19435d.setOnSwitchStateChangeListener(this.C);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.u : (View) invokeV.objValue;
    }

    public BdSwitchView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f19438g.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.J.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.H.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f19439h.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.a.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.C.getLayoutMode().k(i2 == 1);
            this.C.getLayoutMode().j(this.s);
            this.t.onChangeSkinType(this.C.getPageContext(), i2);
            this.a.onChangeSkinType(this.C.getPageContext(), i2);
            this.f19434c.onChangeSkinType(this.C.getPageContext(), i2);
            this.f19435d.onChangeSkinType(this.C.getPageContext(), i2);
            this.f19436e.onChangeSkinType(this.C.getPageContext(), i2);
            this.f19437f.onChangeSkinType(this.C.getPageContext(), i2);
            this.f19438g.onChangeSkinType(this.C.getPageContext(), i2);
            this.f19439h.onChangeSkinType(this.C.getPageContext(), i2);
            this.f19440i.onChangeSkinType(this.C.getPageContext(), i2);
            this.f19441j.onChangeSkinType(this.C.getPageContext(), i2);
            this.k.onChangeSkinType(this.C.getPageContext(), i2);
            this.l.onChangeSkinType(this.C.getPageContext(), i2);
            this.m.onChangeSkinType(this.C.getPageContext(), i2);
            this.p.onChangeSkinType(this.C.getPageContext(), i2);
            this.H.onChangeSkinType(this.C.getPageContext(), i2);
            this.I.onChangeSkinType(this.C.getPageContext(), i2);
            this.J.onChangeSkinType(this.C.getPageContext(), i2);
            this.K.onChangeSkinType(this.C.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.q, c.a.t0.m3.d.more_all);
            SkinManager.setBackgroundResource(this.x, c.a.t0.m3.d.more_all);
            SkinManager.setBackgroundResource(this.z, c.a.t0.m3.d.more_all);
            SkinManager.setBackgroundResource(this.n, c.a.t0.m3.d.more_all);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.q.findViewById(c.a.t0.m3.e.no_disturb_mode_time_arrow), c.a.t0.m3.d.icon_pure_list_arrow16_right_svg, c.a.t0.m3.b.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.n.findViewById(c.a.t0.m3.e.sign_remind_arrow), c.a.t0.m3.d.icon_pure_list_arrow16_right_svg, c.a.t0.m3.b.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.x.findViewById(c.a.t0.m3.e.no_disturb_start_time_arrow), c.a.t0.m3.d.icon_pure_list_arrow16_right_svg, c.a.t0.m3.b.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.z.findViewById(c.a.t0.m3.e.no_disturb_end_time_arrow), c.a.t0.m3.d.icon_pure_list_arrow16_right_svg, c.a.t0.m3.b.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.L);
            d2.v(c.a.t0.m3.b.CAM_X0109);
            d2.f(c.a.t0.m3.b.CAM_X0204);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.M);
            d3.v(c.a.t0.m3.b.CAM_X0109);
            d3.f(c.a.t0.m3.b.CAM_X0204);
        }
    }

    public TbSettingTextTipView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.D : (TbSettingTextTipView) invokeV.objValue;
    }

    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.t.getCenterText() : (TextView) invokeV.objValue;
    }

    public BdSwitchView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f19437f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public LinearLayout s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.z : (LinearLayout) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    public LinearLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.x : (LinearLayout) invokeV.objValue;
    }

    public BdSwitchView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.p.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.K.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.l.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f19440i.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.f19441j.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }
}
