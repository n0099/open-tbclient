package b.i.b.a.x;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class e implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f32836b;

    /* renamed from: c  reason: collision with root package name */
    public int f32837c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f32838d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32839e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f32840f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f32841g;

    /* renamed from: h  reason: collision with root package name */
    public ByteBuffer f32842h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32843i;

    public e() {
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
        ByteBuffer byteBuffer = AudioProcessor.f62942a;
        this.f32841g = byteBuffer;
        this.f32842h = byteBuffer;
        this.f32836b = -1;
        this.f32837c = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int length = ((limit - position) / (this.f32836b * 2)) * this.f32840f.length * 2;
            if (this.f32841g.capacity() < length) {
                this.f32841g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.f32841g.clear();
            }
            while (position < limit) {
                for (int i2 : this.f32840f) {
                    this.f32841g.putShort(byteBuffer.getShort((i2 * 2) + position));
                }
                position += this.f32836b * 2;
            }
            byteBuffer.position(limit);
            this.f32841g.flip();
            this.f32842h = this.f32841g;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32843i && this.f32842h == AudioProcessor.f62942a : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int[] iArr = this.f32840f;
            return iArr == null ? this.f32836b : iArr.length;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32837c : invokeV.intValue;
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
            this.f32843i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f32842h = AudioProcessor.f62942a;
            this.f32843i = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.f32842h;
            this.f32842h = AudioProcessor.f62942a;
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h(int i2, int i3, int i4) throws AudioProcessor.UnhandledFormatException {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4)) != null) {
            return invokeIII.booleanValue;
        }
        boolean z = !Arrays.equals(this.f32838d, this.f32840f);
        int[] iArr = this.f32838d;
        this.f32840f = iArr;
        if (iArr == null) {
            this.f32839e = false;
            return z;
        } else if (i4 == 2) {
            if (!z && this.f32837c == i2 && this.f32836b == i3) {
                return false;
            }
            this.f32837c = i2;
            this.f32836b = i3;
            this.f32839e = i3 != this.f32840f.length;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f32840f;
                if (i5 >= iArr2.length) {
                    return true;
                }
                int i6 = iArr2[i5];
                if (i6 < i3) {
                    this.f32839e = (i6 != i5) | this.f32839e;
                    i5++;
                } else {
                    throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
                }
            }
        } else {
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        }
    }

    public void i(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iArr) == null) {
            this.f32838d = iArr;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f32839e : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            flush();
            this.f32841g = AudioProcessor.f62942a;
            this.f32836b = -1;
            this.f32837c = -1;
            this.f32840f = null;
            this.f32839e = false;
        }
    }
}
