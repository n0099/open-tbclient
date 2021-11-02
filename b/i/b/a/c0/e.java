package b.i.b.a.c0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class e extends b.i.b.a.a implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b m;
    public final d n;
    public final Handler o;
    public final l p;
    public final c q;
    public final Metadata[] r;
    public final long[] s;
    public int t;
    public int u;
    public a v;
    public boolean w;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        this(dVar, looper, b.f31861a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((d) objArr2[0], (Looper) objArr2[1], (b) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.i.b.a.a
    public void B(Format[] formatArr, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, formatArr, j) == null) {
            this.v = this.m.b(formatArr[0]);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Arrays.fill(this.r, (Object) null);
            this.t = 0;
            this.u = 0;
        }
    }

    public final void G(Metadata metadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metadata) == null) {
            Handler handler = this.o;
            if (handler != null) {
                handler.obtainMessage(0, metadata).sendToTarget();
            } else {
                H(metadata);
            }
        }
    }

    public final void H(Metadata metadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, metadata) == null) {
            this.n.g(metadata);
        }
    }

    @Override // b.i.b.a.s
    public int a(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, format)) == null) {
            if (this.m.a(format)) {
                return b.i.b.a.a.E(null, format.drmInitData) ? 4 : 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // b.i.b.a.r
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.w : invokeV.booleanValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            if (message.what == 0) {
                H((Metadata) message.obj);
                return true;
            }
            throw new IllegalStateException();
        }
        return invokeL.booleanValue;
    }

    @Override // b.i.b.a.r
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.i.b.a.r
    public void k(long j, long j2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (!this.w && this.u < 5) {
                this.q.f();
                if (C(this.p, this.q, false) == -4) {
                    if (this.q.j()) {
                        this.w = true;
                    } else if (!this.q.i()) {
                        c cVar = this.q;
                        cVar.j = this.p.f32741a.subsampleOffsetUs;
                        cVar.o();
                        try {
                            int i2 = (this.t + this.u) % 5;
                            this.r[i2] = this.v.a(this.q);
                            this.s[i2] = this.q.f32902h;
                            this.u++;
                        } catch (MetadataDecoderException e2) {
                            throw ExoPlaybackException.createForRenderer(e2, u());
                        }
                    }
                }
            }
            if (this.u > 0) {
                long[] jArr = this.s;
                int i3 = this.t;
                if (jArr[i3] <= j) {
                    G(this.r[i3]);
                    Metadata[] metadataArr = this.r;
                    int i4 = this.t;
                    metadataArr[i4] = null;
                    this.t = (i4 + 1) % 5;
                    this.u--;
                }
            }
        }
    }

    @Override // b.i.b.a.a
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            F();
            this.v = null;
        }
    }

    @Override // b.i.b.a.a
    public void y(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            F();
            this.w = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper, b bVar) {
        super(4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, looper, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b.i.b.a.i0.a.e(dVar);
        this.n = dVar;
        this.o = looper == null ? null : new Handler(looper, this);
        b.i.b.a.i0.a.e(bVar);
        this.m = bVar;
        this.p = new l();
        this.q = new c();
        this.r = new Metadata[5];
        this.s = new long[5];
    }
}
