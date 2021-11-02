package com.baidu.ar.arplay.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.arplay.c.e;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public static boolean fQ;
    public static e.a fR;
    public static ArrayList<a> fS;
    public static volatile BroadcastReceiver fT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1109084131, "Lcom/baidu/ar/arplay/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1109084131, "Lcom/baidu/ar/arplay/c/d;");
                return;
            }
        }
        TAG = d.class.getSimpleName();
        fQ = false;
        fS = new ArrayList<>();
    }

    public d() {
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

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            if (fS == null) {
                fS = new ArrayList<>();
            }
            fS.add(aVar);
        }
    }

    public static void b(a aVar) {
        ArrayList<a> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, aVar) == null) && (arrayList = fS) != null && arrayList.contains(aVar)) {
            fS.remove(aVar);
        }
    }

    public static BroadcastReceiver bj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (fT == null) {
                synchronized (d.class) {
                    if (fT == null) {
                        fT = new d();
                    }
                }
            }
            return fT;
        }
        return (BroadcastReceiver) invokeV.objValue;
    }

    public static boolean bk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? fQ : invokeV.booleanValue;
    }

    private void bl() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || fS.isEmpty()) {
            return;
        }
        int size = fS.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = fS.get(i2);
            if (aVar != null) {
                if (bk()) {
                    aVar.a(fR);
                } else {
                    aVar.aM();
                }
            }
        }
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.getApplicationContext().registerReceiver(bj(), intentFilter);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
            return;
        }
        fT = this;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) || "com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction())) {
            if (e.f(context)) {
                fQ = true;
                fR = e.g(context);
            } else {
                fQ = false;
            }
            bl();
        }
    }
}
