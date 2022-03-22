package c.a.p0.q1.f.d;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
import c.a.d.o.e.n;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.o0.c1.s;
import c.a.p0.h0.e0.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public e f17286b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17287c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17288d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17289e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f17290f;

    /* renamed from: g  reason: collision with root package name */
    public List<ThreadInfo> f17291g;

    /* renamed from: h  reason: collision with root package name */
    public int f17292h;
    public List<c.a.p0.q1.f.c.a> i;
    public boolean j;
    public DataRes.Builder k;
    public c.a.d.c.g.a l;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            int i;
            ClassInfo classInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f17287c = false;
                if (responsedMessage == null) {
                    this.a.f17289e = false;
                    if (this.a.f17286b != null) {
                        this.a.f17286b.b(-1, "", this.a.f17288d);
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
                    this.a.k(dataRes.class_info.sub_class_list);
                    this.a.j = dataRes.need_rechoose.intValue() == 1;
                }
                if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
                    i = 0;
                } else {
                    i = ListUtils.getCount(dataRes.thread_list);
                    this.a.n(dataRes);
                    if (!ListUtils.isEmpty(dataRes.thread_list)) {
                        this.a.z(dataRes);
                    }
                }
                if (this.a.f17286b != null) {
                    if (responsedMessage.getError() == 0) {
                        this.a.f17286b.a(i, this.a.f17288d, false);
                    } else {
                        this.a.f17286b.b(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.f17288d);
                    }
                }
                this.a.f17289e = false;
            }
        }
    }

    /* renamed from: c.a.p0.q1.f.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1298b extends k0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1298b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.o0.r.s.a.f();
                l<byte[]> e2 = c.a.o0.r.s.a.e("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (e2 != null && (bArr = e2.get(String.valueOf(this.a.f17292h))) != null && bArr.length != 0) {
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

    /* loaded from: classes2.dex */
    public class c implements s<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
                return;
            }
            this.a.k = new DataRes.Builder(dataRes);
            int count = ListUtils.getCount(dataRes.thread_list);
            if (count > 0) {
                this.a.n(dataRes);
                this.a.k(dataRes.class_info.sub_class_list);
                if (this.a.f17286b != null) {
                    this.a.f17286b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends k0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17293b;

        public d(b bVar, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17293b = bVar;
            this.a = builder;
        }

        @Override // c.a.o0.c1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                c.a.o0.r.s.a.f();
                try {
                    c.a.o0.r.s.a.e("tb.game_video", TbadkCoreApplication.getCurrentAccount()).g(String.valueOf(this.f17293b.f17292h), builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(int i, boolean z, boolean z2);

        void b(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17289e = true;
        this.j = false;
        this.l = new a(this, CmdConfigHttp.CMD_GAME_VIDEO, 309646);
        this.a = tbPageContext;
        this.f17286b = eVar;
        this.f17290f = new LinkedList();
        this.f17291g = new LinkedList();
        this.i = new LinkedList();
    }

    public final void A(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
            n0.b(new d(this, builder), null);
        }
    }

    public final void k(List<SubClassItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.i == null) {
            this.i = new LinkedList();
        }
        this.i.clear();
        for (SubClassItem subClassItem : list) {
            c.a.p0.q1.f.c.a aVar = new c.a.p0.q1.f.c.a();
            aVar.a(subClassItem);
            this.i.add(aVar);
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17290f : (List) invokeV.objValue;
    }

    public List<c.a.p0.q1.f.c.a> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (List) invokeV.objValue;
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) {
            s(dataRes.thread_list, !this.f17288d);
            List<n> y = y();
            this.f17290f = y;
            c.a.p0.q1.f.d.a.b(dataRes, y);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            n0.b(new C1298b(this), new c(this));
        }
    }

    public void q(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.f17287c) {
            return;
        }
        this.f17292h = i;
        this.f17287c = true;
        this.f17288d = false;
        if (this.f17289e) {
            p();
            this.f17289e = false;
        }
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i;
        if (!c.a.d.f.p.l.H()) {
            if (c.a.d.f.p.l.v()) {
                i2 = 4;
            } else if (c.a.d.f.p.l.u()) {
                i2 = 3;
            } else if (c.a.d.f.p.l.t()) {
                i2 = 2;
            }
            gameVideoRequestMessage.new_net_type = i2;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.a.sendMessage(gameVideoRequestMessage);
        }
        i2 = 1;
        gameVideoRequestMessage.new_net_type = i2;
        gameVideoRequestMessage.load_type = 1;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(gameVideoRequestMessage);
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.f17287c) {
            return;
        }
        this.f17292h = i;
        int i2 = 1;
        this.f17287c = true;
        this.f17288d = true;
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i;
        if (!c.a.d.f.p.l.H()) {
            if (c.a.d.f.p.l.v()) {
                i2 = 4;
            } else if (c.a.d.f.p.l.u()) {
                i2 = 3;
            } else if (c.a.d.f.p.l.t()) {
                i2 = 2;
            }
        }
        gameVideoRequestMessage.new_net_type = i2;
        gameVideoRequestMessage.load_type = 2;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(gameVideoRequestMessage);
    }

    public final void s(List<ThreadInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f17291g);
            this.f17291g.clear();
            this.f17291g.addAll(linkedList);
            return;
        }
        this.f17291g.addAll(list);
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
        long g2 = c.a.d.f.m.b.g(str, 0L);
        for (int i = 0; i < this.k.thread_list.size(); i++) {
            ThreadInfo threadInfo = this.k.thread_list.get(i);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == g2) {
                this.k.thread_list.remove(i);
                A(this.k);
                return;
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || ListUtils.isEmpty(this.f17290f)) {
            return;
        }
        Iterator<n> it = this.f17290f.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof c.a.p0.h0.e0.b) {
                c.a.p0.h0.e0.b bVar = (c.a.p0.h0.e0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().getTid() != null && bVar.getThreadData().getTid().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f17289e = true;
            this.f17290f.clear();
            this.f17291g.clear();
        }
    }

    public final List<n> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.f17291g)) {
                return linkedList;
            }
            int i = 0;
            for (ThreadInfo threadInfo : this.f17291g) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                if (c.a.p0.h0.e0.l.R(threadData)) {
                    k kVar = new k();
                    kVar.a = threadData;
                    kVar.f15321g = threadData.getTid();
                    kVar.position = i;
                    kVar.m = true;
                    linkedList.add(kVar);
                    c.a.p0.h0.e0.l lVar = new c.a.p0.h0.e0.l(threadData);
                    lVar.f15321g = threadData.getTid();
                    lVar.position = i;
                    lVar.s = true;
                    linkedList.add(lVar);
                    if (threadInfo.top_agree_post != null) {
                        k kVar2 = new k();
                        kVar2.a = threadData;
                        kVar2.f15321g = threadData.getTid();
                        kVar2.position = i;
                        kVar2.y = true;
                        linkedList.add(kVar2);
                    }
                    k kVar3 = new k();
                    kVar3.a = threadData;
                    kVar3.f15321g = threadData.getTid();
                    kVar3.position = i;
                    kVar3.A = true;
                    linkedList.add(kVar3);
                    i++;
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
            if (ListUtils.getCount(this.f17291g) >= 12) {
                if (this.f17288d) {
                    List<ThreadInfo> list = this.f17291g;
                    builder.thread_list = list.subList(list.size() - 12, this.f17291g.size());
                } else {
                    builder.thread_list = this.f17291g.subList(0, 12);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f17291g);
                builder.thread_list = arrayList;
            }
            this.k = builder;
            A(builder);
        }
    }
}
