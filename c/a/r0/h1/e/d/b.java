package c.a.r0.h1.e.d;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.d.l;
import c.a.e.e.p.j;
import c.a.e.l.e.n;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.d1.q;
import c.a.q0.s.q.d2;
import c.a.r0.b0.e0.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoHttpResMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoRequestMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVertical.ClassInfo;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.SubClassItem;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18200a;

    /* renamed from: b  reason: collision with root package name */
    public e f18201b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18202c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18203d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18204e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f18205f;

    /* renamed from: g  reason: collision with root package name */
    public List<ThreadInfo> f18206g;

    /* renamed from: h  reason: collision with root package name */
    public int f18207h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.r0.h1.e.c.a> f18208i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18209j;
    public DataRes.Builder k;
    public c.a.e.c.g.a l;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18210a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18210a = bVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            int i2;
            ClassInfo classInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f18210a.f18202c = false;
                if (responsedMessage == null) {
                    this.f18210a.f18204e = false;
                    if (this.f18210a.f18201b != null) {
                        this.f18210a.f18201b.b(-1, "", this.f18210a.f18203d);
                        return;
                    }
                    return;
                }
                DataRes dataRes = null;
                if (responsedMessage instanceof GameVideoSocketResMessage) {
                    dataRes = ((GameVideoSocketResMessage) responsedMessage).mResultData;
                } else if (responsedMessage instanceof GameVideoHttpResMessage) {
                    dataRes = ((GameVideoHttpResMessage) responsedMessage).mResultData;
                }
                if (dataRes != null && (classInfo = dataRes.class_info) != null && !ListUtils.isEmpty(classInfo.sub_class_list)) {
                    this.f18210a.k(dataRes.class_info.sub_class_list);
                    this.f18210a.f18209j = dataRes.need_rechoose.intValue() == 1;
                }
                if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
                    i2 = 0;
                } else {
                    i2 = ListUtils.getCount(dataRes.thread_list);
                    this.f18210a.n(dataRes);
                    if (!ListUtils.isEmpty(dataRes.thread_list)) {
                        this.f18210a.z(dataRes);
                    }
                }
                if (this.f18210a.f18201b != null) {
                    if (responsedMessage.getError() == 0) {
                        this.f18210a.f18201b.a(i2, this.f18210a.f18203d, false);
                    } else {
                        this.f18210a.f18201b.b(responsedMessage.getError(), responsedMessage.getErrorString(), this.f18210a.f18203d);
                    }
                }
                this.f18210a.f18204e = false;
            }
        }
    }

    /* renamed from: c.a.r0.h1.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0885b extends i0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18211a;

        public C0885b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18211a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.q0.s.r.a.f();
                l<byte[]> e2 = c.a.q0.s.r.a.e("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (e2 != null && (bArr = e2.get(String.valueOf(this.f18211a.f18207h))) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e3) {
                        BdLog.e(e3);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18212a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18212a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
                return;
            }
            this.f18212a.k = new DataRes.Builder(dataRes);
            int count = ListUtils.getCount(dataRes.thread_list);
            if (count > 0) {
                this.f18212a.n(dataRes);
                this.f18212a.k(dataRes.class_info.sub_class_list);
                if (this.f18212a.f18201b != null) {
                    this.f18212a.f18201b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f18213a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f18214b;

        public d(b bVar, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18214b = bVar;
            this.f18213a = builder;
        }

        @Override // c.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f18213a.build(true));
                c.a.q0.s.r.a.f();
                try {
                    c.a.q0.s.r.a.e("tb.game_video", TbadkCoreApplication.getCurrentAccount()).g(String.valueOf(this.f18214b.f18207h), builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i2, boolean z, boolean z2);

        void b(int i2, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18204e = true;
        this.f18209j = false;
        this.l = new a(this, CmdConfigHttp.CMD_GAME_VIDEO, 309646);
        this.f18200a = tbPageContext;
        this.f18201b = eVar;
        this.f18205f = new LinkedList();
        this.f18206g = new LinkedList();
        this.f18208i = new LinkedList();
    }

    public final void A(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
            l0.b(new d(this, builder), null);
        }
    }

    public final void k(List<SubClassItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f18208i == null) {
            this.f18208i = new LinkedList();
        }
        this.f18208i.clear();
        for (SubClassItem subClassItem : list) {
            c.a.r0.h1.e.c.a aVar = new c.a.r0.h1.e.c.a();
            aVar.a(subClassItem);
            this.f18208i.add(aVar);
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18205f : (List) invokeV.objValue;
    }

    public List<c.a.r0.h1.e.c.a> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18208i : (List) invokeV.objValue;
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) {
            s(dataRes.thread_list, !this.f18203d);
            List<n> y = y();
            this.f18205f = y;
            c.a.r0.h1.e.d.a.b(dataRes, y);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18209j : invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l0.b(new C0885b(this), new c(this));
        }
    }

    public void q(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f18202c) {
            return;
        }
        this.f18207h = i2;
        this.f18202c = true;
        this.f18203d = false;
        if (this.f18204e) {
            p();
            this.f18204e = false;
        }
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i2;
        if (!j.H()) {
            if (j.v()) {
                i3 = 4;
            } else if (j.u()) {
                i3 = 3;
            } else if (j.t()) {
                i3 = 2;
            }
            gameVideoRequestMessage.new_net_type = i3;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.f18200a.sendMessage(gameVideoRequestMessage);
        }
        i3 = 1;
        gameVideoRequestMessage.new_net_type = i3;
        gameVideoRequestMessage.load_type = 1;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f18200a.sendMessage(gameVideoRequestMessage);
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f18202c) {
            return;
        }
        this.f18207h = i2;
        int i3 = 1;
        this.f18202c = true;
        this.f18203d = true;
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i2;
        if (!j.H()) {
            if (j.v()) {
                i3 = 4;
            } else if (j.u()) {
                i3 = 3;
            } else if (j.t()) {
                i3 = 2;
            }
        }
        gameVideoRequestMessage.new_net_type = i3;
        gameVideoRequestMessage.load_type = 2;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f18200a.sendMessage(gameVideoRequestMessage);
    }

    public final void s(List<ThreadInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f18206g);
            this.f18206g.clear();
            this.f18206g.addAll(linkedList);
            return;
        }
        this.f18206g.addAll(list);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public void v(String str) {
        DataRes.Builder builder;
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (builder = this.k) == null || ListUtils.isEmpty(builder.thread_list)) {
            return;
        }
        long g2 = c.a.e.e.m.b.g(str, 0L);
        for (int i2 = 0; i2 < this.k.thread_list.size(); i2++) {
            ThreadInfo threadInfo = this.k.thread_list.get(i2);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == g2) {
                this.k.thread_list.remove(i2);
                A(this.k);
                return;
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || ListUtils.isEmpty(this.f18205f)) {
            return;
        }
        Iterator<n> it = this.f18205f.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof c.a.r0.b0.e0.b) {
                c.a.r0.b0.e0.b bVar = (c.a.r0.b0.e0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().s1() != null && bVar.getThreadData().s1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f18204e = true;
            this.f18205f.clear();
            this.f18206g.clear();
        }
    }

    public final List<n> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.f18206g)) {
                return linkedList;
            }
            int i2 = 0;
            for (ThreadInfo threadInfo : this.f18206g) {
                d2 d2Var = new d2();
                d2Var.Y2(threadInfo);
                if (c.a.r0.b0.e0.l.T(d2Var)) {
                    k kVar = new k();
                    kVar.f15721e = d2Var;
                    kVar.l = d2Var.s1();
                    kVar.position = i2;
                    kVar.r = true;
                    linkedList.add(kVar);
                    c.a.r0.b0.e0.l lVar = new c.a.r0.b0.e0.l(d2Var);
                    lVar.l = d2Var.s1();
                    lVar.position = i2;
                    lVar.x = true;
                    linkedList.add(lVar);
                    if (threadInfo.top_agree_post != null) {
                        k kVar2 = new k();
                        kVar2.f15721e = d2Var;
                        kVar2.l = d2Var.s1();
                        kVar2.position = i2;
                        kVar2.C = true;
                        linkedList.add(kVar2);
                    }
                    k kVar3 = new k();
                    kVar3.f15721e = d2Var;
                    kVar3.l = d2Var.s1();
                    kVar3.position = i2;
                    kVar3.E = true;
                    linkedList.add(kVar3);
                    i2++;
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void z(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dataRes) == null) {
            DataRes.Builder builder = new DataRes.Builder();
            builder.need_rechoose = dataRes.need_rechoose;
            builder.class_info = dataRes.class_info;
            builder.thread_personalized = dataRes.thread_personalized;
            if (ListUtils.getCount(this.f18206g) >= 12) {
                if (this.f18203d) {
                    List<ThreadInfo> list = this.f18206g;
                    builder.thread_list = list.subList(list.size() - 12, this.f18206g.size());
                } else {
                    builder.thread_list = this.f18206g.subList(0, 12);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f18206g);
                builder.thread_list = arrayList;
            }
            this.k = builder;
            A(builder);
        }
    }
}
