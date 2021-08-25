package c.a.q0.v.i.c;

import android.text.TextUtils;
import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.q0.v0.b1;
import c.a.q0.v0.o0;
import c.a.q0.v0.s0;
import c.a.q0.v0.y0;
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
    public BdUniqueId f25592e;

    /* renamed from: f  reason: collision with root package name */
    public int f25593f;

    /* renamed from: g  reason: collision with root package name */
    public b1 f25594g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<n> f25595h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f25596i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.c.g.a f25597j;
    public HttpMessageListener k;

    /* renamed from: c.a.q0.v.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1192a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25598a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1192a(a aVar, int i2, int i3) {
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
            this.f25598a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c2 c2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == this.f25598a.f25592e) {
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage ? ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds() : null;
                if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    closedIds = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (ListUtils.isEmpty(this.f25598a.f25595h) || ListUtils.isEmpty(closedIds)) {
                    return;
                }
                boolean z = false;
                for (int size = this.f25598a.f25595h.size() - 1; size >= 0; size--) {
                    if (this.f25598a.f25595h.get(size).getType() == c2.u3 && (c2Var = (c2) this.f25598a.f25595h.get(size)) != null && c2Var.j1() != null && closedIds.contains(Long.valueOf(c2Var.j1().live_id))) {
                        this.f25598a.f25595h.remove(size);
                        z = true;
                    }
                }
                if (!z || this.f25598a.f25596i == null) {
                    return;
                }
                this.f25598a.f25596i.a(49, this.f25598a.f25593f, this.f25598a.f25594g, this.f25598a.f25595h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25599a;

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
            this.f25599a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    this.f25599a.f25596i.a(49, this.f25599a.f25593f, null, null);
                    return;
                }
                FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
                if (frsPageAlaTabResponseMessage.errCode != 0) {
                    if (this.f25599a.f25596i != null) {
                        this.f25599a.f25596i.a(49, this.f25599a.f25593f, null, null);
                        return;
                    }
                    return;
                }
                ArrayList<n> arrayList = frsPageAlaTabResponseMessage.mThreadList;
                ArrayList<n> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
                b1 b1Var = frsPageAlaTabResponseMessage.pageInfo;
                int i2 = frsPageAlaTabResponseMessage.alaLiveCount;
                this.f25599a.f25594g = b1Var;
                if (b1Var.f27377c == 1) {
                    this.f25599a.f25595h.clear();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i2)));
                if (this.f25599a.f25596i != null) {
                    if (arrayList != null && arrayList.size() > 0) {
                        this.f25599a.f25595h.addAll(arrayList);
                        this.f25599a.f25596i.a(49, this.f25599a.f25593f, b1Var, this.f25599a.f25595h);
                        return;
                    }
                    c2 c2Var = new c2();
                    c2Var.p4(51);
                    if (this.f25599a.f25595h.size() == 0 || (this.f25599a.f25595h.size() > 0 && ((c2) this.f25599a.f25595h.get(0)).m1() != 51)) {
                        this.f25599a.f25595h.add(0, c2Var);
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c2Var.f1 = true;
                        if (arrayList2.get(0) != null) {
                            ((c2) arrayList2.get(0)).e1 = true;
                        }
                        this.f25599a.f25595h.addAll(arrayList2);
                    }
                    this.f25599a.f25596i.a(49, this.f25599a.f25593f, b1Var, this.f25599a.f25595h);
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
        this.f25595h = new ArrayList<>();
        this.f25597j = new C1192a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        this.k = new b(this, AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdUniqueId bdUniqueId = this.f25592e;
            if (bdUniqueId != null) {
                this.k.setTag(bdUniqueId);
                this.f25597j.setTag(this.f25592e);
            }
            MessageManager.getInstance().registerListener(this.f25597j);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    @Override // c.a.q0.v0.o0
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
        this.f25592e = bdUniqueId;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f25597j);
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    @Override // c.a.q0.v0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
            tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            f();
        }
    }

    @Override // c.a.q0.v0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, y0Var) == null) {
            this.f25593f = i3;
            if (y0Var != null && !TextUtils.isEmpty(y0Var.f27375a) && !TextUtils.isEmpty(y0Var.f27376b)) {
                if (y0Var.f27377c <= 0) {
                    y0Var.f27377c = 1;
                }
                MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, y0Var.f27375a, y0Var.f27376b, y0Var.f27377c));
                return;
            }
            this.f25596i.a(49, this.f25593f, null, null);
        }
    }

    @Override // c.a.q0.v0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, s0Var) == null) {
            this.f25596i = s0Var;
        }
    }
}
