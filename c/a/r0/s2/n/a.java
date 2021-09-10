package c.a.r0.s2.n;

import c.a.e.e.p.k;
import c.a.e.l.e.e;
import c.a.e.l.e.n;
import c.a.r0.n2.f;
import c.a.r0.o2.c.i;
import c.a.r0.o2.c.j;
import c.a.r0.o2.d.c;
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
    public i f24809a;

    /* renamed from: b  reason: collision with root package name */
    public j f24810b;

    /* renamed from: c  reason: collision with root package name */
    public c f24811c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f24812d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f24813e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f24814f;

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
        this.f24812d = new ArrayList();
        this.f24813e = new ArrayList<>();
        this.f24814f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f24809a = new i(tbPageContext);
            this.f24810b = new j(tbPageContext, c.a.r0.o2.e.j.f23220f);
            f fVar = new f(tbPageContext, this, tbPageContext.getUniqueId());
            this.f24811c = fVar;
            this.f24810b.j0(fVar);
            this.f24812d.add(this.f24809a);
            this.f24812d.add(this.f24810b);
            this.f24814f.addAdapters(this.f24812d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f24814f.getAdapter2() instanceof e)) {
            this.f24814f.getAdapter2().notifyDataSetChanged();
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
            if (this.f24814f != null && (arrayList = this.f24813e) != null) {
                Iterator<n> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f50010f)) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f24813e);
                    this.f24813e = mergeDynamicThreadByTime;
                    this.f24814f.setData(mergeDynamicThreadByTime);
                    b();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || this.f24814f == null) {
            return;
        }
        this.f24813e.clear();
        this.f24813e.addAll(arrayList);
        this.f24814f.setData(this.f24813e);
    }

    public void e() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f24814f) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }
}
