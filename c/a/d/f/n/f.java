package c.a.d.f.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static f f2927d;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, b> a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f2928b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f2929c;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, looper};
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
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof b) || (bVar = (b) obj) == null) {
                    return;
                }
                bVar.i(false);
                bVar.h(false);
                bVar.g(0);
                bVar.j(System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f2934b;

        /* renamed from: c  reason: collision with root package name */
        public int f2935c;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2934b : invokeV.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2935c : invokeV.intValue;
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.a = i2;
            }
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f2934b = i2;
            }
        }

        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.f2935c = i2;
            }
        }

        public /* synthetic */ c(f fVar, a aVar) {
            this(fVar);
        }
    }

    public f() {
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
        this.a = new HashMap<>();
        this.f2928b = new HashMap<>();
        this.f2929c = new a(this, Looper.getMainLooper());
        c cVar = new c(this, null);
        cVar.d(3000);
        cVar.e(120000);
        cVar.f(500);
        this.f2928b.put("net", cVar);
        this.f2928b.put("op", cVar);
        this.f2928b.put("stat", cVar);
        this.f2928b.put("crash", cVar);
        this.f2928b.put("pfmonitor", cVar);
        c cVar2 = new c(this, null);
        cVar2.d(3000);
        cVar2.e(120000);
        cVar2.f(1500);
        this.f2928b.put("file", cVar2);
        this.f2928b.put(IMTrackDatabase.DbEnum.TABLE_NAME, cVar2);
        this.f2928b.put("img", cVar2);
        this.f2928b.put("voice", cVar2);
        this.f2928b.put("error", cVar2);
        c cVar3 = new c(this, null);
        cVar3.d(3000);
        cVar3.e(120000);
        cVar3.f(1500);
        this.f2928b.put("dbg", cVar3);
    }

    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f2927d == null) {
                synchronized (f.class) {
                    if (f2927d == null) {
                        f2927d = new f();
                    }
                }
            }
            return f2927d;
        }
        return (f) invokeV.objValue;
    }

    public synchronized boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                c cVar = this.f2928b.get(str);
                if (cVar == null) {
                    return false;
                }
                b bVar = this.a.get(str);
                long currentTimeMillis = System.currentTimeMillis();
                if (bVar == null) {
                    bVar = new b(this, null);
                    bVar.h(false);
                    bVar.i(false);
                    bVar.j(currentTimeMillis);
                    this.a.put(str, bVar);
                }
                b bVar2 = bVar;
                if (bVar2.e()) {
                    return true;
                }
                if (bVar2.d()) {
                    bVar2.g(bVar2.b() + 1);
                    if (currentTimeMillis - bVar2.a() < cVar.b()) {
                        if (bVar2.b() >= cVar.c()) {
                            bVar2.i(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, VideoItemModel.TYPE_LOADING, str, new Object[0]);
                            b(bVar2);
                            return true;
                        }
                    } else {
                        bVar2.h(false);
                        bVar2.g(0);
                        bVar2.j(currentTimeMillis);
                    }
                } else if (currentTimeMillis - bVar2.c() < cVar.a()) {
                    bVar2.h(true);
                    bVar2.f(currentTimeMillis);
                } else {
                    bVar2.j(currentTimeMillis);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            Message obtainMessage = this.f2929c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = bVar;
            this.f2929c.removeMessages(5);
            this.f2929c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2930b;

        /* renamed from: c  reason: collision with root package name */
        public int f2931c;

        /* renamed from: d  reason: collision with root package name */
        public long f2932d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2933e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2930b = false;
            this.f2931c = 0;
            this.f2933e = false;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2932d : invokeV.longValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2931c : invokeV.intValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.longValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2930b : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2933e : invokeV.booleanValue;
        }

        public void f(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
                this.f2932d = j2;
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.f2931c = i2;
            }
        }

        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.f2930b = z;
            }
        }

        public void i(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                this.f2933e = z;
            }
        }

        public void j(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
                this.a = j2;
            }
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }
}
