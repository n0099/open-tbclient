package c.a.p0.f1.u1.a.a;

import c.a.d.o.e.n;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f14691b;

    /* renamed from: c  reason: collision with root package name */
    public int f14692c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f14693d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14694e;

    /* renamed from: f  reason: collision with root package name */
    public int f14695f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a(List<n> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return 0;
            }
            if (ListUtils.isEmpty(this.f14693d)) {
                LinkedList linkedList = new LinkedList();
                this.f14693d = linkedList;
                linkedList.addAll(list);
                return list.size();
            }
            LinkedList linkedList2 = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                n nVar = list.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f14693d.size()) {
                        z = false;
                        break;
                    }
                    n nVar2 = this.f14693d.get(i2);
                    if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                        ThreadData threadData = ((b) nVar).getThreadData();
                        ThreadData threadData2 = ((b) nVar2).getThreadData();
                        if (threadData != null && threadData2 != null && threadData.getTid() != null && threadData2.getTid() != null && threadData.getTid().equals(threadData2.getTid())) {
                            z = true;
                            break;
                        }
                    }
                    i2++;
                }
                if (!z) {
                    ListUtils.add(linkedList2, nVar);
                }
            }
            if (linkedList2.size() != 0) {
                ListUtils.addAll(this.f14693d, 0, linkedList2);
            }
            return linkedList2.size();
        }
        return invokeL.intValue;
    }
}
