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
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMJoinCastMsg extends Message {
    public static final String TAG = "IMJoinCastMsg";
    public Context mContext;
    public boolean mIsReliable;
    public String mMsgKey;
    public long mRowId;
    public long mToUser;

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
            return new IMJoinCastMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID), intent.getBooleanExtra(Constants.EXTRA_OPT_EXT, false));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 201);
            jSONObject.put("mcast_id", this.mToUser);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            jSONObject.put("msg_key", this.mMsgKey);
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("is_reliable", this.mIsReliable);
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(IMJoinCastMsg.class.getSimpleName(), "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:32:0x00d2
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r16, org.json.JSONObject r17, int r18, java.lang.String r19) {
        /*
            r15 = this;
            r1 = r15
            r2 = r17
            java.lang.String r0 = "ack_enable"
            java.lang.String r3 = "ping_interval"
            java.lang.String r4 = "mcast_id"
            java.lang.String r5 = "msg"
            java.lang.String r6 = "IMJoinCastMsg"
            r7 = -1
            if (r18 != 0) goto Le3
            boolean r9 = r2.has(r5)     // Catch: java.lang.Exception -> Ld4
            if (r9 == 0) goto L1a
            r2.getString(r5)     // Catch: java.lang.Exception -> Ld4
        L1a:
            boolean r5 = r2.has(r4)     // Catch: java.lang.Exception -> Ld4
            if (r5 == 0) goto L3f
            long r7 = r2.getLong(r4)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r4 = "fxf"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld4
            r5.<init>()     // Catch: java.lang.Exception -> Ld4
            java.lang.String r9 = " cast id is"
            r5.append(r9)     // Catch: java.lang.Exception -> Ld4
            r5.append(r7)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> Ld4
            com.baidu.android.imsdk.utils.LogUtils.d(r4, r5)     // Catch: java.lang.Exception -> Ld4
            r4 = r18
            r5 = r19
            goto L43
        L3f:
            r4 = 1015(0x3f7, float:1.422E-42)
            java.lang.String r5 = "Server error!"
        L43:
            boolean r9 = r2.has(r3)     // Catch: java.lang.Exception -> Ld0
            r10 = 60000(0xea60, float:8.4078E-41)
            if (r9 == 0) goto L62
            int r3 = r2.optInt(r3, r10)     // Catch: java.lang.Exception -> Ld0
            if (r3 <= 0) goto L5d
            int r3 = r3 * 1000
            com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT = r3     // Catch: java.lang.Exception -> Ld0
            boolean r9 = d.a.s.a.f68181e     // Catch: java.lang.Exception -> Ld0
            if (r9 == 0) goto L64
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.mCastHeartBeatTime = r3     // Catch: java.lang.Exception -> Ld0
            goto L64
        L5d:
            r3 = 30000(0x7530, float:4.2039E-41)
            com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT = r3     // Catch: java.lang.Exception -> Ld0
            goto L64
        L62:
            com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT = r10     // Catch: java.lang.Exception -> Ld0
        L64:
            android.content.Context r3 = r1.mContext     // Catch: java.lang.Exception -> Ld0
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r3)     // Catch: java.lang.Exception -> Ld0
            int r3 = com.baidu.android.imsdk.internal.Heartbeat.ALARM_TIMEOUT     // Catch: java.lang.Exception -> Ld0
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.resetHeartBeat(r3)     // Catch: java.lang.Exception -> Ld0
            boolean r3 = r2.has(r0)     // Catch: java.lang.Exception -> Ld0
            if (r3 == 0) goto Lb7
            r3 = 0
            int r0 = r2.optInt(r0, r3)     // Catch: java.lang.Exception -> Ld0
            r3 = 1
            if (r0 != r3) goto L9a
            android.content.Context r0 = r1.mContext     // Catch: java.lang.Exception -> Ld0
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r0 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r0)     // Catch: java.lang.Exception -> Ld0
            r0.addAckCastId(r7)     // Catch: java.lang.Exception -> Ld0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld0
            r0.<init>()     // Catch: java.lang.Exception -> Ld0
            java.lang.String r3 = "join 后添加ack cast信息："
            r0.append(r3)     // Catch: java.lang.Exception -> Ld0
            r0.append(r7)     // Catch: java.lang.Exception -> Ld0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Ld0
            com.baidu.android.imsdk.utils.LogUtils.d(r6, r0)     // Catch: java.lang.Exception -> Ld0
            goto Lb7
        L9a:
            android.content.Context r0 = r1.mContext     // Catch: java.lang.Exception -> Ld0
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r0 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r0)     // Catch: java.lang.Exception -> Ld0
            r0.removeAckCastId(r7)     // Catch: java.lang.Exception -> Ld0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld0
            r0.<init>()     // Catch: java.lang.Exception -> Ld0
            java.lang.String r3 = "join后 删除ack cast信息"
            r0.append(r3)     // Catch: java.lang.Exception -> Ld0
            r0.append(r7)     // Catch: java.lang.Exception -> Ld0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Ld0
            com.baidu.android.imsdk.utils.LogUtils.d(r6, r0)     // Catch: java.lang.Exception -> Ld0
        Lb7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld0
            r0.<init>()     // Catch: java.lang.Exception -> Ld0
            java.lang.String r3 = " obj="
            r0.append(r3)     // Catch: java.lang.Exception -> Ld0
            java.lang.String r3 = r17.toString()     // Catch: java.lang.Exception -> Ld0
            r0.append(r3)     // Catch: java.lang.Exception -> Ld0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Ld0
            com.baidu.android.imsdk.utils.LogUtils.d(r6, r0)     // Catch: java.lang.Exception -> Ld0
            goto Lde
        Ld0:
            r0 = move-exception
            goto Ld9
        Ld2:
            r0 = move-exception
            goto Ld7
        Ld4:
            r0 = move-exception
            r4 = r18
        Ld7:
            r5 = r19
        Ld9:
            java.lang.String r3 = "handle IMQuitCastMsg exception :"
            com.baidu.android.imsdk.utils.LogUtils.e(r6, r3, r0)
        Lde:
            r3 = r16
            r11 = r4
            r12 = r5
            goto Le9
        Le3:
            r3 = r16
            r11 = r18
            r12 = r19
        Le9:
            super.handleMessageResult(r3, r2, r11, r12)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "errorCode:"
            r0.append(r2)
            r0.append(r11)
            java.lang.String r2 = "  strMsg"
            r0.append(r2)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r6, r0)
            android.content.Context r0 = r1.mContext
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r9 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r0)
            java.lang.String r10 = r15.getListenerKey()
            r2 = 0
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 <= 0) goto L11a
            r13 = r7
            goto L11d
        L11a:
            long r2 = r1.mToUser
            r13 = r2
        L11d:
            r9.onJoinCastResult(r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.mcast.IMJoinCastMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }

    public IMJoinCastMsg(Context context, long j, String str, boolean z) {
        this(context, j, str);
        this.mIsReliable = z;
    }
}
