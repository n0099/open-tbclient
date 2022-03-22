package c.a.p0.c0.k.c;

import android.text.TextUtils;
import c.a.d.o.e.n;
import c.a.p0.f1.c1;
import c.a.p0.f1.p0;
import c.a.p0.f1.t0;
import c.a.p0.f1.z0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.livecard.models.FrsPageAlaTabRequestMessage;
import com.baidu.tieba.ala.livecard.models.FrsPageAlaTabResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public int f13250b;

    /* renamed from: c  reason: collision with root package name */
    public c1 f13251c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<n> f13252d;

    /* renamed from: e  reason: collision with root package name */
    public t0 f13253e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.c.g.a f13254f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f13255g;

    /* renamed from: c.a.p0.c0.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0996a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0996a(a aVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == this.a.a) {
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage ? ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds() : null;
                if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    closedIds = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (ListUtils.isEmpty(this.a.f13252d) || ListUtils.isEmpty(closedIds)) {
                    return;
                }
                boolean z = false;
                for (int size = this.a.f13252d.size() - 1; size >= 0; size--) {
                    if (this.a.f13252d.get(size).getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && (threadData = (ThreadData) this.a.f13252d.get(size)) != null && threadData.getThreadAlaInfo() != null && closedIds.contains(Long.valueOf(threadData.getThreadAlaInfo().live_id))) {
                        this.a.f13252d.remove(size);
                        z = true;
                    }
                }
                if (!z || this.a.f13253e == null) {
                    return;
                }
                this.a.f13253e.a(49, this.a.f13250b, this.a.f13251c, this.a.f13252d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    this.a.f13253e.a(49, this.a.f13250b, null, null);
                    return;
                }
                FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
                if (frsPageAlaTabResponseMessage.errCode != 0) {
                    if (this.a.f13253e != null) {
                        this.a.f13253e.a(49, this.a.f13250b, null, null);
                        return;
                    }
                    return;
                }
                ArrayList<n> arrayList = frsPageAlaTabResponseMessage.mThreadList;
                ArrayList<n> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
                c1 c1Var = frsPageAlaTabResponseMessage.pageInfo;
                int i = frsPageAlaTabResponseMessage.alaLiveCount;
                this.a.f13251c = c1Var;
                if (c1Var.f14893c == 1) {
                    this.a.f13252d.clear();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i)));
                if (this.a.f13253e != null) {
                    if (arrayList != null && arrayList.size() > 0) {
                        this.a.f13252d.addAll(arrayList);
                        this.a.f13253e.a(49, this.a.f13250b, c1Var, this.a.f13252d);
                        return;
                    }
                    ThreadData threadData = new ThreadData();
                    threadData.setThreadType(51);
                    if (this.a.f13252d.size() == 0 || (this.a.f13252d.size() > 0 && ((ThreadData) this.a.f13252d.get(0)).getThreadType() != 51)) {
                        this.a.f13252d.add(0, threadData);
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        threadData.hasRecommend = true;
                        if (arrayList2.get(0) != null) {
                            ((ThreadData) arrayList2.get(0)).isFirstRecommend = true;
                        }
                        this.a.f13252d.addAll(arrayList2);
                    }
                    this.a.f13253e.a(49, this.a.f13250b, c1Var, this.a.f13252d);
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13252d = new ArrayList<>();
        this.f13254f = new C0996a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        this.f13255g = new b(this, AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.f13255g.setTag(bdUniqueId);
                this.f13254f.setTag(this.a);
            }
            MessageManager.getInstance().registerListener(this.f13254f);
            MessageManager.getInstance().registerListener(this.f13255g);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f13254f);
            MessageManager.getInstance().unRegisterListener(this.f13255g);
        }
    }

    @Override // c.a.p0.f1.p0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
            h();
        }
    }

    @Override // c.a.p0.f1.p0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
            tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            f();
        }
    }

    @Override // c.a.p0.f1.p0
    public void s(int i, int i2, z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, z0Var) == null) {
            this.f13250b = i2;
            if (z0Var != null && !TextUtils.isEmpty(z0Var.a) && !TextUtils.isEmpty(z0Var.f14892b)) {
                if (z0Var.f14893c <= 0) {
                    z0Var.f14893c = 1;
                }
                MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, z0Var.a, z0Var.f14892b, z0Var.f14893c));
                return;
            }
            this.f13253e.a(49, this.f13250b, null, null);
        }
    }

    @Override // c.a.p0.f1.p0
    public void v(t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t0Var) == null) {
            this.f13253e = t0Var;
        }
    }
}
