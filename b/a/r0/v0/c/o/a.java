package b.a.r0.v0.c.o;

import b.a.e.l.e.e;
import b.a.r0.v0.b.c;
import b.a.r0.v0.b.d;
import b.a.r0.v0.c.f;
import b.a.r0.v0.c.g;
import b.a.r0.v0.c.h;
import b.a.r0.v0.c.i;
import b.a.r0.v0.c.j;
import b.a.r0.v0.c.k;
import b.a.r0.v0.c.l;
import b.a.r0.v0.c.m;
import b.a.r0.x0.n;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.e.l.e.a> f24295a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24296b;

    /* renamed from: c  reason: collision with root package name */
    public k f24297c;

    /* renamed from: d  reason: collision with root package name */
    public m f24298d;

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
        this.f24295a = arrayList;
        this.f24296b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f24276h));
        this.f24295a.add(new i(baseActivity.getPageContext(), j.f24281g));
        this.f24295a.add(new f(baseActivity.getPageContext(), n.f25994g));
        this.f24295a.add(new b.a.r0.v0.b.a(baseActivity.getPageContext(), b.a.r0.v0.b.b.f24252f));
        this.f24295a.add(new c(baseActivity.getPageContext(), d.k));
        this.f24295a.add(new b.a.r0.v0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f24285i);
        this.f24297c = kVar;
        this.f24295a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), b.a.r0.v0.c.n.f24291h);
        this.f24298d = mVar;
        this.f24295a.add(mVar);
    }

    public List<b.a.e.l.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24295a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f24296b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f24296b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24297c.onDestroy();
            this.f24298d.onDestroy();
        }
    }
}
