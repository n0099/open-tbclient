package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class IMPbGenerator {
    private static final String SDK_NAME = "im";
    private static final List<IMPushPb.Action> actionList = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] generateInitIMClient(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(generateRequestAction("init", "", System.currentTimeMillis(), -1L, -1L, "", 501100L));
            return IMPushPb.PushImClient.newBuilder().setCommon(getIMCommon(context)).setSdkName("im").setSdkVersion(IMConfigInternal.getInstance().getSDKVersionValue(context)).addAllActions(arrayList).build().toByteArray();
        } catch (Exception e) {
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] generateIMClient(Context context) {
        try {
            clearIMActions();
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
        } catch (Exception e) {
            IMTrackDatabase.getInstance(context).clearAllTables();
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            return null;
        }
    }

    private IMPushPb.Common getIMCommon(Context context) {
        IMPushPb.DeviceID build = IMPushPb.DeviceID.newBuilder().setCuid(Utility.getDeviceId(context)).build();
        return IMPushPb.Common.newBuilder().setDeviceId(build).setTimestamp(-1L).setUserTimestamp(System.currentTimeMillis()).setTerminalInfo(getTerminalInfo(context)).setNetInfo(getNetInfo(context)).setAppInfo(IMPushPb.AppInfo.newBuilder().setAppName(context.getPackageName()).setAppVersion("" + Utility.getAppVersionName(context)).setAppChannel("").build()).build();
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

    private void putIMActions(IMPushPb.Action action) {
        actionList.add(action);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearIMActions() {
        actionList.clear();
    }

    private void putIMUiToActions(Context context) {
        for (Ui ui : IMTrackDatabase.getInstance(context).getUis()) {
            putIMUiToAction(ui.category, ui.page, ui.startTime, ui.endTime, ui.duration, ui.ext, ui.aliasId);
        }
    }

    private void putIMUiToAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.UI).setUi(IMPushPb.Ui.newBuilder().setCategory(str).setPage(str2).setStartTime(j).setEndTime(j2).setDuration(j3).setExt(str3).setAliasId(j4).build()).build());
    }

    private void putIMCrashToActions(Context context) {
        for (Crash crash : IMTrackDatabase.getInstance(context).getCrashes()) {
            putIMCrashToActions(crash.timestamp, crash.exception, crash.ext, crash.aliasId);
        }
    }

    private void putIMCrashToActions(long j, String str, String str2, long j2) {
        putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CRASH).setCrash(IMPushPb.Crash.newBuilder().setTimestamp(j).setException(str).setExt(str2).setAliasId(j2).build()).build());
    }

    private void putIMDbToActions(Context context) {
        for (Db db : IMTrackDatabase.getInstance(context).getDbs()) {
            putIMDbToAction(db.table, db.className, db.method, db.action, db.startTime, db.endTime, db.duration, db.ext, db.aliasId);
        }
    }

    private void putIMDbToAction(String str, String str2, String str3, String str4, long j, long j2, long j3, String str5, long j4) {
        putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.DB).setDb(IMPushPb.Db.newBuilder().setTable(str).setClassName(str2).setMethod(str3).setAction(str4).setStartTime(j).setEndTime(j2).setDuration(j3).setExt(str5).setAliasId(j4).build()).build());
    }

    private void putIMConnectionToActions(Context context) {
        for (Connection connection : IMTrackDatabase.getInstance(context).getConnections()) {
            putIMConnectionToActions(connection.startTime, connection.stopTime, connection.reason, connection.retryTime, connection.retryCount, connection.ext, connection.aliasId);
        }
    }

    private void putIMConnectionToActions(long j, long j2, String str, long j3, long j4, String str2, long j5) {
        putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(j).setStopTime(j2).setReason(str).setRetryTime(j3).setRetryCount(j4).setExt(str2).setAliasId(j5).build()).build());
    }

    private void putIMRequestToActions(Context context) {
        for (Request request : IMTrackDatabase.getInstance(context).getRequests()) {
            putIMRequestToAction(request.method, request.requestId, request.timestamp, request.responseTime, request.errorCode, request.ext, request.aliasId);
        }
    }

    private void putIMRequestToAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        putIMActions(generateRequestAction(str, str2, j, j2, j3, str3, j4));
    }

    private IMPushPb.Action generateRequestAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j).setResponseTime(j2).setErrorCode(j3).setExt(str3).setAliasId(j4).build()).build();
    }

    private void putIMAckToActions(Context context) {
        for (Ack ack : IMTrackDatabase.getInstance(context).getAcks()) {
            putIMAckToActions(ack.type, ack.value, ack.timestamp, ack.ext, ack.aliasId);
        }
    }

    private void putIMAckToActions(String str, String str2, long j, String str3, long j2) {
        putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.ACK).setAck(IMPushPb.Ack.newBuilder().setType(str).setValue(str2).setTimestamp(j).setExt(str3).setAliasId(j2).build()).build());
    }

    private void putIMMsgToActions(Context context) {
        for (Msg msg : IMTrackDatabase.getInstance(context).getMsgs()) {
            putIMMsgToActions(msg.msgCount, msg.roomId, msg.duration, msg.startMsgId, msg.endMsgId, msg.ext, msg.aliasId);
        }
    }

    private void putIMMsgToActions(long j, String str, long j2, long j3, long j4, String str2, long j5) {
        putIMActions(IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.MSG).setMsg(IMPushPb.Msg.newBuilder().setMsgCount(j).setRoomId(str).setDuration(j2).setStartMsgid(j3).setEndMsgid(j4).setExt(str2).setAliasId(j5).build()).build());
    }
}
