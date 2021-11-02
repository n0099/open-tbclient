package b.a.r0.t2.n;

import b.a.e.e.p.k;
import b.a.e.l.e.e;
import b.a.e.l.e.n;
import b.a.r0.o2.f;
import b.a.r0.p2.c.i;
import b.a.r0.p2.c.j;
import b.a.r0.p2.d.c;
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

    /* renamed from: a  reason: collision with root package name */
    public i f23843a;

    /* renamed from: b  reason: collision with root package name */
    public j f23844b;

    /* renamed from: c  reason: collision with root package name */
    public c f23845c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.l.e.a> f23846d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f23847e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f23848f;

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
        this.f23846d = new ArrayList();
        this.f23847e = new ArrayList<>();
        this.f23848f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f23843a = new i(tbPageContext);
            this.f23844b = new j(tbPageContext, b.a.r0.p2.e.j.f22309f);
            f fVar = new f(tbPageContext, this, tbPageContext.getUniqueId());
            this.f23845c = fVar;
            this.f23844b.i0(fVar);
            this.f23846d.add(this.f23843a);
            this.f23846d.add(this.f23844b);
            this.f23848f.addAdapters(this.f23846d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f23848f.getAdapter2() instanceof e)) {
            this.f23848f.getAdapter2().notifyDataSetChanged();
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
            if (this.f23848f != null && (arrayList = this.f23847e) != null) {
                Iterator<n> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f47457f)) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f23847e);
                    this.f23847e = mergeDynamicThreadByTime;
                    this.f23848f.setData(mergeDynamicThreadByTime);
                    b();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || this.f23848f == null) {
            return;
        }
        this.f23847e.clear();
        this.f23847e.addAll(arrayList);
        this.f23848f.setData(this.f23847e);
    }

    public void e() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f23848f) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }
}
