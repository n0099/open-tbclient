package c.a.p0.a3.c;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class h extends c.a.e.a.d<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SystemHelpSettingActivity f15265a;

    /* renamed from: b  reason: collision with root package name */
    public View f15266b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f15267c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f15268d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f15269e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f15270f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f15271g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f15272h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f15273i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f15274j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public NavigationBar p;
    public BdSwitchView.b q;

    /* loaded from: classes3.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f15275e;

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
            this.f15275e = hVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) && view == this.f15275e.f15272h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                c.a.o0.s.d0.b j2 = c.a.o0.s.d0.b.j();
                j2.t("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15265a = null;
        this.f15266b = null;
        this.f15267c = null;
        this.f15268d = null;
        this.f15269e = null;
        this.f15270f = null;
        this.f15271g = null;
        this.f15273i = null;
        this.q = new a(this);
        new b(this, 2001303);
        this.f15265a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f15265a.findViewById(R.id.view_navigation_bar);
        this.p = navigationBar;
        navigationBar.setTitleText(this.f15265a.getPageContext().getString(R.string.systemhelpsetting));
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f15265a.findViewById(R.id.clear_cache);
        this.f15267c = tbSettingTextTipView;
        tbSettingTextTipView.hideArrow();
        this.f15267c.setOnClickListener(this.f15265a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f15265a.findViewById(R.id.clear_im);
        this.f15268d = tbSettingTextTipView2;
        tbSettingTextTipView2.hideArrow();
        this.f15268d.setOnClickListener(this.f15265a);
        this.f15269e = (BdSwitchView) this.f15265a.findViewById(R.id.item_switch);
        l.c(this.f15265a.getPageContext().getPageActivity(), this.f15269e, 10, 10, 10, 10);
        this.f15269e.setOnSwitchStateChangeListener(this.f15265a);
        this.f15270f = (BdSwitchView) this.f15265a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f15265a.getPageContext().getPageActivity(), this.f15270f, 10, 10, 10, 10);
        this.f15270f.setOnSwitchStateChangeListener(this.f15265a);
        this.f15273i = (TbSettingTextTipView) this.f15265a.findViewById(R.id.debug_tool_launch);
        this.f15274j = (RelativeLayout) this.f15265a.findViewById(R.id.system_savevideo);
        this.k = (RelativeLayout) this.f15265a.findViewById(R.id.system_tingtong);
        this.l = (TextView) this.f15265a.findViewById(R.id.system_savevideo_name);
        this.o = (TextView) this.f15265a.findViewById(R.id.item_name);
        this.m = (TextView) this.f15265a.findViewById(R.id.item_name_tip);
        this.n = (TextView) this.f15265a.findViewById(R.id.system_recent_tip);
        this.f15273i.setVisibility(8);
        this.f15273i.hideArrow();
        this.f15273i.setOnClickListener(this.f15265a);
        this.f15266b = this.f15265a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f15268d.setVisibility(0);
        } else {
            this.f15268d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f15271g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f15265a);
        this.f15271g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f15265a.findViewById(R.id.recently_bar_switch);
        this.f15272h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f15272h.setSpaceView(8);
        this.f15272h.setText(R.string.privacy_hide_recently_bar_text);
        this.f15272h.setOnSwitchStateChangeListener(this.q);
        c.a.o0.s.d0.b j2 = c.a.o0.s.d0.b.j();
        j(j2.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15267c : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15268d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15273i : (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15269e : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15271g : (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15270f : (BdSwitchView) invokeV.objValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.f15272h.getSwitchView().turnOnNoCallback();
            } else {
                this.f15272h.getSwitchView().turnOffNoCallback();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f15265a.getLayoutMode().k(i2 == 1);
            this.f15265a.getLayoutMode().j(this.f15266b);
            this.p.onChangeSkinType(getPageContext(), i2);
            this.f15269e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f15270f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f15272h.onChangeSkinType(this.f15265a.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f15267c, R.drawable.more_all);
            c.a.o0.s.u.c.d(this.f15274j).t(R.color.CAM_X0205);
            c.a.o0.s.u.c.d(this.k).t(R.color.CAM_X0205);
            c.a.o0.s.u.c.d(this.l).t(R.color.CAM_X0105);
            c.a.o0.s.u.c.d(this.m).t(R.color.CAM_X0109);
            c.a.o0.s.u.c.d(this.n).t(R.color.CAM_X0108);
            c.a.o0.s.u.c.d(this.o).t(R.color.CAM_X0105);
        }
    }
}
