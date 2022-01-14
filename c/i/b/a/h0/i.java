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
/* loaded from: classes9.dex */
public final class i implements c, p<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a f29640b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.p f29641c;

    /* renamed from: d  reason: collision with root package name */
    public final c.i.b.a.i0.b f29642d;

    /* renamed from: e  reason: collision with root package name */
    public int f29643e;

    /* renamed from: f  reason: collision with root package name */
    public long f29644f;

    /* renamed from: g  reason: collision with root package name */
    public long f29645g;

    /* renamed from: h  reason: collision with root package name */
    public long f29646h;

    /* renamed from: i  reason: collision with root package name */
    public long f29647i;

    /* renamed from: j  reason: collision with root package name */
    public long f29648j;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f29649e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f29650f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f29651g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f29652h;

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
            this.f29652h = iVar;
            this.f29649e = i2;
            this.f29650f = j2;
            this.f29651g = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29652h.f29640b.a(this.f29649e, this.f29650f, this.f29651g);
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
                this.f29645g += i2;
            }
        }
    }

    @Override // c.i.b.a.h0.p
    public synchronized void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            synchronized (this) {
                c.i.b.a.i0.a.f(this.f29643e > 0);
                long a2 = this.f29642d.a();
                int i2 = (int) (a2 - this.f29644f);
                long j2 = i2;
                this.f29646h += j2;
                this.f29647i += this.f29645g;
                if (i2 > 0) {
                    this.f29641c.a((int) Math.sqrt(this.f29645g), (float) ((this.f29645g * 8000) / j2));
                    if (this.f29646h >= 2000 || this.f29647i >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        float d2 = this.f29641c.d(0.5f);
                        this.f29648j = Float.isNaN(d2) ? -1L : d2;
                    }
                }
                f(i2, this.f29645g, this.f29648j);
                int i3 = this.f29643e - 1;
                this.f29643e = i3;
                if (i3 > 0) {
                    this.f29644f = a2;
                }
                this.f29645g = 0L;
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
                j2 = this.f29648j;
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
                if (this.f29643e == 0) {
                    this.f29644f = this.f29642d.a();
                }
                this.f29643e++;
            }
        }
    }

    public final void f(int i2, long j2, long j3) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (handler = this.a) == null || this.f29640b == null) {
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
        this(handler, aVar, i2, c.i.b.a.i0.b.a);
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
        this.a = handler;
        this.f29640b = aVar;
        this.f29641c = new c.i.b.a.i0.p(i2);
        this.f29642d = bVar;
        this.f29648j = -1L;
    }
}
