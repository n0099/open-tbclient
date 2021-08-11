package c.a.p0.w1.h.c;

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
    public BdListView f27780a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f27781b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f27782c;

    /* renamed from: d  reason: collision with root package name */
    public View f27783d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f27784e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27785f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27786g;

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
        this.f27781b = baseActivity;
        this.f27783d = baseActivity.findViewById(R.id.tail_management_root);
        this.f27780a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f27782c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f27785f = this.f27782c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f27781b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f27782c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f27786g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f27785f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f27781b, R.dimen.ds16);
        this.f27785f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f27786g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f27781b, R.dimen.ds16);
        this.f27786g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f27781b, R.dimen.tbds27);
        this.f27786g.setPadding(g2, 0, g2, 0);
        this.f27784e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f27780a.addFooterView(view);
        this.f27780a.addHeaderView(view2);
    }

    public TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27785f : (TextView) invokeV.objValue;
    }

    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27786g : (TextView) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f27781b.getLayoutMode().k(i2 == 1);
            this.f27781b.getLayoutMode().j(this.f27783d);
            this.f27784e.onChangeSkinType(this.f27781b.getPageContext(), i2);
            this.f27782c.onChangeSkinType(this.f27781b.getPageContext(), i2);
            SkinManager.setViewTextColor(this.f27786g, R.color.navbar_btn_color);
            SkinManager.setViewTextColor(this.f27785f, R.color.navi_back_text_color);
            SkinManager.setBackgroundResource(this.f27786g, R.drawable.s_navbar_button_bg);
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f27780a.setAdapter((ListAdapter) aVar);
        }
    }

    public void e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                this.f27786g.setText(this.f27781b.getPageContext().getString(R.string.done));
                return;
            }
            this.f27786g.setText(this.f27781b.getPageContext().getString(R.string.edit));
            this.f27786g.setEnabled(!z2);
        }
    }
}
