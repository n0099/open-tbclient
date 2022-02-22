package c.a.u0.r1.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.t0.s.r.b1;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.r1;
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
    public List<c.a.u0.g0.d0.b> g4;
    public b1 h4;
    public long i4;
    public int j4;
    public List<c.a.d.o.e.n> k4;
    @Nullable
    public Map<String, Object> l4;

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
        this.j4 = 1;
        this.k4 = new ArrayList();
        this.j4 = 1;
    }

    public final void U4(@NonNull List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (ThreadInfo threadInfo : list) {
                e2 e2Var = new e2();
                e2Var.d3(threadInfo);
                e2Var.K1();
                this.k4.add(e2Var);
            }
        }
    }

    public ArrayList<c.a.d.o.e.n> V4(r1 r1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r1Var)) == null) {
            ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>(this.k4);
            Y4(arrayList, r1Var);
            ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
                if (next instanceof e2) {
                    e2 e2Var = (e2) next;
                    int[] i0 = e2Var.i0();
                    if (e2Var.getType() == e2.j3) {
                        d2 d2Var = new d2();
                        d2Var.w = e2Var;
                        d2Var.position = i2;
                        d2Var.f13813e = true;
                        arrayList2.add(d2Var);
                        d2 d2Var2 = new d2();
                        d2Var2.w = e2Var;
                        d2Var2.position = i2;
                        if (e2Var.R1()) {
                            d2Var2.f13818j = true;
                        } else if (e2Var.i3() == 1) {
                            d2Var2.f13816h = true;
                            d2Var2.x = i0[0];
                            d2Var2.y = i0[1];
                        } else if (e2Var.i3() >= 2) {
                            d2Var2.f13817i = true;
                        } else {
                            d2Var2.f13814f = true;
                        }
                        arrayList2.add(d2Var2);
                        if (e2Var.u0() != null) {
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
                    } else if (e2Var.getType() == e2.H3) {
                        d2 d2Var6 = new d2();
                        d2Var6.w = e2Var;
                        d2Var6.position = i2;
                        d2Var6.f13813e = true;
                        arrayList2.add(d2Var6);
                        d2 d2Var7 = new d2();
                        d2Var7.w = e2Var;
                        d2Var7.position = i2;
                        d2Var7.m = true;
                        arrayList2.add(d2Var7);
                        if (e2Var.u0() != null) {
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
                    } else if (e2Var.getType() == e2.z3 && e2Var.Q1()) {
                        e2Var.position = i2;
                        arrayList2.add(e2Var);
                    } else if (c.a.u0.g0.d0.j.X(e2Var)) {
                        c.a.u0.g0.d0.j jVar = new c.a.u0.g0.d0.j(e2Var);
                        jVar.k = e2Var.w1();
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
            c.a.t0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Nullable
    public Map<String, Object> W4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l4 : (Map) invokeV.objValue;
    }

    public final void X4(List<c.a.u0.g0.d0.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c.a.u0.g0.d0.b bVar = list.get(list.size() - 1);
        if (bVar.getThreadData() != null) {
            this.i4 = c.a.d.f.m.b.g(bVar.getThreadData().w1(), 0L);
        }
    }

    public final void Y4(ArrayList<c.a.d.o.e.n> arrayList, r1 r1Var) {
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

    public void Z4(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.l4 = DataExt.h(dataRes);
        if (dataRes.thread_list != null) {
            this.g4 = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    e2 e2Var = new e2();
                    e2Var.d3(threadInfo);
                    e2Var.t4(5);
                    c.a.u0.g0.d0.b bVar = null;
                    if (c.a.u0.g0.d0.l.S(e2Var)) {
                        bVar = new c.a.u0.g0.d0.l(e2Var);
                    } else if (c.a.u0.g0.d0.k.X(e2Var)) {
                        bVar = new c.a.u0.g0.d0.k();
                        bVar.f17886e = e2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.M("c10816");
                        this.g4.add(bVar);
                    }
                }
            }
            X4(this.g4);
            U4(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            b1 b1Var = new b1();
            this.h4 = b1Var;
            b1Var.j(dataRes.page);
        }
    }

    public void a5(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, hotThread) == null) || hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.g4 = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    e2 e2Var = new e2();
                    e2Var.d3(threadInfo);
                    e2Var.t4(5);
                    c.a.u0.g0.d0.b bVar = null;
                    if (e2Var.A1) {
                        bVar = new c.a.u0.g0.d0.k();
                        bVar.f17886e = e2Var;
                    } else if (c.a.u0.g0.d0.l.S(e2Var)) {
                        bVar = new c.a.u0.g0.d0.l(e2Var);
                    } else if (c.a.u0.g0.d0.k.X(e2Var)) {
                        bVar = new c.a.u0.g0.d0.k();
                        bVar.f17886e = e2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.M("c10816");
                        this.g4.add(bVar);
                    }
                }
            }
            X4(this.g4);
            U4(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            b1 b1Var = new b1();
            this.h4 = b1Var;
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
        this.j4 = 1;
        this.k4 = new ArrayList();
        this.j4 = i2;
    }
}
