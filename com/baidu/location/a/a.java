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

    /* renamed from: a  reason: collision with root package name */
    public static Object f6541a;

    /* renamed from: b  reason: collision with root package name */
    public static a f6542b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f6543c;

    /* renamed from: d  reason: collision with root package name */
    public Context f6544d;

    /* renamed from: e  reason: collision with root package name */
    public long f6545e;

    /* renamed from: f  reason: collision with root package name */
    public String f6546f;

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
        f6541a = new Object();
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
        this.f6543c = 0;
        this.f6544d = null;
        this.f6545e = 0L;
        this.f6546f = null;
    }

    public static a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (f6541a) {
                if (f6542b == null) {
                    f6542b = new a();
                }
                aVar = f6542b;
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
            this.f6544d = context;
            LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
            this.f6545e = System.currentTimeMillis();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f6543c;
            boolean z = i2 == 0 || i2 == 602 || i2 == 601 || i2 == -10 || i2 == -11;
            if (this.f6544d != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.f6545e;
                if (!z ? currentTimeMillis < 0 || currentTimeMillis > 10000 : currentTimeMillis > 86400000) {
                    LBSAuthManager.getInstance(this.f6544d).authenticate(false, "lbs_locsdk", null, this);
                    this.f6545e = System.currentTimeMillis();
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
            this.f6543c = i2;
            if (i2 == 0) {
                Log.i(com.baidu.location.e.a.f6783a, "LocationAuthManager Authentication AUTHENTICATE_SUCC");
            } else {
                String str2 = com.baidu.location.e.a.f6783a;
                Log.i(str2, "LocationAuthManager Authentication Error errorcode = " + i2 + " , msg = " + str);
            }
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getString("token") != null) {
                        this.f6546f = jSONObject.getString("token");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
