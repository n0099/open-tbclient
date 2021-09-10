package c.a.r0.b3.c;

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
/* loaded from: classes3.dex */
public class b extends c.a.e.a.d<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdSettingActivity f16024a;

    /* renamed from: b  reason: collision with root package name */
    public View f16025b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16026c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f16027d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16028e;

    /* renamed from: f  reason: collision with root package name */
    public View f16029f;

    /* renamed from: g  reason: collision with root package name */
    public View f16030g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16031h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16032i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f16033j;
    public TextView k;

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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16024a = adSettingActivity;
        e();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16030g : (View) invokeV.objValue;
    }

    public final void d() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16027d.setText(R.string.member_ad_setting_text);
            this.f16027d.setOnSwitchStateChangeListener(this.f16024a);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            int i3 = 0;
            if (currentAccountObj != null) {
                i3 = currentAccountObj.getMemberCloseAdIsOpen();
                i2 = currentAccountObj.getMemberCloseAdVipClose();
            } else {
                i2 = 0;
            }
            if (i3 == 0) {
                this.f16027d.setVisibility(8);
                this.f16028e.setVisibility(8);
            } else if (i2 == 0) {
                this.f16027d.turnOffNoCallback();
            } else {
                this.f16027d.turnOnNoCallback();
            }
            if (TextUtils.isEmpty(c.a.q0.s.d0.b.j().p("sync_ad_privacy_url", ""))) {
                this.f16029f.setVisibility(8);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16024a.setContentView(R.layout.ad_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.f16024a.findViewById(R.id.view_navigation_bar);
            this.f16026c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16026c.setTitleText(this.f16024a.getPageContext().getString(R.string.ad_control_setting));
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f16024a.findViewById(R.id.memberAdSetting);
            this.f16027d = msgSettingItemView;
            msgSettingItemView.setLineVisibility(false);
            this.f16028e = (TextView) this.f16024a.findViewById(R.id.memberAdTips);
            this.f16029f = this.f16024a.findViewById(R.id.privacyContainer);
            this.f16030g = this.f16024a.findViewById(R.id.privacyItem);
            this.k = (TextView) this.f16024a.findViewById(R.id.privacyControlText);
            this.f16031h = (TextView) this.f16024a.findViewById(R.id.privacyControlTipsSmall);
            this.f16031h = (TextView) this.f16024a.findViewById(R.id.privacyControlTipsSmall);
            this.f16032i = (TextView) this.f16024a.findViewById(R.id.privacyControlTips);
            this.f16033j = (ImageView) this.f16024a.findViewById(R.id.arrow);
            this.f16025b = this.f16024a.findViewById(R.id.parent);
            this.f16030g.setOnClickListener(this.f16024a);
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16027d.turnOffNoCallback();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16027d.turnOnNoCallback();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f16024a.getLayoutMode().k(i2 == 1);
            this.f16024a.getLayoutMode().j(this.f16025b);
            this.f16026c.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.f16028e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16032i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16031h, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f16028e, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16033j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.f16029f, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f16030g, R.drawable.setting_item_selector);
        }
    }
}
