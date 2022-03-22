package c.a.p0.w2.r;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f20550b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f20551c;

    /* renamed from: d  reason: collision with root package name */
    public View f20552d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.w2.m.c.b f20553e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.w2.m.f.i1.j f20554f;

    public i(c.a.p0.w2.q.c cVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(cVar.x());
        c.a.p0.w2.m.c.b bVar = new c.a.p0.w2.m.c.b(cVar, bdUniqueId, this.f20551c);
        this.f20553e = bVar;
        this.f20554f = new c.a.p0.w2.m.f.i1.j(this.f20551c, bVar);
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
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d071c, (ViewGroup) null);
            this.a = linearLayout;
            this.f20550b = (EMTextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09221e);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f09171d);
            this.f20551c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f20551c.setFadingEdgeLength(0);
            this.f20551c.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f20551c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f20551c.setNestedScrollingEnabled(false);
            this.f20552d = new View(context);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f20550b, (int) R.color.CAM_X0105);
            this.f20553e.e();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f20551c.z(this.f20552d);
            this.f20552d.setLayoutParams(new ViewGroup.LayoutParams(1, i));
            this.f20551c.r(this.f20552d);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f20551c.setNestedScrollingEnabled(z);
        }
    }

    public void f(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f20554f.k(fVar);
        }
    }
}
