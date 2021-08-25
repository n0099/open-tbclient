package com.baidu.location.e;

import android.content.Context;
import android.os.Build;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static String f41136e;

    /* renamed from: f  reason: collision with root package name */
    public static String f41137f;

    /* renamed from: g  reason: collision with root package name */
    public static String f41138g;

    /* renamed from: h  reason: collision with root package name */
    public static String f41139h;

    /* renamed from: i  reason: collision with root package name */
    public static int f41140i;

    /* renamed from: j  reason: collision with root package name */
    public static b f41141j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f41142a;

    /* renamed from: b  reason: collision with root package name */
    public String f41143b;

    /* renamed from: c  reason: collision with root package name */
    public String f41144c;

    /* renamed from: d  reason: collision with root package name */
    public String f41145d;
    public boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037812687, "Lcom/baidu/location/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037812687, "Lcom/baidu/location/e/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41142a = null;
        this.f41143b = null;
        this.f41144c = null;
        this.f41145d = null;
        this.k = false;
        if (com.baidu.location.f.getServiceContext() != null) {
            a(com.baidu.location.f.getServiceContext());
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f41141j == null) {
                f41141j = new b();
            }
            return f41141j;
        }
        return (b) invokeV.objValue;
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? a(z, (String) null) : (String) invokeZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(boolean z, String str) {
        InterceptResult invokeZL;
        String c2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("&sdk=");
            stringBuffer.append(7.93f);
            if (z) {
                if (k.f41187g.equals("all")) {
                    stringBuffer.append("&addr=allj");
                }
                if (k.f41189i) {
                    stringBuffer.append("&adtp=n2");
                }
                if (k.f41188h || k.k || k.l || k.f41190j) {
                    stringBuffer.append("&sema=");
                    if (k.f41188h) {
                        stringBuffer.append("aptag|");
                    }
                    if (k.f41190j) {
                        stringBuffer.append("aptagd|");
                    }
                    if (k.k) {
                        stringBuffer.append("poiregion|");
                    }
                    if (k.l) {
                        stringBuffer.append("regular");
                    }
                }
            }
            if (z) {
                if (str == null) {
                    str = "&coor=gcj02";
                } else {
                    stringBuffer.append("&coor=");
                }
                stringBuffer.append(str);
                String j2 = com.baidu.location.c.e.j();
                if (j2 != null) {
                    stringBuffer.append(j2);
                }
            }
            if (this.f41144c != null) {
                stringBuffer.append("&cu=");
                stringBuffer.append(this.f41144c);
                String str3 = this.f41142a;
                str2 = (str3 == null || str3.equals("NULL") || this.f41144c.contains(new StringBuffer(this.f41142a).reverse().toString())) ? "&Aim=" : "&Aim=";
                if (this.f41143b != null) {
                    stringBuffer.append("&snd=");
                    stringBuffer.append(this.f41143b);
                }
                if (this.f41145d != null) {
                    stringBuffer.append("&Aid=");
                    stringBuffer.append(this.f41145d);
                }
                stringBuffer.append("&fw=");
                stringBuffer.append(com.baidu.location.f.getFrameVersion());
                stringBuffer.append("&lt=1");
                stringBuffer.append("&mb=");
                stringBuffer.append(Build.MODEL);
                c2 = k.c();
                if (c2 != null) {
                    stringBuffer.append("&laip=");
                    stringBuffer.append(c2);
                }
                stringBuffer.append("&resid=");
                stringBuffer.append("12");
                stringBuffer.append("&os=A");
                stringBuffer.append(Build.VERSION.SDK_INT);
                if (z) {
                    stringBuffer.append("&sv=");
                    String str4 = Build.VERSION.RELEASE;
                    if (str4 != null && str4.length() > 6) {
                        str4 = str4.substring(0, 6);
                    }
                    stringBuffer.append(str4);
                }
                return stringBuffer.toString();
            }
            str2 = "&im=";
            stringBuffer.append(str2);
            stringBuffer.append(this.f41142a);
            if (this.f41143b != null) {
            }
            if (this.f41145d != null) {
            }
            stringBuffer.append("&fw=");
            stringBuffer.append(com.baidu.location.f.getFrameVersion());
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            c2 = k.c();
            if (c2 != null) {
            }
            stringBuffer.append("&resid=");
            stringBuffer.append("12");
            stringBuffer.append("&os=A");
            stringBuffer.append(Build.VERSION.SDK_INT);
            if (z) {
            }
            return stringBuffer.toString();
        }
        return (String) invokeZL.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) || context == null || this.k) {
            return;
        }
        try {
            this.f41144c = CommonParam.getCUID(context);
        } catch (Exception unused) {
            this.f41144c = null;
        }
        try {
            f41136e = context.getPackageName();
        } catch (Exception unused2) {
            f41136e = null;
        }
        k.o = "" + this.f41144c;
        this.k = true;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            f41137f = str;
            f41136e = str2;
        }
    }
}
