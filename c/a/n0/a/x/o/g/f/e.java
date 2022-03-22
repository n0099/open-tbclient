package c.a.n0.a.x.o.g.f;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class e implements c.a.n0.a.x.o.g.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f7366b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f7367c;

    /* renamed from: d  reason: collision with root package name */
    public File f7368d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7369e;

    /* loaded from: classes.dex */
    public interface a {
        void a(File file);

        void b(File file);
    }

    public e(File file, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7368d = file;
        this.f7366b = aVar;
        b(file);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f7367c == null) {
            return;
        }
        a aVar = this.f7366b;
        if (aVar != null) {
            if (this.f7369e) {
                aVar.a(this.f7368d);
            } else {
                aVar.b(this.f7368d);
            }
        }
        c.a.n0.w.d.d(this.f7367c);
    }

    public final void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
            try {
                if (this.f7367c != null || file == null) {
                    return;
                }
                c.a.n0.w.d.h(this.f7368d);
                this.f7367c = new FileOutputStream(file);
            } catch (Exception e2) {
                if (c.a.n0.a.x.o.g.d.a.a) {
                    Log.e("HybridIntercept", Log.getStackTraceString(e2));
                }
            }
        }
    }

    public void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) || inputStream == null || this.f7369e) {
            return;
        }
        c.a.n0.w.d.Q(inputStream, this.f7368d);
        this.f7369e = true;
    }

    public void d(byte[] bArr, int i, int i2) {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, bArr, i, i2) == null) || (outputStream = this.f7367c) == null) {
            return;
        }
        try {
            if (i2 > 0) {
                outputStream.write(bArr, i, i2);
            } else {
                this.f7369e = true;
            }
        } catch (IOException unused) {
            c.a.n0.w.d.d(this.f7367c);
            this.f7367c = null;
            a aVar = this.f7366b;
            if (aVar != null) {
                aVar.b(this.f7368d);
            }
        }
    }
}
