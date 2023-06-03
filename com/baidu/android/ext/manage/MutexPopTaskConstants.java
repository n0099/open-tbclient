package com.baidu.android.ext.manage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MutexPopTaskConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean isEnforce_BearBar = false;
    public static boolean isEnforce_Default = false;
    public static boolean isEnforce_LandingTopTip = false;
    public static boolean isEnforce_Voice = false;
    public static boolean isEnforce_VoicePop = false;
    public static boolean isEnforce_Voice_Direct = false;
    public static boolean isEnqueue_BearBar = true;
    public static boolean isEnqueue_Default = true;
    public static boolean isEnqueue_LandingTopTip = true;
    public static boolean isEnqueue_Voice = true;
    public static boolean isEnqueue_VoicePop = true;
    public static boolean isEnqueue_Voice_Direct = true;
    public static boolean isResumable_BearBar = false;
    public static boolean isResumable_Default = false;
    public static boolean isResumable_LandingTopTip = false;
    public static boolean isResumable_Voice = false;
    public static boolean isResumable_VoicePop = false;
    public static boolean isResumable_Voice_Direct = false;
    public static int sPriority_BearBar = 2;
    public static int sPriority_Default = 20;
    public static int sPriority_FreeFlowCard = 6;
    public static int sPriority_LandingTopTip = 1;
    public static int sPriority_Voice = 5;
    public static int sPriority_VoicePop = 4;
    public static int sPriority_Voice_Direct = 3;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-412291375, "Lcom/baidu/android/ext/manage/MutexPopTaskConstants;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-412291375, "Lcom/baidu/android/ext/manage/MutexPopTaskConstants;");
        }
    }

    public MutexPopTaskConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
