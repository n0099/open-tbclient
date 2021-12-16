package c.a.s0.m3.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.d;
import c.a.d.a.f;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.setting.privacy.PrivacyMarkActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends d<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f19565b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19566c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19567d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19568e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f19569f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19570g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19571h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f19572i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19573j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f19574k;
    public BdSwitchView.b l;

    /* renamed from: c.a.s0.m3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1178a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19575e;

        public C1178a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19575e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f19575e.f19569f) {
                    this.f19575e.f19574k = switchState == BdSwitchView.SwitchState.ON;
                    this.f19575e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f19575e.f19572i) {
                    this.f19575e.f19573j = switchState == BdSwitchView.SwitchState.ON;
                    this.f19575e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f19575e.f19569f ? 2 : 1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f<PrivacyMarkActivity> fVar, int i2) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new C1178a(this);
        this.a = fVar;
        i(fVar.getPageActivity(), i2);
        j();
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19565b : (View) invokeV.objValue;
    }

    public final void i(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
            this.f19565b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.f19566c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
            this.f19566c.showBottomLine();
            this.f19566c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19567d = (TextView) this.f19565b.findViewById(R.id.inside_text);
            this.f19568e = (TextView) this.f19565b.findViewById(R.id.inside_desc);
            this.f19569f = (BdSwitchView) this.f19565b.findViewById(R.id.inside_switch);
            this.f19570g = (TextView) this.f19565b.findViewById(R.id.outside_text);
            this.f19571h = (TextView) this.f19565b.findViewById(R.id.outside_desc);
            this.f19572i = (BdSwitchView) this.f19565b.findViewById(R.id.outside_switch);
            this.f19567d.setText(R.string.mark_show_inside);
            this.f19568e.setText(R.string.mark_show_everywhere);
            this.f19570g.setText(R.string.mark_show_outside);
            this.f19571h.setText(R.string.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f19572i.turnOffNoCallback();
            } else {
                this.f19572i.turnOnNoCallback();
            }
            if (i4 == 3) {
                this.f19569f.turnOffNoCallback();
            } else {
                this.f19569f.turnOnNoCallback();
            }
            this.f19573j = i3 != 3;
            this.f19574k = i4 != 3;
            this.f19569f.setOnSwitchStateChangeListener(this.l);
            this.f19572i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f19567d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19568e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f19570g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19571h, R.color.CAM_X0109);
            this.f19566c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.f19574k;
            this.f19574k = z;
            if (z) {
                this.f19569f.turnOnNoCallback();
            } else {
                this.f19569f.turnOffNoCallback();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.f19573j;
            this.f19573j = z;
            if (z) {
                this.f19572i.turnOnNoCallback();
            } else {
                this.f19572i.turnOffNoCallback();
            }
        }
    }
}
