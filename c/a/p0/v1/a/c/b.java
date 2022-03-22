package c.a.p0.v1.a.c;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import c.a.d.a.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends c.a.d.a.d<IMBlackListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IMBlackListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f19058b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19059c;

    /* renamed from: d  reason: collision with root package name */
    public View f19060d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f19061e;

    /* renamed from: f  reason: collision with root package name */
    public a f19062f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f19063g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f19064h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMBlackListActivity};
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
        this.a = iMBlackListActivity;
        g();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.a.getLayoutMode().k(skinType == 1);
            this.a.getLayoutMode().j(this.f19060d);
            this.f19059c.onChangeSkinType(this.a.getPageContext(), skinType);
            this.f19063g.f(this.a.getPageContext(), skinType);
            this.f19058b.c(this.a.getPageContext(), skinType);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19064h.setVisibility(8);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d03cb);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091aee);
            this.f19060d = findViewById;
            this.f19058b = (NoNetworkView) findViewById.findViewById(R.id.obfuscated_res_0x7f0923d1);
            NavigationBar navigationBar = (NavigationBar) this.f19060d.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f19059c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19059c.setTitleText(R.string.obfuscated_res_0x7f0f03a2);
            this.f19061e = (BdListView) this.f19060d.findViewById(R.id.obfuscated_res_0x7f09037f);
            this.f19063g = NoDataViewFactory.a(this.a.getPageContext().getContext(), this.f19060d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.a), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0305), null);
            this.f19064h = (ProgressBar) this.f19060d.findViewById(R.id.obfuscated_res_0x7f091929);
            a aVar = new a(this.a);
            this.f19062f = aVar;
            this.f19061e.setAdapter((ListAdapter) aVar);
            c();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19064h.setVisibility(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f19062f.getCount() <= 0) {
                this.f19061e.setVisibility(8);
                this.f19063g.setVisibility(0);
                return;
            }
            this.f19061e.setVisibility(0);
            this.f19063g.setVisibility(8);
            this.f19062f.notifyDataSetChanged();
        }
    }

    public void j(ArrayList<BlackListItemData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f19061e.setVisibility(0);
                this.f19063g.setVisibility(8);
                this.f19062f.f(arrayList);
                this.f19062f.notifyDataSetChanged();
                return;
            }
            this.f19061e.setVisibility(8);
            this.f19063g.setVisibility(0);
        }
    }

    public void k(BlackListItemData blackListItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, blackListItemData) == null) {
            this.f19062f.e(blackListItemData);
            if (this.f19062f.getCount() <= 0) {
                this.f19061e.setVisibility(8);
                this.f19063g.setVisibility(0);
                return;
            }
            this.f19061e.setVisibility(0);
            this.f19063g.setVisibility(8);
            this.f19062f.notifyDataSetChanged();
        }
    }
}
