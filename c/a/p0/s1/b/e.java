package c.a.p0.s1.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.n1;
import c.a.o0.r.r.o1;
import c.a.o0.r.r.z0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.PostForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.SpecialTopic;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c.a.d.o.e.n> a;

    /* renamed from: b  reason: collision with root package name */
    public f f18150b;

    /* renamed from: c  reason: collision with root package name */
    public l f18151c;

    /* renamed from: d  reason: collision with root package name */
    public o1 f18152d;

    /* renamed from: e  reason: collision with root package name */
    public PostForumData f18153e;

    /* renamed from: f  reason: collision with root package name */
    public i f18154f;

    /* renamed from: g  reason: collision with root package name */
    public a f18155g;

    /* renamed from: h  reason: collision with root package name */
    public a f18156h;
    public a i;
    public g j;
    public d k;
    public g l;
    public List<c.a.p0.h0.e0.b> m;
    public List<c.a.d.o.e.n> n;
    public z0 o;
    public int p;

    public e() {
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
        this.a = null;
        this.f18150b = null;
        this.f18151c = null;
        this.f18153e = null;
        this.f18154f = null;
        this.f18155g = null;
        this.f18156h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.a = new ArrayList<>();
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18155g : (a) invokeV.objValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18156h : (a) invokeV.objValue;
    }

    public o1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18152d : (o1) invokeV.objValue;
    }

    public i d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18154f : (i) invokeV.objValue;
    }

    public f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18150b : (f) invokeV.objValue;
    }

    public List<c.a.d.o.e.n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (a) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            f fVar = new f();
            this.f18150b = fVar;
            fVar.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            g gVar = new g();
            this.l = gVar;
            gVar.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                c.a.p0.h0.e0.b bVar = null;
                if (threadData.isShareThread) {
                    bVar = new c.a.p0.h0.e0.k();
                    bVar.a = threadData;
                } else if (c.a.p0.h0.e0.l.R(threadData)) {
                    bVar = new c.a.p0.h0.e0.l(threadData);
                    bVar.s = true;
                } else if (c.a.p0.h0.e0.k.W(threadData)) {
                    bVar = new c.a.p0.h0.e0.k();
                    bVar.a = threadData;
                }
                if (bVar != null && bVar.isValid()) {
                    bVar.L("c10814");
                    this.m.add(bVar);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            l lVar = new l();
            this.f18151c = lVar;
            lVar.parserProtobuf(dataRes.relate_forum);
            o1 o1Var = new o1();
            this.f18152d = o1Var;
            o1Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.f18152d.f10921d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0869);
            } else {
                this.f18152d.f10921d = dataRes.relate_forum_title;
            }
            o1 o1Var2 = this.f18152d;
            o1Var2.f10922e = R.color.CAM_X0108;
            ArrayList<n1> i = o1Var2.i();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    n1 n1Var = new n1();
                    n1Var.D(relateForum.forum_id.intValue());
                    n1Var.E(relateForum.forum_name);
                    n1Var.C(relateForum.avatar);
                    n1Var.A(relateForum.desc);
                    n1Var.B(relateForum.thread_num.intValue());
                    n1Var.z(relateForum.member_num.intValue());
                    n1Var.y(relateForum.is_liked.intValue() != 0);
                    i.add(n1Var);
                }
            }
        }
        List<RelateForum> list2 = dataRes.post_forum;
        if (list2 != null && list2.size() != 0) {
            PostForumData postForumData = new PostForumData();
            this.f18153e = postForumData;
            postForumData.parserProtobuf(dataRes.post_forum);
        }
        PkModule pkModule = dataRes.pk_module;
        if (pkModule != null && !StringUtils.isNull(pkModule.ques_desc)) {
            i iVar = new i();
            this.f18154f = iVar;
            iVar.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            a aVar = new a();
            this.f18155g = aVar;
            aVar.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            a aVar2 = new a();
            this.f18156h = aVar2;
            aVar2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            a aVar3 = new a();
            this.i = aVar3;
            aVar3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            g gVar2 = new g();
            this.j = gVar2;
            gVar2.a(dataRes.hot_thread);
            d dVar = new d();
            this.k = dVar;
            dVar.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                z0 z0Var = new z0();
                this.o = z0Var;
                z0Var.j(dataRes.hot_thread.page);
                this.o.b();
            }
            dataRes.is_global_block.intValue();
        }
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            boolean z = this.f18154f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        c.a.p0.q2.e.c cVar = new c.a.p0.q2.e.c(specialTopic.title);
                        if (!z) {
                            cVar.f17666b = false;
                            z = true;
                        }
                        this.n.add(cVar);
                    }
                    int size = specialTopic.thread_list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i2);
                        i2++;
                        c.a.p0.q2.e.b bVar2 = new c.a.p0.q2.e.b(threadInfo2, i2 == size);
                        bVar2.e(i2);
                        this.n.add(bVar2);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<c.a.d.o.e.n> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            i iVar = this.f18154f;
            if (iVar != null) {
                this.a.add(iVar);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (c.a.p0.h0.e0.b bVar : this.m) {
                    this.a.add(bVar);
                }
            }
            l lVar = this.f18151c;
            if (lVar != null && lVar.getCount() > 0 && this.p == 1) {
                this.a.add(this.f18151c);
            }
            d dVar = this.k;
            if (dVar != null && !ListUtils.isEmpty(dVar.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((c.a.p0.h0.e0.b) ListUtils.getItem(this.k.a, i));
                    l lVar2 = this.f18151c;
                    if (lVar2 != null && lVar2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.f18151c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
