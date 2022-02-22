package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class IMMediaGetChatSessionRequest extends IMMediaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_FETCH_COUNT = 20;
    public static final String TAG = "IMMediaGetChatSessionRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mContacter;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public int mCount;
    public long mEndTime;
    public String mKey;
    public int mNeedTop;

    public IMMediaGetChatSessionRequest(Context context, long j2, int i2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mNeedTop = -1;
        this.mContext = context;
        this.mContacter = j2;
        this.mCount = i2;
        this.mEndTime = j3;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/3.0/im/fetch_session";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                putCommonParams(jSONObject);
                if (this.mContacter > 0) {
                    if (this.mContactorType == 2) {
                        jSONObject.put("contacter_im_uk", this.mContacter);
                    } else {
                        jSONObject.put("contacter", Utility.transBDUID(String.valueOf(this.mContacter)));
                    }
                }
                if (this.mEndTime > 0) {
                    jSONObject.put("end_time", this.mEndTime);
                }
                if (this.mContactorType >= 0) {
                    jSONObject.put("contacter_type", this.mContactorType);
                }
                if (this.mContactorPauid > 0) {
                    jSONObject.put("contacter_pa_uid", this.mContactorPauid);
                }
                if (!TextUtils.isEmpty(this.mContactorThirdid)) {
                    jSONObject.put("contacter_third_id", this.mContactorThirdid);
                }
                jSONObject.put("need_top", this.mNeedTop);
                int i2 = 20;
                if (this.mCount <= 20) {
                    i2 = this.mCount;
                }
                jSONObject.put("count", i2);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
            ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(((Integer) transErrorCode.first).intValue(), false, 0, 0, null, null, null, this.mKey);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:100:0x022a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int r40, byte[] r41) {
        /*
            r39 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.android.imsdk.chatmessage.request.IMMediaGetChatSessionRequest.$ic
            if (r0 != 0) goto L288
        L4:
            r1 = r39
            java.lang.String r0 = new java.lang.String
            r2 = r41
            r0.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onSuccess resultContent = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "IMMediaGetChatSessionRequest"
            com.baidu.android.imsdk.utils.LogUtils.d(r3, r2)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L265
            r5.<init>(r0)     // Catch: org.json.JSONException -> L265
            java.lang.String r0 = "error_code"
            int r6 = r5.optInt(r0, r4)     // Catch: org.json.JSONException -> L265
            if (r6 != 0) goto L25d
            java.lang.String r0 = "has_more"
            int r7 = r5.optInt(r0, r4)     // Catch: org.json.JSONException -> L265
            java.lang.String r0 = "total_unread_num"
            int r8 = r5.optInt(r0, r4)     // Catch: org.json.JSONException -> L259
            java.lang.String r0 = "top_has_more"
            int r12 = r5.optInt(r0)     // Catch: org.json.JSONException -> L253
            java.lang.String r0 = "sessions"
            org.json.JSONArray r5 = r5.optJSONArray(r0)     // Catch: org.json.JSONException -> L24b
            if (r5 == 0) goto L23c
            r13 = 0
        L5b:
            int r0 = r5.length()     // Catch: org.json.JSONException -> L24b
            if (r13 >= r0) goto L23c
            org.json.JSONObject r14 = r5.getJSONObject(r13)     // Catch: org.json.JSONException -> L24b
            java.lang.String r0 = "chat_type"
            int r15 = r14.optInt(r0)     // Catch: org.json.JSONException -> L24b
            java.lang.String r0 = "contacter_pass_uk"
            java.lang.String r0 = r14.optString(r0)     // Catch: org.json.JSONException -> L24b
            r16 = 0
            java.lang.String r0 = com.baidu.android.imsdk.utils.Utility.transBDUK(r0)     // Catch: org.json.JSONException -> L7c java.lang.NumberFormatException -> L7f
            long r18 = java.lang.Long.parseLong(r0)     // Catch: org.json.JSONException -> L7c java.lang.NumberFormatException -> L7f
            goto L89
        L7c:
            r0 = move-exception
            goto L269
        L7f:
            r0 = move-exception
            java.lang.String r2 = com.baidu.android.imsdk.utils.LogUtils.TAG     // Catch: org.json.JSONException -> L24b
            java.lang.String r4 = "IMMediaGetChatSessionRequest NumberFormatException"
            com.baidu.android.imsdk.utils.LogUtils.e(r2, r4, r0)     // Catch: org.json.JSONException -> L233
            r18 = r16
        L89:
            java.lang.String r0 = "contacter_pa_uid"
            r2 = r5
            long r4 = r14.optLong(r0)     // Catch: org.json.JSONException -> L233
            java.lang.String r0 = "content_type"
            int r0 = r14.optInt(r0)     // Catch: org.json.JSONException -> L233
            r20 = r2
            java.lang.String r2 = "content"
            java.lang.String r2 = r14.optString(r2)     // Catch: org.json.JSONException -> L233
            r21 = r6
            java.lang.String r6 = "unread_num"
            int r6 = r14.optInt(r6)     // Catch: org.json.JSONException -> L233
            r22 = r7
            java.lang.String r7 = "last_time"
            r23 = r8
            long r7 = r14.optLong(r7)     // Catch: org.json.JSONException -> L221
            r24 = r12
            java.lang.String r12 = "contacter_im_uk"
            long r32 = r14.optLong(r12)     // Catch: org.json.JSONException -> L218
            java.lang.String r12 = "is_top"
            r34 = r13
            r13 = 0
            int r12 = r14.optInt(r12, r13)     // Catch: org.json.JSONException -> L218
            java.lang.String r13 = "last_msg_bd_uid"
            long r13 = r14.optLong(r13)     // Catch: org.json.JSONException -> L218
            r35 = r10
            r10 = 57
            r36 = r9
            if (r15 != r10) goto Ld3
            r18 = r32
            r10 = 1
            goto Ld4
        Ld3:
            r10 = 0
        Ld4:
            com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory r9 = com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory.getInstance()     // Catch: org.json.JSONException -> L212
            r37 = r4
            android.content.Context r4 = r1.mContext     // Catch: org.json.JSONException -> L212
            r5 = -1
            com.baidu.android.imsdk.chatmessage.messages.ChatMsg r4 = r9.newChatMsg(r4, r10, r0, r5)     // Catch: org.json.JSONException -> L212
            java.lang.String r5 = ""
            if (r4 == 0) goto L118
            r4.setMsgType(r0)     // Catch: org.json.JSONException -> L10b
            r4.setMsgContentFromServer(r2)     // Catch: org.json.JSONException -> L10b
            r0 = 57
            if (r15 != r0) goto L102
            android.content.Context r0 = r1.mContext     // Catch: org.json.JSONException -> L10b
            com.baidu.android.imsdk.group.GroupMessageManagerImpl r0 = com.baidu.android.imsdk.group.GroupMessageManagerImpl.getInstance(r0)     // Catch: org.json.JSONException -> L10b
            boolean r0 = r0.isValidGroup(r4)     // Catch: org.json.JSONException -> L10b
            if (r0 != 0) goto L102
        Lfb:
            r10 = r35
            r9 = r36
            r4 = 0
            goto L204
        L102:
            java.lang.String r5 = r4.getRecommendDescription()     // Catch: org.json.JSONException -> L10b
            java.lang.String r0 = r4.getExtLog()     // Catch: org.json.JSONException -> L10b
            goto L119
        L10b:
            r0 = move-exception
            r7 = r22
            r8 = r23
            r12 = r24
            r10 = r35
            r9 = r36
            goto L23a
        L118:
            r0 = r5
        L119:
            com.baidu.android.imsdk.chatmessage.ChatSession r2 = new com.baidu.android.imsdk.chatmessage.ChatSession     // Catch: org.json.JSONException -> L212
            java.lang.String r31 = ""
            r25 = r2
            r26 = r10
            r27 = r32
            r29 = r18
            r25.<init>(r26, r27, r29, r31)     // Catch: org.json.JSONException -> L212
            long r9 = (long) r6     // Catch: org.json.JSONException -> L212
            r2.setNewMsgSum(r9)     // Catch: org.json.JSONException -> L212
            r2.setLastMsgTime(r7)     // Catch: org.json.JSONException -> L212
            r2.setLastOpenTime(r7)     // Catch: org.json.JSONException -> L212
            r2.setLastMsg(r5)     // Catch: org.json.JSONException -> L212
            r2.setMarkTop(r12)     // Catch: org.json.JSONException -> L212
            r2.setMarkTopTime(r7)     // Catch: org.json.JSONException -> L212
            r4 = 1
            r2.setSessionFrom(r4)     // Catch: org.json.JSONException -> L212
            r2.setIsClicked(r4)     // Catch: org.json.JSONException -> L212
            r2.setExt(r0)     // Catch: org.json.JSONException -> L212
            r2.setLastMsgUid(r13)     // Catch: org.json.JSONException -> L212
            r0 = 57
            if (r15 != r0) goto L1c9
            java.lang.String r0 = java.lang.String.valueOf(r32)     // Catch: org.json.JSONException -> L1bb
            r11.put(r0, r2)     // Catch: org.json.JSONException -> L1bb
            if (r6 <= 0) goto L1ab
            long r4 = r2.getContacterId()     // Catch: org.json.JSONException -> L10b
            java.lang.String r0 = java.lang.Long.toString(r4)     // Catch: org.json.JSONException -> L10b
            android.content.Context r4 = r1.mContext     // Catch: org.json.JSONException -> L10b
            java.lang.String r4 = com.baidu.android.imsdk.account.AccountManager.getUid(r4)     // Catch: org.json.JSONException -> L10b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L10b
            r5.<init>()     // Catch: org.json.JSONException -> L10b
            java.lang.String r6 = "userId: "
            r5.append(r6)     // Catch: org.json.JSONException -> L10b
            r5.append(r4)     // Catch: org.json.JSONException -> L10b
            java.lang.String r5 = r5.toString()     // Catch: org.json.JSONException -> L10b
            com.baidu.android.imsdk.utils.LogUtils.d(r3, r5)     // Catch: org.json.JSONException -> L10b
            android.content.Context r5 = r1.mContext     // Catch: org.json.JSONException -> L10b
            java.util.ArrayList r0 = com.baidu.android.imsdk.group.db.GroupMessageDAOImpl.getFansGroupAtUnread(r5, r0, r4)     // Catch: org.json.JSONException -> L10b
            if (r0 == 0) goto L1a0
            int r4 = r0.size()     // Catch: org.json.JSONException -> L10b
            r2.setNewFansAtMsgSum(r4)     // Catch: org.json.JSONException -> L10b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L10b
            r2.<init>()     // Catch: org.json.JSONException -> L10b
            java.lang.String r4 = "newFansAtSMsgSum: "
            r2.append(r4)     // Catch: org.json.JSONException -> L10b
            int r0 = r0.size()     // Catch: org.json.JSONException -> L10b
            r2.append(r0)     // Catch: org.json.JSONException -> L10b
            java.lang.String r0 = r2.toString()     // Catch: org.json.JSONException -> L10b
            com.baidu.android.imsdk.utils.LogUtils.d(r3, r0)     // Catch: org.json.JSONException -> L10b
            goto Lfb
        L1a0:
            r4 = 0
            r2.setNewFansAtMsgSum(r4)     // Catch: org.json.JSONException -> L1b9
            java.lang.String r0 = "newFansAtSMsgSum: 0"
            com.baidu.android.imsdk.utils.LogUtils.d(r3, r0)     // Catch: org.json.JSONException -> L10b
            goto Lfb
        L1ab:
            r4 = 0
            r2.setNewFansAtMsgSum(r4)     // Catch: org.json.JSONException -> L1b9
            java.lang.String r0 = "newFansAtSMsgSum: 0, unread = 0"
            com.baidu.android.imsdk.utils.LogUtils.d(r3, r0)     // Catch: org.json.JSONException -> L1b9
            r10 = r35
            r9 = r36
            goto L204
        L1b9:
            r0 = move-exception
            goto L1bd
        L1bb:
            r0 = move-exception
            r4 = 0
        L1bd:
            r7 = r22
            r8 = r23
            r12 = r24
            r10 = r35
            r9 = r36
            goto L269
        L1c9:
            r4 = 0
            int r0 = (r37 > r16 ? 1 : (r37 == r16 ? 0 : -1))
            if (r0 == 0) goto L1ec
            r5 = r37
            r2.setPaid(r5)     // Catch: org.json.JSONException -> L1df
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch: org.json.JSONException -> L1df
            r9 = r36
            r9.put(r0, r2)     // Catch: org.json.JSONException -> L1dd
            goto L202
        L1dd:
            r0 = move-exception
            goto L1e2
        L1df:
            r0 = move-exception
            r9 = r36
        L1e2:
            r7 = r22
            r8 = r23
            r12 = r24
            r10 = r35
            goto L269
        L1ec:
            r9 = r36
            int r0 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r0 == 0) goto L202
            java.lang.Long r0 = java.lang.Long.valueOf(r18)     // Catch: org.json.JSONException -> L1fe
            r10 = r35
            r10.put(r0, r2)     // Catch: org.json.JSONException -> L1fc
            goto L204
        L1fc:
            r0 = move-exception
            goto L21a
        L1fe:
            r0 = move-exception
            r10 = r35
            goto L21a
        L202:
            r10 = r35
        L204:
            int r13 = r34 + 1
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r12 = r24
            goto L5b
        L212:
            r0 = move-exception
            r10 = r35
            r9 = r36
            goto L219
        L218:
            r0 = move-exception
        L219:
            r4 = 0
        L21a:
            r7 = r22
            r8 = r23
            r12 = r24
            goto L269
        L221:
            r0 = move-exception
            r24 = r12
            r4 = 0
            r7 = r22
            r8 = r23
            goto L269
        L22a:
            r0 = move-exception
            r23 = r8
            r24 = r12
            r4 = 0
            r7 = r22
            goto L269
        L233:
            r0 = move-exception
            r22 = r7
            r23 = r8
            r24 = r12
        L23a:
            r4 = 0
            goto L269
        L23c:
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r12
            r7 = r22
            r8 = r23
            r12 = r24
            goto L262
        L24b:
            r0 = move-exception
            r22 = r7
            r23 = r8
            r24 = r12
            goto L269
        L253:
            r0 = move-exception
            r22 = r7
            r23 = r8
            goto L268
        L259:
            r0 = move-exception
            r22 = r7
            goto L267
        L25d:
            r21 = r6
            r7 = 0
            r8 = 0
            r12 = 0
        L262:
            r5 = r21
            goto L272
        L265:
            r0 = move-exception
            r7 = 0
        L267:
            r8 = 0
        L268:
            r12 = 0
        L269:
            java.lang.String r2 = "IMMediaGetChatSessionRequest JSONException"
            com.baidu.android.imsdk.utils.LogUtils.e(r3, r2, r0)
            r0 = 1010(0x3f2, float:1.415E-42)
            r5 = 1010(0x3f2, float:1.415E-42)
        L272:
            android.content.Context r0 = r1.mContext
            com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl r0 = com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.getInstance(r0)
            r2 = 1
            if (r7 != r2) goto L27d
            r6 = 1
            goto L27e
        L27d:
            r6 = 0
        L27e:
            java.lang.String r2 = r1.mKey
            r4 = r0
            r7 = r8
            r8 = r12
            r12 = r2
            r4.onMediaGetChatSessionRequest(r5, r6, r7, r8, r9, r10, r11, r12)
            return
        L288:
            r37 = r0
            r38 = 1048582(0x100006, float:1.469376E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r37.invokeIL(r38, r39, r40, r41)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.chatmessage.request.IMMediaGetChatSessionRequest.onSuccess(int, byte[]):void");
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaGetChatSessionRequest(Context context, long j2, int i2, long j3, String str, int i3, long j4, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Integer.valueOf(i3), Long.valueOf(j4), Integer.valueOf(i4), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mNeedTop = -1;
        this.mContext = context;
        this.mContacter = j2;
        this.mCount = i3;
        this.mEndTime = j4;
        this.mKey = str2;
        this.mContactorType = i2;
        this.mContactorPauid = j3;
        this.mContactorThirdid = str;
        this.mNeedTop = i4;
    }
}
