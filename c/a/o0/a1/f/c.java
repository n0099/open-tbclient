package c.a.o0.a1.f;

import android.text.TextUtils;
import c.a.d.o.e.n;
import c.a.o0.r.r.a2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f9788b;

    /* renamed from: c  reason: collision with root package name */
    public final List<n> f9789c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f9790d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f9791e;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c cVar = this.a;
                cVar.c(cVar.f9788b, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c cVar = this.a;
                cVar.c(cVar.f9788b, customResponsedMessage);
            }
        }
    }

    public c(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9789c = new ArrayList();
        this.f9790d = new a(this, 2016488);
        this.f9791e = new b(this, 2016553);
        this.f9788b = bdTypeRecyclerView;
    }

    public final void c(BdTypeRecyclerView bdTypeRecyclerView, CustomResponsedMessage<?> customResponsedMessage) {
        a2 a2Var;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bdTypeRecyclerView, customResponsedMessage) == null) || bdTypeRecyclerView == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("tid");
        if (StringUtils.isNull(optString)) {
            String optString2 = jSONObject.optString("liveid");
            if (bdTypeRecyclerView != null && !TextUtils.isEmpty(optString2)) {
                int i = 0;
                while (true) {
                    if (i >= bdTypeRecyclerView.getCount()) {
                        break;
                    }
                    n C = bdTypeRecyclerView.C(i);
                    if (C instanceof c.a.o0.r.r.a) {
                        c.a.o0.r.r.a aVar = (c.a.o0.r.r.a) C;
                        if (aVar.getThreadData() != null && aVar.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(aVar.getThreadData().getThreadAlaInfo().live_id))) {
                            optString = aVar.getThreadData().getTid();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        if (StringUtils.isNull(optString)) {
            return;
        }
        Iterator<n> it = this.f9789c.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof c.a.o0.r.r.a) && (threadData2 = ((c.a.o0.r.r.a) next).getThreadData()) != null && !TextUtils.isEmpty(threadData2.getTid()) && optString.equals(threadData2.getTid())) {
                it.remove();
            }
        }
        List<n> data = bdTypeRecyclerView.getData();
        if (ListUtils.isEmpty(data)) {
            return;
        }
        Iterator<n> it2 = data.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (it2.hasNext()) {
            n next2 = it2.next();
            if ((next2 instanceof a2) && (threadData = (a2Var = (a2) next2).s) != null) {
                if (i2 >= 0) {
                    if (a2Var.position != i2) {
                        break;
                    }
                    it2.remove();
                    i4 = i5;
                } else if (StringHelper.equals(optString, threadData.getTid())) {
                    i2 = a2Var.position;
                    it2.remove();
                    i3 = i5;
                }
            }
            i5++;
        }
        if (i3 < i4) {
            bdTypeRecyclerView.F(i3, i4);
        }
    }

    public c.a.o0.a1.d.d d(LoadType loadType, c.a.o0.a1.e.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadType, aVar)) == null) {
            if (aVar == null) {
                c.a.o0.a1.d.d dVar = new c.a.o0.a1.d.d();
                dVar.a = null;
                return dVar;
            }
            List<ThreadData> f2 = aVar.f();
            List<c.a.o0.r.r.a> e2 = aVar.e();
            aVar.h(f2);
            c.a.o0.a1.h.a.b("response threadList =  " + ListUtils.getCount(f2));
            if (!ListUtils.isEmpty(f2)) {
                if (loadType == LoadType.REFRESH) {
                    this.f9789c.clear();
                    this.f9789c.addAll(f2);
                } else if (loadType == LoadType.PREPEND) {
                    this.f9789c.addAll(0, f2);
                } else {
                    this.f9789c.addAll(f2);
                }
            }
            ArrayList arrayList = new ArrayList(ListUtils.getCount(this.f9789c) + ListUtils.getCount(e2));
            arrayList.addAll(this.f9789c);
            c.a.o0.a1.h.a.b("dataList = " + ListUtils.getCount(arrayList));
            c.a.o0.a1.h.a.b("floorList = " + ListUtils.getCount(e2));
            if (!ListUtils.isEmpty(e2)) {
                for (c.a.o0.r.r.a aVar2 : e2) {
                    c.a.o0.a1.h.b.b(arrayList, aVar2);
                }
            }
            List<n> d2 = aVar.d(arrayList);
            if (d2 == null) {
                d2 = c.a.o0.a1.h.b.a(arrayList);
            }
            int count = ListUtils.getCount(d2);
            int count2 = ListUtils.getCount(f2);
            c.a.o0.a1.h.a.b("addThreadCount=" + count2 + ",resultThreadList=" + count);
            c.a.o0.a1.d.d dVar2 = new c.a.o0.a1.d.d();
            dVar2.a = d2;
            aVar.g(dVar2);
            return dVar2;
        }
        return (c.a.o0.a1.d.d) invokeLL.objValue;
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            if (this.a != bdUniqueId) {
                this.f9790d.setTag(bdUniqueId);
                this.f9791e.setTag(bdUniqueId);
                MessageManager.getInstance().unRegisterListener(this.f9790d);
                MessageManager.getInstance().unRegisterListener(this.f9791e);
                MessageManager.getInstance().registerListener(this.f9790d);
                MessageManager.getInstance().registerListener(this.f9791e);
            }
            this.a = bdUniqueId;
        }
    }
}
