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
    public static final class EnumC1776a {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC1776a a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1776a f34401b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1776a f34402c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC1776a f34403d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ EnumC1776a[] f34404e;
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
            a = new EnumC1776a("FAILED", 0);
            f34401b = new EnumC1776a("AND_NEED_CHECK_NEXT", 1);
            f34402c = new EnumC1776a("OR_NEED_CHECK_NEXT", 2);
            EnumC1776a enumC1776a = new EnumC1776a(c.p, 3);
            f34403d = enumC1776a;
            f34404e = new EnumC1776a[]{a, f34401b, f34402c, enumC1776a};
        }

        public EnumC1776a(String str, int i2) {
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

        public static EnumC1776a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC1776a) Enum.valueOf(EnumC1776a.class, str) : (EnumC1776a) invokeL.objValue;
        }

        public static EnumC1776a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC1776a[]) f34404e.clone() : (EnumC1776a[]) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f34405b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34406c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34407d;

        /* renamed from: e  reason: collision with root package name */
        public int f34408e;

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
            this.f34406c = false;
            this.f34407d = false;
            this.a = null;
            this.f34405b = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65538, this, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_CLOSE_ALL)) {
                this.f34407d = true;
                this.f34406c = false;
            } else if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_ENABLE_ALL)) {
                this.f34406c = true;
                this.f34407d = false;
            } else if (!str.contains(str2)) {
                this.a = a(str, str3);
            } else {
                if (str2.endsWith("|")) {
                    str2 = "\\|";
                }
                String[] split = str.split(str2);
                if (split.length == 2) {
                    this.a = a(split[0], str3);
                    this.f34405b = c(split[1]);
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
                this.f34408e = i2;
            }
        }

        public boolean a(String str) {
            InterceptResult invokeL;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.f34406c) {
                    return true;
                }
                if (!TextUtils.isEmpty(str) && (strArr = this.a) != null) {
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!str.equals(this.a[i2]) && (this.f34408e != 0 || !a(str, this.a[i2], EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, ProxyConfig.MATCH_ALL_SCHEMES))) {
                            if (this.f34408e == 1) {
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

        public EnumC1776a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (this.f34407d) {
                    return EnumC1776a.a;
                }
                boolean a = a(str);
                return this.f34405b ? a ? EnumC1776a.f34401b : EnumC1776a.a : a ? EnumC1776a.f34403d : EnumC1776a.f34402c;
            }
            return (EnumC1776a) invokeL.objValue;
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
            EnumC1776a b2 = bVar.b(str2);
            return Boolean.valueOf((b2 == EnumC1776a.f34403d || b2 == EnumC1776a.f34401b) ? true : true);
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
