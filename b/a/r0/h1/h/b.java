package b.a.r0.h1.h;

import androidx.collection.LongSparseArray;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.r0.h1.h.h.d0;
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
    public final List<n> f18755a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f18756b;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f18757c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f18758d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f18759e;

    /* renamed from: f  reason: collision with root package name */
    public d f18760f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f18761g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.e.c.g.a f18762h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f18763i;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18764a;

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
            this.f18764a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long g2 = b.a.e.f.m.b.g(postWriteCallBackData.getPostId(), 0L);
                long g3 = b.a.e.f.m.b.g(postWriteCallBackData.getThreadId(), 0L);
                if (g2 == 0 || g3 == 0) {
                    return;
                }
                b.a.e.f.m.e.a().removeCallbacks(this.f18764a.f18760f);
                b bVar = this.f18764a;
                bVar.f18760f = new d(bVar, g3, g2);
                b.a.e.f.m.e.a().postDelayed(this.f18764a.f18760f, 500L);
            }
        }
    }

    /* renamed from: b.a.r0.h1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0956b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0956b(b bVar, int i2, int i3) {
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
        public final /* synthetic */ b f18765a;

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
            this.f18765a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || ListUtils.isEmpty(this.f18765a.f18755a) || ListUtils.isEmpty(this.f18765a.f18758d)) {
                    return;
                }
                Iterator it = this.f18765a.f18755a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n nVar = (n) it.next();
                    if (nVar instanceof b.a.r0.b0.f0.b) {
                        b.a.r0.b0.f0.b bVar = (b.a.r0.b0.f0.b) nVar;
                        if (bVar.getThreadData() != null && bVar.getThreadData().t1() != null && bVar.getThreadData().t1().equals(str)) {
                            it.remove();
                            b.a.r0.h1.h.k.c.b(this.f18765a.f18755a);
                            this.f18765a.f18756b.z(new ArrayList(this.f18765a.f18755a));
                            break;
                        }
                    }
                }
                long g2 = b.a.e.f.m.b.g(str, 0L);
                Iterator it2 = this.f18765a.f18758d.iterator();
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
        public long f18766e;

        /* renamed from: f  reason: collision with root package name */
        public long f18767f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f18768g;

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
            this.f18768g = bVar;
            this.f18766e = j;
            this.f18767f = j2;
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
                requestGetMyPostNetMessage.setTag(this.f18768g.f18759e);
                requestGetMyPostNetMessage.setParams(this.f18766e, this.f18767f, 0L, k, i2, f2, i3);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    public b(List<n> list, d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, d0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18757c = new LongSparseArray<>();
        this.f18761g = new a(this, 2921030);
        this.f18762h = new C0956b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.f18763i = new c(this, 2921031);
        this.f18755a = list;
        this.f18756b = d0Var;
    }

    public void g(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f18757c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f18760f == null) {
            return;
        }
        b.a.e.f.m.e.a().removeCallbacks(this.f18760f);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f18759e = bdUniqueId;
            this.f18761g.setTag(bdUniqueId);
            this.f18761g.setSelfListener(false);
            this.f18762h.setTag(bdUniqueId);
            this.f18762h.getHttpMessageListener().setSelfListener(true);
            this.f18762h.getSocketMessageListener().setSelfListener(true);
            this.f18763i.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.f18761g);
            MessageManager.getInstance().registerListener(this.f18762h);
            MessageManager.getInstance().registerListener(this.f18763i);
        }
    }

    public void j(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f18758d = list;
        }
    }
}
