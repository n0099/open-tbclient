package c.i.b.a.x;

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
/* loaded from: classes4.dex */
public final class e implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f33911b;

    /* renamed from: c  reason: collision with root package name */
    public int f33912c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f33913d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33914e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f33915f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f33916g;

    /* renamed from: h  reason: collision with root package name */
    public ByteBuffer f33917h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33918i;

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
        ByteBuffer byteBuffer = AudioProcessor.f69886a;
        this.f33916g = byteBuffer;
        this.f33917h = byteBuffer;
        this.f33911b = -1;
        this.f33912c = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int length = ((limit - position) / (this.f33911b * 2)) * this.f33915f.length * 2;
            if (this.f33916g.capacity() < length) {
                this.f33916g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.f33916g.clear();
            }
            while (position < limit) {
                for (int i2 : this.f33915f) {
                    this.f33916g.putShort(byteBuffer.getShort((i2 * 2) + position));
                }
                position += this.f33911b * 2;
            }
            byteBuffer.position(limit);
            this.f33916g.flip();
            this.f33917h = this.f33916g;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33918i && this.f33917h == AudioProcessor.f69886a : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int[] iArr = this.f33915f;
            return iArr == null ? this.f33911b : iArr.length;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33912c : invokeV.intValue;
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
            this.f33918i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f33917h = AudioProcessor.f69886a;
            this.f33918i = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.f33917h;
            this.f33917h = AudioProcessor.f69886a;
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
        boolean z = !Arrays.equals(this.f33913d, this.f33915f);
        int[] iArr = this.f33913d;
        this.f33915f = iArr;
        if (iArr == null) {
            this.f33914e = false;
            return z;
        } else if (i4 == 2) {
            if (!z && this.f33912c == i2 && this.f33911b == i3) {
                return false;
            }
            this.f33912c = i2;
            this.f33911b = i3;
            this.f33914e = i3 != this.f33915f.length;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f33915f;
                if (i5 >= iArr2.length) {
                    return true;
                }
                int i6 = iArr2[i5];
                if (i6 < i3) {
                    this.f33914e = (i6 != i5) | this.f33914e;
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
            this.f33913d = iArr;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f33914e : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            flush();
            this.f33916g = AudioProcessor.f69886a;
            this.f33911b = -1;
            this.f33912c = -1;
            this.f33915f = null;
            this.f33914e = false;
        }
    }
}
