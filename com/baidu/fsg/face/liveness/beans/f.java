package com.baidu.fsg.face.liveness.beans;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "https://passport.baidu.com";

    /* renamed from: b  reason: collision with root package name */
    public static String f34255b = "https://passport.qatest.baidu.com";

    /* renamed from: c  reason: collision with root package name */
    public static String f34256c = "http://passport.rdtest.baidu.com";

    /* renamed from: d  reason: collision with root package name */
    public static String f34257d = "http://wappass.baidu.com";

    /* renamed from: e  reason: collision with root package name */
    public static String f34258e = "http://wappass.qatest.baidu.com";

    /* renamed from: f  reason: collision with root package name */
    public static String f34259f = "http://wappass.rdtest.baidu.com";

    /* renamed from: g  reason: collision with root package name */
    public static String f34260g = "https://gss0.bdstatic.com";

    /* renamed from: h  reason: collision with root package name */
    public static String f34261h = "https://passport.baidu.com";

    /* renamed from: i  reason: collision with root package name */
    public static String f34262i = "https://passport.qatest.baidu.com";

    /* renamed from: j  reason: collision with root package name */
    public static String f34263j = "https://voiceprint.baidu.com/echo.fcgi";
    public static String k = "https://voiceprint.baidu.com/echo.fcgi";
    public static String l = "/6bMWfDe8BsgCpNKfpU_Y_D3/static/appsapi/appdistribute/android.txt";
    public static String m = "/risk/living/authfacematch";
    public static String n = "/risk/living/facedetect";
    public static String o = "/risk/living/authuploadvideocert";
    public static String p = "/risk/living/confirm";
    public static String q = "/risk/living/asyncgetportrait";
    public static String r = "/risk/living/authgetquestion";
    public static String s = "/risk/living/authqueryvideoreview";
    public static String t = "/risk/living/authqueryvideoreview";
    public static String u = "/risk/living/sdk/getportrait";
    public static String v = "/risk/living/sdk/faceMatch";
    public static String w = "/risk/living/sdk/AudioVideoUpload";
    public static String x = "/risk/living/info";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1577364098, "Lcom/baidu/fsg/face/liveness/beans/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1577364098, "Lcom/baidu/fsg/face/liveness/beans/f;");
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
