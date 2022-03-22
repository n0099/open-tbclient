package c.a.p0.c1.c.o;

import c.a.d.o.e.e;
import c.a.p0.c1.b.c;
import c.a.p0.c1.b.d;
import c.a.p0.c1.c.f;
import c.a.p0.c1.c.g;
import c.a.p0.c1.c.h;
import c.a.p0.c1.c.i;
import c.a.p0.c1.c.j;
import c.a.p0.c1.c.k;
import c.a.p0.c1.c.l;
import c.a.p0.c1.c.m;
import c.a.p0.f1.n;
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
    public BdTypeListView f13431b;

    /* renamed from: c  reason: collision with root package name */
    public k f13432c;

    /* renamed from: d  reason: collision with root package name */
    public m f13433d;

    public a(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.f13431b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f13419d));
        this.a.add(new i(baseActivity.getPageContext(), j.f13422c));
        this.a.add(new f(baseActivity.getPageContext(), n.f14248c));
        this.a.add(new c.a.p0.c1.b.a(baseActivity.getPageContext(), c.a.p0.c1.b.b.f13403b));
        this.a.add(new c(baseActivity.getPageContext(), d.f13404g));
        this.a.add(new c.a.p0.c1.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f13424e);
        this.f13432c = kVar;
        this.a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), c.a.p0.c1.c.n.f13428d);
        this.f13433d = mVar;
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f13431b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f13431b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13432c.onDestroy();
            this.f13433d.onDestroy();
        }
    }
}
