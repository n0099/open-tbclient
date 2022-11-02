package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
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
/* loaded from: classes2.dex */
public class a implements LBSAuthManagerListener {
    public static /* synthetic */ Interceptable $ic;
    public static Object b;
    public static a c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int d;
    public Context e;
    public long f;
    public String g;

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
        b = new Object();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.e = null;
        this.f = 0L;
        this.g = null;
        this.a = 0;
    }

    public static a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (b) {
                if (c == null) {
                    c = new a();
                }
                aVar = c;
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
            } catch (Exception e) {
                e.printStackTrace();
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
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.e = context;
            LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
            this.f = System.currentTimeMillis();
        }
    }

    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            LBSAuthManager.getInstance(context).setKey(str);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.d;
            boolean z = i == 0 || i == 602 || i == 601 || i == -10 || i == -11;
            if (this.e != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.f;
                if (!z ? currentTimeMillis < 0 || currentTimeMillis > 10000 : currentTimeMillis > 86400000) {
                    LBSAuthManager.getInstance(this.e).authenticate(false, "lbs_locsdk", null, this);
                    this.f = System.currentTimeMillis();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            this.d = i;
            if (i == 0) {
                str2 = "LocationAuthManager Authentication AUTHENTICATE_SUCC";
            } else {
                str2 = "LocationAuthManager Authentication Error errorcode = " + i + " , msg = " + str;
            }
            Log.i("baidu_location_service", str2);
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("token") && jSONObject.getString("token") != null) {
                        this.g = jSONObject.getString("token");
                    }
                    if (!jSONObject.has("ak_permission") || jSONObject.getInt("ak_permission") == 0) {
                        return;
                    }
                    this.a = jSONObject.getInt("ak_permission");
                    Log.i("baidu_location_service", "LocationAuthManager ak_permission = " + this.a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
