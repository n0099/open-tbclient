package c.a.q0.b2.j;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.e.c.g.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.myCollection.message.RequestQueryCollectUpdateNumMessage;
import com.baidu.tieba.myCollection.message.ResponseQueryCollectUpdateNumMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f15999d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f16000a;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public final Handler f16001b;

    /* renamed from: c  reason: collision with root package name */
    public final c f16002c;

    /* renamed from: c.a.q0.b2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0759a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16003a;

        public HandlerC0759a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16003a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                this.f16003a.f16000a = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                this.f16003a.f16001b.sendMessageDelayed(this.f16003a.f16001b.obtainMessage(1), 1800000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
                c.a.p0.t.d.b.g0().a0(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1544971796, "Lc/a/q0/b2/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1544971796, "Lc/a/q0/b2/j/a;");
                return;
            }
        }
        c.a.q0.i3.d0.a.g(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        f15999d = null;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16000a = 0L;
        this.f16001b = new HandlerC0759a(this);
        this.f16002c = new b(this, 303005);
        MessageManager.getInstance().registerListener(this.f16002c);
    }

    public static synchronized a d() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (a.class) {
                if (f15999d == null) {
                    f15999d = new a();
                }
                aVar = f15999d;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16001b.removeMessages(1);
            this.f16001b.removeMessages(2);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16000a = 0L;
            c();
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f16000a;
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis >= 1800000) {
                Handler handler = this.f16001b;
                handler.sendMessageDelayed(handler.obtainMessage(1), 10000L);
            } else {
                long j2 = 1800000 - currentTimeMillis;
                Handler handler2 = this.f16001b;
                handler2.sendMessageDelayed(handler2.obtainMessage(1), j2);
            }
            this.f16000a = System.currentTimeMillis();
        }
    }
}
