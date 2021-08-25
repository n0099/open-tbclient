package c.h.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g implements Printer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f32288a;

    /* renamed from: b  reason: collision with root package name */
    public long f32289b;

    /* renamed from: c  reason: collision with root package name */
    public long f32290c;

    /* renamed from: d  reason: collision with root package name */
    public b f32291d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f32292e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f32293e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f32294f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f32295g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f32296h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f32297i;

        public a(g gVar, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32297i = gVar;
            this.f32293e = j2;
            this.f32294f = j3;
            this.f32295g = j4;
            this.f32296h = j5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32297i.f32291d.a(this.f32293e, this.f32294f, this.f32295g, this.f32296h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(long j2, long j3, long j4, long j5);
    }

    public g(b bVar, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32288a = 3000L;
        this.f32289b = 0L;
        this.f32290c = 0L;
        this.f32291d = null;
        if (bVar != null) {
            this.f32291d = bVar;
            this.f32288a = j2;
            this.f32292e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? j2 - this.f32289b > this.f32288a : invokeJ.booleanValue;
    }

    public final void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            e.b().post(new a(this, this.f32289b, j2, this.f32290c, SystemClock.currentThreadTimeMillis()));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.f().f32277b != null) {
                c.f().f32277b.c();
            }
            if (c.f().f32278c != null) {
                c.f().f32278c.c();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.f().f32277b != null) {
                c.f().f32277b.d();
            }
            if (c.f().f32278c != null) {
                c.f().f32278c.d();
            }
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.f32292e && Debug.isDebuggerConnected()) {
                return;
            }
            if (str.charAt(0) == '>') {
                this.f32289b = System.currentTimeMillis();
                this.f32290c = SystemClock.currentThreadTimeMillis();
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
