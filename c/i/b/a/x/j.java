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
/* loaded from: classes4.dex */
public final class j implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f33939b;

    /* renamed from: c  reason: collision with root package name */
    public int f33940c;

    /* renamed from: d  reason: collision with root package name */
    public int f33941d;

    /* renamed from: e  reason: collision with root package name */
    public i f33942e;

    /* renamed from: f  reason: collision with root package name */
    public float f33943f;

    /* renamed from: g  reason: collision with root package name */
    public float f33944g;

    /* renamed from: h  reason: collision with root package name */
    public int f33945h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f33946i;

    /* renamed from: j  reason: collision with root package name */
    public ShortBuffer f33947j;
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
        this.f33943f = 1.0f;
        this.f33944g = 1.0f;
        this.f33940c = -1;
        this.f33941d = -1;
        this.f33945h = -1;
        ByteBuffer byteBuffer = AudioProcessor.f69886a;
        this.f33946i = byteBuffer;
        this.f33947j = byteBuffer.asShortBuffer();
        this.k = AudioProcessor.f69886a;
        this.f33939b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            if (byteBuffer.hasRemaining()) {
                ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
                int remaining = byteBuffer.remaining();
                this.l += remaining;
                this.f33942e.s(asShortBuffer);
                byteBuffer.position(byteBuffer.position() + remaining);
            }
            int k = this.f33942e.k() * this.f33940c * 2;
            if (k > 0) {
                if (this.f33946i.capacity() < k) {
                    ByteBuffer order = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
                    this.f33946i = order;
                    this.f33947j = order.asShortBuffer();
                } else {
                    this.f33946i.clear();
                    this.f33947j.clear();
                }
                this.f33942e.j(this.f33947j);
                this.m += k;
                this.f33946i.limit(k);
                this.k = this.f33946i;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n && ((iVar = this.f33942e) == null || iVar.k() == 0) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33940c : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33945h : invokeV.intValue;
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
            this.f33942e.r();
            this.n = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f33942e = new i(this.f33941d, this.f33940c, this.f33943f, this.f33944g, this.f33945h);
            this.k = AudioProcessor.f69886a;
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
            this.k = AudioProcessor.f69886a;
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
                int i5 = this.f33939b;
                if (i5 == -1) {
                    i5 = i2;
                }
                if (this.f33941d == i2 && this.f33940c == i3 && this.f33945h == i5) {
                    return false;
                }
                this.f33941d = i2;
                this.f33940c = i3;
                this.f33945h = i5;
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
                int i2 = this.f33945h;
                int i3 = this.f33941d;
                if (i2 == i3) {
                    return v.F(j2, this.l, j3);
                }
                return v.F(j2, this.l * i2, j3 * i3);
            }
            return (long) (this.f33943f * j2);
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Math.abs(this.f33943f - 1.0f) >= 0.01f || Math.abs(this.f33944g - 1.0f) >= 0.01f || this.f33945h != this.f33941d : invokeV.booleanValue;
    }

    public float j(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            this.f33944g = v.j(f2, 0.1f, 8.0f);
            return f2;
        }
        return invokeF.floatValue;
    }

    public float k(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            float j2 = v.j(f2, 0.1f, 8.0f);
            this.f33943f = j2;
            return j2;
        }
        return invokeF.floatValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f33942e = null;
            ByteBuffer byteBuffer = AudioProcessor.f69886a;
            this.f33946i = byteBuffer;
            this.f33947j = byteBuffer.asShortBuffer();
            this.k = AudioProcessor.f69886a;
            this.f33940c = -1;
            this.f33941d = -1;
            this.f33945h = -1;
            this.l = 0L;
            this.m = 0L;
            this.n = false;
            this.f33939b = -1;
        }
    }
}
