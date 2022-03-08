package c.a.p0.a.z0.h;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Integer> f9523b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f9524c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-117904446, "Lc/a/p0/a/z0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-117904446, "Lc/a/p0/a/z0/h/b;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        a = hashMap;
        hashMap.put("VRModeProjectionSphere", 201);
        a.put("VRModeProjectionDome180", 202);
        a.put("VRModeProjectionDome230", 203);
        a.put("VRModeProjectionDome180Upper", 204);
        a.put("VRModeProjectionDome230Upper", 205);
        a.put("VRModeProjectionPlaneFit", 207);
        a.put("VRModeProjectionPlaneCrop", 208);
        a.put("VRModeProjectionPlaneFull", 209);
        a.put("VRModeProjectionMultiFishEyeHorizontal", 210);
        a.put("VRModeProjectionMultiFishEyeVertical", Integer.valueOf((int) w0.A));
        a.put("VRModeProjectionStereoSphereHorizontal", Integer.valueOf((int) w0.f53859h));
        a.put("VRModeProjectionStereoSphereVertical", 213);
        a.put("VRModeProjectionStereoPlaneFitHorizontal", Integer.valueOf((int) w0.c0));
        a.put("VRModeProjectionStereoPlaneFitVertical", 215);
        a.put("VRModeProjectionPlaneFullHorizontal", 216);
        a.put("VRModeProjectionPlaneFullVertical", 217);
        HashMap<String, Integer> hashMap2 = new HashMap<>(2);
        f9523b = hashMap2;
        hashMap2.put("VRModeDisplayNormal", 101);
        f9523b.put("VRModeDisplayGlass", 102);
        HashMap<String, Integer> hashMap3 = new HashMap<>(5);
        f9524c = hashMap3;
        hashMap3.put("VRModeInteractiveMotion", 1);
        f9524c.put("VRModeInteractiveTouch", 2);
        f9524c.put("VRModeInteractiveMotionWithTouch", 3);
        f9524c.put("VRModeInteractiveGVRMotion", 4);
        f9524c.put("VRModeInteractiveGVRMotionWithTouch", 5);
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
            if (!TextUtils.isEmpty(optString) && a.containsKey(optString)) {
                a.get(optString).intValue();
            }
            String optString2 = jSONObject.optString("displayMode");
            if (!TextUtils.isEmpty(optString2) && f9523b.containsKey(optString2)) {
                f9523b.get(optString2).intValue();
            }
            String optString3 = jSONObject.optString("interactiveMode");
            if (!TextUtils.isEmpty(optString3) && f9524c.containsKey(optString3)) {
                f9524c.get(optString3).intValue();
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
