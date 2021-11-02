package b.a.r0.j1.j;

import b.a.e.l.e.n;
import b.a.r0.j1.l.o;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f18330a;

    /* renamed from: b  reason: collision with root package name */
    public c f18331b;

    /* renamed from: c  reason: collision with root package name */
    public b f18332c;

    /* renamed from: d  reason: collision with root package name */
    public k f18333d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.e.l.e.a> f18334e;

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
        this.f18334e = new ArrayList();
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotRanklistActivity, bdTypeListView) == null) {
            this.f18331b = new c(hotRanklistActivity, b.a.r0.j1.l.c.m);
            this.f18332c = new b(hotRanklistActivity, b.a.r0.j1.l.b.j);
            this.f18333d = new k(hotRanklistActivity, o.k);
            this.f18334e.add(this.f18331b);
            this.f18334e.add(this.f18332c);
            this.f18334e.add(this.f18333d);
            this.f18330a = bdTypeListView;
            bdTypeListView.addAdapters(this.f18334e);
        }
    }

    public void b(b.a.r0.j1.l.j jVar, String str) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, str) == null) {
            if (jVar.b() != null) {
                arrayList = jVar.b();
            } else {
                arrayList = new ArrayList<>();
            }
            k kVar = this.f18333d;
            if (kVar != null) {
                kVar.A0();
            }
            c cVar = this.f18331b;
            if (cVar != null) {
                cVar.n0(str);
            }
            BdTypeListView bdTypeListView = this.f18330a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
