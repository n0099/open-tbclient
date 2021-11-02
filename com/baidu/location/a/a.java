package com.baidu.location.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements LBSAuthManagerListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f38921a;

    /* renamed from: b  reason: collision with root package name */
    public static a f38922b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f38923c;

    /* renamed from: d  reason: collision with root package name */
    public Context f38924d;

    /* renamed from: e  reason: collision with root package name */
    public long f38925e;

    /* renamed from: f  reason: collision with root package name */
    public String f38926f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037693492, "Lcom/baidu/location/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037693492, "Lcom/baidu/location/a/a;");
                return;
            }
        }
        f38921a = new Object();
    }

    public a() {
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
        this.f38923c = 0;
        this.f38924d = null;
        this.f38925e = 0L;
        this.f38926f = null;
    }

    public static a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (f38921a) {
                if (f38922b == null) {
                    f38922b = new a();
                }
                aVar = f38922b;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return LBSAuthManager.getInstance(context).getPublicKey(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                return LBSAuthManager.getInstance(context).getMCode();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f38924d = context;
            LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
            this.f38925e = System.currentTimeMillis();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f38923c;
            boolean z = i2 == 0 || i2 == 602 || i2 == 601 || i2 == -10 || i2 == -11;
            if (this.f38924d != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.f38925e;
                if (!z ? currentTimeMillis < 0 || currentTimeMillis > 10000 : currentTimeMillis > 86400000) {
                    LBSAuthManager.getInstance(this.f38924d).authenticate(false, "lbs_locsdk", null, this);
                    this.f38925e = System.currentTimeMillis();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            this.f38923c = i2;
            if (i2 == 0) {
                String str2 = com.baidu.location.e.a.f39163a;
            } else {
                String str3 = com.baidu.location.e.a.f39163a;
                String str4 = "LocationAuthManager Authentication Error errorcode = " + i2 + " , msg = " + str;
            }
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getString("token") != null) {
                        this.f38926f = jSONObject.getString("token");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
