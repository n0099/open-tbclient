package b.a.r0.j1.l;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.b1;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.q1;
import b.a.q0.s.q.r1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b.a.e.l.e.n> f18438a;

    /* renamed from: b  reason: collision with root package name */
    public f f18439b;

    /* renamed from: c  reason: collision with root package name */
    public n f18440c;

    /* renamed from: d  reason: collision with root package name */
    public r1 f18441d;

    /* renamed from: e  reason: collision with root package name */
    public PostForumData f18442e;

    /* renamed from: f  reason: collision with root package name */
    public i f18443f;

    /* renamed from: g  reason: collision with root package name */
    public a f18444g;

    /* renamed from: h  reason: collision with root package name */
    public a f18445h;

    /* renamed from: i  reason: collision with root package name */
    public a f18446i;
    public g j;
    public d k;
    public g l;
    public List<b.a.r0.b0.e0.b> m;
    public List<b.a.e.l.e.n> n;
    public b1 o;
    public boolean p;
    public int q;
    public boolean r;
    public int s;

    public e() {
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
        this.f18438a = null;
        this.f18439b = null;
        this.f18440c = null;
        this.f18442e = null;
        this.f18443f = null;
        this.f18444g = null;
        this.f18445h = null;
        this.f18446i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = true;
        this.q = 0;
        this.f18438a = new ArrayList<>();
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null || ListUtils.getCount(dVar.X3) == 0) {
            return;
        }
        for (b.a.r0.b0.e0.b bVar : dVar.X3) {
            this.f18438a.add(bVar);
        }
    }

    public void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
            return;
        }
        b.a.r0.b0.e0.k kVar = new b.a.r0.b0.e0.k();
        kVar.f14748e = d2Var;
        d2Var.o4(5);
        this.f18438a.add(0, kVar);
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18444g : (a) invokeV.objValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18445h : (a) invokeV.objValue;
    }

    public r1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18441d : (r1) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.intValue;
    }

    public i g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f18443f : (i) invokeV.objValue;
    }

    public f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f18439b : (f) invokeV.objValue;
    }

    public ArrayList<b.a.e.l.e.n> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18438a : (ArrayList) invokeV.objValue;
    }

    public b1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : (b1) invokeV.objValue;
    }

    public n k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f18440c : (n) invokeV.objValue;
    }

    public List<b.a.e.l.e.n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f18446i : (a) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void o(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.p = dataRes.is_new_url.intValue() == 1;
        if (dataRes.topic_info != null) {
            f fVar = new f();
            this.f18439b = fVar;
            fVar.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            g gVar = new g();
            this.l = gVar;
            gVar.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                d2 d2Var = new d2();
                d2Var.o4(5);
                d2Var.Y2(threadInfo);
                b.a.r0.b0.e0.b bVar = null;
                if (d2Var.z1) {
                    bVar = new b.a.r0.b0.e0.k();
                    bVar.f14748e = d2Var;
                } else if (b.a.r0.b0.e0.l.T(d2Var)) {
                    bVar = new b.a.r0.b0.e0.l(d2Var);
                    bVar.x = true;
                } else if (b.a.r0.b0.e0.k.Y(d2Var)) {
                    bVar = new b.a.r0.b0.e0.k();
                    bVar.f14748e = d2Var;
                }
                if (bVar != null && bVar.isValid()) {
                    bVar.N("c10814");
                    this.m.add(bVar);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            n nVar = new n();
            this.f18440c = nVar;
            nVar.parserProtobuf(dataRes.relate_forum);
            r1 r1Var = new r1();
            this.f18441d = r1Var;
            r1Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.f18441d.f13435h = TbadkCoreApplication.getInst().getString(b.a.r0.j1.h.hot_topic_detail_recommend_forum_list_title);
            } else {
                this.f18441d.f13435h = dataRes.relate_forum_title;
            }
            r1 r1Var2 = this.f18441d;
            r1Var2.f13436i = b.a.r0.j1.b.CAM_X0108;
            ArrayList<q1> k = r1Var2.k();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    q1 q1Var = new q1();
                    q1Var.D(relateForum.forum_id.intValue());
                    q1Var.E(relateForum.forum_name);
                    q1Var.C(relateForum.avatar);
                    q1Var.A(relateForum.desc);
                    q1Var.B(relateForum.thread_num.intValue());
                    q1Var.z(relateForum.member_num.intValue());
                    q1Var.y(relateForum.is_liked.intValue() != 0);
                    k.add(q1Var);
                }
            }
        }
        List<RelateForum> list2 = dataRes.post_forum;
        if (list2 != null && list2.size() != 0) {
            PostForumData postForumData = new PostForumData();
            this.f18442e = postForumData;
            postForumData.parserProtobuf(dataRes.post_forum);
        }
        PkModule pkModule = dataRes.pk_module;
        if (pkModule != null && !StringUtils.isNull(pkModule.ques_desc)) {
            i iVar = new i();
            this.f18443f = iVar;
            iVar.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            a aVar = new a();
            this.f18444g = aVar;
            aVar.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            a aVar2 = new a();
            this.f18445h = aVar2;
            aVar2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            a aVar3 = new a();
            this.f18446i = aVar3;
            aVar3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            g gVar2 = new g();
            this.j = gVar2;
            gVar2.a(dataRes.hot_thread);
            d dVar = new d();
            this.k = dVar;
            dVar.V4(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                b1 b1Var = new b1();
                this.o = b1Var;
                b1Var.j(dataRes.hot_thread.page);
                this.r = this.o.b() != 0;
            }
            this.q = dataRes.is_global_block.intValue();
        }
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            boolean z = this.f18443f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        b.a.r0.e2.e.c cVar = new b.a.r0.e2.e.c(specialTopic.title);
                        if (!z) {
                            cVar.f16293f = false;
                            z = true;
                        }
                        this.n.add(cVar);
                    }
                    int size = specialTopic.thread_list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i2);
                        i2++;
                        b.a.r0.e2.e.b bVar2 = new b.a.r0.e2.e.b(threadInfo2, i2 == size);
                        bVar2.e(i2);
                        this.n.add(bVar2);
                    }
                }
            }
        }
        p();
    }

    public final ArrayList<b.a.e.l.e.n> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            i iVar = this.f18443f;
            if (iVar != null) {
                this.f18438a.add(iVar);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.f18438a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (b.a.r0.b0.e0.b bVar : this.m) {
                    this.f18438a.add(bVar);
                }
            }
            n nVar = this.f18440c;
            if (nVar != null && nVar.getCount() > 0 && this.s == 1) {
                this.f18438a.add(this.f18440c);
            }
            d dVar = this.k;
            if (dVar != null && !ListUtils.isEmpty(dVar.X3)) {
                this.f18438a.add(this.j);
                for (int i2 = 0; i2 < this.k.X3.size(); i2++) {
                    this.f18438a.add((b.a.r0.b0.e0.b) ListUtils.getItem(this.k.X3, i2));
                    n nVar2 = this.f18440c;
                    if (nVar2 != null && nVar2.getCount() > 0 && i2 == 2 && this.s == 0) {
                        this.f18438a.add(this.f18440c);
                    }
                }
            }
            return this.f18438a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void q(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, b1Var) == null) {
            this.o = b1Var;
        }
    }
}
