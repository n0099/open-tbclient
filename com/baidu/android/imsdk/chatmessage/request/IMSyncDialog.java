package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberQuitMsg;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMSyncDialog extends Message {
    public static final String TAG = IMDelMsg.class.getSimpleName();
    public Context mContext;
    public long mMaxMsgid;

    public IMSyncDialog(Context context, long j) {
        this.mMaxMsgid = 0L;
        this.mContext = context;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(94);
        this.mMaxMsgid = j;
    }

    public static IMSyncDialog newInstance(Context context, Intent intent) {
        return new IMSyncDialog(context, intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, 0L));
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 94);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("msgid", this.mMaxMsgid);
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            LogUtils.e(TAG, e2.getMessage(), e2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        long j = -1;
        if (i == 0 && jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("dialogue");
                int length = jSONArray.length();
                r3 = length > 0 ? new ArrayList() : null;
                Type type = new Type();
                type.t = 0L;
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        ChatMsg parserMessage = MessageParser.parserMessage(context, jSONArray.getJSONObject(i2).getJSONObject(TableDefine.SessionColumns.COLUMN_LAST_MSG), type, false);
                        if (parserMessage != null) {
                            if (1003 == parserMessage.getMsgType()) {
                                GroupMemberQuitMsg groupMemberQuitMsg = (GroupMemberQuitMsg) parserMessage;
                                String valueOf = String.valueOf(groupMemberQuitMsg.getContacter());
                                String quitBuid = groupMemberQuitMsg.getQuitBuid();
                                if (quitBuid != null && quitBuid.equals(AccountManager.getUid(this.mContext))) {
                                    try {
                                        GroupInfoDAOImpl.quitGroup(this.mContext, valueOf);
                                        DialogRecordDBManager.getInstance(this.mContext).delete(1, groupMemberQuitMsg.getContacter());
                                        ConversationManagerImpl.getInstance(this.mContext).deleteConversation(1, valueOf);
                                    } catch (Exception e2) {
                                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                                        LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                                    }
                                }
                            } else {
                                if (r3 != null) {
                                    r3.add(parserMessage);
                                }
                                if (((Long) type.t).longValue() > j) {
                                    j = ((Long) type.t).longValue();
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        LogUtils.e(TAG, "handle IMSyncMsg exception :", e);
                        super.handleMessageResult(context, jSONObject, i, str);
                        ChatSessionManagerImpl.getInstance(this.mContext).onSyncDialogResult(i, str, getListenerKey(), j, r3);
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
        }
        super.handleMessageResult(context, jSONObject, i, str);
        ChatSessionManagerImpl.getInstance(this.mContext).onSyncDialogResult(i, str, getListenerKey(), j, r3);
    }
}
