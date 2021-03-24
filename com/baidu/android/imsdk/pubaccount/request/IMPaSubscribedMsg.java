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
    public Context mContext;
    public long mPaId;

    public IMPaSubscribedMsg(Context context, long j) {
        this.mContext = context;
        initCommonParameter(context);
        this.mPaId = j;
        setNeedReplay(true);
        setType(109);
    }

    public static IMPaSubscribedMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_PA_ID)) {
            return new IMPaSubscribedMsg(context, intent.getLongExtra(Constants.EXTRA_PA_ID, -1L));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 109);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("pa_uid", this.mPaId);
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    public long getPaId() {
        return this.mPaId;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x001f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r9, org.json.JSONObject r10, int r11, java.lang.String r12) {
        /*
            r8 = this;
            r0 = 0
            if (r11 != 0) goto Lc
            java.lang.String r1 = "is_subscribe"
            boolean r0 = r10.optBoolean(r1)     // Catch: java.lang.Exception -> La
            goto L3e
        La:
            r1 = move-exception
            goto L21
        Lc:
            r1 = 1001(0x3e9, float:1.403E-42)
            if (r1 != r11) goto L3e
            com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager r1 = com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.getInstance(r9)     // Catch: java.lang.Exception -> La
            long r2 = r8.mPaId     // Catch: java.lang.Exception -> La
            boolean r11 = r1.isSubscribed(r2)     // Catch: java.lang.Exception -> La
            java.lang.String r12 = "query from local db"
            r0 = r11
            r11 = 0
            goto L3e
        L1f:
            r1 = move-exception
            r11 = 0
        L21:
            java.lang.String r2 = com.baidu.android.imsdk.utils.LogUtils.TAG
            java.lang.String r3 = "handleMessageResult:"
            com.baidu.android.imsdk.utils.LogUtils.e(r2, r3, r1)
            com.baidu.android.imsdk.upload.action.IMTrack$CrashBuilder r2 = new com.baidu.android.imsdk.upload.action.IMTrack$CrashBuilder
            android.content.Context r3 = r8.mContext
            r2.<init>(r3)
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            com.baidu.android.imsdk.upload.action.IMTrack$CrashBuilder r1 = r2.exception(r1)
            r1.build()
            r3 = r11
            r4 = r12
            r7 = 0
            goto L41
        L3e:
            r3 = r11
            r4 = r12
            r7 = r0
        L41:
            super.handleMessageResult(r9, r10, r3, r4)
            com.baidu.android.imsdk.pubaccount.PaManagerImpl r1 = com.baidu.android.imsdk.pubaccount.PaManagerImpl.getInstance(r9)
            java.lang.String r2 = r8.getListenerKey()
            long r5 = r8.mPaId
            r1.onIsSubscribedResult(r2, r3, r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }
}
