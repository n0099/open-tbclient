package b.a.p0.a.m1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.o2.g.h;
import b.a.p0.q.i.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7032a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? file.isDirectory() && TextUtils.isDigitsOnly(file.getName()) : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1768493784, "Lb/a/p0/a/m1/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1768493784, "Lb/a/p0/a/m1/d/c;");
                return;
            }
        }
        f7032a = k.f6863a;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(b.a.p0.a.a1.d.g(), str);
        if (file.exists()) {
            if (f7032a) {
                String str2 = "clear all pkg info's ext ,appId - " + str;
            }
            File[] listFiles = file.listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                b(str, file2.getName());
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            String e2 = e(str, str2);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            h.a().edit().remove(e2).apply();
            if (f7032a) {
                String str3 = "clear pkg info's ext , appId - " + str + ", version code - " + str2;
            }
        }
    }

    public static String c(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pMSAppInfo)) == null) ? d(pMSAppInfo.appId, pMSAppInfo.versionCode) : (String) invokeL.objValue;
    }

    public static String d(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j)) == null) ? e(str, String.valueOf(j)) : (String) invokeLJ.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return str + "_" + str2 + "_pkg_info_ext";
            } else if (f7032a) {
                String str3 = "#getExtKey appId=" + str + " version=" + str2;
                return null;
            } else {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String f(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                return "";
            }
            String c2 = c(pMSAppInfo);
            if (TextUtils.isEmpty(c2)) {
                return "";
            }
            String string = h.a().getString(c2, "");
            if (f7032a) {
                String str = "appId - " + pMSAppInfo.appId + ", get pkg info' ext - " + string;
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public static void g(String str, JSONObject jSONObject, g gVar, List<b.a.p0.q.i.h> list) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, str, jSONObject, gVar, list) == null) {
            if (jSONObject == null) {
                boolean z = f7032a;
            } else if (gVar == null && list == null) {
                boolean z2 = f7032a;
            } else {
                String str2 = null;
                if (gVar != null) {
                    str = gVar.f11774g;
                    j = gVar.f11776i;
                    str2 = gVar.p;
                } else if (list.size() > 0) {
                    b.a.p0.q.i.h hVar = list.get(0);
                    j = hVar.f11776i;
                    str2 = hVar.s;
                } else {
                    j = -1;
                }
                if (str2 == null) {
                    boolean z3 = f7032a;
                } else if (!TextUtils.isEmpty(str) && j != -1) {
                    h.a().edit().putString(d(str, j), str2).apply();
                } else {
                    boolean z4 = f7032a;
                }
            }
        }
    }
}
