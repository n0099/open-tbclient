package c.a.r0.g1.h;

import androidx.collection.LongSparseArray;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.r0.g1.h.h.c0;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f18182a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f18183b;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f18184c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f18185d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f18186e;

    /* renamed from: f  reason: collision with root package name */
    public d f18187f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f18188g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.e.c.g.a f18189h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f18190i;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18191a;

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
            this.f18191a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long g2 = c.a.e.e.m.b.g(postWriteCallBackData.getPostId(), 0L);
                long g3 = c.a.e.e.m.b.g(postWriteCallBackData.getThreadId(), 0L);
                if (g2 == 0 || g3 == 0) {
                    return;
                }
                c.a.e.e.m.e.a().removeCallbacks(this.f18191a.f18187f);
                b bVar = this.f18191a;
                bVar.f18187f = new d(bVar, g3, g2);
                c.a.e.e.m.e.a().postDelayed(this.f18191a.f18187f, 500L);
            }
        }
    }

    /* renamed from: c.a.r0.g1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0884b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0884b(b bVar, int i2, int i3) {
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

        @Override // c.a.e.c.g.a
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

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18192a;

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
            this.f18192a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || ListUtils.isEmpty(this.f18192a.f18182a) || ListUtils.isEmpty(this.f18192a.f18185d)) {
                    return;
                }
                Iterator it = this.f18192a.f18182a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n nVar = (n) it.next();
                    if (nVar instanceof c.a.r0.a0.d0.b) {
                        c.a.r0.a0.d0.b bVar = (c.a.r0.a0.d0.b) nVar;
                        if (bVar.getThreadData() != null && bVar.getThreadData().s1() != null && bVar.getThreadData().s1().equals(str)) {
                            it.remove();
                            c.a.r0.g1.h.k.b.b(this.f18192a.f18182a);
                            this.f18192a.f18183b.z(new ArrayList(this.f18192a.f18182a));
                            break;
                        }
                    }
                }
                long g2 = c.a.e.e.m.b.g(str, 0L);
                Iterator it2 = this.f18192a.f18185d.iterator();
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

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f18193e;

        /* renamed from: f  reason: collision with root package name */
        public long f18194f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f18195g;

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
            this.f18195g = bVar;
            this.f18193e = j2;
            this.f18194f = j3;
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
                requestGetMyPostNetMessage.setTag(this.f18195g.f18186e);
                requestGetMyPostNetMessage.setParams(this.f18193e, this.f18194f, 0L, k, i2, f2, i3);
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
        this.f18184c = new LongSparseArray<>();
        this.f18188g = new a(this, 2921030);
        this.f18189h = new C0884b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.f18190i = new c(this, 2921031);
        this.f18182a = list;
        this.f18183b = c0Var;
    }

    public void g(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f18184c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f18187f == null) {
            return;
        }
        c.a.e.e.m.e.a().removeCallbacks(this.f18187f);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f18186e = bdUniqueId;
            this.f18188g.setTag(bdUniqueId);
            this.f18188g.setSelfListener(false);
            this.f18189h.setTag(bdUniqueId);
            this.f18189h.getHttpMessageListener().setSelfListener(true);
            this.f18189h.getSocketMessageListener().setSelfListener(true);
            this.f18190i.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.f18188g);
            MessageManager.getInstance().registerListener(this.f18189h);
            MessageManager.getInstance().registerListener(this.f18190i);
        }
    }

    public void j(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f18185d = list;
        }
    }
}
