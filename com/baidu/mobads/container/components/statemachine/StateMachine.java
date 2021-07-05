package com.baidu.mobads.container.components.statemachine;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class StateMachine {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_CACHED_AD_NUM = 100;
    public static final long STATE_TIME_OUT_MILLIS = 1800000;
    public static LinkedList<String> mAdOrderList;
    public static ConcurrentHashMap<String, AdStateInstance> mAdStatusList;
    public static Context mContext;
    public static ConcurrentHashMap<String, String> mIdTransformMap;
    public static String mLastAdEvent;
    public static String mLastAdId;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2088114790, "Lcom/baidu/mobads/container/components/statemachine/StateMachine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2088114790, "Lcom/baidu/mobads/container/components/statemachine/StateMachine;");
                return;
            }
        }
        mAdStatusList = new ConcurrentHashMap<>();
        mIdTransformMap = new ConcurrentHashMap<>();
        mAdOrderList = new LinkedList<>();
    }

    public StateMachine() {
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

    public static boolean addIdMapper(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void createState(long j, String str, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), str, iXAdInstanceInfo}) == null) || j < 0 || iXAdInstanceInfo == null) {
            return;
        }
        String uniqueId = iXAdInstanceInfo.getUniqueId();
        if (TextUtils.isEmpty(uniqueId)) {
            return;
        }
        if (getAdStateById(uniqueId) == null) {
            mAdStatusList.put(uniqueId, new AdStateInstance(j, str, iXAdInstanceInfo));
            mAdOrderList.add(uniqueId);
        }
        StateUploadScheduler.getInstance().start();
    }

    public static void event(String str, AdStateCode adStateCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, str, adStateCode) == null) {
        }
    }

    public static void event(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
        }
    }

    public static void event(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3) == null) {
        }
    }

    public static void finish(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
        }
    }

    public static AdStateInstance getAdStateById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str) || mAdStatusList.size() <= 0) {
                    return null;
                }
                if (!mAdStatusList.containsKey(str) && mIdTransformMap.containsKey(str)) {
                    str = mIdTransformMap.get(str);
                }
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return mAdStatusList.get(str);
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(th);
                return null;
            }
        }
        return (AdStateInstance) invokeL.objValue;
    }

    public static void markTimeoutState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            try {
                Set<String> keySet = mAdStatusList.keySet();
                if (keySet == null || keySet.size() <= 0) {
                    return;
                }
                for (String str : keySet) {
                    AdStateInstance adStateById = getAdStateById(str);
                    if (adStateById != null && System.currentTimeMillis() - adStateById.mRequestTimeMillis > 1800000) {
                        adStateById.markReady4Send(true);
                        String str2 = AdStateEvent.EVENT_AD_TIMEOUT;
                        adStateById.addExtra(str2, System.currentTimeMillis() + "");
                    }
                }
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(th);
            }
        }
    }

    public static long queryLong(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            return 0L;
        }
        return invokeLL.longValue;
    }

    public static String queryPossibleUniqueId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void removeUnusedState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            try {
                if (mAdStatusList.size() > 100) {
                    Set<String> keySet = mAdStatusList.keySet();
                    if (keySet.size() > 0) {
                        for (String str : keySet) {
                            AdStateInstance adStateInstance = mAdStatusList.get(str);
                            if (adStateInstance != null && adStateInstance.isHasSend.get()) {
                                mAdStatusList.remove(str);
                                mAdOrderList.remove(str);
                            }
                        }
                    }
                    if (mAdStatusList.size() > 100) {
                        int size = mAdStatusList.size() - 100;
                        for (int i2 = 0; i2 < size; i2++) {
                            mAdOrderList.remove(0);
                            mAdStatusList.remove(mAdOrderList.getFirst());
                        }
                    }
                    Set<String> keySet2 = mIdTransformMap.keySet();
                    if (keySet2.size() > 0) {
                        for (String str2 : keySet2) {
                            String str3 = mIdTransformMap.get(str2);
                            if (!TextUtils.isEmpty(str3) && !mAdStatusList.containsKey(str3)) {
                                mIdTransformMap.remove(str2);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(th);
            }
        }
    }

    public static void sendLog(AdStateInstance adStateInstance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, adStateInstance) == null) {
            try {
                if (mContext != null) {
                    SendLogUtil.Builder append = SendLogUtil.Builder.create(mContext).appendType(SDKLogTypeConstants.STATE_MACHINE).appendAdInfo(adStateInstance.mAdInstanceInfo).appendProdType(adStateInstance.mProdType).append("states", adStateInstance.getAllState());
                    String str = AdStateEvent.EVENT_REQUEST_TIME;
                    append.append(str, "" + adStateInstance.mRequestTimeMillis).append(adStateInstance.getExtraInfo()).send();
                    adStateInstance.setHasSend(true);
                }
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(th);
            }
        }
    }

    public static void setApplicationContext(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, context) == null) && context != null && mContext == null) {
            mContext = context.getApplicationContext();
        }
    }

    public static void uploadState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            try {
                if (mAdStatusList.size() > 0) {
                    for (String str : mAdStatusList.keySet()) {
                        AdStateInstance adStateInstance = mAdStatusList.get(str);
                        if (adStateInstance != null && adStateInstance.isReady4Send.get() && !adStateInstance.isHasSend.get()) {
                            sendLog(adStateInstance);
                        }
                    }
                }
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(th);
            }
        }
    }
}
