package c.a.n0.a.h0.o.h.g;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class d implements c.a.n0.a.h0.o.h.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f6074b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f6075c;

    /* renamed from: d  reason: collision with root package name */
    public File f6076d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6077e;

    /* loaded from: classes.dex */
    public interface a {
        void a(File file);

        void b(File file);
    }

    public d(File file, a aVar) {
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
        this.f6076d = file;
        this.f6074b = aVar;
        b(file);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f6075c == null) {
            return;
        }
        a aVar = this.f6074b;
        if (aVar != null) {
            if (this.f6077e) {
                aVar.a(this.f6076d);
            } else {
                aVar.b(this.f6076d);
            }
        }
        c.a.n0.t.d.d(this.f6075c);
    }

    public final void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
            try {
                if (this.f6075c != null || file == null) {
                    return;
                }
                c.a.n0.t.d.h(this.f6076d);
                this.f6075c = new FileOutputStream(file);
            } catch (Exception e2) {
                if (c.a.n0.a.h0.o.h.e.a.f6048a) {
                    Log.getStackTraceString(e2);
                }
            }
        }
    }

    public void c(byte[] bArr, int i2, int i3) {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) || (outputStream = this.f6075c) == null) {
            return;
        }
        try {
            if (i3 > 0) {
                outputStream.write(bArr, i2, i3);
            } else {
                this.f6077e = true;
            }
        } catch (IOException unused) {
            c.a.n0.t.d.d(this.f6075c);
            this.f6075c = null;
            a aVar = this.f6074b;
            if (aVar != null) {
                aVar.b(this.f6076d);
            }
        }
    }
}
