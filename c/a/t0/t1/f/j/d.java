package c.a.t0.t1.f.j;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends c.a.d.a.d<OfficialBarHistoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f22267b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f22268c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f22269d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f22270e;

    /* renamed from: f  reason: collision with root package name */
    public View f22271f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f22272g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseActivity;
        d();
    }

    public void c(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.size() <= 0 || (noDataView = this.f22272g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22267b = View.inflate(this.a.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
            this.a.getPageContext().getPageActivity().setContentView(this.f22267b);
            NavigationBar navigationBar = (NavigationBar) this.f22267b.findViewById(R.id.view_navigation_bar);
            this.f22269d = navigationBar;
            navigationBar.setTitleText(R.string.officical_bar_info_history);
            this.f22269d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f22268c = (BdListView) this.f22267b.findViewById(R.id.bar_history_list);
            BaseActivity baseActivity = this.a;
            OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
            this.f22270e = officialBarHistoryAdapter;
            this.f22268c.setAdapter((ListAdapter) officialBarHistoryAdapter);
            View inflate = View.inflate(this.a.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
            this.f22271f = inflate;
            this.f22268c.addHeaderView(inflate);
            this.f22268c.addFooterView(this.f22271f);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22270e.getCount() != 0 && this.f22268c.getLastVisiblePosition() - this.f22268c.getHeaderViewsCount() < this.f22270e.getCount() - 1 : invokeV.booleanValue;
    }

    public void f(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f22270e.c(list);
            c(list);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            this.f22268c.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list == null || list.size() == 0) {
                if (this.f22272g == null) {
                    this.f22272g = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f22267b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.no_data_text), null);
                }
                this.f22272g.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
                this.f22272g.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f22267b);
            this.f22269d.onChangeSkinType(this.a.getPageContext(), i2);
        }
    }
}
