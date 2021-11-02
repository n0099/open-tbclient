package com.baidu.pass.face.platform.common;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class LogHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LogHelper";
    public static ArrayList<Integer> logLivenessLiveness;
    public static HashMap<String, Object> logMap;
    public static HashMap<String, Integer> logTipsMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1351468947, "Lcom/baidu/pass/face/platform/common/LogHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1351468947, "Lcom/baidu/pass/face/platform/common/LogHelper;");
                return;
            }
        }
        logMap = new HashMap<>();
        logLivenessLiveness = new ArrayList<>();
        logTipsMap = new HashMap<>();
    }

    public LogHelper() {
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

    public static void addLivenessLog(int i2) {
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, null, i2) == null) || (arrayList = logLivenessLiveness) == null || arrayList.contains(Integer.valueOf(i2))) {
            return;
        }
        logLivenessLiveness.add(Integer.valueOf(i2));
    }

    public static void addLog(String str, Object obj) {
        HashMap<String, Object> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, obj) == null) || (hashMap = logMap) == null) {
            return;
        }
        hashMap.put(str, obj);
    }

    public static void addLogWithKey(String str, Object obj) {
        HashMap<String, Object> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, obj) == null) || (hashMap = logMap) == null || hashMap.containsKey(str)) {
            return;
        }
        logMap.put(str, obj);
    }

    public static void addTipsLogWithKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            HashMap<String, Integer> hashMap = logTipsMap;
            if (hashMap != null && !hashMap.containsKey(str)) {
                logTipsMap.put(str, 1);
                return;
            }
            HashMap<String, Integer> hashMap2 = logTipsMap;
            if (hashMap2 == null || !hashMap2.containsKey(str)) {
                return;
            }
            logTipsMap.put(str, Integer.valueOf(logTipsMap.get(str).intValue() + 1));
        }
    }

    public static void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            logMap = new HashMap<>();
            logLivenessLiveness = new ArrayList<>();
            logTipsMap = new HashMap<>();
        }
    }

    public static String getLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(StringUtil.ARRAY_START);
                int i2 = 0;
                for (Map.Entry<String, Object> entry : logMap.entrySet()) {
                    if (i2 == logMap.size() - 1) {
                        if (entry.getValue() instanceof String) {
                            sb.append(entry.getKey() + ":'" + entry.getValue() + "'");
                        } else {
                            sb.append(entry.getKey() + ":" + entry.getValue());
                        }
                    } else {
                        if (entry.getValue() instanceof String) {
                            sb.append(entry.getKey() + ":'" + entry.getValue() + "'");
                        } else {
                            sb.append(entry.getKey() + ":" + entry.getValue());
                        }
                        sb.append(",");
                    }
                    i2++;
                }
                if (logLivenessLiveness != null && logLivenessLiveness.size() > 0) {
                    sb.append(",lv:[");
                    for (int i3 = 0; i3 < logLivenessLiveness.size(); i3++) {
                        if (i3 == logLivenessLiveness.size() - 1) {
                            sb.append(logLivenessLiveness.get(i3));
                        } else {
                            sb.append(logLivenessLiveness.get(i3) + ",");
                        }
                    }
                    sb.append(PreferencesUtil.RIGHT_MOUNT);
                }
                if (logTipsMap != null && logTipsMap.size() > 0) {
                    sb.append(",msg:{");
                    sb.append(getTipsMessage());
                    sb.append("}");
                }
                sb.append("}");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            logMap = new HashMap<>();
            logLivenessLiveness = new ArrayList<>();
            logTipsMap = new HashMap<>();
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getTipsKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye.name()) ? ConstantHelper.LOG_TIPS_LEFTEYE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye.name()) ? ConstantHelper.LOG_TIPS_RIGHTEYE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionNose.name()) ? ConstantHelper.LOG_TIPS_NOSE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionMouth.name()) ? ConstantHelper.LOG_TIPS_MOUTH_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour.name()) ? ConstantHelper.LOG_TIPS_LEFTFACE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour.name()) ? ConstantHelper.LOG_TIPS_RIGHTFACE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour.name()) ? ConstantHelper.LOG_TIPS_CHIN_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePoorIllumination.name()) ? ConstantHelper.LOG_TIPS_LIGHTUP : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeImageBlured.name()) ? ConstantHelper.LOG_TIPS_STAYSTILL : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeTooFar.name()) ? ConstantHelper.LOG_TIPS_MOVECLOSE : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeTooClose.name()) ? ConstantHelper.LOG_TIPS_MOVEFURTHER : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.name()) ? ConstantHelper.LOG_TIPS_HEADUP : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.name()) ? ConstantHelper.LOG_TIPS_HEADDOWN : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.name()) ? ConstantHelper.LOG_TIPS_TURNLEFT : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.name()) ? ConstantHelper.LOG_TIPS_TURNRIGHT : (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.name()) || TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame.name())) ? ConstantHelper.LOG_TIPS_MOVEFACE : "" : (String) invokeL.objValue;
    }

    public static String getTipsMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> entry : logTipsMap.entrySet()) {
                String tipsKey = getTipsKey(entry.getKey());
                if (!TextUtils.isEmpty(tipsKey)) {
                    sb.append(tipsKey + ":" + entry.getValue());
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void sendLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
        }
    }
}
