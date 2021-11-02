package b.a.r0.c3.f;

import android.view.View;
import b.a.e.a.d;
import b.a.e.a.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.usermutelist.UserMuteListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends d<UserMuteListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<UserMuteListActivity> f15336a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f15337b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15338c;

    /* renamed from: d  reason: collision with root package name */
    public View f15339d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f15340e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f15341f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15336a = baseActivity;
        initUI();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f15336a.getLayoutMode().k(skinType == 1);
            this.f15336a.getLayoutMode().j(this.f15339d);
            this.f15338c.onChangeSkinType(this.f15336a.getPageContext(), skinType);
            this.f15341f.onChangeSkinType(this.f15336a.getPageContext(), skinType);
            this.f15337b.onChangeSkinType(this.f15336a.getPageContext(), skinType);
        }
    }

    public BdListView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15340e : (BdListView) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15340e.setVisibility(8);
            this.f15341f.setVisibility(0);
            this.f15341f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15340e.setVisibility(8);
            this.f15341f.setVisibility(0);
            this.f15341f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f15336a.setContentView(R.layout.user_mute_list_activity);
            View findViewById = this.f15336a.findViewById(R.id.root_view);
            this.f15339d = findViewById;
            this.f15337b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f15339d.findViewById(R.id.view_navigation_bar);
            this.f15338c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15338c.setTitleText(R.string.user_mute_list_text);
            this.f15340e = (BdListView) this.f15339d.findViewById(R.id.mute_user_list);
            this.f15341f = NoDataViewFactory.a(this.f15336a.getPageContext().getContext(), this.f15339d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f46057a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
            c();
        }
    }
}
