package b.a.r0.d3.c;

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
/* loaded from: classes4.dex */
public class b extends b.a.e.a.d<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdSettingActivity f16856a;

    /* renamed from: b  reason: collision with root package name */
    public View f16857b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16858c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f16859d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16860e;

    /* renamed from: f  reason: collision with root package name */
    public View f16861f;

    /* renamed from: g  reason: collision with root package name */
    public View f16862g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16863h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16864i;
    public ImageView j;
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16856a = adSettingActivity;
        e();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16862g : (View) invokeV.objValue;
    }

    public final void d() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16859d.setText(R.string.member_ad_setting_text);
            this.f16859d.setOnSwitchStateChangeListener(this.f16856a);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            int i3 = 0;
            if (currentAccountObj != null) {
                i3 = currentAccountObj.getMemberCloseAdIsOpen();
                i2 = currentAccountObj.getMemberCloseAdVipClose();
            } else {
                i2 = 0;
            }
            if (i3 == 0) {
                this.f16859d.setVisibility(8);
                this.f16860e.setVisibility(8);
            } else if (i2 == 0) {
                this.f16859d.turnOffNoCallback();
            } else {
                this.f16859d.turnOnNoCallback();
            }
            if (TextUtils.isEmpty(b.a.q0.s.e0.b.j().p("sync_ad_privacy_url", ""))) {
                this.f16861f.setVisibility(8);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16856a.setContentView(R.layout.ad_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.f16856a.findViewById(R.id.view_navigation_bar);
            this.f16858c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16858c.setTitleText(this.f16856a.getPageContext().getString(R.string.ad_control_setting));
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f16856a.findViewById(R.id.memberAdSetting);
            this.f16859d = msgSettingItemView;
            msgSettingItemView.setLineVisibility(false);
            this.f16860e = (TextView) this.f16856a.findViewById(R.id.memberAdTips);
            this.f16861f = this.f16856a.findViewById(R.id.privacyContainer);
            this.f16862g = this.f16856a.findViewById(R.id.privacyItem);
            this.k = (TextView) this.f16856a.findViewById(R.id.privacyControlText);
            this.f16863h = (TextView) this.f16856a.findViewById(R.id.privacyControlTipsSmall);
            this.f16863h = (TextView) this.f16856a.findViewById(R.id.privacyControlTipsSmall);
            this.f16864i = (TextView) this.f16856a.findViewById(R.id.privacyControlTips);
            this.j = (ImageView) this.f16856a.findViewById(R.id.arrow);
            this.f16857b = this.f16856a.findViewById(R.id.parent);
            this.f16862g.setOnClickListener(this.f16856a);
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16859d.turnOffNoCallback();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16859d.turnOnNoCallback();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f16856a.getLayoutMode().k(i2 == 1);
            this.f16856a.getLayoutMode().j(this.f16857b);
            this.f16858c.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.f16860e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16864i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16863h, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f16860e, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.f16861f, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f16862g, R.drawable.setting_item_selector);
        }
    }
}
