package b.h.b.a.x;

import androidx.core.view.InputDeviceCompat;
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public final class k implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f33729b;

    /* renamed from: c  reason: collision with root package name */
    public int f33730c;

    /* renamed from: d  reason: collision with root package name */
    public int f33731d;

    /* renamed from: e  reason: collision with root package name */
    public int f33732e;

    /* renamed from: f  reason: collision with root package name */
    public int f33733f;

    /* renamed from: g  reason: collision with root package name */
    public int f33734g;

    /* renamed from: h  reason: collision with root package name */
    public ByteBuffer f33735h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f33736i;
    public byte[] j;
    public int k;
    public boolean l;

    public k() {
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
        ByteBuffer byteBuffer = AudioProcessor.f63841a;
        this.f33735h = byteBuffer;
        this.f33736i = byteBuffer;
        this.f33732e = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int i2 = limit - position;
            int min = Math.min(i2, this.f33734g);
            this.f33734g -= min;
            byteBuffer.position(position + min);
            if (this.f33734g > 0) {
                return;
            }
            int i3 = i2 - min;
            int length = (this.k + i3) - this.j.length;
            if (this.f33735h.capacity() < length) {
                this.f33735h = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.f33735h.clear();
            }
            int k = v.k(length, 0, this.k);
            this.f33735h.put(this.j, 0, k);
            int k2 = v.k(length - k, 0, i3);
            byteBuffer.limit(byteBuffer.position() + k2);
            this.f33735h.put(byteBuffer);
            byteBuffer.limit(limit);
            int i4 = i3 - k2;
            int i5 = this.k - k;
            this.k = i5;
            byte[] bArr = this.j;
            System.arraycopy(bArr, k, bArr, 0, i5);
            byteBuffer.get(this.j, this.k, i4);
            this.k += i4;
            this.f33735h.flip();
            this.f33736i = this.f33735h;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l && this.f33736i == AudioProcessor.f63841a : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33732e : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33733f : invokeV.intValue;
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
            this.l = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f33736i = AudioProcessor.f63841a;
            this.l = false;
            this.f33734g = 0;
            this.k = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.f33736i;
            this.f33736i = AudioProcessor.f63841a;
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
                this.f33732e = i3;
                this.f33733f = i2;
                int i5 = this.f33731d;
                this.j = new byte[i5 * i3 * 2];
                this.k = 0;
                int i6 = this.f33730c;
                this.f33734g = i3 * i6 * 2;
                boolean z = this.f33729b;
                boolean z2 = (i6 == 0 && i5 == 0) ? false : true;
                this.f33729b = z2;
                return z != z2;
            }
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        }
        return invokeIII.booleanValue;
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f33730c = i2;
            this.f33731d = i3;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f33729b : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            flush();
            this.f33735h = AudioProcessor.f63841a;
            this.f33732e = -1;
            this.f33733f = -1;
            this.j = null;
        }
    }
}
