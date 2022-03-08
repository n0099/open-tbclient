package c.a.r0.q1.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.r.b1;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.q1;
import c.a.q0.r.r.r1;
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
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c.a.d.o.e.n> a;

    /* renamed from: b  reason: collision with root package name */
    public f f20978b;

    /* renamed from: c  reason: collision with root package name */
    public l f20979c;

    /* renamed from: d  reason: collision with root package name */
    public r1 f20980d;

    /* renamed from: e  reason: collision with root package name */
    public PostForumData f20981e;

    /* renamed from: f  reason: collision with root package name */
    public i f20982f;

    /* renamed from: g  reason: collision with root package name */
    public a f20983g;

    /* renamed from: h  reason: collision with root package name */
    public a f20984h;

    /* renamed from: i  reason: collision with root package name */
    public a f20985i;

    /* renamed from: j  reason: collision with root package name */
    public g f20986j;
    public d k;
    public g l;
    public List<c.a.r0.f0.d0.b> m;
    public List<c.a.d.o.e.n> n;
    public b1 o;
    public int p;

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
        this.a = null;
        this.f20978b = null;
        this.f20979c = null;
        this.f20981e = null;
        this.f20982f = null;
        this.f20983g = null;
        this.f20984h = null;
        this.f20985i = null;
        this.f20986j = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20983g : (a) invokeV.objValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20984h : (a) invokeV.objValue;
    }

    public r1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20980d : (r1) invokeV.objValue;
    }

    public i d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20982f : (i) invokeV.objValue;
    }

    public f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20978b : (f) invokeV.objValue;
    }

    public List<c.a.d.o.e.n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20985i : (a) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            f fVar = new f();
            this.f20978b = fVar;
            fVar.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            g gVar = new g();
            this.l = gVar;
            gVar.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                e2 e2Var = new e2();
                e2Var.t4(5);
                e2Var.d3(threadInfo);
                c.a.r0.f0.d0.b bVar = null;
                if (e2Var.A1) {
                    bVar = new c.a.r0.f0.d0.k();
                    bVar.f17272e = e2Var;
                } else if (c.a.r0.f0.d0.l.S(e2Var)) {
                    bVar = new c.a.r0.f0.d0.l(e2Var);
                    bVar.w = true;
                } else if (c.a.r0.f0.d0.k.X(e2Var)) {
                    bVar = new c.a.r0.f0.d0.k();
                    bVar.f17272e = e2Var;
                }
                if (bVar != null && bVar.isValid()) {
                    bVar.M("c10814");
                    this.m.add(bVar);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            l lVar = new l();
            this.f20979c = lVar;
            lVar.parserProtobuf(dataRes.relate_forum);
            r1 r1Var = new r1();
            this.f20980d = r1Var;
            r1Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.f20980d.f13368h = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
            } else {
                this.f20980d.f13368h = dataRes.relate_forum_title;
            }
            r1 r1Var2 = this.f20980d;
            r1Var2.f13369i = R.color.CAM_X0108;
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
            this.f20981e = postForumData;
            postForumData.parserProtobuf(dataRes.post_forum);
        }
        PkModule pkModule = dataRes.pk_module;
        if (pkModule != null && !StringUtils.isNull(pkModule.ques_desc)) {
            i iVar = new i();
            this.f20982f = iVar;
            iVar.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            a aVar = new a();
            this.f20983g = aVar;
            aVar.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            a aVar2 = new a();
            this.f20984h = aVar2;
            aVar2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            a aVar3 = new a();
            this.f20985i = aVar3;
            aVar3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            g gVar2 = new g();
            this.f20986j = gVar2;
            gVar2.a(dataRes.hot_thread);
            d dVar = new d();
            this.k = dVar;
            dVar.a5(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                b1 b1Var = new b1();
                this.o = b1Var;
                b1Var.j(dataRes.hot_thread.page);
                this.o.b();
            }
            dataRes.is_global_block.intValue();
        }
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            boolean z = this.f20982f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        c.a.r0.o2.e.c cVar = new c.a.r0.o2.e.c(specialTopic.title);
                        if (!z) {
                            cVar.f20370f = false;
                            z = true;
                        }
                        this.n.add(cVar);
                    }
                    int size = specialTopic.thread_list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i2);
                        i2++;
                        c.a.r0.o2.e.b bVar2 = new c.a.r0.o2.e.b(threadInfo2, i2 == size);
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
            i iVar = this.f20982f;
            if (iVar != null) {
                this.a.add(iVar);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (c.a.r0.f0.d0.b bVar : this.m) {
                    this.a.add(bVar);
                }
            }
            l lVar = this.f20979c;
            if (lVar != null && lVar.getCount() > 0 && this.p == 1) {
                this.a.add(this.f20979c);
            }
            d dVar = this.k;
            if (dVar != null && !ListUtils.isEmpty(dVar.g4)) {
                this.a.add(this.f20986j);
                for (int i2 = 0; i2 < this.k.g4.size(); i2++) {
                    this.a.add((c.a.r0.f0.d0.b) ListUtils.getItem(this.k.g4, i2));
                    l lVar2 = this.f20979c;
                    if (lVar2 != null && lVar2.getCount() > 0 && i2 == 2 && this.p == 0) {
                        this.a.add(this.f20979c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
