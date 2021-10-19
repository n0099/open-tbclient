package c.a.r0.c3.f;

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
    public BaseActivity<UserMuteListActivity> f16316a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f16317b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16318c;

    /* renamed from: d  reason: collision with root package name */
    public View f16319d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f16320e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f16321f;

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
        this.f16316a = baseActivity;
        initUI();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f16316a.getLayoutMode().k(skinType == 1);
            this.f16316a.getLayoutMode().j(this.f16319d);
            this.f16318c.onChangeSkinType(this.f16316a.getPageContext(), skinType);
            this.f16321f.onChangeSkinType(this.f16316a.getPageContext(), skinType);
            this.f16317b.onChangeSkinType(this.f16316a.getPageContext(), skinType);
        }
    }

    public BdListView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16320e : (BdListView) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16320e.setVisibility(8);
            this.f16321f.setVisibility(0);
            this.f16321f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16320e.setVisibility(8);
            this.f16321f.setVisibility(0);
            this.f16321f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16316a.setContentView(R.layout.user_mute_list_activity);
            View findViewById = this.f16316a.findViewById(R.id.root_view);
            this.f16319d = findViewById;
            this.f16317b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f16319d.findViewById(R.id.view_navigation_bar);
            this.f16318c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16318c.setTitleText(R.string.user_mute_list_text);
            this.f16320e = (BdListView) this.f16319d.findViewById(R.id.mute_user_list);
            this.f16321f = NoDataViewFactory.a(this.f16316a.getPageContext().getContext(), this.f16319d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f48534a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
            c();
        }
    }
}
