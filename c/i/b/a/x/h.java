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
/* loaded from: classes4.dex */
public final class h implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f33817b;

    /* renamed from: c  reason: collision with root package name */
    public int f33818c;

    /* renamed from: d  reason: collision with root package name */
    public int f33819d;

    /* renamed from: e  reason: collision with root package name */
    public ByteBuffer f33820e;

    /* renamed from: f  reason: collision with root package name */
    public ByteBuffer f33821f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33822g;

    public h() {
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
        this.f33817b = -1;
        this.f33818c = -1;
        this.f33819d = 0;
        ByteBuffer byteBuffer = AudioProcessor.f69686a;
        this.f33820e = byteBuffer;
        this.f33821f = byteBuffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085 A[LOOP:2: B:27:0x0085->B:28:0x0087, LOOP_START, PHI: r0 
      PHI: (r0v3 int) = (r0v2 int), (r0v4 int) binds: [B:18:0x0045, B:28:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ByteBuffer byteBuffer) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            int i4 = limit - position;
            int i5 = this.f33819d;
            if (i5 == Integer.MIN_VALUE) {
                i4 /= 3;
            } else if (i5 != 3) {
                if (i5 == 1073741824) {
                    i2 = i4 / 2;
                    if (this.f33820e.capacity() >= i2) {
                        this.f33820e = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
                    } else {
                        this.f33820e.clear();
                    }
                    i3 = this.f33819d;
                    if (i3 != Integer.MIN_VALUE) {
                        while (position < limit) {
                            this.f33820e.put(byteBuffer.get(position + 1));
                            this.f33820e.put(byteBuffer.get(position + 2));
                            position += 3;
                        }
                    } else if (i3 == 3) {
                        while (position < limit) {
                            this.f33820e.put((byte) 0);
                            this.f33820e.put((byte) ((byteBuffer.get(position) & 255) + com.alipay.sdk.encrypt.a.f35772g));
                            position++;
                        }
                    } else if (i3 != 1073741824) {
                        throw new IllegalStateException();
                    } else {
                        while (position < limit) {
                            this.f33820e.put(byteBuffer.get(position + 2));
                            this.f33820e.put(byteBuffer.get(position + 3));
                            position += 4;
                        }
                    }
                    byteBuffer.position(byteBuffer.limit());
                    this.f33820e.flip();
                    this.f33821f = this.f33820e;
                }
                throw new IllegalStateException();
            }
            i2 = i4 * 2;
            if (this.f33820e.capacity() >= i2) {
            }
            i3 = this.f33819d;
            if (i3 != Integer.MIN_VALUE) {
            }
            byteBuffer.position(byteBuffer.limit());
            this.f33820e.flip();
            this.f33821f = this.f33820e;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33822g && this.f33821f == AudioProcessor.f69686a : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33818c : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33817b : invokeV.intValue;
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
            this.f33822g = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f33821f = AudioProcessor.f69686a;
            this.f33822g = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.f33821f;
            this.f33821f = AudioProcessor.f69686a;
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h(int i2, int i3, int i4) throws AudioProcessor.UnhandledFormatException {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4)) == null) {
            if (i4 != 3 && i4 != 2 && i4 != Integer.MIN_VALUE && i4 != 1073741824) {
                throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
            }
            if (this.f33817b == i2 && this.f33818c == i3 && this.f33819d == i4) {
                return false;
            }
            this.f33817b = i2;
            this.f33818c = i3;
            this.f33819d = i4;
            if (i4 == 2) {
                this.f33820e = AudioProcessor.f69686a;
                return true;
            }
            return true;
        }
        return invokeIII.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f33819d;
            return (i2 == 0 || i2 == 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            flush();
            this.f33820e = AudioProcessor.f69686a;
            this.f33817b = -1;
            this.f33818c = -1;
            this.f33819d = 0;
        }
    }
}
