package c.a.r0.q2.z;

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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f22570b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f22571c;

    /* renamed from: d  reason: collision with root package name */
    public View f22572d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.q2.u.c.b f22573e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.q2.u.f.b1.j f22574f;

    public h(c.a.r0.q2.y.b bVar, BdUniqueId bdUniqueId) {
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
        c.a.r0.q2.u.c.b bVar2 = new c.a.r0.q2.u.c.b(bVar, bdUniqueId, this.f22571c);
        this.f22573e = bVar2;
        this.f22574f = new c.a.r0.q2.u.f.b1.j(this.f22571c, bVar2);
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
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(c.a.r0.q2.j.recom_thread_info_layout, (ViewGroup) null);
            this.a = linearLayout;
            this.f22570b = (EMTextView) linearLayout.findViewById(c.a.r0.q2.i.tv_title);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.a.findViewById(c.a.r0.q2.i.pb_recom_info_list);
            this.f22571c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f22571c.setFadingEdgeLength(0);
            this.f22571c.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.r0.q2.g.M_W_X004);
            this.f22571c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f22571c.setNestedScrollingEnabled(false);
            this.f22572d = new View(context);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.a, c.a.r0.q2.f.CAM_X0204);
            SkinManager.setViewTextColor(this.f22570b, c.a.r0.q2.f.CAM_X0105);
            this.f22573e.e();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f22571c.removeFooterView(this.f22572d);
            this.f22572d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
            this.f22571c.addFooterView(this.f22572d);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f22571c.setNestedScrollingEnabled(z);
        }
    }

    public void f(c.a.r0.q2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f22574f.k(fVar);
        }
    }
}
