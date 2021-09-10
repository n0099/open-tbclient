package c.a.r0.i1.a;

import c.a.e.l.e.n;
import c.a.r0.i1.c.o;
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
    public BdTypeListView f19156a;

    /* renamed from: b  reason: collision with root package name */
    public c f19157b;

    /* renamed from: c  reason: collision with root package name */
    public b f19158c;

    /* renamed from: d  reason: collision with root package name */
    public k f19159d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.l.e.a> f19160e;

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
        this.f19160e = new ArrayList();
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotRanklistActivity, bdTypeListView) == null) {
            this.f19157b = new c(hotRanklistActivity, c.a.r0.i1.c.c.m);
            this.f19158c = new b(hotRanklistActivity, c.a.r0.i1.c.b.f19257j);
            this.f19159d = new k(hotRanklistActivity, o.k);
            this.f19160e.add(this.f19157b);
            this.f19160e.add(this.f19158c);
            this.f19160e.add(this.f19159d);
            this.f19156a = bdTypeListView;
            bdTypeListView.addAdapters(this.f19160e);
        }
    }

    public void b(c.a.r0.i1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, str) == null) {
            if (jVar.b() != null) {
                arrayList = jVar.b();
            } else {
                arrayList = new ArrayList<>();
            }
            k kVar = this.f19159d;
            if (kVar != null) {
                kVar.B0();
            }
            c cVar = this.f19157b;
            if (cVar != null) {
                cVar.o0(str);
            }
            BdTypeListView bdTypeListView = this.f19156a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
