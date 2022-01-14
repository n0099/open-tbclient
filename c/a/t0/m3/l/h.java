package c.a.t0.m3.l;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class h extends c.a.d.a.d<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SystemHelpSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f19442b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f19443c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f19444d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f19445e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f19446f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f19447g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f19448h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f19449i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f19450j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public NavigationBar p;
    public BdSwitchView.b q;

    /* loaded from: classes7.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f19451e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19451e = hVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) && view == this.f19451e.f19448h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                c.a.s0.s.h0.b k = c.a.s0.s.h0.b.k();
                k.u("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                this.f19451e.a.changeSwitchStateLog("recnbar", z ^ true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001303) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {systemHelpSettingActivity};
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
        this.a = null;
        this.f19442b = null;
        this.f19443c = null;
        this.f19444d = null;
        this.f19445e = null;
        this.f19446f = null;
        this.f19447g = null;
        this.f19449i = null;
        this.q = new a(this);
        new b(this, 2001303);
        this.a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(c.a.t0.m3.f.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(c.a.t0.m3.e.view_navigation_bar);
        this.p = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(c.a.t0.m3.g.systemhelpsetting));
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(c.a.t0.m3.e.clear_cache);
        this.f19443c = tbSettingTextTipView;
        tbSettingTextTipView.hideArrow();
        this.f19443c.setOnClickListener(this.a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(c.a.t0.m3.e.clear_im);
        this.f19444d = tbSettingTextTipView2;
        tbSettingTextTipView2.hideArrow();
        this.f19444d.setOnClickListener(this.a);
        this.f19445e = (BdSwitchView) this.a.findViewById(c.a.t0.m3.e.item_switch);
        n.b(this.a.getPageContext().getPageActivity(), this.f19445e, 10, 10, 10, 10);
        this.f19445e.setOnSwitchStateChangeListener(this.a);
        this.f19446f = (BdSwitchView) this.a.findViewById(c.a.t0.m3.e.setting_save_video_switch);
        n.b(this.a.getPageContext().getPageActivity(), this.f19446f, 10, 10, 10, 10);
        this.f19446f.setOnSwitchStateChangeListener(this.a);
        this.f19449i = (TbSettingTextTipView) this.a.findViewById(c.a.t0.m3.e.debug_tool_launch);
        this.f19450j = (RelativeLayout) this.a.findViewById(c.a.t0.m3.e.system_savevideo);
        this.k = (RelativeLayout) this.a.findViewById(c.a.t0.m3.e.system_tingtong);
        this.l = (TextView) this.a.findViewById(c.a.t0.m3.e.system_savevideo_name);
        this.o = (TextView) this.a.findViewById(c.a.t0.m3.e.item_name);
        this.m = (TextView) this.a.findViewById(c.a.t0.m3.e.item_name_tip);
        this.n = (TextView) this.a.findViewById(c.a.t0.m3.e.system_recent_tip);
        this.f19449i.setVisibility(8);
        this.f19449i.hideArrow();
        this.f19449i.setOnClickListener(this.a);
        this.f19442b = this.a.findViewById(c.a.t0.m3.e.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f19444d.setVisibility(0);
        } else {
            this.f19444d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(c.a.t0.m3.e.sv_plugin_center);
        this.f19447g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.a);
        this.f19447g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(c.a.t0.m3.e.recently_bar_switch);
        this.f19448h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f19448h.setSpaceView(8);
        this.f19448h.setText(c.a.t0.m3.g.privacy_hide_recently_bar_text);
        this.f19448h.setOnSwitchStateChangeListener(this.q);
        c.a.s0.s.h0.b k = c.a.s0.s.h0.b.k();
        k(k.h("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19443c : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19444d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19449i : (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19445e : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19447g : (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19446f : (BdSwitchView) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.f19448h.getSwitchView().turnOnNoCallback();
            } else {
                this.f19448h.getSwitchView().turnOffNoCallback();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f19442b);
            this.p.onChangeSkinType(getPageContext(), i2);
            this.f19445e.setBackgroundRes(SkinManager.getBitmap(c.a.t0.m3.d.bg_switch_open), SkinManager.getBitmap(c.a.t0.m3.d.bg_switch_close), SkinManager.getBitmap(c.a.t0.m3.d.btn_handle));
            this.f19446f.setBackgroundRes(SkinManager.getBitmap(c.a.t0.m3.d.bg_switch_open), SkinManager.getBitmap(c.a.t0.m3.d.bg_switch_close), SkinManager.getBitmap(c.a.t0.m3.d.btn_handle));
            this.f19448h.onChangeSkinType(this.a.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f19443c, c.a.t0.m3.d.more_all);
            c.a.s0.s.u.c.d(this.f19450j).v(c.a.t0.m3.b.CAM_X0205);
            c.a.s0.s.u.c.d(this.k).v(c.a.t0.m3.b.CAM_X0205);
            c.a.s0.s.u.c.d(this.l).v(c.a.t0.m3.b.CAM_X0105);
            c.a.s0.s.u.c.d(this.m).v(c.a.t0.m3.b.CAM_X0109);
            c.a.s0.s.u.c.d(this.n).v(c.a.t0.m3.b.CAM_X0108);
            c.a.s0.s.u.c.d(this.o).v(c.a.t0.m3.b.CAM_X0105);
        }
    }
}
