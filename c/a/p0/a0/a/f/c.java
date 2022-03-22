package c.a.p0.a0.a.f;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f11902b;

    /* renamed from: c  reason: collision with root package name */
    public String f11903c;

    /* renamed from: d  reason: collision with root package name */
    public String f11904d;

    /* renamed from: e  reason: collision with root package name */
    public String f11905e;

    /* renamed from: f  reason: collision with root package name */
    public String f11906f;

    /* renamed from: g  reason: collision with root package name */
    public String f11907g;

    /* renamed from: h  reason: collision with root package name */
    public String f11908h;
    public String i;
    public String j;
    public String k;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(22675112, "Lc/a/p0/a0/a/f/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(22675112, "Lc/a/p0/a0/a/f/c$b;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (c) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.j == null) {
                try {
                    this.j = TbadkCoreApplication.getInst().getAndroidId();
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return "";
                }
            }
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return SapiAccountManager.getInstance().getSession() != null ? SapiAccountManager.getInstance().getSession().uid : "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a == null) {
                try {
                    this.a = TbConfig.getVersion();
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return "";
                }
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f11903c == null) {
                try {
                    this.f11903c = TbadkCoreApplication.getInst().getCuidGalaxy2();
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return "";
                }
            }
            return this.f11903c;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.k == null) {
                this.k = "com.baidu.tieba.fileprovider";
            }
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f11906f == null) {
                try {
                    this.f11906f = TbadkCoreApplication.getInst().getImei();
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return "";
                }
            }
            return this.f11906f;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f11908h == null) {
                try {
                    this.f11908h = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return "";
                }
            }
            return this.f11908h;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f11905e == null) {
                this.f11905e = Build.MODEL;
            }
            return this.f11905e;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f11907g == null) {
                try {
                    this.f11907g = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return "";
                }
            }
            return this.f11907g;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f11902b == null) {
                this.f11902b = Build.VERSION.RELEASE;
            }
            return this.f11902b;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.i == null) {
                try {
                    this.i = BdBaseApplication.getInst().getPackageName();
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return "";
                }
            }
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f11904d == null) {
                try {
                    this.f11904d = r();
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return "";
                }
            }
            return this.f11904d;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String sampleId = TbSingleton.getInstance().getSampleId();
            return sampleId == null ? "" : sampleId.replace(SignatureImpl.SEP, ',');
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TbadkCoreApplication.getCurrentAccount() : (String) invokeV.objValue;
    }

    @NonNull
    public final String q() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                sb = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                int length = property.length();
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    } else {
                        sb2.append(charAt);
                    }
                }
                sb = sb2.toString();
            }
            String str = Build.VERSION.RELEASE;
            String replace = TextUtils.isEmpty(str) ? "0.0" : str.replace("_", "-");
            return sb + " baiduboxapp/" + TbConfig.getVersion() + " (Baidu; P1 " + replace + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            DisplayMetrics displayMetrics = TbadkCoreApplication.getInst().getResources().getDisplayMetrics();
            int i = 0;
            String[] strArr = {String.valueOf(displayMetrics.widthPixels), String.valueOf(displayMetrics.heightPixels), "android", TbConfig.getVersion(), String.valueOf(displayMetrics.densityDpi)};
            StringBuilder sb = new StringBuilder();
            String str = "";
            while (i < 5) {
                String str2 = strArr[i];
                sb.append(str);
                sb.append(str2);
                i++;
                str = "_";
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.a = TbConfig.getVersion();
            this.f11902b = Build.VERSION.RELEASE;
            this.f11903c = TbadkCoreApplication.getInst().getCuidGalaxy2();
            q();
            this.f11904d = r();
            this.f11905e = Build.MODEL;
            this.f11906f = TbadkCoreApplication.getInst().getImei();
            this.f11907g = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            this.f11908h = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            this.i = BdBaseApplication.getInst().getPackageName();
            this.j = TbadkCoreApplication.getInst().getAndroidId();
            this.k = "com.baidu.tieba.fileprovider";
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
