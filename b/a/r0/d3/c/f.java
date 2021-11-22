package b.a.r0.d3.c;

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
    public ViewGroup f16891a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f16892b;

    /* renamed from: c  reason: collision with root package name */
    public View f16893c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f16894d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f16895e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f16896f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f16897g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f16898h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f16899i;
    public View.OnClickListener j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f16900e;

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
            this.f16900e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.f16900e.f16897g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(this.f16900e.f16899i, this.f16900e.i())));
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
        this.f16899i = msgReceiveActivity;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16893c : (View) invokeV.objValue;
    }

    public BdSwitchView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16896f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16894d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final ArrayList<OfficialAccountPushInfo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16898h : (ArrayList) invokeV.objValue;
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (msgReceiveActivity = this.f16899i) == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f16891a = (ViewGroup) this.f16899i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f16899i.findViewById(R.id.navigation_bar_msg_receive);
        this.f16892b = navigationBar;
        navigationBar.setCenterTextTitle(this.f16899i.getPageContext().getString(R.string.receive_message));
        this.f16892b.showBottomLine();
        this.f16893c = this.f16892b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f16899i.findViewById(R.id.item_view_friend_msg);
        this.f16894d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f16894d.setOnSwitchStateChangeListener(this.f16899i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f16899i.findViewById(R.id.item_view_stranger_msg);
        this.f16895e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f16895e.setOnSwitchStateChangeListener(this.f16899i);
        this.f16895e.setLineVisibility(false);
        m();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f16899i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f16896f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f16896f.setOnSwitchStateChangeListener(this.f16899i);
        this.f16896f.setLineVisibility(false);
        l();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f16899i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f16897g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16895e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f16899i == null) {
            return;
        }
        initUI();
    }

    public final void l() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.f16896f) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(b.a.q0.t.d.d.d().l());
    }

    public final void m() {
        MsgSettingItemView msgSettingItemView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (msgSettingItemView = this.f16894d) == null || this.f16895e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().turnOffNoCallback();
            this.f16894d.setLineVisibility(false);
            this.f16895e.setVisibility(8);
            this.f16895e.getSwitchView().turnOffNoCallback();
            return;
        }
        msgSettingItemView.getSwitchView().turnOnNoCallback();
        this.f16894d.setLineVisibility(true);
        this.f16895e.getSwitchView().turnOffNoCallback();
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f16894d.setLineVisibility(z);
        }
    }

    public void o(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.f16898h = arrayList;
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f16891a, R.color.CAM_X0204, i2);
            this.f16892b.onChangeSkinType(this.f16899i.getPageContext(), i2);
            this.f16894d.onChangeSkinType(this.f16899i.getPageContext(), i2);
            this.f16895e.onChangeSkinType(this.f16899i.getPageContext(), i2);
            this.f16896f.onChangeSkinType(this.f16899i.getPageContext(), i2);
            this.f16897g.onChangeSkinType(i2);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f16895e.setVisibility(0);
            } else {
                this.f16895e.setVisibility(8);
            }
        }
    }
}
