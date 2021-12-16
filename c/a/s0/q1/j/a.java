package c.a.s0.q1.j;

import c.a.d.m.e.n;
import c.a.s0.q1.l.o;
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
    public c f21524b;

    /* renamed from: c  reason: collision with root package name */
    public b f21525c;

    /* renamed from: d  reason: collision with root package name */
    public k f21526d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.m.e.a> f21527e;

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
        this.f21527e = new ArrayList();
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotRanklistActivity, bdTypeListView) == null) {
            this.f21524b = new c(hotRanklistActivity, c.a.s0.q1.l.c.m);
            this.f21525c = new b(hotRanklistActivity, c.a.s0.q1.l.b.f21612j);
            this.f21526d = new k(hotRanklistActivity, o.f21670k);
            this.f21527e.add(this.f21524b);
            this.f21527e.add(this.f21525c);
            this.f21527e.add(this.f21526d);
            this.a = bdTypeListView;
            bdTypeListView.addAdapters(this.f21527e);
        }
    }

    public void b(c.a.s0.q1.l.j jVar, String str) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, str) == null) {
            if (jVar.b() != null) {
                arrayList = jVar.b();
            } else {
                arrayList = new ArrayList<>();
            }
            k kVar = this.f21526d;
            if (kVar != null) {
                kVar.A0();
            }
            c cVar = this.f21524b;
            if (cVar != null) {
                cVar.n0(str);
            }
            BdTypeListView bdTypeListView = this.a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
