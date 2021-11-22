package b.a.r0.w.k.c;

import android.text.TextUtils;
import b.a.e.m.e.n;
import b.a.q0.s.q.d2;
import b.a.r0.x0.m1;
import b.a.r0.x0.p0;
import b.a.r0.x0.t0;
import b.a.r0.x0.z0;
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
/* loaded from: classes5.dex */
public class a implements p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f26621e;

    /* renamed from: f  reason: collision with root package name */
    public int f26622f;

    /* renamed from: g  reason: collision with root package name */
    public m1 f26623g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<n> f26624h;

    /* renamed from: i  reason: collision with root package name */
    public t0 f26625i;
    public b.a.e.c.g.a j;
    public HttpMessageListener k;

    /* renamed from: b.a.r0.w.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1292a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26626a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1292a(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f26626a = aVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == this.f26626a.f26621e) {
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage ? ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds() : null;
                if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    closedIds = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (ListUtils.isEmpty(this.f26626a.f26624h) || ListUtils.isEmpty(closedIds)) {
                    return;
                }
                boolean z = false;
                for (int size = this.f26626a.f26624h.size() - 1; size >= 0; size--) {
                    if (this.f26626a.f26624h.get(size).getType() == d2.A3 && (d2Var = (d2) this.f26626a.f26624h.get(size)) != null && d2Var.m1() != null && closedIds.contains(Long.valueOf(d2Var.m1().live_id))) {
                        this.f26626a.f26624h.remove(size);
                        z = true;
                    }
                }
                if (!z || this.f26626a.f26625i == null) {
                    return;
                }
                this.f26626a.f26625i.a(49, this.f26626a.f26622f, this.f26626a.f26623g, this.f26626a.f26624h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26627a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f26627a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    this.f26627a.f26625i.a(49, this.f26627a.f26622f, null, null);
                    return;
                }
                FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
                if (frsPageAlaTabResponseMessage.errCode != 0) {
                    if (this.f26627a.f26625i != null) {
                        this.f26627a.f26625i.a(49, this.f26627a.f26622f, null, null);
                        return;
                    }
                    return;
                }
                ArrayList<n> arrayList = frsPageAlaTabResponseMessage.mThreadList;
                ArrayList<n> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
                m1 m1Var = frsPageAlaTabResponseMessage.pageInfo;
                int i2 = frsPageAlaTabResponseMessage.alaLiveCount;
                this.f26627a.f26623g = m1Var;
                if (m1Var.f28384c == 1) {
                    this.f26627a.f26624h.clear();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i2)));
                if (this.f26627a.f26625i != null) {
                    if (arrayList != null && arrayList.size() > 0) {
                        this.f26627a.f26624h.addAll(arrayList);
                        this.f26627a.f26625i.a(49, this.f26627a.f26622f, m1Var, this.f26627a.f26624h);
                        return;
                    }
                    d2 d2Var = new d2();
                    d2Var.B4(51);
                    if (this.f26627a.f26624h.size() == 0 || (this.f26627a.f26624h.size() > 0 && ((d2) this.f26627a.f26624h.get(0)).p1() != 51)) {
                        this.f26627a.f26624h.add(0, d2Var);
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        d2Var.i1 = true;
                        if (arrayList2.get(0) != null) {
                            ((d2) arrayList2.get(0)).h1 = true;
                        }
                        this.f26627a.f26624h.addAll(arrayList2);
                    }
                    this.f26627a.f26625i.a(49, this.f26627a.f26622f, m1Var, this.f26627a.f26624h);
                }
            }
        }
    }

    public a() {
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
        this.f26624h = new ArrayList<>();
        this.j = new C1292a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        this.k = new b(this, AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdUniqueId bdUniqueId = this.f26621e;
            if (bdUniqueId != null) {
                this.k.setTag(bdUniqueId);
                this.j.setTag(this.f26621e);
            }
            MessageManager.getInstance().registerListener(this.j);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    @Override // b.a.r0.x0.p0
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
            i();
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f26621e = bdUniqueId;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    @Override // b.a.r0.x0.p0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
            tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            f();
        }
    }

    @Override // b.a.r0.x0.p0
    public void q(int i2, int i3, z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, z0Var) == null) {
            this.f26622f = i3;
            if (z0Var != null && !TextUtils.isEmpty(z0Var.f28382a) && !TextUtils.isEmpty(z0Var.f28383b)) {
                if (z0Var.f28384c <= 0) {
                    z0Var.f28384c = 1;
                }
                MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, z0Var.f28382a, z0Var.f28383b, z0Var.f28384c));
                return;
            }
            this.f26625i.a(49, this.f26622f, null, null);
        }
    }

    @Override // b.a.r0.x0.p0
    public void t(t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t0Var) == null) {
            this.f26625i = t0Var;
        }
    }
}
