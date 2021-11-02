package b.a.e.e.n;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, aVar) == null) && d() && aVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", aVar.h());
                uBCManager.onEvent("3102", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, aVar) == null) && d() && aVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", aVar.h());
                uBCManager.onEvent("3052", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, aVar) == null) && d() && aVar != null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", aVar.h());
                uBCManager.onEvent("3103", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.isOn() : invokeV.booleanValue;
    }

    public static void e(b.a.e.e.n.j.a aVar, a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, aVar2) == null) {
            if (aVar instanceof b.a.e.e.n.o.c) {
                c(aVar2);
            } else if (aVar instanceof b.a.e.e.n.o.b) {
                b(aVar2);
            } else if (aVar instanceof b.a.e.e.n.o.a) {
                a(aVar2);
            }
        }
    }
}
