package c.a.r0.j2.p;

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
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f20764a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f20765b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f20766c;

    /* renamed from: d  reason: collision with root package name */
    public View f20767d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.j2.k.c.b f20768e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.j2.k.e.a1.j f20769f;

    public h(c.a.r0.j2.o.b bVar, BdUniqueId bdUniqueId) {
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
        c.a.r0.j2.k.c.b bVar2 = new c.a.r0.j2.k.c.b(bVar, bdUniqueId, this.f20766c);
        this.f20768e = bVar2;
        this.f20769f = new c.a.r0.j2.k.e.a1.j(this.f20766c, bVar2);
        c();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20764a : (View) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
            this.f20764a = linearLayout;
            this.f20765b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f20764a.findViewById(R.id.pb_recom_info_list);
            this.f20766c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f20766c.setFadingEdgeLength(0);
            this.f20766c.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f20766c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f20766c.setNestedScrollingEnabled(false);
            this.f20767d = new View(context);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.f20764a, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f20765b, R.color.CAM_X0105);
            this.f20768e.e();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f20766c.removeFooterView(this.f20767d);
            this.f20767d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
            this.f20766c.addFooterView(this.f20767d);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f20766c.setNestedScrollingEnabled(z);
        }
    }

    public void f(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.f20769f.k(eVar);
        }
    }
}
