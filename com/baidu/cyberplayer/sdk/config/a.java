package com.baidu.cyberplayer.sdk.config;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.webkit.ProxyConfig;
import com.alipay.security.mobile.module.http.model.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.VideoCloudSetting;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.cyberplayer.sdk.config.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class EnumC1783a {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC1783a a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1783a f34557b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1783a f34558c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC1783a f34559d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ EnumC1783a[] f34560e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1924634642, "Lcom/baidu/cyberplayer/sdk/config/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1924634642, "Lcom/baidu/cyberplayer/sdk/config/a$a;");
                    return;
                }
            }
            a = new EnumC1783a("FAILED", 0);
            f34557b = new EnumC1783a("AND_NEED_CHECK_NEXT", 1);
            f34558c = new EnumC1783a("OR_NEED_CHECK_NEXT", 2);
            EnumC1783a enumC1783a = new EnumC1783a(c.p, 3);
            f34559d = enumC1783a;
            f34560e = new EnumC1783a[]{a, f34557b, f34558c, enumC1783a};
        }

        public EnumC1783a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EnumC1783a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC1783a) Enum.valueOf(EnumC1783a.class, str) : (EnumC1783a) invokeL.objValue;
        }

        public static EnumC1783a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC1783a[]) f34560e.clone() : (EnumC1783a[]) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f34561b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34562c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34563d;

        /* renamed from: e  reason: collision with root package name */
        public int f34564e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34562c = false;
            this.f34563d = false;
            this.a = null;
            this.f34561b = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65538, this, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_CLOSE_ALL)) {
                this.f34563d = true;
                this.f34562c = false;
            } else if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_ENABLE_ALL)) {
                this.f34562c = true;
                this.f34563d = false;
            } else if (!str.contains(str2)) {
                this.a = a(str, str3);
            } else {
                if (str2.endsWith("|")) {
                    str2 = "\\|";
                }
                String[] split = str.split(str2);
                if (split.length == 2) {
                    this.a = a(split[0], str3);
                    this.f34561b = c(split[1]);
                } else if (split.length == 1) {
                    this.a = a(split[0], str3);
                }
            }
        }

        private String[] a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (!str.contains(str2)) {
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    return new String[]{str};
                }
                String[] split = str.split(str2);
                int length = split.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (TextUtils.isEmpty(split[i2]) || split[i2].equals(".")) {
                        split[i2] = null;
                    }
                }
                return split;
            }
            return (String[]) invokeLL.objValue;
        }

        private boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) ? TextUtils.isEmpty(str) || !str.toLowerCase().equals("or") : invokeL.booleanValue;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f34564e = i2;
            }
        }

        public boolean a(String str) {
            InterceptResult invokeL;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.f34562c) {
                    return true;
                }
                if (!TextUtils.isEmpty(str) && (strArr = this.a) != null) {
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!str.equals(this.a[i2]) && (this.f34564e != 0 || !a(str, this.a[i2], EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, ProxyConfig.MATCH_ALL_SCHEMES))) {
                            if (this.f34564e == 1) {
                                if (str.contains("." + this.a[i2])) {
                                }
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean a(String str, String str2, String str3, String str4) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, str4)) == null) {
                String[] split = str.split(str3);
                String[] split2 = str2.split(str3);
                if (split.length != split2.length) {
                    return false;
                }
                int length = split.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (TextUtils.isEmpty(split[i2]) || TextUtils.isEmpty(split2[i2])) {
                        if (!TextUtils.isEmpty(split2[i2]) || !TextUtils.isEmpty(split[i2])) {
                            return false;
                        }
                    } else if (!split2[i2].equals(str4) && !split2[i2].equals(split[i2])) {
                        return false;
                    }
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        public EnumC1783a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (this.f34563d) {
                    return EnumC1783a.a;
                }
                boolean a = a(str);
                return this.f34561b ? a ? EnumC1783a.f34557b : EnumC1783a.a : a ? EnumC1783a.f34559d : EnumC1783a.f34558c;
            }
            return (EnumC1783a) invokeL.objValue;
        }
    }

    public static Boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            b bVar = new b();
            boolean z = false;
            bVar.a(0);
            bVar.a(str, "|", ";");
            EnumC1783a b2 = bVar.b(str2);
            return Boolean.valueOf((b2 == EnumC1783a.f34559d || b2 == EnumC1783a.f34557b) ? true : true);
        }
        return (Boolean) invokeLL.objValue;
    }

    public static boolean a(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, arrayList)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (str.indexOf(arrayList.get(i2)) > -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, arrayList2)) == null) ? b(Build.DEVICE, arrayList) || b(Build.MODEL, arrayList2) : invokeLL.booleanValue;
    }

    public static boolean b(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, arrayList)) == null) {
            if (!TextUtils.isEmpty(str) && arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (str.equalsIgnoreCase(arrayList.get(i2))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
