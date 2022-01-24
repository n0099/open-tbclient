package c.a.t0.e3.n;

import c.a.d.f.p.m;
import c.a.d.n.e.e;
import c.a.d.n.e.n;
import c.a.t0.x2.f;
import c.a.t0.y2.c.i;
import c.a.t0.y2.c.j;
import c.a.t0.y2.d.c;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public j f17434b;

    /* renamed from: c  reason: collision with root package name */
    public c f17435c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.n.e.a> f17436d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f17437e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f17438f;

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
        this.f17436d = new ArrayList();
        this.f17437e = new ArrayList<>();
        this.f17438f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.a = new i(tbPageContext);
            this.f17434b = new j(tbPageContext, c.a.t0.y2.e.j.f25719f);
            f fVar = new f(tbPageContext, this, tbPageContext.getUniqueId());
            this.f17435c = fVar;
            this.f17434b.b0(fVar);
            this.f17436d.add(this.a);
            this.f17436d.add(this.f17434b);
            this.f17438f.addAdapters(this.f17436d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f17438f.getAdapter2() instanceof e)) {
            this.f17438f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = false;
            if (m.isEmpty(str)) {
                return false;
            }
            if (this.f17438f != null && (arrayList = this.f17437e) != null) {
                Iterator<n> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f42383f)) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f17437e);
                    this.f17437e = mergeDynamicThreadByTime;
                    this.f17438f.setData(mergeDynamicThreadByTime);
                    b();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || this.f17438f == null) {
            return;
        }
        this.f17437e.clear();
        this.f17437e.addAll(arrayList);
        this.f17438f.setData(this.f17437e);
    }

    public void e() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f17438f) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }
}
