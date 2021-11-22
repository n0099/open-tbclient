package b.a.r0.k2.z;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f21448a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f21449b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f21450c;

    /* renamed from: d  reason: collision with root package name */
    public View f21451d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.k2.u.c.b f21452e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.k2.u.f.b1.j f21453f;

    public h(b.a.r0.k2.y.b bVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(bVar.getPbActivity());
        b.a.r0.k2.u.c.b bVar2 = new b.a.r0.k2.u.c.b(bVar, bdUniqueId, this.f21450c);
        this.f21452e = bVar2;
        this.f21453f = new b.a.r0.k2.u.f.b1.j(this.f21450c, bVar2);
        c();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21448a : (View) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(b.a.r0.k2.j.recom_thread_info_layout, (ViewGroup) null);
            this.f21448a = linearLayout;
            this.f21449b = (EMTextView) linearLayout.findViewById(b.a.r0.k2.i.tv_title);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f21448a.findViewById(b.a.r0.k2.i.pb_recom_info_list);
            this.f21450c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f21450c.setFadingEdgeLength(0);
            this.f21450c.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(b.a.r0.k2.g.M_W_X004);
            this.f21450c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f21450c.setNestedScrollingEnabled(false);
            this.f21451d = new View(context);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.f21448a, b.a.r0.k2.f.CAM_X0204);
            SkinManager.setViewTextColor(this.f21449b, b.a.r0.k2.f.CAM_X0105);
            this.f21452e.e();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f21450c.removeFooterView(this.f21451d);
            this.f21451d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
            this.f21450c.addFooterView(this.f21451d);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f21450c.setNestedScrollingEnabled(z);
        }
    }

    public void f(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f21453f.k(fVar);
        }
    }
}
