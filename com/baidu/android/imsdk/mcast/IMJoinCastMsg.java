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
    private boolean mIsReliable;
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

    public IMJoinCastMsg(Context context, long j, String str, boolean z) {
        this(context, j, str);
        this.mIsReliable = z;
    }

    public static IMJoinCastMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("mcast_id")) {
            return new IMJoinCastMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID), intent.getBooleanExtra(Constants.EXTRA_OPT_EXT, false));
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
            jSONObject.put("is_reliable", this.mIsReliable);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:44:0x0148
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r9, org.json.JSONObject r10, int r11, java.lang.String r12) {
        /*
            r8 = this;
            r0 = -1
            if (r11 != 0) goto L14b
            java.lang.String r2 = "msg"
            boolean r2 = r10.has(r2)     // Catch: java.lang.Exception -> L144
            if (r2 == 0) goto L13
            java.lang.String r2 = "msg"
            r10.getString(r2)     // Catch: java.lang.Exception -> L144
        L13:
            java.lang.String r2 = "mcast_id"
            boolean r2 = r10.has(r2)     // Catch: java.lang.Exception -> L144
            if (r2 == 0) goto Lfc
            java.lang.String r2 = "mcast_id"
            long r0 = r10.getLong(r2)     // Catch: java.lang.Exception -> L144
            java.lang.String r2 = "fxf"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L144
            r3.<init>()     // Catch: java.lang.Exception -> L144
            java.lang.String r4 = " cast id is"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Exception -> L144
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch: java.lang.Exception -> L144
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L144
            com.baidu.android.imsdk.utils.LogUtils.d(r2, r3)     // Catch: java.lang.Exception -> L144
            r3 = r12
            r2 = r11
        L3f:
            java.lang.String r4 = "ping_interval"
            boolean r4 = r10.has(r4)     // Catch: java.lang.Exception -> L109
            if (r4 == 0) goto L115
            java.lang.String r4 = "ping_interval"
            r5 = 60000(0xea60, float:8.4078E-41)
            int r4 = r10.optInt(r4, r5)     // Catch: java.lang.Exception -> L109
            if (r4 <= 0) goto L103
            int r5 = r4 * 1000
            com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT = r5     // Catch: java.lang.Exception -> L109
            boolean r5 = com.baidu.g.a.avG     // Catch: java.lang.Exception -> L109
            if (r5 == 0) goto L60
            int r4 = r4 * 1000
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.mCastHeartBeatTime = r4     // Catch: java.lang.Exception -> L109
        L60:
            android.content.Context r4 = r8.mContext     // Catch: java.lang.Exception -> L109
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r4)     // Catch: java.lang.Exception -> L109
            int r4 = com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT     // Catch: java.lang.Exception -> L109
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.resetHeartBeat(r4)     // Catch: java.lang.Exception -> L109
            java.lang.String r4 = "ack_enable"
            boolean r4 = r10.has(r4)     // Catch: java.lang.Exception -> L109
            if (r4 == 0) goto La1
            java.lang.String r4 = "ack_enable"
            r5 = 0
            int r4 = r10.optInt(r4, r5)     // Catch: java.lang.Exception -> L109
            r5 = 1
            if (r4 != r5) goto L11c
            android.content.Context r4 = r8.mContext     // Catch: java.lang.Exception -> L109
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r4 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r4)     // Catch: java.lang.Exception -> L109
            r4.addAckCastId(r0)     // Catch: java.lang.Exception -> L109
            java.lang.String r4 = "IMJoinCastMsg"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r5.<init>()     // Catch: java.lang.Exception -> L109
            java.lang.String r6 = "join 后添加ack cast信息："
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Exception -> L109
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch: java.lang.Exception -> L109
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L109
            com.baidu.android.imsdk.utils.LogUtils.d(r4, r5)     // Catch: java.lang.Exception -> L109
        La1:
            java.lang.String r4 = "IMJoinCastMsg"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r5.<init>()     // Catch: java.lang.Exception -> L109
            java.lang.String r6 = " obj="
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Exception -> L109
            java.lang.String r6 = r10.toString()     // Catch: java.lang.Exception -> L109
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Exception -> L109
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L109
            com.baidu.android.imsdk.utils.LogUtils.d(r4, r5)     // Catch: java.lang.Exception -> L109
            r4 = r0
        Lc0:
            super.handleMessageResult(r9, r10, r2, r3)
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
            android.content.Context r0 = r8.mContext
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r0 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r0)
            java.lang.String r1 = r8.getListenerKey()
            r6 = 0
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L141
        Lf8:
            r0.onJoinCastResult(r1, r2, r3, r4)
            return
        Lfc:
            r2 = 1015(0x3f7, float:1.422E-42)
            java.lang.String r3 = "Server error!"
            goto L3f
        L103:
            r4 = 30000(0x7530, float:4.2039E-41)
            com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT = r4     // Catch: java.lang.Exception -> L109
            goto L60
        L109:
            r4 = move-exception
        L10a:
            java.lang.String r5 = "IMJoinCastMsg"
            java.lang.String r6 = "handle IMQuitCastMsg exception :"
            com.baidu.android.imsdk.utils.LogUtils.e(r5, r6, r4)
            r4 = r0
            goto Lc0
        L115:
            r4 = 60000(0xea60, float:8.4078E-41)
            com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT = r4     // Catch: java.lang.Exception -> L109
            goto L60
        L11c:
            android.content.Context r4 = r8.mContext     // Catch: java.lang.Exception -> L109
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r4 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r4)     // Catch: java.lang.Exception -> L109
            r4.removeAckCastId(r0)     // Catch: java.lang.Exception -> L109
            java.lang.String r4 = "IMJoinCastMsg"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r5.<init>()     // Catch: java.lang.Exception -> L109
            java.lang.String r6 = "join后 删除ack cast信息"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Exception -> L109
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch: java.lang.Exception -> L109
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L109
            com.baidu.android.imsdk.utils.LogUtils.d(r4, r5)     // Catch: java.lang.Exception -> L109
            goto La1
        L141:
            long r4 = r8.mToUser
            goto Lf8
        L144:
            r4 = move-exception
            r3 = r12
            r2 = r11
            goto L10a
        L148:
            r4 = move-exception
            r3 = r12
            goto L10a
        L14b:
            r4 = r0
            r3 = r12
            r2 = r11
            goto Lc0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.mcast.IMJoinCastMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }
}
