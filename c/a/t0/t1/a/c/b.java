package c.a.t0.t1.a.c;

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
/* loaded from: classes8.dex */
public class b extends c.a.d.a.d<IMBlackListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IMBlackListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f24344b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f24345c;

    /* renamed from: d  reason: collision with root package name */
    public View f24346d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f24347e;

    /* renamed from: f  reason: collision with root package name */
    public a f24348f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f24349g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f24350h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMBlackListActivity};
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
        this.a = iMBlackListActivity;
        e();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.a.getLayoutMode().k(skinType == 1);
            this.a.getLayoutMode().j(this.f24346d);
            this.f24345c.onChangeSkinType(this.a.getPageContext(), skinType);
            this.f24349g.onChangeSkinType(this.a.getPageContext(), skinType);
            this.f24344b.onChangeSkinType(this.a.getPageContext(), skinType);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24350h.setVisibility(8);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setContentView(R.layout.im_black_list);
            View findViewById = this.a.findViewById(R.id.root_view);
            this.f24346d = findViewById;
            this.f24344b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f24346d.findViewById(R.id.view_navigation_bar);
            this.f24345c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f24345c.setTitleText(R.string.chat_black_list_title);
            this.f24347e = (BdListView) this.f24346d.findViewById(R.id.black_list);
            this.f24349g = NoDataViewFactory.a(this.a.getPageContext().getContext(), this.f24346d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
            this.f24350h = (ProgressBar) this.f24346d.findViewById(R.id.progress);
            a aVar = new a(this.a);
            this.f24348f = aVar;
            this.f24347e.setAdapter((ListAdapter) aVar);
            c();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24350h.setVisibility(0);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f24348f.getCount() <= 0) {
                this.f24347e.setVisibility(8);
                this.f24349g.setVisibility(0);
                return;
            }
            this.f24347e.setVisibility(0);
            this.f24349g.setVisibility(8);
            this.f24348f.notifyDataSetChanged();
        }
    }

    public void h(ArrayList<BlackListItemData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f24347e.setVisibility(0);
                this.f24349g.setVisibility(8);
                this.f24348f.f(arrayList);
                this.f24348f.notifyDataSetChanged();
                return;
            }
            this.f24347e.setVisibility(8);
            this.f24349g.setVisibility(0);
        }
    }

    public void i(BlackListItemData blackListItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, blackListItemData) == null) {
            this.f24348f.e(blackListItemData);
            if (this.f24348f.getCount() <= 0) {
                this.f24347e.setVisibility(8);
                this.f24349g.setVisibility(0);
                return;
            }
            this.f24347e.setVisibility(0);
            this.f24349g.setVisibility(8);
            this.f24348f.notifyDataSetChanged();
        }
    }
}
