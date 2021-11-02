package b.q.a;

import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class x2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ byte[] f33555e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f33556f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ a4 f33557g;

    public x2(byte[] bArr, String str, a4 a4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, str, a4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33555e = bArr;
        this.f33556f = str;
        this.f33557g = a4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            byte[] bArr = this.f33555e;
            String str = this.f33556f;
            a4 a4Var = this.f33557g;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            File file = new File(str);
            String substring = str.substring(0, str.lastIndexOf("/"));
            if (!file.exists()) {
                new File(substring).mkdir();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = byteArrayInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr2, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (a4Var != null && (handler = a4Var.f33237a.f33301c.k) != null) {
                    handler.post(new x3(a4Var));
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (a4Var != null) {
                    return;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            if (a4Var != null || (handler2 = a4Var.f33237a.f33301c.k) == null) {
                return;
            }
            handler2.post(new t3(a4Var));
        }
    }
}
