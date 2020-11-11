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
/* loaded from: classes5.dex */
public final class BIMRtcPbGenerator {
    private static final String SDK_NAME = "bim_rtc";
    private static final String TAG = "BIMRtcPbGenerator";
    private static final List<IMPushPb.Action> actionList = new CopyOnWriteArrayList();
    private static final List<Request> requests = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] generateRtcClient(Context context) {
        try {
            putRequestToActions(context);
            LogUtils.w(TAG, "generateRtcClient :" + requests.size());
            if (actionList.size() <= 0) {
                return null;
            }
            return IMPushPb.PushImClient.newBuilder().setCommon(getIMCommon(context)).setSdkName(SDK_NAME).setSdkVersion(RtcConstants.RTC_VERSION).addAllActions(actionList).build().toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    private IMPushPb.Common getIMCommon(Context context) {
        IMPushPb.DeviceID build = IMPushPb.DeviceID.newBuilder().setCuid(RtcUtility.getCuid(context)).build();
        return IMPushPb.Common.newBuilder().setDeviceId(build).setTimestamp(-1L).setUserTimestamp(System.currentTimeMillis()).setTerminalInfo(getTerminalInfo(context)).setNetInfo(getNetInfo(context)).setAppInfo(IMPushPb.AppInfo.newBuilder().setAppName(context.getPackageName()).setAppVersion("" + RtcUtility.getAppVersionName(context)).setAppChannel("").build()).build();
    }

    private IMPushPb.TerminalInfo getTerminalInfo(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                i4 = displayMetrics.widthPixels;
                i3 = displayMetrics.heightPixels;
            } else {
                i3 = displayMetrics.widthPixels;
                i4 = displayMetrics.heightPixels;
            }
            int i6 = displayMetrics.densityDpi;
            i2 = i4;
            i5 = i3;
            i = i6;
        } else {
            i = 0;
            i2 = 0;
        }
        return IMPushPb.TerminalInfo.newBuilder().setOs(IMPushPb.OSType.ANDROID).setOsVersion(Build.VERSION.RELEASE).setManufacturer(Build.MANUFACTURER).setTerminalType(Build.MODEL).setResolutionH(i2).setResolutionV(i5).setPpi(i).build();
    }

    private static IMPushPb.NetInfo getNetInfo(Context context) {
        String str;
        String str2;
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            String str3 = "" + activeNetworkInfo.getTypeName();
            str = "" + activeNetworkInfo.getExtraInfo();
            str2 = str3;
        } else {
            str = "";
            str2 = "";
        }
        return IMPushPb.NetInfo.newBuilder().setNetType(str2).setNetApn(str).build();
    }

    private void putActions(IMPushPb.Action action) {
        actionList.add(action);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearRtcActions(Context context) {
        actionList.clear();
        synchronized (requests) {
            LogUtils.e(TAG, "deleteRequests :" + requests.size());
            BIMRtcTrackDatabase.getInstance(context).deleteRequests(requests);
        }
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

    private void putRequestToAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        putActions(generateRequestAction(str, str2, j, j2, j3, str3, j4));
    }

    private IMPushPb.Action generateRequestAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j).setResponseTime(j2).setErrorCode(j3).setExt(str3).setAliasId(j4).build()).build();
    }
}
