package com.baidu.android.imrtc.upload;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Request;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public final class BIMRtcPbGenerator {
    public static final String SDK_NAME = "bim_rtc";
    public static final String TAG = "BIMRtcPbGenerator";
    public static final List<IMPushPb.Action> actionList = new CopyOnWriteArrayList();
    public static final List<Request> requests = new ArrayList();

    private IMPushPb.Action generateRequestAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j).setResponseTime(j2).setErrorCode(j3).setExt(str3).setAliasId(j4).build()).build();
    }

    private IMPushPb.Common getIMCommon(Context context) {
        IMPushPb.DeviceID build = IMPushPb.DeviceID.newBuilder().setCuid(RtcUtility.getCuid(context)).build();
        IMPushPb.AppInfo.Builder appName = IMPushPb.AppInfo.newBuilder().setAppName(context.getPackageName());
        return IMPushPb.Common.newBuilder().setDeviceId(build).setTimestamp(-1L).setUserTimestamp(System.currentTimeMillis()).setTerminalInfo(getTerminalInfo(context)).setNetInfo(getNetInfo(context)).setAppInfo(appName.setAppVersion("" + RtcUtility.getAppVersionName(context)).setAppChannel("").build()).build();
    }

    public static IMPushPb.NetInfo getNetInfo(Context context) {
        String str;
        NetworkInfo activeNetworkInfo;
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

    private IMPushPb.TerminalInfo getTerminalInfo(Context context) {
        int i;
        int i2;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
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

    private void putActions(IMPushPb.Action action) {
        actionList.add(action);
    }

    private void putRequestToAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        putActions(generateRequestAction(str, str2, j, j2, j3, str3, j4));
    }

    private void putRequestToActions(Context context) {
        synchronized (requests) {
            requests.clear();
            requests.addAll(BIMRtcTrackDatabase.getInstance(context).getRequests());
            for (Request request : requests) {
                putRequestToAction(request.method, request.requestId, request.timestamp, request.responseTime, request.errorCode, request.ext, request.aliasId);
            }
        }
    }

    public void clearRtcActions(Context context) {
        actionList.clear();
        synchronized (requests) {
            LogUtils.e(TAG, "deleteRequests :" + requests.size());
            BIMRtcTrackDatabase.getInstance(context).deleteRequests(requests);
        }
    }

    public byte[] generateRtcClient(Context context) {
        try {
            putRequestToActions(context);
            LogUtils.w(TAG, "generateRtcClient :" + requests.size());
            if (actionList.size() <= 0) {
                return null;
            }
            return IMPushPb.PushImClient.newBuilder().setCommon(getIMCommon(context)).setSdkName(SDK_NAME).setSdkVersion(RtcConstants.RTC_VERSION).addAllActions(actionList).build().toByteArray();
        } catch (Exception unused) {
            return null;
        }
    }
}
