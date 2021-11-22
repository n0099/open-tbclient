package b.h.b.a.x;

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
    public int f33694b;

    /* renamed from: c  reason: collision with root package name */
    public int f33695c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f33696d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33697e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f33698f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f33699g;

    /* renamed from: h  reason: collision with root package name */
    public ByteBuffer f33700h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33701i;

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
        ByteBuffer byteBuffer = AudioProcessor.f63841a;
        this.f33699g = byteBuffer;
        this.f33700h = byteBuffer;
        this.f33694b = -1;
        this.f33695c = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int length = ((limit - position) / (this.f33694b * 2)) * this.f33698f.length * 2;
            if (this.f33699g.capacity() < length) {
                this.f33699g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.f33699g.clear();
            }
            while (position < limit) {
                for (int i2 : this.f33698f) {
                    this.f33699g.putShort(byteBuffer.getShort((i2 * 2) + position));
                }
                position += this.f33694b * 2;
            }
            byteBuffer.position(limit);
            this.f33699g.flip();
            this.f33700h = this.f33699g;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33701i && this.f33700h == AudioProcessor.f63841a : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int[] iArr = this.f33698f;
            return iArr == null ? this.f33694b : iArr.length;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33695c : invokeV.intValue;
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
            this.f33701i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f33700h = AudioProcessor.f63841a;
            this.f33701i = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.f33700h;
            this.f33700h = AudioProcessor.f63841a;
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
        boolean z = !Arrays.equals(this.f33696d, this.f33698f);
        int[] iArr = this.f33696d;
        this.f33698f = iArr;
        if (iArr == null) {
            this.f33697e = false;
            return z;
        } else if (i4 == 2) {
            if (!z && this.f33695c == i2 && this.f33694b == i3) {
                return false;
            }
            this.f33695c = i2;
            this.f33694b = i3;
            this.f33697e = i3 != this.f33698f.length;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f33698f;
                if (i5 >= iArr2.length) {
                    return true;
                }
                int i6 = iArr2[i5];
                if (i6 < i3) {
                    this.f33697e = (i6 != i5) | this.f33697e;
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
            this.f33696d = iArr;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f33697e : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            flush();
            this.f33699g = AudioProcessor.f63841a;
            this.f33694b = -1;
            this.f33695c = -1;
            this.f33698f = null;
            this.f33697e = false;
        }
    }
}
