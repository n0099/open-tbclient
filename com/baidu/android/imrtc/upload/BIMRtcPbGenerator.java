package com.baidu.android.imrtc.upload;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public final class BIMRtcPbGenerator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SDK_NAME = "bim_rtc";
    public static final String TAG = "BIMRtcPbGenerator";
    public static final List<IMPushPb.Action> actionList;
    public static final List<Request> requests;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(862927395, "Lcom/baidu/android/imrtc/upload/BIMRtcPbGenerator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(862927395, "Lcom/baidu/android/imrtc/upload/BIMRtcPbGenerator;");
                return;
            }
        }
        actionList = new CopyOnWriteArrayList();
        requests = new ArrayList();
    }

    public BIMRtcPbGenerator() {
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

    private IMPushPb.Action generateRequestAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str3, Long.valueOf(j4)})) == null) {
            return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j).setResponseTime(j2).setErrorCode(j3).setExt(str3).setAliasId(j4).build()).build();
        }
        return (IMPushPb.Action) invokeCommon.objValue;
    }

    private IMPushPb.Common getIMCommon(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            IMPushPb.DeviceID build = IMPushPb.DeviceID.newBuilder().setCuid(RtcUtility.getCuid(context)).build();
            IMPushPb.AppInfo.Builder appName = IMPushPb.AppInfo.newBuilder().setAppName(context.getPackageName());
            return IMPushPb.Common.newBuilder().setDeviceId(build).setTimestamp(-1L).setUserTimestamp(System.currentTimeMillis()).setTerminalInfo(getTerminalInfo(context)).setNetInfo(getNetInfo(context)).setAppInfo(appName.setAppVersion("" + RtcUtility.getAppVersionName(context)).setAppChannel("").build()).build();
        }
        return (IMPushPb.Common) invokeL.objValue;
    }

    private IMPushPb.TerminalInfo getTerminalInfo(Context context) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i3 = 0;
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i = displayMetrics.widthPixels;
                i3 = displayMetrics.heightPixels;
                if (i > i3) {
                    i3 = i;
                    i = i3;
                }
                i2 = displayMetrics.densityDpi;
            } else {
                i = 0;
                i2 = 0;
            }
            return IMPushPb.TerminalInfo.newBuilder().setOs(IMPushPb.OSType.ANDROID).setOsVersion(Build.VERSION.RELEASE).setManufacturer(Build.MANUFACTURER).setTerminalType(Build.MODEL).setResolutionH(i3).setResolutionV(i).setPpi(i2).build();
        }
        return (IMPushPb.TerminalInfo) invokeL.objValue;
    }

    public byte[] generateRtcClient(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                putRequestToActions(context);
                LogUtils.w(TAG, "generateRtcClient :" + requests.size());
                if (actionList.size() <= 0) {
                    return null;
                }
                return IMPushPb.PushImClient.newBuilder().setCommon(getIMCommon(context)).setSdkName(SDK_NAME).setSdkVersion(103050L).addAllActions(actionList).build().toByteArray();
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static IMPushPb.NetInfo getNetInfo(Context context) {
        InterceptResult invokeL;
        String str;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            String str2 = "";
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                str = "";
            } else {
                String str3 = "" + activeNetworkInfo.getTypeName();
                str = "" + activeNetworkInfo.getExtraInfo();
                str2 = str3;
            }
            return IMPushPb.NetInfo.newBuilder().setNetType(str2).setNetApn(str).build();
        }
        return (IMPushPb.NetInfo) invokeL.objValue;
    }

    private void putRequestToActions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            synchronized (requests) {
                requests.clear();
                requests.addAll(BIMRtcTrackDatabase.getInstance(context).getRequests());
                for (Request request : requests) {
                    putRequestToAction(request.method, request.requestId, request.timestamp, request.responseTime, request.errorCode, request.ext, request.aliasId);
                }
            }
        }
    }

    private void putActions(IMPushPb.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, action) == null) {
            actionList.add(action);
        }
    }

    private void putRequestToAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str3, Long.valueOf(j4)}) == null) {
            putActions(generateRequestAction(str, str2, j, j2, j3, str3, j4));
        }
    }

    public void clearRtcActions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            actionList.clear();
            synchronized (requests) {
                LogUtils.e(TAG, "deleteRequests :" + requests.size());
                BIMRtcTrackDatabase.getInstance(context).deleteRequests(requests);
            }
        }
    }
}
