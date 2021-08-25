package c.a.q0.a3.f;

import android.view.View;
import c.a.e.a.d;
import c.a.e.a.f;
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
/* loaded from: classes3.dex */
public class b extends d<UserMuteListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<UserMuteListActivity> f15611a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f15612b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15613c;

    /* renamed from: d  reason: collision with root package name */
    public View f15614d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f15615e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f15616f;

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
        this.f15611a = baseActivity;
        initUI();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f15611a.getLayoutMode().k(skinType == 1);
            this.f15611a.getLayoutMode().j(this.f15614d);
            this.f15613c.onChangeSkinType(this.f15611a.getPageContext(), skinType);
            this.f15616f.onChangeSkinType(this.f15611a.getPageContext(), skinType);
            this.f15612b.onChangeSkinType(this.f15611a.getPageContext(), skinType);
        }
    }

    public BdListView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15615e : (BdListView) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15615e.setVisibility(8);
            this.f15616f.setVisibility(0);
            this.f15616f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15615e.setVisibility(8);
            this.f15616f.setVisibility(0);
            this.f15616f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f15611a.setContentView(R.layout.user_mute_list_activity);
            View findViewById = this.f15611a.findViewById(R.id.root_view);
            this.f15614d = findViewById;
            this.f15612b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f15614d.findViewById(R.id.view_navigation_bar);
            this.f15613c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15613c.setTitleText(R.string.user_mute_list_text);
            this.f15615e = (BdListView) this.f15614d.findViewById(R.id.mute_user_list);
            this.f15616f = NoDataViewFactory.a(this.f15611a.getPageContext().getContext(), this.f15614d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f48369a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
            c();
        }
    }
}
