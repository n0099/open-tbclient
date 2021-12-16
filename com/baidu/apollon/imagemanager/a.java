package com.baidu.apollon.imagemanager;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long a = 52428800;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final InterfaceC1728a f33397b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33398c;

    /* renamed from: d  reason: collision with root package name */
    public File f33399d;

    /* renamed from: e  reason: collision with root package name */
    public long f33400e;

    /* renamed from: com.baidu.apollon.imagemanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1728a {
        List<File> a(File file);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, String str, InterfaceC1728a interfaceC1728a) {
        this(context, str, "", interfaceC1728a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, interfaceC1728a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (InterfaceC1728a) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static synchronized void a(File file) {
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

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.f33400e >= 0) {
            return;
        }
        this.f33400e = 52428800 - c();
    }

    private long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            File[] listFiles = this.f33399d.listFiles();
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

    public a(Context context, String str, String str2, InterfaceC1728a interfaceC1728a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, interfaceC1728a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33400e = Long.MIN_VALUE;
        this.f33398c = str2;
        if (CheckUtils.isExternalStorageWriteable(context)) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                this.f33399d = new File(externalFilesDir, str);
            } else {
                this.f33399d = new File(context.getCacheDir(), str);
            }
        } else {
            this.f33399d = new File(context.getCacheDir(), str);
        }
        if (!this.f33399d.exists()) {
            this.f33399d.mkdirs();
        }
        this.f33397b = interfaceC1728a;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            return String.valueOf(str.hashCode()) + this.f33398c;
        }
        return (String) invokeL.objValue;
    }

    public static void a(byte[] bArr, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bArr, file) == null) {
            try {
                FileCopyUtils.copy(bArr, file);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(String str, byte[] bArr) {
        InterfaceC1728a interfaceC1728a;
        List<File> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            File a3 = a(str);
            a(a3.getParentFile());
            a(bArr, a3);
            b();
            long length = this.f33400e - a(str).length();
            if (length < 0 && (interfaceC1728a = this.f33397b) != null && (a2 = interfaceC1728a.a(this.f33399d)) != null) {
                for (File file : a2) {
                    length += file.length();
                    file.delete();
                }
            }
            this.f33400e = length;
        }
    }

    public File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            File file = new File(this.f33399d, b(str));
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public void a() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (listFiles = this.f33399d.listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
