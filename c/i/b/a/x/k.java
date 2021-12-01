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
/* loaded from: classes7.dex */
public final class k implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30448b;

    /* renamed from: c  reason: collision with root package name */
    public int f30449c;

    /* renamed from: d  reason: collision with root package name */
    public int f30450d;

    /* renamed from: e  reason: collision with root package name */
    public int f30451e;

    /* renamed from: f  reason: collision with root package name */
    public int f30452f;

    /* renamed from: g  reason: collision with root package name */
    public int f30453g;

    /* renamed from: h  reason: collision with root package name */
    public ByteBuffer f30454h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f30455i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f30456j;

    /* renamed from: k  reason: collision with root package name */
    public int f30457k;
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
        this.f30454h = byteBuffer;
        this.f30455i = byteBuffer;
        this.f30451e = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int i2 = limit - position;
            int min = Math.min(i2, this.f30453g);
            this.f30453g -= min;
            byteBuffer.position(position + min);
            if (this.f30453g > 0) {
                return;
            }
            int i3 = i2 - min;
            int length = (this.f30457k + i3) - this.f30456j.length;
            if (this.f30454h.capacity() < length) {
                this.f30454h = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.f30454h.clear();
            }
            int k2 = v.k(length, 0, this.f30457k);
            this.f30454h.put(this.f30456j, 0, k2);
            int k3 = v.k(length - k2, 0, i3);
            byteBuffer.limit(byteBuffer.position() + k3);
            this.f30454h.put(byteBuffer);
            byteBuffer.limit(limit);
            int i4 = i3 - k3;
            int i5 = this.f30457k - k2;
            this.f30457k = i5;
            byte[] bArr = this.f30456j;
            System.arraycopy(bArr, k2, bArr, 0, i5);
            byteBuffer.get(this.f30456j, this.f30457k, i4);
            this.f30457k += i4;
            this.f30454h.flip();
            this.f30455i = this.f30454h;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l && this.f30455i == AudioProcessor.a : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30451e : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30452f : invokeV.intValue;
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
            this.f30455i = AudioProcessor.a;
            this.l = false;
            this.f30453g = 0;
            this.f30457k = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.f30455i;
            this.f30455i = AudioProcessor.a;
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
                this.f30451e = i3;
                this.f30452f = i2;
                int i5 = this.f30450d;
                this.f30456j = new byte[i5 * i3 * 2];
                this.f30457k = 0;
                int i6 = this.f30449c;
                this.f30453g = i3 * i6 * 2;
                boolean z = this.f30448b;
                boolean z2 = (i6 == 0 && i5 == 0) ? false : true;
                this.f30448b = z2;
                return z != z2;
            }
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        }
        return invokeIII.booleanValue;
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f30449c = i2;
            this.f30450d = i3;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30448b : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            flush();
            this.f30454h = AudioProcessor.a;
            this.f30451e = -1;
            this.f30452f = -1;
            this.f30456j = null;
        }
    }
}
