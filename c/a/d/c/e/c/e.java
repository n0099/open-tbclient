package c.a.d.c.e.c;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class e extends c.a.d.f.r.c {
    public static /* synthetic */ Interceptable $ic;
    public static Handler o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public CoderException f2394c;

    /* renamed from: d  reason: collision with root package name */
    public SocketMessage f2395d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f2396e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f2397f;

    /* renamed from: g  reason: collision with root package name */
    public g f2398g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2399h;

    /* renamed from: i  reason: collision with root package name */
    public int f2400i;

    /* renamed from: j  reason: collision with root package name */
    public int f2401j;
    public long k;
    public SocketMessageTask l;
    public long m;
    public long n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f2402e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2402e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2402e.A();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1190822249, "Lc/a/d/c/e/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1190822249, "Lc/a/d/c/e/c/e;");
                return;
            }
        }
        o = new Handler();
    }

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {socketMessage, socketMessageTask, gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2395d = null;
        this.f2396e = 0;
        this.f2397f = null;
        this.f2398g = null;
        this.f2399h = true;
        this.f2400i = 0;
        this.f2401j = 0;
        this.k = 0L;
        this.l = null;
        if (socketMessage != null && socketMessageTask != null) {
            this.l = socketMessageTask;
            this.f2395d = socketMessage;
            this.f2398g = gVar;
            return;
        }
        throw new InvalidParameterException("SenderData msg null");
    }

    public final void A() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (gVar = this.f2398g) != null && this.f2399h) {
            gVar.B(this);
        }
    }

    @Override // c.a.d.f.r.f0
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            o.removeCallbacks(u());
            x(i2);
        }
    }

    @Override // c.a.d.f.r.f0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            int cmd = this.f2395d.getCmd();
            int length = e() != null ? e().length : 0;
            long clientLogID = this.f2395d.getClientLogID();
            int i2 = this.f2396e;
            i.b("SenderData", cmd, clientLogID, i2, "StartSend", 0, "SenderData: start send size = " + length);
            o.removeCallbacks(u());
            if (this.l.getTimeOut() != null) {
                o.postDelayed(u(), this.l.getTimeOut().b());
            }
            z();
        }
    }

    @Override // c.a.d.f.r.f0
    public void c() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int cmd = this.f2395d.getCmd();
            if (e() != null) {
                i2 = e().length;
                this.f2395d.setEncodedBinarySize(i2);
            } else {
                i2 = 0;
            }
            long clientLogID = this.f2395d.getClientLogID();
            int i3 = this.f2396e;
            i.b("SenderData", cmd, clientLogID, i3, "FinishSend", 0, "SenderData: finish send  size = " + i2);
            if (!this.l.b()) {
                o.removeCallbacks(u());
            }
            y();
        }
    }

    @Override // c.a.d.f.r.c
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            this.f2394c = null;
            c.a.d.c.e.c.j.b f2 = c.a.d.c.e.c.j.b.f();
            this.f2396e = f.a().b();
            SocketMessage socketMessage = this.f2395d;
            if (socketMessage != null) {
                socketMessage.setSquencedId(this.f2396e);
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                SocketMessage socketMessage2 = this.f2395d;
                long clientLogID = socketMessage2 == null ? -1L : socketMessage2.getClientLogID();
                String valueOf = String.valueOf(this.f2396e & 4294967295L);
                Object[] objArr = new Object[2];
                objArr[0] = "cmd";
                SocketMessage socketMessage3 = this.f2395d;
                objArr[1] = Integer.valueOf(socketMessage3 == null ? -1 : socketMessage3.getCmd());
                bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
            }
            try {
                return f2.e(this.f2395d, this.f2396e, this.l.c(), this.l.getNeedEncrypt());
            } catch (CoderException e2) {
                this.f2394c = e2;
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.f2401j + 1;
            this.f2401j = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.f2400i + 1;
            this.f2400i = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l.d() : invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            o.removeCallbacks(u());
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SocketMessage socketMessage = this.f2395d;
            if (socketMessage != null) {
                return socketMessage.getCmd();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int retry = this.l.getRetry();
            if (retry > 1) {
                return retry;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public SocketMessage m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2395d : (SocketMessage) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l.getPriority() : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f2401j : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f2400i : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f2396e : invokeV.intValue;
    }

    public CoderException r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f2394c : (CoderException) invokeV.objValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : invokeV.longValue;
    }

    public SocketMessageTask t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l : (SocketMessageTask) invokeV.objValue;
    }

    public final Runnable u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f2397f == null) {
                this.f2397f = new a(this);
            }
            return this.f2397f;
        }
        return (Runnable) invokeV.objValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l.b() : invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            j();
            this.f2399h = false;
        }
    }

    public final void x(int i2) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i2) == null) && (gVar = this.f2398g) != null && this.f2399h) {
            gVar.y(i2, this);
        }
    }

    public final void y() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (gVar = this.f2398g) != null && this.f2399h) {
            gVar.z(this);
        }
    }

    public final void z() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (gVar = this.f2398g) != null && this.f2399h) {
            gVar.A(this);
        }
    }
}
