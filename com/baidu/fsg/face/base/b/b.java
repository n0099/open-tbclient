package com.baidu.fsg.face.base.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.base.d.h;
import com.baidu.fsg.face.base.d.i;
import com.baidu.idl.license.License;
import com.baidu.pass.main.facesdk.FaceAuth;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 100;

    /* renamed from: c  reason: collision with root package name */
    public static final String f34012c = ".BD_SAPI_CACHE";

    /* renamed from: d  reason: collision with root package name */
    public static final String f34013d = "so_zips";

    /* renamed from: e  reason: collision with root package name */
    public static final String f34014e = "1.0.1";

    /* renamed from: f  reason: collision with root package name */
    public static final String f34015f = "1.0.3";

    /* renamed from: g  reason: collision with root package name */
    public static final String f34016g = "FaceSDKLibs";

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f34017h;

    /* renamed from: i  reason: collision with root package name */
    public static b f34018i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f34019b;

    /* renamed from: j  reason: collision with root package name */
    public SharedPreferences f34020j;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f34021b;

        /* renamed from: c  reason: collision with root package name */
        public String f34022c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f34023d;

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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-365335243, "Lcom/baidu/fsg/face/base/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-365335243, "Lcom/baidu/fsg/face/base/b/b;");
                return;
            }
        }
        f34017h = new String[]{License.LICENSE_ASSETS_FILE, FaceAuth.TAG};
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34020j = context.getApplicationContext().getSharedPreferences("rim_liveness_base_system_v1", 0);
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Context applicationContext = context.getApplicationContext();
            if (f34018i == null) {
                f34018i = new b(applicationContext);
            }
            return f34018i;
        }
        return (b) invokeL.objValue;
    }

    public static String b(Context context, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, aVar)) == null) {
            String a2 = a(context, aVar);
            return new File(a2 + File.separator).getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Context context, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, aVar)) == null) {
            String a2 = a(context, aVar);
            return new File(a2 + File.separator + aVar.a + File.separator + aVar.a + "-" + aVar.f34021b + ".zip").getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    private String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            if (TextUtils.isEmpty(this.f34019b)) {
                try {
                    this.f34019b = MD5Util.toMd5((context.getPackageName() + h.a(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
                } catch (UnsupportedEncodingException e2) {
                    com.baidu.fsg.face.base.d.d.a(e2);
                }
            }
            return this.f34019b;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, aVar)) == null) ? context.getDir(aVar.f34022c, 0).getAbsolutePath() : (String) invokeLL.objValue;
    }

    public static String a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aVar)) == null) {
            return ShareStorage.SP_FILE_PATH + aVar.a + "/" + aVar.a + "-" + aVar.f34021b + ".zip";
        }
        return (String) invokeL.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) ? this.f34020j.getString(str, "") : (String) invokeL.objValue;
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            if (Build.VERSION.SDK_INT > 8) {
                this.f34020j.edit().putString(str, str2).apply();
            } else {
                this.f34020j.edit().putString(str, str2).commit();
            }
        }
    }

    public void a(Context context, String str, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, cVar) == null) || cVar == null) {
            return;
        }
        a(str, i.c(cVar.a().toString(), b(context)));
    }

    public c a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            String a2 = a(str);
            if (!TextUtils.isEmpty(a2)) {
                String b2 = i.b(a2, b(context));
                if (!TextUtils.isEmpty(b2)) {
                    try {
                        return c.a(new JSONObject(b2));
                    } catch (JSONException e2) {
                        com.baidu.fsg.face.base.d.d.a(e2);
                    }
                }
            }
            return new c();
        }
        return (c) invokeLL.objValue;
    }

    public static a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            a aVar = new a();
            if (i2 == 4) {
                aVar.a = f34013d;
                aVar.f34021b = "1.0.3";
                aVar.f34022c = f34016g;
                aVar.f34023d = f34017h;
                return aVar;
            }
            throw new IllegalArgumentException("the so modle type = " + i2 + " is not support");
        }
        return (a) invokeI.objValue;
    }
}
