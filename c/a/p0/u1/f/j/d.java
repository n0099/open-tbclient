package c.a.p0.u1.f.j;

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
/* loaded from: classes2.dex */
public class d extends c.a.d.a.d<OfficialBarHistoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f18712b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f18713c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f18714d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f18715e;

    /* renamed from: f  reason: collision with root package name */
    public View f18716f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f18717g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.size() <= 0 || (noDataView = this.f18717g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18712b = View.inflate(this.a.getPageContext().getContext(), R.layout.obfuscated_res_0x7f0d063a, null);
            this.a.getPageContext().getPageActivity().setContentView(this.f18712b);
            NavigationBar navigationBar = (NavigationBar) this.f18712b.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f18714d = navigationBar;
            navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f0cac);
            this.f18714d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f18713c = (BdListView) this.f18712b.findViewById(R.id.obfuscated_res_0x7f09030c);
            BaseActivity baseActivity = this.a;
            OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
            this.f18715e = officialBarHistoryAdapter;
            this.f18713c.setAdapter((ListAdapter) officialBarHistoryAdapter);
            View inflate = View.inflate(this.a.getPageContext().getContext(), R.layout.obfuscated_res_0x7f0d063b, null);
            this.f18716f = inflate;
            this.f18713c.addHeaderView(inflate);
            this.f18713c.addFooterView(this.f18716f);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18715e.getCount() != 0 && this.f18713c.getLastVisiblePosition() - this.f18713c.getHeaderViewsCount() < this.f18715e.getCount() - 1 : invokeV.booleanValue;
    }

    public void h(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f18715e.c(list);
            c(list);
        }
    }

    public void i(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            this.f18713c.setOnSrollToBottomListener(pVar);
        }
    }

    public void j(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list == null || list.size() == 0) {
                if (this.f18717g == null) {
                    this.f18717g = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f18712b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c2d), null);
                }
                this.f18717g.f(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
                this.f18717g.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f18712b);
            this.f18714d.onChangeSkinType(this.a.getPageContext(), i);
        }
    }
}
