package com.baidu.apollon.imagemanager;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final long f37735a = 52428800;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final InterfaceC1608a f37736b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37737c;

    /* renamed from: d  reason: collision with root package name */
    public File f37738d;

    /* renamed from: e  reason: collision with root package name */
    public long f37739e;

    /* renamed from: com.baidu.apollon.imagemanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1608a {
        List<File> a(File file);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, String str, InterfaceC1608a interfaceC1608a) {
        this(context, str, "", interfaceC1608a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, interfaceC1608a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (InterfaceC1608a) objArr2[3]);
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
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || this.f37739e >= 0) {
            return;
        }
        this.f37739e = 52428800 - c();
    }

    private long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            File[] listFiles = this.f37738d.listFiles();
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

    public a(Context context, String str, String str2, InterfaceC1608a interfaceC1608a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, interfaceC1608a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37739e = Long.MIN_VALUE;
        this.f37737c = str2;
        if (CheckUtils.isExternalStorageWriteable(context)) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                this.f37738d = new File(externalFilesDir, str);
            } else {
                this.f37738d = new File(context.getCacheDir(), str);
            }
        } else {
            this.f37738d = new File(context.getCacheDir(), str);
        }
        if (!this.f37738d.exists()) {
            this.f37738d.mkdirs();
        }
        this.f37736b = interfaceC1608a;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            return String.valueOf(str.hashCode()) + this.f37737c;
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
        InterfaceC1608a interfaceC1608a;
        List<File> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            File a3 = a(str);
            a(a3.getParentFile());
            a(bArr, a3);
            b();
            long length = this.f37739e - a(str).length();
            if (length < 0 && (interfaceC1608a = this.f37736b) != null && (a2 = interfaceC1608a.a(this.f37738d)) != null) {
                for (File file : a2) {
                    length += file.length();
                    file.delete();
                }
            }
            this.f37739e = length;
        }
    }

    public File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            File file = new File(this.f37738d, b(str));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (listFiles = this.f37738d.listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
