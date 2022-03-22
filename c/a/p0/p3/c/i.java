package c.a.p0.p3.c;

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
/* loaded from: classes2.dex */
public class i extends c.a.d.a.d<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SystemHelpSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f16980b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f16981c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f16982d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f16983e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f16984f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f16985g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f16986h;
    public TbSettingTextTipView i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public NavigationBar p;
    public BdSwitchView.b q;

    /* loaded from: classes2.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) && view == this.a.f16986h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
                k.u("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                this.a.a.changeSwitchStateLog("recnbar", z ^ true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    public i(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {systemHelpSettingActivity};
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
        this.a = null;
        this.f16980b = null;
        this.f16981c = null;
        this.f16982d = null;
        this.f16983e = null;
        this.f16984f = null;
        this.f16985g = null;
        this.i = null;
        this.q = new a(this);
        new b(this, 2001303);
        this.a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d07f1);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.p = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1313));
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090650);
        this.f16981c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.f16981c.setOnClickListener(this.a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090651);
        this.f16982d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.f16982d.setOnClickListener(this.a);
        this.f16983e = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f090fa4);
        n.b(this.a.getPageContext().getPageActivity(), this.f16983e, 10, 10, 10, 10);
        this.f16983e.setOnSwitchStateChangeListener(this.a);
        this.f16984f = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f091ca5);
        n.b(this.a.getPageContext().getPageActivity(), this.f16984f, 10, 10, 10, 10);
        this.f16984f.setOnSwitchStateChangeListener(this.a);
        this.i = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09075f);
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091e2f);
        this.k = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091e31);
        this.l = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e30);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090f87);
        this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090f88);
        this.n = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e2e);
        if (c.a.o0.r.e.h()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.i.c();
        this.i.setOnClickListener(this.a);
        this.f16980b = this.a.findViewById(R.id.obfuscated_res_0x7f091647);
        if (TbadkCoreApplication.isLogin()) {
            this.f16982d.setVisibility(0);
        } else {
            this.f16982d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.obfuscated_res_0x7f091deb);
        this.f16985g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.a);
        this.f16985g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f0919e2);
        this.f16986h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f16986h.setSpaceView(8);
        this.f16986h.setText(R.string.obfuscated_res_0x7f0f0eb5);
        this.f16986h.setOnSwitchStateChangeListener(this.q);
        c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
        m(k.h("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16981c : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16982d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16983e : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16985g : (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16984f : (BdSwitchView) invokeV.objValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.f16986h.getSwitchView().l();
            } else {
                this.f16986h.getSwitchView().h();
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f16980b);
            this.p.onChangeSkinType(getPageContext(), i);
            this.f16983e.setBackgroundRes(SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e8), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e7), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f080398));
            this.f16984f.setBackgroundRes(SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e8), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e7), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f080398));
            this.f16986h.c(this.a.getPageContext(), i);
            SkinManager.setBackgroundResource(this.f16981c, R.drawable.more_all);
            c.a.o0.r.v.c.d(this.j).v(R.color.CAM_X0205);
            c.a.o0.r.v.c.d(this.k).v(R.color.CAM_X0205);
            c.a.o0.r.v.c.d(this.l).v(R.color.CAM_X0105);
            c.a.o0.r.v.c.d(this.m).v(R.color.CAM_X0109);
            c.a.o0.r.v.c.d(this.n).v(R.color.CAM_X0108);
            c.a.o0.r.v.c.d(this.o).v(R.color.CAM_X0105);
        }
    }
}
