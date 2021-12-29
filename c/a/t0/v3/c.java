package c.a.t0.v3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import c.a.d.f.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static c f25343g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.t0.v3.b a;

    /* renamed from: b  reason: collision with root package name */
    public int f25344b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f25345c;

    /* renamed from: d  reason: collision with root package name */
    public C1478c f25346d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f25347e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f25348f;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1478c c1478c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 5) {
                    return;
                }
                Object obj = message.obj;
                if (!(obj instanceof C1478c) || (c1478c = (C1478c) obj) == null) {
                    return;
                }
                c1478c.f25351d = false;
                c1478c.a = false;
                c1478c.f25349b = 0;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.f25345c != null) {
                this.a.f25345c.clear();
            }
            this.a.a.g();
        }
    }

    public c() {
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
        this.f25347e = new a(this, Looper.getMainLooper());
        this.f25348f = new b(this, 2005016);
        this.f25344b = c.a.s0.s.g0.b.j().k("card_show_statistic_max_count", 200);
        this.a = new c.a.t0.v3.b();
        MessageManager.getInstance().registerListener(this.f25348f);
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f25343g == null) {
                synchronized (c.class) {
                    if (f25343g == null) {
                        f25343g = new c();
                    }
                }
            }
            return f25343g;
        }
        return (c) invokeV.objValue;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bdUniqueId, statisticItem) == null) {
            this.a.d(bdUniqueId, true);
            TiebaStatic.log(statisticItem);
        }
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId, str, statisticItem) == null) || bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f25345c == null) {
            this.f25345c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f25345c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f25345c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f25346d == null) {
                this.f25346d = new C1478c(this, null);
            }
            if (this.f25346d.f25351d) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1478c c1478c = this.f25346d;
            if (c1478c.a) {
                int i2 = c1478c.f25349b + 1;
                c1478c.f25349b = i2;
                if (currentTimeMillis - c1478c.f25350c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= this.f25344b) {
                        c1478c.f25351d = true;
                        f(c1478c);
                        return true;
                    }
                } else {
                    c1478c.a = false;
                    c1478c.f25349b = 0;
                }
            } else {
                c1478c.a = true;
                c1478c.f25350c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f(C1478c c1478c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c1478c) == null) {
            Message obtainMessage = this.f25347e.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1478c;
            this.f25347e.removeMessages(5);
            this.f25347e.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bdUniqueId, z) == null) {
            if (BdLog.isDebugMode()) {
                BdLog.d("logStatisticByKey start write log ");
            }
            this.a.d(bdUniqueId, z);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            n.c();
            if (bdUniqueId == null) {
                return;
            }
            this.a.f(bdUniqueId);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (sparseArray = this.f25345c) == null) {
            return;
        }
        sparseArray.remove(bdUniqueId.getId());
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            n.c();
            if (bdUniqueId == null) {
                return;
            }
            this.a.h(bdUniqueId);
            j(bdUniqueId);
        }
    }

    /* renamed from: c.a.t0.v3.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1478c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f25349b;

        /* renamed from: c  reason: collision with root package name */
        public long f25350c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f25351d;

        public C1478c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.f25349b = 0;
            this.f25350c = 0L;
            this.f25351d = false;
        }

        public /* synthetic */ C1478c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
