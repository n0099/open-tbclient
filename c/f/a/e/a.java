package c.f.a.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.FileCopyUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1464a f32058a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32059b;

    /* renamed from: c  reason: collision with root package name */
    public File f32060c;

    /* renamed from: d  reason: collision with root package name */
    public long f32061d;

    /* renamed from: c.f.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1464a {
        List<File> a(File file);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, String str, InterfaceC1464a interfaceC1464a) {
        this(context, str, "", interfaceC1464a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, interfaceC1464a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (InterfaceC1464a) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static synchronized void c(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            synchronized (a.class) {
                if (file == null) {
                    return;
                }
                if (!file.isDirectory()) {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.mkdirs();
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void e(byte[] bArr, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bArr, file) == null) {
            try {
                FileCopyUtils.copy(bArr, file);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            File file = new File(this.f32060c, g(str));
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f32061d >= 0) {
            return;
        }
        this.f32061d = 52428800 - f();
    }

    public void d(String str, byte[] bArr) {
        InterfaceC1464a interfaceC1464a;
        List<File> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            File a3 = a(str);
            c(a3.getParentFile());
            e(bArr, a3);
            b();
            long length = this.f32061d - a(str).length();
            if (length < 0 && (interfaceC1464a = this.f32058a) != null && (a2 = interfaceC1464a.a(this.f32060c)) != null) {
                for (File file : a2) {
                    length += file.length();
                    file.delete();
                }
            }
            this.f32061d = length;
        }
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File[] listFiles = this.f32060c.listFiles();
            long j2 = 0;
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    j2 += file.length();
                }
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return String.valueOf(str.hashCode()) + this.f32059b;
        }
        return (String) invokeL.objValue;
    }

    public a(Context context, String str, String str2, InterfaceC1464a interfaceC1464a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, interfaceC1464a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32061d = Long.MIN_VALUE;
        this.f32059b = str2;
        if (CheckUtils.isExternalStorageWriteable(context)) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                this.f32060c = new File(externalFilesDir, str);
            } else {
                this.f32060c = new File(context.getCacheDir(), str);
            }
        } else {
            this.f32060c = new File(context.getCacheDir(), str);
        }
        if (!this.f32060c.exists()) {
            this.f32060c.mkdirs();
        }
        this.f32058a = interfaceC1464a;
    }
}
