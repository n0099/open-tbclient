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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSendQuizOptMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSendQuizOptMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public int mAnsWer;
    public long mCastId;
    public Context mContext;
    public int mGroup;
    public int mOpCode;
    public String mOptExt;
    public int mQuizId;
    public long mRoomId;
    public long mUid;

    public IMSendQuizOptMsg(Context context, long j, long j2, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        initCommonParameter(context);
        this.mListenerKey = str2;
        this.mCastId = j;
        this.mRoomId = j2;
        this.mOpCode = i;
        this.mOptExt = str;
        setListenerKey(str2);
        setNeedReplay(true);
        setType(210);
    }

    public static IMSendQuizOptMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent.hasExtra("mcast_id")) {
                return new IMSendQuizOptMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getLongExtra("room_id", -1L), intent.getIntExtra(Constants.EXTRA_OPT_CODE, -1), intent.getStringExtra(Constants.EXTRA_OPT_EXT), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
            return null;
        }
        return (IMSendQuizOptMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 210);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                long j = 0;
                try {
                    j = Long.parseLong(Utility.readUid(this.mContext));
                } catch (Exception e) {
                    LogUtils.e(TAG, "bd uid is null");
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                }
                jSONObject.put("bd_uid", j);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                jSONObject.put("mcast_id", this.mCastId);
                jSONObject.put("room_id", this.mRoomId);
                jSONObject.put("op_code", this.mOpCode);
                jSONObject.put("op_ext", this.mOptExt);
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                this.mBody = jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x0030
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r17, org.json.JSONObject r18, int r19, java.lang.String r20) {
        /*
            r16 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.android.imsdk.mcast.IMSendQuizOptMsg.$ic
            if (r0 != 0) goto L77
        L4:
            r1 = r16
            r2 = r18
            java.lang.String r0 = "mcast_id"
            java.lang.String r3 = "msg"
            java.lang.String r4 = "IMSendQuizOptMsg"
            r5 = -1
            if (r19 != 0) goto L41
            boolean r7 = r2.has(r3)     // Catch: java.lang.Exception -> L32
            if (r7 == 0) goto L1b
            r2.getString(r3)     // Catch: java.lang.Exception -> L32
        L1b:
            boolean r3 = r2.has(r0)     // Catch: java.lang.Exception -> L32
            if (r3 == 0) goto L2a
            long r5 = r2.getLong(r0)     // Catch: java.lang.Exception -> L32
            r3 = r19
            r0 = r20
            goto L2e
        L2a:
            r3 = 1015(0x3f7, float:1.422E-42)
            java.lang.String r0 = "Server error!"
        L2e:
            r11 = r0
            goto L3c
        L30:
            r0 = move-exception
            goto L35
        L32:
            r0 = move-exception
            r3 = r19
        L35:
            java.lang.String r7 = "handle sendQuizOptMsg exception :"
            com.baidu.android.imsdk.utils.LogUtils.e(r4, r7, r0)
            r11 = r20
        L3c:
            r10 = r3
            r12 = r5
            r3 = r17
            goto L48
        L41:
            r3 = r17
            r10 = r19
            r11 = r20
            r12 = r5
        L48:
            super.handleMessageResult(r3, r2, r10, r11)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "errorCode:"
            r0.append(r2)
            r0.append(r10)
            java.lang.String r2 = "  strMsg"
            r0.append(r2)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r4, r0)
            android.content.Context r0 = r1.mContext
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r8 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r0)
            java.lang.String r9 = r16.getListenerKey()
            long r14 = r1.mRoomId
            r8.onSendQuizOptsResult(r9, r10, r11, r12, r14)
            return
        L77:
            r14 = r0
            r15 = 1048577(0x100001, float:1.46937E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r14.invokeLLIL(r15, r16, r17, r18, r19, r20)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.mcast.IMSendQuizOptMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }
}
