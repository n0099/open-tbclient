package c.a.p0.h1.a;

import c.a.e.k.e.n;
import c.a.p0.h1.c.o;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f18167a;

    /* renamed from: b  reason: collision with root package name */
    public c f18168b;

    /* renamed from: c  reason: collision with root package name */
    public b f18169c;

    /* renamed from: d  reason: collision with root package name */
    public k f18170d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.k.e.a> f18171e;

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotRanklistActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18171e = new ArrayList();
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotRanklistActivity, bdTypeListView) == null) {
            this.f18168b = new c(hotRanklistActivity, c.a.p0.h1.c.c.m);
            this.f18169c = new b(hotRanklistActivity, c.a.p0.h1.c.b.f18268j);
            this.f18170d = new k(hotRanklistActivity, o.k);
            this.f18171e.add(this.f18168b);
            this.f18171e.add(this.f18169c);
            this.f18171e.add(this.f18170d);
            this.f18167a = bdTypeListView;
            bdTypeListView.addAdapters(this.f18171e);
        }
    }

    public void b(c.a.p0.h1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, str) == null) {
            if (jVar.b() != null) {
                arrayList = jVar.b();
            } else {
                arrayList = new ArrayList<>();
            }
            k kVar = this.f18170d;
            if (kVar != null) {
                kVar.B0();
            }
            c cVar = this.f18168b;
            if (cVar != null) {
                cVar.o0(str);
            }
            BdTypeListView bdTypeListView = this.f18167a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
