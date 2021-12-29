package c.a.t0.m3.f;

import android.view.View;
import c.a.d.a.d;
import c.a.d.a.f;
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
/* loaded from: classes7.dex */
public class b extends d<UserMuteListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<UserMuteListActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f20022b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f20023c;

    /* renamed from: d  reason: collision with root package name */
    public View f20024d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f20025e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f20026f;

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
        this.a = baseActivity;
        initUI();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.a.getLayoutMode().k(skinType == 1);
            this.a.getLayoutMode().j(this.f20024d);
            this.f20023c.onChangeSkinType(this.a.getPageContext(), skinType);
            this.f20026f.onChangeSkinType(this.a.getPageContext(), skinType);
            this.f20022b.onChangeSkinType(this.a.getPageContext(), skinType);
        }
    }

    public BdListView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20025e : (BdListView) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f20025e.setVisibility(8);
            this.f20026f.setVisibility(0);
            this.f20026f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20025e.setVisibility(8);
            this.f20026f.setVisibility(0);
            this.f20026f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setContentView(R.layout.user_mute_list_activity);
            View findViewById = this.a.findViewById(R.id.root_view);
            this.f20024d = findViewById;
            this.f20022b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f20024d.findViewById(R.id.view_navigation_bar);
            this.f20023c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20023c.setTitleText(R.string.user_mute_list_text);
            this.f20025e = (BdListView) this.f20024d.findViewById(R.id.mute_user_list);
            this.f20026f = NoDataViewFactory.a(this.a.getPageContext().getContext(), this.f20024d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
            c();
        }
    }
}
