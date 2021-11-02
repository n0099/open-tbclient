package b.a.r0.c3.c;

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
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class f extends b.a.e.a.d<MsgReceiveActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f15259a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f15260b;

    /* renamed from: c  reason: collision with root package name */
    public View f15261c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f15262d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f15263e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f15264f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f15265g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f15266h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f15267i;
    public View.OnClickListener j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f15268e;

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
            this.f15268e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.f15268e.f15265g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(this.f15268e.f15267i, this.f15268e.i())));
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.f15267i = msgReceiveActivity;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15261c : (View) invokeV.objValue;
    }

    public BdSwitchView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15264f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15262d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final ArrayList<OfficialAccountPushInfo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15266h : (ArrayList) invokeV.objValue;
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (msgReceiveActivity = this.f15267i) == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f15259a = (ViewGroup) this.f15267i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f15267i.findViewById(R.id.navigation_bar_msg_receive);
        this.f15260b = navigationBar;
        navigationBar.setCenterTextTitle(this.f15267i.getPageContext().getString(R.string.receive_message));
        this.f15260b.showBottomLine();
        this.f15261c = this.f15260b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f15267i.findViewById(R.id.item_view_friend_msg);
        this.f15262d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f15262d.setOnSwitchStateChangeListener(this.f15267i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f15267i.findViewById(R.id.item_view_stranger_msg);
        this.f15263e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f15263e.setOnSwitchStateChangeListener(this.f15267i);
        this.f15263e.setLineVisibility(false);
        m();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f15267i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f15264f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f15264f.setOnSwitchStateChangeListener(this.f15267i);
        this.f15264f.setLineVisibility(false);
        l();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f15267i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f15265g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15263e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f15267i == null) {
            return;
        }
        initUI();
    }

    public final void l() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.f15264f) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(b.a.q0.t.d.d.d().l());
    }

    public final void m() {
        MsgSettingItemView msgSettingItemView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (msgSettingItemView = this.f15262d) == null || this.f15263e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().turnOffNoCallback();
            this.f15262d.setLineVisibility(false);
            this.f15263e.setVisibility(8);
            this.f15263e.getSwitchView().turnOffNoCallback();
            return;
        }
        msgSettingItemView.getSwitchView().turnOnNoCallback();
        this.f15262d.setLineVisibility(true);
        this.f15263e.getSwitchView().turnOffNoCallback();
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f15262d.setLineVisibility(z);
        }
    }

    public void o(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.f15266h = arrayList;
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f15259a, R.color.CAM_X0204, i2);
            this.f15260b.onChangeSkinType(this.f15267i.getPageContext(), i2);
            this.f15262d.onChangeSkinType(this.f15267i.getPageContext(), i2);
            this.f15263e.onChangeSkinType(this.f15267i.getPageContext(), i2);
            this.f15264f.onChangeSkinType(this.f15267i.getPageContext(), i2);
            this.f15265g.onChangeSkinType(i2);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f15263e.setVisibility(0);
            } else {
                this.f15263e.setVisibility(8);
            }
        }
    }
}
