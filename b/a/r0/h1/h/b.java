package b.a.r0.h1.h;

import androidx.collection.LongSparseArray;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.r0.h1.h.h.c0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f17287a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f17288b;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f17289c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f17290d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f17291e;

    /* renamed from: f  reason: collision with root package name */
    public d f17292f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f17293g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.e.c.g.a f17294h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f17295i;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17296a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17296a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long g2 = b.a.e.e.m.b.g(postWriteCallBackData.getPostId(), 0L);
                long g3 = b.a.e.e.m.b.g(postWriteCallBackData.getThreadId(), 0L);
                if (g2 == 0 || g3 == 0) {
                    return;
                }
                b.a.e.e.m.e.a().removeCallbacks(this.f17296a.f17292f);
                b bVar = this.f17296a;
                bVar.f17292f = new d(bVar, g3, g2);
                b.a.e.e.m.e.a().postDelayed(this.f17296a.f17292f, 500L);
            }
        }
    }

    /* renamed from: b.a.r0.h1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0888b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0888b(b bVar, int i2, int i3) {
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
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17297a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17297a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || ListUtils.isEmpty(this.f17297a.f17287a) || ListUtils.isEmpty(this.f17297a.f17290d)) {
                    return;
                }
                Iterator it = this.f17297a.f17287a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n nVar = (n) it.next();
                    if (nVar instanceof b.a.r0.b0.e0.b) {
                        b.a.r0.b0.e0.b bVar = (b.a.r0.b0.e0.b) nVar;
                        if (bVar.getThreadData() != null && bVar.getThreadData().s1() != null && bVar.getThreadData().s1().equals(str)) {
                            it.remove();
                            b.a.r0.h1.h.k.c.b(this.f17297a.f17287a);
                            this.f17297a.f17288b.z(new ArrayList(this.f17297a.f17287a));
                            break;
                        }
                    }
                }
                long g2 = b.a.e.e.m.b.g(str, 0L);
                Iterator it2 = this.f17297a.f17290d.iterator();
                while (it2.hasNext()) {
                    ThreadInfo threadInfo = (ThreadInfo) it2.next();
                    if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == g2) {
                        it2.remove();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f17298e;

        /* renamed from: f  reason: collision with root package name */
        public long f17299f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f17300g;

        public d(b bVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17300g = bVar;
            this.f17298e = j;
            this.f17299f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int k = l.k(TbadkCoreApplication.getInst());
                int i2 = l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.f17300g.f17291e);
                requestGetMyPostNetMessage.setParams(this.f17298e, this.f17299f, 0L, k, i2, f2, i3);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    public b(List<n> list, c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, c0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17289c = new LongSparseArray<>();
        this.f17293g = new a(this, 2921030);
        this.f17294h = new C0888b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.f17295i = new c(this, 2921031);
        this.f17287a = list;
        this.f17288b = c0Var;
    }

    public void g(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f17289c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17292f == null) {
            return;
        }
        b.a.e.e.m.e.a().removeCallbacks(this.f17292f);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f17291e = bdUniqueId;
            this.f17293g.setTag(bdUniqueId);
            this.f17293g.setSelfListener(false);
            this.f17294h.setTag(bdUniqueId);
            this.f17294h.getHttpMessageListener().setSelfListener(true);
            this.f17294h.getSocketMessageListener().setSelfListener(true);
            this.f17295i.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.f17293g);
            MessageManager.getInstance().registerListener(this.f17294h);
            MessageManager.getInstance().registerListener(this.f17295i);
        }
    }

    public void j(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17290d = list;
        }
    }
}
