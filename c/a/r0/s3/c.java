package c.a.r0.s3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import c.a.d.f.p.l;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static c f23509g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.s3.b a;

    /* renamed from: b  reason: collision with root package name */
    public int f23510b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f23511c;

    /* renamed from: d  reason: collision with root package name */
    public C1356c f23512d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f23513e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f23514f;

    /* loaded from: classes6.dex */
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
            C1356c c1356c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 5) {
                    return;
                }
                Object obj = message.obj;
                if (!(obj instanceof C1356c) || (c1356c = (C1356c) obj) == null) {
                    return;
                }
                c1356c.f23517d = false;
                c1356c.a = false;
                c1356c.f23515b = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (this.a.f23511c != null) {
                this.a.f23511c.clear();
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
        this.f23513e = new a(this, Looper.getMainLooper());
        this.f23514f = new b(this, 2005016);
        this.f23510b = c.a.q0.s.e0.b.j().k("card_show_statistic_max_count", 200);
        this.a = new c.a.r0.s3.b();
        MessageManager.getInstance().registerListener(this.f23514f);
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f23509g == null) {
                synchronized (c.class) {
                    if (f23509g == null) {
                        f23509g = new c();
                    }
                }
            }
            return f23509g;
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
        if (this.f23511c == null) {
            this.f23511c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f23511c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f23511c.put(bdUniqueId.getId(), hashSet);
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
            if (this.f23512d == null) {
                this.f23512d = new C1356c(this, null);
            }
            if (this.f23512d.f23517d) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1356c c1356c = this.f23512d;
            if (c1356c.a) {
                int i2 = c1356c.f23515b + 1;
                c1356c.f23515b = i2;
                if (currentTimeMillis - c1356c.f23516c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= this.f23510b) {
                        c1356c.f23517d = true;
                        f(c1356c);
                        return true;
                    }
                } else {
                    c1356c.a = false;
                    c1356c.f23515b = 0;
                }
            } else {
                c1356c.a = true;
                c1356c.f23516c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f(C1356c c1356c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c1356c) == null) {
            Message obtainMessage = this.f23513e.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1356c;
            this.f23513e.removeMessages(5);
            this.f23513e.sendMessageDelayed(obtainMessage, 300000L);
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
            l.c();
            if (bdUniqueId == null) {
                return;
            }
            this.a.f(bdUniqueId);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (sparseArray = this.f23511c) == null) {
            return;
        }
        sparseArray.remove(bdUniqueId.getId());
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            l.c();
            if (bdUniqueId == null) {
                return;
            }
            this.a.h(bdUniqueId);
            j(bdUniqueId);
        }
    }

    /* renamed from: c.a.r0.s3.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1356c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f23515b;

        /* renamed from: c  reason: collision with root package name */
        public long f23516c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f23517d;

        public C1356c(c cVar) {
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
            this.f23515b = 0;
            this.f23516c = 0L;
            this.f23517d = false;
        }

        public /* synthetic */ C1356c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
