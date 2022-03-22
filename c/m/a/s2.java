package c.m.a;

import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class s2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23555b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v3 f23556c;

    public s2(byte[] bArr, String str, v3 v3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, str, v3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bArr;
        this.f23555b = str;
        this.f23556c = v3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            byte[] bArr = this.a;
            String str = this.f23555b;
            v3 v3Var = this.f23556c;
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
                if (v3Var != null && (handler = v3Var.a.f23614c.k) != null) {
                    handler.post(new s3(v3Var));
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (v3Var != null) {
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
            if (v3Var != null || (handler2 = v3Var.a.f23614c.k) == null) {
                return;
            }
            handler2.post(new o3(v3Var));
        }
    }
}
