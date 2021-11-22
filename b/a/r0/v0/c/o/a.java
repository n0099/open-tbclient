package b.a.r0.v0.c.o;

import b.a.e.m.e.e;
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
    public List<b.a.e.m.e.a> f25758a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25759b;

    /* renamed from: c  reason: collision with root package name */
    public k f25760c;

    /* renamed from: d  reason: collision with root package name */
    public m f25761d;

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
        this.f25758a = arrayList;
        this.f25759b = bdTypeListView;
        arrayList.add(new g(baseActivity.getPageContext(), h.f25739h));
        this.f25758a.add(new i(baseActivity.getPageContext(), j.f25744g));
        this.f25758a.add(new f(baseActivity.getPageContext(), n.f27580g));
        this.f25758a.add(new b.a.r0.v0.b.a(baseActivity.getPageContext(), b.a.r0.v0.b.b.f25715f));
        this.f25758a.add(new c(baseActivity.getPageContext(), d.k));
        this.f25758a.add(new b.a.r0.v0.c.a(baseActivity.getPageContext()));
        k kVar = new k(baseActivity.getPageContext(), l.f25748i);
        this.f25760c = kVar;
        this.f25758a.add(kVar);
        m mVar = new m(baseActivity.getPageContext(), b.a.r0.v0.c.n.f25754h);
        this.f25761d = mVar;
        this.f25758a.add(mVar);
    }

    public List<b.a.e.m.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25758a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f25759b) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f25759b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25760c.onDestroy();
            this.f25761d.onDestroy();
        }
    }
}
