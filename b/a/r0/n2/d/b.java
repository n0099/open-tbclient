package b.a.r0.n2.d;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.b3.b;
import b.a.r0.n2.e.f;
import b.a.r0.n2.g.c;
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
/* loaded from: classes5.dex */
public class b implements c.InterfaceC1117c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PersonCenterModel f22915a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.n2.g.c f22916b;

    /* renamed from: c  reason: collision with root package name */
    public PersonCenterModel.c f22917c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f22918d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f22919e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f22920f;

    /* loaded from: classes5.dex */
    public class a implements PersonCenterModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22921a;

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
            this.f22921a = bVar;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f22921a.f22916b.d();
                this.f22921a.f22916b.j(fVar);
                if (fVar != null && fVar.p() != null) {
                    b.a.q0.s.l.f.b(fVar.p().getPersonPrivate());
                }
                b.a.r0.n2.a.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e2 = b.a.r0.n2.a.d().e();
                if (e2 > 0) {
                    b.a.r0.n2.a.d().k(System.currentTimeMillis() - e2);
                    b.a.r0.n2.a.d().j(0L);
                }
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.c
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (i2 != -1 || this.f22921a.f22915a.mIsDataLoaded) {
                    this.f22921a.f22916b.l(i2, str);
                } else {
                    this.f22921a.f22916b.n();
                }
            }
        }
    }

    /* renamed from: b.a.r0.n2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1116b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22922a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1116b(b bVar, int i2) {
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
            this.f22922a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.r0.b3.b bVar;
            SparseArray<b.a> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b.a.r0.b3.b) || (sparseArray = (bVar = (b.a.r0.b3.b) customResponsedMessage.getData()).f16502a) == null || sparseArray.size() <= 0) {
                return;
            }
            b.a aVar = bVar.f16502a.get(2);
            b.a aVar2 = bVar.f16502a.get(3);
            b.a aVar3 = bVar.f16502a.get(9);
            b.a aVar4 = bVar.f16502a.get(10);
            if (this.f22922a.f22915a.A() != null) {
                if (aVar2 != null) {
                    this.f22922a.f22915a.A().f(aVar2.f16503a);
                }
                if (aVar != null) {
                    this.f22922a.f22915a.A().d(aVar.f16503a);
                }
                if (aVar3 != null) {
                    this.f22922a.f22915a.A().c(aVar3.f16503a);
                }
                if (aVar4 != null) {
                    this.f22922a.f22915a.A().e(aVar4.f16503a);
                }
            }
            b.a aVar5 = bVar.f16502a.get(5);
            if (aVar5 != null) {
                this.f22922a.f22916b.o(5, aVar5.f16503a);
            }
            b.a aVar6 = bVar.f16502a.get(6);
            if (aVar6 != null) {
                this.f22922a.f22916b.o(6, aVar6.f16503a);
            }
            this.f22922a.f22916b.g();
        }
    }

    /* loaded from: classes5.dex */
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
            b.a.r0.b3.a.v().I(false);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22923a;

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
            this.f22923a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || (userPendantData = (UserPendantData) customResponsedMessage.getData()) == null) {
                return;
            }
            if (this.f22923a.f22915a.A() != null) {
                this.f22923a.f22915a.A().u(userPendantData);
                this.f22923a.f22916b.g();
                return;
            }
            this.f22923a.j();
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
        this.f22917c = new a(this);
        this.f22918d = new C1116b(this, 2001435);
        this.f22919e = new c(this, 2005016);
        this.f22920f = new d(this, 2016485);
        b.a.r0.n2.g.c cVar = new b.a.r0.n2.g.c(view, tbPageContext, bdUniqueId);
        this.f22916b = cVar;
        cVar.k(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.f22915a = personCenterModel;
        personCenterModel.F(this.f22917c);
        b.a.r0.b3.a.v();
        this.f22918d.setTag(bdUniqueId);
        this.f22919e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f22918d);
        MessageManager.getInstance().registerListener(this.f22919e);
        this.f22920f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f22920f);
    }

    @Override // b.a.r0.n2.g.c.InterfaceC1117c
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f22915a.loadData();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22916b.c();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22916b.e();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f22916b.h(i2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f22916b.i();
        }
    }

    public void h(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (A = this.f22915a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setPortrait(str);
        this.f22916b.g();
    }

    public void i(String str) {
        f A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (A = this.f22915a.A()) == null || A.p() == null) {
            return;
        }
        A.p().setName_show(str);
        this.f22916b.g();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.r0.n2.a.d().j(System.currentTimeMillis());
            this.f22915a.loadData();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f22915a.G(z);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f22916b.m();
        }
    }
}
