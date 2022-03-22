package c.a.p0.j2.h.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.n;
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
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f15838b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15839c;

    /* renamed from: d  reason: collision with root package name */
    public View f15840d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f15841e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15842f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15843g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15838b = baseActivity;
        this.f15840d = baseActivity.findViewById(R.id.obfuscated_res_0x7f091ee4);
        this.a = (BdListView) baseActivity.findViewById(R.id.obfuscated_res_0x7f091ee0);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.obfuscated_res_0x7f091ee1);
        this.f15839c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1334));
        this.f15842f = this.f15839c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f15838b.getString(R.string.obfuscated_res_0x7f0f036c), onClickListener);
        TextView addTextButton = this.f15839c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f050c), onClickListener);
        this.f15843g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15842f.getLayoutParams();
        layoutParams.leftMargin = n.f(this.f15838b, R.dimen.obfuscated_res_0x7f0701be);
        this.f15842f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f15843g.getLayoutParams();
        layoutParams2.rightMargin = n.f(this.f15838b, R.dimen.obfuscated_res_0x7f0701be);
        this.f15843g.setLayoutParams(layoutParams2);
        int f2 = n.f(this.f15838b, R.dimen.tbds27);
        this.f15843g.setPadding(f2, 0, f2, 0);
        this.f15841e = (NoNetworkView) baseActivity.findViewById(R.id.obfuscated_res_0x7f091eed);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070266)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9)));
        this.a.addFooterView(view);
        this.a.addHeaderView(view2);
    }

    public TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15842f : (TextView) invokeV.objValue;
    }

    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15843g : (TextView) invokeV.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f15838b.getLayoutMode().k(i == 1);
            this.f15838b.getLayoutMode().j(this.f15840d);
            this.f15841e.c(this.f15838b.getPageContext(), i);
            this.f15839c.onChangeSkinType(this.f15838b.getPageContext(), i);
            SkinManager.setViewTextColor(this.f15843g, (int) R.color.navbar_btn_color);
            SkinManager.setViewTextColor(this.f15842f, (int) R.color.navi_back_text_color);
            SkinManager.setBackgroundResource(this.f15843g, R.drawable.s_navbar_button_bg);
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
                this.f15843g.setText(this.f15838b.getPageContext().getString(R.string.obfuscated_res_0x7f0f04e0));
                return;
            }
            this.f15843g.setText(this.f15838b.getPageContext().getString(R.string.obfuscated_res_0x7f0f050c));
            this.f15843g.setEnabled(!z2);
        }
    }
}
