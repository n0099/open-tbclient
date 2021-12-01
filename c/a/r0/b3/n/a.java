package c.a.r0.b3.n;

import c.a.d.f.p.k;
import c.a.d.m.e.e;
import c.a.d.m.e.n;
import c.a.r0.u2.f;
import c.a.r0.v2.c.i;
import c.a.r0.v2.c.j;
import c.a.r0.v2.d.c;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public j f14922b;

    /* renamed from: c  reason: collision with root package name */
    public c f14923c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.m.e.a> f14924d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f14925e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f14926f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14924d = new ArrayList();
        this.f14925e = new ArrayList<>();
        this.f14926f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.a = new i(tbPageContext);
            this.f14922b = new j(tbPageContext, c.a.r0.v2.e.j.f24806f);
            f fVar = new f(tbPageContext, this, tbPageContext.getUniqueId());
            this.f14923c = fVar;
            this.f14922b.i0(fVar);
            this.f14924d.add(this.a);
            this.f14924d.add(this.f14922b);
            this.f14926f.addAdapters(this.f14924d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f14926f.getAdapter2() instanceof e)) {
            this.f14926f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = false;
            if (k.isEmpty(str)) {
                return false;
            }
            if (this.f14926f != null && (arrayList = this.f14925e) != null) {
                Iterator<n> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f43287f)) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f14925e);
                    this.f14925e = mergeDynamicThreadByTime;
                    this.f14926f.setData(mergeDynamicThreadByTime);
                    b();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || this.f14926f == null) {
            return;
        }
        this.f14925e.clear();
        this.f14925e.addAll(arrayList);
        this.f14926f.setData(this.f14925e);
    }

    public void e() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f14926f) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }
}
