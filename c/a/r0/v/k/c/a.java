package c.a.r0.v.k.c;

import android.text.TextUtils;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.w0.b1;
import c.a.r0.w0.o0;
import c.a.r0.w0.s0;
import c.a.r0.w0.y0;
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
/* loaded from: classes4.dex */
public class a implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f26093e;

    /* renamed from: f  reason: collision with root package name */
    public int f26094f;

    /* renamed from: g  reason: collision with root package name */
    public b1 f26095g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<n> f26096h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f26097i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.c.g.a f26098j;
    public HttpMessageListener k;

    /* renamed from: c.a.r0.v.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1214a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26099a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1214a(a aVar, int i2, int i3) {
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
            this.f26099a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == this.f26099a.f26093e) {
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage ? ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds() : null;
                if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    closedIds = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (ListUtils.isEmpty(this.f26099a.f26096h) || ListUtils.isEmpty(closedIds)) {
                    return;
                }
                boolean z = false;
                for (int size = this.f26099a.f26096h.size() - 1; size >= 0; size--) {
                    if (this.f26099a.f26096h.get(size).getType() == d2.y3 && (d2Var = (d2) this.f26099a.f26096h.get(size)) != null && d2Var.l1() != null && closedIds.contains(Long.valueOf(d2Var.l1().live_id))) {
                        this.f26099a.f26096h.remove(size);
                        z = true;
                    }
                }
                if (!z || this.f26099a.f26097i == null) {
                    return;
                }
                this.f26099a.f26097i.a(49, this.f26099a.f26094f, this.f26099a.f26095g, this.f26099a.f26096h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26100a;

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
            this.f26100a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    this.f26100a.f26097i.a(49, this.f26100a.f26094f, null, null);
                    return;
                }
                FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
                if (frsPageAlaTabResponseMessage.errCode != 0) {
                    if (this.f26100a.f26097i != null) {
                        this.f26100a.f26097i.a(49, this.f26100a.f26094f, null, null);
                        return;
                    }
                    return;
                }
                ArrayList<n> arrayList = frsPageAlaTabResponseMessage.mThreadList;
                ArrayList<n> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
                b1 b1Var = frsPageAlaTabResponseMessage.pageInfo;
                int i2 = frsPageAlaTabResponseMessage.alaLiveCount;
                this.f26100a.f26095g = b1Var;
                if (b1Var.f28047c == 1) {
                    this.f26100a.f26096h.clear();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i2)));
                if (this.f26100a.f26097i != null) {
                    if (arrayList != null && arrayList.size() > 0) {
                        this.f26100a.f26096h.addAll(arrayList);
                        this.f26100a.f26097i.a(49, this.f26100a.f26094f, b1Var, this.f26100a.f26096h);
                        return;
                    }
                    d2 d2Var = new d2();
                    d2Var.y4(51);
                    if (this.f26100a.f26096h.size() == 0 || (this.f26100a.f26096h.size() > 0 && ((d2) this.f26100a.f26096h.get(0)).o1() != 51)) {
                        this.f26100a.f26096h.add(0, d2Var);
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        d2Var.i1 = true;
                        if (arrayList2.get(0) != null) {
                            ((d2) arrayList2.get(0)).h1 = true;
                        }
                        this.f26100a.f26096h.addAll(arrayList2);
                    }
                    this.f26100a.f26097i.a(49, this.f26100a.f26094f, b1Var, this.f26100a.f26096h);
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
        this.f26096h = new ArrayList<>();
        this.f26098j = new C1214a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        this.k = new b(this, AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdUniqueId bdUniqueId = this.f26093e;
            if (bdUniqueId != null) {
                this.k.setTag(bdUniqueId);
                this.f26098j.setTag(this.f26093e);
            }
            MessageManager.getInstance().registerListener(this.f26098j);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    @Override // c.a.r0.w0.o0
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
        this.f26093e = bdUniqueId;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f26098j);
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    @Override // c.a.r0.w0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
            tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            f();
        }
    }

    @Override // c.a.r0.w0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, y0Var) == null) {
            this.f26094f = i3;
            if (y0Var != null && !TextUtils.isEmpty(y0Var.f28045a) && !TextUtils.isEmpty(y0Var.f28046b)) {
                if (y0Var.f28047c <= 0) {
                    y0Var.f28047c = 1;
                }
                MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, y0Var.f28045a, y0Var.f28046b, y0Var.f28047c));
                return;
            }
            this.f26097i.a(49, this.f26094f, null, null);
        }
    }

    @Override // c.a.r0.w0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, s0Var) == null) {
            this.f26097i = s0Var;
        }
    }
}
