package c.a.q0.h3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static c f18785g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.q0.h3.b f18786a;

    /* renamed from: b  reason: collision with root package name */
    public int f18787b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f18788c;

    /* renamed from: d  reason: collision with root package name */
    public C0899c f18789d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f18790e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f18791f;

    /* loaded from: classes3.dex */
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
            C0899c c0899c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 5) {
                    return;
                }
                Object obj = message.obj;
                if (!(obj instanceof C0899c) || (c0899c = (C0899c) obj) == null) {
                    return;
                }
                c0899c.f18796d = false;
                c0899c.f18793a = false;
                c0899c.f18794b = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18792a;

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
            this.f18792a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f18792a.f18788c != null) {
                this.f18792a.f18788c.clear();
            }
            this.f18792a.f18786a.g();
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
        this.f18790e = new a(this, Looper.getMainLooper());
        this.f18791f = new b(this, 2005016);
        this.f18787b = c.a.p0.s.d0.b.j().k("card_show_statistic_max_count", 200);
        this.f18786a = new c.a.q0.h3.b();
        MessageManager.getInstance().registerListener(this.f18791f);
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f18785g == null) {
                synchronized (c.class) {
                    if (f18785g == null) {
                        f18785g = new c();
                    }
                }
            }
            return f18785g;
        }
        return (c) invokeV.objValue;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bdUniqueId, statisticItem) == null) {
            this.f18786a.d(bdUniqueId, true);
            TiebaStatic.log(statisticItem);
        }
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId, str, statisticItem) == null) || bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f18786a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f18788c == null) {
            this.f18788c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f18788c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f18788c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f18786a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f18789d == null) {
                this.f18789d = new C0899c(this, null);
            }
            if (this.f18789d.f18796d) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C0899c c0899c = this.f18789d;
            if (c0899c.f18793a) {
                int i2 = c0899c.f18794b + 1;
                c0899c.f18794b = i2;
                if (currentTimeMillis - c0899c.f18795c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= this.f18787b) {
                        c0899c.f18796d = true;
                        f(c0899c);
                        return true;
                    }
                } else {
                    c0899c.f18793a = false;
                    c0899c.f18794b = 0;
                }
            } else {
                c0899c.f18793a = true;
                c0899c.f18795c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f(C0899c c0899c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c0899c) == null) {
            Message obtainMessage = this.f18790e.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c0899c;
            this.f18790e.removeMessages(5);
            this.f18790e.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bdUniqueId, z) == null) {
            if (BdLog.isDebugMode()) {
                BdLog.d("logStatisticByKey start write log ");
            }
            this.f18786a.d(bdUniqueId, z);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            l.d();
            if (bdUniqueId == null) {
                return;
            }
            this.f18786a.f(bdUniqueId);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (sparseArray = this.f18788c) == null) {
            return;
        }
        sparseArray.remove(bdUniqueId.getId());
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            l.d();
            if (bdUniqueId == null) {
                return;
            }
            this.f18786a.h(bdUniqueId);
            j(bdUniqueId);
        }
    }

    /* renamed from: c.a.q0.h3.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0899c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f18793a;

        /* renamed from: b  reason: collision with root package name */
        public int f18794b;

        /* renamed from: c  reason: collision with root package name */
        public long f18795c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f18796d;

        public C0899c(c cVar) {
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
            this.f18793a = false;
            this.f18794b = 0;
            this.f18795c = 0L;
            this.f18796d = false;
        }

        public /* synthetic */ C0899c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
