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
/* loaded from: classes9.dex */
public class IMQuitCastMsg extends Message {
    private static final String TAG = "IMQuitCastMsg";
    private Context mContext;
    private String mMsgKey;
    protected long mRowId;
    private long mToUser;

    public IMQuitCastMsg(Context context, long j, String str) {
        this.mContext = context;
        initCommonParameter(context);
        this.mMsgKey = str;
        this.mToUser = j;
        setNeedReplay(true);
        setType(202);
    }

    public static IMQuitCastMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("mcast_id")) {
            return new IMQuitCastMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 202);
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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x008e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r8, org.json.JSONObject r9, int r10, java.lang.String r11) {
        /*
            r7 = this;
            r4 = -1
            if (r10 != 0) goto L93
            java.lang.String r0 = "msg"
            boolean r0 = r9.has(r0)     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L13
            java.lang.String r0 = "msg"
            r9.getString(r0)     // Catch: java.lang.Exception -> L81
        L13:
            java.lang.String r0 = "mcast_id"
            boolean r0 = r9.has(r0)     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L7b
            java.lang.String r0 = "mcast_id"
            long r4 = r9.getLong(r0)     // Catch: java.lang.Exception -> L81
            r3 = r11
            r2 = r10
        L25:
            r0 = 0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 <= 0) goto L45
            java.lang.String r0 = "IMQuitCastMsg"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L91
            r1.<init>()     // Catch: java.lang.Exception -> L91
            java.lang.String r6 = "quit 直播间，castid信息："
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch: java.lang.Exception -> L91
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Exception -> L91
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L91
            com.baidu.android.imsdk.utils.LogUtils.d(r0, r1)     // Catch: java.lang.Exception -> L91
        L45:
            super.handleMessageResult(r8, r9, r2, r3)
            java.lang.String r0 = "IMQuitCastMsg"
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
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r0 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r0)
            java.lang.String r1 = r7.getListenerKey()
            r0.onQuitCastResult(r1, r2, r3, r4)
            return
        L7b:
            r2 = 1015(0x3f7, float:1.422E-42)
            java.lang.String r3 = "Server error!"
            goto L25
        L81:
            r0 = move-exception
            r3 = r11
            r2 = r10
        L84:
            java.lang.String r1 = "IMQuitCastMsg"
            java.lang.String r6 = "handle IMQuitCastMsg exception :"
            com.baidu.android.imsdk.utils.LogUtils.e(r1, r6, r0)
            goto L45
        L8e:
            r0 = move-exception
            r3 = r11
            goto L84
        L91:
            r0 = move-exception
            goto L84
        L93:
            r3 = r11
            r2 = r10
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.mcast.IMQuitCastMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }
}
