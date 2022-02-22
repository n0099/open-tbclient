package c.a.s0.e.a.h;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.cpu.booster.utils.CpuType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<c.a.s0.e.a.d.a> a;

    /* renamed from: b  reason: collision with root package name */
    public static CpuType f10572b;

    /* renamed from: c  reason: collision with root package name */
    public static int f10573c;

    /* renamed from: d  reason: collision with root package name */
    public static c.a.s0.e.a.d.b f10574d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.s0.e.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0700a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0700a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                String name = file.getName();
                if (name.startsWith("cpu")) {
                    int length = name.length();
                    for (int i2 = 3; i2 < length; i2++) {
                        if (!Character.isDigit(name.charAt(i2))) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1000123749, "Lc/a/s0/e/a/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1000123749, "Lc/a/s0/e/a/h/a;");
                return;
            }
        }
        a = new SparseArray<>();
        f10573c = -1;
    }

    public static c.a.s0.e.a.d.a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            c.a.s0.e.a.d.a aVar = a.get(i2);
            if (aVar != null) {
                return aVar;
            }
            try {
                c.a.s0.e.a.d.a aVar2 = new c.a.s0.e.a.d.a(i2, k("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_min_freq"), k("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq"));
                a.put(i2, aVar2);
                return aVar2;
            } catch (Exception unused) {
                return new c.a.s0.e.a.d.a(i2, -1, -1);
            }
        }
        return (c.a.s0.e.a.d.a) invokeI.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File[] listFiles = new File("/sys/devices/system/cpu").listFiles(new C0700a());
            if (listFiles == null || listFiles.length <= 0) {
                return -1;
            }
            return listFiles.length;
        }
        return invokeV.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                int d2 = d(readLine);
                fileInputStream.close();
                return d2;
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            int indexOf = str.indexOf(45);
            if (indexOf == -1) {
                if (TextUtils.isDigitsOnly(str)) {
                    return m(str) + 1;
                }
                return -1;
            }
            int m = m(str.substring(indexOf + 1));
            if (m != -1) {
                return m + 1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            int i2 = f10573c;
            if (i2 != -1) {
                return i2;
            }
            int c2 = c("/sys/devices/system/cpu/possible");
            if (c2 != -1) {
                f10573c = c2;
                return c2;
            }
            int c3 = c("/sys/devices/system/cpu/present");
            if (c3 != -1) {
                f10573c = c3;
                return c3;
            }
            int b2 = b();
            if (b2 == -1) {
                b2 = Math.max(Runtime.getRuntime().availableProcessors(), 1);
            }
            f10573c = b2;
            return b2;
        }
        return invokeV.intValue;
    }

    public static c.a.s0.e.a.d.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            c.a.s0.e.a.d.b bVar = f10574d;
            if (bVar != null) {
                return bVar;
            }
            int e2 = e();
            if (e2 <= 0) {
                return new c.a.s0.e.a.d.b();
            }
            if (e2 == 1) {
                c.a.s0.e.a.d.b bVar2 = new c.a.s0.e.a.d.b();
                bVar2.f10546h = false;
                bVar2.a = e2;
                bVar2.l = a(0);
                f10574d = bVar2;
                return bVar2;
            }
            ArrayList<c.a.s0.e.a.d.a> arrayList = new ArrayList(e2);
            for (int i2 = 0; i2 < e2; i2++) {
                arrayList.add(a(i2));
            }
            SparseArray sparseArray = new SparseArray();
            SparseIntArray sparseIntArray = new SparseIntArray();
            ArrayList arrayList2 = new ArrayList();
            for (c.a.s0.e.a.d.a aVar : arrayList) {
                int i3 = aVar.f10539g;
                if (sparseArray.get(i3) != null) {
                    sparseIntArray.put(i3, sparseIntArray.get(i3) + 1);
                } else {
                    sparseArray.put(i3, aVar);
                    arrayList2.add(aVar);
                    sparseIntArray.put(i3, 1);
                }
            }
            Collections.sort(arrayList2);
            c.a.s0.e.a.d.b bVar3 = new c.a.s0.e.a.d.b();
            bVar3.a = e2;
            boolean z = arrayList2.size() > 1;
            bVar3.f10546h = z;
            if (!z) {
                bVar3.l = (c.a.s0.e.a.d.a) (arrayList2.size() <= 0 ? arrayList.get(0) : arrayList2.get(0));
                f10574d = bVar3;
                return bVar3;
            }
            bVar3.f10548j = (c.a.s0.e.a.d.a) arrayList2.get(0);
            bVar3.f10541c = ((c.a.s0.e.a.d.a) arrayList2.get(0)).f10537e;
            bVar3.f10540b = sparseIntArray.get(bVar3.f10548j.f10539g);
            bVar3.f10547i = (c.a.s0.e.a.d.a) arrayList2.get(1);
            bVar3.f10543e = ((c.a.s0.e.a.d.a) arrayList2.get(1)).f10537e;
            bVar3.f10542d = sparseIntArray.get(bVar3.f10547i.f10539g);
            if (arrayList2.size() > 2) {
                bVar3.k = (c.a.s0.e.a.d.a) arrayList2.get(2);
                bVar3.f10545g = ((c.a.s0.e.a.d.a) arrayList2.get(2)).f10537e;
                bVar3.f10544f = sparseIntArray.get(bVar3.k.f10539g);
            }
            f10574d = bVar3;
            return bVar3;
        }
        return (c.a.s0.e.a.d.b) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String a2 = c.a("ro.board.platform");
            if (TextUtils.isEmpty(a2)) {
                a2 = Build.HARDWARE;
            }
            return a2 != null ? a2.trim() : a2;
        }
        return (String) invokeV.objValue;
    }

    public static CpuType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            CpuType cpuType = f10572b;
            return cpuType != null ? cpuType : i(g());
        }
        return (CpuType) invokeV.objValue;
    }

    public static CpuType i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                CpuType cpuType = CpuType.Unknown;
                f10572b = cpuType;
                return cpuType;
            }
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith("kirin") && !lowerCase.startsWith("hi")) {
                if (!lowerCase.startsWith("qcom") && !lowerCase.startsWith("kona") && !lowerCase.startsWith("lahaina") && !lowerCase.startsWith("msm") && !lowerCase.startsWith("sdm") && !lowerCase.startsWith("apq") && !lowerCase.startsWith("sm")) {
                    if (lowerCase.startsWith("mt")) {
                        CpuType cpuType2 = CpuType.Mtk;
                        f10572b = cpuType2;
                        return cpuType2;
                    }
                    CpuType cpuType3 = CpuType.Unknown;
                    f10572b = cpuType3;
                    return cpuType3;
                }
                CpuType cpuType4 = CpuType.QualComm;
                f10572b = cpuType4;
                return cpuType4;
            }
            CpuType cpuType5 = CpuType.Hisilicon;
            f10572b = cpuType5;
            return cpuType5;
        }
        return (CpuType) invokeL.objValue;
    }

    public static int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            return k("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/scaling_cur_freq");
        }
        return invokeI.intValue;
    }

    public static int k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    return m(l(readLine));
                } catch (Exception unused) {
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            int i2 = 0;
            while (i2 < length && Character.isDigit(str.charAt(i2))) {
                i2++;
            }
            return str.substring(0, i2);
        }
        return (String) invokeL.objValue;
    }

    public static int m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }
}
