package c.a.q0.l2.d;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.l2.e.f;
import c.a.q0.l2.g.c;
import c.a.q0.y2.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements c.InterfaceC1012c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f21747a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.l2.g.c f21748b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f21749c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f21750d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f21751e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f21752f;

    /* loaded from: classes3.dex */
    public class a implements PersonCenterModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21753a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21753a = bVar;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f21753a.f21748b.d();
                this.f21753a.f21748b.j(fVar);
                if (fVar != null && fVar.p() != null) {
                    c.a.p0.s.l.f.b(fVar.p().getPersonPrivate());
                }
                c.a.q0.l2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e2 = c.a.q0.l2.a.d().e();
                if (e2 > 0) {
                    c.a.q0.l2.a.d().k(System.currentTimeMillis() - e2);
                    c.a.q0.l2.a.d().j(0L);
                }
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (i2 != -1 || this.f21753a.f21747a.mIsDataLoaded) {
                    this.f21753a.f21748b.l(i2, str);
                } else {
                    this.f21753a.f21748b.n();
                }
            }
        }
    }

    /* renamed from: c.a.q0.l2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1011b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21754a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1011b(b bVar, int i2) {
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
            this.f21754a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.q0.y2.b bVar;
            SparseArray<b.a> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.q0.y2.b) || (sparseArray = (bVar = (c.a.q0.y2.b) customResponsedMessage.getData()).f29142a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f29142a.get(2);
            b.a aVar2 = bVar.f29142a.get(3);
            b.a aVar3 = bVar.f29142a.get(9);
            b.a aVar4 = bVar.f29142a.get(10);
            if (this.f21754a.f21747a.A() != null) {
                if (aVar2 != null) {
                    this.f21754a.f21747a.A().f(aVar2.f29143a);
                }
                if (aVar != null) {
                    this.f21754a.f21747a.A().d(aVar.f29143a);
                }
                if (aVar3 != null) {
                    this.f21754a.f21747a.A().c(aVar3.f29143a);
                }
                if (aVar4 != null) {
                    this.f21754a.f21747a.A().e(aVar4.f29143a);
                }
            }
            b.a aVar5 = bVar.f29142a.get(5);
            if (aVar5 != null) {
                this.f21754a.f21748b.o(5, aVar5.f29143a);
            }
            b.a aVar6 = bVar.f29142a.get(6);
            if (aVar6 != null) {
                this.f21754a.f21748b.o(6, aVar6.f29143a);
            }
            this.f21754a.f21748b.g();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            c.a.q0.y2.a.v().I(false);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21755a;

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
            this.f21755a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || (userPendantData = (UserPendantData) customResponsedMessage.getData()) == null) {
                return;
            }
            if (this.f21755a.f21747a.A() != null) {
                this.f21755a.f21747a.A().u(userPendantData);
                this.f21755a.f21748b.g();
                return;
            }
            this.f21755a.j();
        }
    }

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21749c = new a(this);
        this.f21750d = new C1011b(this, 2001435);
        this.f21751e = new c(this, 2005016);
        this.f21752f = new d(this, 2016485);
        c.a.q0.l2.g.c cVar = new c.a.q0.l2.g.c(view, tbPageContext, bdUniqueId);
        this.f21748b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f21747a = personCenterModel;
        personCenterModel.F(this.f21749c);
        c.a.q0.y2.a.v();
        this.f21750d.setTag(bdUniqueId);
        this.f21751e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f21750d);
        MessageManager.getInstance().registerListener(this.f21751e);
        this.f21752f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f21752f);
    }

    @Override // c.a.q0.l2.g.c.InterfaceC1012c
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f21747a.LoadData();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21748b.c();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21748b.e();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f21748b.h(i2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f21748b.i();
        }
    }

    public void h(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (A = this.f21747a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setPortrait(str);
        this.f21748b.g();
    }

    public void i(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (A = this.f21747a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setName_show(str);
        this.f21748b.g();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.l2.a.d().j(System.currentTimeMillis());
            this.f21747a.LoadData();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f21747a.G(z);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f21748b.m();
        }
    }
}
