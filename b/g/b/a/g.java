package b.g.b.a;

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
    public long f32163a;

    /* renamed from: b  reason: collision with root package name */
    public long f32164b;

    /* renamed from: c  reason: collision with root package name */
    public long f32165c;

    /* renamed from: d  reason: collision with root package name */
    public b f32166d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f32167e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f32168e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f32169f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f32170g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f32171h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f32172i;

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
            this.f32172i = gVar;
            this.f32168e = j;
            this.f32169f = j2;
            this.f32170g = j3;
            this.f32171h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32172i.f32166d.a(this.f32168e, this.f32169f, this.f32170g, this.f32171h);
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
        this.f32163a = 3000L;
        this.f32164b = 0L;
        this.f32165c = 0L;
        this.f32166d = null;
        if (bVar != null) {
            this.f32166d = bVar;
            this.f32163a = j;
            this.f32167e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? j - this.f32164b > this.f32163a : invokeJ.booleanValue;
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            e.b().post(new a(this, this.f32164b, j, this.f32165c, SystemClock.currentThreadTimeMillis()));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.e().f32152b != null) {
                c.e().f32152b.c();
            }
            if (c.e().f32153c != null) {
                c.e().f32153c.c();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.e().f32152b != null) {
                c.e().f32152b.d();
            }
            if (c.e().f32153c != null) {
                c.e().f32153c.d();
            }
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.f32167e && Debug.isDebuggerConnected()) {
                return;
            }
            if (str.charAt(0) == '>') {
                this.f32164b = System.currentTimeMillis();
                this.f32165c = SystemClock.currentThreadTimeMillis();
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
