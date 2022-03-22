package c.a.n0.a.p2;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public final class k0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        public a(String str, boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-850762210, "Lc/a/n0/a/p2/k0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-850762210, "Lc/a/n0/a/p2/k0;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b()) {
                return (int) (new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes() / 1024);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }

    public static long c() {
        InterceptResult invokeV;
        long blockSize;
        long availableBlocks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                if (d.d()) {
                    blockSize = statFs.getBlockSizeLong();
                    availableBlocks = statFs.getAvailableBlocksLong();
                } else {
                    blockSize = statFs.getBlockSize();
                    availableBlocks = statFs.getAvailableBlocks();
                }
                return availableBlocks * blockSize;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<a> d() {
        InterceptResult invokeV;
        HashSet hashSet;
        BufferedReader bufferedReader;
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader2 = null;
            File externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null);
            String path = externalFilesDir == null ? null : externalFilesDir.getPath();
            int i2 = 1;
            boolean z = false;
            boolean z2 = d.b() ? !Environment.isExternalStorageRemovable() : false;
            String externalStorageState = Environment.getExternalStorageState();
            boolean z3 = externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro");
            boolean equals = Environment.getExternalStorageState().equals("mounted_ro");
            try {
                try {
                    hashSet = new HashSet();
                    bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                bufferedReader2 = null;
            } catch (IOException e3) {
                e = e3;
                bufferedReader2 = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = null;
            }
            try {
                if (a) {
                    Log.d(StorageUtils.TAG, "/proc/mounts");
                }
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (a) {
                        Log.d(StorageUtils.TAG, readLine);
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
                    String nextToken = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    if (!hashSet.contains(nextToken2)) {
                        stringTokenizer.nextToken();
                        boolean contains = Arrays.asList(stringTokenizer.nextToken().split(",")).contains("ro");
                        if (!readLine.contains("vfat") && !readLine.contains("/mnt")) {
                            if (e(nextToken, nextToken2)) {
                                hashSet.add(nextToken2);
                                if (f(nextToken2)) {
                                    i = i2 + 1;
                                    arrayList.add(new a(nextToken2, z, contains, i2));
                                    i2 = i;
                                }
                            }
                            z = false;
                        }
                        if (nextToken2.equals(path)) {
                            hashSet.add(path);
                            hashMap.put(nextToken, new a(path, z2, contains, -1));
                        } else if (readLine.contains("/dev/block/vold")) {
                            if (!readLine.contains("/mnt/secure") && !readLine.contains("/mnt/asec") && !readLine.contains("/mnt/obb") && !readLine.contains("/dev/mapper") && !readLine.contains("tmpfs")) {
                                hashSet.add(nextToken2);
                                if (!hashMap.containsKey(nextToken)) {
                                    i = i2 + 1;
                                    hashMap.put(nextToken, new a(nextToken2, z, contains, i2));
                                    i2 = i;
                                }
                            }
                        } else if (hashSet.contains(nextToken)) {
                            Iterator it = hashMap.keySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                str = (String) it.next();
                                if (TextUtils.equals(((a) hashMap.get(str)).a, nextToken)) {
                                    break;
                                }
                            }
                            hashMap.remove(str);
                            hashSet.add(nextToken2);
                            if (!hashMap.containsKey(nextToken)) {
                                hashMap.put(nextToken, new a(nextToken2, false, contains, i2));
                                i2++;
                            }
                        }
                        z = false;
                    }
                }
                for (a aVar : hashMap.values()) {
                    if (f(aVar.a)) {
                        arrayList.add(aVar);
                    }
                }
                if (!hashSet.contains(path) && z3) {
                    arrayList.add(0, new a(path, z2, equals, -1));
                }
                c.a.n0.w.d.d(bufferedReader);
            } catch (FileNotFoundException e4) {
                e = e4;
                bufferedReader2 = bufferedReader;
                if (a) {
                    e.printStackTrace();
                }
                c.a.n0.w.d.d(bufferedReader2);
                if (arrayList.isEmpty()) {
                }
                return arrayList;
            } catch (IOException e5) {
                e = e5;
                bufferedReader2 = bufferedReader;
                if (a) {
                    e.printStackTrace();
                }
                c.a.n0.w.d.d(bufferedReader2);
                if (arrayList.isEmpty()) {
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader;
                c.a.n0.w.d.d(bufferedReader2);
                throw th;
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new a(path, z2, equals, -1));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (str == null || !str.contains("/dev/fuse") || str2 == null || str2.startsWith("/storage/emulated/legacy") || str2.contains("/Android/obb")) {
                return false;
            }
            if (str2.startsWith("/storage/")) {
                return true;
            }
            return (!d.e() || str2.startsWith("/mnt/") || str2.startsWith("/data/")) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).canRead();
        }
        return invokeL.booleanValue;
    }
}
