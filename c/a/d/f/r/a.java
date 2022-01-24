package c.a.d.f.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f3136e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3137f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f3138g;

    public a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3136e = i2;
        this.f3137f = i3;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        this.f3138g = allocateDirect;
        allocateDirect.clear();
    }

    public Buffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3138g.clear() : (Buffer) invokeV.objValue;
    }

    public synchronized void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                write(13);
                write(10);
            }
        }
    }

    public synchronized void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            synchronized (this) {
                if (i2 > this.f3138g.capacity()) {
                    ByteBuffer byteBuffer = this.f3138g;
                    int position = this.f3138g.position();
                    this.f3138g = ByteBuffer.allocateDirect(((i2 / this.f3137f) + 1) * this.f3137f);
                    byteBuffer.clear();
                    this.f3138g.clear();
                    this.f3138g.put(byteBuffer);
                    this.f3138g.position(position);
                }
            }
        }
    }

    public Buffer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3138g.flip() : (Buffer) invokeV.objValue;
    }

    public ByteBuffer f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3138g : (ByteBuffer) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3138g.remaining() : invokeV.intValue;
    }

    public synchronized void h(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this) {
                write(str.getBytes("UTF-8"));
            }
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            synchronized (this) {
                if (this.f3138g.position() + 1 > this.f3138g.capacity()) {
                    d(this.f3138g.capacity() + 1);
                }
                this.f3138g.put((byte) i2);
            }
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, bArr, i2, i3) == null) {
            synchronized (this) {
                if (this.f3138g.position() + i3 > this.f3138g.capacity()) {
                    d(this.f3138g.capacity() + i3);
                }
                this.f3138g.put(bArr, i2, i3);
            }
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr) == null) {
            synchronized (this) {
                write(bArr, 0, bArr.length);
            }
        }
    }
}
