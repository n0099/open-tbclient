package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
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
/* loaded from: classes3.dex */
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

    /* JADX WARN: Type inference failed for: r2v9, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        long j;
        ArrayList arrayList = null;
        long j2 = -1;
        if (i == 0 && jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("dialogue");
                int length = jSONArray.length();
                if (length > 0) {
                    arrayList = new ArrayList();
                }
                Type type = new Type();
                type.t = 0L;
                long j3 = -1;
                int i2 = 0;
                while (i2 < length) {
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
                                        j = j3;
                                    } catch (Exception e) {
                                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                        LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                                        j = j3;
                                    }
                                    i2++;
                                    j3 = j;
                                }
                            } else {
                                if (arrayList != null) {
                                    arrayList.add(parserMessage);
                                }
                                if (((Long) type.t).longValue() > j3) {
                                    j = ((Long) type.t).longValue();
                                    i2++;
                                    j3 = j;
                                }
                            }
                        }
                        j = j3;
                        i2++;
                        j3 = j;
                    } catch (Exception e2) {
                        e = e2;
                        j2 = j3;
                        LogUtils.e(TAG, "handle IMSyncMsg exception :", e);
                        ChatMsgManagerImpl.getInstance(this.mContext).onSyncDialogResult(i, str, getListenerKey(), j2, arrayList);
                    }
                }
                j2 = j3;
            } catch (Exception e3) {
                e = e3;
            }
        } else if (i == 4001) {
            LoginManager.getInstance(this.mContext).triggleLogoutListener(i, str);
        }
        ChatMsgManagerImpl.getInstance(this.mContext).onSyncDialogResult(i, str, getListenerKey(), j2, arrayList);
    }
}
