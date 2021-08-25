package c.a.q0.k1.a.c;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import c.a.e.a.f;
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
/* loaded from: classes3.dex */
public class b extends c.a.e.a.d<IMBlackListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IMBlackListActivity f21251a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f21252b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21253c;

    /* renamed from: d  reason: collision with root package name */
    public View f21254d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f21255e;

    /* renamed from: f  reason: collision with root package name */
    public a f21256f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f21257g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f21258h;

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
        this.f21251a = iMBlackListActivity;
        e();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f21251a.getLayoutMode().k(skinType == 1);
            this.f21251a.getLayoutMode().j(this.f21254d);
            this.f21253c.onChangeSkinType(this.f21251a.getPageContext(), skinType);
            this.f21257g.onChangeSkinType(this.f21251a.getPageContext(), skinType);
            this.f21252b.onChangeSkinType(this.f21251a.getPageContext(), skinType);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21258h.setVisibility(8);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21251a.setContentView(R.layout.im_black_list);
            View findViewById = this.f21251a.findViewById(R.id.root_view);
            this.f21254d = findViewById;
            this.f21252b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f21254d.findViewById(R.id.view_navigation_bar);
            this.f21253c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21253c.setTitleText(R.string.chat_black_list_title);
            this.f21255e = (BdListView) this.f21254d.findViewById(R.id.black_list);
            this.f21257g = NoDataViewFactory.a(this.f21251a.getPageContext().getContext(), this.f21254d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f48369a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
            this.f21258h = (ProgressBar) this.f21254d.findViewById(R.id.progress);
            a aVar = new a(this.f21251a);
            this.f21256f = aVar;
            this.f21255e.setAdapter((ListAdapter) aVar);
            c();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21258h.setVisibility(0);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f21256f.getCount() <= 0) {
                this.f21255e.setVisibility(8);
                this.f21257g.setVisibility(0);
                return;
            }
            this.f21255e.setVisibility(0);
            this.f21257g.setVisibility(8);
            this.f21256f.notifyDataSetChanged();
        }
    }

    public void h(ArrayList<BlackListItemData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f21255e.setVisibility(0);
                this.f21257g.setVisibility(8);
                this.f21256f.f(arrayList);
                this.f21256f.notifyDataSetChanged();
                return;
            }
            this.f21255e.setVisibility(8);
            this.f21257g.setVisibility(0);
        }
    }

    public void i(BlackListItemData blackListItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, blackListItemData) == null) {
            this.f21256f.e(blackListItemData);
            if (this.f21256f.getCount() <= 0) {
                this.f21255e.setVisibility(8);
                this.f21257g.setVisibility(0);
                return;
            }
            this.f21255e.setVisibility(0);
            this.f21257g.setVisibility(8);
            this.f21256f.notifyDataSetChanged();
        }
    }
}
