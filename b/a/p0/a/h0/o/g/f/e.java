package b.a.p0.a.h0.o.g.f;

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
public final class e implements b.a.p0.a.h0.o.g.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f5981b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f5982c;

    /* renamed from: d  reason: collision with root package name */
    public File f5983d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5984e;

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
        this.f5983d = file;
        this.f5981b = aVar;
        b(file);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5982c == null) {
            return;
        }
        a aVar = this.f5981b;
        if (aVar != null) {
            if (this.f5984e) {
                aVar.a(this.f5983d);
            } else {
                aVar.b(this.f5983d);
            }
        }
        b.a.p0.w.d.d(this.f5982c);
    }

    public final void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
            try {
                if (this.f5982c != null || file == null) {
                    return;
                }
                b.a.p0.w.d.h(this.f5983d);
                this.f5982c = new FileOutputStream(file);
            } catch (Exception e2) {
                if (b.a.p0.a.h0.o.g.d.a.f5954a) {
                    Log.getStackTraceString(e2);
                }
            }
        }
    }

    public void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) || inputStream == null || this.f5984e) {
            return;
        }
        b.a.p0.w.d.Q(inputStream, this.f5983d);
        this.f5984e = true;
    }

    public void d(byte[] bArr, int i2, int i3) {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) || (outputStream = this.f5982c) == null) {
            return;
        }
        try {
            if (i3 > 0) {
                outputStream.write(bArr, i2, i3);
            } else {
                this.f5984e = true;
            }
        } catch (IOException unused) {
            b.a.p0.w.d.d(this.f5982c);
            this.f5982c = null;
            a aVar = this.f5981b;
            if (aVar != null) {
                aVar.b(this.f5983d);
            }
        }
    }
}
