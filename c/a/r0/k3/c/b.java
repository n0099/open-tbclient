package c.a.r0.k3.c;

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
/* loaded from: classes6.dex */
public class b extends c.a.d.a.d<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f18696b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f18697c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f18698d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18699e;

    /* renamed from: f  reason: collision with root package name */
    public View f18700f;

    /* renamed from: g  reason: collision with root package name */
    public View f18701g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18702h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18703i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f18704j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f18705k;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18701g : (View) invokeV.objValue;
    }

    public final void d() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18698d.setText(R.string.member_ad_setting_text);
            this.f18698d.setOnSwitchStateChangeListener(this.a);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            int i3 = 0;
            if (currentAccountObj != null) {
                i3 = currentAccountObj.getMemberCloseAdIsOpen();
                i2 = currentAccountObj.getMemberCloseAdVipClose();
            } else {
                i2 = 0;
            }
            if (i3 == 0) {
                this.f18698d.setVisibility(8);
                this.f18699e.setVisibility(8);
            } else if (i2 == 0) {
                this.f18698d.turnOffNoCallback();
            } else {
                this.f18698d.turnOnNoCallback();
            }
            if (TextUtils.isEmpty(c.a.q0.s.e0.b.j().p("sync_ad_privacy_url", ""))) {
                this.f18700f.setVisibility(8);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setContentView(R.layout.ad_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.f18697c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f18697c.setTitleText(this.a.getPageContext().getString(R.string.ad_control_setting));
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.memberAdSetting);
            this.f18698d = msgSettingItemView;
            msgSettingItemView.setLineVisibility(false);
            this.f18699e = (TextView) this.a.findViewById(R.id.memberAdTips);
            this.f18700f = this.a.findViewById(R.id.privacyContainer);
            this.f18701g = this.a.findViewById(R.id.privacyItem);
            this.f18705k = (TextView) this.a.findViewById(R.id.privacyControlText);
            this.f18702h = (TextView) this.a.findViewById(R.id.privacyControlTipsSmall);
            this.f18702h = (TextView) this.a.findViewById(R.id.privacyControlTipsSmall);
            this.f18703i = (TextView) this.a.findViewById(R.id.privacyControlTips);
            this.f18704j = (ImageView) this.a.findViewById(R.id.arrow);
            this.f18696b = this.a.findViewById(R.id.parent);
            this.f18701g.setOnClickListener(this.a);
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f18698d.turnOffNoCallback();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f18698d.turnOnNoCallback();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f18696b);
            this.f18697c.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.f18699e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18703i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18705k, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18702h, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f18699e, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f18704j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.f18700f, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f18701g, R.drawable.setting_item_selector);
        }
    }
}
