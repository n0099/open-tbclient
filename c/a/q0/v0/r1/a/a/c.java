package c.a.q0.v0.r1.a.a;

import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f27096a;

    /* renamed from: b  reason: collision with root package name */
    public int f27097b;

    /* renamed from: c  reason: collision with root package name */
    public int f27098c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f27099d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27100e;

    /* renamed from: f  reason: collision with root package name */
    public int f27101f;

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
            if (ListUtils.isEmpty(this.f27099d)) {
                LinkedList linkedList = new LinkedList();
                this.f27099d = linkedList;
                linkedList.addAll(list);
                return list.size();
            }
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                n nVar = list.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f27099d.size()) {
                        z = false;
                        break;
                    }
                    n nVar2 = this.f27099d.get(i3);
                    if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                        c2 threadData = ((b) nVar).getThreadData();
                        c2 threadData2 = ((b) nVar2).getThreadData();
                        if (threadData != null && threadData2 != null && threadData.q1() != null && threadData2.q1() != null && threadData.q1().equals(threadData2.q1())) {
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
                ListUtils.addAll(this.f27099d, 0, linkedList2);
            }
            return linkedList2.size();
        }
        return invokeL.intValue;
    }
}
