package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/* loaded from: classes2.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h a;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public final List d;
    public g e;
    public String f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(42760346, "Lcom/baidu/mapsdkplatform/comapi/util/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(42760346, "Lcom/baidu/mapsdkplatform/comapi/util/h;");
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = true;
        this.d = new ArrayList();
        this.e = null;
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (h.class) {
                    if (a == null) {
                        a = new h();
                    }
                }
            }
            return a;
        }
        return (h) invokeV.objValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            boolean z = false;
            try {
                File file = new File(str + "/test.0");
                if (file.exists()) {
                    file.delete();
                }
                z = file.createNewFile();
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private void c(Context context) {
        boolean z;
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            try {
                StorageManager storageManager = (StorageManager) context.getSystemService("storage");
                Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
                int i = 1;
                Method method2 = storageManager.getClass().getMethod("getVolumeState", String.class);
                Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                Method method3 = cls.getMethod("isRemovable", new Class[0]);
                Method method4 = cls.getMethod("getPath", new Class[0]);
                Object[] objArr2 = (Object[]) method.invoke(storageManager, new Object[0]);
                if (objArr2 != null) {
                    int length = objArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        Object obj = objArr2[i2];
                        String str = (String) method4.invoke(obj, new Object[0]);
                        if (str == null || str.length() <= 0) {
                            objArr = objArr2;
                        } else {
                            objArr = objArr2;
                            Object[] objArr3 = new Object[i];
                            objArr3[0] = str;
                            if ("mounted".equals(method2.invoke(storageManager, objArr3))) {
                                boolean z2 = !((Boolean) method3.invoke(obj, new Object[0])).booleanValue();
                                if (Build.VERSION.SDK_INT <= 19 && a(str)) {
                                    this.d.add(new g(str, !z2, z2 ? "内置存储卡" : "外置存储卡", context));
                                } else if (Build.VERSION.SDK_INT >= 19) {
                                    if (new File(str + File.separator + "BaiduMapSDKNew").exists() && str.equals(context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", ""))) {
                                        this.f = str + File.separator + "BaiduMapSDKNew";
                                    }
                                }
                            }
                        }
                        i2++;
                        objArr2 = objArr;
                        i = 1;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        File[] externalFilesDirs = context.getExternalFilesDirs(null);
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(this.d);
                        for (int i3 = 0; i3 < externalFilesDirs.length && externalFilesDirs[i3] != null; i3++) {
                            String absolutePath = externalFilesDirs[i3].getAbsolutePath();
                            Iterator it = this.d.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (absolutePath.startsWith(((g) it.next()).a())) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                            String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                            if (str2 != null && !z && absolutePath.indexOf(str2) != -1) {
                                arrayList.add(new g(absolutePath, true, "外置存储卡", context));
                            }
                        }
                        this.d.clear();
                        this.d.addAll(arrayList);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void d(Context context) {
        Scanner scanner;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65541, this, context) != null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Scanner scanner2 = null;
        try {
            try {
                File file = new File("/proc/mounts");
                if (file.exists()) {
                    scanner = new Scanner(file);
                    while (scanner.hasNext()) {
                        try {
                            String nextLine = scanner.nextLine();
                            if (nextLine.startsWith("/dev/block/vold/") && (split2 = nextLine.replace('\t', WebvttCueParser.CHAR_SPACE).split(" ")) != null && split2.length > 0) {
                                arrayList.add(split2[1]);
                            }
                        } catch (Exception e) {
                            e = e;
                            scanner2 = scanner;
                            e.printStackTrace();
                            if (scanner2 != null) {
                                scanner2.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            scanner2 = scanner;
                            if (scanner2 != null) {
                                scanner2.close();
                            }
                            throw th;
                        }
                    }
                    scanner.close();
                }
                File file2 = new File("/system/etc/vold.fstab");
                if (file2.exists()) {
                    scanner = new Scanner(file2);
                    while (scanner.hasNext()) {
                        String nextLine2 = scanner.nextLine();
                        if (nextLine2.startsWith("dev_mount") && (split = nextLine2.replace('\t', WebvttCueParser.CHAR_SPACE).split(" ")) != null && split.length > 0) {
                            String str = split[2];
                            if (str.contains(":")) {
                                str = str.substring(0, str.indexOf(":"));
                            }
                            arrayList2.add(str);
                        }
                    }
                    scanner.close();
                }
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                this.d.add(new g(absolutePath, false, "Auto", context));
                for (String str2 : arrayList) {
                    if (arrayList2.contains(str2) && !str2.equals(absolutePath)) {
                        File file3 = new File(str2);
                        if (file3.exists() && file3.isDirectory() && file3.canWrite()) {
                            this.d.add(new g(str2, false, "Auto", context));
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0086 A[Catch: Exception -> 0x0091, TRY_LEAVE, TryCatch #2 {Exception -> 0x0091, blocks: (B:16:0x001f, B:18:0x0027, B:19:0x002f, B:21:0x0035, B:23:0x004a, B:25:0x0050, B:27:0x0058, B:28:0x005e, B:30:0x0064, B:32:0x0070, B:38:0x0082, B:40:0x0086, B:34:0x0075, B:37:0x007c), top: B:69:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || this.b) {
            return;
        }
        this.b = true;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                c(context);
            } else {
                d(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.d.size() > 0) {
            r2 = null;
            int i = 0;
            for (g gVar : this.d) {
                if (new File(gVar.b()).exists()) {
                    i++;
                    r2 = gVar;
                }
            }
            if (i == 0) {
                g b = b(context);
                this.e = b;
                if (b == null) {
                    for (g gVar2 : this.d) {
                        if (a(context, gVar2)) {
                            this.e = gVar2;
                            break;
                        }
                    }
                }
                if (this.e == null) {
                    this.e = (g) this.d.get(0);
                }
            } else {
                if (i != 1) {
                    this.e = b(context);
                } else if (a(context, gVar2)) {
                    this.e = gVar2;
                    break;
                }
                if (this.e == null) {
                }
            }
            e2.printStackTrace();
        }
        try {
            if (this.e == null || !a(this.e.a())) {
                this.c = false;
                this.e = new g(context);
                this.d.clear();
                this.d.add(this.e);
                return;
            }
            File file = new File(this.e.b());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(this.e.c());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, ".nomedia");
            if (file3.exists()) {
                return;
            }
            file3.createNewFile();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public boolean a(Context context, g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gVar)) == null) {
            String a2 = gVar.a();
            if (a(a2)) {
                SharedPreferences.Editor edit = context.getSharedPreferences("map_pref", 0).edit();
                edit.putString("PREFFERED_SD_CARD", a2);
                return edit.commit();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (g) invokeV.objValue;
    }

    public g b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
            if (string == null || string.length() <= 0) {
                return null;
            }
            for (g gVar : this.d) {
                if (gVar.a().equals(string)) {
                    return gVar;
                }
            }
            return null;
        }
        return (g) invokeL.objValue;
    }
}
