package c.a.w0;

import androidx.core.view.InputDeviceCompat;
import c.a.v0.j;
import c.a.v0.m;
import c.a.v0.w;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, Flow> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1353675658, "Lc/a/w0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1353675658, "Lc/a/w0/a;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            a.put(str, ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(str));
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            Flow flow = a.get(str);
            if (flow != null) {
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).flowCancel(flow);
                a.remove(str);
                return;
            }
            String str2 = "cancelFlow:" + str + "对应flow为空";
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            Flow flow = a.get(str);
            if (flow != null) {
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).flowEnd(flow);
                a.remove(str);
                return;
            }
            String str2 = "endFlow:" + str + "对应flow为空";
        }
    }

    public static void d(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hashMap) == null) {
            String str = (String) hashMap.get("flowId");
            String str2 = (String) hashMap.get(TbEnum.SystemMessage.KEY_EVENT_ID);
            String str3 = (String) hashMap.get("eventContent");
            Flow flow = a.get(str);
            if (flow != null) {
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (str3 == null) {
                    uBCManager.flowAddEvent(flow, str2);
                    return;
                } else {
                    uBCManager.flowAddEvent(flow, str2, str3);
                    return;
                }
            }
            String str4 = "flowAddEvent:" + str + "对应flow为空";
        }
    }

    public static void e(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, hashMap) == null) {
            String str = (String) hashMap.get("flowId");
            String str2 = (String) hashMap.get(TbEnum.SystemMessage.KEY_EVENT_ID);
            String str3 = (String) hashMap.get("eventContent");
            long longValue = ((Long) hashMap.get("eventDate")).longValue();
            Flow flow = a.get(str);
            if (flow != null) {
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).flowAddEventWithDate(flow, str2, str3, longValue);
                return;
            }
            String str4 = "flowAddEventWithDate:" + str + "对应flow为空";
        }
    }

    public static void f(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, hashMap) == null) {
            String str = (String) hashMap.get("flowId");
            String str2 = (String) hashMap.get("category");
            Flow flow = a.get(str);
            if (flow != null) {
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).flowEndSlot(flow, str2);
                return;
            }
            String str3 = "flowEndSlot:" + str + "对应flow为空";
        }
    }

    public static void g(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, hashMap) == null) {
            String str = (String) hashMap.get("flowId");
            String str2 = (String) hashMap.get("flowContent");
            Flow flow = a.get(str);
            if (flow != null) {
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).flowSetValue(flow, str2);
                return;
            }
            String str3 = "flowSetValue:" + str + "对应flow为空";
        }
    }

    public static void h(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, hashMap) == null) {
            String str = (String) hashMap.get("flowId");
            String str2 = (String) hashMap.get("flowContent");
            Flow flow = a.get(str);
            if (flow != null) {
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).flowSetValueWithDuration(flow, str2);
                return;
            }
            String str3 = "flowSetValueWithDuration:" + str + "对应flow为空";
        }
    }

    public static void i(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, hashMap) == null) {
            String str = (String) hashMap.get("flowId");
            String str2 = (String) hashMap.get("category");
            String str3 = (String) hashMap.get(SpeedStatsUtils.UBC_KEY_OPTION);
            Flow flow = a.get(str);
            if (flow != null) {
                try {
                    ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).flowStartSlot(flow, str2, new JSONObject(str3));
                    return;
                } catch (JSONException unused) {
                    return;
                }
            }
            String str4 = "flowStartSlot:" + str + "对应flow为空";
        }
    }

    public static int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            if ((i2 & 1) > 0) {
                return 1;
            }
            if ((i2 & 2) > 0) {
                return 2;
            }
            if ((i2 & 4) > 0) {
                return 4;
            }
            if ((i2 & 8) > 0) {
                return 8;
            }
            if ((i2 & 16) > 0) {
                return 16;
            }
            if ((i2 & 32) > 0) {
                return 32;
            }
            return (i2 & 64) > 0 ? 64 : 0;
        }
        return invokeI.intValue;
    }

    public static void k(MethodChannel.Result result, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, result, hashMap) == null) {
            String str = (String) hashMap.get(TbEnum.SystemMessage.KEY_EVENT_ID);
            String str2 = (String) hashMap.get("eventContent");
            int intValue = ((Integer) hashMap.get(SpeedStatsUtils.UBC_KEY_OPTION)).intValue();
            try {
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                JSONObject jSONObject = new JSONObject(str2);
                if (j(intValue) > 0) {
                    uBCManager.onEvent(str, jSONObject, intValue);
                } else {
                    uBCManager.onEvent(str, jSONObject);
                }
            } catch (JSONException unused) {
                String str3 = str + "eventContent json格式错误";
            }
        }
    }

    public static void l(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, hashMap) == null) {
            String str = (String) hashMap.get("id");
            boolean equals = "1".equals((String) hashMap.get(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME));
            int parseInt = Integer.parseInt((String) hashMap.get("type"));
            j.a aVar = new j.a();
            aVar.c(str);
            aVar.b(equals);
            aVar.h(parseInt);
            j a2 = aVar.a();
            j.a aVar2 = new j.a();
            aVar2.c(str);
            aVar2.b(equals);
            aVar2.h(parseInt);
            j a3 = aVar2.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2);
            arrayList.add(a3);
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).registerConfig(new w(arrayList));
        }
    }

    public static void m(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, hashMap) == null) {
            String str = (String) hashMap.get(TbEnum.SystemMessage.KEY_EVENT_ID);
            boolean booleanValue = ((Boolean) hashMap.get("isReal")).booleanValue();
            int intValue = ((Integer) hashMap.get("uploadPeriod")).intValue();
            boolean booleanValue2 = ((Boolean) hashMap.get("isSend")).booleanValue();
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            m mVar = new m();
            if (!str.isEmpty()) {
                mVar = new m(str);
            }
            mVar.f26510b = booleanValue;
            mVar.f26511c = intValue;
            mVar.f26512d = booleanValue2;
            uBCManager.setDefaultConfig(mVar);
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).uploadFailedData();
        }
    }
}
