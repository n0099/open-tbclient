package c.a.p0.t0.c.o;

import c.a.e.k.e.e;
import c.a.p0.t0.b.c;
import c.a.p0.t0.b.d;
import c.a.p0.t0.c.f;
import c.a.p0.t0.c.g;
import c.a.p0.t0.c.h;
import c.a.p0.t0.c.i;
import c.a.p0.t0.c.j;
import c.a.p0.t0.c.k;
import c.a.p0.t0.c.l;
import c.a.p0.t0.c.m;
import c.a.p0.v0.n;
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
    public List<c.a.e.k.e.a> f24251a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24252b;

    /* renamed from: c  reason: collision with root package name */
    public k f24253c;

    /* renamed from: d  reason: collision with root package name */
    public m f24254d;

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
        this.f24251a = arrayList;
        this.f24252b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f24232h));
        this.f24251a.add(new i(baseActivity.getPageContext(), j.f24237g));
        this.f24251a.add(new f(baseActivity.getPageContext(), n.f26291g));
        this.f24251a.add(new c.a.p0.t0.b.a(baseActivity.getPageContext(), c.a.p0.t0.b.b.f24206f));
        this.f24251a.add(new c(baseActivity.getPageContext(), d.k));
        this.f24251a.add(new c.a.p0.t0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f24241i);
        this.f24253c = kVar;
        this.f24251a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), c.a.p0.t0.c.n.f24247h);
        this.f24254d = mVar;
        this.f24251a.add(mVar);
    }

    public List<c.a.e.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24251a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f24252b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f24252b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24253c.onDestroy();
            this.f24254d.onDestroy();
        }
    }
}
