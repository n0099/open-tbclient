package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
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
public class IMJoinCastMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMJoinCastMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public boolean mIsReliable;
    public String mMsgKey;
    public long mRowId;
    public long mToUser;

    public IMJoinCastMsg(Context context, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str};
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
        this.mMsgKey = str;
        this.mToUser = j;
        setNeedReplay(true);
        setType(201);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IMJoinCastMsg(Context context, long j, String str, boolean z) {
        this(context, j, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsReliable = z;
    }

    public static IMJoinCastMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            if (intent.hasExtra("mcast_id")) {
                return new IMJoinCastMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID), intent.getBooleanExtra(Constants.EXTRA_OPT_EXT, false));
            }
            return null;
        }
        return (IMJoinCastMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 201);
                jSONObject.put("mcast_id", this.mToUser);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                jSONObject.put("msg_key", this.mMsgKey);
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("is_reliable", this.mIsReliable);
                this.mBody = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(IMJoinCastMsg.class.getSimpleName(), "Exception ", e);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:31:0x00c3
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r16, org.json.JSONObject r17, int r18, java.lang.String r19) {
        /*
            r15 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.android.imsdk.mcast.IMJoinCastMsg.$ic
            if (r0 != 0) goto L112
        L4:
            r1 = r15
            r2 = r17
            java.lang.String r0 = "ack_enable"
            java.lang.String r3 = "ping_interval"
            java.lang.String r4 = "mcast_id"
            java.lang.String r5 = "msg"
            java.lang.String r6 = "IMJoinCastMsg"
            r7 = -1
            if (r18 != 0) goto Ld4
            boolean r9 = r2.has(r5)     // Catch: java.lang.Exception -> Lc5
            if (r9 == 0) goto L1e
            r2.getString(r5)     // Catch: java.lang.Exception -> Lc5
        L1e:
            boolean r5 = r2.has(r4)     // Catch: java.lang.Exception -> Lc5
            if (r5 == 0) goto L43
            long r7 = r2.getLong(r4)     // Catch: java.lang.Exception -> Lc5
            java.lang.String r4 = "fxf"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc5
            r5.<init>()     // Catch: java.lang.Exception -> Lc5
            java.lang.String r9 = " cast id is"
            r5.append(r9)     // Catch: java.lang.Exception -> Lc5
            r5.append(r7)     // Catch: java.lang.Exception -> Lc5
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> Lc5
            com.baidu.android.imsdk.utils.LogUtils.d(r4, r5)     // Catch: java.lang.Exception -> Lc5
            r4 = r18
            r5 = r19
            goto L47
        L43:
            r4 = 1015(0x3f7, float:1.422E-42)
            java.lang.String r5 = "Server error!"
        L47:
            boolean r9 = r2.has(r3)     // Catch: java.lang.Exception -> Lc1
            if (r9 == 0) goto L5b
            r9 = 60000(0xea60, float:8.4078E-41)
            int r3 = r2.optInt(r3, r9)     // Catch: java.lang.Exception -> Lc1
            if (r3 <= 0) goto L5f
            int r3 = r3 * 1000
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.mCastHeartBeatTime = r3     // Catch: java.lang.Exception -> Lc1
            goto L5f
        L5b:
            r3 = 3000(0xbb8, float:4.204E-42)
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.mCastHeartBeatTime = r3     // Catch: java.lang.Exception -> Lc1
        L5f:
            boolean r3 = r2.has(r0)     // Catch: java.lang.Exception -> Lc1
            if (r3 == 0) goto La8
            r3 = 0
            int r0 = r2.optInt(r0, r3)     // Catch: java.lang.Exception -> Lc1
            r3 = 1
            if (r0 != r3) goto L8b
            android.content.Context r0 = r1.mContext     // Catch: java.lang.Exception -> Lc1
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r0 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r0)     // Catch: java.lang.Exception -> Lc1
            r0.addAckCastId(r7)     // Catch: java.lang.Exception -> Lc1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc1
            r0.<init>()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r3 = "join 后添加ack cast信息："
            r0.append(r3)     // Catch: java.lang.Exception -> Lc1
            r0.append(r7)     // Catch: java.lang.Exception -> Lc1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lc1
            com.baidu.android.imsdk.utils.LogUtils.d(r6, r0)     // Catch: java.lang.Exception -> Lc1
            goto La8
        L8b:
            android.content.Context r0 = r1.mContext     // Catch: java.lang.Exception -> Lc1
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r0 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r0)     // Catch: java.lang.Exception -> Lc1
            r0.removeAckCastId(r7)     // Catch: java.lang.Exception -> Lc1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc1
            r0.<init>()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r3 = "join后 删除ack cast信息"
            r0.append(r3)     // Catch: java.lang.Exception -> Lc1
            r0.append(r7)     // Catch: java.lang.Exception -> Lc1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lc1
            com.baidu.android.imsdk.utils.LogUtils.d(r6, r0)     // Catch: java.lang.Exception -> Lc1
        La8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc1
            r0.<init>()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r3 = " obj="
            r0.append(r3)     // Catch: java.lang.Exception -> Lc1
            java.lang.String r3 = r17.toString()     // Catch: java.lang.Exception -> Lc1
            r0.append(r3)     // Catch: java.lang.Exception -> Lc1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lc1
            com.baidu.android.imsdk.utils.LogUtils.d(r6, r0)     // Catch: java.lang.Exception -> Lc1
            goto Lcf
        Lc1:
            r0 = move-exception
            goto Lca
        Lc3:
            r0 = move-exception
            goto Lc8
        Lc5:
            r0 = move-exception
            r4 = r18
        Lc8:
            r5 = r19
        Lca:
            java.lang.String r3 = "handle IMQuitCastMsg exception :"
            com.baidu.android.imsdk.utils.LogUtils.e(r6, r3, r0)
        Lcf:
            r3 = r16
            r11 = r4
            r12 = r5
            goto Lda
        Ld4:
            r3 = r16
            r11 = r18
            r12 = r19
        Lda:
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
            if (r0 <= 0) goto L10b
            r13 = r7
            goto L10e
        L10b:
            long r2 = r1.mToUser
            r13 = r2
        L10e:
            r9.onJoinCastResult(r10, r11, r12, r13)
            return
        L112:
            r13 = r0
            r14 = 1048577(0x100001, float:1.46937E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r13.invokeLLIL(r14, r15, r16, r17, r18, r19)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.mcast.IMJoinCastMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }
}
