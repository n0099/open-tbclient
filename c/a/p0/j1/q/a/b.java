package c.a.p0.j1.q.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecommendDetailActivity f20650a;

    /* renamed from: b  reason: collision with root package name */
    public View f20651b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f20652c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f20653d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f20654e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20655f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20656g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20657h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f20658i;

    /* renamed from: j  reason: collision with root package name */
    public SettingTextSwitchView f20659j;
    public NoDataView k;
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
        this.f20650a = recommendDetailActivity;
        c();
    }

    public void a() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (linearLayout = this.f20658i) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoDataView noDataView = this.k;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
            this.l.setVisibility(0);
        }
    }

    public final void c() {
        RecommendDetailActivity recommendDetailActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (recommendDetailActivity = this.f20650a) == null) {
            return;
        }
        recommendDetailActivity.setContentView(R.layout.recommend_detail_activity);
        this.f20651b = this.f20650a.findViewById(R.id.root_view);
        NavigationBar navigationBar = (NavigationBar) this.f20650a.findViewById(R.id.view_navigation_bar);
        this.f20652c = navigationBar;
        navigationBar.showBottomLine();
        this.f20652c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        e(this.f20650a.getResources().getString(R.string.recommend_detail_activity_title));
        this.f20653d = (NoNetworkView) this.f20650a.findViewById(R.id.view_no_network);
        this.l = (LinearLayout) this.f20650a.findViewById(R.id.content_view);
        HeadImageView headImageView = (HeadImageView) this.f20650a.findViewById(R.id.user_image);
        this.f20654e = headImageView;
        headImageView.setIsRound(true);
        this.f20655f = (TextView) this.f20650a.findViewById(R.id.user_name);
        this.f20656g = (TextView) this.f20650a.findViewById(R.id.user_type);
        this.f20657h = (TextView) this.f20650a.findViewById(R.id.intro_content);
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) this.f20650a.findViewById(R.id.switch_view);
        this.f20659j = settingTextSwitchView;
        settingTextSwitchView.setSwitchStateChangeListener(this.f20650a);
        this.f20659j.setVisibility(8);
        this.l.setVisibility(8);
        this.f20658i = (LinearLayout) this.f20650a.findViewById(R.id.switch_ll);
        this.m = this.f20650a.findViewById(R.id.divider_1);
    }

    public void d(int i2) {
        RecommendDetailActivity recommendDetailActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (recommendDetailActivity = this.f20650a) == null || recommendDetailActivity.getPageContext() == null || this.f20650a.getPageContext().getLayoutMode() == null) {
            return;
        }
        NavigationBar navigationBar = this.f20652c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f20650a.getPageContext(), i2);
        }
        NoNetworkView noNetworkView = this.f20653d;
        if (noNetworkView != null) {
            noNetworkView.onChangeSkinType(this.f20650a.getPageContext(), i2);
        }
        NoDataView noDataView = this.k;
        if (noDataView != null) {
            noDataView.onChangeSkinType(this.f20650a.getPageContext(), i2);
        }
        SettingTextSwitchView settingTextSwitchView = this.f20659j;
        if (settingTextSwitchView != null) {
            settingTextSwitchView.switchSkinType(i2);
        }
        View view = this.m;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0205);
        }
        this.f20650a.getPageContext().getLayoutMode().k(i2 == 1);
        this.f20650a.getPageContext().getLayoutMode().j(this.f20651b);
    }

    public void e(String str) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (navigationBar = this.f20652c) == null) {
            return;
        }
        navigationBar.setCenterTextTitle(str);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.f20659j.getSwitchView().turnOnNoCallback();
            } else {
                this.f20659j.getSwitchView().turnOffNoCallback();
            }
        }
    }

    public void g() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (linearLayout = this.f20658i) == null) {
            return;
        }
        linearLayout.setVisibility(0);
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (this.k == null) {
                this.k = NoDataViewFactory.a(this.f20650a.getPageContext().getPageActivity(), this.f20651b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.e.a(i2), null);
            }
            this.k.setTextOption(NoDataViewFactory.e.a(i2));
            this.k.onChangeSkinType(this.f20650a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.l.setVisibility(8);
            this.k.setVisibility(0);
        }
    }

    public void i(UserInfoBigVip userInfoBigVip, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, userInfoBigVip, z) == null) || userInfoBigVip == null || this.f20650a == null) {
            return;
        }
        this.f20654e.startLoad(userInfoBigVip.portraith, 12, false);
        this.f20655f.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
        this.f20656g.setText(userInfoBigVip.user_type);
        this.f20657h.setText(userInfoBigVip.user_detail);
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
        this.f20659j.setVisibility(0);
    }
}
