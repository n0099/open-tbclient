package c.a.q0.v0.p1.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.s.u.c;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f26922a;

    /* renamed from: b  reason: collision with root package name */
    public View f26923b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f26924c;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26922a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (view = this.f26923b) == null) {
            return;
        }
        view.setVisibility(0);
        bdTypeRecyclerView.addHeaderView(this.f26923b);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.f26923b == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
            this.f26923b = inflate;
            this.f26924c = (EMTextView) inflate.findViewById(R.id.forum_rules_title);
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c d2 = c.d(this.f26924c);
            d2.z(R.string.F_X02);
            d2.u(R.color.CAM_X0105);
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (view = this.f26923b) == null) {
            return;
        }
        view.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f26923b);
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f26924c.setText(str);
        }
    }
}
