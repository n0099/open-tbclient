package c.a.r0;

import android.content.Intent;
import c.a.r0.z2.s;
import c.a.r0.z2.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.LogoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f16585h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f16586a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f16587b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.l.c f16588c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f16589d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f16590e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f16591f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f16592g;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016522 || y.o().n() == null) {
                return;
            }
            y.o().n().b();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f16593a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f16593a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                this.f16593a.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f16594a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f16594a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || this.f16594a.f16586a == 0) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data.getClass().getSimpleName().equals(LoginActivity.D)) {
                return;
            }
            if (this.f16594a.f()) {
                if (data instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) data;
                    Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                    intent.putExtra("splash", true);
                    intent.setFlags(65536);
                    baseActivity.startActivity(intent);
                } else if (data instanceof BaseFragmentActivity) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
                TbadkCoreApplication.getInst().setCanShowHotSplash(2);
                return;
            }
            TbadkCoreApplication.getInst().setCanShowHotSplash(1);
        }
    }

    /* renamed from: c.a.r0.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0793d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f16595a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0793d(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f16595a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        d dVar = this.f16595a;
                        dVar.f16587b = currentTimeMillis - dVar.f16586a <= 1;
                    }
                }
            }
        }
    }

    public d() {
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
        this.f16589d = new a(this, 2016522);
        this.f16590e = new b(this, 2016521);
        this.f16591f = new c(this, 2016520);
        this.f16592g = new C0793d(this, 2016523);
        this.f16587b = false;
        MessageManager.getInstance().registerListener(this.f16590e);
        MessageManager.getInstance().registerListener(this.f16591f);
        MessageManager.getInstance().registerListener(this.f16589d);
        MessageManager.getInstance().registerListener(this.f16592g);
        if (y.o().n() != null) {
            y.o().n().c();
        }
    }

    public static d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f16585h == null) {
                synchronized (d.class) {
                    if (f16585h == null) {
                        f16585h = new d();
                    }
                }
            }
            return f16585h;
        }
        return (d) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16586a = System.currentTimeMillis() / 1000;
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int h2 = h();
            int i2 = i();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.f16587b) {
                this.f16587b = false;
                return false;
            }
            long j2 = this.f16586a;
            if (currentTimeMillis - j2 > 2 && currentTimeMillis - j2 > h2) {
                s n = y.o().n();
                return (n != null ? n.a() : i2) < i2;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int h() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f16588c == null && (runTask = MessageManager.getInstance().runTask(2921564, c.a.q0.l.c.class)) != null) {
                this.f16588c = (c.a.q0.l.c) runTask.getData();
            }
            c.a.q0.l.c cVar = this.f16588c;
            if (cVar != null) {
                return (int) (cVar.a() * 60.0f);
            }
            c.a.q0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                int b2 = adAdSense.b();
                if (b2 <= 0) {
                    return 86400;
                }
                return b2;
            }
            return 300;
        }
        return invokeV.intValue;
    }

    public final int i() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f16588c == null && (runTask = MessageManager.getInstance().runTask(2921564, c.a.q0.l.c.class)) != null) {
                this.f16588c = (c.a.q0.l.c) runTask.getData();
            }
            c.a.q0.l.c cVar = this.f16588c;
            if (cVar != null) {
                return cVar.b();
            }
            return 3;
        }
        return invokeV.intValue;
    }
}
