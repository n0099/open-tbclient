package c.a.r0.d1.u1.a.a;

import c.a.d.o.e.n;
import c.a.q0.r.r.e2;
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
    public int f16495b;

    /* renamed from: c  reason: collision with root package name */
    public int f16496c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f16497d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16498e;

    /* renamed from: f  reason: collision with root package name */
    public int f16499f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (ListUtils.isEmpty(this.f16497d)) {
                LinkedList linkedList = new LinkedList();
                this.f16497d = linkedList;
                linkedList.addAll(list);
                return list.size();
            }
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                n nVar = list.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f16497d.size()) {
                        z = false;
                        break;
                    }
                    n nVar2 = this.f16497d.get(i3);
                    if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                        e2 threadData = ((b) nVar).getThreadData();
                        e2 threadData2 = ((b) nVar2).getThreadData();
                        if (threadData != null && threadData2 != null && threadData.w1() != null && threadData2.w1() != null && threadData.w1().equals(threadData2.w1())) {
                            z = true;
                            break;
                        }
                    }
                    i3++;
                }
                if (!z) {
                    ListUtils.add(linkedList2, nVar);
                }
            }
            if (linkedList2.size() != 0) {
                ListUtils.addAll(this.f16497d, 0, linkedList2);
            }
            return linkedList2.size();
        }
        return invokeL.intValue;
    }
}
