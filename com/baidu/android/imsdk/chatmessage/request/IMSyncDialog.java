package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
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
/* loaded from: classes6.dex */
public class IMSyncDialog extends Message {
    public static final String TAG = IMDelMsg.class.getSimpleName();
    private Context mContext;
    private long mMaxMsgid;

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
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 94);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("msgid", this.mMaxMsgid);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            LogUtils.e(TAG, e.getMessage(), e);
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) throws JSONException {
        ArrayList arrayList;
        ArrayList arrayList2;
        long j = -1;
        if (i != 0 || jSONObject == null) {
            arrayList = null;
        } else {
            JSONArray jSONArray = jSONObject.getJSONArray("dialogue");
            int length = jSONArray.length();
            if (length <= 0) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList();
            }
            Type type = new Type();
            type.t = 0L;
            long j2 = -1;
            for (int i2 = 0; i2 < length; i2++) {
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
                            } catch (Exception e) {
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                            }
                        }
                    } else {
                        if (arrayList2 != null) {
                            arrayList2.add(parserMessage);
                        }
                        if (((Long) type.t).longValue() > j2) {
                            j2 = ((Long) type.t).longValue();
                        }
                    }
                }
            }
            j = j2;
            arrayList = arrayList2;
        }
        ChatMsgManagerImpl.getInstance(this.mContext).onSyncDialogResult(i, str, getListenerKey(), j, arrayList);
    }
}
