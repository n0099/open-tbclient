package c.a.q0.h1.c;

import androidx.annotation.NonNull;
import c.a.p0.s.q.b1;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.q1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class d extends c2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.q0.a0.d0.b> T3;
    public b1 U3;
    public long V3;
    public int W3;
    public List<c.a.e.l.e.n> X3;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.W3 = 1;
        this.X3 = new ArrayList();
        this.W3 = 1;
    }

    public final void D4(@NonNull List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (ThreadInfo threadInfo : list) {
                c2 c2Var = new c2();
                c2Var.S2(threadInfo);
                c2Var.E1();
                this.X3.add(c2Var);
            }
        }
    }

    public ArrayList<c.a.e.l.e.n> E4(q1 q1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q1Var)) == null) {
            ArrayList<c.a.e.l.e.n> arrayList = new ArrayList<>(this.X3);
            G4(arrayList, q1Var);
            ArrayList<c.a.e.l.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.e.l.e.n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                c.a.e.l.e.n next = it.next();
                if (next instanceof c2) {
                    c2 c2Var = (c2) next;
                    int[] g0 = c2Var.g0();
                    if (c2Var.getType() == c2.W2) {
                        b2 b2Var = new b2();
                        b2Var.w = c2Var;
                        b2Var.position = i2;
                        b2Var.f14149e = true;
                        arrayList2.add(b2Var);
                        b2 b2Var2 = new b2();
                        b2Var2.w = c2Var;
                        b2Var2.position = i2;
                        if (c2Var.K1()) {
                            b2Var2.f14154j = true;
                        } else if (c2Var.X2() == 1) {
                            b2Var2.f14152h = true;
                            b2Var2.x = g0[0];
                            b2Var2.y = g0[1];
                        } else if (c2Var.X2() >= 2) {
                            b2Var2.f14153i = true;
                        } else {
                            b2Var2.f14150f = true;
                        }
                        arrayList2.add(b2Var2);
                        if (c2Var.q0() != null) {
                            b2 b2Var3 = new b2();
                            b2Var3.r = true;
                            b2Var3.w = c2Var;
                            b2Var3.position = i2;
                            arrayList2.add(b2Var3);
                        }
                        b2 b2Var4 = new b2();
                        b2Var4.q = true;
                        b2Var4.w = c2Var;
                        b2Var4.position = i2;
                        arrayList2.add(b2Var4);
                        b2 b2Var5 = new b2();
                        b2Var5.k = true;
                        b2Var5.w = c2Var;
                        b2Var5.position = i2;
                        arrayList2.add(b2Var5);
                    } else if (c2Var.getType() == c2.t3) {
                        b2 b2Var6 = new b2();
                        b2Var6.w = c2Var;
                        b2Var6.position = i2;
                        b2Var6.f14149e = true;
                        arrayList2.add(b2Var6);
                        b2 b2Var7 = new b2();
                        b2Var7.w = c2Var;
                        b2Var7.position = i2;
                        b2Var7.m = true;
                        arrayList2.add(b2Var7);
                        if (c2Var.q0() != null) {
                            b2 b2Var8 = new b2();
                            b2Var8.r = true;
                            b2Var8.w = c2Var;
                            b2Var8.position = i2;
                            arrayList2.add(b2Var8);
                        }
                        b2 b2Var9 = new b2();
                        b2Var9.q = true;
                        b2Var9.w = c2Var;
                        b2Var9.position = i2;
                        arrayList2.add(b2Var9);
                        b2 b2Var10 = new b2();
                        b2Var10.k = true;
                        b2Var10.w = c2Var;
                        b2Var10.position = i2;
                        arrayList2.add(b2Var10);
                    } else if (c2Var.getType() == c2.l3 && c2Var.J1()) {
                        c2Var.position = i2;
                        arrayList2.add(c2Var);
                    } else if (c.a.q0.a0.d0.j.Y(c2Var)) {
                        c.a.q0.a0.d0.j jVar = new c.a.q0.a0.d0.j(c2Var);
                        jVar.l = c2Var.q1();
                        arrayList2.add(jVar);
                    } else {
                        b2 b2Var11 = new b2();
                        b2Var11.w = c2Var;
                        b2Var11.position = i2;
                        arrayList2.add(b2Var11);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i2;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            c.a.p0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void F4(List<c.a.q0.a0.d0.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c.a.q0.a0.d0.b bVar = list.get(list.size() - 1);
        if (bVar.getThreadData() != null) {
            this.V3 = c.a.e.e.m.b.f(bVar.getThreadData().q1(), 0L);
        }
    }

    public final void G4(ArrayList<c.a.e.l.e.n> arrayList, q1 q1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, arrayList, q1Var) == null) || q1Var == null || ListUtils.isEmpty(q1Var.k())) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (arrayList.get(i2) instanceof c2) {
                if (q1Var.floorPosition == i3) {
                    ListUtils.add(arrayList, i2, q1Var);
                    break;
                }
                i3++;
            }
            i2++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, q1Var);
        }
    }

    public void H4(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) || dataRes == null) {
            return;
        }
        if (dataRes.thread_list != null) {
            this.T3 = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    c2 c2Var = new c2();
                    c2Var.S2(threadInfo);
                    c2Var.e4(5);
                    c.a.q0.a0.d0.b bVar = null;
                    if (c.a.q0.a0.d0.l.T(c2Var)) {
                        bVar = new c.a.q0.a0.d0.l(c2Var);
                    } else if (c.a.q0.a0.d0.k.Y(c2Var)) {
                        bVar = new c.a.q0.a0.d0.k();
                        bVar.f15245e = c2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.N("c10816");
                        this.T3.add(bVar);
                    }
                }
            }
            F4(this.T3);
            D4(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            b1 b1Var = new b1();
            this.U3 = b1Var;
            b1Var.j(dataRes.page);
        }
    }

    public void I4(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, hotThread) == null) || hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.T3 = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    c2 c2Var = new c2();
                    c2Var.S2(threadInfo);
                    c2Var.e4(5);
                    c.a.q0.a0.d0.b bVar = null;
                    if (c2Var.w1) {
                        bVar = new c.a.q0.a0.d0.k();
                        bVar.f15245e = c2Var;
                    } else if (c.a.q0.a0.d0.l.T(c2Var)) {
                        bVar = new c.a.q0.a0.d0.l(c2Var);
                    } else if (c.a.q0.a0.d0.k.Y(c2Var)) {
                        bVar = new c.a.q0.a0.d0.k();
                        bVar.f15245e = c2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.N("c10816");
                        this.T3.add(bVar);
                    }
                }
            }
            F4(this.T3);
            D4(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            b1 b1Var = new b1();
            this.U3 = b1Var;
            b1Var.j(hotThread.page);
        }
    }

    public d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.W3 = 1;
        this.X3 = new ArrayList();
        this.W3 = i2;
    }
}
