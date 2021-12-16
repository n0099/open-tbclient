package c.a.s0.q1.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.s.r.b1;
import c.a.r0.s.r.c2;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.r1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class d extends d2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.s0.g0.f0.b> d4;
    public b1 e4;
    public long f4;
    public int g4;
    public List<c.a.d.m.e.n> h4;
    @Nullable
    public Map<String, Object> i4;

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
        this.g4 = 1;
        this.h4 = new ArrayList();
        this.g4 = 1;
    }

    public final void T4(@NonNull List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (ThreadInfo threadInfo : list) {
                d2 d2Var = new d2();
                d2Var.c3(threadInfo);
                d2Var.J1();
                this.h4.add(d2Var);
            }
        }
    }

    public ArrayList<c.a.d.m.e.n> U4(r1 r1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r1Var)) == null) {
            ArrayList<c.a.d.m.e.n> arrayList = new ArrayList<>(this.h4);
            X4(arrayList, r1Var);
            ArrayList<c.a.d.m.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.m.e.n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                c.a.d.m.e.n next = it.next();
                if (next instanceof d2) {
                    d2 d2Var = (d2) next;
                    int[] h0 = d2Var.h0();
                    if (d2Var.getType() == d2.g3) {
                        c2 c2Var = new c2();
                        c2Var.w = d2Var;
                        c2Var.position = i2;
                        c2Var.f13264e = true;
                        arrayList2.add(c2Var);
                        c2 c2Var2 = new c2();
                        c2Var2.w = d2Var;
                        c2Var2.position = i2;
                        if (d2Var.Q1()) {
                            c2Var2.f13269j = true;
                        } else if (d2Var.h3() == 1) {
                            c2Var2.f13267h = true;
                            c2Var2.x = h0[0];
                            c2Var2.y = h0[1];
                        } else if (d2Var.h3() >= 2) {
                            c2Var2.f13268i = true;
                        } else {
                            c2Var2.f13265f = true;
                        }
                        arrayList2.add(c2Var2);
                        if (d2Var.t0() != null) {
                            c2 c2Var3 = new c2();
                            c2Var3.r = true;
                            c2Var3.w = d2Var;
                            c2Var3.position = i2;
                            arrayList2.add(c2Var3);
                        }
                        c2 c2Var4 = new c2();
                        c2Var4.q = true;
                        c2Var4.w = d2Var;
                        c2Var4.position = i2;
                        arrayList2.add(c2Var4);
                        c2 c2Var5 = new c2();
                        c2Var5.f13270k = true;
                        c2Var5.w = d2Var;
                        c2Var5.position = i2;
                        arrayList2.add(c2Var5);
                    } else if (d2Var.getType() == d2.E3) {
                        c2 c2Var6 = new c2();
                        c2Var6.w = d2Var;
                        c2Var6.position = i2;
                        c2Var6.f13264e = true;
                        arrayList2.add(c2Var6);
                        c2 c2Var7 = new c2();
                        c2Var7.w = d2Var;
                        c2Var7.position = i2;
                        c2Var7.m = true;
                        arrayList2.add(c2Var7);
                        if (d2Var.t0() != null) {
                            c2 c2Var8 = new c2();
                            c2Var8.r = true;
                            c2Var8.w = d2Var;
                            c2Var8.position = i2;
                            arrayList2.add(c2Var8);
                        }
                        c2 c2Var9 = new c2();
                        c2Var9.q = true;
                        c2Var9.w = d2Var;
                        c2Var9.position = i2;
                        arrayList2.add(c2Var9);
                        c2 c2Var10 = new c2();
                        c2Var10.f13270k = true;
                        c2Var10.w = d2Var;
                        c2Var10.position = i2;
                        arrayList2.add(c2Var10);
                    } else if (d2Var.getType() == d2.w3 && d2Var.P1()) {
                        d2Var.position = i2;
                        arrayList2.add(d2Var);
                    } else if (c.a.s0.g0.f0.j.Y(d2Var)) {
                        c.a.s0.g0.f0.j jVar = new c.a.s0.g0.f0.j(d2Var);
                        jVar.l = d2Var.v1();
                        arrayList2.add(jVar);
                    } else {
                        c2 c2Var11 = new c2();
                        c2Var11.w = d2Var;
                        c2Var11.position = i2;
                        arrayList2.add(c2Var11);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i2;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            c.a.r0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Nullable
    public Map<String, Object> V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i4 : (Map) invokeV.objValue;
    }

    public final void W4(List<c.a.s0.g0.f0.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c.a.s0.g0.f0.b bVar = list.get(list.size() - 1);
        if (bVar.getThreadData() != null) {
            this.f4 = c.a.d.f.m.b.g(bVar.getThreadData().v1(), 0L);
        }
    }

    public final void X4(ArrayList<c.a.d.m.e.n> arrayList, r1 r1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, r1Var) == null) || r1Var == null || ListUtils.isEmpty(r1Var.k())) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (arrayList.get(i2) instanceof d2) {
                if (r1Var.floorPosition == i3) {
                    ListUtils.add(arrayList, i2, r1Var);
                    break;
                }
                i3++;
            }
            i2++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, r1Var);
        }
    }

    public void Y4(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.i4 = DataExt.h(dataRes);
        if (dataRes.thread_list != null) {
            this.d4 = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    d2 d2Var = new d2();
                    d2Var.c3(threadInfo);
                    d2Var.s4(5);
                    c.a.s0.g0.f0.b bVar = null;
                    if (c.a.s0.g0.f0.l.T(d2Var)) {
                        bVar = new c.a.s0.g0.f0.l(d2Var);
                    } else if (c.a.s0.g0.f0.k.Y(d2Var)) {
                        bVar = new c.a.s0.g0.f0.k();
                        bVar.f17727e = d2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.N("c10816");
                        this.d4.add(bVar);
                    }
                }
            }
            W4(this.d4);
            T4(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            b1 b1Var = new b1();
            this.e4 = b1Var;
            b1Var.j(dataRes.page);
        }
    }

    public void Z4(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, hotThread) == null) || hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.d4 = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    d2 d2Var = new d2();
                    d2Var.c3(threadInfo);
                    d2Var.s4(5);
                    c.a.s0.g0.f0.b bVar = null;
                    if (d2Var.B1) {
                        bVar = new c.a.s0.g0.f0.k();
                        bVar.f17727e = d2Var;
                    } else if (c.a.s0.g0.f0.l.T(d2Var)) {
                        bVar = new c.a.s0.g0.f0.l(d2Var);
                    } else if (c.a.s0.g0.f0.k.Y(d2Var)) {
                        bVar = new c.a.s0.g0.f0.k();
                        bVar.f17727e = d2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.N("c10816");
                        this.d4.add(bVar);
                    }
                }
            }
            W4(this.d4);
            T4(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            b1 b1Var = new b1();
            this.e4 = b1Var;
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
        this.g4 = 1;
        this.h4 = new ArrayList();
        this.g4 = i2;
    }
}
