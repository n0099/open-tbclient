package c.a.s0.m3.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.AdSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b extends c.a.d.a.d<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f19480b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19481c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f19482d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19483e;

    /* renamed from: f  reason: collision with root package name */
    public View f19484f;

    /* renamed from: g  reason: collision with root package name */
    public View f19485g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19486h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19487i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f19488j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f19489k;

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
        e();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19485g : (View) invokeV.objValue;
    }

    public final void d() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19482d.setText(R.string.member_ad_setting_text);
            this.f19482d.setOnSwitchStateChangeListener(this.a);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            int i3 = 0;
            if (currentAccountObj != null) {
                i3 = currentAccountObj.getMemberCloseAdIsOpen();
                i2 = currentAccountObj.getMemberCloseAdVipClose();
            } else {
                i2 = 0;
            }
            if (i3 == 0) {
                this.f19482d.setVisibility(8);
                this.f19483e.setVisibility(8);
            } else if (i2 == 0) {
                this.f19482d.turnOffNoCallback();
            } else {
                this.f19482d.turnOnNoCallback();
            }
            if (TextUtils.isEmpty(c.a.r0.s.g0.b.j().p("sync_ad_privacy_url", ""))) {
                this.f19484f.setVisibility(8);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setContentView(R.layout.ad_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.f19481c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19481c.setTitleText(this.a.getPageContext().getString(R.string.ad_control_setting));
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.memberAdSetting);
            this.f19482d = msgSettingItemView;
            msgSettingItemView.setLineVisibility(false);
            this.f19483e = (TextView) this.a.findViewById(R.id.memberAdTips);
            this.f19484f = this.a.findViewById(R.id.privacyContainer);
            this.f19485g = this.a.findViewById(R.id.privacyItem);
            this.f19489k = (TextView) this.a.findViewById(R.id.privacyControlText);
            this.f19486h = (TextView) this.a.findViewById(R.id.privacyControlTipsSmall);
            this.f19486h = (TextView) this.a.findViewById(R.id.privacyControlTipsSmall);
            this.f19487i = (TextView) this.a.findViewById(R.id.privacyControlTips);
            this.f19488j = (ImageView) this.a.findViewById(R.id.arrow);
            this.f19480b = this.a.findViewById(R.id.parent);
            this.f19485g.setOnClickListener(this.a);
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19482d.turnOffNoCallback();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f19482d.turnOnNoCallback();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f19480b);
            this.f19481c.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.f19483e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19487i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19489k, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19486h, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f19483e, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19488j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.f19484f, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f19485g, R.drawable.setting_item_selector);
        }
    }
}
