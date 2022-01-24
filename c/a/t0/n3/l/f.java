package c.a.t0.n3.l;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.more.MsgReceiveActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class f extends c.a.d.a.d<MsgReceiveActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f19817b;

    /* renamed from: c  reason: collision with root package name */
    public View f19818c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f19819d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f19820e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f19821f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f19822g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f19823h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f19824i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f19825j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f19826e;

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
            this.f19826e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.f19826e.f19822g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(this.f19826e.f19824i, this.f19826e.i())));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgReceiveActivity};
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
        this.f19825j = new a(this);
        this.f19824i = msgReceiveActivity;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19818c : (View) invokeV.objValue;
    }

    public BdSwitchView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19821f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19819d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final ArrayList<OfficialAccountPushInfo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19823h : (ArrayList) invokeV.objValue;
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (msgReceiveActivity = this.f19824i) == null) {
            return;
        }
        msgReceiveActivity.setContentView(c.a.t0.n3.f.msg_receive_activity);
        this.a = (ViewGroup) this.f19824i.findViewById(c.a.t0.n3.e.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f19824i.findViewById(c.a.t0.n3.e.navigation_bar_msg_receive);
        this.f19817b = navigationBar;
        navigationBar.setCenterTextTitle(this.f19824i.getPageContext().getString(c.a.t0.n3.g.receive_message));
        this.f19817b.showBottomLine();
        this.f19818c = this.f19817b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f19824i.findViewById(c.a.t0.n3.e.item_view_friend_msg);
        this.f19819d = msgSettingItemView;
        msgSettingItemView.setText(c.a.t0.n3.g.friend_msg_switch);
        this.f19819d.setOnSwitchStateChangeListener(this.f19824i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f19824i.findViewById(c.a.t0.n3.e.item_view_stranger_msg);
        this.f19820e = msgSettingItemView2;
        msgSettingItemView2.setText(c.a.t0.n3.g.stranger_msg_switch);
        this.f19820e.setOnSwitchStateChangeListener(this.f19824i);
        this.f19820e.setLineVisibility(false);
        m();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f19824i.findViewById(c.a.t0.n3.e.item_view_forum_broadcast_msg);
        this.f19821f = msgSettingItemView3;
        msgSettingItemView3.setText(c.a.t0.n3.g.receive_forum_broadcast_message);
        this.f19821f.setOnSwitchStateChangeListener(this.f19824i);
        this.f19821f.setLineVisibility(false);
        l();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f19824i.findViewById(c.a.t0.n3.e.item_view_offical_account_push_msg);
        this.f19822g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.f19825j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19820e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f19824i == null) {
            return;
        }
        initUI();
    }

    public final void l() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.f19821f) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(c.a.s0.t.d.d.d().m());
    }

    public final void m() {
        MsgSettingItemView msgSettingItemView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (msgSettingItemView = this.f19819d) == null || this.f19820e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().turnOffNoCallback();
            this.f19819d.setLineVisibility(false);
            this.f19820e.setVisibility(8);
            this.f19820e.getSwitchView().turnOffNoCallback();
            return;
        }
        msgSettingItemView.getSwitchView().turnOnNoCallback();
        this.f19819d.setLineVisibility(true);
        this.f19820e.getSwitchView().turnOffNoCallback();
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f19819d.setLineVisibility(z);
        }
    }

    public void o(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.f19823h = arrayList;
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setBackgroundColor(this.a, c.a.t0.n3.b.CAM_X0204, i2);
            this.f19817b.onChangeSkinType(this.f19824i.getPageContext(), i2);
            this.f19819d.onChangeSkinType(this.f19824i.getPageContext(), i2);
            this.f19820e.onChangeSkinType(this.f19824i.getPageContext(), i2);
            this.f19821f.onChangeSkinType(this.f19824i.getPageContext(), i2);
            this.f19822g.onChangeSkinType(i2);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f19820e.setVisibility(0);
            } else {
                this.f19820e.setVisibility(8);
            }
        }
    }
}
