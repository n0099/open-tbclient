package c.a.r0.n1.h;

import androidx.collection.LongSparseArray;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.r0.n1.h.h.d0;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f20426b;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f20427c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f20428d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f20429e;

    /* renamed from: f  reason: collision with root package name */
    public d f20430f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f20431g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.d.c.g.a f20432h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f20433i;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long g2 = c.a.d.f.m.b.g(postWriteCallBackData.getPostId(), 0L);
                long g3 = c.a.d.f.m.b.g(postWriteCallBackData.getThreadId(), 0L);
                if (g2 == 0 || g3 == 0) {
                    return;
                }
                c.a.d.f.m.e.a().removeCallbacks(this.a.f20430f);
                b bVar = this.a;
                bVar.f20430f = new d(bVar, g3, g2);
                c.a.d.f.m.e.a().postDelayed(this.a.f20430f, 500L);
            }
        }
    }

    /* renamed from: c.a.r0.n1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1215b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1215b(b bVar, int i2, int i3) {
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

        @Override // c.a.d.c.g.a
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

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || ListUtils.isEmpty(this.a.a) || ListUtils.isEmpty(this.a.f20428d)) {
                    return;
                }
                Iterator it = this.a.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n nVar = (n) it.next();
                    if (nVar instanceof c.a.r0.g0.f0.b) {
                        c.a.r0.g0.f0.b bVar = (c.a.r0.g0.f0.b) nVar;
                        if (bVar.getThreadData() != null && bVar.getThreadData().v1() != null && bVar.getThreadData().v1().equals(str)) {
                            it.remove();
                            c.a.r0.n1.h.k.c.b(this.a.a);
                            this.a.f20426b.z(new ArrayList(this.a.a));
                            break;
                        }
                    }
                }
                long g2 = c.a.d.f.m.b.g(str, 0L);
                Iterator it2 = this.a.f20428d.iterator();
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

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f20434e;

        /* renamed from: f  reason: collision with root package name */
        public long f20435f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f20436g;

        public d(b bVar, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20436g = bVar;
            this.f20434e = j2;
            this.f20435f = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int k2 = l.k(TbadkCoreApplication.getInst());
                int i2 = l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.f20436g.f20429e);
                requestGetMyPostNetMessage.setParams(this.f20434e, this.f20435f, 0L, k2, i2, f2, i3);
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
        this.f20427c = new LongSparseArray<>();
        this.f20431g = new a(this, 2921030);
        this.f20432h = new C1215b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.f20433i = new c(this, 2921031);
        this.a = list;
        this.f20426b = d0Var;
    }

    public void g(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f20427c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f20430f == null) {
            return;
        }
        c.a.d.f.m.e.a().removeCallbacks(this.f20430f);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f20429e = bdUniqueId;
            this.f20431g.setTag(bdUniqueId);
            this.f20431g.setSelfListener(false);
            this.f20432h.setTag(bdUniqueId);
            this.f20432h.getHttpMessageListener().setSelfListener(true);
            this.f20432h.getSocketMessageListener().setSelfListener(true);
            this.f20433i.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.f20431g);
            MessageManager.getInstance().registerListener(this.f20432h);
            MessageManager.getInstance().registerListener(this.f20433i);
        }
    }

    public void j(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f20428d = list;
        }
    }
}
