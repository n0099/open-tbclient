package c.a.t0.t2.z;

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
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f23696b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f23697c;

    /* renamed from: d  reason: collision with root package name */
    public View f23698d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.t2.u.c.b f23699e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.t2.u.f.c1.j f23700f;

    public i(c.a.t0.t2.y.c cVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(cVar.getPbActivity());
        c.a.t0.t2.u.c.b bVar = new c.a.t0.t2.u.c.b(cVar, bdUniqueId, this.f23697c);
        this.f23699e = bVar;
        this.f23700f = new c.a.t0.t2.u.f.c1.j(this.f23697c, bVar);
        c();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(c.a.t0.t2.j.recom_thread_info_layout, (ViewGroup) null);
            this.a = linearLayout;
            this.f23696b = (EMTextView) linearLayout.findViewById(c.a.t0.t2.i.tv_title);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.a.findViewById(c.a.t0.t2.i.pb_recom_info_list);
            this.f23697c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f23697c.setFadingEdgeLength(0);
            this.f23697c.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.t0.t2.g.M_W_X004);
            this.f23697c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f23697c.setNestedScrollingEnabled(false);
            this.f23698d = new View(context);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.a, c.a.t0.t2.f.CAM_X0204);
            SkinManager.setViewTextColor(this.f23696b, c.a.t0.t2.f.CAM_X0105);
            this.f23699e.e();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f23697c.removeFooterView(this.f23698d);
            this.f23698d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
            this.f23697c.addFooterView(this.f23698d);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f23697c.setNestedScrollingEnabled(z);
        }
    }

    public void f(c.a.t0.t2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f23700f.k(fVar);
        }
    }
}
