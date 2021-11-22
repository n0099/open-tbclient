package b.a.p0.e.a.h;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final SparseArray<b.a.p0.e.a.d.a> f10253a;

    /* renamed from: b  reason: collision with root package name */
    public static CpuType f10254b;

    /* renamed from: c  reason: collision with root package name */
    public static int f10255c;

    /* renamed from: d  reason: collision with root package name */
    public static b.a.p0.e.a.d.b f10256d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.e.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0531a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0531a() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(588458721, "Lb/a/p0/e/a/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(588458721, "Lb/a/p0/e/a/h/a;");
                return;
            }
        }
        f10253a = new SparseArray<>();
        f10255c = -1;
    }

    public static b.a.p0.e.a.d.a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            b.a.p0.e.a.d.a aVar = f10253a.get(i2);
            if (aVar != null) {
                return aVar;
            }
            try {
                b.a.p0.e.a.d.a aVar2 = new b.a.p0.e.a.d.a(i2, k("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_min_freq"), k("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq"));
                f10253a.put(i2, aVar2);
                return aVar2;
            } catch (Exception unused) {
                return new b.a.p0.e.a.d.a(i2, -1, -1);
            }
        }
        return (b.a.p0.e.a.d.a) invokeI.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File[] listFiles = new File("/sys/devices/system/cpu").listFiles(new C0531a());
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            int i2 = f10255c;
            if (i2 != -1) {
                return i2;
            }
            int c2 = c("/sys/devices/system/cpu/possible");
            if (c2 != -1) {
                f10255c = c2;
                return c2;
            }
            int c3 = c("/sys/devices/system/cpu/present");
            if (c3 != -1) {
                f10255c = c3;
                return c3;
            }
            int b2 = b();
            if (b2 == -1) {
                b2 = Math.max(Runtime.getRuntime().availableProcessors(), 1);
            }
            f10255c = b2;
            return b2;
        }
        return invokeV.intValue;
    }

    public static b.a.p0.e.a.d.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            b.a.p0.e.a.d.b bVar = f10256d;
            if (bVar != null) {
                return bVar;
            }
            int e2 = e();
            if (e2 <= 0) {
                return new b.a.p0.e.a.d.b();
            }
            if (e2 == 1) {
                b.a.p0.e.a.d.b bVar2 = new b.a.p0.e.a.d.b();
                bVar2.f10222h = false;
                bVar2.f10215a = e2;
                bVar2.l = a(0);
                f10256d = bVar2;
                return bVar2;
            }
            ArrayList<b.a.p0.e.a.d.a> arrayList = new ArrayList(e2);
            for (int i2 = 0; i2 < e2; i2++) {
                arrayList.add(a(i2));
            }
            SparseArray sparseArray = new SparseArray();
            SparseIntArray sparseIntArray = new SparseIntArray();
            ArrayList arrayList2 = new ArrayList();
            for (b.a.p0.e.a.d.a aVar : arrayList) {
                int i3 = aVar.f10214g;
                if (sparseArray.get(i3) != null) {
                    sparseIntArray.put(i3, sparseIntArray.get(i3) + 1);
                } else {
                    sparseArray.put(i3, aVar);
                    arrayList2.add(aVar);
                    sparseIntArray.put(i3, 1);
                }
            }
            Collections.sort(arrayList2);
            b.a.p0.e.a.d.b bVar3 = new b.a.p0.e.a.d.b();
            bVar3.f10215a = e2;
            boolean z = arrayList2.size() > 1;
            bVar3.f10222h = z;
            if (!z) {
                bVar3.l = (b.a.p0.e.a.d.a) (arrayList2.size() <= 0 ? arrayList.get(0) : arrayList2.get(0));
                f10256d = bVar3;
                return bVar3;
            }
            bVar3.j = (b.a.p0.e.a.d.a) arrayList2.get(0);
            bVar3.f10217c = ((b.a.p0.e.a.d.a) arrayList2.get(0)).f10212e;
            bVar3.f10216b = sparseIntArray.get(bVar3.j.f10214g);
            bVar3.f10223i = (b.a.p0.e.a.d.a) arrayList2.get(1);
            bVar3.f10219e = ((b.a.p0.e.a.d.a) arrayList2.get(1)).f10212e;
            bVar3.f10218d = sparseIntArray.get(bVar3.f10223i.f10214g);
            if (arrayList2.size() > 2) {
                bVar3.k = (b.a.p0.e.a.d.a) arrayList2.get(2);
                bVar3.f10221g = ((b.a.p0.e.a.d.a) arrayList2.get(2)).f10212e;
                bVar3.f10220f = sparseIntArray.get(bVar3.k.f10214g);
            }
            f10256d = bVar3;
            return bVar3;
        }
        return (b.a.p0.e.a.d.b) invokeV.objValue;
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
            CpuType cpuType = f10254b;
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
                f10254b = cpuType;
                return cpuType;
            }
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith("kirin") && !lowerCase.startsWith("hi")) {
                if (!lowerCase.startsWith("qcom") && !lowerCase.startsWith("kona") && !lowerCase.startsWith("lahaina") && !lowerCase.startsWith("msm") && !lowerCase.startsWith("sdm") && !lowerCase.startsWith("apq") && !lowerCase.startsWith("sm")) {
                    if (lowerCase.startsWith("mt")) {
                        CpuType cpuType2 = CpuType.Mtk;
                        f10254b = cpuType2;
                        return cpuType2;
                    }
                    CpuType cpuType3 = CpuType.Unknown;
                    f10254b = cpuType3;
                    return cpuType3;
                }
                CpuType cpuType4 = CpuType.QualComm;
                f10254b = cpuType4;
                return cpuType4;
            }
            CpuType cpuType5 = CpuType.Hisilicon;
            f10254b = cpuType5;
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
