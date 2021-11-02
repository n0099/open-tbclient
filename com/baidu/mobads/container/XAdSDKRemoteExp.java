package com.baidu.mobads.container;

import android.content.Context;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class XAdSDKRemoteExp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class LiteInc {
        public static /* synthetic */ Interceptable $ic = null;
        public static int mCountMax = 2;
        public static int mIntervalTime = 3600000;
        public static long mLastTimeMillis = 0;
        public static String mPkgName = "com.baidu.searchbox.lite";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1101179562, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$LiteInc;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101179562, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$LiteInc;");
            }
        }

        public LiteInc() {
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

        public static boolean count() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (mCountMax <= 0) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - mLastTimeMillis < mIntervalTime) {
                    return false;
                }
                mLastTimeMillis = currentTimeMillis;
                int i2 = mCountMax;
                mCountMax = i2 - 1;
                return i2 > 0;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class PlayGame {
        public static /* synthetic */ Interceptable $ic;
        public static boolean mInit;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-890555990, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$PlayGame;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-890555990, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$PlayGame;");
            }
        }

        public PlayGame() {
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
    }

    /* loaded from: classes7.dex */
    public static class SearchBoxAct {
        public static /* synthetic */ Interceptable $ic = null;
        public static int mIntervalTime = 43200000;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1098205953, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$SearchBoxAct;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1098205953, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$SearchBoxAct;");
            }
        }

        public SearchBoxAct() {
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

        public static boolean count(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? System.currentTimeMillis() - j >= ((long) mIntervalTime) : invokeJ.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class SecDexExp {
        public static /* synthetic */ Interceptable $ic;
        public static String[] appsidList;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1911816591, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$SecDexExp;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1911816591, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$SecDexExp;");
                    return;
                }
            }
            appsidList = new String[]{"c5cd4938", "cc11ff4a", "c37351b3", "c57c567d", "f4ebd40b", "ee9301d8", "d73bab66", "edb0202e", "c346a49a", "cdd9e6c3", "a8dd3411", "eaaaf235", "eedce234", "be6cafba", "fdb23908", "ecfe3dd9", "f3b8127c", "cb8f3131", "e7a4e60d", "af908ec9", "e866cfb0"};
        }

        public SecDexExp() {
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

        public static boolean isAddZdTd(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                String appId = DeviceUtils.getInstance().getAppId(context);
                String[] strArr = appsidList;
                if (strArr != null && strArr.length > 0) {
                    for (String str : strArr) {
                        if (str.equals(appId)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class StateMachineExp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public StateMachineExp() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static boolean isUnderStateMachine(XAdContainerContext xAdContainerContext) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xAdContainerContext)) == null) {
                if (xAdContainerContext != null) {
                    try {
                        String adProd = xAdContainerContext.getAdProd();
                        if (!"feed".equals(adProd)) {
                            if (!"rsplash".equals(adProd)) {
                                return false;
                            }
                        }
                        return true;
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class ThirdMonitorExp {
        public static /* synthetic */ Interceptable $ic;
        public static String[] appsidList;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1495436612, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$ThirdMonitorExp;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1495436612, "Lcom/baidu/mobads/container/XAdSDKRemoteExp$ThirdMonitorExp;");
                    return;
                }
            }
            appsidList = new String[]{"df7e6e9f", "e866cfb0", "b4305876"};
        }

        public ThirdMonitorExp() {
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

        public static boolean isSendThirdMonitorLog(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public XAdSDKRemoteExp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
