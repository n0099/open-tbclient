package c.p.a.e.a.h.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InputStream f35028a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35029b;

    /* renamed from: c  reason: collision with root package name */
    public int f35030c;

    public c(InputStream inputStream, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c(inputStream, z);
    }

    public final int a(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= 0 && i2 <= 4) {
                int i3 = 0;
                if (this.f35029b) {
                    for (int i4 = (i2 - 1) * 8; i4 >= 0; i4 -= 8) {
                        int read = this.f35028a.read();
                        if (read == -1) {
                            throw new EOFException();
                        }
                        this.f35030c++;
                        i3 |= read << i4;
                    }
                    return i3;
                }
                int i5 = i2 * 8;
                int i6 = 0;
                while (i3 != i5) {
                    int read2 = this.f35028a.read();
                    if (read2 == -1) {
                        throw new EOFException();
                    }
                    this.f35030c++;
                    i6 |= read2 << i3;
                    i3 += 8;
                }
                return i6;
            }
            throw new IllegalArgumentException();
        }
        return invokeI.intValue;
    }

    public final void b() {
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (inputStream = this.f35028a) == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
        c(null, false);
    }

    public final void c(InputStream inputStream, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, inputStream, z) == null) {
            this.f35028a = inputStream;
            this.f35029b = z;
            this.f35030c = 0;
        }
    }

    public final void d(int[] iArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, iArr, i2, i3) == null) {
            while (i3 > 0) {
                iArr[i2] = e();
                i3--;
                i2++;
            }
        }
    }

    public final int e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(4) : invokeV.intValue;
    }

    public final int[] f(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int[] iArr = new int[i2];
            d(iArr, 0, i2);
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public final void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h(4);
        }
    }

    public final void h(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 <= 0) {
            return;
        }
        long j2 = i2;
        long skip = this.f35028a.skip(j2);
        this.f35030c = (int) (this.f35030c + skip);
        if (skip != j2) {
            throw new EOFException();
        }
    }
}
