package c.a.r0.b1.c.o;

import c.a.d.o.e.e;
import c.a.r0.b1.b.c;
import c.a.r0.b1.b.d;
import c.a.r0.b1.c.f;
import c.a.r0.b1.c.g;
import c.a.r0.b1.c.h;
import c.a.r0.b1.c.i;
import c.a.r0.b1.c.j;
import c.a.r0.b1.c.k;
import c.a.r0.b1.c.l;
import c.a.r0.b1.c.m;
import c.a.r0.d1.n;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.d.o.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f15129b;

    /* renamed from: c  reason: collision with root package name */
    public k f15130c;

    /* renamed from: d  reason: collision with root package name */
    public m f15131d;

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
        this.a = arrayList;
        this.f15129b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f15110h));
        this.a.add(new i(baseActivity.getPageContext(), j.f15115g));
        this.a.add(new f(baseActivity.getPageContext(), n.f15854g));
        this.a.add(new c.a.r0.b1.b.a(baseActivity.getPageContext(), c.a.r0.b1.b.b.f15090f));
        this.a.add(new c(baseActivity.getPageContext(), d.k));
        this.a.add(new c.a.r0.b1.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f15119i);
        this.f15130c = kVar;
        this.a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), c.a.r0.b1.c.n.f15125h);
        this.f15131d = mVar;
        this.a.add(mVar);
    }

    public List<c.a.d.o.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f15129b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f15129b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15130c.onDestroy();
            this.f15131d.onDestroy();
        }
    }
}
