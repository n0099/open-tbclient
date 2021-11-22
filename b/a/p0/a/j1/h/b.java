package b.a.p0.a.j1.h;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f6855a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Integer> f6856b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f6857c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-893898126, "Lb/a/p0/a/j1/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-893898126, "Lb/a/p0/a/j1/h/b;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        f6855a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        f6855a.put("VRModeProjectionDome180", 202);
        f6855a.put("VRModeProjectionDome230", 203);
        f6855a.put("VRModeProjectionDome180Upper", 204);
        f6855a.put("VRModeProjectionDome230Upper", 205);
        f6855a.put("VRModeProjectionPlaneFit", 207);
        f6855a.put("VRModeProjectionPlaneCrop", 208);
        f6855a.put("VRModeProjectionPlaneFull", 209);
        f6855a.put("VRModeProjectionMultiFishEyeHorizontal", 210);
        f6855a.put("VRModeProjectionMultiFishEyeVertical", 211);
        f6855a.put("VRModeProjectionStereoSphereHorizontal", 212);
        f6855a.put("VRModeProjectionStereoSphereVertical", 213);
        f6855a.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        f6855a.put("VRModeProjectionStereoPlaneFitVertical", Integer.valueOf((int) JfifUtil.MARKER_RST7));
        f6855a.put("VRModeProjectionPlaneFullHorizontal", Integer.valueOf((int) JfifUtil.MARKER_SOI));
        f6855a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap<String, Integer> hashMap2 = new HashMap<>(2);
        f6856b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        f6856b.put("VRModeDisplayGlass", 102);
        HashMap<String, Integer> hashMap3 = new HashMap<>(5);
        f6857c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        f6857c.put("VRModeInteractiveTouch", 2);
        f6857c.put("VRModeInteractiveMotionWithTouch", 3);
        f6857c.put("VRModeInteractiveGVRMotion", 4);
        f6857c.put("VRModeInteractiveGVRMotionWithTouch", 5);
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
            }
        }
    }

    public b a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            b bVar = new b();
            if (jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("projectionMode");
            if (!TextUtils.isEmpty(optString) && f6855a.containsKey(optString)) {
                f6855a.get(optString).intValue();
            }
            String optString2 = jSONObject.optString("displayMode");
            if (!TextUtils.isEmpty(optString2) && f6856b.containsKey(optString2)) {
                f6856b.get(optString2).intValue();
            }
            String optString3 = jSONObject.optString("interactiveMode");
            if (!TextUtils.isEmpty(optString3) && f6857c.containsKey(optString3)) {
                f6857c.get(optString3).intValue();
            }
            jSONObject.optInt("fov", -1);
            jSONObject.optInt("minFov", -1);
            jSONObject.optInt("maxFov", -1);
            jSONObject.optBoolean("pinchEnable", true);
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
