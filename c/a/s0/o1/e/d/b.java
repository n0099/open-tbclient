package c.a.s0.o1.e.d;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
import c.a.d.f.p.k;
import c.a.d.m.e.n;
import c.a.r0.d1.k0;
import c.a.r0.d1.n0;
import c.a.r0.d1.s;
import c.a.r0.s.r.d2;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public e f20832b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20833c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20834d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20835e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f20836f;

    /* renamed from: g  reason: collision with root package name */
    public List<ThreadInfo> f20837g;

    /* renamed from: h  reason: collision with root package name */
    public int f20838h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.s0.o1.e.c.a> f20839i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20840j;

    /* renamed from: k  reason: collision with root package name */
    public DataRes.Builder f20841k;
    public c.a.d.c.g.a l;

    /* loaded from: classes7.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            int i2;
            ClassInfo classInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f20833c = false;
                if (responsedMessage == null) {
                    this.a.f20835e = false;
                    if (this.a.f20832b != null) {
                        this.a.f20832b.b(-1, "", this.a.f20834d);
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
                    this.a.f20840j = dataRes.need_rechoose.intValue() == 1;
                }
                if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
                    i2 = 0;
                } else {
                    i2 = ListUtils.getCount(dataRes.thread_list);
                    this.a.n(dataRes);
                    if (!ListUtils.isEmpty(dataRes.thread_list)) {
                        this.a.z(dataRes);
                    }
                }
                if (this.a.f20832b != null) {
                    if (responsedMessage.getError() == 0) {
                        this.a.f20832b.a(i2, this.a.f20834d, false);
                    } else {
                        this.a.f20832b.b(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.f20834d);
                    }
                }
                this.a.f20835e = false;
            }
        }
    }

    /* renamed from: c.a.s0.o1.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1257b extends k0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1257b(b bVar) {
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.d1.k0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.s.s.a.f();
                l<byte[]> e2 = c.a.r0.s.s.a.e("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (e2 != null && (bArr = e2.get(String.valueOf(this.a.f20838h))) != null && bArr.length != 0) {
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

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.d1.s
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
                return;
            }
            this.a.f20841k = new DataRes.Builder(dataRes);
            int count = ListUtils.getCount(dataRes.thread_list);
            if (count > 0) {
                this.a.n(dataRes);
                this.a.k(dataRes.class_info.sub_class_list);
                if (this.a.f20832b != null) {
                    this.a.f20832b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends k0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f20842b;

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
            this.f20842b = bVar;
            this.a = builder;
        }

        @Override // c.a.r0.d1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                c.a.r0.s.s.a.f();
                try {
                    c.a.r0.s.s.a.e("tb.game_video", TbadkCoreApplication.getCurrentAccount()).g(String.valueOf(this.f20842b.f20838h), builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
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
        this.f20835e = true;
        this.f20840j = false;
        this.l = new a(this, CmdConfigHttp.CMD_GAME_VIDEO, 309646);
        this.a = tbPageContext;
        this.f20832b = eVar;
        this.f20836f = new LinkedList();
        this.f20837g = new LinkedList();
        this.f20839i = new LinkedList();
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
        if (this.f20839i == null) {
            this.f20839i = new LinkedList();
        }
        this.f20839i.clear();
        for (SubClassItem subClassItem : list) {
            c.a.s0.o1.e.c.a aVar = new c.a.s0.o1.e.c.a();
            aVar.a(subClassItem);
            this.f20839i.add(aVar);
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20836f : (List) invokeV.objValue;
    }

    public List<c.a.s0.o1.e.c.a> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20839i : (List) invokeV.objValue;
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) {
            s(dataRes.thread_list, !this.f20834d);
            List<n> y = y();
            this.f20836f = y;
            c.a.s0.o1.e.d.a.b(dataRes, y);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20840j : invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            n0.b(new C1257b(this), new c(this));
        }
    }

    public void q(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f20833c) {
            return;
        }
        this.f20838h = i2;
        this.f20833c = true;
        this.f20834d = false;
        if (this.f20835e) {
            p();
            this.f20835e = false;
        }
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i2;
        if (!k.H()) {
            if (k.v()) {
                i3 = 4;
            } else if (k.u()) {
                i3 = 3;
            } else if (k.t()) {
                i3 = 2;
            }
            gameVideoRequestMessage.new_net_type = i3;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.a.sendMessage(gameVideoRequestMessage);
        }
        i3 = 1;
        gameVideoRequestMessage.new_net_type = i3;
        gameVideoRequestMessage.load_type = 1;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(gameVideoRequestMessage);
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f20833c) {
            return;
        }
        this.f20838h = i2;
        int i3 = 1;
        this.f20833c = true;
        this.f20834d = true;
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i2;
        if (!k.H()) {
            if (k.v()) {
                i3 = 4;
            } else if (k.u()) {
                i3 = 3;
            } else if (k.t()) {
                i3 = 2;
            }
        }
        gameVideoRequestMessage.new_net_type = i3;
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
            linkedList.addAll(this.f20837g);
            this.f20837g.clear();
            this.f20837g.addAll(linkedList);
            return;
        }
        this.f20837g.addAll(list);
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
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (builder = this.f20841k) == null || ListUtils.isEmpty(builder.thread_list)) {
            return;
        }
        long g2 = c.a.d.f.m.b.g(str, 0L);
        for (int i2 = 0; i2 < this.f20841k.thread_list.size(); i2++) {
            ThreadInfo threadInfo = this.f20841k.thread_list.get(i2);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == g2) {
                this.f20841k.thread_list.remove(i2);
                A(this.f20841k);
                return;
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || ListUtils.isEmpty(this.f20836f)) {
            return;
        }
        Iterator<n> it = this.f20836f.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof c.a.s0.g0.f0.b) {
                c.a.s0.g0.f0.b bVar = (c.a.s0.g0.f0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().v1() != null && bVar.getThreadData().v1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f20835e = true;
            this.f20836f.clear();
            this.f20837g.clear();
        }
    }

    public final List<n> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.f20837g)) {
                return linkedList;
            }
            int i2 = 0;
            for (ThreadInfo threadInfo : this.f20837g) {
                d2 d2Var = new d2();
                d2Var.c3(threadInfo);
                if (c.a.s0.g0.f0.l.T(d2Var)) {
                    c.a.s0.g0.f0.k kVar = new c.a.s0.g0.f0.k();
                    kVar.f17727e = d2Var;
                    kVar.l = d2Var.v1();
                    kVar.position = i2;
                    kVar.r = true;
                    linkedList.add(kVar);
                    c.a.s0.g0.f0.l lVar = new c.a.s0.g0.f0.l(d2Var);
                    lVar.l = d2Var.v1();
                    lVar.position = i2;
                    lVar.x = true;
                    linkedList.add(lVar);
                    if (threadInfo.top_agree_post != null) {
                        c.a.s0.g0.f0.k kVar2 = new c.a.s0.g0.f0.k();
                        kVar2.f17727e = d2Var;
                        kVar2.l = d2Var.v1();
                        kVar2.position = i2;
                        kVar2.D = true;
                        linkedList.add(kVar2);
                    }
                    c.a.s0.g0.f0.k kVar3 = new c.a.s0.g0.f0.k();
                    kVar3.f17727e = d2Var;
                    kVar3.l = d2Var.v1();
                    kVar3.position = i2;
                    kVar3.F = true;
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
            if (ListUtils.getCount(this.f20837g) >= 12) {
                if (this.f20834d) {
                    List<ThreadInfo> list = this.f20837g;
                    builder.thread_list = list.subList(list.size() - 12, this.f20837g.size());
                } else {
                    builder.thread_list = this.f20837g.subList(0, 12);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f20837g);
                builder.thread_list = arrayList;
            }
            this.f20841k = builder;
            A(builder);
        }
    }
}
