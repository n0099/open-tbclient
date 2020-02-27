package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.sapi2.SapiContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMJoinCastMsg extends Message {
    private static final String TAG = "IMJoinCastMsg";
    private Context mContext;
    private String mMsgKey;
    protected long mRowId;
    private long mToUser;

    public IMJoinCastMsg(Context context, long j, String str) {
        this.mContext = context;
        initCommonParameter(context);
        this.mMsgKey = str;
        this.mToUser = j;
        setNeedReplay(true);
        setType(201);
    }

    public static IMJoinCastMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("mcast_id")) {
            return new IMJoinCastMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 201);
            jSONObject.put("mcast_id", this.mToUser);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            jSONObject.put("msg_key", this.mMsgKey);
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:35:0x00dc
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r8, org.json.JSONObject r9, int r10, java.lang.String r11) {
        /*
            r7 = this;
            r4 = -1
            if (r10 != 0) goto Ldf
            r0 = 1
            com.baidu.android.imsdk.mcast.McastConfig.mLiveShowing = r0     // Catch: java.lang.Exception -> Ld8
            java.lang.String r0 = "msg"
            boolean r0 = r9.has(r0)     // Catch: java.lang.Exception -> Ld8
            if (r0 == 0) goto L16
            java.lang.String r0 = "msg"
            r9.getString(r0)     // Catch: java.lang.Exception -> Ld8
        L16:
            java.lang.String r0 = "mcast_id"
            boolean r0 = r9.has(r0)     // Catch: java.lang.Exception -> Ld8
            if (r0 == 0) goto Lbc
            java.lang.String r0 = "mcast_id"
            long r4 = r9.getLong(r0)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r0 = "fxf"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld8
            r1.<init>()     // Catch: java.lang.Exception -> Ld8
            java.lang.String r2 = " cast id is"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> Ld8
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Ld8
            com.baidu.android.imsdk.utils.LogUtils.d(r0, r1)     // Catch: java.lang.Exception -> Ld8
            r3 = r11
            r2 = r10
        L42:
            java.lang.String r0 = "ping_interval"
            boolean r0 = r9.has(r0)     // Catch: java.lang.Exception -> Lc7
            if (r0 == 0) goto Ld2
            java.lang.String r0 = "ping_interval"
            r1 = 60000(0xea60, float:8.4078E-41)
            int r0 = r9.optInt(r0, r1)     // Catch: java.lang.Exception -> Lc7
            if (r0 <= 0) goto Lc2
            int r1 = r0 * 1000
            com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT = r1     // Catch: java.lang.Exception -> Lc7
            boolean r1 = com.baidu.imsdk.IMService.isSmallFlow     // Catch: java.lang.Exception -> Lc7
            if (r1 == 0) goto L61
            com.baidu.android.imsdk.mcast.McastManagerImpl.mCastHeartBeatTime = r0     // Catch: java.lang.Exception -> Lc7
        L61:
            android.content.Context r0 = r7.mContext     // Catch: java.lang.Exception -> Lc7
            com.baidu.android.imsdk.mcast.McastManagerImpl.getInstance(r0)     // Catch: java.lang.Exception -> Lc7
            int r0 = com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT     // Catch: java.lang.Exception -> Lc7
            com.baidu.android.imsdk.mcast.McastManagerImpl.resetHeartBeat(r0)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r0 = "IMJoinCastMsg"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc7
            r1.<init>()     // Catch: java.lang.Exception -> Lc7
            java.lang.String r6 = " obj="
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r6 = r9.toString()     // Catch: java.lang.Exception -> Lc7
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Lc7
            com.baidu.android.imsdk.utils.LogUtils.d(r0, r1)     // Catch: java.lang.Exception -> Lc7
        L89:
            java.lang.String r0 = "IMJoinCastMsg"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "errorCode:"
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r6 = "  strMsg"
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r0, r1)
            android.content.Context r0 = r7.mContext
            com.baidu.android.imsdk.mcast.McastManagerImpl r0 = com.baidu.android.imsdk.mcast.McastManagerImpl.getInstance(r0)
            java.lang.String r1 = r7.getListenerKey()
            r0.onJoinCastResult(r1, r2, r3, r4)
            return
        Lbc:
            r2 = 1015(0x3f7, float:1.422E-42)
            java.lang.String r3 = "Server error!"
            goto L42
        Lc2:
            r0 = 30000(0x7530, float:4.2039E-41)
            com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT = r0     // Catch: java.lang.Exception -> Lc7
            goto L61
        Lc7:
            r0 = move-exception
        Lc8:
            java.lang.String r1 = "IMJoinCastMsg"
            java.lang.String r6 = "handle IMQuitCastMsg exception :"
            com.baidu.android.imsdk.utils.LogUtils.e(r1, r6, r0)
            goto L89
        Ld2:
            r0 = 60000(0xea60, float:8.4078E-41)
            com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT = r0     // Catch: java.lang.Exception -> Lc7
            goto L61
        Ld8:
            r0 = move-exception
            r3 = r11
            r2 = r10
            goto Lc8
        Ldc:
            r0 = move-exception
            r3 = r11
            goto Lc8
        Ldf:
            r3 = r11
            r2 = r10
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.mcast.IMJoinCastMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }
}
