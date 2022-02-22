package c.a.u0.o3.l;

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
/* loaded from: classes8.dex */
public class h extends c.a.d.a.d<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SystemHelpSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f20176b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f20177c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f20178d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f20179e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f20180f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f20181g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f20182h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f20183i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f20184j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public NavigationBar p;
    public BdSwitchView.b q;

    /* loaded from: classes8.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20185e;

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
            this.f20185e = hVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) && view == this.f20185e.f20182h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                c.a.t0.s.j0.b k = c.a.t0.s.j0.b.k();
                k.u("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                this.f20185e.a.changeSwitchStateLog("recnbar", z ^ true);
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f20176b = null;
        this.f20177c = null;
        this.f20178d = null;
        this.f20179e = null;
        this.f20180f = null;
        this.f20181g = null;
        this.f20183i = null;
        this.q = new a(this);
        new b(this, 2001303);
        this.a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(c.a.u0.o3.f.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(c.a.u0.o3.e.view_navigation_bar);
        this.p = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(c.a.u0.o3.g.systemhelpsetting));
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.clear_cache);
        this.f20177c = tbSettingTextTipView;
        tbSettingTextTipView.hideArrow();
        this.f20177c.setOnClickListener(this.a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.clear_im);
        this.f20178d = tbSettingTextTipView2;
        tbSettingTextTipView2.hideArrow();
        this.f20178d.setOnClickListener(this.a);
        this.f20179e = (BdSwitchView) this.a.findViewById(c.a.u0.o3.e.item_switch);
        n.b(this.a.getPageContext().getPageActivity(), this.f20179e, 10, 10, 10, 10);
        this.f20179e.setOnSwitchStateChangeListener(this.a);
        this.f20180f = (BdSwitchView) this.a.findViewById(c.a.u0.o3.e.setting_save_video_switch);
        n.b(this.a.getPageContext().getPageActivity(), this.f20180f, 10, 10, 10, 10);
        this.f20180f.setOnSwitchStateChangeListener(this.a);
        this.f20183i = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.debug_tool_launch);
        this.f20184j = (RelativeLayout) this.a.findViewById(c.a.u0.o3.e.system_savevideo);
        this.k = (RelativeLayout) this.a.findViewById(c.a.u0.o3.e.system_tingtong);
        this.l = (TextView) this.a.findViewById(c.a.u0.o3.e.system_savevideo_name);
        this.o = (TextView) this.a.findViewById(c.a.u0.o3.e.item_name);
        this.m = (TextView) this.a.findViewById(c.a.u0.o3.e.item_name_tip);
        this.n = (TextView) this.a.findViewById(c.a.u0.o3.e.system_recent_tip);
        if (c.a.t0.s.e.h()) {
            this.f20183i.setVisibility(0);
        } else {
            this.f20183i.setVisibility(8);
        }
        this.f20183i.hideArrow();
        this.f20183i.setOnClickListener(this.a);
        this.f20176b = this.a.findViewById(c.a.u0.o3.e.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f20178d.setVisibility(0);
        } else {
            this.f20178d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(c.a.u0.o3.e.sv_plugin_center);
        this.f20181g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.a);
        this.f20181g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(c.a.u0.o3.e.recently_bar_switch);
        this.f20182h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f20182h.setSpaceView(8);
        this.f20182h.setText(c.a.u0.o3.g.privacy_hide_recently_bar_text);
        this.f20182h.setOnSwitchStateChangeListener(this.q);
        c.a.t0.s.j0.b k = c.a.t0.s.j0.b.k();
        k(k.h("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20177c : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20178d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20183i : (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20179e : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20181g : (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20180f : (BdSwitchView) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.f20182h.getSwitchView().turnOnNoCallback();
            } else {
                this.f20182h.getSwitchView().turnOffNoCallback();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f20176b);
            this.p.onChangeSkinType(getPageContext(), i2);
            this.f20179e.setBackgroundRes(SkinManager.getBitmap(c.a.u0.o3.d.bg_switch_open), SkinManager.getBitmap(c.a.u0.o3.d.bg_switch_close), SkinManager.getBitmap(c.a.u0.o3.d.btn_handle));
            this.f20180f.setBackgroundRes(SkinManager.getBitmap(c.a.u0.o3.d.bg_switch_open), SkinManager.getBitmap(c.a.u0.o3.d.bg_switch_close), SkinManager.getBitmap(c.a.u0.o3.d.btn_handle));
            this.f20182h.onChangeSkinType(this.a.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f20177c, c.a.u0.o3.d.more_all);
            c.a.t0.s.v.c.d(this.f20184j).v(c.a.u0.o3.b.CAM_X0205);
            c.a.t0.s.v.c.d(this.k).v(c.a.u0.o3.b.CAM_X0205);
            c.a.t0.s.v.c.d(this.l).v(c.a.u0.o3.b.CAM_X0105);
            c.a.t0.s.v.c.d(this.m).v(c.a.u0.o3.b.CAM_X0109);
            c.a.t0.s.v.c.d(this.n).v(c.a.u0.o3.b.CAM_X0108);
            c.a.t0.s.v.c.d(this.o).v(c.a.u0.o3.b.CAM_X0105);
        }
    }
}
