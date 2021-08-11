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
    public long f32182a;

    /* renamed from: b  reason: collision with root package name */
    public long f32183b;

    /* renamed from: c  reason: collision with root package name */
    public long f32184c;

    /* renamed from: d  reason: collision with root package name */
    public b f32185d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f32186e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f32187e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f32188f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f32189g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f32190h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f32191i;

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
            this.f32191i = gVar;
            this.f32187e = j2;
            this.f32188f = j3;
            this.f32189g = j4;
            this.f32190h = j5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32191i.f32185d.a(this.f32187e, this.f32188f, this.f32189g, this.f32190h);
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
        this.f32182a = 3000L;
        this.f32183b = 0L;
        this.f32184c = 0L;
        this.f32185d = null;
        if (bVar != null) {
            this.f32185d = bVar;
            this.f32182a = j2;
            this.f32186e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? j2 - this.f32183b > this.f32182a : invokeJ.booleanValue;
    }

    public final void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            e.b().post(new a(this, this.f32183b, j2, this.f32184c, SystemClock.currentThreadTimeMillis()));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.f().f32171b != null) {
                c.f().f32171b.c();
            }
            if (c.f().f32172c != null) {
                c.f().f32172c.c();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.f().f32171b != null) {
                c.f().f32171b.d();
            }
            if (c.f().f32172c != null) {
                c.f().f32172c.d();
            }
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.f32186e && Debug.isDebuggerConnected()) {
                return;
            }
            if (str.charAt(0) == '>') {
                this.f32183b = System.currentTimeMillis();
                this.f32184c = SystemClock.currentThreadTimeMillis();
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
