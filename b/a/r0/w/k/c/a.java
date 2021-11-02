package b.a.r0.w.k.c;

import android.text.TextUtils;
import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
import b.a.r0.x0.l1;
import b.a.r0.x0.o0;
import b.a.r0.x0.s0;
import b.a.r0.x0.y0;
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
public class a implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f25104e;

    /* renamed from: f  reason: collision with root package name */
    public int f25105f;

    /* renamed from: g  reason: collision with root package name */
    public l1 f25106g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<n> f25107h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f25108i;
    public b.a.e.c.g.a j;
    public HttpMessageListener k;

    /* renamed from: b.a.r0.w.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1224a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25109a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1224a(a aVar, int i2, int i3) {
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
            this.f25109a = aVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == this.f25109a.f25104e) {
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage ? ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds() : null;
                if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    closedIds = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (ListUtils.isEmpty(this.f25109a.f25107h) || ListUtils.isEmpty(closedIds)) {
                    return;
                }
                boolean z = false;
                for (int size = this.f25109a.f25107h.size() - 1; size >= 0; size--) {
                    if (this.f25109a.f25107h.get(size).getType() == d2.y3 && (d2Var = (d2) this.f25109a.f25107h.get(size)) != null && d2Var.l1() != null && closedIds.contains(Long.valueOf(d2Var.l1().live_id))) {
                        this.f25109a.f25107h.remove(size);
                        z = true;
                    }
                }
                if (!z || this.f25109a.f25108i == null) {
                    return;
                }
                this.f25109a.f25108i.a(49, this.f25109a.f25105f, this.f25109a.f25106g, this.f25109a.f25107h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25110a;

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
            this.f25110a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    this.f25110a.f25108i.a(49, this.f25110a.f25105f, null, null);
                    return;
                }
                FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
                if (frsPageAlaTabResponseMessage.errCode != 0) {
                    if (this.f25110a.f25108i != null) {
                        this.f25110a.f25108i.a(49, this.f25110a.f25105f, null, null);
                        return;
                    }
                    return;
                }
                ArrayList<n> arrayList = frsPageAlaTabResponseMessage.mThreadList;
                ArrayList<n> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
                l1 l1Var = frsPageAlaTabResponseMessage.pageInfo;
                int i2 = frsPageAlaTabResponseMessage.alaLiveCount;
                this.f25110a.f25106g = l1Var;
                if (l1Var.f26789c == 1) {
                    this.f25110a.f25107h.clear();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i2)));
                if (this.f25110a.f25108i != null) {
                    if (arrayList != null && arrayList.size() > 0) {
                        this.f25110a.f25107h.addAll(arrayList);
                        this.f25110a.f25108i.a(49, this.f25110a.f25105f, l1Var, this.f25110a.f25107h);
                        return;
                    }
                    d2 d2Var = new d2();
                    d2Var.z4(51);
                    if (this.f25110a.f25107h.size() == 0 || (this.f25110a.f25107h.size() > 0 && ((d2) this.f25110a.f25107h.get(0)).o1() != 51)) {
                        this.f25110a.f25107h.add(0, d2Var);
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        d2Var.i1 = true;
                        if (arrayList2.get(0) != null) {
                            ((d2) arrayList2.get(0)).h1 = true;
                        }
                        this.f25110a.f25107h.addAll(arrayList2);
                    }
                    this.f25110a.f25108i.a(49, this.f25110a.f25105f, l1Var, this.f25110a.f25107h);
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
        this.f25107h = new ArrayList<>();
        this.j = new C1224a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        this.k = new b(this, AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdUniqueId bdUniqueId = this.f25104e;
            if (bdUniqueId != null) {
                this.k.setTag(bdUniqueId);
                this.j.setTag(this.f25104e);
            }
            MessageManager.getInstance().registerListener(this.j);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    @Override // b.a.r0.x0.o0
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
        this.f25104e = bdUniqueId;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    @Override // b.a.r0.x0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
            tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            f();
        }
    }

    @Override // b.a.r0.x0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, y0Var) == null) {
            this.f25105f = i3;
            if (y0Var != null && !TextUtils.isEmpty(y0Var.f26787a) && !TextUtils.isEmpty(y0Var.f26788b)) {
                if (y0Var.f26789c <= 0) {
                    y0Var.f26789c = 1;
                }
                MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, y0Var.f26787a, y0Var.f26788b, y0Var.f26789c));
                return;
            }
            this.f25108i.a(49, this.f25105f, null, null);
        }
    }

    @Override // b.a.r0.x0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, s0Var) == null) {
            this.f25108i = s0Var;
        }
    }
}
