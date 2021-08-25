package c.a.q0.a3.c;

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
/* loaded from: classes3.dex */
public class f extends c.a.e.a.d<MsgReceiveActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f15529a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f15530b;

    /* renamed from: c  reason: collision with root package name */
    public View f15531c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f15532d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f15533e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f15534f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f15535g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f15536h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f15537i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f15538j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f15539e;

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
            this.f15539e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.f15539e.f15535g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(this.f15539e.f15537i, this.f15539e.i())));
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15538j = new a(this);
        this.f15537i = msgReceiveActivity;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15531c : (View) invokeV.objValue;
    }

    public BdSwitchView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15534f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15532d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final ArrayList<OfficialAccountPushInfo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15536h : (ArrayList) invokeV.objValue;
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (msgReceiveActivity = this.f15537i) == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f15529a = (ViewGroup) this.f15537i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f15537i.findViewById(R.id.navigation_bar_msg_receive);
        this.f15530b = navigationBar;
        navigationBar.setCenterTextTitle(this.f15537i.getPageContext().getString(R.string.receive_message));
        this.f15530b.showBottomLine();
        this.f15531c = this.f15530b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f15537i.findViewById(R.id.item_view_friend_msg);
        this.f15532d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f15532d.setOnSwitchStateChangeListener(this.f15537i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f15537i.findViewById(R.id.item_view_stranger_msg);
        this.f15533e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f15533e.setOnSwitchStateChangeListener(this.f15537i);
        this.f15533e.setLineVisibility(false);
        m();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f15537i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f15534f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f15534f.setOnSwitchStateChangeListener(this.f15537i);
        this.f15534f.setLineVisibility(false);
        l();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f15537i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f15535g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.f15538j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15533e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f15537i == null) {
            return;
        }
        initUI();
    }

    public final void l() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.f15534f) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(c.a.p0.t.d.d.d().l());
    }

    public final void m() {
        MsgSettingItemView msgSettingItemView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (msgSettingItemView = this.f15532d) == null || this.f15533e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().turnOffNoCallback();
            this.f15532d.setLineVisibility(false);
            this.f15533e.setVisibility(8);
            this.f15533e.getSwitchView().turnOffNoCallback();
            return;
        }
        msgSettingItemView.getSwitchView().turnOnNoCallback();
        this.f15532d.setLineVisibility(true);
        this.f15533e.getSwitchView().turnOffNoCallback();
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f15532d.setLineVisibility(z);
        }
    }

    public void o(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.f15536h = arrayList;
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f15529a, R.color.CAM_X0204, i2);
            this.f15530b.onChangeSkinType(this.f15537i.getPageContext(), i2);
            this.f15532d.onChangeSkinType(this.f15537i.getPageContext(), i2);
            this.f15533e.onChangeSkinType(this.f15537i.getPageContext(), i2);
            this.f15534f.onChangeSkinType(this.f15537i.getPageContext(), i2);
            this.f15535g.onChangeSkinType(i2);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f15533e.setVisibility(0);
            } else {
                this.f15533e.setVisibility(8);
            }
        }
    }
}
