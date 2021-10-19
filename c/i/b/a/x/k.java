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
/* loaded from: classes4.dex */
public final class k implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34084b;

    /* renamed from: c  reason: collision with root package name */
    public int f34085c;

    /* renamed from: d  reason: collision with root package name */
    public int f34086d;

    /* renamed from: e  reason: collision with root package name */
    public int f34087e;

    /* renamed from: f  reason: collision with root package name */
    public int f34088f;

    /* renamed from: g  reason: collision with root package name */
    public int f34089g;

    /* renamed from: h  reason: collision with root package name */
    public ByteBuffer f34090h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f34091i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f34092j;
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
        ByteBuffer byteBuffer = AudioProcessor.f70420a;
        this.f34090h = byteBuffer;
        this.f34091i = byteBuffer;
        this.f34087e = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int i2 = limit - position;
            int min = Math.min(i2, this.f34089g);
            this.f34089g -= min;
            byteBuffer.position(position + min);
            if (this.f34089g > 0) {
                return;
            }
            int i3 = i2 - min;
            int length = (this.k + i3) - this.f34092j.length;
            if (this.f34090h.capacity() < length) {
                this.f34090h = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.f34090h.clear();
            }
            int k = v.k(length, 0, this.k);
            this.f34090h.put(this.f34092j, 0, k);
            int k2 = v.k(length - k, 0, i3);
            byteBuffer.limit(byteBuffer.position() + k2);
            this.f34090h.put(byteBuffer);
            byteBuffer.limit(limit);
            int i4 = i3 - k2;
            int i5 = this.k - k;
            this.k = i5;
            byte[] bArr = this.f34092j;
            System.arraycopy(bArr, k, bArr, 0, i5);
            byteBuffer.get(this.f34092j, this.k, i4);
            this.k += i4;
            this.f34090h.flip();
            this.f34091i = this.f34090h;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l && this.f34091i == AudioProcessor.f70420a : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34087e : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34088f : invokeV.intValue;
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
            this.f34091i = AudioProcessor.f70420a;
            this.l = false;
            this.f34089g = 0;
            this.k = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.f34091i;
            this.f34091i = AudioProcessor.f70420a;
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
                this.f34087e = i3;
                this.f34088f = i2;
                int i5 = this.f34086d;
                this.f34092j = new byte[i5 * i3 * 2];
                this.k = 0;
                int i6 = this.f34085c;
                this.f34089g = i3 * i6 * 2;
                boolean z = this.f34084b;
                boolean z2 = (i6 == 0 && i5 == 0) ? false : true;
                this.f34084b = z2;
                return z != z2;
            }
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        }
        return invokeIII.booleanValue;
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f34085c = i2;
            this.f34086d = i3;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34084b : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            flush();
            this.f34090h = AudioProcessor.f70420a;
            this.f34087e = -1;
            this.f34088f = -1;
            this.f34092j = null;
        }
    }
}
