package c.a.p0.f3.n;

import c.a.d.f.p.m;
import c.a.d.o.e.e;
import c.a.d.o.e.n;
import c.a.p0.a3.f;
import c.a.p0.b3.c.i;
import c.a.p0.b3.c.j;
import c.a.p0.b3.d.c;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public j f14975b;

    /* renamed from: c  reason: collision with root package name */
    public c f14976c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f14977d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f14978e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f14979f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14977d = new ArrayList();
        this.f14978e = new ArrayList<>();
        this.f14979f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.a = new i(tbPageContext);
            this.f14975b = new j(tbPageContext, c.a.p0.b3.e.j.f12729b);
            f fVar = new f(tbPageContext, this, tbPageContext.getUniqueId());
            this.f14976c = fVar;
            this.f14975b.b0(fVar);
            this.f14977d.add(this.a);
            this.f14977d.add(this.f14975b);
            this.f14979f.a(this.f14977d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f14979f.getAdapter2() instanceof e)) {
            this.f14979f.getAdapter2().notifyDataSetChanged();
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
            if (this.f14979f != null && (arrayList = this.f14978e) != null) {
                Iterator<n> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f31670b)) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f14978e);
                    this.f14978e = mergeDynamicThreadByTime;
                    this.f14979f.setData(mergeDynamicThreadByTime);
                    b();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || this.f14979f == null) {
            return;
        }
        this.f14978e.clear();
        this.f14978e.addAll(arrayList);
        this.f14979f.setData(this.f14978e);
    }

    public void e() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f14979f) == null) {
            return;
        }
        bdTypeListView.F();
    }
}
