package c.a.s0.x2.i.a;

import c.a.d.f.p.m;
import c.a.d.m.e.n;
import c.a.r0.s.r.d2;
import c.a.s0.g0.s;
import c.a.s0.y2.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f25786b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.x2.i.b.a f25787c;

    /* renamed from: d  reason: collision with root package name */
    public int f25788d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f25789e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f25790f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f25791g;

    /* loaded from: classes8.dex */
    public class a implements s.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d2 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f25792b;

        public a(b bVar, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25792b = bVar;
            this.a = d2Var;
        }

        @Override // c.a.s0.g0.s.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    m.L(this.f25792b.a.getPageActivity(), g.thread_has_hide);
                }
                this.f25792b.h(z, this.a);
            }
        }
    }

    /* renamed from: c.a.s0.x2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1494b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1494b(b bVar, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d2) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.a.f25786b && this.a.f25787c != null && this.a.f25787c.isAvaliableToShowManageWindow()) {
                this.a.k((d2) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.j((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, c.a.s0.x2.i.b.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25789e = new C1494b(this, 2921428);
        this.f25790f = new c(this, 2016557);
        this.f25791g = new d(this, 2921436);
        this.a = tbPageContext;
        this.f25786b = bdUniqueId;
        this.f25787c = aVar;
        this.f25788d = i2;
        this.f25789e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f25789e);
        this.f25790f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f25790f);
        this.f25791g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f25791g);
    }

    public final void h(boolean z, d2 d2Var) {
        c.a.s0.x2.i.b.a aVar;
        d2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, d2Var) == null) || d2Var == null || (aVar = this.f25787c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f25787c.getMainView() == null || this.f25787c.getMainView().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f25787c.getListData().size()) {
                break;
            }
            n nVar = this.f25787c.getListData().get(i2);
            if (nVar != null && (e2 = c.a.s0.x2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.E) && e2.E.equals(d2Var.E)) {
                e2.m2 = z;
                c.a.s0.g0.f0.b d2 = c.a.s0.x2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f25787c.getListData().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f25787c.getMainView().n(this.f25787c.getListData());
        }
    }

    public final void i(String str) {
        c.a.s0.x2.i.b.a aVar;
        d2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f25787c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f25787c.getMainView() == null || this.f25787c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f25787c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = c.a.s0.x2.i.c.a.e(next)) != null && e2.L() != null && !StringUtils.isNull(e2.L().oriUgcNid) && e2.L().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f25787c.getMainView().n(this.f25787c.getListData());
        }
    }

    public final void j(String str) {
        c.a.s0.x2.i.b.a aVar;
        d2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f25787c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f25787c.getMainView() == null || this.f25787c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f25787c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = c.a.s0.x2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.E) && e2.E.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f25787c.getMainView().n(this.f25787c.getListData());
        }
    }

    public final void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.t = d2Var;
            cardPersonDynamicThreadData.f43777e = String.valueOf(d2Var.U());
            cardPersonDynamicThreadData.f43778f = d2Var.E;
            cardPersonDynamicThreadData.f43781i = d2Var.n2;
            cardPersonDynamicThreadData.s = d2Var.m2;
            if (d2Var != null && d2Var.L() != null) {
                cardPersonDynamicThreadData.K = d2Var.L().oriUgcNid;
            }
            s sVar = new s(this.a);
            sVar.t(this.f25788d == 1);
            sVar.o();
            sVar.s(new a(this, d2Var));
            sVar.n(cardPersonDynamicThreadData, false);
            sVar.u();
        }
    }
}
