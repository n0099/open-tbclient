package com.baidu.searchbox.ui.animview.praise;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.animview.praise.data.PraiseSourceDef;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileReader;
/* loaded from: classes7.dex */
public class PraiseEnvironment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int RAM_THRESHOLD_GB = 3;
    public static final String TAG = "PraiseEnvironment";
    public static Performance sPerformanceLevel;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Performance {
        public static final /* synthetic */ Performance[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Performance LEVEL_1;
        public static final Performance LEVEL_2;
        public static final Performance LEVEL_3;
        public static final Performance LEVEL_NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(963899347, "Lcom/baidu/searchbox/ui/animview/praise/PraiseEnvironment$Performance;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(963899347, "Lcom/baidu/searchbox/ui/animview/praise/PraiseEnvironment$Performance;");
                    return;
                }
            }
            LEVEL_NONE = new Performance("LEVEL_NONE", 0);
            LEVEL_1 = new Performance("LEVEL_1", 1);
            LEVEL_2 = new Performance("LEVEL_2", 2);
            Performance performance = new Performance("LEVEL_3", 3);
            LEVEL_3 = performance;
            $VALUES = new Performance[]{LEVEL_NONE, LEVEL_1, LEVEL_2, performance};
        }

        public Performance(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Performance valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Performance) Enum.valueOf(Performance.class, str) : (Performance) invokeL.objValue;
        }

        public static Performance[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Performance[]) $VALUES.clone() : (Performance[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2125012545, "Lcom/baidu/searchbox/ui/animview/praise/PraiseEnvironment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2125012545, "Lcom/baidu/searchbox/ui/animview/praise/PraiseEnvironment;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
        sPerformanceLevel = Performance.LEVEL_NONE;
        analyzePerformance();
    }

    public PraiseEnvironment() {
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

    public static void analyzePerformance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                sPerformanceLevel = Performance.LEVEL_1;
                boolean z = DEBUG;
                return;
            }
            int totalRam = getTotalRam();
            if (totalRam > 0 && totalRam < 3) {
                sPerformanceLevel = Performance.LEVEL_1;
                if (DEBUG) {
                    String str = "Performance.LEVEL_1, totalRam = " + totalRam;
                    return;
                }
                return;
            }
            sPerformanceLevel = Performance.LEVEL_3;
            boolean z2 = DEBUG;
        }
    }

    public static Performance getPerformanceLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sPerformanceLevel : (Performance) invokeV.objValue;
    }

    @SuppressLint({"UseValueOf"})
    public static int getTotalRam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                String str = bufferedReader.readLine().split("\\s+")[1];
                bufferedReader.close();
                if (TextUtils.isEmpty(str)) {
                    return 0;
                }
                return (int) Math.ceil(new Float(Float.valueOf(str).floatValue() / 1048576.0f).doubleValue());
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean isCancelPraiseEnabled(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("h5_") || str.contains("hn_") || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HEADER) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST_OUT) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_IMMERSIVE_VIDEO_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_BAR) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_DYNAMIC_IMGTXT_DETAIL_BAR) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMUNITY_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HOT) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_HOT_DISCUSSION) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_YOULIAO) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_TAB_MOMENT) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_DYNAMIC_IMMERSIVE) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_LIVE_ASK_ANSWER) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_DYNAMIC_DETAIL) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_MERGE_VIDEO_LANDING) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FANCY_COMMENT_LIST);
        }
        return invokeL.booleanValue;
    }

    public static boolean isFirstPraiseAnimSupported(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = DEBUG;
                return false;
            } else if (!str.contains("h5_") && !str.contains("hn_")) {
                if (TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HEADER) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HOT)) {
                    return true;
                }
                if (TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FANCY_COMMENT_LIST)) {
                    return false;
                }
                boolean z2 = DEBUG;
                return false;
            } else {
                boolean z3 = DEBUG;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isPraiseLoginSupported(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = DEBUG;
                return false;
            } else if (!str.contains("h5_") && !str.contains("hn_")) {
                if (ComboPraiseRuntime.getContext() != null && !ComboPraiseRuntime.getContext().isPraiseLoginSupported()) {
                    boolean z2 = DEBUG;
                    return false;
                } else if (TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HEADER) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HOT)) {
                    return true;
                } else {
                    boolean z3 = DEBUG;
                    return false;
                }
            } else {
                boolean z4 = DEBUG;
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
