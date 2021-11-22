package b.a.r0.l1.q.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecommendDetailActivity f21848a;

    /* renamed from: b  reason: collision with root package name */
    public View f21849b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21850c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f21851d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f21852e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21853f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21854g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21855h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f21856i;
    public SettingTextSwitchView j;
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
        this.f21848a = recommendDetailActivity;
        c();
    }

    public void a() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (linearLayout = this.f21856i) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (recommendDetailActivity = this.f21848a) == null) {
            return;
        }
        recommendDetailActivity.setContentView(R.layout.recommend_detail_activity);
        this.f21849b = this.f21848a.findViewById(R.id.root_view);
        NavigationBar navigationBar = (NavigationBar) this.f21848a.findViewById(R.id.view_navigation_bar);
        this.f21850c = navigationBar;
        navigationBar.showBottomLine();
        this.f21850c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        e(this.f21848a.getResources().getString(R.string.recommend_detail_activity_title));
        this.f21851d = (NoNetworkView) this.f21848a.findViewById(R.id.view_no_network);
        this.l = (LinearLayout) this.f21848a.findViewById(R.id.content_view);
        HeadImageView headImageView = (HeadImageView) this.f21848a.findViewById(R.id.user_image);
        this.f21852e = headImageView;
        headImageView.setIsRound(true);
        this.f21853f = (TextView) this.f21848a.findViewById(R.id.user_name);
        this.f21854g = (TextView) this.f21848a.findViewById(R.id.user_type);
        this.f21855h = (TextView) this.f21848a.findViewById(R.id.intro_content);
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) this.f21848a.findViewById(R.id.switch_view);
        this.j = settingTextSwitchView;
        settingTextSwitchView.setSwitchStateChangeListener(this.f21848a);
        this.j.setVisibility(8);
        this.l.setVisibility(8);
        this.f21856i = (LinearLayout) this.f21848a.findViewById(R.id.switch_ll);
        this.m = this.f21848a.findViewById(R.id.divider_1);
    }

    public void d(int i2) {
        RecommendDetailActivity recommendDetailActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (recommendDetailActivity = this.f21848a) == null || recommendDetailActivity.getPageContext() == null || this.f21848a.getPageContext().getLayoutMode() == null) {
            return;
        }
        NavigationBar navigationBar = this.f21850c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f21848a.getPageContext(), i2);
        }
        NoNetworkView noNetworkView = this.f21851d;
        if (noNetworkView != null) {
            noNetworkView.onChangeSkinType(this.f21848a.getPageContext(), i2);
        }
        NoDataView noDataView = this.k;
        if (noDataView != null) {
            noDataView.onChangeSkinType(this.f21848a.getPageContext(), i2);
        }
        SettingTextSwitchView settingTextSwitchView = this.j;
        if (settingTextSwitchView != null) {
            settingTextSwitchView.switchSkinType(i2);
        }
        View view = this.m;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0205);
        }
        this.f21848a.getPageContext().getLayoutMode().k(i2 == 1);
        this.f21848a.getPageContext().getLayoutMode().j(this.f21849b);
    }

    public void e(String str) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (navigationBar = this.f21850c) == null) {
            return;
        }
        navigationBar.setCenterTextTitle(str);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.j.getSwitchView().turnOnNoCallback();
            } else {
                this.j.getSwitchView().turnOffNoCallback();
            }
        }
    }

    public void g() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (linearLayout = this.f21856i) == null) {
            return;
        }
        linearLayout.setVisibility(0);
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (this.k == null) {
                this.k = NoDataViewFactory.a(this.f21848a.getPageContext().getPageActivity(), this.f21849b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320)), NoDataViewFactory.e.a(i2), null);
            }
            this.k.setTextOption(NoDataViewFactory.e.a(i2));
            this.k.onChangeSkinType(this.f21848a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.l.setVisibility(8);
            this.k.setVisibility(0);
        }
    }

    public void i(UserInfoBigVip userInfoBigVip, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, userInfoBigVip, z) == null) || userInfoBigVip == null || this.f21848a == null) {
            return;
        }
        this.f21852e.startLoad(userInfoBigVip.portraith, 12, false);
        this.f21853f.setText(UtilHelper.getFixedText(userInfoBigVip.user_name, 7));
        this.f21854g.setText(userInfoBigVip.user_type);
        this.f21855h.setText(userInfoBigVip.user_detail);
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
        this.j.setVisibility(0);
    }
}
