package c.a.r0.u0.c.o;

import c.a.e.l.e.e;
import c.a.r0.u0.b.c;
import c.a.r0.u0.b.d;
import c.a.r0.u0.c.f;
import c.a.r0.u0.c.g;
import c.a.r0.u0.c.h;
import c.a.r0.u0.c.i;
import c.a.r0.u0.c.j;
import c.a.r0.u0.c.k;
import c.a.r0.u0.c.l;
import c.a.r0.u0.c.m;
import c.a.r0.w0.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25266a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25267b;

    /* renamed from: c  reason: collision with root package name */
    public k f25268c;

    /* renamed from: d  reason: collision with root package name */
    public m f25269d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.f25266a = arrayList;
        this.f25267b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f25247h));
        this.f25266a.add(new i(baseActivity.getPageContext(), j.f25252g));
        this.f25266a.add(new f(baseActivity.getPageContext(), n.f27141g));
        this.f25266a.add(new c.a.r0.u0.b.a(baseActivity.getPageContext(), c.a.r0.u0.b.b.f25221f));
        this.f25266a.add(new c(baseActivity.getPageContext(), d.k));
        this.f25266a.add(new c.a.r0.u0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f25256i);
        this.f25268c = kVar;
        this.f25266a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), c.a.r0.u0.c.n.f25262h);
        this.f25269d = mVar;
        this.f25266a.add(mVar);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25266a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f25267b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f25267b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25268c.onDestroy();
            this.f25269d.onDestroy();
        }
    }
}
