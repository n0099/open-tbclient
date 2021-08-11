package c.a.p0.r2.n;

import c.a.e.e.p.k;
import c.a.e.k.e.n;
import c.a.p0.m2.e;
import c.a.p0.n2.c.i;
import c.a.p0.n2.c.j;
import c.a.p0.n2.d.c;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f23844a;

    /* renamed from: b  reason: collision with root package name */
    public j f23845b;

    /* renamed from: c  reason: collision with root package name */
    public c f23846c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.k.e.a> f23847d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f23848e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f23849f;

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
        this.f23847d = new ArrayList();
        this.f23848e = new ArrayList<>();
        this.f23849f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f23844a = new i(tbPageContext);
            this.f23845b = new j(tbPageContext, c.a.p0.n2.e.j.f22309f);
            e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
            this.f23846c = eVar;
            this.f23845b.j0(eVar);
            this.f23847d.add(this.f23844a);
            this.f23847d.add(this.f23845b);
            this.f23849f.addAdapters(this.f23847d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f23849f.getAdapter2() instanceof c.a.e.k.e.e)) {
            this.f23849f.getAdapter2().notifyDataSetChanged();
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
            if (this.f23849f != null && (arrayList = this.f23848e) != null) {
                Iterator<n> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f49767f)) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f23848e);
                    this.f23848e = mergeDynamicThreadByTime;
                    this.f23849f.setData(mergeDynamicThreadByTime);
                    b();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || this.f23849f == null) {
            return;
        }
        this.f23848e.clear();
        this.f23848e.addAll(arrayList);
        this.f23849f.setData(this.f23848e);
    }

    public void e() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f23849f) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }
}
