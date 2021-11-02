package b.i.b.a.h0;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import b.i.b.a.h0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class i implements c, p<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f32544a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a f32545b;

    /* renamed from: c  reason: collision with root package name */
    public final b.i.b.a.i0.p f32546c;

    /* renamed from: d  reason: collision with root package name */
    public final b.i.b.a.i0.b f32547d;

    /* renamed from: e  reason: collision with root package name */
    public int f32548e;

    /* renamed from: f  reason: collision with root package name */
    public long f32549f;

    /* renamed from: g  reason: collision with root package name */
    public long f32550g;

    /* renamed from: h  reason: collision with root package name */
    public long f32551h;

    /* renamed from: i  reason: collision with root package name */
    public long f32552i;
    public long j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f32553e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f32554f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f32555g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f32556h;

        public a(i iVar, int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32556h = iVar;
            this.f32553e = i2;
            this.f32554f = j;
            this.f32555g = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32556h.f32545b.a(this.f32553e, this.f32554f, this.f32555g);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i() {
        this(null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Handler) objArr[0], (c.a) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.i.b.a.h0.p
    public synchronized void a(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, obj, i2) == null) {
            synchronized (this) {
                this.f32550g += i2;
            }
        }
    }

    @Override // b.i.b.a.h0.p
    public synchronized void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            synchronized (this) {
                b.i.b.a.i0.a.f(this.f32548e > 0);
                long a2 = this.f32547d.a();
                int i2 = (int) (a2 - this.f32549f);
                long j = i2;
                this.f32551h += j;
                this.f32552i += this.f32550g;
                if (i2 > 0) {
                    this.f32546c.a((int) Math.sqrt(this.f32550g), (float) ((this.f32550g * 8000) / j));
                    if (this.f32551h >= 2000 || this.f32552i >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        float d2 = this.f32546c.d(0.5f);
                        this.j = Float.isNaN(d2) ? -1L : d2;
                    }
                }
                f(i2, this.f32550g, this.j);
                int i3 = this.f32548e - 1;
                this.f32548e = i3;
                if (i3 > 0) {
                    this.f32549f = a2;
                }
                this.f32550g = 0L;
            }
        }
    }

    @Override // b.i.b.a.h0.c
    public synchronized long c() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                j = this.j;
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // b.i.b.a.h0.p
    public synchronized void d(Object obj, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, gVar) == null) {
            synchronized (this) {
                if (this.f32548e == 0) {
                    this.f32549f = this.f32547d.a();
                }
                this.f32548e++;
            }
        }
    }

    public final void f(int i2, long j, long j2) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || (handler = this.f32544a) == null || this.f32545b == null) {
            return;
        }
        handler.post(new a(this, i2, j, j2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (c.a) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Handler handler, c.a aVar, int i2) {
        this(handler, aVar, i2, b.i.b.a.i0.b.f32600a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (c.a) objArr2[1], ((Integer) objArr2[2]).intValue(), (b.i.b.a.i0.b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public i(Handler handler, c.a aVar, int i2, b.i.b.a.i0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, aVar, Integer.valueOf(i2), bVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f32544a = handler;
        this.f32545b = aVar;
        this.f32546c = new b.i.b.a.i0.p(i2);
        this.f32547d = bVar;
        this.j = -1L;
    }
}
