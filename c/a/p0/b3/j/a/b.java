package c.a.p0.b3.j.a;

import c.a.d.f.p.n;
import c.a.p0.h0.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f12784b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.b3.j.b.a f12785c;

    /* renamed from: d  reason: collision with root package name */
    public int f12786d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f12787e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f12788f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f12789g;

    /* loaded from: classes2.dex */
    public class a implements r.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f12790b;

        public a(b bVar, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12790b = bVar;
            this.a = threadData;
        }

        @Override // c.a.p0.h0.r.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    n.M(this.f12790b.a.getPageActivity(), R.string.obfuscated_res_0x7f0f1399);
                }
                this.f12790b.h(z, this.a);
            }
        }
    }

    /* renamed from: c.a.p0.b3.j.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0962b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0962b(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ThreadData) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.a.f12784b && this.a.f12785c != null && this.a.f12785c.i0()) {
                this.a.k((ThreadData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.j((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, c.a.p0.b3.j.b.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12787e = new C0962b(this, 2921428);
        this.f12788f = new c(this, 2016557);
        this.f12789g = new d(this, 2921436);
        this.a = tbPageContext;
        this.f12784b = bdUniqueId;
        this.f12785c = aVar;
        this.f12786d = i;
        this.f12787e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f12787e);
        this.f12788f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f12788f);
        this.f12789g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f12789g);
    }

    public final void h(boolean z, ThreadData threadData) {
        c.a.p0.b3.j.b.a aVar;
        ThreadData e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, threadData) == null) || threadData == null || (aVar = this.f12785c) == null || ListUtils.isEmpty(aVar.F()) || this.f12785c.getMainView() == null || this.f12785c.getMainView().e() == null) {
            return;
        }
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= this.f12785c.F().size()) {
                break;
            }
            c.a.d.o.e.n nVar = this.f12785c.F().get(i);
            if (nVar != null && (e2 = c.a.p0.b3.j.c.a.e(nVar)) != null && !StringUtils.isNull(e2.tid) && e2.tid.equals(threadData.tid)) {
                e2.isPrivacy = z;
                c.a.p0.h0.e0.b d2 = c.a.p0.b3.j.c.a.d(e2);
                if (d2 != null) {
                    this.f12785c.F().set(i, d2);
                    z2 = true;
                    break;
                }
            }
            i++;
        }
        if (z2) {
            this.f12785c.getMainView().n(this.f12785c.F());
        }
    }

    public final void i(String str) {
        c.a.p0.b3.j.b.a aVar;
        ThreadData e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f12785c) == null || ListUtils.isEmpty(aVar.F()) || this.f12785c.getMainView() == null || this.f12785c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<c.a.d.o.e.n> it = this.f12785c.F().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.d.o.e.n next = it.next();
            if (next != null && (e2 = c.a.p0.b3.j.c.a.e(next)) != null && e2.getBaijiahaoData() != null && !StringUtils.isNull(e2.getBaijiahaoData().oriUgcNid) && e2.getBaijiahaoData().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f12785c.getMainView().n(this.f12785c.F());
        }
    }

    public final void j(String str) {
        c.a.p0.b3.j.b.a aVar;
        ThreadData e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f12785c) == null || ListUtils.isEmpty(aVar.F()) || this.f12785c.getMainView() == null || this.f12785c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<c.a.d.o.e.n> it = this.f12785c.F().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.d.o.e.n next = it.next();
            if (next != null && (e2 = c.a.p0.b3.j.c.a.e(next)) != null && !StringUtils.isNull(e2.tid) && e2.tid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f12785c.getMainView().n(this.f12785c.F());
        }
    }

    public final void k(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.p = threadData;
            cardPersonDynamicThreadData.a = String.valueOf(threadData.getFid());
            cardPersonDynamicThreadData.f31670b = threadData.tid;
            cardPersonDynamicThreadData.f31673e = threadData.person_center_post_id;
            cardPersonDynamicThreadData.o = threadData.isPrivacy;
            if (threadData != null && threadData.getBaijiahaoData() != null) {
                cardPersonDynamicThreadData.G = threadData.getBaijiahaoData().oriUgcNid;
            }
            r rVar = new r(this.a);
            rVar.t(this.f12786d == 1);
            rVar.o();
            rVar.s(new a(this, threadData));
            rVar.n(cardPersonDynamicThreadData, false);
            rVar.u();
        }
    }
}
