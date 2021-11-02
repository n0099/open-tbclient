package b.a.r0.p2.i.a;

import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
import b.a.r0.b0.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22373a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f22374b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.p2.i.b.a f22375c;

    /* renamed from: d  reason: collision with root package name */
    public int f22376d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f22377e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f22378f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f22379g;

    /* loaded from: classes5.dex */
    public class a implements r.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d2 f22380a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f22381b;

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
            this.f22381b = bVar;
            this.f22380a = d2Var;
        }

        @Override // b.a.r0.b0.r.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f22381b.f22373a.getPageActivity(), R.string.thread_has_hide);
                }
                this.f22381b.h(z, this.f22380a);
            }
        }
    }

    /* renamed from: b.a.r0.p2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1090b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22382a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1090b(b bVar, int i2) {
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
            this.f22382a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d2) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.f22382a.f22374b && this.f22382a.f22375c != null && this.f22382a.f22375c.isAvaliableToShowManageWindow()) {
                this.f22382a.k((d2) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22383a;

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
            this.f22383a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f22383a.j((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22384a;

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
            this.f22384a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f22384a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, b.a.r0.p2.i.b.a aVar, int i2) {
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
        this.f22377e = new C1090b(this, 2921428);
        this.f22378f = new c(this, 2016557);
        this.f22379g = new d(this, 2921436);
        this.f22373a = tbPageContext;
        this.f22374b = bdUniqueId;
        this.f22375c = aVar;
        this.f22376d = i2;
        this.f22377e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f22377e);
        this.f22378f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f22378f);
        this.f22379g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f22379g);
    }

    public final void h(boolean z, d2 d2Var) {
        b.a.r0.p2.i.b.a aVar;
        d2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, d2Var) == null) || d2Var == null || (aVar = this.f22375c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f22375c.getMainView() == null || this.f22375c.getMainView().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f22375c.getListData().size()) {
                break;
            }
            n nVar = this.f22375c.getListData().get(i2);
            if (nVar != null && (e2 = b.a.r0.p2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.E) && e2.E.equals(d2Var.E)) {
                e2.j2 = z;
                b.a.r0.b0.e0.b d2 = b.a.r0.p2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f22375c.getListData().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f22375c.getMainView().n(this.f22375c.getListData());
        }
    }

    public final void i(String str) {
        b.a.r0.p2.i.b.a aVar;
        d2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f22375c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f22375c.getMainView() == null || this.f22375c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f22375c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = b.a.r0.p2.i.c.a.e(next)) != null && e2.L() != null && !StringUtils.isNull(e2.L().oriUgcNid) && e2.L().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f22375c.getMainView().n(this.f22375c.getListData());
        }
    }

    public final void j(String str) {
        b.a.r0.p2.i.b.a aVar;
        d2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f22375c) == null || ListUtils.isEmpty(aVar.getListData()) || this.f22375c.getMainView() == null || this.f22375c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f22375c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = b.a.r0.p2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.E) && e2.E.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f22375c.getMainView().n(this.f22375c.getListData());
        }
    }

    public final void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.t = d2Var;
            cardPersonDynamicThreadData.f47456e = String.valueOf(d2Var.T());
            cardPersonDynamicThreadData.f47457f = d2Var.E;
            cardPersonDynamicThreadData.f47460i = d2Var.k2;
            cardPersonDynamicThreadData.s = d2Var.j2;
            if (d2Var != null && d2Var.L() != null) {
                cardPersonDynamicThreadData.K = d2Var.L().oriUgcNid;
            }
            r rVar = new r(this.f22373a);
            rVar.t(this.f22376d == 1);
            rVar.o();
            rVar.s(new a(this, d2Var));
            rVar.n(cardPersonDynamicThreadData, false);
            rVar.u();
        }
    }
}
