package c.a.t0.n3.l;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.setting.more.AdSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b extends c.a.d.a.d<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f19787b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19788c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f19789d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19790e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19791f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adSettingActivity};
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
        this.a = adSettingActivity;
        d();
    }

    public final void c() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19789d.setText(c.a.t0.n3.g.member_ad_setting_text);
            this.f19789d.setOnSwitchStateChangeListener(this.a);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            int i3 = 0;
            if (currentAccountObj != null) {
                i3 = currentAccountObj.getMemberCloseAdIsOpen();
                i2 = currentAccountObj.getMemberCloseAdVipClose();
            } else {
                i2 = 0;
            }
            if (i3 == 0) {
                this.f19789d.setVisibility(8);
                this.f19790e.setVisibility(8);
            } else if (i2 == 0) {
                this.f19789d.turnOffNoCallback();
            } else {
                this.f19789d.turnOnNoCallback();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.setContentView(c.a.t0.n3.f.ad_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(c.a.t0.n3.e.view_navigation_bar);
            this.f19788c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19788c.setTitleText(this.a.getPageContext().getString(c.a.t0.n3.g.ad_control_setting));
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(c.a.t0.n3.e.memberAdSetting);
            this.f19789d = msgSettingItemView;
            msgSettingItemView.setLineVisibility(false);
            this.f19790e = (TextView) this.a.findViewById(c.a.t0.n3.e.memberAdTips);
            this.f19791f = (ImageView) this.a.findViewById(c.a.t0.n3.e.arrow);
            this.f19787b = this.a.findViewById(c.a.t0.n3.e.parent);
            c();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19789d.turnOffNoCallback();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19789d.turnOnNoCallback();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f19787b);
            this.f19788c.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.f19790e, c.a.t0.n3.b.CAM_X0105);
            SkinManager.setBackgroundColor(this.f19790e, c.a.t0.n3.b.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19791f, c.a.t0.n3.d.icon_pure_list_arrow16_right_svg, c.a.t0.n3.b.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
