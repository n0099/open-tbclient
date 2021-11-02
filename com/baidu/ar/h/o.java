package com.baidu.ar.h;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public static String yg;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1921143043, "Lcom/baidu/ar/h/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1921143043, "Lcom/baidu/ar/h/o;");
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, jSONObject) == null) {
            if (context == null || jSONObject == null) {
                b.aS("bdar: addSystemInfo context/httpParams is null!!!");
                return;
            }
            jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, "android");
            jSONObject.put("os_type", "android");
            jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, c.getVersionCode());
            jSONObject.put("app_id", c.s(context));
            jSONObject.put("device_id", Build.MODEL);
            jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
            jSONObject.put(HttpConstants.OS_BRAND, Build.BRAND.toLowerCase());
            jSONObject.put(HttpConstants.OS_MODEL, Build.MODEL.toLowerCase());
            jSONObject.put(HttpConstants.OS_VERSION_SDK, Build.VERSION.SDK_INT);
            jSONObject.put(HttpConstants.OS_VERSION_RELESE, Build.VERSION.RELEASE);
            jSONObject.put(HttpConstants.OS_WIDTH_PIXELS, context.getResources().getDisplayMetrics().widthPixels);
            jSONObject.put(HttpConstants.OS_HEIGHT_PIXELS, context.getResources().getDisplayMetrics().heightPixels);
            jSONObject.put(HttpConstants.OS_SCALE_PDI, context.getResources().getDisplayMetrics().densityDpi);
            long[] gC = q.gC();
            jSONObject.put(HttpConstants.OS_ROM_MEMORY, gC[0]);
            jSONObject.put(HttpConstants.OS_ROM_AVAIL_MEMORY, gC[1]);
            jSONObject.put(HttpConstants.OS_SDCARD_MEMORY, q.gD());
            jSONObject.put(HttpConstants.OS_ROM_SDCARD_AVAIL_MEMORY, q.gE());
            jSONObject.put(HttpConstants.OS_RAM_MEMEORY, q.B(context));
            jSONObject.put(HttpConstants.OS_RAM_AVAIL_MEMORY, q.C(context));
            if (q.D(context)) {
                jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 1);
            } else {
                jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 0);
            }
            jSONObject.put(HttpConstants.OS_CPU_NAME, q.gF());
            jSONObject.put(HttpConstants.OS_CPU_NUM_CORES, q.gG());
            jSONObject.put(HttpConstants.OS_CPU_MIN_FREQ, q.gH());
            jSONObject.put(HttpConstants.OS_CPU_MAX_FREQ, q.gJ());
            jSONObject.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
            jSONObject.put(HttpConstants.OS_CPU_CUR_FREQ, q.gK());
            jSONObject.put(HttpConstants.OS_NATIVE_HEAPSIZE, (int) (Runtime.getRuntime().maxMemory() / 1048576));
            jSONObject.put(HttpConstants.OS_NATIVE_SENSOR, ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null);
            jSONObject.put("network_type", m.x(context));
            jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Arrays.asList(Build.SUPPORTED_ABIS));
            jSONObject.put(HttpConstants.HTTP_GLES_VERSION, ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
            jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
            jSONObject.put(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
            jSONObject.put(HttpConstants.HTTP_MANUFACTURER, Build.MANUFACTURER);
        }
    }

    public static void a(JSONObject jSONObject, int i2, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, jSONObject, i2, objArr) == null) {
            jSONObject.put(HttpConstants.AIP_APP_ID, i2);
            jSONObject.put(HttpConstants.IS_AIP, "3");
            jSONObject.put("sign", objArr[0]);
            jSONObject.put("timestamp", objArr[1]);
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, jSONObject) == null) || context == null || jSONObject == null) {
            return;
        }
        jSONObject.put("user_id", y(context));
        jSONObject.put("cuid", ARConfig.getCUID());
    }

    public static void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String aipAppId = DuMixARConfig.getAipAppId();
        a(jSONObject, TextUtils.isEmpty(aipAppId) ? 0 : Integer.parseInt(aipAppId), ARConfig.getSignatureAndTime());
    }

    public static String y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (yg == null && context != null) {
                UUID gz = new g(context).gz();
                yg = gz != null ? gz.toString() : "";
            }
            return yg;
        }
        return (String) invokeL.objValue;
    }
}
