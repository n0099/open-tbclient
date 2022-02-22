package c.a.w0;

import android.content.SharedPreferences;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.w0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.IRemoteUBCService;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBC;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h0 implements UBCManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f26696c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26697b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-985721117, "Lc/a/w0/h0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-985721117, "Lc/a/w0/h0;");
                return;
            }
        }
        f26696c = b0.m();
    }

    public h0() {
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
        this.a = "";
        this.f26697b = "";
    }

    public final IRemoteUBCService a() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? UBC.getProxy() : (IRemoteUBCService) invokeV.objValue;
    }

    public final Flow b(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Flow ubcBeginFlowWithBizInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2)) == null) {
            Flow flow = null;
            try {
                if (TextUtils.isEmpty(this.a)) {
                    ubcBeginFlowWithBizInfo = a().ubcBeginFlow(str, str2, i2);
                } else {
                    ubcBeginFlowWithBizInfo = a().ubcBeginFlowWithBizInfo(str, str2, i2, this.a);
                }
                flow = ubcBeginFlowWithBizInfo;
                if (f26696c) {
                    String str3 = "flow id " + str + " beginFlow  process name " + c.a.l0.b.a.a.b() + "flow hashCode " + flow.hashCode() + " handle id " + flow.getHandle();
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            return flow == null ? new Flow() : flow;
        }
        return (Flow) invokeLLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? beginFlow(str, "", 0) : (Flow) invokeL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowAddEvent(Flow flow, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, flow, str) == null) {
            flowAddEvent(flow, str, null);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowAddEventWithDate(Flow flow, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{flow, str, str2, Long.valueOf(j2)}) == null) {
            if (f26696c) {
                String str3 = " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid();
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (c.a.l0.b.a.a.g()) {
                d.w().G(flow.getId(), str, flow.getHandle(), str2, j2, flow.getOption());
                return;
            }
            try {
                UBC.getProxy().flowAddEventWithTime(flow, str, str2, j2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowCancel(Flow flow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, flow) == null) {
            if (f26696c) {
                String str = "cancel flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid();
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (b0.i().m() && flow.hasEnd()) {
                if (f26696c) {
                    String str2 = "flow has end, should not end again!!! ubc id=" + flow.getId() + ", flow handle=" + flow.getHandle();
                    return;
                }
                return;
            }
            flow.markEnd();
            if (c.a.l0.b.a.a.g()) {
                d.w().s(flow.getId(), flow.getHandle());
                return;
            }
            try {
                UBC.getProxy().flowCancel(flow);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowEnd(Flow flow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, flow) == null) {
            if (f26696c) {
                String str = "end flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid();
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (b0.i().m() && flow.hasEnd()) {
                if (f26696c) {
                    String str2 = "flow has end, should not end again!!! ubc id=" + flow.getId() + ", flow handle=" + flow.getHandle();
                    return;
                }
                return;
            }
            flow.markEnd();
            if (c.a.l0.b.a.a.g()) {
                JSONArray jSONArray = new JSONArray();
                if (flow.getSlotMaps() != null && (r1 = flow.getSlotMaps().entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : flow.getSlotMaps().entrySet()) {
                        Slot value = entry.getValue();
                        if (value.isBegin() && !value.isEnded()) {
                            value.setEnd(System.currentTimeMillis());
                        }
                        JSONObject jSONObject = entry.getValue().getJSONObject();
                        if (jSONObject != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                d.w().u(flow.getId(), flow.getHandle(), flow.getOption(), jSONArray);
                return;
            }
            try {
                UBC.getProxy().flowEnd(flow);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowEndSlot(Flow flow, String str) {
        Slot slot;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, flow, str) == null) || flow == null || !flow.getValid() || TextUtils.isEmpty(str) || (slot = flow.getSlotMaps().get(str)) == null || !slot.isBegin() || slot.isEnded()) {
            return;
        }
        slot.setEnd(System.currentTimeMillis());
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowSetValue(Flow flow, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, flow, str) == null) {
            if (f26696c) {
                String str2 = " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid();
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (c.a.l0.b.a.a.g()) {
                d.w().N(flow.getId(), flow.getHandle(), str);
                return;
            }
            try {
                UBC.getProxy().flowSetValue(flow, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowSetValueWithDuration(Flow flow, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, flow, str) == null) {
            if (f26696c) {
                String str2 = " flow setValueWithDuration, mId:" + flow.getId() + " handle: " + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid();
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (c.a.l0.b.a.a.g()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    float currentTimeMillis = ((float) (System.currentTimeMillis() - flow.getStartTime())) / 1000.0f;
                    if (currentTimeMillis < 0.0f) {
                        currentTimeMillis = 0.0f;
                    }
                    jSONObject.put("duration", String.format(Locale.ENGLISH, "%.3f", Float.valueOf(currentTimeMillis)));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(SpeedStatsUtils.UBC_KEY_OPTION, str);
                    }
                    if (f26696c) {
                        String str3 = " flow setValueWithDuration, mId:" + flow.getId() + ", duration: " + jSONObject.toString();
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                d.w().N(flow.getId(), flow.getHandle(), jSONObject.toString());
                return;
            }
            try {
                UBC.getProxy().flowSetValueWithDuration(flow, str);
            } catch (RemoteException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowStartSlot(Flow flow, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048595, this, flow, str, jSONObject) == null) || flow == null || !flow.getValid() || TextUtils.isEmpty(str)) {
            return;
        }
        Slot slot = flow.getSlotMaps().get(str);
        if (slot == null) {
            flow.getSlotMaps().put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
            return;
        }
        slot.setOption(jSONObject);
    }

    @Override // com.baidu.ubc.UBCManager
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            boolean z = f26696c;
            d.w().v();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    @Deprecated
    public String getUploadType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (c.a.l0.b.a.a.g()) {
                return d.w().x(str);
            }
            try {
                return UBC.getProxy().getUploadType(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public boolean isUBCDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (f26696c) {
                return PreferenceManager.getDefaultSharedPreferences(b0.b()).getBoolean("KEY_UBC_DEBUG", f26696c);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public boolean isUBCSample() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (f26696c) {
                return PreferenceManager.getDefaultSharedPreferences(b0.b()).getBoolean("KEY_UBC_SAMPLE", false);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            onEvent(str, "", 0);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void registerConfig(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, wVar) == null) {
            registerConfig(wVar, false, null);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void setDefaultConfig(m mVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, mVar) == null) && mVar != null && c.a.l0.b.a.a.g()) {
            j.a aVar = new j.a();
            aVar.c(mVar.f26747f);
            aVar.f(mVar.a);
            aVar.e(mVar.f26743b);
            aVar.d(mVar.f26745d);
            aVar.g(mVar.f26744c);
            aVar.b(true);
            j a = aVar.a();
            if (!m.a(mVar.f26747f)) {
                a.D(mVar.f26746e);
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(a);
            registerConfig(new w(arrayList));
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void setUBCDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(b0.b()).edit();
            edit.putBoolean("KEY_UBC_DEBUG", z);
            edit.commit();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void setUBCSample(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(b0.b()).edit();
            edit.putBoolean("KEY_UBC_SAMPLE", z);
            edit.commit();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void upload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            boolean z = f26696c;
            d.w().O();
            d.w().K();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void uploadFailedData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            boolean z = f26696c;
            d.w().E();
            d.w().L();
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void uploadLocalDatas() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (c.a.l0.b.a.a.g()) {
                d.w().W();
                return;
            }
            try {
                UBC.getProxy().uploadLocalDatas();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) ? beginFlow(str, "", i2) : (Flow) invokeLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowAddEvent(Flow flow, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, flow, str, str2) == null) {
            if (f26696c) {
                String str3 = " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid();
            }
            if (flow == null || !flow.getValid()) {
                return;
            }
            if (c.a.l0.b.a.a.g()) {
                d.w().F(flow.getId(), str, flow.getHandle(), str2, flow.getOption());
                return;
            }
            try {
                UBC.getProxy().flowAddEvent(flow, str, str2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, str, i2) == null) {
            onEvent(str, "", i2);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void registerConfig(w wVar, boolean z, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
            d.w().M(wVar, z, sVar);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) ? beginFlow(str, str2, 0) : (Flow) invokeLL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            onEvent(str, str2, 0);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jSONObject)) == null) ? beginFlow(str, jSONObject, 0) : (Flow) invokeLL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, jSONObject) == null) {
            onEvent(str, jSONObject, 0);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, map)) == null) ? beginFlow(str, map, 0) : (Flow) invokeLL.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, map) == null) {
            onEvent(str, map, 0);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public final Flow beginFlow(String str, Map<String, String> map, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, str, map, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                if (f26696c) {
                    String str2 = "UBC beginFlow# exception:" + e2.getMessage();
                }
            }
            return beginFlow(str, jSONObject.toString(), i2);
        }
        return (Flow) invokeLLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public final void onEvent(String str, Map<String, String> map, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048605, this, str, map, i2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                if (f26696c) {
                    String str2 = "UBC onEvent# exception:" + e2.getMessage();
                }
            }
            onEvent(str, jSONObject.toString(), i2);
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public void flowSetValue(Flow flow, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, flow, map) == null) && flow != null && flow.getValid()) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                if (f26696c) {
                    String str = "UBC beginFlow# exception:" + e2.getMessage();
                }
            }
            if (f26696c) {
                String str2 = " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + jSONObject.toString();
            }
            flowSetValue(flow, jSONObject.toString());
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public Flow beginFlow(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, str, str2, i2)) == null) {
            if (c.a.l0.b.a.a.g()) {
                if (TextUtils.isEmpty(str)) {
                    if (f26696c) {
                        throw new IllegalArgumentException("UBC beginFlow#flowId must not be null.");
                    }
                    return null;
                }
                if (f26696c) {
                    String str3 = "begin flow id:" + str + " value:" + str2;
                }
                if (TextUtils.isEmpty(this.a)) {
                    return d.w().o(str, str2, i2);
                }
                return d.w().p(str, str2, i2, this.f26697b);
            }
            return b(str, str2, i2);
        }
        return (Flow) invokeLLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public void onEvent(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, str, str2, i2) == null) {
            if (c.a.l0.b.a.a.g()) {
                if (TextUtils.isEmpty(str)) {
                    if (f26696c) {
                        throw new IllegalArgumentException("UBC onEvent#eventId must not be null.");
                    }
                    return;
                }
                if (f26696c) {
                    String str3 = "on event id:" + str + " value:" + str2;
                }
                if (TextUtils.isEmpty(this.a)) {
                    d.w().A(str, str2, i2);
                    return;
                } else {
                    d.w().B(str, str2, i2, this.f26697b);
                    return;
                }
            }
            try {
                IRemoteUBCService a = a();
                if (TextUtils.isEmpty(this.a)) {
                    a.ubcOnEvent(str, str2, i2);
                } else {
                    a.ubcOnEventWithBizInfo(str, str2, i2, this.a);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.UBCManager
    public Flow beginFlow(String str, JSONObject jSONObject, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, str, jSONObject, i2)) == null) {
            if (c.a.l0.b.a.a.g()) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (f26696c) {
                    String str2 = "begin flow id:" + str + " value:" + jSONObject;
                }
                if (TextUtils.isEmpty(this.a)) {
                    return d.w().q(str, jSONObject, i2);
                }
                return d.w().r(str, jSONObject, i2, this.f26697b);
            }
            return b(str, jSONObject.toString(), i2);
        }
        return (Flow) invokeLLI.objValue;
    }

    @Override // com.baidu.ubc.UBCManager
    public void onEvent(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048607, this, str, jSONObject, i2) == null) {
            if (c.a.l0.b.a.a.g()) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f26696c) {
                    String str2 = "on event id:" + str + " value:" + jSONObject.toString();
                }
                if (TextUtils.isEmpty(this.a)) {
                    d.w().C(str, jSONObject, i2);
                    return;
                } else {
                    d.w().D(str, jSONObject, i2, this.f26697b);
                    return;
                }
            }
            try {
                IRemoteUBCService a = a();
                if (TextUtils.isEmpty(this.a)) {
                    a.ubcOnEvent(str, jSONObject.toString(), i2);
                } else {
                    a.ubcOnEventWithBizInfo(str, jSONObject.toString(), i2, this.a);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
