package com.baidu.livesdk.sdk.im.live.parser;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.livesdk.api.account.Account;
import com.baidu.livesdk.api.account.AccountBean;
import com.baidu.livesdk.api.im.live.ImageAudioMsg;
import com.baidu.livesdk.api.im.live.LiveMessageBean;
import com.baidu.livesdk.api.im.live.LiveSendMessage;
import com.baidu.livesdk.sdk.LiveSDK;
import com.baidu.livesdk.sdk.im.live.MessageUtils;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveMessageParser {
    public static final boolean DEBUG = false;
    public static final String TAG = "LiveMessageParser";

    public static boolean checkMessageValid(LiveMessageBean liveMessageBean) {
        if (liveMessageBean == null) {
            return false;
        }
        int i = -1;
        try {
            i = Integer.parseInt(liveMessageBean.type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i != 0) {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                    return true;
                default:
                    return false;
            }
        }
        LiveMessageBean.MessageBody messageBody = liveMessageBean.message_body;
        if (messageBody == null) {
            return false;
        }
        if (messageBody.txt == null && messageBody.voice == null && messageBody.link == null && messageBody.pic == null) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020 A[Catch: Exception -> 0x0032, TRY_LEAVE, TryCatch #1 {Exception -> 0x0032, blocks: (B:4:0x0003, B:6:0x000f, B:11:0x001a, B:13:0x0020, B:9:0x0016), top: B:20:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LiveMessageBean parseJson(JSONObject jSONObject) {
        JSONObject jSONObject2;
        LiveMessageBean parseContentJson;
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("content");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject2 = new JSONObject(optString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                parseContentJson = parseContentJson(jSONObject2);
                if (parseContentJson != null) {
                    parseContentJson.msgId = jSONObject.optLong("msgid");
                    parseContentJson.time = jSONObject.optLong("create_time");
                }
                return parseContentJson;
            }
            jSONObject2 = null;
            parseContentJson = parseContentJson(jSONObject2);
            if (parseContentJson != null) {
            }
            return parseContentJson;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static LiveMessageBean.MessageBody parseMessageBody(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(jSONObject.optString(RemoteMessageConst.MSGBODY))) {
            return parseMessageBody(jSONObject.optString(RemoteMessageConst.MSGBODY));
        }
        if (!TextUtils.isEmpty(jSONObject.optString("content"))) {
            String optString = jSONObject.optString("content");
            if (!TextUtils.isEmpty(optString)) {
                LiveMessageBean.MessageBody messageBody = new LiveMessageBean.MessageBody();
                LiveMessageBean.Txt txt = new LiveMessageBean.Txt();
                txt.word = optString;
                messageBody.txt = txt;
                return messageBody;
            }
            return null;
        }
        return null;
    }

    public static List<LiveMessageBean> getMessageList(JSONArray jSONArray) {
        LiveMessageBean parseJson;
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (parseJson = parseJson(optJSONObject)) != null) {
                    arrayList.add(parseJson);
                }
            }
            return arrayList;
        }
        return null;
    }

    public static LiveMessageBean.MessageBody parseAtMessageBody(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(jSONObject.optString("at_message_body"))) {
            return parseMessageBody(jSONObject.optString("at_message_body"));
        }
        return null;
    }

    public static LiveMessageBean parseChatMsg(ChatMsg chatMsg) {
        try {
            LiveMessageBean parseContentJson = parseContentJson(new JSONObject(chatMsg.getJsonContent()));
            if (checkMessageValid(parseContentJson)) {
                parseContentJson.msgId = chatMsg.getMsgId();
                parseContentJson.time = chatMsg.getMsgTime();
                return parseContentJson;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[Catch: Exception -> 0x002f, TryCatch #1 {Exception -> 0x002f, blocks: (B:4:0x0017, B:6:0x0024, B:14:0x0035, B:15:0x0053, B:24:0x0077, B:26:0x0087, B:27:0x008d, B:29:0x009f, B:30:0x00a5, B:32:0x00ab, B:33:0x00b1, B:35:0x00d9, B:36:0x00df, B:38:0x00e9, B:39:0x00ef, B:41:0x00f9, B:42:0x00ff, B:44:0x012f, B:45:0x0135, B:47:0x013d, B:17:0x005a, B:19:0x0066, B:22:0x0073, B:9:0x002b), top: B:53:0x0017, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LiveMessageBean parseContentJson(JSONObject jSONObject) {
        JSONObject jSONObject2;
        LiveMessageBean liveMessageBean = new LiveMessageBean();
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("text");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        jSONObject2 = new JSONObject(optString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jSONObject2 == null) {
                        int optInt = jSONObject2.optInt("type");
                        liveMessageBean.type = String.valueOf(optInt);
                        liveMessageBean.room_id = jSONObject2.optString("room_id");
                        liveMessageBean.to_uid = jSONObject2.optString("to_uid");
                        switch (optInt) {
                            case 100:
                            case 101:
                            case 102:
                            case 103:
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                            case 108:
                                String optString2 = jSONObject2.optString("data");
                                if (!TextUtils.isEmpty(optString2)) {
                                    try {
                                        liveMessageBean.data = parseDataFromJson(optInt, new JSONObject(optString2));
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return liveMessageBean;
                            default:
                                liveMessageBean.uid = jSONObject2.optString("uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString("message_type"))) {
                                    liveMessageBean.message_type = jSONObject2.optString("message_type");
                                }
                                liveMessageBean.character_name = jSONObject2.optString("character_name");
                                if (!TextUtils.isEmpty(jSONObject2.optString("character"))) {
                                    liveMessageBean.character = jSONObject2.optString("character");
                                }
                                if (!TextUtils.isEmpty("vip")) {
                                    liveMessageBean.vip = jSONObject2.optString("vip");
                                }
                                liveMessageBean.name = jSONObject2.optString("name");
                                liveMessageBean.portrait = jSONObject2.optString("portrait");
                                liveMessageBean.content = jSONObject2.optString("content");
                                liveMessageBean.at_uid = jSONObject2.optString("at_uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_type"))) {
                                    liveMessageBean.at_message_type = jSONObject2.optString("at_message_type");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_character"))) {
                                    liveMessageBean.at_character = jSONObject2.optString("at_character");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_vip"))) {
                                    liveMessageBean.at_vip = jSONObject2.optString("at_vip");
                                }
                                liveMessageBean.at_name = jSONObject2.optString("at_name");
                                liveMessageBean.at_character_name = jSONObject2.optString("at_character_name");
                                liveMessageBean.at_portrait = jSONObject2.optString("at_portrait");
                                liveMessageBean.message_body = parseMessageBody(jSONObject2);
                                liveMessageBean.content = jSONObject2.optString("content");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_body"))) {
                                    liveMessageBean.at_message_body = parseAtMessageBody(jSONObject2);
                                }
                                JSONObject optJSONObject = jSONObject2.optJSONObject("ext_params");
                                if (optJSONObject != null) {
                                    liveMessageBean.expand = optJSONObject.toString();
                                    return liveMessageBean;
                                }
                                return liveMessageBean;
                        }
                    }
                    return liveMessageBean;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }
        jSONObject2 = null;
        if (jSONObject2 == null) {
        }
    }

    public static LiveMessageBean.MessageBody parseMessageBody(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        LiveMessageBean.MessageBody messageBody = new LiveMessageBean.MessageBody();
        if (!TextUtils.isEmpty(jSONObject.optString("txt"))) {
            try {
                jSONObject4 = new JSONObject(jSONObject.optString("txt"));
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject4 = null;
            }
            if (jSONObject4 != null) {
                String optString = jSONObject4.optString(DownloadStatisticConstants.UBC_VALUE_WORD);
                LiveMessageBean.Txt txt = new LiveMessageBean.Txt();
                txt.word = optString;
                messageBody.txt = txt;
            }
        }
        if (!TextUtils.isEmpty(jSONObject.optString("link"))) {
            try {
                jSONObject3 = new JSONObject(jSONObject.optString("link"));
            } catch (JSONException e3) {
                e3.printStackTrace();
                jSONObject3 = null;
            }
            if (jSONObject3 != null) {
                String optString2 = jSONObject3.optString("title");
                String optString3 = jSONObject3.optString("url");
                LiveMessageBean.Link link = new LiveMessageBean.Link();
                link.title = optString2;
                link.url = optString3;
                messageBody.link = link;
            }
        }
        if (!TextUtils.isEmpty(jSONObject.optString("voice"))) {
            try {
                jSONObject2 = new JSONObject(jSONObject.optString("voice"));
            } catch (JSONException e4) {
                e4.printStackTrace();
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                String optString4 = jSONObject2.optString("url");
                String optString5 = jSONObject2.optString("duration");
                String optString6 = jSONObject2.optString("format");
                LiveMessageBean.Voice voice = new LiveMessageBean.Voice();
                voice.url = optString4;
                voice.duration = optString5;
                voice.format = optString6;
                messageBody.voice = voice;
            }
        }
        if (!TextUtils.isEmpty(jSONObject.optString("pic"))) {
            try {
                jSONObject5 = new JSONObject(jSONObject.optString("pic"));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            if (jSONObject5 != null) {
                String optString7 = jSONObject5.optString("origin");
                String optString8 = jSONObject5.optString("thumbnail");
                LiveMessageBean.Pic pic = new LiveMessageBean.Pic();
                try {
                    JSONObject jSONObject6 = new JSONObject(optString7);
                    LiveMessageBean.Pic.ImageInfo imageInfo = new LiveMessageBean.Pic.ImageInfo();
                    if (!TextUtils.isEmpty(jSONObject6.optString("width"))) {
                        imageInfo.width = jSONObject6.optInt("width");
                    }
                    if (!TextUtils.isEmpty(jSONObject6.optString("height"))) {
                        imageInfo.height = jSONObject6.optInt("height");
                    }
                    imageInfo.url = jSONObject6.optString("url");
                    imageInfo.format = jSONObject6.optString("format");
                    pic.origin = imageInfo;
                    messageBody.pic = pic;
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
                try {
                    JSONObject jSONObject7 = new JSONObject(optString8);
                    LiveMessageBean.Pic.ImageInfo imageInfo2 = new LiveMessageBean.Pic.ImageInfo();
                    if (!TextUtils.isEmpty(jSONObject7.optString("width"))) {
                        imageInfo2.width = jSONObject7.optInt("width");
                    }
                    if (!TextUtils.isEmpty(jSONObject7.optString("height"))) {
                        imageInfo2.height = jSONObject7.optInt("height");
                    }
                    imageInfo2.url = jSONObject7.optString("url");
                    imageInfo2.format = jSONObject7.optString("format");
                    pic.thumbnail = imageInfo2;
                    messageBody.pic = pic;
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            }
        }
        return messageBody;
    }

    public static LiveMessageBean.Data parseDataFromJson(int i, JSONObject jSONObject) {
        LiveMessageBean.Data data = new LiveMessageBean.Data();
        switch (i) {
            case 101:
                data.feedback = jSONObject.optInt("feedbacks");
                data.totaluser = jSONObject.optInt("totaluser");
                data.lasteruser = jSONObject.optString("lastestuser");
                break;
            case 102:
                data.duration = jSONObject.optString("duration");
                data.totalUsers = jSONObject.optString("total_users");
                data.closeExt = jSONObject.optString("close_ext");
                break;
            case 103:
                data.noticeTitle = jSONObject.optString("title");
                data.noticeContent = jSONObject.optString("content");
                break;
            case 104:
                data.liveRTMPUrl = jSONObject.optString("live_rtmp_url");
                data.liveFLVUrl = jSONObject.optString("live_flv_url");
                break;
            case 105:
                data.mcaseId = jSONObject.optInt("mcast_id");
                data.opreation = jSONObject.optInt(AppDownloadNetworkStateReceiver.KEY_OPERATION);
                String optString = jSONObject.optString("stick_msgs");
                if (!TextUtils.isEmpty(optString)) {
                    JSONArray jSONArray = null;
                    try {
                        jSONArray = new JSONArray(optString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jSONArray != null && jSONArray.length() > 0) {
                        try {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
                            if (jSONObject2 != null) {
                                data.stickMsg = parseJson(jSONObject2);
                                break;
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            break;
                        }
                    }
                }
                break;
            case 106:
                data.mcaseId = jSONObject.optInt("mcast_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("msgids");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    data.delMsgIds = new long[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        data.delMsgIds[i2] = optJSONArray.optLong(i2);
                    }
                    break;
                }
                break;
            case 107:
            case 108:
                data.serviceType = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
                JSONObject optJSONObject = jSONObject.optJSONObject("service_info");
                if (optJSONObject != null) {
                    data.serviceInfo = optJSONObject.toString();
                    break;
                }
                break;
        }
        return data;
    }

    public static ChatMsg trans2ChatMsg(Context context, LiveSendMessage liveSendMessage) {
        AccountBean accountBean;
        String str;
        String str2;
        String str3;
        LiveMessageBean liveMessageBean = new LiveMessageBean();
        if (!TextUtils.isEmpty(liveSendMessage.room_id)) {
            liveMessageBean.room_id = liveSendMessage.room_id;
        }
        if (!TextUtils.isEmpty(liveSendMessage.character)) {
            liveMessageBean.character = liveSendMessage.character;
        }
        liveMessageBean.character_name = liveSendMessage.character_name;
        liveMessageBean.type = "0";
        ImageAudioMsg imageAudioMsg = liveSendMessage.iaMsg;
        String str4 = liveSendMessage.msg;
        if (imageAudioMsg == null) {
            liveMessageBean.message_type = "0";
        } else if (TextUtils.isEmpty(str4)) {
            if (imageAudioMsg.getType() == 0) {
                liveMessageBean.message_type = "1";
            } else {
                liveMessageBean.message_type = "5";
            }
        } else if (imageAudioMsg.getType() == 0) {
            liveMessageBean.message_type = "2";
        }
        Account account = LiveSDK.getInstance(context).getAccount();
        if (account != null) {
            accountBean = account.accountInfo();
        } else {
            accountBean = null;
        }
        if (accountBean != null) {
            liveMessageBean.portrait = accountBean.getProtrait();
            liveMessageBean.uid = accountBean.getUid();
            liveMessageBean.name = liveSendMessage.name;
        }
        LiveMessageBean.MessageBody messageBody = new LiveMessageBean.MessageBody();
        if (!TextUtils.isEmpty(str4)) {
            LiveMessageBean.Txt txt = new LiveMessageBean.Txt();
            txt.word = str4;
            messageBody.txt = txt;
        }
        if (imageAudioMsg != null && imageAudioMsg.getType() == 0) {
            LiveMessageBean.Pic pic = new LiveMessageBean.Pic();
            LiveMessageBean.Pic.ImageInfo imageInfo = new LiveMessageBean.Pic.ImageInfo();
            imageInfo.url = imageAudioMsg.getUrl();
            imageInfo.width = imageAudioMsg.getWidth();
            imageInfo.height = imageAudioMsg.getHeigth();
            LiveMessageBean.Pic.ImageInfo imageInfo2 = new LiveMessageBean.Pic.ImageInfo();
            imageInfo2.url = imageAudioMsg.getThumbUrl();
            imageInfo2.width = imageAudioMsg.getThurbWidth();
            imageInfo2.height = imageAudioMsg.getThumbHeigth();
            pic.origin = imageInfo;
            pic.thumbnail = imageInfo2;
            messageBody.pic = pic;
        } else if (imageAudioMsg != null && imageAudioMsg.getType() == 1) {
            LiveMessageBean.Voice voice = new LiveMessageBean.Voice();
            voice.url = imageAudioMsg.getUrl();
            voice.duration = imageAudioMsg.getAudioDuration() + "";
            messageBody.voice = voice;
        }
        liveMessageBean.message_body = messageBody;
        liveMessageBean.expand = liveSendMessage.expand;
        LiveMessageBean liveMessageBean2 = liveSendMessage.liveMessageBean;
        if (liveMessageBean2 != null) {
            liveMessageBean.at_uid = liveMessageBean2.uid;
            liveMessageBean.at_message_type = liveMessageBean2.message_type;
            liveMessageBean.at_name = liveMessageBean2.name;
            liveMessageBean.at_vip = liveMessageBean2.vip;
            liveMessageBean.at_character = liveMessageBean2.character;
            liveMessageBean.at_portrait = liveMessageBean2.portrait;
            liveMessageBean.at_message_body = liveMessageBean2.message_body;
            liveMessageBean.at_character_name = liveMessageBean2.character_name;
            MessageUtils.trimReplayMessage(context, liveMessageBean);
        }
        liveMessageBean.content = MessageUtils.createOldVideoLiveMessage(context, liveMessageBean, true);
        if (account != null && account.isLogin()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("room_id", liveMessageBean.room_id + "");
                jSONObject.put("type", liveMessageBean.type + "");
                jSONObject.put("uid", liveMessageBean.uid);
                jSONObject.put("to_uid", liveMessageBean.to_uid);
                jSONObject.put("message_type", liveMessageBean.message_type + "");
                jSONObject.put("character", liveMessageBean.character + "");
                jSONObject.put("vip", liveMessageBean.vip + "");
                jSONObject.put("name", liveMessageBean.name);
                jSONObject.put("character_name", liveMessageBean.character_name);
                jSONObject.put("portrait", liveMessageBean.portrait);
                jSONObject.put("content", liveMessageBean.content);
                if (!TextUtils.isEmpty(liveMessageBean.expand)) {
                    jSONObject.put("ext_params", new JSONObject(liveMessageBean.expand));
                }
                if (liveMessageBean.message_body == null) {
                    str = "";
                    str2 = "txt";
                    str3 = DownloadStatisticConstants.UBC_VALUE_WORD;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    LiveMessageBean.MessageBody messageBody2 = liveMessageBean.message_body;
                    if (liveMessageBean.message_body.txt == null) {
                        str = "";
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        str = "";
                        jSONObject3.put(DownloadStatisticConstants.UBC_VALUE_WORD, messageBody2.txt.word);
                        jSONObject2.put("txt", jSONObject3);
                    }
                    if (liveMessageBean.message_body.pic == null) {
                        str2 = "txt";
                        str3 = DownloadStatisticConstants.UBC_VALUE_WORD;
                    } else {
                        JSONObject jSONObject4 = new JSONObject();
                        JSONObject jSONObject5 = new JSONObject();
                        str2 = "txt";
                        jSONObject5.put("width", messageBody2.pic.origin.width);
                        jSONObject5.put("height", messageBody2.pic.origin.height);
                        jSONObject5.put("url", messageBody2.pic.origin.url);
                        JSONObject jSONObject6 = new JSONObject();
                        str3 = DownloadStatisticConstants.UBC_VALUE_WORD;
                        jSONObject6.put("width", messageBody2.pic.thumbnail.width);
                        jSONObject6.put("height", messageBody2.pic.thumbnail.height);
                        jSONObject6.put("url", messageBody2.pic.thumbnail.url);
                        jSONObject4.put("origin", jSONObject5);
                        jSONObject4.put("thumbnail", jSONObject6);
                        jSONObject2.put("pic", jSONObject4);
                    }
                    if (liveMessageBean.message_body.voice != null) {
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("url", messageBody2.voice.url);
                        jSONObject7.put("duration", messageBody2.voice.duration);
                        jSONObject2.put("voice", jSONObject7);
                    }
                    jSONObject.put(RemoteMessageConst.MSGBODY, jSONObject2);
                }
                jSONObject.put("at_uid", liveMessageBean.at_uid);
                StringBuilder sb = new StringBuilder();
                sb.append(liveMessageBean.at_message_type);
                String str5 = str;
                sb.append(str5);
                jSONObject.put("at_message_type", sb.toString());
                jSONObject.put("at_name", liveMessageBean.at_name);
                jSONObject.put("at_character_name", liveMessageBean.at_character_name);
                jSONObject.put("at_vip", liveMessageBean.at_vip + str5);
                jSONObject.put("at_character", liveMessageBean.at_character + str5);
                jSONObject.put("at_portrait", liveMessageBean.at_portrait);
                if (liveMessageBean.at_message_body != null) {
                    JSONObject jSONObject8 = new JSONObject();
                    LiveMessageBean.MessageBody messageBody3 = liveMessageBean.at_message_body;
                    JSONObject jSONObject9 = new JSONObject();
                    if (messageBody3.txt != null) {
                        jSONObject9.put(str3, messageBody3.txt.word);
                    }
                    jSONObject8.put(str2, jSONObject9);
                    JSONObject jSONObject10 = new JSONObject();
                    if (messageBody3.pic != null) {
                        if (messageBody3.pic.origin != null) {
                            JSONObject jSONObject11 = new JSONObject();
                            jSONObject11.put("width", messageBody3.pic.origin.width);
                            jSONObject11.put("height", messageBody3.pic.origin.height);
                            jSONObject11.put("url", messageBody3.pic.origin.url);
                            jSONObject10.put("origin", jSONObject11);
                        }
                        if (messageBody3.pic.thumbnail != null) {
                            JSONObject jSONObject12 = new JSONObject();
                            jSONObject12.put("width", messageBody3.pic.thumbnail.width);
                            jSONObject12.put("height", messageBody3.pic.thumbnail.height);
                            jSONObject12.put("url", messageBody3.pic.thumbnail.url);
                            jSONObject10.put("thumbnail", jSONObject12);
                        }
                        jSONObject8.put("pic", jSONObject10);
                    }
                    if (messageBody3.voice != null) {
                        JSONObject jSONObject13 = new JSONObject();
                        jSONObject13.put("url", messageBody3.voice.url);
                        jSONObject13.put("duration", messageBody3.voice.duration);
                        jSONObject8.put("voice", jSONObject13);
                    }
                    jSONObject.put("at_message_body", jSONObject8);
                }
                TextMsg textMsg = new TextMsg();
                try {
                    textMsg.setCategory(4);
                    textMsg.setText(jSONObject.toString());
                } catch (Exception unused) {
                }
                return textMsg;
            } catch (Exception unused2) {
            }
        }
        return null;
    }
}
