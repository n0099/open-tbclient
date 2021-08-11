package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Ack;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Crash;
import com.baidu.android.imsdk.upload.action.track.Db;
import com.baidu.android.imsdk.upload.action.track.Msg;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.android.imsdk.upload.action.track.Ui;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public final class IMPbGenerator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_ALL_LENGTH = 800;
    public static final int MAX_CRASH_LENGTH = 300;
    public static final String SDK_NAME = "im";
    public static final List<IMPushPb.Action> actionList;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1151188496, "Lcom/baidu/android/imsdk/upload/action/IMPbGenerator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1151188496, "Lcom/baidu/android/imsdk/upload/action/IMPbGenerator;");
                return;
            }
        }
        actionList = new CopyOnWriteArrayList();
    }

    public IMPbGenerator() {
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

    private IMPushPb.Action generateRequestAction(String str, String str2, long j2, long j3, long j4, String str3, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str3, Long.valueOf(j5)})) == null) ? IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j2).setResponseTime(j3).setErrorCode(j4).setExt(str3).setAliasId(j5).build()).build() : (IMPushPb.Action) invokeCommon.objValue;
    }

    private IMPushPb.Common getIMCommon(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            IMPushPb.DeviceID build = IMPushPb.DeviceID.newBuilder().setCuid(Utility.getDeviceId(context)).build();
            IMPushPb.AppInfo.Builder appName = IMPushPb.AppInfo.newBuilder().setAppName(context.getPackageName());
            return IMPushPb.Common.newBuilder().setDeviceId(build).setTimestamp(-1L).setUserTimestamp(System.currentTimeMillis()).setTerminalInfo(getTerminalInfo(context)).setNetInfo(getNetInfo(context)).setAppInfo(appName.setAppVersion("" + Utility.getAppVersionName(context)).setAppChannel("").build()).build();
        }
        return (IMPushPb.Common) invokeL.objValue;
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

    private IMPushPb.TerminalInfo getTerminalInfo(Context context) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i4 = 0;
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                i4 = displayMetrics.heightPixels;
                if (i2 > i4) {
                    i4 = i2;
                    i2 = i4;
                }
                i3 = displayMetrics.densityDpi;
            } else {
                i2 = 0;
                i3 = 0;
            }
            return IMPushPb.TerminalInfo.newBuilder().setOs(IMPushPb.OSType.ANDROID).setOsVersion(Build.VERSION.RELEASE).setManufacturer(Build.MANUFACTURER).setTerminalType(Build.MODEL).setResolutionH(i4).setResolutionV(i2).setPpi(i3).build();
        }
        return (IMPushPb.TerminalInfo) invokeL.objValue;
    }

    private void putIMAckToActions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            for (Ack ack : IMTrackDatabase.getInstance(context).getAcks()) {
                putIMAckToActions(ack.type, ack.value, ack.timestamp, ack.ext, ack.aliasId);
            }
        }
    }

    private void putIMActions(IMPushPb.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, action) == null) {
            actionList.add(action);
        }
    }

    private void putIMConnectionToActions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, context) == null) {
            for (Connection connection : IMTrackDatabase.getInstance(context).getConnections()) {
                putIMConnectionToActions(connection.startTime, connection.stopTime, connection.reason, connection.retryTime, connection.retryCount, connection.ext, connection.aliasId);
            }
        }
    }

    private void putIMCrashToActions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, context) == null) {
            for (Crash crash : IMTrackDatabase.getInstance(context).getCrashes()) {
                putIMCrashToActions(crash.timestamp, crash.exception, crash.ext, crash.aliasId);
            }
        }
    }

    private void putIMDbToAction(String str, String str2, String str3, String str4, long j2, long j3, long j4, String str5, long j5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str5, Long.valueOf(j5)}) == null) {
            putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.DB).setDb(IMPushPb.Db.newBuilder().setTable(str).setClassName(str2).setMethod(str3).setAction(str4).setStartTime(j2).setEndTime(j3).setDuration(j4).setExt(str5).setAliasId(j5).build()).build());
        }
    }

    private void putIMDbToActions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            for (Db db : IMTrackDatabase.getInstance(context).getDbs()) {
                putIMDbToAction(db.table, db.className, db.method, db.action, db.startTime, db.endTime, db.duration, db.ext, db.aliasId);
            }
        }
    }

    private void putIMMsgToActions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, context) == null) {
            for (Msg msg : IMTrackDatabase.getInstance(context).getMsgs()) {
                putIMMsgToActions(msg.msgCount, msg.roomId, msg.duration, msg.startMsgId, msg.endMsgId, msg.ext, msg.aliasId);
            }
        }
    }

    private void putIMRequestToAction(String str, String str2, long j2, long j3, long j4, String str3, long j5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str3, Long.valueOf(j5)}) == null) {
            putIMActions(generateRequestAction(str, str2, j2, j3, j4, str3, j5));
        }
    }

    private void putIMRequestToActions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, context) == null) {
            for (Request request : IMTrackDatabase.getInstance(context).getRequests()) {
                putIMRequestToAction(request.method, request.requestId, request.timestamp, request.responseTime, request.errorCode, request.ext, request.aliasId);
            }
        }
    }

    private void putIMUiToAction(String str, String str2, long j2, long j3, long j4, String str3, long j5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str3, Long.valueOf(j5)}) == null) {
            putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.UI).setUi(IMPushPb.Ui.newBuilder().setCategory(str).setPage(str2).setStartTime(j2).setEndTime(j3).setDuration(j4).setExt(str3).setAliasId(j5).build()).build());
        }
    }

    private void putIMUiToActions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, context) == null) {
            for (Ui ui : IMTrackDatabase.getInstance(context).getUis()) {
                putIMUiToAction(ui.category, ui.page, ui.startTime, ui.endTime, ui.duration, ui.ext, ui.aliasId);
            }
        }
    }

    public void clearIMActions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            actionList.clear();
        }
    }

    public byte[] generateIMClient(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                clearIMActions();
                long crashCount = IMTrackDatabase.getInstance(context).getCrashCount();
                long requestCount = IMTrackDatabase.getInstance(context).getRequestCount();
                long connectionCount = IMTrackDatabase.getInstance(context).getConnectionCount();
                if (crashCount >= 300 || requestCount >= 300 || connectionCount >= 300) {
                    IMTrackDatabase.getInstance(context).clearAllTables();
                }
                if (crashCount + requestCount + connectionCount > 800) {
                    IMTrackDatabase.getInstance(context).clearAllTables();
                    return null;
                }
                putIMUiToActions(context);
                putIMCrashToActions(context);
                putIMDbToActions(context);
                putIMConnectionToActions(context);
                putIMRequestToActions(context);
                putIMAckToActions(context);
                putIMMsgToActions(context);
                if (actionList.size() <= 0) {
                    return null;
                }
                return IMPushPb.PushImClient.newBuilder().setCommon(getIMCommon(context)).setSdkName("im").setSdkVersion(IMConfigInternal.getInstance().getSDKVersionValue(context)).addAllActions(actionList).build().toByteArray();
            } catch (Exception e2) {
                IMTrackDatabase.getInstance(context).clearAllTables();
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] generateIMRealClient(Context context, @NonNull IMPushPb.Action action) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, action)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(action);
                return IMPushPb.PushImClient.newBuilder().setCommon(getIMCommon(context)).setSdkName("im").setSdkVersion(IMConfigInternal.getInstance().getSDKVersionValue(context)).addAllActions(arrayList).build().toByteArray();
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    private void putIMAckToActions(String str, String str2, long j2, String str3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{str, str2, Long.valueOf(j2), str3, Long.valueOf(j3)}) == null) {
            putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.ACK).setAck(IMPushPb.Ack.newBuilder().setType(str).setValue(str2).setTimestamp(j2).setExt(str3).setAliasId(j3).build()).build());
        }
    }

    private void putIMConnectionToActions(long j2, long j3, String str, long j4, long j5, String str2, long j6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4), Long.valueOf(j5), str2, Long.valueOf(j6)}) == null) {
            putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(j2).setStopTime(j3).setReason(str).setRetryTime(j4).setRetryCount(j5).setExt(str2).setAliasId(j6).build()).build());
        }
    }

    private void putIMCrashToActions(long j2, String str, String str2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Long.valueOf(j2), str, str2, Long.valueOf(j3)}) == null) {
            putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CRASH).setCrash(IMPushPb.Crash.newBuilder().setTimestamp(j2).setException(str).setExt(str2).setAliasId(j3).build()).build());
        }
    }

    private void putIMMsgToActions(long j2, String str, long j3, long j4, long j5, String str2, long j6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), str2, Long.valueOf(j6)}) == null) {
            putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.MSG).setMsg(IMPushPb.Msg.newBuilder().setMsgCount(j2).setRoomId(str).setDuration(j3).setStartMsgid(j4).setEndMsgid(j5).setExt(str2).setAliasId(j6).build()).build());
        }
    }
}
