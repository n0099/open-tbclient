package c.a.t0.q1.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.s0.s.q.b1;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.r1;
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
public class d extends e2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.t0.g0.f0.b> f4;
    public b1 g4;
    public long h4;
    public int i4;
    public List<c.a.d.n.e.n> j4;
    @Nullable
    public Map<String, Object> k4;

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
        this.i4 = 1;
        this.j4 = new ArrayList();
        this.i4 = 1;
    }

    public final void T4(@NonNull List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (ThreadInfo threadInfo : list) {
                e2 e2Var = new e2();
                e2Var.c3(threadInfo);
                e2Var.J1();
                this.j4.add(e2Var);
            }
        }
    }

    public ArrayList<c.a.d.n.e.n> U4(r1 r1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r1Var)) == null) {
            ArrayList<c.a.d.n.e.n> arrayList = new ArrayList<>(this.j4);
            X4(arrayList, r1Var);
            ArrayList<c.a.d.n.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.n.e.n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                c.a.d.n.e.n next = it.next();
                if (next instanceof e2) {
                    e2 e2Var = (e2) next;
                    int[] h0 = e2Var.h0();
                    if (e2Var.getType() == e2.i3) {
                        d2 d2Var = new d2();
                        d2Var.w = e2Var;
                        d2Var.position = i2;
                        d2Var.f13343e = true;
                        arrayList2.add(d2Var);
                        d2 d2Var2 = new d2();
                        d2Var2.w = e2Var;
                        d2Var2.position = i2;
                        if (e2Var.Q1()) {
                            d2Var2.f13348j = true;
                        } else if (e2Var.h3() == 1) {
                            d2Var2.f13346h = true;
                            d2Var2.x = h0[0];
                            d2Var2.y = h0[1];
                        } else if (e2Var.h3() >= 2) {
                            d2Var2.f13347i = true;
                        } else {
                            d2Var2.f13344f = true;
                        }
                        arrayList2.add(d2Var2);
                        if (e2Var.t0() != null) {
                            d2 d2Var3 = new d2();
                            d2Var3.r = true;
                            d2Var3.w = e2Var;
                            d2Var3.position = i2;
                            arrayList2.add(d2Var3);
                        }
                        d2 d2Var4 = new d2();
                        d2Var4.q = true;
                        d2Var4.w = e2Var;
                        d2Var4.position = i2;
                        arrayList2.add(d2Var4);
                        d2 d2Var5 = new d2();
                        d2Var5.k = true;
                        d2Var5.w = e2Var;
                        d2Var5.position = i2;
                        arrayList2.add(d2Var5);
                    } else if (e2Var.getType() == e2.G3) {
                        d2 d2Var6 = new d2();
                        d2Var6.w = e2Var;
                        d2Var6.position = i2;
                        d2Var6.f13343e = true;
                        arrayList2.add(d2Var6);
                        d2 d2Var7 = new d2();
                        d2Var7.w = e2Var;
                        d2Var7.position = i2;
                        d2Var7.m = true;
                        arrayList2.add(d2Var7);
                        if (e2Var.t0() != null) {
                            d2 d2Var8 = new d2();
                            d2Var8.r = true;
                            d2Var8.w = e2Var;
                            d2Var8.position = i2;
                            arrayList2.add(d2Var8);
                        }
                        d2 d2Var9 = new d2();
                        d2Var9.q = true;
                        d2Var9.w = e2Var;
                        d2Var9.position = i2;
                        arrayList2.add(d2Var9);
                        d2 d2Var10 = new d2();
                        d2Var10.k = true;
                        d2Var10.w = e2Var;
                        d2Var10.position = i2;
                        arrayList2.add(d2Var10);
                    } else if (e2Var.getType() == e2.y3 && e2Var.P1()) {
                        e2Var.position = i2;
                        arrayList2.add(e2Var);
                    } else if (c.a.t0.g0.f0.j.Y(e2Var)) {
                        c.a.t0.g0.f0.j jVar = new c.a.t0.g0.f0.j(e2Var);
                        jVar.l = e2Var.v1();
                        arrayList2.add(jVar);
                    } else {
                        d2 d2Var11 = new d2();
                        d2Var11.w = e2Var;
                        d2Var11.position = i2;
                        arrayList2.add(d2Var11);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i2;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            c.a.s0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Nullable
    public Map<String, Object> V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k4 : (Map) invokeV.objValue;
    }

    public final void W4(List<c.a.t0.g0.f0.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c.a.t0.g0.f0.b bVar = list.get(list.size() - 1);
        if (bVar.getThreadData() != null) {
            this.h4 = c.a.d.f.m.b.g(bVar.getThreadData().v1(), 0L);
        }
    }

    public final void X4(ArrayList<c.a.d.n.e.n> arrayList, r1 r1Var) {
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
            if (arrayList.get(i2) instanceof e2) {
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
        this.k4 = DataExt.h(dataRes);
        if (dataRes.thread_list != null) {
            this.f4 = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    e2 e2Var = new e2();
                    e2Var.c3(threadInfo);
                    e2Var.s4(5);
                    c.a.t0.g0.f0.b bVar = null;
                    if (c.a.t0.g0.f0.l.T(e2Var)) {
                        bVar = new c.a.t0.g0.f0.l(e2Var);
                    } else if (c.a.t0.g0.f0.k.Y(e2Var)) {
                        bVar = new c.a.t0.g0.f0.k();
                        bVar.f17778e = e2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.N("c10816");
                        this.f4.add(bVar);
                    }
                }
            }
            W4(this.f4);
            T4(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            b1 b1Var = new b1();
            this.g4 = b1Var;
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
            this.f4 = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    e2 e2Var = new e2();
                    e2Var.c3(threadInfo);
                    e2Var.s4(5);
                    c.a.t0.g0.f0.b bVar = null;
                    if (e2Var.A1) {
                        bVar = new c.a.t0.g0.f0.k();
                        bVar.f17778e = e2Var;
                    } else if (c.a.t0.g0.f0.l.T(e2Var)) {
                        bVar = new c.a.t0.g0.f0.l(e2Var);
                    } else if (c.a.t0.g0.f0.k.Y(e2Var)) {
                        bVar = new c.a.t0.g0.f0.k();
                        bVar.f17778e = e2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.N("c10816");
                        this.f4.add(bVar);
                    }
                }
            }
            W4(this.f4);
            T4(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            b1 b1Var = new b1();
            this.g4 = b1Var;
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
        this.i4 = 1;
        this.j4 = new ArrayList();
        this.i4 = i2;
    }
}
