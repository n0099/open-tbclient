package c.a.p0.a.x.o.g.f;

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
public final class e implements c.a.p0.a.x.o.g.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f8763b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f8764c;

    /* renamed from: d  reason: collision with root package name */
    public File f8765d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8766e;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8765d = file;
        this.f8763b = aVar;
        b(file);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8764c == null) {
            return;
        }
        a aVar = this.f8763b;
        if (aVar != null) {
            if (this.f8766e) {
                aVar.a(this.f8765d);
            } else {
                aVar.b(this.f8765d);
            }
        }
        c.a.p0.w.d.d(this.f8764c);
    }

    public final void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
            try {
                if (this.f8764c != null || file == null) {
                    return;
                }
                c.a.p0.w.d.h(this.f8765d);
                this.f8764c = new FileOutputStream(file);
            } catch (Exception e2) {
                if (c.a.p0.a.x.o.g.d.a.a) {
                    Log.getStackTraceString(e2);
                }
            }
        }
    }

    public void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) || inputStream == null || this.f8766e) {
            return;
        }
        c.a.p0.w.d.Q(inputStream, this.f8765d);
        this.f8766e = true;
    }

    public void d(byte[] bArr, int i2, int i3) {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) || (outputStream = this.f8764c) == null) {
            return;
        }
        try {
            if (i3 > 0) {
                outputStream.write(bArr, i2, i3);
            } else {
                this.f8766e = true;
            }
        } catch (IOException unused) {
            c.a.p0.w.d.d(this.f8764c);
            this.f8764c = null;
            a aVar = this.f8763b;
            if (aVar != null) {
                aVar.b(this.f8765d);
            }
        }
    }
}
