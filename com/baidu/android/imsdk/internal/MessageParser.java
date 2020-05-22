package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.mcast.McastManagerImpl;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.Utils;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.IMService;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
                            chatMsg.setChatType(0);
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

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Long] */
    public static ArrayList<ChatMsg> parserMessage(final Context context, JSONArray jSONArray, Type<Long> type, boolean z, boolean z2) {
        int i = 0;
        final ArrayList<ChatMsg> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            try {
                Type type2 = new Type();
                type2.t = 0L;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    ChatMsg parserMessage = parserMessage(context, jSONArray.getJSONObject(i2), type2, z);
                    if (type.t.longValue() < ((Long) type2.t).longValue()) {
                        type.t = type2.t;
                    }
                    if (parserMessage != null) {
                        if (parserMessage.isSelf(context) && parserMessage.getCategory() != 4) {
                            parserMessage.setMsgReaded(1);
                            parserMessage.setIsClicked(true);
                        }
                        parserMessage.setStatus(0);
                        arrayList.add(parserMessage);
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                LogUtils.e(LogUtils.TAG, "parserMessage:", e);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            }
        }
        if (z2) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.internal.MessageParser.1
                @Override // java.lang.Runnable
                public void run() {
                    MessageParser.handleAck(context, arrayList, true);
                }
            });
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void handleAck(Context context, ArrayList<ChatMsg> arrayList, boolean z) {
        boolean z2;
        String str;
        String str2;
        JSONObject jSONObject;
        synchronized (MessageParser.class) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    LogUtils.d(TAG, "ack> handleAck...number=" + arrayList.size());
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    LinkedList linkedList = new LinkedList();
                    boolean z3 = false;
                    long triggerId = Utility.getTriggerId(context);
                    String str3 = AccountManagerImpl.getInstance(context).getLoginType() == 6 ? "cuid" : "uid";
                    long uk = AccountManager.getUK(context);
                    int i = 0;
                    while (i < arrayList.size()) {
                        ChatMsg chatMsg = arrayList.get(i);
                        if (chatMsg != null) {
                            int category = chatMsg.getCategory();
                            int msgType = chatMsg.getMsgType();
                            long fromUser = chatMsg.getFromUser();
                            long contacter = chatMsg.getContacter();
                            int i2 = -1;
                            int i3 = -1;
                            int i4 = -1;
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            String str7 = "";
                            if (category == 1) {
                                str7 = Constants.PAGE_QUNXIAOXI_NAME;
                                str = "";
                                str2 = "";
                            } else if (category == 0) {
                                if ((Constants.PAFLAG & contacter) != 0) {
                                    PaInfo paInfo = PaManager.getPaInfo(context, contacter);
                                    if (paInfo != null) {
                                        LogUtils.d(TAG, "ack> painfo in local db, paid=" + contacter);
                                        i2 = paInfo.getSubtype();
                                        i3 = paInfo.getSubsetType();
                                        i4 = paInfo.getClassType();
                                        String paExt = paInfo.getPaExt();
                                        if (!TextUtils.isEmpty(paExt)) {
                                            try {
                                                JSONObject jSONObject2 = new JSONObject(paExt);
                                                str5 = jSONObject2.optString("msg_category", "");
                                                str4 = jSONObject2.optString("business_source", "");
                                                str6 = jSONObject2.optString("third_id", "");
                                            } catch (JSONException e) {
                                                LogUtils.d(TAG, e.getMessage());
                                            }
                                        }
                                        str7 = getPaPage(i2, i3);
                                        str = str5;
                                        str2 = str4;
                                    } else {
                                        LogUtils.d(TAG, "ack> painfo not in local db, paid=" + contacter);
                                        arrayList3.add(Long.valueOf(contacter));
                                        arrayList2.add(chatMsg);
                                        str = "";
                                        str2 = "";
                                    }
                                } else if ((Constants.PAFLAG & contacter) != 0) {
                                    str = "";
                                    str2 = "";
                                } else {
                                    str7 = Constants.PAGE_C2C_NAME;
                                    str = "";
                                    str2 = "";
                                }
                            } else {
                                str7 = "others_category_" + category;
                                str = "";
                                str2 = "";
                            }
                            String ext = chatMsg.getExt();
                            JSONObject jSONObject3 = null;
                            if (ext != null) {
                                try {
                                    JSONObject jSONObject4 = new JSONObject(ext);
                                    if (jSONObject4.has("ack")) {
                                        jSONObject3 = jSONObject4.getJSONObject("ack");
                                    }
                                } catch (JSONException e2) {
                                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                                    jSONObject = null;
                                }
                            }
                            jSONObject = jSONObject3;
                            NewAckMessage.Tripule tripule = new NewAckMessage.Tripule(chatMsg.getMsgId(), chatMsg.getMsgKey(), System.currentTimeMillis(), str7, msgType, str3, fromUser, uk, contacter, i2, i3, i4, str, str2, str6);
                            tripule.setFromUser(chatMsg.getFromUser());
                            if (jSONObject != null) {
                                tripule.setAck(jSONObject);
                            }
                            if (category == 4 && McastManagerImpl.getInstance(context).isReliable(((TextMsg) chatMsg).getCastId()).booleanValue()) {
                                tripule.setMcastId(((TextMsg) chatMsg).getCastId());
                                tripule.setStudioIsReliable(true);
                                z2 = true;
                            } else {
                                z2 = z3;
                            }
                            linkedList.add(tripule);
                        } else {
                            z2 = z3;
                        }
                        i++;
                        z3 = z2;
                    }
                    getAckNeedPainfos(context, z, arrayList2, arrayList3);
                    sendNewAckToServer(context, triggerId, linkedList, z3);
                }
            }
        }
    }

    private static void getAckNeedPainfos(final Context context, boolean z, final ArrayList<ChatMsg> arrayList, ArrayList<Long> arrayList2) {
        if (arrayList2.size() > 0 && z) {
            LogUtils.d(TAG, "ack> will get remote pa, ids=" + arrayList2.toString());
            PaManager.getPaInfos(context, arrayList2, new IGetPaInfosListener() { // from class: com.baidu.android.imsdk.internal.MessageParser.2
                @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                public void onResult(int i, String str, ArrayList<PaInfo> arrayList3) {
                    LogUtils.d(MessageParser.TAG, "ack> get remote painfos, responseCode=" + i + ", strMsg=" + str);
                    if (i == 0 && arrayList3 != null && arrayList3.size() > 0) {
                        LogUtils.d(MessageParser.TAG, "ack> get remote pa, painfos size=" + arrayList3.size());
                        Iterator<PaInfo> it = arrayList3.iterator();
                        while (it.hasNext()) {
                            PaInfo next = it.next();
                            PaInfoDBManager.getInstance(context).subscribePa(next);
                            ChatMessageDBManager.getInstance(context).updateSessionClass(next);
                        }
                        MessageParser.handleAck(context, arrayList, false);
                    }
                }
            });
        }
    }

    private static String getPaPage(int i, int i2) {
        if (i2 == 16) {
            return Constants.PAGE_SHANGXIONGHAO_NAME;
        }
        if (i2 == 21) {
            return Constants.PAGE_XIAOCHENGXUKEFU_NAME;
        }
        if (i == 7) {
            return Constants.PAGE_BAIJIAHAO_NAME;
        }
        if (i == 17) {
            return Constants.PAGE_FUWUXIAOXI_NAME;
        }
        if (i == 1 || i == 5) {
            return Constants.PAGE_SHOWBAIFUWUHAO_NAME;
        }
        if (i != 19 && i != 6) {
            return "";
        }
        return Constants.PAGE_HUDONG_NAME;
    }

    private static void sendNewAckToServer(Context context, long j, List<NewAckMessage.Tripule> list, boolean z) {
        if (list != null && list.size() != 0) {
            List<List<NewAckMessage.Tripule>> splitList = Utils.splitList(list, 20);
            if (splitList != null && splitList.size() > 0) {
                for (List<NewAckMessage.Tripule> list2 : splitList) {
                    NewAckMessage newAckMessage = new NewAckMessage(context, IMSDK.getInstance(context).getUk(), j, z);
                    newAckMessage.addTriples(list2);
                    if (!IMService.isSmallFlow) {
                        IMConnection.getInstance(context).sendMessage(newAckMessage, false);
                    }
                }
                return;
            }
            LogUtils.e(TAG, "sendNewAckToServer splitList wrong!!!");
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
    /* loaded from: classes3.dex */
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

        /* JADX WARN: Removed duplicated region for block: B:15:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x014e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DuParser invokeParse() throws Exception {
            int i;
            String str;
            JSONObject jSONObject = new JSONObject(this.content);
            String optString = jSONObject.optString("text");
            String optString2 = jSONObject.optString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "");
            if (!TextUtils.isEmpty(optString)) {
                String optString3 = new JSONObject(optString).optString("msg");
                if (!TextUtils.isEmpty(optString3)) {
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    String optString4 = jSONObject2.optString("ext");
                    if (!TextUtils.isEmpty(optString4)) {
                        JSONObject jSONObject3 = new JSONObject(optString4);
                        int optInt = jSONObject3.optInt("type");
                        String optString5 = jSONObject3.optString("content");
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
                                String optString6 = jSONObject.optString("ext");
                                if (!TextUtils.isEmpty(optString6)) {
                                    int optInt3 = new JSONObject(optString6).optInt("sub_app_identity");
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
                                    } else if (optInt3 == 26) {
                                        this.msg.setChatType(26);
                                    } else if (optInt3 == 27) {
                                        this.msg.setChatType(27);
                                    }
                                    this.msg.setMsgType(i);
                                    if (i == 18) {
                                        ((HtmlMsg) this.msg).setDesc(jSONObject2.optString("description"));
                                    }
                                    this.jsonParseResult = this.msg.setMsgContentFromServer(str);
                                    this.msg.setmExtJson(optString6);
                                    this.msg.setServiceType(optString2);
                                } else {
                                    LogUtils.e(MessageParser.TAG, "duzhan msg parse error! ext in content is null!");
                                }
                            }
                            return this;
                        }
                        i = optInt;
                        str = optString5;
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
