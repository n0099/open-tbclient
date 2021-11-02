package b.h.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g implements Printer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f31305a;

    /* renamed from: b  reason: collision with root package name */
    public long f31306b;

    /* renamed from: c  reason: collision with root package name */
    public long f31307c;

    /* renamed from: d  reason: collision with root package name */
    public b f31308d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f31309e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f31310e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f31311f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f31312g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f31313h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f31314i;

        public a(g gVar, long j, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31314i = gVar;
            this.f31310e = j;
            this.f31311f = j2;
            this.f31312g = j3;
            this.f31313h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31314i.f31308d.a(this.f31310e, this.f31311f, this.f31312g, this.f31313h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31305a = 3000L;
        this.f31306b = 0L;
        this.f31307c = 0L;
        this.f31308d = null;
        if (bVar != null) {
            this.f31308d = bVar;
            this.f31305a = j;
            this.f31309e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? j - this.f31306b > this.f31305a : invokeJ.booleanValue;
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            e.b().post(new a(this, this.f31306b, j, this.f31307c, SystemClock.currentThreadTimeMillis()));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.e().f31294b != null) {
                c.e().f31294b.c();
            }
            if (c.e().f31295c != null) {
                c.e().f31295c.c();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.e().f31294b != null) {
                c.e().f31294b.d();
            }
            if (c.e().f31295c != null) {
                c.e().f31295c.d();
            }
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.f31309e && Debug.isDebuggerConnected()) {
                return;
            }
            if (str.charAt(0) == '>') {
                this.f31306b = System.currentTimeMillis();
                this.f31307c = SystemClock.currentThreadTimeMillis();
                d();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (b(currentTimeMillis)) {
                c(currentTimeMillis);
            }
            e();
        }
    }
}
