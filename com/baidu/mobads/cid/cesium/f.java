package com.baidu.mobads.cid.cesium;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f42771a;

    /* renamed from: b  reason: collision with root package name */
    public c f42772b;

    public f(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42771a = context;
        this.f42772b = cVar;
    }

    private e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                return e.b(com.baidu.mobads.cid.cesium.f.c.a(file));
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    private e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            List<b> b2 = this.f42772b.b(context);
            e eVar = null;
            if (b2 != null) {
                String str = com.baidu.fsg.face.base.b.c.f39676g;
                File filesDir = context.getFilesDir();
                if (!com.baidu.fsg.face.base.b.c.f39676g.equals(filesDir.getName())) {
                    String str2 = "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath();
                    str = filesDir.getName();
                }
                for (b bVar : b2) {
                    if (!bVar.f42635d) {
                        File file = new File(new File(bVar.f42632a.dataDir, str), "libcuid.so");
                        if (file.exists() && (eVar = e.b(com.baidu.mobads.cid.cesium.f.c.a(file))) != null) {
                            break;
                        }
                    }
                }
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    private e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? e.a(c("com.baidu.deviceid"), c("bd_setting_i")) : (e) invokeV.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) ? this.f42771a.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeL.booleanValue;
    }

    private String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            try {
                return Settings.System.getString(this.f42771a.getContentResolver(), str);
            } catch (Exception e2) {
                com.baidu.mobads.cid.cesium.f.c.a(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) ? "0" : (String) invokeL.objValue;
    }

    private e e(String str) {
        InterceptResult invokeL;
        String str2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            String str3 = "";
            File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
            if (!file.exists()) {
                file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append(Part.CRLF);
                }
                bufferedReader.close();
                byte[] a2 = com.baidu.mobads.cid.cesium.c.a.g.a();
                split = new String(com.baidu.mobads.cid.cesium.c.a.c.a(a2, a2, com.baidu.mobads.cid.cesium.d.a.a(sb.toString().getBytes()))).split("=");
            } catch (FileNotFoundException | IOException | Exception unused) {
            }
            if (split != null && split.length == 2) {
                str2 = split[0];
                try {
                    str3 = split[1];
                } catch (FileNotFoundException | IOException | Exception unused2) {
                }
                return e.a(str3, str2);
            }
            str2 = "";
            return e.a(str3, str2);
        }
        return (e) invokeL.objValue;
    }

    public e a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            e a2 = a(this.f42771a);
            if (a2 == null) {
                a2 = e.b(c("com.baidu.deviceid.v2"));
            }
            boolean b2 = b("android.permission.READ_EXTERNAL_STORAGE");
            if (a2 == null && b2) {
                a2 = a();
            }
            if (a2 == null) {
                a2 = b();
            }
            boolean z = false;
            if (a2 == null && b2) {
                z = true;
                a2 = e(d(""));
            }
            if (!z) {
                d("");
            }
            if (a2 != null) {
                a2.c();
            }
            return a2;
        }
        return (e) invokeL.objValue;
    }
}
