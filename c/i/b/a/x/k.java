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
/* loaded from: classes9.dex */
public final class k implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30818b;

    /* renamed from: c  reason: collision with root package name */
    public int f30819c;

    /* renamed from: d  reason: collision with root package name */
    public int f30820d;

    /* renamed from: e  reason: collision with root package name */
    public int f30821e;

    /* renamed from: f  reason: collision with root package name */
    public int f30822f;

    /* renamed from: g  reason: collision with root package name */
    public int f30823g;

    /* renamed from: h  reason: collision with root package name */
    public ByteBuffer f30824h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f30825i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f30826j;

    /* renamed from: k  reason: collision with root package name */
    public int f30827k;
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
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.f30824h = byteBuffer;
        this.f30825i = byteBuffer;
        this.f30821e = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int i2 = limit - position;
            int min = Math.min(i2, this.f30823g);
            this.f30823g -= min;
            byteBuffer.position(position + min);
            if (this.f30823g > 0) {
                return;
            }
            int i3 = i2 - min;
            int length = (this.f30827k + i3) - this.f30826j.length;
            if (this.f30824h.capacity() < length) {
                this.f30824h = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.f30824h.clear();
            }
            int k2 = v.k(length, 0, this.f30827k);
            this.f30824h.put(this.f30826j, 0, k2);
            int k3 = v.k(length - k2, 0, i3);
            byteBuffer.limit(byteBuffer.position() + k3);
            this.f30824h.put(byteBuffer);
            byteBuffer.limit(limit);
            int i4 = i3 - k3;
            int i5 = this.f30827k - k2;
            this.f30827k = i5;
            byte[] bArr = this.f30826j;
            System.arraycopy(bArr, k2, bArr, 0, i5);
            byteBuffer.get(this.f30826j, this.f30827k, i4);
            this.f30827k += i4;
            this.f30824h.flip();
            this.f30825i = this.f30824h;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l && this.f30825i == AudioProcessor.a : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30821e : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30822f : invokeV.intValue;
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
            this.f30825i = AudioProcessor.a;
            this.l = false;
            this.f30823g = 0;
            this.f30827k = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.f30825i;
            this.f30825i = AudioProcessor.a;
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
                this.f30821e = i3;
                this.f30822f = i2;
                int i5 = this.f30820d;
                this.f30826j = new byte[i5 * i3 * 2];
                this.f30827k = 0;
                int i6 = this.f30819c;
                this.f30823g = i3 * i6 * 2;
                boolean z = this.f30818b;
                boolean z2 = (i6 == 0 && i5 == 0) ? false : true;
                this.f30818b = z2;
                return z != z2;
            }
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        }
        return invokeIII.booleanValue;
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f30819c = i2;
            this.f30820d = i3;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30818b : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            flush();
            this.f30824h = AudioProcessor.a;
            this.f30821e = -1;
            this.f30822f = -1;
            this.f30826j = null;
        }
    }
}
