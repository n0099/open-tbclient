package c.a.r0.x1.h.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f28806a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f28807b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f28808c;

    /* renamed from: d  reason: collision with root package name */
    public View f28809d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f28810e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28811f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f28812g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28807b = baseActivity;
        this.f28809d = baseActivity.findViewById(R.id.tail_management_root);
        this.f28806a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f28808c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f28811f = this.f28808c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f28807b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f28808c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f28812g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f28811f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f28807b, R.dimen.ds16);
        this.f28811f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f28812g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f28807b, R.dimen.ds16);
        this.f28812g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f28807b, R.dimen.tbds27);
        this.f28812g.setPadding(g2, 0, g2, 0);
        this.f28810e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f28806a.addFooterView(view);
        this.f28806a.addHeaderView(view2);
    }

    public TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28811f : (TextView) invokeV.objValue;
    }

    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28812g : (TextView) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f28807b.getLayoutMode().k(i2 == 1);
            this.f28807b.getLayoutMode().j(this.f28809d);
            this.f28810e.onChangeSkinType(this.f28807b.getPageContext(), i2);
            this.f28808c.onChangeSkinType(this.f28807b.getPageContext(), i2);
            SkinManager.setViewTextColor(this.f28812g, R.color.navbar_btn_color);
            SkinManager.setViewTextColor(this.f28811f, R.color.navi_back_text_color);
            SkinManager.setBackgroundResource(this.f28812g, R.drawable.s_navbar_button_bg);
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f28806a.setAdapter((ListAdapter) aVar);
        }
    }

    public void e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                this.f28812g.setText(this.f28807b.getPageContext().getString(R.string.done));
                return;
            }
            this.f28812g.setText(this.f28807b.getPageContext().getString(R.string.edit));
            this.f28812g.setEnabled(!z2);
        }
    }
}
