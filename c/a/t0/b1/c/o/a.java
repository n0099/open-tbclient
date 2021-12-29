package c.a.t0.b1.c.o;

import c.a.d.n.e.e;
import c.a.t0.b1.b.c;
import c.a.t0.b1.b.d;
import c.a.t0.b1.c.f;
import c.a.t0.b1.c.g;
import c.a.t0.b1.c.h;
import c.a.t0.b1.c.i;
import c.a.t0.b1.c.j;
import c.a.t0.b1.c.k;
import c.a.t0.b1.c.l;
import c.a.t0.b1.c.m;
import c.a.t0.d1.n;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.d.n.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f15554b;

    /* renamed from: c  reason: collision with root package name */
    public k f15555c;

    /* renamed from: d  reason: collision with root package name */
    public m f15556d;

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
        this.f15554b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f15535h));
        this.a.add(new i(baseActivity.getPageContext(), j.f15540g));
        this.a.add(new f(baseActivity.getPageContext(), n.f16631g));
        this.a.add(new c.a.t0.b1.b.a(baseActivity.getPageContext(), c.a.t0.b1.b.b.f15513f));
        this.a.add(new c(baseActivity.getPageContext(), d.f15516k));
        this.a.add(new c.a.t0.b1.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f15544i);
        this.f15555c = kVar;
        this.a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), c.a.t0.b1.c.n.f15550h);
        this.f15556d = mVar;
        this.a.add(mVar);
    }

    public List<c.a.d.n.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f15554b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f15554b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15555c.onDestroy();
            this.f15556d.onDestroy();
        }
    }
}
