package c.a.p0.p3.c;

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
/* loaded from: classes2.dex */
public class f extends c.a.d.a.d<MsgReceiveActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f16966b;

    /* renamed from: c  reason: collision with root package name */
    public View f16967c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f16968d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f16969e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f16970f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f16971g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f16972h;
    public MsgReceiveActivity i;
    public View.OnClickListener j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.a.f16971g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(this.a.i, this.a.k())));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.i = msgReceiveActivity;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16967c : (View) invokeV.objValue;
    }

    public BdSwitchView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16970f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16968d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final ArrayList<OfficialAccountPushInfo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16972h : (ArrayList) invokeV.objValue;
    }

    public BdSwitchView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16969e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.i == null) {
            return;
        }
        p();
    }

    public final void n() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (msgSettingItemView = this.f16970f) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(c.a.o0.s.d.d.d().m());
    }

    public final void o() {
        MsgSettingItemView msgSettingItemView;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.f16968d) == null || this.f16969e == null || (i = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f16968d.setLineVisibility(false);
            this.f16969e.setVisibility(8);
            this.f16969e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().l();
        this.f16968d.setLineVisibility(true);
        this.f16969e.getSwitchView().h();
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0204, i);
            this.f16966b.onChangeSkinType(this.i.getPageContext(), i);
            this.f16968d.c(this.i.getPageContext(), i);
            this.f16969e.c(this.i.getPageContext(), i);
            this.f16970f.c(this.i.getPageContext(), i);
            this.f16971g.f(i);
        }
    }

    public final void p() {
        MsgReceiveActivity msgReceiveActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (msgReceiveActivity = this.i) == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.obfuscated_res_0x7f0d0569);
        this.a = (ViewGroup) this.i.findViewById(R.id.obfuscated_res_0x7f09145e);
        NavigationBar navigationBar = (NavigationBar) this.i.findViewById(R.id.obfuscated_res_0x7f09151d);
        this.f16966b = navigationBar;
        navigationBar.setCenterTextTitle(this.i.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f31));
        this.f16966b.showBottomLine();
        this.f16967c = this.f16966b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.i.findViewById(R.id.obfuscated_res_0x7f090fb4);
        this.f16968d = msgSettingItemView;
        msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f06b0);
        this.f16968d.setOnSwitchStateChangeListener(this.i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.i.findViewById(R.id.obfuscated_res_0x7f090fb6);
        this.f16969e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.obfuscated_res_0x7f0f11df);
        this.f16969e.setOnSwitchStateChangeListener(this.i);
        this.f16969e.setLineVisibility(false);
        o();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.i.findViewById(R.id.obfuscated_res_0x7f090fb3);
        this.f16970f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.obfuscated_res_0x7f0f0f30);
        this.f16970f.setOnSwitchStateChangeListener(this.i);
        this.f16970f.setLineVisibility(false);
        n();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.i.findViewById(R.id.obfuscated_res_0x7f090fb5);
        this.f16971g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f16968d.setLineVisibility(z);
        }
    }

    public void r(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
            this.f16972h = arrayList;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f16969e.setVisibility(0);
            } else {
                this.f16969e.setVisibility(8);
            }
        }
    }
}
