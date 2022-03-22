package com.baidu.sofire.utility;

import android.content.Context;
import android.util.Base64;
import com.baidu.sofire.BaiduLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ReportUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int POINT_CODE_BEGIN_FACE_SURFACE_LIVENESS = 0;
    public static final int POINT_CODE_BEGIN_FACE_TEXTURE_LIVENESS_RECORD = 1;
    public static final int POINT_CODE_BEGIN_RECORD = 102;
    public static final int POINT_CODE_END = 2;
    public static final int POINT_CODE_END_RECORD = 103;
    public static final int POINT_CODE_PREPARE_RECORD = 101;
    public static final int PROCESS_CODE_AFTER_COLLECT_BACK = 6;
    public static final int PROCESS_CODE_BEFORE_COLLECT = 1;
    public static final int PROCESS_CODE_ON_LIVENESS_COMLETION = 4;
    public static final int PROCESS_CODE_ON_PREVIEW_FRAME = 3;
    public static final int PROCESS_CODE_OPEN_BACK_CAMERA = 5;
    public static final int PROCESS_CODE_OPEN_CAMERA = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public ReportUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void reportProcessException(Context context, String str, int i, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, context, str, i, th) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("0", str);
                hashMap.put("1", Integer.valueOf(i));
                hashMap.put("2", th != null ? Base64.encodeToString(BaiduLog.getStackTraceString(th).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", "") : "");
                CommonMethods.sendEventUDC(context, "1090102", hashMap, true);
            } catch (Throwable th2) {
                CommonMethods.handleNuLException(th2);
            }
        }
    }

    public static void reportProcessKeyPoint(Context context, String str, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("0", str);
                hashMap.put("1", Integer.valueOf(i));
                hashMap.put("2", Integer.valueOf(i2));
                if (jSONObject != null) {
                    hashMap.put("3", jSONObject);
                }
                CommonMethods.sendEventRealTime(context, "1090101", hashMap);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }
}
