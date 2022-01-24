package c.a.t0;

import android.content.Intent;
import c.a.t0.k3.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.LogoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f15794h;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15795b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.l.c f15796c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f15797d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f15798e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f15799f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f15800g;

    /* loaded from: classes7.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016522 || y.q().n() == null) {
                return;
            }
            y.q().n().b();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof LogoActivity)) {
                    this.a.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || this.a.a == 0) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data.getClass().getSimpleName().equals(LoginActivity.E) || (data instanceof LogoActivity) || MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            boolean f2 = this.a.f();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - this.a.a > 5) {
                new StatisticItem(TbadkCoreStatisticKey.HOT_SPLASH_APP_START).param("obj_param1", f2 ? 1 : 0).param(TiebaStatic.Params.OBJ_PARAM2, currentTimeMillis - this.a.a).param(TiebaStatic.Params.OBJ_PARAM3, c.a.s0.s.z.a.f13863b ? 1 : 0).eventStat();
                if (c.a.s0.s.z.a.f13863b) {
                    c.a.s0.s.z.a.f13863b = false;
                }
            }
            if (f2) {
                if (data instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) data;
                    Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                    intent.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                    intent.setFlags(65536);
                    baseActivity.startActivity(intent);
                } else if (data instanceof BaseFragmentActivity) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
                TbadkCoreApplication.getInst().setCanShowHotSplash(2);
                return;
            }
            TbadkCoreApplication.getInst().setCanShowHotSplash(1);
        }
    }

    /* renamed from: c.a.t0.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1005d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1005d(d dVar, int i2) {
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
            this.a = dVar;
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
                        d dVar = this.a;
                        dVar.f15795b = currentTimeMillis - dVar.a <= 1;
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
        this.f15797d = new a(this, 2016522);
        this.f15798e = new b(this, 2016521);
        this.f15799f = new c(this, 2016520);
        this.f15800g = new C1005d(this, 2016523);
        this.f15795b = false;
        MessageManager.getInstance().registerListener(this.f15798e);
        MessageManager.getInstance().registerListener(this.f15799f);
        MessageManager.getInstance().registerListener(this.f15797d);
        MessageManager.getInstance().registerListener(this.f15800g);
        if (y.q().n() != null) {
            y.q().n().c();
        }
    }

    public static d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f15794h == null) {
                synchronized (d.class) {
                    if (f15794h == null) {
                        f15794h = new d();
                    }
                }
            }
            return f15794h;
        }
        return (d) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis() / 1000;
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int h2 = h();
            int i2 = i();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.f15795b) {
                this.f15795b = false;
                return false;
            }
            long j2 = this.a;
            if (currentTimeMillis - j2 > 2 && currentTimeMillis - j2 > h2) {
                c.a.t0.k3.s n = y.q().n();
                int a2 = n != null ? n.a() : i2;
                PrintStream printStream = System.out;
                printStream.println("TestTest => hotSplashMaxTime: " + i2 + " currentTime: " + a2 + " interval: " + h2);
                return a2 < i2;
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
            if (this.f15796c == null && (runTask = MessageManager.getInstance().runTask(2921564, c.a.s0.l.c.class)) != null) {
                this.f15796c = (c.a.s0.l.c) runTask.getData();
            }
            c.a.s0.l.c cVar = this.f15796c;
            if (cVar != null) {
                return (int) (cVar.a() * 60.0f);
            }
            c.a.s0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
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
            if (this.f15796c == null && (runTask = MessageManager.getInstance().runTask(2921564, c.a.s0.l.c.class)) != null) {
                this.f15796c = (c.a.s0.l.c) runTask.getData();
            }
            c.a.s0.l.c cVar = this.f15796c;
            if (cVar != null) {
                return cVar.b();
            }
            return 3;
        }
        return invokeV.intValue;
    }
}
