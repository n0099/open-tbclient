package c.a.t0.s2.z;

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
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f24089b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f24090c;

    /* renamed from: d  reason: collision with root package name */
    public View f24091d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.s2.u.c.b f24092e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.s2.u.f.b1.j f24093f;

    public h(c.a.t0.s2.y.b bVar, BdUniqueId bdUniqueId) {
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
        c.a.t0.s2.u.c.b bVar2 = new c.a.t0.s2.u.c.b(bVar, bdUniqueId, this.f24090c);
        this.f24092e = bVar2;
        this.f24093f = new c.a.t0.s2.u.f.b1.j(this.f24090c, bVar2);
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
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(c.a.t0.s2.j.recom_thread_info_layout, (ViewGroup) null);
            this.a = linearLayout;
            this.f24089b = (EMTextView) linearLayout.findViewById(c.a.t0.s2.i.tv_title);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.a.findViewById(c.a.t0.s2.i.pb_recom_info_list);
            this.f24090c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f24090c.setFadingEdgeLength(0);
            this.f24090c.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.t0.s2.g.M_W_X004);
            this.f24090c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f24090c.setNestedScrollingEnabled(false);
            this.f24091d = new View(context);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.a, c.a.t0.s2.f.CAM_X0204);
            SkinManager.setViewTextColor(this.f24089b, c.a.t0.s2.f.CAM_X0105);
            this.f24092e.e();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f24090c.removeFooterView(this.f24091d);
            this.f24091d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
            this.f24090c.addFooterView(this.f24091d);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f24090c.setNestedScrollingEnabled(z);
        }
    }

    public void f(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f24093f.k(fVar);
        }
    }
}
