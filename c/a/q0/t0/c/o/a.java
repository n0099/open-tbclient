package c.a.q0.t0.c.o;

import c.a.e.l.e.e;
import c.a.q0.t0.b.c;
import c.a.q0.t0.b.d;
import c.a.q0.t0.c.f;
import c.a.q0.t0.c.g;
import c.a.q0.t0.c.h;
import c.a.q0.t0.c.i;
import c.a.q0.t0.c.j;
import c.a.q0.t0.c.k;
import c.a.q0.t0.c.l;
import c.a.q0.t0.c.m;
import c.a.q0.v0.n;
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
    public List<c.a.e.l.e.a> f24584a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24585b;

    /* renamed from: c  reason: collision with root package name */
    public k f24586c;

    /* renamed from: d  reason: collision with root package name */
    public m f24587d;

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
        this.f24584a = arrayList;
        this.f24585b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f24565h));
        this.f24584a.add(new i(baseActivity.getPageContext(), j.f24570g));
        this.f24584a.add(new f(baseActivity.getPageContext(), n.f26660g));
        this.f24584a.add(new c.a.q0.t0.b.a(baseActivity.getPageContext(), c.a.q0.t0.b.b.f24539f));
        this.f24584a.add(new c(baseActivity.getPageContext(), d.k));
        this.f24584a.add(new c.a.q0.t0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f24574i);
        this.f24586c = kVar;
        this.f24584a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), c.a.q0.t0.c.n.f24580h);
        this.f24587d = mVar;
        this.f24584a.add(mVar);
    }

    public List<c.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24584a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f24585b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f24585b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24586c.onDestroy();
            this.f24587d.onDestroy();
        }
    }
}
