package c.a.t0.q1.j;

import c.a.d.n.e.n;
import c.a.t0.q1.l.o;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeListView a;

    /* renamed from: b  reason: collision with root package name */
    public c f21439b;

    /* renamed from: c  reason: collision with root package name */
    public b f21440c;

    /* renamed from: d  reason: collision with root package name */
    public k f21441d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.n.e.a> f21442e;

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
        this.f21442e = new ArrayList();
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotRanklistActivity, bdTypeListView) == null) {
            this.f21439b = new c(hotRanklistActivity, c.a.t0.q1.l.c.m);
            this.f21440c = new b(hotRanklistActivity, c.a.t0.q1.l.b.f21522j);
            this.f21441d = new k(hotRanklistActivity, o.k);
            this.f21442e.add(this.f21439b);
            this.f21442e.add(this.f21440c);
            this.f21442e.add(this.f21441d);
            this.a = bdTypeListView;
            bdTypeListView.addAdapters(this.f21442e);
        }
    }

    public void b(c.a.t0.q1.l.j jVar, String str) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, str) == null) {
            if (jVar.b() != null) {
                arrayList = jVar.b();
            } else {
                arrayList = new ArrayList<>();
            }
            k kVar = this.f21441d;
            if (kVar != null) {
                kVar.t0();
            }
            c cVar = this.f21439b;
            if (cVar != null) {
                cVar.g0(str);
            }
            BdTypeListView bdTypeListView = this.a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
