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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:33:0x00a9
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(android.content.Context r16, org.json.JSONObject r17, int r18, java.lang.String r19) {
        /*
            r15 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.android.imsdk.mcast.IMJoinCastMsg.$ic
            if (r0 != 0) goto Lf8
        L4:
            r1 = r15
            r2 = r17
            java.lang.String r0 = "ack_enable"
            java.lang.String r3 = "ping_interval"
            java.lang.String r4 = "mcast_id"
            java.lang.String r5 = "msg"
            java.lang.String r6 = "IMJoinCastMsg"
            r7 = -1
            if (r18 != 0) goto Lba
            boolean r9 = r2.has(r5)     // Catch: java.lang.Exception -> Lab
            if (r9 == 0) goto L1e
            r2.getString(r5)     // Catch: java.lang.Exception -> Lab
        L1e:
            boolean r5 = r2.has(r4)     // Catch: java.lang.Exception -> Lab
            if (r5 == 0) goto L47
            long r4 = r2.getLong(r4)     // Catch: java.lang.Exception -> Lab
            java.lang.String r7 = "fxf"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L44
            r8.<init>()     // Catch: java.lang.Exception -> L44
            java.lang.String r9 = " cast id is"
            r8.append(r9)     // Catch: java.lang.Exception -> L44
            r8.append(r4)     // Catch: java.lang.Exception -> L44
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L44
            com.baidu.android.imsdk.utils.LogUtils.d(r7, r8)     // Catch: java.lang.Exception -> L44
            r7 = r4
            r4 = r18
            r5 = r19
            goto L4b
        L44:
            r0 = move-exception
            r7 = r4
            goto Lac
        L47:
            r4 = 1015(0x3f7, float:1.422E-42)
            java.lang.String r5 = "Server error!"
        L4b:
            boolean r9 = r2.has(r3)     // Catch: java.lang.Exception -> La7
            if (r9 == 0) goto L5f
            r9 = 60000(0xea60, float:8.4078E-41)
            int r3 = r2.optInt(r3, r9)     // Catch: java.lang.Exception -> La7
            if (r3 <= 0) goto L63
            int r3 = r3 * 1000
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.mCastHeartBeatTime = r3     // Catch: java.lang.Exception -> La7
            goto L63
        L5f:
            r3 = 3000(0xbb8, float:4.204E-42)
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl.mCastHeartBeatTime = r3     // Catch: java.lang.Exception -> La7
        L63:
            boolean r3 = r2.has(r0)     // Catch: java.lang.Exception -> La7
            if (r3 == 0) goto L8e
            r3 = 0
            int r0 = r2.optInt(r0, r3)     // Catch: java.lang.Exception -> La7
            r3 = 1
            if (r0 != r3) goto L8e
            android.content.Context r0 = r1.mContext     // Catch: java.lang.Exception -> La7
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r0 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r0)     // Catch: java.lang.Exception -> La7
            r0.needAck(r3)     // Catch: java.lang.Exception -> La7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La7
            r0.<init>()     // Catch: java.lang.Exception -> La7
            java.lang.String r3 = "join 后添加ack cast信息："
            r0.append(r3)     // Catch: java.lang.Exception -> La7
            r0.append(r7)     // Catch: java.lang.Exception -> La7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> La7
            com.baidu.android.imsdk.utils.LogUtils.d(r6, r0)     // Catch: java.lang.Exception -> La7
        L8e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La7
            r0.<init>()     // Catch: java.lang.Exception -> La7
            java.lang.String r3 = " obj="
            r0.append(r3)     // Catch: java.lang.Exception -> La7
            java.lang.String r3 = r17.toString()     // Catch: java.lang.Exception -> La7
            r0.append(r3)     // Catch: java.lang.Exception -> La7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> La7
            com.baidu.android.imsdk.utils.LogUtils.d(r6, r0)     // Catch: java.lang.Exception -> La7
            goto Lb5
        La7:
            r0 = move-exception
            goto Lb0
        La9:
            r0 = move-exception
            goto Lae
        Lab:
            r0 = move-exception
        Lac:
            r4 = r18
        Lae:
            r5 = r19
        Lb0:
            java.lang.String r3 = "handle IMQuitCastMsg exception :"
            com.baidu.android.imsdk.utils.LogUtils.e(r6, r3, r0)
        Lb5:
            r3 = r16
            r11 = r4
            r12 = r5
            goto Lc0
        Lba:
            r3 = r16
            r11 = r18
            r12 = r19
        Lc0:
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
            if (r0 <= 0) goto Lf1
            r13 = r7
            goto Lf4
        Lf1:
            long r2 = r1.mToUser
            r13 = r2
        Lf4:
            r9.onJoinCastResult(r10, r11, r12, r13)
            return
        Lf8:
            r13 = r0
            r14 = 1048577(0x100001, float:1.46937E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r13.invokeLLIL(r14, r15, r16, r17, r18, r19)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.mcast.IMJoinCastMsg.handleMessageResult(android.content.Context, org.json.JSONObject, int, java.lang.String):void");
    }
}
