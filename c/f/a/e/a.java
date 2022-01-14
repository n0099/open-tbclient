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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InterfaceC1638a a;

    /* renamed from: b  reason: collision with root package name */
    public final String f28099b;

    /* renamed from: c  reason: collision with root package name */
    public File f28100c;

    /* renamed from: d  reason: collision with root package name */
    public long f28101d;

    /* renamed from: c.f.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1638a {
        List<File> a(File file);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, String str, InterfaceC1638a interfaceC1638a) {
        this(context, str, "", interfaceC1638a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, interfaceC1638a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (InterfaceC1638a) objArr2[3]);
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
            File file = new File(this.f28100c, g(str));
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28101d >= 0) {
            return;
        }
        this.f28101d = 52428800 - f();
    }

    public void d(String str, byte[] bArr) {
        InterfaceC1638a interfaceC1638a;
        List<File> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            File a2 = a(str);
            c(a2.getParentFile());
            e(bArr, a2);
            b();
            long length = this.f28101d - a(str).length();
            if (length < 0 && (interfaceC1638a = this.a) != null && (a = interfaceC1638a.a(this.f28100c)) != null) {
                for (File file : a) {
                    length += file.length();
                    file.delete();
                }
            }
            this.f28101d = length;
        }
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File[] listFiles = this.f28100c.listFiles();
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
            return String.valueOf(str.hashCode()) + this.f28099b;
        }
        return (String) invokeL.objValue;
    }

    public a(Context context, String str, String str2, InterfaceC1638a interfaceC1638a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, interfaceC1638a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28101d = Long.MIN_VALUE;
        this.f28099b = str2;
        if (CheckUtils.isExternalStorageWriteable(context)) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                this.f28100c = new File(externalFilesDir, str);
            } else {
                this.f28100c = new File(context.getCacheDir(), str);
            }
        } else {
            this.f28100c = new File(context.getCacheDir(), str);
        }
        if (!this.f28100c.exists()) {
            this.f28100c.mkdirs();
        }
        this.a = interfaceC1638a;
    }
}
