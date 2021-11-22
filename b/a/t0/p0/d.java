package b.a.t0.p0;

import b.a.t0.b0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes6.dex */
public class d extends GZIPOutputStream {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f29750i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MessageDigest f29751e;

    /* renamed from: f  reason: collision with root package name */
    public int f29752f;

    /* renamed from: g  reason: collision with root package name */
    public int f29753g;

    /* renamed from: h  reason: collision with root package name */
    public StringBuilder f29754h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(854612346, "Lb/a/t0/p0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(854612346, "Lb/a/t0/p0/d;");
                return;
            }
        }
        f29750i = b0.m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(OutputStream outputStream) throws IOException {
        super(outputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((OutputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29751e = null;
        this.f29752f = 0;
        this.f29753g = 0;
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MessageDigest messageDigest = this.f29751e;
            if (messageDigest == null || this.f29752f != 2) {
                return null;
            }
            return messageDigest.digest();
        }
        return (byte[]) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = this.f29754h;
            return sb != null ? sb.toString() : "";
        }
        return (String) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f29751e == null) {
                try {
                    this.f29751e = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
            }
            MessageDigest messageDigest = this.f29751e;
            if (messageDigest != null) {
                messageDigest.reset();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f29752f = 1;
            this.f29753g = 0;
            if (f29750i) {
                this.f29754h = new StringBuilder();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29752f = 2;
        }
    }

    @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            synchronized (this) {
                super.write(bArr, i2, i3);
                this.f29753g += i3;
                if (this.f29752f == 1) {
                    if (bArr[i2] == 58 && this.f29751e == null) {
                        i2++;
                        i3--;
                    }
                    if (this.f29751e == null) {
                        e();
                    }
                    if (this.f29751e == null) {
                        return;
                    }
                    this.f29751e.update(bArr, i2, i3);
                    if (f29750i) {
                        this.f29754h.append(new String(bArr, i2, i3));
                    }
                }
            }
        }
    }
}
