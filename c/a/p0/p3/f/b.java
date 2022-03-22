package c.a.p0.p3.f;

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
/* loaded from: classes2.dex */
public class b extends d<UserMuteListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<UserMuteListActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f17018b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f17019c;

    /* renamed from: d  reason: collision with root package name */
    public View f17020d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f17021e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f17022f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseActivity;
        g();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.a.getLayoutMode().k(skinType == 1);
            this.a.getLayoutMode().j(this.f17020d);
            this.f17019c.onChangeSkinType(this.a.getPageContext(), skinType);
            this.f17022f.f(this.a.getPageContext(), skinType);
            this.f17018b.c(this.a.getPageContext(), skinType);
        }
    }

    public BdListView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17021e : (BdListView) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setContentView((int) R.layout.obfuscated_res_0x7f0d0865);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091aee);
            this.f17020d = findViewById;
            this.f17018b = (NoNetworkView) findViewById.findViewById(R.id.obfuscated_res_0x7f0923d1);
            NavigationBar navigationBar = (NavigationBar) this.f17020d.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f17019c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f17019c.setTitleText(R.string.obfuscated_res_0x7f0f14a9);
            this.f17021e = (BdListView) this.f17020d.findViewById(R.id.obfuscated_res_0x7f09148e);
            this.f17022f = NoDataViewFactory.a(this.a.getPageContext().getContext(), this.f17020d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.a), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f14a8), null);
            c();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17021e.setVisibility(8);
            this.f17022f.setVisibility(0);
            this.f17022f.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f14a8));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f17021e.setVisibility(8);
            this.f17022f.setVisibility(0);
            this.f17022f.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0f65));
        }
    }
}
