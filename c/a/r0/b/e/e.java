package c.a.r0.b.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class e extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d f29755e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29756f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f29757g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f29758h;

    public e(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29755e = dVar;
    }

    public final void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f29756f) {
                IOException iOException = this.f29758h;
                if (iOException != null) {
                    throw iOException;
                }
            } else if (n()) {
            } else {
                if (this.f29757g == null) {
                    this.f29757g = ByteBuffer.allocateDirect(32768);
                }
                this.f29757g.clear();
                this.f29755e.u(this.f29757g);
                IOException iOException2 = this.f29758h;
                if (iOException2 == null) {
                    ByteBuffer byteBuffer = this.f29757g;
                    if (byteBuffer != null) {
                        byteBuffer.flip();
                        return;
                    }
                    return;
                }
                throw iOException2;
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ByteBuffer byteBuffer = this.f29757g;
            return byteBuffer != null && byteBuffer.hasRemaining();
        }
        return invokeV.booleanValue;
    }

    public void o(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iOException) == null) {
            this.f29758h = iOException;
            this.f29756f = true;
            this.f29757g = null;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g();
            if (n()) {
                return this.f29757g.get() & 255;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            g();
            if (n()) {
                int min = Math.min(this.f29757g.limit() - this.f29757g.position(), i3);
                this.f29757g.get(bArr, i2, min);
                return min;
            }
            return -1;
        }
        return invokeLII.intValue;
    }
}
