package c.a.x.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaMuxer a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f26810b;

    /* renamed from: c  reason: collision with root package name */
    public f f26811c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-92176345, "Lc/a/x/c/g/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-92176345, "Lc/a/x/c/g/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26810b = false;
    }

    public synchronized int a(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                try {
                    int addTrack = this.a.addTrack(mediaFormat);
                    if (addTrack >= 0) {
                        return addTrack;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public boolean b(String str, int i2, f fVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, fVar)) == null) {
            if (!c.a.x.c.h.a.a(str)) {
                c.a.x.c.h.a.b(str);
            }
            try {
                this.a = new MediaMuxer(str, i2);
                this.f26811c = fVar;
                this.f26810b = false;
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26810b : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f26810b) {
            return;
        }
        this.a.release();
        this.a = null;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                boolean z = true;
                try {
                    this.a.start();
                    this.f26810b = true;
                } catch (Exception unused) {
                    z = false;
                }
                if (this.f26811c != null) {
                    this.f26811c.a(z);
                }
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                boolean z = false;
                try {
                    this.a.stop();
                    this.f26810b = false;
                    z = true;
                } catch (Exception unused) {
                }
                if (this.f26811c != null) {
                    this.f26811c.b(z);
                }
            }
        }
    }

    public boolean g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, byteBuffer, bufferInfo)) == null) {
            if (i2 != -1) {
                try {
                    this.a.writeSampleData(i2, byteBuffer, bufferInfo);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeILL.booleanValue;
    }
}
