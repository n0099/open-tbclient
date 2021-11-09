package b.i.b.a.x;

import androidx.core.view.InputDeviceCompat;
import b.i.b.a.i0.v;
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
/* loaded from: classes6.dex */
public final class j implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f32863b;

    /* renamed from: c  reason: collision with root package name */
    public int f32864c;

    /* renamed from: d  reason: collision with root package name */
    public int f32865d;

    /* renamed from: e  reason: collision with root package name */
    public i f32866e;

    /* renamed from: f  reason: collision with root package name */
    public float f32867f;

    /* renamed from: g  reason: collision with root package name */
    public float f32868g;

    /* renamed from: h  reason: collision with root package name */
    public int f32869h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f32870i;
    public ShortBuffer j;
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
        this.f32867f = 1.0f;
        this.f32868g = 1.0f;
        this.f32864c = -1;
        this.f32865d = -1;
        this.f32869h = -1;
        ByteBuffer byteBuffer = AudioProcessor.f62941a;
        this.f32870i = byteBuffer;
        this.j = byteBuffer.asShortBuffer();
        this.k = AudioProcessor.f62941a;
        this.f32863b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            if (byteBuffer.hasRemaining()) {
                ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
                int remaining = byteBuffer.remaining();
                this.l += remaining;
                this.f32866e.s(asShortBuffer);
                byteBuffer.position(byteBuffer.position() + remaining);
            }
            int k = this.f32866e.k() * this.f32864c * 2;
            if (k > 0) {
                if (this.f32870i.capacity() < k) {
                    ByteBuffer order = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
                    this.f32870i = order;
                    this.j = order.asShortBuffer();
                } else {
                    this.f32870i.clear();
                    this.j.clear();
                }
                this.f32866e.j(this.j);
                this.m += k;
                this.f32870i.limit(k);
                this.k = this.f32870i;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n && ((iVar = this.f32866e) == null || iVar.k() == 0) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32864c : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32869h : invokeV.intValue;
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
            this.f32866e.r();
            this.n = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f32866e = new i(this.f32865d, this.f32864c, this.f32867f, this.f32868g, this.f32869h);
            this.k = AudioProcessor.f62941a;
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
            this.k = AudioProcessor.f62941a;
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
                int i5 = this.f32863b;
                if (i5 == -1) {
                    i5 = i2;
                }
                if (this.f32865d == i2 && this.f32864c == i3 && this.f32869h == i5) {
                    return false;
                }
                this.f32865d = i2;
                this.f32864c = i3;
                this.f32869h = i5;
                return true;
            }
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        }
        return invokeIII.booleanValue;
    }

    public long i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            long j2 = this.m;
            if (j2 >= 1024) {
                int i2 = this.f32869h;
                int i3 = this.f32865d;
                if (i2 == i3) {
                    return v.F(j, this.l, j2);
                }
                return v.F(j, this.l * i2, j2 * i3);
            }
            return (long) (this.f32867f * j);
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Math.abs(this.f32867f - 1.0f) >= 0.01f || Math.abs(this.f32868g - 1.0f) >= 0.01f || this.f32869h != this.f32865d : invokeV.booleanValue;
    }

    public float j(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            this.f32868g = v.j(f2, 0.1f, 8.0f);
            return f2;
        }
        return invokeF.floatValue;
    }

    public float k(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            float j = v.j(f2, 0.1f, 8.0f);
            this.f32867f = j;
            return j;
        }
        return invokeF.floatValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f32866e = null;
            ByteBuffer byteBuffer = AudioProcessor.f62941a;
            this.f32870i = byteBuffer;
            this.j = byteBuffer.asShortBuffer();
            this.k = AudioProcessor.f62941a;
            this.f32864c = -1;
            this.f32865d = -1;
            this.f32869h = -1;
            this.l = 0L;
            this.m = 0L;
            this.n = false;
            this.f32863b = -1;
        }
    }
}
