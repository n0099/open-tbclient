package c.a.t0.s1.q.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.recommend.detail.RecommendDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendDetailActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f22837b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f22838c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f22839d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f22840e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22841f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22842g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22843h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f22844i;

    /* renamed from: j  reason: collision with root package name */
    public SettingTextSwitchView f22845j;

    /* renamed from: k  reason: collision with root package name */
    public NoDataView f22846k;
    public LinearLayout l;
    public View m;

    public b(RecommendDetailActivity recommendDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recommendDetailActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = recommendDetailActivity;
        c();
    }

    public void a() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (linearLayout = this.f22844i) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoDataView noDataView = this.f22846k;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.l.setVisibility(0);
        }
    }

    public final void c() {
        RecommendDetailActivity recommendDetailActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (recommendDetailActivity = this.a) == null) {
            return;
        }
        recommendDetailActivity.setContentView(R.layout.recommend_detail_activity);
        this.f22837b = this.a.findViewById(R.id.root_view);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.f22838c = navigationBar;
        navigationBar.showBottomLine();
        this.f22838c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        e(this.a.getResources().getString(R.string.recommend_detail_activity_title));
        this.f22839d = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
        this.l = (LinearLayout) this.a.findViewById(R.id.content_view);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.user_image);
        this.f22840e = headImageView;
        headImageView.setIsRound(true);
        this.f22841f = (TextView) this.a.findViewById(R.id.user_name);
        this.f22842g = (TextView) this.a.findViewById(R.id.user_type);
        this.f22843h = (TextView) this.a.findViewById(R.id.intro_content);
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) this.a.findViewById(R.id.switch_view);
        this.f22845j = settingTextSwitchView;
        settingTextSwitchView.setSwitchStateChangeListener(this.a);
        this.f22845j.setVisibility(8);
        this.l.setVisibility(8);
        this.f22844i = (LinearLayout) this.a.findViewById(R.id.switch_ll);
        this.m = this.a.findViewById(R.id.divider_1);
    }

    public void d(int i2) {
        RecommendDetailActivity recommendDetailActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (recommendDetailActivity = this.a) == null || recommendDetailActivity.getPageContext() == null || this.a.getPageContext().getLayoutMode() == null) {
            return;
        }
        NavigationBar navigationBar = this.f22838c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
        }
        NoNetworkView noNetworkView = this.f22839d;
        if (noNetworkView != null) {
            noNetworkView.onChangeSkinType(this.a.getPageContext(), i2);
        }
        NoDataView noDataView = this.f22846k;
        if (noDataView != null) {
            noDataView.onChangeSkinType(this.a.getPageContext(), i2);
        }
        SettingTextSwitchView settingTextSwitchView = this.f22845j;
        if (settingTextSwitchView != null) {
            settingTextSwitchView.switchSkinType(i2);
        }
        View view = this.m;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0205);
        }
        this.a.getPageContext().getLayoutMode().k(i2 == 1);
        this.a.getPageContext().getLayoutMode().j(this.f22837b);
    }

    public void e(String str) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (navigationBar = this.f22838c) == null) {
            return;
        }
        navigationBar.setCenterTextTitle(str);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.f22845j.getSwitchView().turnOnNoCallback();
            } else {
                this.f22845j.getSwitchView().turnOffNoCallback();
            }
        }
    }

    public void g() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (linearLayout = this.f22844i) == null) {
            return;
        }
        linearLayout.setVisibility(0);
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (this.f22846k == null) {
                this.f22846k = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f22837b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.e.a(i2), null);
            }
            this.f22846k.setTextOption(NoDataViewFactory.e.a(i2));
            this.f22846k.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.l.setVisibility(8);
            this.f22846k.setVisibility(0);
        }
    }

    public void i(UserInfoBigVip userInfoBigVip, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, userInfoBigVip, z) == null) || userInfoBigVip == null || this.a == null) {
            return;
        }
        this.f22840e.startLoad(userInfoBigVip.portraith, 12, false);
        this.f22841f.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
        this.f22842g.setText(userInfoBigVip.user_type);
        this.f22843h.setText(userInfoBigVip.user_detail);
        if (z) {
            if (userInfoBigVip.message_accept.intValue() == 1) {
                f(true);
                TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(userInfoBigVip.user_id), true);
            } else {
                f(false);
                TbadkCoreApplication.getInst().setPromotedMessage(String.valueOf(userInfoBigVip.user_id), false);
            }
        } else if (TbadkCoreApplication.getInst().isPromotedMessageOn(String.valueOf(userInfoBigVip.user_id))) {
            f(true);
        } else {
            f(false);
        }
        this.f22845j.setVisibility(0);
    }
}
