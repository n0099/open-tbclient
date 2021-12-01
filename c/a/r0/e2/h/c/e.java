package c.a.r0.e2.h.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.l;
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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f17083b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f17084c;

    /* renamed from: d  reason: collision with root package name */
    public View f17085d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f17086e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17087f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17088g;

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
        this.f17083b = baseActivity;
        this.f17085d = baseActivity.findViewById(R.id.tail_management_root);
        this.a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f17084c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f17087f = this.f17084c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f17083b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f17084c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f17088g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17087f.getLayoutParams();
        layoutParams.leftMargin = l.f(this.f17083b, R.dimen.ds16);
        this.f17087f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f17088g.getLayoutParams();
        layoutParams2.rightMargin = l.f(this.f17083b, R.dimen.ds16);
        this.f17088g.setLayoutParams(layoutParams2);
        int f2 = l.f(this.f17083b, R.dimen.tbds27);
        this.f17088g.setPadding(f2, 0, f2, 0);
        this.f17086e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.a.addFooterView(view);
        this.a.addHeaderView(view2);
    }

    public TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17087f : (TextView) invokeV.objValue;
    }

    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17088g : (TextView) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f17083b.getLayoutMode().k(i2 == 1);
            this.f17083b.getLayoutMode().j(this.f17085d);
            this.f17086e.onChangeSkinType(this.f17083b.getPageContext(), i2);
            this.f17084c.onChangeSkinType(this.f17083b.getPageContext(), i2);
            SkinManager.setViewTextColor(this.f17088g, R.color.navbar_btn_color);
            SkinManager.setViewTextColor(this.f17087f, R.color.navi_back_text_color);
            SkinManager.setBackgroundResource(this.f17088g, R.drawable.s_navbar_button_bg);
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a.setAdapter((ListAdapter) aVar);
        }
    }

    public void e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                this.f17088g.setText(this.f17083b.getPageContext().getString(R.string.done));
                return;
            }
            this.f17088g.setText(this.f17083b.getPageContext().getString(R.string.edit));
            this.f17088g.setEnabled(!z2);
        }
    }
}
