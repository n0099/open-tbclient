package com.baidu.android.imsdk.consult;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.RequestContants;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AdvisoryFilterSessionTask extends TaskManager.Task {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdvisoryFilterSessionTask";
    public transient /* synthetic */ FieldHolder $fh;
    public final int mBusinessType;
    public final int mCategory;
    public final Context mContext;
    public final String mListenerKey;
    public final String mResponse;

    public AdvisoryFilterSessionTask(Context context, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mResponse = str;
        this.mListenerKey = str2;
        this.mCategory = i;
        this.mBusinessType = i2;
    }

    private ChatSession addAdvisoryValue(JSONObject jSONObject, ChatSession chatSession) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, jSONObject, chatSession)) == null) {
            if (jSONObject != null && chatSession != null && this.mBusinessType == 27) {
                try {
                    int i = jSONObject.getInt("session_type");
                    long optLong = jSONObject.optLong(TableDefine.BusiSessionColumns.COLUMN_LAST_DIALOGUE_ID);
                    String optString = jSONObject.optString(TableDefine.BusiSessionColumns.COLUMN_LAST_RESOURCE_ID);
                    int optInt = jSONObject.optInt("aid_type");
                    int optInt2 = jSONObject.optInt("status");
                    long optLong2 = jSONObject.optLong(TableDefine.BusiSessionColumns.COLUMN_LAST_ASK_UK);
                    long optLong3 = jSONObject.optLong(TableDefine.BusiSessionColumns.COLUMN_LAST_ANSWER_UK);
                    String optString2 = jSONObject.optString("desc");
                    String optString3 = jSONObject.optString(TableDefine.BusiSessionColumns.COLUMN_STATUS_SHOW);
                    int optInt3 = jSONObject.optInt("follow_state", 0);
                    int optInt4 = jSONObject.optInt("consult_collect_state");
                    chatSession.setDesc(optString2);
                    chatSession.setLastStatusShow(optString3);
                    chatSession.setSessionType(i);
                    chatSession.setLastDialogueId(optLong);
                    chatSession.setLastResourceId(optString);
                    chatSession.setAidType(optInt);
                    chatSession.setLastDialogueStatus(optInt2);
                    chatSession.setLastAnswerUk(optLong3);
                    chatSession.setLastAskUk(optLong2);
                    chatSession.setBusinessType(27);
                    chatSession.setSubscribe(optInt3);
                    chatSession.setCollectState(optInt4);
                } catch (Exception unused) {
                }
            }
            return chatSession;
        }
        return (ChatSession) invokeLL.objValue;
    }

    private String getLastMsgDesc(ChatMsg chatMsg) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, chatMsg)) == null) {
            if (chatMsg != null) {
                str = chatMsg.getRecommendDescription();
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str)) {
                return IMConstants.IM_GROUP_MSG_DEFAULT_RECOMMEND_DESC;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private List<ChatSession> parseBusinessSessions(JSONArray jSONArray) {
        InterceptResult invokeL;
        String str;
        int i;
        String str2;
        long optLong;
        int optInt;
        String optString;
        ArrayList arrayList;
        long optLong2;
        int optInt2;
        String optString2;
        String optString3;
        int optInt3;
        int optInt4;
        long optLong3;
        int i2;
        int i3;
        long j;
        int i4;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONArray)) == null) {
            JSONArray jSONArray2 = jSONArray;
            ArrayList arrayList2 = new ArrayList();
            if (jSONArray2 != null && jSONArray.length() != 0) {
                String str3 = TAG;
                LogUtils.d(TAG, "parseBusinessSessions size = " + jSONArray.length());
                int i5 = 0;
                while (i5 < jSONArray.length()) {
                    try {
                        JSONObject jSONObject = jSONArray2.getJSONObject(i5);
                        LogUtils.d(str3, "parseBusinessSessions json = " + jSONObject.toString());
                        long optLong4 = jSONObject.optLong("sort_update_time_us");
                        long j3 = jSONObject.getLong("contacter_uk");
                        long j4 = jSONObject.getLong("contacter_bduid");
                        long optLong5 = jSONObject.optLong(RequestContants.EXTRA_CONTACTER_PA_UID, -1L);
                        long j5 = jSONObject.getLong("unread_num");
                        i = i5;
                        try {
                            optLong = jSONObject.optLong(TableDefine.MediaSessionColumns.COLUMN_LAST_MSGID);
                            optInt = jSONObject.optInt("last_msgtype");
                            optString = jSONObject.optString("last_content");
                            arrayList = arrayList2;
                            try {
                                optLong2 = jSONObject.optLong("last_time");
                                int optInt5 = jSONObject.optInt("pa_classtype");
                                optInt2 = jSONObject.optInt("pa_classshow");
                                optString2 = jSONObject.optString("pa_classavatar");
                                optString3 = jSONObject.optString("pa_classtitle");
                                optInt3 = jSONObject.optInt("is_top", 0);
                                optInt4 = jSONObject.optInt("is_block");
                                optLong3 = jSONObject.optLong("block_timestamp");
                                int optInt6 = jSONObject.optInt("aggr_type");
                                int optInt7 = jSONObject.optInt("stranger_type");
                                str = str3;
                                if (optInt6 != 12 && optInt7 != 1) {
                                    i2 = optInt5;
                                    i3 = 0;
                                } else {
                                    i2 = optInt6;
                                    i3 = 1;
                                }
                            } catch (Exception e) {
                                e = e;
                                str = str3;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = str3;
                        }
                        try {
                            int optInt8 = jSONObject.optInt("do_not_disturb");
                            int optInt9 = jSONObject.optInt("chat_type");
                            int i6 = i3;
                            long optLong6 = jSONObject.optLong("last_msg_bduid");
                            jSONObject.optLong("last_msg_uk");
                            String optString4 = jSONObject.optString("desc");
                            ChatMsg parseChatMsg = MessageParser.parseChatMsg(this.mContext, this.mCategory, optInt, this.mBusinessType, 0, optString);
                            if (TextUtils.isEmpty(optString4)) {
                                optString4 = getLastMsgDesc(parseChatMsg);
                            }
                            String str4 = optString4;
                            if (optInt9 == 57 && !GroupMessageManagerImpl.getInstance(this.mContext).isValidGroup(parseChatMsg)) {
                                arrayList2 = arrayList;
                                str2 = str;
                            } else {
                                long j6 = 0;
                                int i7 = (optLong5 > 0L ? 1 : (optLong5 == 0L ? 0 : -1));
                                if (i7 > 0) {
                                    j = optLong5;
                                } else {
                                    j = j3;
                                }
                                if (optInt9 == 57) {
                                    i4 = optInt9;
                                    ChatSession chatRecord = ChatMessageDBManager.getInstance(this.mContext).getChatRecord(new ChatObject(this.mContext, 1, j3));
                                    if (chatRecord != null) {
                                        j6 = chatRecord.getNewMsgSum();
                                    }
                                    j2 = j6;
                                } else {
                                    i4 = optInt9;
                                    j2 = j5;
                                }
                                int i8 = i4;
                                ChatSession chatSession = new ChatSession(this.mCategory, j, j4, "");
                                chatSession.setChatType(i8);
                                chatSession.setLastMsg(str4);
                                chatSession.setNewMsgSum(j2);
                                chatSession.setLastMsgId(optLong);
                                chatSession.setLastMsgTime(optLong2);
                                chatSession.setClassShow(optInt2);
                                chatSession.setClassType(i2);
                                chatSession.setClassAvatar(optString2);
                                chatSession.setClassTitle(optString3);
                                chatSession.setBusinessType(this.mBusinessType);
                                if (i7 > 0) {
                                    chatSession.setPaid(optLong5);
                                }
                                chatSession.setMarkTop(optInt3);
                                chatSession.setShield(optInt4);
                                chatSession.setShieldTime(optLong3);
                                chatSession.setSortTime(optLong4);
                                chatSession.setIsStranger(i6);
                                try {
                                    chatSession.setState(0);
                                    chatSession.setIsClicked(1);
                                    chatSession.setDisturb(optInt8);
                                    chatSession.setContacterImuk(j3);
                                    if (i8 == 57) {
                                        chatSession.setLastMsgUid(optLong6);
                                    }
                                    arrayList2 = arrayList;
                                } catch (Exception e3) {
                                    e = e3;
                                    arrayList2 = arrayList;
                                }
                                try {
                                    arrayList2.add(addAdvisoryValue(jSONObject, chatSession));
                                    str2 = str;
                                } catch (Exception e4) {
                                    e = e4;
                                    str2 = str;
                                    LogUtils.e(str2, "parseBusinessSessions exception ", e);
                                    i5 = i + 1;
                                    jSONArray2 = jSONArray;
                                    str3 = str2;
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            arrayList2 = arrayList;
                            str2 = str;
                            LogUtils.e(str2, "parseBusinessSessions exception ", e);
                            i5 = i + 1;
                            jSONArray2 = jSONArray;
                            str3 = str2;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        str = str3;
                        i = i5;
                    }
                    i5 = i + 1;
                    jSONArray2 = jSONArray;
                    str3 = str2;
                }
            }
            return arrayList2;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
    public void run() {
        int i;
        List<ChatSession> list;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<ChatSession> list2 = null;
            if (!TextUtils.isEmpty(this.mResponse)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mResponse);
                    i = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                    if (i == 0) {
                        list2 = parseBusinessSessions(jSONObject.optJSONArray("sessions"));
                        i2 = jSONObject.getInt("has_more");
                    } else {
                        i2 = 0;
                    }
                    list = list2;
                } catch (JSONException unused) {
                    i = 1005;
                    LogUtils.d(TAG, "FetchSessionTask exception");
                    list = list2;
                    i2 = 0;
                }
            } else {
                list = null;
                i2 = 0;
                i = 0;
            }
            ChatSessionManagerImpl chatSessionManagerImpl = ChatSessionManagerImpl.getInstance(this.mContext);
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            chatSessionManagerImpl.onFetchBusiChatSessionResult(i, z, 0, list, this.mListenerKey);
        }
    }
}
