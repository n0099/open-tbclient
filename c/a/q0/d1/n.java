package c.a.q0.d1;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static n f12964i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12965a;

    /* renamed from: b  reason: collision with root package name */
    public long f12966b;

    /* renamed from: c  reason: collision with root package name */
    public long f12967c;

    /* renamed from: d  reason: collision with root package name */
    public int f12968d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f12969e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12970f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f12971g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f12972h;

    /* loaded from: classes3.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f12973e;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12973e = nVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 5) {
                    return false;
                }
                if (Boolean.TRUE.equals(message.obj)) {
                    this.f12973e.o();
                    this.f12973e.k();
                    return false;
                }
                this.f12973e.l();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f12974e;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12974e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n nVar = this.f12974e;
                if (nVar.f12969e == null) {
                    nVar.f12969e = new AtomicBoolean(false);
                }
                if (this.f12974e.f12969e.get()) {
                    return;
                }
                this.f12974e.f12969e.set(true);
                if (this.f12974e.j(true)) {
                    TbadkCoreApplication.getInst().fixOppoTimeout();
                    MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.TRUE));
                    TiebaStaticHelper.setCurrentActivity(null);
                    TiebaStatic.save();
                }
            }
        }
    }

    public n() {
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
        this.f12965a = 0;
        this.f12966b = 0L;
        this.f12967c = 0L;
        this.f12968d = 0;
        this.f12969e = null;
        this.f12970f = false;
        this.f12971g = new Handler(new a(this));
        this.f12972h = new b(this);
    }

    public static n g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f12964i == null) {
                synchronized (n.class) {
                    if (f12964i == null) {
                        f12964i = new n();
                    }
                }
            }
            return f12964i;
        }
        return (n) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12968d++;
            n();
            c.a.q0.s.p.a.c().b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f12968d--;
            n();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (j(false)) {
                if (this.f12970f) {
                    Intent intent = new Intent("com.tieba.baidu.notifyprocess");
                    intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                    intent.putExtra("message", true);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                    return false;
                }
                return true;
            }
            Intent intent2 = new Intent("com.tieba.baidu.notifyprocess");
            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent2.putExtra("message", false);
            TbadkCoreApplication.getInst().sendBroadcast(intent2);
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12965a = 0;
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12965a : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12968d : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AtomicBoolean atomicBoolean = this.f12969e;
            if (atomicBoolean == null) {
                return true;
            }
            return atomicBoolean.get();
        }
        return invokeV.booleanValue;
    }

    public boolean j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) ? TbadkCoreApplication.getInst().isMainProcess(z) : invokeZ.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AsyncService.INSTANCE.sendRunnable(this.f12972h);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AsyncService.INSTANCE.removeRunnable(this.f12972h);
            if (this.f12969e == null) {
                this.f12969e = new AtomicBoolean(true);
            }
            if (this.f12969e.get()) {
                this.f12969e.set(false);
                this.f12965a++;
                if (j(true)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = this.f12966b;
                    if (currentTimeMillis - j2 > 3600000 || j2 == 0) {
                        this.f12966b = System.currentTimeMillis();
                        new EnterForePvThread().start();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.FALSE));
                }
            }
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f12970f = !z;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f12968d < 0) {
                this.f12968d = 0;
            }
            if (j(true) && this.f12967c == 0 && this.f12968d > 0) {
                this.f12967c = System.nanoTime();
            }
            this.f12971g.removeMessages(5);
            if (this.f12968d == 0) {
                p();
                return;
            }
            AtomicBoolean atomicBoolean = this.f12969e;
            if (atomicBoolean == null || atomicBoolean.get()) {
                Handler handler = this.f12971g;
                handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.FALSE), 1000L);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f12968d == 0 && this.f12967c > 0) {
            long nanoTime = ((System.nanoTime() - this.f12967c) / 1000000) / 1000;
            if (nanoTime >= TbadkCoreApplication.getInst().getUseTimeInterval()) {
                new PvThread(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
            }
            this.f12967c = 0L;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Handler handler = this.f12971g;
            handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.TRUE), 1000L);
        }
    }
}
