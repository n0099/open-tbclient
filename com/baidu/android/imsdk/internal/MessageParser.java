package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.request.AckHandlerThread;
import com.baidu.android.imsdk.request.AckMessage;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.Utils;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import d.b.r.a;
import d.b.s.a.b.d.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MessageParser {
    public static final String TAG = "MessageParser";

    /* loaded from: classes2.dex */
    public static class DuParser {
        public int category;
        public String content;
        public Context context;
        public boolean jsonParseResult;
        public ChatMsg msg;
        public boolean msgIsNull;

        public DuParser(Context context, String str, int i) {
            this.context = context;
            this.content = str;
            this.category = i;
        }

        public ChatMsg getMsg() {
            return this.msg;
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x013e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DuParser invokeParse() throws Exception {
            int i;
            String str;
            int i2;
            int i3;
            ChatMsg newChatMsg;
            JSONObject jSONObject = new JSONObject(this.content);
            String optString = jSONObject.optString("text");
            int optInt = jSONObject.optInt(TableDefine.MessageColumns.COLUME_TEMPLATE, 0);
            String optString2 = jSONObject.optString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "");
            boolean isEmpty = TextUtils.isEmpty(optString);
            String str2 = MessageParser.TAG;
            if (!isEmpty) {
                String optString3 = new JSONObject(optString).optString("msg");
                if (!TextUtils.isEmpty(optString3)) {
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    String optString4 = jSONObject2.optString("ext");
                    if (!TextUtils.isEmpty(optString4)) {
                        JSONObject jSONObject3 = new JSONObject(optString4);
                        int optInt2 = jSONObject3.optInt("type");
                        String optString5 = jSONObject3.optString("content");
                        if (jSONObject3.has("body")) {
                            int optInt3 = jSONObject3.optInt("type", 1);
                            if (optInt3 == 1) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("text", jSONObject3.optString("body"));
                                optString5 = jSONObject4.toString();
                                i = optInt;
                                str = MessageParser.TAG;
                                i3 = 0;
                            } else if (optInt3 == 0) {
                                JSONArray jSONArray = new JSONArray(jSONObject3.optString("body"));
                                i2 = optInt2;
                                if (jSONArray.length() > 1) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    int i4 = 0;
                                    while (i4 < jSONArray.length()) {
                                        JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                                        String str3 = str2;
                                        JSONObject jSONObject5 = new JSONObject();
                                        jSONObject5.put("title", optJSONObject.optString("title"));
                                        jSONObject5.put("article_url", optJSONObject.optString("url"));
                                        jSONObject5.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject.optString("headImage"));
                                        jSONArray2.put(jSONObject5);
                                        i4++;
                                        str2 = str3;
                                        optInt = optInt;
                                    }
                                    i = optInt;
                                    str = str2;
                                    JSONObject jSONObject6 = new JSONObject();
                                    jSONObject6.put("articles", jSONArray2);
                                    optString5 = jSONObject6.toString();
                                    i3 = 9;
                                } else {
                                    i = optInt;
                                    str = MessageParser.TAG;
                                    if (jSONArray.length() == 1) {
                                        JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
                                        JSONObject jSONObject7 = new JSONObject();
                                        jSONObject7.put("title", optJSONObject2.optString("title"));
                                        jSONObject7.put("article_url", optJSONObject2.optString("url"));
                                        jSONObject7.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject2.optString("headImage"));
                                        optString5 = jSONObject7.toString();
                                        i3 = 8;
                                    }
                                    i3 = i2;
                                }
                            }
                            newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.context, this.category, i3, -1);
                            this.msg = newChatMsg;
                            if (newChatMsg != null) {
                                this.msgIsNull = true;
                                return this;
                            }
                            String optString6 = jSONObject.optString("ext");
                            if (!TextUtils.isEmpty(optString6)) {
                                int optInt4 = new JSONObject(optString6).optInt("sub_app_identity");
                                if (optInt4 == 7) {
                                    this.msg.setChatType(7);
                                } else if (optInt4 == 16) {
                                    this.msgIsNull = true;
                                    return this;
                                } else if (optInt4 == 17) {
                                    this.msg.setChatType(17);
                                } else if (optInt4 == 6) {
                                    this.msgIsNull = true;
                                    return this;
                                } else if (optInt4 == 19) {
                                    this.msg.setChatType(19);
                                } else if (optInt4 == 23) {
                                    this.msg.setChatType(23);
                                } else if (optInt4 == 24) {
                                    this.msg.setChatType(24);
                                } else if (optInt4 == 25) {
                                    this.msg.setChatType(25);
                                } else if (optInt4 == 26) {
                                    this.msg.setChatType(26);
                                } else if (optInt4 == 27) {
                                    this.msg.setChatType(27);
                                } else if (optInt4 == 29) {
                                    this.msg.setChatType(29);
                                } else if (Utility.availableNotificationPaType(optInt4)) {
                                    this.msg.setChatType(optInt4);
                                } else if (optInt4 == 20) {
                                    this.msg.setChatType(20);
                                }
                                this.msg.setMsgType(i3);
                                if (i3 == 18) {
                                    ((HtmlMsg) this.msg).setDesc(jSONObject2.optString("description"));
                                }
                                this.jsonParseResult = this.msg.setMsgContentFromServer(optString5);
                                this.msg.setmExtJson(optString6);
                                this.msg.setServiceType(optString2);
                                this.msg.setTemplateType(i);
                            } else {
                                LogUtils.e(str, "duzhan msg parse error! ext in content is null!");
                            }
                        }
                        i = optInt;
                        str = MessageParser.TAG;
                        i2 = optInt2;
                        i3 = i2;
                        newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.context, this.category, i3, -1);
                        this.msg = newChatMsg;
                        if (newChatMsg != null) {
                        }
                    } else {
                        LogUtils.e(MessageParser.TAG, "duzhan msg parse error! ext in text is null!");
                    }
                } else {
                    LogUtils.e(MessageParser.TAG, "duzhan msg parse error! msg in text is null!");
                }
            } else {
                LogUtils.e(MessageParser.TAG, "duzhan msg parse error! text in content is null!");
            }
            this.msgIsNull = false;
            return this;
        }

        public boolean isJsonParseResult() {
            return this.jsonParseResult;
        }

        public boolean isMsgNull() {
            return this.msgIsNull;
        }
    }

    public static void getAckNeedPainfos(final Context context, boolean z, final ArrayList<ChatMsg> arrayList, ArrayList<Long> arrayList2) {
        if (arrayList2.size() <= 0 || !z) {
            return;
        }
        LogUtils.d(TAG, "ack> will get remote pa, ids=" + arrayList2.toString());
        PaManager.getPaInfos(context, arrayList2, new IGetPaInfosListener() { // from class: com.baidu.android.imsdk.internal.MessageParser.2
            @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
            public void onResult(int i, String str, ArrayList<PaInfo> arrayList3) {
                LogUtils.d(MessageParser.TAG, "ack> get remote painfos, responseCode=" + i + ", strMsg=" + str);
                if (i != 0 || arrayList3 == null || arrayList3.size() <= 0) {
                    return;
                }
                LogUtils.d(MessageParser.TAG, "ack> get remote pa, painfos size=" + arrayList3.size());
                Iterator<PaInfo> it = arrayList3.iterator();
                while (it.hasNext()) {
                    PaInfo next = it.next();
                    PaInfoDBManager.getInstance(context).subscribePa(next);
                    ChatMessageDBManager.getInstance(context).updateSessionClass(next);
                }
                MessageParser.handleAck(context, arrayList, false);
            }
        });
    }

    public static String getPaPage(int i, int i2) {
        return i2 == 16 ? Constants.PAGE_SHANGXIONGHAO_NAME : i2 == 21 ? Constants.PAGE_XIAOCHENGXUKEFU_NAME : i == 7 ? Constants.PAGE_BAIJIAHAO_NAME : i == 17 ? Constants.PAGE_FUWUXIAOXI_NAME : (i == 1 || i == 5) ? Constants.PAGE_SHOWBAIFUWUHAO_NAME : (i == 19 || i == 6 || i == 29) ? Constants.PAGE_HUDONG_NAME : "";
    }

    public static synchronized List<NewAckMessage.Tripule> handleAck(Context context, ArrayList<ChatMsg> arrayList, boolean z) {
        List<NewAckMessage.Tripule> handleAck;
        synchronized (MessageParser.class) {
            handleAck = handleAck(context, arrayList, z, true);
        }
        return handleAck;
    }

    public static ChatMsg handleSysChatMsg(ChatMsg chatMsg) throws Exception {
        JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
        JSONObject jSONObject2 = new JSONObject();
        int notifyCmd = chatMsg.getNotifyCmd();
        if (notifyCmd == 0) {
            long j = jSONObject.getLong("from");
            jSONObject2.put("text", jSONObject.getString("description"));
            chatMsg.setFromUser(j);
        } else {
            if (notifyCmd == 1) {
                chatMsg.setFromUser(jSONObject.getLong("from"));
            }
            chatMsg.setMsgContentFromServer(jSONObject.toString());
            return chatMsg;
        }
        jSONObject = jSONObject2;
        chatMsg.setMsgContentFromServer(jSONObject.toString());
        return chatMsg;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x026c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x026e A[Catch: Exception -> 0x0328, TryCatch #5 {Exception -> 0x0328, blocks: (B:113:0x028c, B:115:0x0292, B:117:0x02ac, B:119:0x02be, B:120:0x02c5, B:122:0x02cd, B:126:0x02da, B:127:0x02dd, B:129:0x02e3, B:131:0x02e9, B:133:0x02ef, B:134:0x02f2, B:136:0x02f8, B:138:0x02fd, B:140:0x0309, B:142:0x0318, B:141:0x030d, B:107:0x0276, B:102:0x025f, B:106:0x026e), top: B:161:0x025f }] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ChatMsg parserMessage(Context context, JSONObject jSONObject, Type<Long> type, boolean z) {
        Context context2;
        String str;
        long j;
        long j2;
        int i;
        int i2;
        boolean z2;
        DuParser invokeParse;
        ChatMsg msg;
        boolean isJsonParseResult;
        ?? r1;
        try {
            long optLong = jSONObject.optLong("msgid");
            long optLong2 = jSONObject.optLong("from_user");
            long optLong3 = jSONObject.optLong("create_time");
            long optLong4 = jSONObject.optLong("contacter");
            String optString = jSONObject.optString("content");
            int optInt = jSONObject.optInt("category");
            type.t = Long.valueOf(optLong);
            if (optInt != 0) {
                if (optInt == 1) {
                    long optLong5 = jSONObject.optLong("group_id");
                    int optInt2 = jSONObject.optInt("type");
                    str = "";
                    ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt2, -1);
                    if (newChatMsg == null) {
                        return newChatMsg;
                    }
                    newChatMsg.setCategory(optInt);
                    newChatMsg.setContacter(optLong5);
                    newChatMsg.setFromUser(optLong2);
                    newChatMsg.setMsgType(optInt2);
                    isJsonParseResult = newChatMsg.setMsgContentFromServer(optString);
                    msg = newChatMsg;
                } else if (optInt != 2) {
                    if (optInt == 3) {
                        int i3 = jSONObject.getInt("cmd");
                        msg = ChatMsgFactory.getInstance().newChatMsg(context, 3, -1, i3);
                        if (msg == null) {
                            return msg;
                        }
                        msg.setCategory(optInt);
                        msg.setContacter(optLong4);
                        msg.setFromUser(optLong2);
                        msg.setNotifyCmd(i3);
                        isJsonParseResult = msg.setMsgContentFromServer(optString);
                    } else if (optInt == 4) {
                        int optInt3 = jSONObject.optInt("type");
                        msg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt3, -1);
                        if (msg == null) {
                            return msg;
                        }
                        msg.setCategory(optInt);
                        msg.setContacter(optLong4);
                        msg.setFromUser(optLong2);
                        msg.setMsgType(optInt3);
                        isJsonParseResult = msg.setMsgContentFromServer(optString);
                        ((TextMsg) msg).setCastId(optLong4);
                        if (ConversationStudioManImpl.getInstance(context).isReliable(optLong4)) {
                            ((TextMsg) msg).setCastId(optLong4);
                            ((TextMsg) msg).setPriority(jSONObject.optLong("prority"));
                            msg.setMsgContent(jSONObject.toString());
                        }
                        LogUtils.d("IMFetchMsgByIdMsg parse ", isJsonParseResult + "");
                    } else if (optInt != 6) {
                        str = "";
                        j = optLong;
                        isJsonParseResult = false;
                        msg = null;
                        context2 = context;
                    } else {
                        int optInt4 = jSONObject.optInt("type");
                        msg = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt4, -1);
                        if (msg == null) {
                            return msg;
                        }
                        msg.setCategory(optInt);
                        msg.setContacter(optLong4);
                        msg.setFromUser(optLong2);
                        msg.setMsgType(optInt4);
                        isJsonParseResult = msg.setMsgContentFromServer(optString);
                    }
                    str = "";
                } else {
                    int i4 = jSONObject.getInt("cmd");
                    ChatMsg newChatMsg2 = ChatMsgFactory.getInstance().newChatMsg(context, optInt, -1, i4);
                    if (newChatMsg2 == null) {
                        return newChatMsg2;
                    }
                    newChatMsg2.setCategory(optInt);
                    newChatMsg2.setContacter(optLong4);
                    newChatMsg2.setFromUser(optLong2);
                    boolean msgContentFromServer = newChatMsg2.setMsgContentFromServer(optString);
                    newChatMsg2.setNotifyCmd(i4);
                    ChatMsg handleSysChatMsg = handleSysChatMsg(newChatMsg2);
                    handleSysChatMsg.setMsgType(-1);
                    msg = handleSysChatMsg;
                    str = "";
                    isJsonParseResult = msgContentFromServer;
                }
                j = optLong;
                context2 = context;
            } else {
                str = "";
                int optInt5 = jSONObject.optInt("type");
                j = optLong;
                long optLong6 = jSONObject.optLong("msg_expires", 0L);
                int optInt6 = jSONObject.optInt(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE);
                try {
                    j2 = optLong6;
                    try {
                        i = new JSONObject(optString).optInt(TableDefine.MessageColumns.COLUME_TEMPLATE, 0);
                    } catch (JSONException e2) {
                        e = e2;
                        LogUtils.e(TAG, "parserMessage template_type:", e);
                        i = 0;
                        if (optInt5 == 80) {
                        }
                        i2 = 2;
                        z2 = false;
                        if (i != i2) {
                        }
                        if (z2) {
                        }
                        context2 = context;
                        try {
                            invokeParse = new DuParser(context2, optString, optInt).invokeParse();
                            if (!invokeParse.isMsgNull()) {
                            }
                        } catch (Exception e3) {
                            e = e3;
                            LogUtils.e(TAG, "parserMessage:", e);
                            new IMTrack.CrashBuilder(context2).exception(Log.getStackTraceString(e)).build();
                            return null;
                        }
                    }
                } catch (JSONException e4) {
                    e = e4;
                    j2 = optLong6;
                }
                if (((optInt5 == 80 || optInt6 == 11) && !(optInt5 == 0 && optInt6 == 10)) || i != 0) {
                    i2 = 2;
                    z2 = false;
                } else {
                    i2 = 2;
                    z2 = true;
                }
                boolean z3 = i != i2 || i == 3;
                try {
                    if (z2 && !z3) {
                        if ((i == 1 || i == 4) && optInt5 == 80) {
                            optInt5 = 0;
                        }
                        ChatMsg newChatMsg3 = ChatMsgFactory.getInstance().newChatMsg(context, optInt, optInt5, -1);
                        if (newChatMsg3 == null) {
                            return newChatMsg3;
                        }
                        newChatMsg3.setMsgType(optInt5);
                        boolean msgContentFromServer2 = newChatMsg3.setMsgContentFromServer(optString);
                        newChatMsg3.setTemplateType(i);
                        if (newChatMsg3.isDumiMessage()) {
                            newChatMsg3.setChatType(100);
                            LogUtils.d(TAG, "setchattype as dumi " + newChatMsg3.getMsgId());
                        }
                        newChatMsg3.setChatType(0);
                        if (optInt6 == 11) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("content"));
                                String optString2 = jSONObject2.optString("ext");
                                if (!TextUtils.isEmpty(optString2) && new JSONObject(optString2).optInt("sub_app_identity") == 20) {
                                    newChatMsg3.setChatType(20);
                                }
                                String optString3 = jSONObject2.optString("text");
                                if (!TextUtils.isEmpty(optString3)) {
                                    newChatMsg3.setMsgContent(optString3);
                                }
                                LogUtils.w(TAG, "parserMessage studioPa msg :" + newChatMsg3.toString());
                            } catch (Exception e5) {
                                LogUtils.e(TAG, "IM_BUSINESS_TYPE_STUDIO_USE_PA Exception :", e5);
                            }
                        }
                        isJsonParseResult = msgContentFromServer2;
                        msg = newChatMsg3;
                        context2 = context;
                    } else {
                        context2 = context;
                        invokeParse = new DuParser(context2, optString, optInt).invokeParse();
                        if (!invokeParse.isMsgNull()) {
                            return null;
                        }
                        msg = invokeParse.getMsg();
                        isJsonParseResult = invokeParse.isJsonParseResult();
                    }
                    msg.setCategory(optInt);
                    msg.setContacter(optLong4);
                    msg.setFromUser(optLong2);
                    msg.setExpiresTime(j2);
                } catch (Exception e6) {
                    e = e6;
                    context2 = context;
                    LogUtils.e(TAG, "parserMessage:", e);
                    new IMTrack.CrashBuilder(context2).exception(Log.getStackTraceString(e)).build();
                    return null;
                }
            }
            if (isJsonParseResult || !z) {
                if (msg != null) {
                    if (msg.shouldAbandonMsg(context2)) {
                        LogUtils.d(TAG, "msg will abandon for shouldAbandonMsg=true, msg=" + msg.toString());
                        return null;
                    }
                    msg.setMsgId(j);
                    msg.setMsgTime(optLong3);
                    if (jSONObject.has("appid")) {
                        msg.setAppId(jSONObject.optLong("appid"));
                    }
                    if (jSONObject.has("is_read")) {
                        int optInt7 = jSONObject.optInt("is_read");
                        msg.setMsgReaded(optInt7);
                        msg.setIsClicked(optInt7 == 1);
                    }
                    if (msg.isSelf(context2)) {
                        r1 = 1;
                        msg.setMsgReaded(1);
                    } else {
                        r1 = 1;
                    }
                    if (MsgUtility.isNotice(msg)) {
                        msg.setMsgReaded(r1);
                    }
                    if (msg.isMsgRead()) {
                        msg.setIsClicked(r1);
                    }
                    if (optInt == 0 && (Constants.PAFLAG & optLong4) != 0) {
                        msg.setPaid(optLong4);
                    } else {
                        msg.setPaid(jSONObject.optLong("pa_uid", -1L));
                    }
                    msg.setMsgKey(jSONObject.optString("msg_key", str));
                    msg.setDeviceFlag(2);
                }
                return msg;
            }
            return null;
        } catch (Exception e7) {
            e = e7;
            context2 = context;
        }
    }

    public static void sendNewAckToServer(final Context context, long j, List<NewAckMessage.Tripule> list, boolean z) {
        if (list == null || list.size() == 0) {
            return;
        }
        List<List<NewAckMessage.Tripule>> splitList = Utils.splitList(list, 20);
        if (splitList != null && splitList.size() > 0) {
            for (List<NewAckMessage.Tripule> list2 : splitList) {
                final NewAckMessage newAckMessage = new NewAckMessage(context, IMSDK.getInstance(context).getUk(), j, z);
                newAckMessage.addTriples(list2);
                if (a.f64551e) {
                    BLCPRequest bLCPRequest = new BLCPRequest();
                    bLCPRequest.f6377a = 2L;
                    bLCPRequest.f6378b = 95L;
                    bLCPRequest.f6379c = newAckMessage.getBody().getBytes();
                    bLCPRequest.f6380d = System.nanoTime();
                    d.b.s.a.b.a.c(bLCPRequest, new b() { // from class: com.baidu.android.imsdk.internal.MessageParser.3
                        @Override // d.b.s.a.b.d.b
                        public void onResponse(int i, String str, long j2, long j3, long j4, byte[] bArr) {
                            LogUtils.d(MessageParser.TAG, "MessageParser Ack Response err :" + i + ", methodId :" + j3 + ", data :" + bArr.length);
                            if (j3 == 95) {
                                try {
                                    NewAckMessage.this.handleMessageResult(context, new JSONObject(new String(bArr)), i, str);
                                    if (i != 0) {
                                        LogUtils.d(MessageParser.TAG, "ack failed，retry~~");
                                        AckHandlerThread.getInstance(context).getAckHandler().sendMessageDelayed(AckMessage.getSendMessage(1, NewAckMessage.this), 1000L);
                                    }
                                } catch (JSONException e2) {
                                    LogUtils.e(MessageParser.TAG, "handle sendNewAckToServer response, e :", e2);
                                }
                            }
                        }
                    });
                } else {
                    IMConnection.getInstance(context).sendMessage(newAckMessage, false);
                }
            }
            return;
        }
        LogUtils.e(TAG, "sendNewAckToServer splitList wrong!!!");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:42:0x0124
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.util.List<com.baidu.android.imsdk.request.NewAckMessage.Tripule> handleAck(android.content.Context r39, java.util.ArrayList<com.baidu.android.imsdk.chatmessage.messages.ChatMsg> r40, boolean r41, boolean r42) {
        /*
            r1 = r39
            r2 = r40
            java.lang.Class<com.baidu.android.imsdk.internal.MessageParser> r3 = com.baidu.android.imsdk.internal.MessageParser.class
            monitor-enter(r3)
            if (r2 == 0) goto L279
            int r0 = r40.size()     // Catch: java.lang.Throwable -> L276
            if (r0 != 0) goto L11
            goto L279
        L11:
            java.lang.String r0 = "MessageParser"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L276
            r5.<init>()     // Catch: java.lang.Throwable -> L276
            java.lang.String r6 = "ack type: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L276
            java.lang.String r6 = java.lang.String.valueOf(r42)     // Catch: java.lang.Throwable -> L276
            r5.append(r6)     // Catch: java.lang.Throwable -> L276
            java.lang.String r6 = ", ack> handleAck...number="
            r5.append(r6)     // Catch: java.lang.Throwable -> L276
            int r6 = r40.size()     // Catch: java.lang.Throwable -> L276
            r5.append(r6)     // Catch: java.lang.Throwable -> L276
            java.lang.String r6 = ", msgs:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L276
            java.lang.String r6 = r40.toString()     // Catch: java.lang.Throwable -> L276
            r5.append(r6)     // Catch: java.lang.Throwable -> L276
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L276
            com.baidu.android.imsdk.utils.LogUtils.d(r0, r5)     // Catch: java.lang.Throwable -> L276
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L276
            r5.<init>()     // Catch: java.lang.Throwable -> L276
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L276
            r6.<init>()     // Catch: java.lang.Throwable -> L276
            java.util.LinkedList r7 = new java.util.LinkedList     // Catch: java.lang.Throwable -> L276
            r7.<init>()     // Catch: java.lang.Throwable -> L276
            long r8 = com.baidu.android.imsdk.utils.Utility.getTriggerId(r39)     // Catch: java.lang.Throwable -> L276
            com.baidu.android.imsdk.account.AccountManagerImpl r0 = com.baidu.android.imsdk.account.AccountManagerImpl.getInstance(r39)     // Catch: java.lang.Throwable -> L276
            int r0 = r0.getLoginType()     // Catch: java.lang.Throwable -> L276
            r10 = 6
            if (r0 != r10) goto L64
            java.lang.String r0 = "cuid"
            goto L67
        L64:
            java.lang.String r0 = "uid"
        L67:
            r31 = r0
            long r32 = com.baidu.android.imsdk.account.AccountManager.getUK(r39)     // Catch: java.lang.Throwable -> L276
            r0 = 0
            r14 = 0
            r15 = 0
        L70:
            int r0 = r40.size()     // Catch: java.lang.Throwable -> L276
            if (r14 >= r0) goto L25d
            java.lang.Object r0 = r2.get(r14)     // Catch: java.lang.Throwable -> L276
            r13 = r0
            com.baidu.android.imsdk.chatmessage.messages.ChatMsg r13 = (com.baidu.android.imsdk.chatmessage.messages.ChatMsg) r13     // Catch: java.lang.Throwable -> L276
            if (r13 == 0) goto L24b
            int r11 = r13.getCategory()     // Catch: java.lang.Throwable -> L276
            int r17 = r13.getMsgType()     // Catch: java.lang.Throwable -> L276
            long r19 = r13.getFromUser()     // Catch: java.lang.Throwable -> L276
            r34 = r5
            long r4 = r13.getContacter()     // Catch: java.lang.Throwable -> L276
            java.lang.String r10 = ""
            java.lang.String r12 = ""
            java.lang.String r16 = ""
            java.lang.String r0 = ""
            r18 = -1
            r2 = 1
            if (r11 != r2) goto Lb4
            java.lang.String r0 = "qunxiaoxi"
            r30 = r10
            r29 = r12
            r27 = r14
            r2 = r34
            r25 = -1
            r26 = -1
            r28 = -1
        Lae:
            r34 = r16
        Lb0:
            r16 = r0
            goto L1ba
        Lb4:
            if (r11 != 0) goto L1a0
            r21 = 17592186044416(0x100000000000, double:8.691694759794E-311)
            long r21 = r4 & r21
            r23 = 0
            int r25 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r25 == 0) goto L184
            com.baidu.android.imsdk.pubaccount.PaInfo r21 = com.baidu.android.imsdk.pubaccount.PaManager.getPaInfo(r1, r4)     // Catch: java.lang.Throwable -> L276
            if (r21 == 0) goto L15b
            java.lang.String r0 = "MessageParser"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L276
            r2.<init>()     // Catch: java.lang.Throwable -> L276
            r25 = r10
            java.lang.String r10 = "ack> painfo in local db, paid="
            r2.append(r10)     // Catch: java.lang.Throwable -> L276
            r2.append(r4)     // Catch: java.lang.Throwable -> L276
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L276
            com.baidu.android.imsdk.utils.LogUtils.d(r0, r2)     // Catch: java.lang.Throwable -> L276
            int r2 = r21.getSubtype()     // Catch: java.lang.Throwable -> L276
            int r10 = r21.getSubsetType()     // Catch: java.lang.Throwable -> L276
            int r18 = r21.getClassType()     // Catch: java.lang.Throwable -> L276
            java.lang.String r0 = r21.getPaExt()     // Catch: java.lang.Throwable -> L276
            boolean r21 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L276
            if (r21 != 0) goto L145
            r26 = r12
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch: org.json.JSONException -> L136 java.lang.Throwable -> L276
            r12.<init>(r0)     // Catch: org.json.JSONException -> L136 java.lang.Throwable -> L276
            java.lang.String r0 = "msg_category"
            r27 = r14
            java.lang.String r14 = ""
            java.lang.String r14 = r12.optString(r0, r14)     // Catch: org.json.JSONException -> L134 java.lang.Throwable -> L276
            java.lang.String r0 = "business_source"
            r21 = r14
            java.lang.String r14 = ""
            java.lang.String r14 = r12.optString(r0, r14)     // Catch: org.json.JSONException -> L12c java.lang.Throwable -> L276
            java.lang.String r0 = "third_id"
            r22 = r14
            java.lang.String r14 = ""
            java.lang.String r16 = r12.optString(r0, r14)     // Catch: org.json.JSONException -> L122 java.lang.Throwable -> L276
            r12 = r21
            r25 = r22
            goto L149
        L122:
            r0 = move-exception
            goto L127
        L124:
            r0 = move-exception
            r22 = r14
        L127:
            r12 = r21
            r25 = r22
            goto L13b
        L12c:
            r0 = move-exception
            goto L131
        L12e:
            r0 = move-exception
            r21 = r14
        L131:
            r12 = r21
            goto L13b
        L134:
            r0 = move-exception
            goto L139
        L136:
            r0 = move-exception
            r27 = r14
        L139:
            r12 = r26
        L13b:
            java.lang.String r14 = "MessageParser"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L276
            com.baidu.android.imsdk.utils.LogUtils.d(r14, r0)     // Catch: java.lang.Throwable -> L276
            goto L149
        L145:
            r26 = r12
            r27 = r14
        L149:
            java.lang.String r0 = getPaPage(r2, r10)     // Catch: java.lang.Throwable -> L276
            r26 = r10
            r29 = r12
            r28 = r18
            r30 = r25
            r25 = r2
            r2 = r34
            goto Lae
        L15b:
            r25 = r10
            r26 = r12
            r27 = r14
            java.lang.String r2 = "MessageParser"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L276
            r10.<init>()     // Catch: java.lang.Throwable -> L276
            java.lang.String r12 = "ack> painfo not in local db, paid="
            r10.append(r12)     // Catch: java.lang.Throwable -> L276
            r10.append(r4)     // Catch: java.lang.Throwable -> L276
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L276
            com.baidu.android.imsdk.utils.LogUtils.d(r2, r10)     // Catch: java.lang.Throwable -> L276
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L276
            r6.add(r2)     // Catch: java.lang.Throwable -> L276
            r2 = r34
            r2.add(r13)     // Catch: java.lang.Throwable -> L276
            goto L192
        L184:
            r25 = r10
            r26 = r12
            r27 = r14
            r2 = r34
            int r10 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r10 != 0) goto L192
            java.lang.String r0 = "C2C"
        L192:
            r34 = r16
            r30 = r25
            r29 = r26
            r25 = -1
            r26 = -1
            r28 = -1
            goto Lb0
        L1a0:
            r25 = r10
            r26 = r12
            r27 = r14
            r2 = r34
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L276
            r0.<init>()     // Catch: java.lang.Throwable -> L276
            java.lang.String r10 = "others_category_"
            r0.append(r10)     // Catch: java.lang.Throwable -> L276
            r0.append(r11)     // Catch: java.lang.Throwable -> L276
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L276
            goto L192
        L1ba:
            java.lang.String r0 = r13.getExt()     // Catch: java.lang.Throwable -> L276
            if (r0 == 0) goto L1e5
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: org.json.JSONException -> L1d4 java.lang.Throwable -> L276
            r10.<init>(r0)     // Catch: org.json.JSONException -> L1d4 java.lang.Throwable -> L276
            java.lang.String r0 = "ack"
            boolean r0 = r10.has(r0)     // Catch: org.json.JSONException -> L1d4 java.lang.Throwable -> L276
            if (r0 == 0) goto L1e5
            java.lang.String r0 = "ack"
            org.json.JSONObject r0 = r10.getJSONObject(r0)     // Catch: org.json.JSONException -> L1d4 java.lang.Throwable -> L276
            goto L1e6
        L1d4:
            r0 = move-exception
            com.baidu.android.imsdk.upload.action.IMTrack$CrashBuilder r10 = new com.baidu.android.imsdk.upload.action.IMTrack$CrashBuilder     // Catch: java.lang.Throwable -> L276
            r10.<init>(r1)     // Catch: java.lang.Throwable -> L276
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch: java.lang.Throwable -> L276
            com.baidu.android.imsdk.upload.action.IMTrack$CrashBuilder r0 = r10.exception(r0)     // Catch: java.lang.Throwable -> L276
            r0.build()     // Catch: java.lang.Throwable -> L276
        L1e5:
            r0 = 0
        L1e6:
            com.baidu.android.imsdk.request.NewAckMessage$Tripule r14 = new com.baidu.android.imsdk.request.NewAckMessage$Tripule     // Catch: java.lang.Throwable -> L276
            long r21 = r13.getMsgId()     // Catch: java.lang.Throwable -> L276
            java.lang.String r18 = r13.getMsgKey()     // Catch: java.lang.Throwable -> L276
            long r23 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L276
            r10 = r14
            r35 = r8
            r8 = r11
            r11 = r21
            r9 = r13
            r13 = r18
            r1 = r14
            r37 = r15
            r38 = r27
            r14 = r23
            r18 = r31
            r21 = r32
            r23 = r4
            r27 = r28
            r28 = r29
            r29 = r30
            r30 = r34
            r10.<init>(r11, r13, r14, r16, r17, r18, r19, r21, r23, r25, r26, r27, r28, r29, r30)     // Catch: java.lang.Throwable -> L276
            long r4 = r9.getFromUser()     // Catch: java.lang.Throwable -> L276
            r1.setFromUser(r4)     // Catch: java.lang.Throwable -> L276
            if (r0 == 0) goto L221
            r1.setAck(r0)     // Catch: java.lang.Throwable -> L276
        L221:
            r0 = 4
            if (r8 != r0) goto L245
            r13 = r9
            com.baidu.android.imsdk.chatmessage.messages.TextMsg r13 = (com.baidu.android.imsdk.chatmessage.messages.TextMsg) r13     // Catch: java.lang.Throwable -> L276
            long r4 = r13.getCastId()     // Catch: java.lang.Throwable -> L276
            r1.setMcastId(r4)     // Catch: java.lang.Throwable -> L276
            com.baidu.android.imsdk.conversation.ConversationStudioManImpl r0 = com.baidu.android.imsdk.conversation.ConversationStudioManImpl.getInstance(r39)     // Catch: java.lang.Throwable -> L276
            r13 = r9
            com.baidu.android.imsdk.chatmessage.messages.TextMsg r13 = (com.baidu.android.imsdk.chatmessage.messages.TextMsg) r13     // Catch: java.lang.Throwable -> L276
            long r4 = r13.getCastId()     // Catch: java.lang.Throwable -> L276
            boolean r0 = r0.isReliable(r4)     // Catch: java.lang.Throwable -> L276
            if (r0 == 0) goto L245
            r4 = 1
            r1.setStudioIsReliable(r4)     // Catch: java.lang.Throwable -> L276
            r15 = 1
            goto L247
        L245:
            r15 = r37
        L247:
            r7.add(r1)     // Catch: java.lang.Throwable -> L276
            goto L252
        L24b:
            r2 = r5
            r35 = r8
            r38 = r14
            r37 = r15
        L252:
            int r14 = r38 + 1
            r1 = r39
            r5 = r2
            r8 = r35
            r2 = r40
            goto L70
        L25d:
            r2 = r5
            r35 = r8
            r37 = r15
            if (r42 != 0) goto L266
            monitor-exit(r3)
            return r7
        L266:
            r1 = r39
            r4 = r41
            getAckNeedPainfos(r1, r4, r2, r6)     // Catch: java.lang.Throwable -> L276
            r4 = r35
            r15 = r37
            sendNewAckToServer(r1, r4, r7, r15)     // Catch: java.lang.Throwable -> L276
            monitor-exit(r3)
            return r7
        L276:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L279:
            monitor-exit(r3)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.internal.MessageParser.handleAck(android.content.Context, java.util.ArrayList, boolean, boolean):java.util.List");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Long] */
    public static ArrayList<ChatMsg> parserMessage(final Context context, JSONArray jSONArray, Type<Long> type, boolean z, boolean z2) {
        final ArrayList<ChatMsg> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            try {
                Type type2 = new Type();
                type2.t = 0L;
                for (int i = 0; i < jSONArray.length(); i++) {
                    ChatMsg parserMessage = parserMessage(context, jSONArray.getJSONObject(i), type2, z);
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
                }
            } catch (Exception e2) {
                LogUtils.e(LogUtils.TAG, "parserMessage:", e2);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
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
}
