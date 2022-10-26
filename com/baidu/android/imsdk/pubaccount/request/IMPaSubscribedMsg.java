package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMPaSubscribedMsg extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public long mPaId;

    public IMPaSubscribedMsg(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        initCommonParameter(context);
        this.mPaId = j;
        setNeedReplay(true);
        setType(109);
    }

    public static IMPaSubscribedMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent.hasExtra(Constants.EXTRA_PA_ID)) {
                return new IMPaSubscribedMsg(context, intent.getLongExtra(Constants.EXTRA_PA_ID, -1L));
            }
            return null;
        }
        return (IMPaSubscribedMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
    }

    public long getPaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mPaId;
        }
        return invokeV.longValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0023
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r9, org.json.JSONObject r10, int r11, java.lang.String r12) {
        /*
            r8 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedMsg.$ic
            if (r0 != 0) goto L56
        L4:
            r0 = 0
            if (r11 != 0) goto L10
            java.lang.String r1 = "is_subscribe"
            boolean r0 = r10.optBoolean(r1)     // Catch: java.lang.Exception -> Le
            goto L42
        Le:
            r1 = move-exception
            goto L25
        L10:
            r1 = 1001(0x3e9, float:1.403E-42)
            if (r1 != r11) goto L42
            com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager r1 = com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager.getInstance(r9)     // Catch: java.lang.Exception -> Le
            long r2 = r8.mPaId     // Catch: java.lang.Exception -> Le
            boolean r11 = r1.isSubscribed(r2)     // Catch: java.lang.Exception -> Le
            java.lang.String r12 = "query from local db"
            r0 = r11
            r11 = 0
            goto L42
        L23:
            r1 = move-exception
            r11 = 0
        L25:
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
            goto L45
        L42:
            r3 = r11
            r4 = r12
            r7 = r0
        L45:
            super.handleMessageResult(r9, r10, r3, r4)
            com.baidu.android.imsdk.pubaccount.PaManagerImpl r1 = com.baidu.android.imsdk.pubaccount.PaManagerImpl.getInstance(r9)
            java.lang.String r2 = r8.getListenerKey()
            long r5 = r8.mPaId
            r1.onIsSubscribedResult(r2, r3, r4, r5, r7)
            return
        L56:
            r6 = r0
            r7 = 1048578(0x100002, float:1.469371E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r6.invokeLLIL(r7, r8, r9, r10, r11, r12)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }
}
