package c.a.p0.s1.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.r.r.a2;
import c.a.o0.r.r.o1;
import c.a.o0.r.r.z0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class d extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.p0.h0.e0.b> a;

    /* renamed from: b  reason: collision with root package name */
    public z0 f18145b;

    /* renamed from: c  reason: collision with root package name */
    public long f18146c;

    /* renamed from: d  reason: collision with root package name */
    public int f18147d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.o.e.n> f18148e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Object> f18149f;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18147d = 1;
        this.f18148e = new ArrayList();
        this.f18147d = 1;
    }

    public final void e(@NonNull List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                threadData.insertItemToTitleOrAbstractText();
                this.f18148e.add(threadData);
            }
        }
    }

    public ArrayList<c.a.d.o.e.n> g(o1 o1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o1Var)) == null) {
            ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>(this.f18148e);
            m(arrayList, o1Var);
            ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a2 a2Var = new a2();
                        a2Var.s = threadData;
                        a2Var.position = i;
                        a2Var.a = true;
                        arrayList2.add(a2Var);
                        a2 a2Var2 = new a2();
                        a2Var2.s = threadData;
                        a2Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            a2Var2.f10786f = true;
                        } else if (threadData.picCount() == 1) {
                            a2Var2.f10784d = true;
                            a2Var2.t = imageWidthAndHeight[0];
                            a2Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            a2Var2.f10785e = true;
                        } else {
                            a2Var2.f10782b = true;
                        }
                        arrayList2.add(a2Var2);
                        if (threadData.getItem() != null) {
                            a2 a2Var3 = new a2();
                            a2Var3.n = true;
                            a2Var3.s = threadData;
                            a2Var3.position = i;
                            arrayList2.add(a2Var3);
                        }
                        a2 a2Var4 = new a2();
                        a2Var4.m = true;
                        a2Var4.s = threadData;
                        a2Var4.position = i;
                        arrayList2.add(a2Var4);
                        a2 a2Var5 = new a2();
                        a2Var5.f10787g = true;
                        a2Var5.s = threadData;
                        a2Var5.position = i;
                        arrayList2.add(a2Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a2 a2Var6 = new a2();
                        a2Var6.s = threadData;
                        a2Var6.position = i;
                        a2Var6.a = true;
                        arrayList2.add(a2Var6);
                        a2 a2Var7 = new a2();
                        a2Var7.s = threadData;
                        a2Var7.position = i;
                        a2Var7.i = true;
                        arrayList2.add(a2Var7);
                        if (threadData.getItem() != null) {
                            a2 a2Var8 = new a2();
                            a2Var8.n = true;
                            a2Var8.s = threadData;
                            a2Var8.position = i;
                            arrayList2.add(a2Var8);
                        }
                        a2 a2Var9 = new a2();
                        a2Var9.m = true;
                        a2Var9.s = threadData;
                        a2Var9.position = i;
                        arrayList2.add(a2Var9);
                        a2 a2Var10 = new a2();
                        a2Var10.f10787g = true;
                        a2Var10.s = threadData;
                        a2Var10.position = i;
                        arrayList2.add(a2Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (c.a.p0.h0.e0.j.W(threadData)) {
                        c.a.p0.h0.e0.j jVar = new c.a.p0.h0.e0.j(threadData);
                        jVar.f15321g = threadData.getTid();
                        arrayList2.add(jVar);
                    } else {
                        a2 a2Var11 = new a2();
                        a2Var11.s = threadData;
                        a2Var11.position = i;
                        arrayList2.add(a2Var11);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Nullable
    public Map<String, Object> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18149f : (Map) invokeV.objValue;
    }

    public final void k(List<c.a.p0.h0.e0.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c.a.p0.h0.e0.b bVar = list.get(list.size() - 1);
        if (bVar.getThreadData() != null) {
            this.f18146c = c.a.d.f.m.b.g(bVar.getThreadData().getTid(), 0L);
        }
    }

    public final void m(ArrayList<c.a.d.o.e.n> arrayList, o1 o1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, o1Var) == null) || o1Var == null || ListUtils.isEmpty(o1Var.i())) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (arrayList.get(i) instanceof ThreadData) {
                if (o1Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, o1Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, o1Var);
        }
    }

    public void q(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f18149f = DataExt.toMap(dataRes);
        if (dataRes.thread_list != null) {
            this.a = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.setResource(5);
                    c.a.p0.h0.e0.b bVar = null;
                    if (c.a.p0.h0.e0.l.R(threadData)) {
                        bVar = new c.a.p0.h0.e0.l(threadData);
                    } else if (c.a.p0.h0.e0.k.W(threadData)) {
                        bVar = new c.a.p0.h0.e0.k();
                        bVar.a = threadData;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.L("c10816");
                        this.a.add(bVar);
                    }
                }
            }
            k(this.a);
            e(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            z0 z0Var = new z0();
            this.f18145b = z0Var;
            z0Var.j(dataRes.page);
        }
    }

    public void r(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, hotThread) == null) || hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.a = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.setResource(5);
                    c.a.p0.h0.e0.b bVar = null;
                    if (threadData.isShareThread) {
                        bVar = new c.a.p0.h0.e0.k();
                        bVar.a = threadData;
                    } else if (c.a.p0.h0.e0.l.R(threadData)) {
                        bVar = new c.a.p0.h0.e0.l(threadData);
                    } else if (c.a.p0.h0.e0.k.W(threadData)) {
                        bVar = new c.a.p0.h0.e0.k();
                        bVar.a = threadData;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.L("c10816");
                        this.a.add(bVar);
                    }
                }
            }
            k(this.a);
            e(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            z0 z0Var = new z0();
            this.f18145b = z0Var;
            z0Var.j(hotThread.page);
        }
    }

    public d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18147d = 1;
        this.f18148e = new ArrayList();
        this.f18147d = i;
    }
}
