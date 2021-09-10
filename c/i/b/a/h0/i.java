package c.i.b.a.h0;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import c.i.b.a.h0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class i implements c, p<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f33717a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a f33718b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.p f33719c;

    /* renamed from: d  reason: collision with root package name */
    public final c.i.b.a.i0.b f33720d;

    /* renamed from: e  reason: collision with root package name */
    public int f33721e;

    /* renamed from: f  reason: collision with root package name */
    public long f33722f;

    /* renamed from: g  reason: collision with root package name */
    public long f33723g;

    /* renamed from: h  reason: collision with root package name */
    public long f33724h;

    /* renamed from: i  reason: collision with root package name */
    public long f33725i;

    /* renamed from: j  reason: collision with root package name */
    public long f33726j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f33727e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f33728f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f33729g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f33730h;

        public a(i iVar, int i2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33730h = iVar;
            this.f33727e = i2;
            this.f33728f = j2;
            this.f33729g = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33730h.f33718b.a(this.f33727e, this.f33728f, this.f33729g);
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

    @Override // c.i.b.a.h0.p
    public synchronized void a(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, obj, i2) == null) {
            synchronized (this) {
                this.f33723g += i2;
            }
        }
    }

    @Override // c.i.b.a.h0.p
    public synchronized void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            synchronized (this) {
                c.i.b.a.i0.a.f(this.f33721e > 0);
                long a2 = this.f33720d.a();
                int i2 = (int) (a2 - this.f33722f);
                long j2 = i2;
                this.f33724h += j2;
                this.f33725i += this.f33723g;
                if (i2 > 0) {
                    this.f33719c.a((int) Math.sqrt(this.f33723g), (float) ((this.f33723g * 8000) / j2));
                    if (this.f33724h >= 2000 || this.f33725i >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        float d2 = this.f33719c.d(0.5f);
                        this.f33726j = Float.isNaN(d2) ? -1L : d2;
                    }
                }
                f(i2, this.f33723g, this.f33726j);
                int i3 = this.f33721e - 1;
                this.f33721e = i3;
                if (i3 > 0) {
                    this.f33722f = a2;
                }
                this.f33723g = 0L;
            }
        }
    }

    @Override // c.i.b.a.h0.c
    public synchronized long c() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                j2 = this.f33726j;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.h0.p
    public synchronized void d(Object obj, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, gVar) == null) {
            synchronized (this) {
                if (this.f33721e == 0) {
                    this.f33722f = this.f33720d.a();
                }
                this.f33721e++;
            }
        }
    }

    public final void f(int i2, long j2, long j3) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (handler = this.f33717a) == null || this.f33718b == null) {
            return;
        }
        handler.post(new a(this, i2, j2, j3));
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
        this(handler, aVar, i2, c.i.b.a.i0.b.f33776a);
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
                this((Handler) objArr2[0], (c.a) objArr2[1], ((Integer) objArr2[2]).intValue(), (c.i.b.a.i0.b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public i(Handler handler, c.a aVar, int i2, c.i.b.a.i0.b bVar) {
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
        this.f33717a = handler;
        this.f33718b = aVar;
        this.f33719c = new c.i.b.a.i0.p(i2);
        this.f33720d = bVar;
        this.f33726j = -1L;
    }
}
