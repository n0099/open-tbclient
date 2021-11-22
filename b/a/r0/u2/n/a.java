package b.a.r0.u2.n;

import b.a.e.f.p.k;
import b.a.e.m.e.e;
import b.a.e.m.e.n;
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
    public i f25559a;

    /* renamed from: b  reason: collision with root package name */
    public j f25560b;

    /* renamed from: c  reason: collision with root package name */
    public c f25561c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.m.e.a> f25562d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f25563e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f25564f;

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
        this.f25562d = new ArrayList();
        this.f25563e = new ArrayList<>();
        this.f25564f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f25559a = new i(tbPageContext);
            this.f25560b = new j(tbPageContext, b.a.r0.p2.e.j.f23786f);
            f fVar = new f(tbPageContext, this, tbPageContext.getUniqueId());
            this.f25561c = fVar;
            this.f25560b.i0(fVar);
            this.f25562d.add(this.f25559a);
            this.f25562d.add(this.f25560b);
            this.f25564f.addAdapters(this.f25562d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f25564f.getAdapter2() instanceof e)) {
            this.f25564f.getAdapter2().notifyDataSetChanged();
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
            if (this.f25564f != null && (arrayList = this.f25563e) != null) {
                Iterator<n> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f48320f)) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f25563e);
                    this.f25563e = mergeDynamicThreadByTime;
                    this.f25564f.setData(mergeDynamicThreadByTime);
                    b();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || this.f25564f == null) {
            return;
        }
        this.f25563e.clear();
        this.f25563e.addAll(arrayList);
        this.f25564f.setData(this.f25563e);
    }

    public void e() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f25564f) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }
}
