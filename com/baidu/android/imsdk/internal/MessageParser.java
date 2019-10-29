package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.mcast.McastManagerImpl;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MessageParser {
    private static final String TAG = "MessageParser";

    /* JADX WARN: Type inference failed for: r16v0, types: [T, java.lang.Long] */
    public static ChatMsg parserMessage(Context context, JSONObject jSONObject, Type<Long> type, boolean z) {
        try {
            long optLong = jSONObject.optLong("msgid");
            long optLong2 = jSONObject.optLong("from_user");
            long optLong3 = jSONObject.optLong("create_time");
            long optLong4 = jSONObject.optLong("contacter");
            String optString = jSONObject.optString("content");
            int optInt = jSONObject.optInt("category");
            ChatMsg chatMsg = null;
            boolean z2 = false;
            type.t = Long.valueOf(optLong);
            switch (optInt) {
                case 0:
                    int optInt2 = jSONObject.optInt("type");
                    long optLong5 = jSONObject.optLong("msg_expires", 0L);
                    int optInt3 = jSONObject.optInt(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE);
                    if (optInt2 == 80 || (optInt2 == 0 && optInt3 == 10)) {
                        DuParser invokeParse = new DuParser(context, optString, optInt).invokeParse();
                        if (invokeParse.isMsgNull()) {
                            return null;
                        }
                        chatMsg = invokeParse.getMsg();
                        z2 = invokeParse.isJsonParseResult();
                    } else {
                        chatMsg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt2, -1);
                        if (chatMsg != null) {
                            chatMsg.setMsgType(optInt2);
                            z2 = chatMsg.setMsgContentFromServer(optString);
                            if (chatMsg.isDumiMessage()) {
                                chatMsg.setChatType(100);
                                LogUtils.d(TAG, "setchattype as dumi " + chatMsg.getMsgId());
                            }
                        } else {
                            return chatMsg;
                        }
                    }
                    chatMsg.setCategory(optInt);
                    chatMsg.setContacter(optLong4);
                    chatMsg.setFromUser(optLong2);
                    chatMsg.setExpiresTime(optLong5);
                    break;
                case 1:
                    long optLong6 = jSONObject.optLong("group_id");
                    int optInt4 = jSONObject.optInt("type");
                    chatMsg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt4, -1);
                    if (chatMsg != null) {
                        chatMsg.setCategory(optInt);
                        chatMsg.setContacter(optLong6);
                        chatMsg.setFromUser(optLong2);
                        chatMsg.setMsgType(optInt4);
                        z2 = chatMsg.setMsgContentFromServer(optString);
                        break;
                    } else {
                        return chatMsg;
                    }
                case 2:
                    int i = jSONObject.getInt("cmd");
                    ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, -1, i);
                    if (newChatMsg != null) {
                        newChatMsg.setCategory(optInt);
                        newChatMsg.setContacter(optLong4);
                        newChatMsg.setFromUser(optLong2);
                        z2 = newChatMsg.setMsgContentFromServer(optString);
                        newChatMsg.setNotifyCmd(i);
                        chatMsg = handleSysChatMsg(newChatMsg);
                        chatMsg.setMsgType(-1);
                        break;
                    } else {
                        return newChatMsg;
                    }
                case 3:
                    int i2 = jSONObject.getInt("cmd");
                    chatMsg = ChatMsgFactory.getInstance().newChatMsg(context, 3, -1, i2);
                    if (chatMsg != null) {
                        chatMsg.setCategory(optInt);
                        chatMsg.setContacter(optLong4);
                        chatMsg.setFromUser(optLong2);
                        chatMsg.setNotifyCmd(i2);
                        z2 = chatMsg.setMsgContentFromServer(optString);
                        break;
                    } else {
                        return chatMsg;
                    }
                case 4:
                    int optInt5 = jSONObject.optInt("type");
                    chatMsg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt5, -1);
                    if (chatMsg != null) {
                        chatMsg.setCategory(optInt);
                        chatMsg.setContacter(optLong4);
                        chatMsg.setFromUser(optLong2);
                        chatMsg.setMsgType(optInt5);
                        boolean msgContentFromServer = chatMsg.setMsgContentFromServer(optString);
                        if (McastManagerImpl.getInstance(context).isReliable(optLong4).booleanValue()) {
                            ((TextMsg) chatMsg).setCastId(optLong4);
                            ((TextMsg) chatMsg).setPriority(jSONObject.optLong("prority"));
                            chatMsg.setMsgContent(jSONObject.toString());
                        }
                        LogUtils.d("IMFetchMsgByIdMsg parse ", msgContentFromServer + "");
                        z2 = msgContentFromServer;
                        break;
                    } else {
                        return chatMsg;
                    }
                case 6:
                    int optInt6 = jSONObject.optInt("type");
                    chatMsg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt6, -1);
                    if (chatMsg != null) {
                        chatMsg.setCategory(optInt);
                        chatMsg.setContacter(optLong4);
                        chatMsg.setFromUser(optLong2);
                        chatMsg.setMsgType(optInt6);
                        z2 = chatMsg.setMsgContentFromServer(optString);
                        break;
                    } else {
                        return chatMsg;
                    }
            }
            if (!z2 && z) {
                return null;
            }
            if (chatMsg != null) {
                if (chatMsg.shouldAbandonMsg(context)) {
                    LogUtils.d(TAG, "msg will abandon for shouldAbandonMsg=true, msg=" + chatMsg.toString());
                    return null;
                }
                chatMsg.setMsgId(optLong);
                chatMsg.setMsgTime(optLong3);
                chatMsg.setMsgKey(jSONObject.optString("msg_key", ""));
                if (jSONObject.has("appid")) {
                    chatMsg.setAppId(jSONObject.optLong("appid"));
                }
                if (jSONObject.has("is_read")) {
                    int optInt7 = jSONObject.optInt("is_read");
                    chatMsg.setMsgReaded(optInt7);
                    chatMsg.setIsClicked(optInt7 == 1);
                }
                if (chatMsg.isSelf(context)) {
                    chatMsg.setMsgReaded(1);
                }
                if (MsgUtility.isNotice(chatMsg)) {
                    chatMsg.setMsgReaded(1);
                }
                if (chatMsg.isMsgRead()) {
                    chatMsg.setIsClicked(true);
                }
                if (optInt == 0 && (Constants.PAFLAG & optLong4) != 0) {
                    chatMsg.setPaid(optLong4);
                } else {
                    chatMsg.setPaid(jSONObject.optLong("pa_uid", -1L));
                }
                chatMsg.setMsgKey(jSONObject.optString("msg_key", ""));
                chatMsg.setDeviceFlag(2);
                LogUtils.d("msg", chatMsg.getMsgKey());
                return chatMsg;
            }
            return chatMsg;
        } catch (Exception e) {
            LogUtils.e(TAG, "parserMessage:", e);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Long] */
    public static ArrayList<ChatMsg> parserMessage(Context context, JSONArray jSONArray, Type<Long> type, boolean z, boolean z2) {
        JSONObject jSONObject;
        ArrayList<ChatMsg> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            try {
                long triggerId = Utility.getTriggerId(context);
                LinkedList linkedList = new LinkedList();
                Type type2 = new Type();
                type2.t = 0L;
                for (int i = 0; i < jSONArray.length(); i++) {
                    ChatMsg parserMessage = parserMessage(context, jSONArray.getJSONObject(i), type2, z);
                    if (type.t.longValue() < ((Long) type2.t).longValue()) {
                        type.t = type2.t;
                    }
                    if (parserMessage != null) {
                        if (parserMessage.isSelf(context)) {
                            parserMessage.setMsgReaded(1);
                            parserMessage.setIsClicked(true);
                        } else {
                            String ext = parserMessage.getExt();
                            JSONObject jSONObject2 = null;
                            if (ext != null) {
                                try {
                                    JSONObject jSONObject3 = new JSONObject(ext);
                                    if (jSONObject3.has("ack")) {
                                        jSONObject2 = jSONObject3.getJSONObject("ack");
                                    }
                                } catch (JSONException e) {
                                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                                    jSONObject = null;
                                }
                            }
                            jSONObject = jSONObject2;
                            NewAckMessage.Tripule tripule = new NewAckMessage.Tripule(parserMessage.getMsgId(), parserMessage.getMsgKey(), System.currentTimeMillis());
                            tripule.setFromUser(parserMessage.getFromUser());
                            if (jSONObject != null) {
                                tripule.setAck(jSONObject);
                            }
                            linkedList.add(tripule);
                        }
                        parserMessage.setStatus(0);
                        arrayList.add(parserMessage);
                    }
                }
                if (z2) {
                    sendNewAckToServer(context, triggerId, linkedList);
                }
            } catch (Exception e2) {
                LogUtils.e(LogUtils.TAG, "parserMessage:", e2);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            }
        }
        return arrayList;
    }

    private static void sendNewAckToServer(Context context, long j, List<NewAckMessage.Tripule> list) {
        if (list != null && list.size() != 0) {
            NewAckMessage newAckMessage = new NewAckMessage(context, IMSDK.getInstance(context).getUk(), j);
            newAckMessage.addTriples(list);
            IMConnection.getInstance(context).sendMessage(newAckMessage, false);
        }
    }

    private static ChatMsg handleSysChatMsg(ChatMsg chatMsg) throws Exception {
        JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
        JSONObject jSONObject2 = new JSONObject();
        switch (chatMsg.getNotifyCmd()) {
            case 0:
                long j = jSONObject.getLong("from");
                jSONObject2.put("text", jSONObject.getString("description"));
                chatMsg.setFromUser(j);
                break;
            case 1:
                chatMsg.setFromUser(jSONObject.getLong("from"));
                break;
            case 20:
                jSONObject2 = jSONObject;
                break;
            default:
                jSONObject2 = jSONObject;
                break;
        }
        chatMsg.setMsgContentFromServer(jSONObject2.toString());
        return chatMsg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class DuParser {
        private int category;
        private String content;
        private Context context;
        private boolean jsonParseResult;
        private ChatMsg msg;
        private boolean msgIsNull;

        public DuParser(Context context, String str, int i) {
            this.context = context;
            this.content = str;
            this.category = i;
        }

        boolean isMsgNull() {
            return this.msgIsNull;
        }

        public ChatMsg getMsg() {
            return this.msg;
        }

        public boolean isJsonParseResult() {
            return this.jsonParseResult;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0144  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DuParser invokeParse() throws Exception {
            int i;
            String str;
            JSONObject jSONObject = new JSONObject(this.content);
            String optString = jSONObject.optString("text");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = new JSONObject(optString).optString("msg");
                if (!TextUtils.isEmpty(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    String optString3 = jSONObject2.optString("ext");
                    if (!TextUtils.isEmpty(optString3)) {
                        JSONObject jSONObject3 = new JSONObject(optString3);
                        int optInt = jSONObject3.optInt("type");
                        String optString4 = jSONObject3.optString("content");
                        if (jSONObject3.has("body")) {
                            int optInt2 = jSONObject3.optInt("type", 1);
                            if (optInt2 == 1) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("text", jSONObject3.optString("body"));
                                String jSONObject5 = jSONObject4.toString();
                                i = 0;
                                str = jSONObject5;
                            } else if (optInt2 == 0) {
                                JSONArray jSONArray = new JSONArray(jSONObject3.optString("body"));
                                if (jSONArray != null && jSONArray.length() > 1) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                                        JSONObject jSONObject6 = new JSONObject();
                                        jSONObject6.put("title", optJSONObject.optString("title"));
                                        jSONObject6.put("article_url", optJSONObject.optString("url"));
                                        jSONObject6.put("cover", optJSONObject.optString("headImage"));
                                        jSONArray2.put(jSONObject6);
                                    }
                                    JSONObject jSONObject7 = new JSONObject();
                                    jSONObject7.put("articles", jSONArray2);
                                    String jSONObject8 = jSONObject7.toString();
                                    i = 9;
                                    str = jSONObject8;
                                } else if (jSONArray != null && jSONArray.length() == 1) {
                                    JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
                                    JSONObject jSONObject9 = new JSONObject();
                                    jSONObject9.put("title", optJSONObject2.optString("title"));
                                    jSONObject9.put("article_url", optJSONObject2.optString("url"));
                                    jSONObject9.put("cover", optJSONObject2.optString("headImage"));
                                    i = 8;
                                    str = jSONObject9.toString();
                                }
                            }
                            this.msg = ChatMsgFactory.getInstance().newChatMsg(this.context, this.category, i, -1);
                            if (this.msg != null) {
                                this.msgIsNull = true;
                            } else {
                                String optString5 = jSONObject.optString("ext");
                                if (!TextUtils.isEmpty(optString5)) {
                                    int optInt3 = new JSONObject(optString5).optInt("sub_app_identity");
                                    if (optInt3 == 7) {
                                        this.msg.setChatType(7);
                                    } else if (optInt3 == 16) {
                                        this.msgIsNull = true;
                                    } else if (optInt3 == 17) {
                                        this.msg.setChatType(17);
                                    } else if (optInt3 == 6) {
                                        this.msgIsNull = true;
                                    } else if (optInt3 == 19) {
                                        this.msg.setChatType(19);
                                    } else if (optInt3 == 23) {
                                        this.msg.setChatType(23);
                                    } else if (optInt3 == 24) {
                                        this.msg.setChatType(24);
                                    } else if (optInt3 == 25) {
                                        this.msg.setChatType(25);
                                    }
                                    this.msg.setMsgType(i);
                                    if (i == 18) {
                                        ((HtmlMsg) this.msg).setDesc(jSONObject2.optString("description"));
                                    }
                                    this.jsonParseResult = this.msg.setMsgContentFromServer(str);
                                    this.msg.setmExtJson(optString5);
                                } else {
                                    LogUtils.e(MessageParser.TAG, "duzhan msg parse error! ext in content is null!");
                                }
                            }
                            return this;
                        }
                        i = optInt;
                        str = optString4;
                        this.msg = ChatMsgFactory.getInstance().newChatMsg(this.context, this.category, i, -1);
                        if (this.msg != null) {
                        }
                        return this;
                    }
                    LogUtils.e(MessageParser.TAG, "duzhan msg parse error! ext in text is null!");
                } else {
                    LogUtils.e(MessageParser.TAG, "duzhan msg parse error! msg in text is null!");
                }
            } else {
                LogUtils.e(MessageParser.TAG, "duzhan msg parse error! text in content is null!");
            }
            this.msgIsNull = false;
            return this;
        }
    }
}
