package c.a.r0.i1.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.q1;
import c.a.q0.s.q.r1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c.a.e.l.e.n> f19269a;

    /* renamed from: b  reason: collision with root package name */
    public f f19270b;

    /* renamed from: c  reason: collision with root package name */
    public n f19271c;

    /* renamed from: d  reason: collision with root package name */
    public r1 f19272d;

    /* renamed from: e  reason: collision with root package name */
    public PostForumData f19273e;

    /* renamed from: f  reason: collision with root package name */
    public i f19274f;

    /* renamed from: g  reason: collision with root package name */
    public a f19275g;

    /* renamed from: h  reason: collision with root package name */
    public a f19276h;

    /* renamed from: i  reason: collision with root package name */
    public a f19277i;

    /* renamed from: j  reason: collision with root package name */
    public g f19278j;
    public d k;
    public g l;
    public List<c.a.r0.a0.d0.b> m;
    public List<c.a.e.l.e.n> n;
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
        this.f19269a = null;
        this.f19270b = null;
        this.f19271c = null;
        this.f19273e = null;
        this.f19274f = null;
        this.f19275g = null;
        this.f19276h = null;
        this.f19277i = null;
        this.f19278j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = true;
        this.q = 0;
        this.f19269a = new ArrayList<>();
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null || ListUtils.getCount(dVar.W3) == 0) {
            return;
        }
        for (c.a.r0.a0.d0.b bVar : dVar.W3) {
            this.f19269a.add(bVar);
        }
    }

    public void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
            return;
        }
        c.a.r0.a0.d0.k kVar = new c.a.r0.a0.d0.k();
        kVar.f15562e = d2Var;
        d2Var.o4(5);
        this.f19269a.add(0, kVar);
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19275g : (a) invokeV.objValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19276h : (a) invokeV.objValue;
    }

    public r1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19272d : (r1) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.intValue;
    }

    public i g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19274f : (i) invokeV.objValue;
    }

    public f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19270b : (f) invokeV.objValue;
    }

    public ArrayList<c.a.e.l.e.n> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19269a : (ArrayList) invokeV.objValue;
    }

    public b1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : (b1) invokeV.objValue;
    }

    public n k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f19271c : (n) invokeV.objValue;
    }

    public List<c.a.e.l.e.n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f19277i : (a) invokeV.objValue;
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
            this.f19270b = fVar;
            fVar.b(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            g gVar = new g();
            this.l = gVar;
            gVar.b(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                d2 d2Var = new d2();
                d2Var.o4(5);
                d2Var.Y2(threadInfo);
                c.a.r0.a0.d0.b bVar = null;
                if (d2Var.y1) {
                    bVar = new c.a.r0.a0.d0.k();
                    bVar.f15562e = d2Var;
                } else if (c.a.r0.a0.d0.l.T(d2Var)) {
                    bVar = new c.a.r0.a0.d0.l(d2Var);
                    bVar.x = true;
                } else if (c.a.r0.a0.d0.k.Y(d2Var)) {
                    bVar = new c.a.r0.a0.d0.k();
                    bVar.f15562e = d2Var;
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
            this.f19271c = nVar;
            nVar.parserProtobuf(dataRes.relate_forum);
            r1 r1Var = new r1();
            this.f19272d = r1Var;
            r1Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.f19272d.f14298h = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
            } else {
                this.f19272d.f14298h = dataRes.relate_forum_title;
            }
            r1 r1Var2 = this.f19272d;
            r1Var2.f14299i = R.color.CAM_X0108;
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
            this.f19273e = postForumData;
            postForumData.parserProtobuf(dataRes.post_forum);
        }
        PkModule pkModule = dataRes.pk_module;
        if (pkModule != null && !StringUtils.isNull(pkModule.ques_desc)) {
            i iVar = new i();
            this.f19274f = iVar;
            iVar.b(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            a aVar = new a();
            this.f19275g = aVar;
            aVar.b(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            a aVar2 = new a();
            this.f19276h = aVar2;
            aVar2.b(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            a aVar3 = new a();
            this.f19277i = aVar3;
            aVar3.b(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            g gVar2 = new g();
            this.f19278j = gVar2;
            gVar2.b(dataRes.hot_thread);
            d dVar = new d();
            this.k = dVar;
            dVar.T4(dataRes.hot_thread);
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
            boolean z = this.f19274f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        c.a.r0.d2.e.c cVar = new c.a.r0.d2.e.c(specialTopic.title);
                        if (!z) {
                            cVar.f17144f = false;
                            z = true;
                        }
                        this.n.add(cVar);
                    }
                    int size = specialTopic.thread_list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        List<c.a.e.l.e.n> list3 = this.n;
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i2);
                        i2++;
                        list3.add(new c.a.r0.d2.e.b(threadInfo2, i2 == size));
                    }
                }
            }
        }
        p();
    }

    public final ArrayList<c.a.e.l.e.n> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            i iVar = this.f19274f;
            if (iVar != null) {
                this.f19269a.add(iVar);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.f19269a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (c.a.r0.a0.d0.b bVar : this.m) {
                    this.f19269a.add(bVar);
                }
            }
            n nVar = this.f19271c;
            if (nVar != null && nVar.getCount() > 0 && this.s == 1) {
                this.f19269a.add(this.f19271c);
            }
            d dVar = this.k;
            if (dVar != null && !ListUtils.isEmpty(dVar.W3)) {
                this.f19269a.add(this.f19278j);
                for (int i2 = 0; i2 < this.k.W3.size(); i2++) {
                    this.f19269a.add((c.a.r0.a0.d0.b) ListUtils.getItem(this.k.W3, i2));
                    n nVar2 = this.f19271c;
                    if (nVar2 != null && nVar2.getCount() > 0 && i2 == 2 && this.s == 0) {
                        this.f19269a.add(this.f19271c);
                    }
                }
            }
            return this.f19269a;
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
