package com.baidu.lcp.sdk.a;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.CommonUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.lcp.sdk.d.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] c(Context context, @NonNull IMPushPb.Action action) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(action);
            return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, e.aL(context))).setSdkName("lcp").setSdkVersion(2240016L).addAllActions(arrayList).build().toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] ar(Context context) {
        try {
            Set<String> ax = d.ax(context);
            HashSet<String> hashSet = new HashSet(ax);
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (ax.size() <= 4000 && ax.size() >= 1) {
                for (String str : hashSet) {
                    copyOnWriteArrayList.add(IMPushPb.Action.parseFrom(Base64.decode(str, 0)));
                }
            }
            Set<String> aw = d.aw(context);
            HashSet<String> hashSet2 = new HashSet(aw);
            if (aw.size() <= 4000 - ax.size() && aw.size() >= 1) {
                for (String str2 : hashSet2) {
                    copyOnWriteArrayList.add(IMPushPb.Action.parseFrom(Base64.decode(str2, 0)));
                }
            }
            return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, e.aL(context))).setSdkName("lcp").setSdkVersion(2240016L).addAllActions(copyOnWriteArrayList).build().toByteArray();
        } catch (Exception e) {
            com.baidu.lcp.sdk.d.d.e("TrackPbGenerator", "generateTrackClient :", e);
            return null;
        }
    }

    public static void a(Context context, Connection connection) {
        try {
            HashSet hashSet = new HashSet(d.aw(context));
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
            HashSet hashSet = new HashSet(d.ax(context));
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
