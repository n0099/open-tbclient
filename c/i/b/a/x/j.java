package c.i.b.a.x;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes9.dex */
public final class j implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f29946b;

    /* renamed from: c  reason: collision with root package name */
    public int f29947c;

    /* renamed from: d  reason: collision with root package name */
    public int f29948d;

    /* renamed from: e  reason: collision with root package name */
    public i f29949e;

    /* renamed from: f  reason: collision with root package name */
    public float f29950f;

    /* renamed from: g  reason: collision with root package name */
    public float f29951g;

    /* renamed from: h  reason: collision with root package name */
    public int f29952h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f29953i;

    /* renamed from: j  reason: collision with root package name */
    public ShortBuffer f29954j;
    public ByteBuffer k;
    public long l;
    public long m;
    public boolean n;

    public j() {
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
        this.f29950f = 1.0f;
        this.f29951g = 1.0f;
        this.f29947c = -1;
        this.f29948d = -1;
        this.f29952h = -1;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.f29953i = byteBuffer;
        this.f29954j = byteBuffer.asShortBuffer();
        this.k = AudioProcessor.a;
        this.f29946b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            if (byteBuffer.hasRemaining()) {
                ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
                int remaining = byteBuffer.remaining();
                this.l += remaining;
                this.f29949e.s(asShortBuffer);
                byteBuffer.position(byteBuffer.position() + remaining);
            }
            int k = this.f29949e.k() * this.f29947c * 2;
            if (k > 0) {
                if (this.f29953i.capacity() < k) {
                    ByteBuffer order = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
                    this.f29953i = order;
                    this.f29954j = order.asShortBuffer();
                } else {
                    this.f29953i.clear();
                    this.f29954j.clear();
                }
                this.f29949e.j(this.f29954j);
                this.m += k;
                this.f29953i.limit(k);
                this.k = this.f29953i;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n && ((iVar = this.f29949e) == null || iVar.k() == 0) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29947c : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29952h : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29949e.r();
            this.n = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29949e = new i(this.f29948d, this.f29947c, this.f29950f, this.f29951g, this.f29952h);
            this.k = AudioProcessor.a;
            this.l = 0L;
            this.m = 0L;
            this.n = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.k;
            this.k = AudioProcessor.a;
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h(int i2, int i3, int i4) throws AudioProcessor.UnhandledFormatException {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4)) == null) {
            if (i4 == 2) {
                int i5 = this.f29946b;
                if (i5 == -1) {
                    i5 = i2;
                }
                if (this.f29948d == i2 && this.f29947c == i3 && this.f29952h == i5) {
                    return false;
                }
                this.f29948d = i2;
                this.f29947c = i3;
                this.f29952h = i5;
                return true;
            }
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        }
        return invokeIII.booleanValue;
    }

    public long i(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
            long j3 = this.m;
            if (j3 >= 1024) {
                int i2 = this.f29952h;
                int i3 = this.f29948d;
                if (i2 == i3) {
                    return v.F(j2, this.l, j3);
                }
                return v.F(j2, this.l * i2, j3 * i3);
            }
            return (long) (this.f29950f * j2);
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Math.abs(this.f29950f - 1.0f) >= 0.01f || Math.abs(this.f29951g - 1.0f) >= 0.01f || this.f29952h != this.f29948d : invokeV.booleanValue;
    }

    public float j(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            this.f29951g = v.j(f2, 0.1f, 8.0f);
            return f2;
        }
        return invokeF.floatValue;
    }

    public float k(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            float j2 = v.j(f2, 0.1f, 8.0f);
            this.f29950f = j2;
            return j2;
        }
        return invokeF.floatValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f29949e = null;
            ByteBuffer byteBuffer = AudioProcessor.a;
            this.f29953i = byteBuffer;
            this.f29954j = byteBuffer.asShortBuffer();
            this.k = AudioProcessor.a;
            this.f29947c = -1;
            this.f29948d = -1;
            this.f29952h = -1;
            this.l = 0L;
            this.m = 0L;
            this.n = false;
            this.f29946b = -1;
        }
    }
}
