package com.baidu.lcp.sdk.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.android.imsdk.upload.action.CommonUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.lcp.sdk.d.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes14.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] c(Context context, @NonNull IMPushPb.Action action) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(action);
            return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, e.aO(context))).setSdkName("lcp").setSdkVersion(2240016L).addAllActions(arrayList).build().toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] au(Context context) {
        try {
            Set<String> aA = d.aA(context);
            HashSet<String> hashSet = new HashSet(aA);
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (aA.size() <= 4000 && aA.size() >= 1) {
                for (String str : hashSet) {
                    copyOnWriteArrayList.add(IMPushPb.Action.parseFrom(Base64.decode(str, 0)));
                }
            }
            Set<String> az = d.az(context);
            HashSet<String> hashSet2 = new HashSet(az);
            if (az.size() <= 4000 - aA.size() && az.size() >= 1) {
                for (String str2 : hashSet2) {
                    copyOnWriteArrayList.add(IMPushPb.Action.parseFrom(Base64.decode(str2, 0)));
                }
            }
            return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, e.aO(context))).setSdkName("lcp").setSdkVersion(2240016L).addAllActions(copyOnWriteArrayList).build().toByteArray();
        } catch (Exception e) {
            com.baidu.lcp.sdk.d.d.e("TrackPbGenerator", "generateTrackClient :", e);
            return null;
        }
    }

    public static void a(Context context, Connection connection) {
        try {
            HashSet hashSet = new HashSet(d.az(context));
            hashSet.add(Base64.encodeToString(b(connection.startTime, connection.stopTime, connection.reason, connection.retryTime, connection.retryCount, connection.ext, connection.aliasId).toByteArray(), 0));
            d.a(context, hashSet);
        } catch (Exception e) {
            com.baidu.lcp.sdk.d.d.e("TrackPbGenerator", "putIMConnectionToActions :", e);
        }
    }

    private static IMPushPb.Action b(long j, long j2, String str, long j3, long j4, String str2, long j5) {
        return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(j).setStopTime(j2).setReason(str).setRetryTime(j3).setRetryCount(j4).setExt(str2).setAliasId(j5).build()).build();
    }

    public static void a(Context context, Request request) {
        try {
            HashSet hashSet = new HashSet(d.aA(context));
            hashSet.add(Base64.encodeToString(generateRequestAction(request.method, request.requestId, request.timestamp, request.responseTime, request.errorCode, request.ext, request.aliasId).toByteArray(), 0));
            d.b(context, hashSet);
        } catch (Exception e) {
            com.baidu.lcp.sdk.d.d.e("TrackPbGenerator", "putIMRequestToActions :", e);
        }
    }

    private static IMPushPb.Action generateRequestAction(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j).setResponseTime(j2).setErrorCode(j3).setExt(str3).setAliasId(j4).build()).build();
    }
}
