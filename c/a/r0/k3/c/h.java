package c.a.r0.k3.c;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class h extends c.a.d.a.d<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SystemHelpSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f18753b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f18754c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f18755d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f18756e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f18757f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f18758g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f18759h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f18760i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f18761j;

    /* renamed from: k  reason: collision with root package name */
    public RelativeLayout f18762k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public NavigationBar p;
    public BdSwitchView.b q;

    /* loaded from: classes6.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f18763e;

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
            this.f18763e = hVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) && view == this.f18763e.f18759h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
                j2.t("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                this.f18763e.a.changeSwitchStateLog("recnbar", z ^ true);
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.f18753b = null;
        this.f18754c = null;
        this.f18755d = null;
        this.f18756e = null;
        this.f18757f = null;
        this.f18758g = null;
        this.f18760i = null;
        this.q = new a(this);
        new b(this, 2001303);
        this.a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.p = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.systemhelpsetting));
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.clear_cache);
        this.f18754c = tbSettingTextTipView;
        tbSettingTextTipView.hideArrow();
        this.f18754c.setOnClickListener(this.a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.clear_im);
        this.f18755d = tbSettingTextTipView2;
        tbSettingTextTipView2.hideArrow();
        this.f18755d.setOnClickListener(this.a);
        this.f18756e = (BdSwitchView) this.a.findViewById(R.id.item_switch);
        l.b(this.a.getPageContext().getPageActivity(), this.f18756e, 10, 10, 10, 10);
        this.f18756e.setOnSwitchStateChangeListener(this.a);
        this.f18757f = (BdSwitchView) this.a.findViewById(R.id.setting_save_video_switch);
        l.b(this.a.getPageContext().getPageActivity(), this.f18757f, 10, 10, 10, 10);
        this.f18757f.setOnSwitchStateChangeListener(this.a);
        this.f18760i = (TbSettingTextTipView) this.a.findViewById(R.id.debug_tool_launch);
        this.f18761j = (RelativeLayout) this.a.findViewById(R.id.system_savevideo);
        this.f18762k = (RelativeLayout) this.a.findViewById(R.id.system_tingtong);
        this.l = (TextView) this.a.findViewById(R.id.system_savevideo_name);
        this.o = (TextView) this.a.findViewById(R.id.item_name);
        this.m = (TextView) this.a.findViewById(R.id.item_name_tip);
        this.n = (TextView) this.a.findViewById(R.id.system_recent_tip);
        this.f18760i.setVisibility(8);
        this.f18760i.hideArrow();
        this.f18760i.setOnClickListener(this.a);
        this.f18753b = this.a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f18755d.setVisibility(0);
        } else {
            this.f18755d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f18758g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.a);
        this.f18758g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.recently_bar_switch);
        this.f18759h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f18759h.setSpaceView(8);
        this.f18759h.setText(R.string.privacy_hide_recently_bar_text);
        this.f18759h.setOnSwitchStateChangeListener(this.q);
        c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
        k(j2.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18754c : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18755d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18760i : (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18756e : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18758g : (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18757f : (BdSwitchView) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.f18759h.getSwitchView().turnOnNoCallback();
            } else {
                this.f18759h.getSwitchView().turnOffNoCallback();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f18753b);
            this.p.onChangeSkinType(getPageContext(), i2);
            this.f18756e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f18757f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f18759h.onChangeSkinType(this.a.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f18754c, R.drawable.more_all);
            c.a.q0.s.u.c.d(this.f18761j).v(R.color.CAM_X0205);
            c.a.q0.s.u.c.d(this.f18762k).v(R.color.CAM_X0205);
            c.a.q0.s.u.c.d(this.l).v(R.color.CAM_X0105);
            c.a.q0.s.u.c.d(this.m).v(R.color.CAM_X0109);
            c.a.q0.s.u.c.d(this.n).v(R.color.CAM_X0108);
            c.a.q0.s.u.c.d(this.o).v(R.color.CAM_X0105);
        }
    }
}
