package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMPaSubscribedMsg extends Message {
    private Context mContext;
    private long mPaId;

    public IMPaSubscribedMsg(Context context, long j) {
        this.mContext = context;
        initCommonParameter(context);
        this.mPaId = j;
        setNeedReplay(true);
        setType(109);
    }

    public long getPaId() {
        return this.mPaId;
    }

    public static IMPaSubscribedMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_PA_ID)) {
            return new IMPaSubscribedMsg(context, intent.getLongExtra(Constants.EXTRA_PA_ID, -1L));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 109);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("pa_uid", this.mPaId);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x004d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r8, org.json.JSONObject r9, int r10, java.lang.String r11) throws org.json.JSONException {
        /*
            r7 = this;
            r1 = 0
            if (r10 != 0) goto L1b
            java.lang.String r0 = "is_subscribe"
            boolean r0 = r9.optBoolean(r0)     // Catch: java.lang.Exception -> L2e
        La:
            r6 = r0
            r3 = r11
            r2 = r10
        Ld:
            com.baidu.android.imsdk.pubaccount.PaManagerImpl r0 = com.baidu.android.imsdk.pubaccount.PaManagerImpl.getInstance(r8)
            java.lang.String r1 = r7.getListenerKey()
            long r4 = r7.mPaId
            r0.onIsSubscribedResult(r1, r2, r3, r4, r6)
            return
        L1b:
            r0 = 1001(0x3e9, float:1.403E-42)
            if (r0 != r10) goto L50
            com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager r0 = com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.getInstance(r8)     // Catch: java.lang.Exception -> L2e
            long r2 = r7.mPaId     // Catch: java.lang.Exception -> L2e
            boolean r0 = r0.isSubscribed(r2)     // Catch: java.lang.Exception -> L2e
            java.lang.String r11 = "query from local db"
            r10 = r1
            goto La
        L2e:
            r0 = move-exception
            r2 = r10
        L30:
            java.lang.String r3 = com.baidu.android.imsdk.utils.LogUtils.TAG
            java.lang.String r4 = "handleMessageResult:"
            com.baidu.android.imsdk.utils.LogUtils.e(r3, r4, r0)
            com.baidu.android.imsdk.upload.action.IMTrack$CrashBuilder r3 = new com.baidu.android.imsdk.upload.action.IMTrack$CrashBuilder
            android.content.Context r4 = r7.mContext
            r3.<init>(r4)
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            com.baidu.android.imsdk.upload.action.IMTrack$CrashBuilder r0 = r3.exception(r0)
            r0.build()
            r6 = r1
            r3 = r11
            goto Ld
        L4d:
            r0 = move-exception
            r2 = r1
            goto L30
        L50:
            r0 = r1
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }
}
