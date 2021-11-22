package b.a.r0.d3.c;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
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
/* loaded from: classes4.dex */
public class h extends b.a.e.a.d<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SystemHelpSettingActivity f16911a;

    /* renamed from: b  reason: collision with root package name */
    public View f16912b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f16913c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f16914d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f16915e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f16916f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f16917g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f16918h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f16919i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public NavigationBar p;
    public BdSwitchView.b q;

    /* loaded from: classes4.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16920e;

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
            this.f16920e = hVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) && view == this.f16920e.f16918h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                j.t("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                this.f16920e.f16911a.changeSwitchStateLog("recnbar", z ^ true);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16911a = null;
        this.f16912b = null;
        this.f16913c = null;
        this.f16914d = null;
        this.f16915e = null;
        this.f16916f = null;
        this.f16917g = null;
        this.f16919i = null;
        this.q = new a(this);
        new b(this, 2001303);
        this.f16911a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f16911a.findViewById(R.id.view_navigation_bar);
        this.p = navigationBar;
        navigationBar.setTitleText(this.f16911a.getPageContext().getString(R.string.systemhelpsetting));
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f16911a.findViewById(R.id.clear_cache);
        this.f16913c = tbSettingTextTipView;
        tbSettingTextTipView.hideArrow();
        this.f16913c.setOnClickListener(this.f16911a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f16911a.findViewById(R.id.clear_im);
        this.f16914d = tbSettingTextTipView2;
        tbSettingTextTipView2.hideArrow();
        this.f16914d.setOnClickListener(this.f16911a);
        this.f16915e = (BdSwitchView) this.f16911a.findViewById(R.id.item_switch);
        l.c(this.f16911a.getPageContext().getPageActivity(), this.f16915e, 10, 10, 10, 10);
        this.f16915e.setOnSwitchStateChangeListener(this.f16911a);
        this.f16916f = (BdSwitchView) this.f16911a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f16911a.getPageContext().getPageActivity(), this.f16916f, 10, 10, 10, 10);
        this.f16916f.setOnSwitchStateChangeListener(this.f16911a);
        this.f16919i = (TbSettingTextTipView) this.f16911a.findViewById(R.id.debug_tool_launch);
        this.j = (RelativeLayout) this.f16911a.findViewById(R.id.system_savevideo);
        this.k = (RelativeLayout) this.f16911a.findViewById(R.id.system_tingtong);
        this.l = (TextView) this.f16911a.findViewById(R.id.system_savevideo_name);
        this.o = (TextView) this.f16911a.findViewById(R.id.item_name);
        this.m = (TextView) this.f16911a.findViewById(R.id.item_name_tip);
        this.n = (TextView) this.f16911a.findViewById(R.id.system_recent_tip);
        this.f16919i.setVisibility(8);
        this.f16919i.hideArrow();
        this.f16919i.setOnClickListener(this.f16911a);
        this.f16912b = this.f16911a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f16914d.setVisibility(0);
        } else {
            this.f16914d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f16917g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f16911a);
        this.f16917g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f16911a.findViewById(R.id.recently_bar_switch);
        this.f16918h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f16918h.setSpaceView(8);
        this.f16918h.setText(R.string.privacy_hide_recently_bar_text);
        this.f16918h.setOnSwitchStateChangeListener(this.q);
        b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
        k(j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16913c : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16914d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16919i : (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16915e : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16917g : (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16916f : (BdSwitchView) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.f16918h.getSwitchView().turnOnNoCallback();
            } else {
                this.f16918h.getSwitchView().turnOffNoCallback();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f16911a.getLayoutMode().k(i2 == 1);
            this.f16911a.getLayoutMode().j(this.f16912b);
            this.p.onChangeSkinType(getPageContext(), i2);
            this.f16915e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f16916f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f16918h.onChangeSkinType(this.f16911a.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f16913c, R.drawable.more_all);
            b.a.q0.s.u.c.d(this.j).v(R.color.CAM_X0205);
            b.a.q0.s.u.c.d(this.k).v(R.color.CAM_X0205);
            b.a.q0.s.u.c.d(this.l).v(R.color.CAM_X0105);
            b.a.q0.s.u.c.d(this.m).v(R.color.CAM_X0109);
            b.a.q0.s.u.c.d(this.n).v(R.color.CAM_X0108);
            b.a.q0.s.u.c.d(this.o).v(R.color.CAM_X0105);
        }
    }
}
