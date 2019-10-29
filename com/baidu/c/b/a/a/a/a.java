package com.baidu.c.b.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.c.a.a.b;
import com.baidu.c.a.b.a.c;
import com.baidu.c.a.b.a.e;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:4:0x0003, B:6:0x0010, B:7:0x0015, B:9:0x001b, B:13:0x0030), top: B:18:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c H(JSONObject jSONObject) {
        JSONObject jSONObject2;
        c I;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("content");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        jSONObject2 = new JSONObject(optString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    I = I(jSONObject2);
                    if (I != null) {
                        I.msgId = jSONObject.optLong("msgid");
                        I.time = jSONObject.optLong("create_time");
                    }
                }
                jSONObject2 = null;
                I = I(jSONObject2);
                if (I != null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            I = null;
        }
        return I;
    }

    public static List<c> m(JSONArray jSONArray) {
        c H;
        ArrayList arrayList = null;
        if (jSONArray != null) {
            arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (H = H(optJSONObject)) != null) {
                    arrayList.add(H);
                }
            }
        }
        return arrayList;
    }

    public static c a(ChatMsg chatMsg) {
        try {
            c I = I(new JSONObject(chatMsg.getJsonContent()));
            if (f(I)) {
                I.msgId = chatMsg.getMsgId();
                I.time = chatMsg.getMsgTime();
                return I;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c A[Catch: Exception -> 0x0168, TRY_ENTER, TryCatch #2 {Exception -> 0x0168, blocks: (B:4:0x0008, B:6:0x0015, B:8:0x001c, B:9:0x003b, B:10:0x003e, B:12:0x0054, B:13:0x005d, B:15:0x0073, B:16:0x007c, B:18:0x0085, B:19:0x008e, B:21:0x00bf, B:22:0x00c8, B:24:0x00d5, B:25:0x00de, B:27:0x00eb, B:28:0x00f4, B:30:0x012b, B:31:0x0131, B:33:0x013a, B:39:0x0149, B:41:0x0156, B:44:0x0164, B:37:0x0143), top: B:52:0x0008, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static c I(JSONObject jSONObject) {
        JSONObject jSONObject2;
        c cVar = new c();
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("text");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        jSONObject2 = new JSONObject(optString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jSONObject2 != null) {
                        int optInt = jSONObject2.optInt("type");
                        cVar.type = String.valueOf(optInt);
                        cVar.avg = jSONObject2.optString("room_id");
                        cVar.avh = jSONObject2.optString("to_uid");
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
                                        cVar.avv = c(optInt, new JSONObject(optString2));
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return cVar;
                            default:
                                cVar.uid = jSONObject2.optString("uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString(PushMessageHelper.MESSAGE_TYPE))) {
                                    cVar.avi = jSONObject2.optString(PushMessageHelper.MESSAGE_TYPE);
                                }
                                cVar.avk = jSONObject2.optString("character_name");
                                if (!TextUtils.isEmpty(jSONObject2.optString("character"))) {
                                    cVar.avj = jSONObject2.optString("character");
                                }
                                if (!TextUtils.isEmpty("vip")) {
                                    cVar.avl = jSONObject2.optString("vip");
                                }
                                cVar.name = jSONObject2.optString("name");
                                cVar.portrait = jSONObject2.optString("portrait");
                                cVar.content = jSONObject2.optString("content");
                                cVar.avn = jSONObject2.optString("at_uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_type"))) {
                                    cVar.avo = jSONObject2.optString("at_message_type");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_character"))) {
                                    cVar.avr = jSONObject2.optString("at_character");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_vip"))) {
                                    cVar.avq = jSONObject2.optString("at_vip");
                                }
                                cVar.avp = jSONObject2.optString("at_name");
                                cVar.avs = jSONObject2.optString("at_character_name");
                                cVar.avt = jSONObject2.optString("at_portrait");
                                cVar.avm = J(jSONObject2);
                                cVar.content = jSONObject2.optString("content");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_body"))) {
                                    cVar.avu = K(jSONObject2);
                                }
                                JSONObject optJSONObject = jSONObject2.optJSONObject("ext_params");
                                if (optJSONObject != null) {
                                    cVar.avw = optJSONObject.toString();
                                    break;
                                }
                                break;
                        }
                    }
                    return cVar;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }
        jSONObject2 = null;
        if (jSONObject2 != null) {
        }
        return cVar;
    }

    private static boolean f(c cVar) {
        int i;
        boolean z = true;
        if (cVar == null) {
            return false;
        }
        try {
            i = Integer.parseInt(cVar.type);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        switch (i) {
            case 0:
                if (cVar.avm == null || (cVar.avm.avL == null && cVar.avm.avN == null && cVar.avm.avO == null && cVar.avm.avM == null)) {
                    z = false;
                }
                return z;
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

    private static c.a c(int i, JSONObject jSONObject) {
        JSONArray jSONArray;
        c.a aVar = new c.a();
        switch (i) {
            case 101:
                aVar.feedback = jSONObject.optInt("feedbacks");
                aVar.avy = jSONObject.optInt("totaluser");
                aVar.avx = jSONObject.optString("lastestuser");
                break;
            case 102:
                aVar.duration = jSONObject.optString("duration");
                aVar.avz = jSONObject.optString("total_users");
                aVar.avK = jSONObject.optString("close_ext");
                break;
            case 103:
                aVar.avA = jSONObject.optString("title");
                aVar.avB = jSONObject.optString("content");
                break;
            case 104:
                aVar.avC = jSONObject.optString("live_rtmp_url");
                aVar.avD = jSONObject.optString("live_flv_url");
                break;
            case 105:
                aVar.avE = jSONObject.optInt("mcast_id");
                aVar.avF = jSONObject.optInt("operation");
                String optString = jSONObject.optString("stick_msgs");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        jSONArray = new JSONArray(optString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        jSONArray = null;
                    }
                    if (jSONArray != null && jSONArray.length() > 0) {
                        try {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
                            if (jSONObject2 != null) {
                                aVar.avG = H(jSONObject2);
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
                aVar.avE = jSONObject.optInt("mcast_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("msgids");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    aVar.avH = new long[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        aVar.avH[i2] = optJSONArray.optLong(i2);
                    }
                    break;
                }
                break;
            case 107:
            case 108:
                aVar.avI = jSONObject.optInt("service_type");
                JSONObject optJSONObject = jSONObject.optJSONObject("service_info");
                if (optJSONObject != null) {
                    aVar.avJ = optJSONObject.toString();
                    break;
                }
                break;
        }
        return aVar;
    }

    private static c.C0042c J(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(jSONObject.optString("message_body"))) {
            return dp(jSONObject.optString("message_body"));
        }
        if (!TextUtils.isEmpty(jSONObject.optString("content"))) {
            String optString = jSONObject.optString("content");
            if (!TextUtils.isEmpty(optString)) {
                c.C0042c c0042c = new c.C0042c();
                c.e eVar = new c.e();
                eVar.word = optString;
                c0042c.avL = eVar;
                return c0042c;
            }
        }
        return null;
    }

    private static c.C0042c dp(String str) {
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
        if (jSONObject != null) {
            c.C0042c c0042c = new c.C0042c();
            if (!TextUtils.isEmpty(jSONObject.optString("txt"))) {
                try {
                    jSONObject4 = new JSONObject(jSONObject.optString("txt"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    jSONObject4 = null;
                }
                if (jSONObject4 != null) {
                    String optString = jSONObject4.optString("word");
                    c.e eVar = new c.e();
                    eVar.word = optString;
                    c0042c.avL = eVar;
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
                    c.b bVar = new c.b();
                    bVar.title = optString2;
                    bVar.url = optString3;
                    c0042c.avO = bVar;
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
                    String optString6 = jSONObject2.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
                    c.f fVar = new c.f();
                    fVar.url = optString4;
                    fVar.duration = optString5;
                    fVar.avR = optString6;
                    c0042c.avN = fVar;
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
                    c.d dVar = new c.d();
                    try {
                        JSONObject jSONObject6 = new JSONObject(optString7);
                        c.d.a aVar = new c.d.a();
                        if (!TextUtils.isEmpty(jSONObject6.optString("width"))) {
                            aVar.width = jSONObject6.optInt("width");
                        }
                        if (!TextUtils.isEmpty(jSONObject6.optString("height"))) {
                            aVar.height = jSONObject6.optInt("height");
                        }
                        aVar.url = jSONObject6.optString("url");
                        aVar.avR = jSONObject6.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
                        dVar.avP = aVar;
                        c0042c.avM = dVar;
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    try {
                        JSONObject jSONObject7 = new JSONObject(optString8);
                        c.d.a aVar2 = new c.d.a();
                        if (!TextUtils.isEmpty(jSONObject7.optString("width"))) {
                            aVar2.width = jSONObject7.optInt("width");
                        }
                        if (!TextUtils.isEmpty(jSONObject7.optString("height"))) {
                            aVar2.height = jSONObject7.optInt("height");
                        }
                        aVar2.url = jSONObject7.optString("url");
                        aVar2.avR = jSONObject7.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
                        dVar.avQ = aVar2;
                        c0042c.avM = dVar;
                        return c0042c;
                    } catch (JSONException e7) {
                        e7.printStackTrace();
                        return c0042c;
                    }
                }
                return c0042c;
            }
            return c0042c;
        }
        return null;
    }

    private static c.C0042c K(JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("at_message_body"))) {
            return null;
        }
        return dp(jSONObject.optString("at_message_body"));
    }

    public static ChatMsg a(Context context, e eVar) {
        c cVar = new c();
        if (!TextUtils.isEmpty(eVar.avg)) {
            cVar.avg = eVar.avg;
        }
        if (!TextUtils.isEmpty(eVar.avj)) {
            cVar.avj = eVar.avj;
        }
        cVar.avk = eVar.avk;
        cVar.type = "0";
        com.baidu.c.a.b.a.a aVar = eVar.avT;
        String str = eVar.msg;
        if (aVar == null) {
            cVar.avi = "0";
        } else if (TextUtils.isEmpty(str)) {
            if (aVar.getType() == 0) {
                cVar.avi = "1";
            } else {
                cVar.avi = "5";
            }
        } else if (aVar.getType() == 0) {
            cVar.avi = "2";
        }
        com.baidu.c.a.a.a xd = com.baidu.c.b.a.aB(context).xd();
        b wU = xd != null ? xd.wU() : null;
        if (wU != null) {
            cVar.portrait = wU.wW();
            cVar.uid = wU.getUid();
            cVar.name = eVar.name;
        }
        c.C0042c c0042c = new c.C0042c();
        if (!TextUtils.isEmpty(str)) {
            c.e eVar2 = new c.e();
            eVar2.word = str;
            c0042c.avL = eVar2;
        }
        if (aVar != null && aVar.getType() == 0) {
            c.d dVar = new c.d();
            c.d.a aVar2 = new c.d.a();
            aVar2.url = aVar.getUrl();
            aVar2.width = aVar.getWidth();
            aVar2.height = aVar.xa();
            c.d.a aVar3 = new c.d.a();
            aVar3.url = aVar.getThumbUrl();
            aVar3.width = aVar.wY();
            aVar3.height = aVar.wZ();
            dVar.avP = aVar2;
            dVar.avQ = aVar3;
            c0042c.avM = dVar;
        } else if (aVar != null && aVar.getType() == 1) {
            c.f fVar = new c.f();
            fVar.url = aVar.getUrl();
            fVar.duration = aVar.xb() + "";
            c0042c.avN = fVar;
        }
        cVar.avm = c0042c;
        cVar.avw = eVar.avw;
        c cVar2 = eVar.avS;
        if (cVar2 != null) {
            cVar.avn = cVar2.uid;
            cVar.avo = cVar2.avi;
            cVar.avp = cVar2.name;
            cVar.avq = cVar2.avl;
            cVar.avr = cVar2.avj;
            cVar.avt = cVar2.portrait;
            cVar.avu = cVar2.avm;
            cVar.avs = cVar2.avk;
            com.baidu.c.b.a.a.c.c(context, cVar);
        }
        cVar.content = com.baidu.c.b.a.a.c.a(context, cVar, true);
        if (xd == null || !xd.isLogin()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", cVar.avg + "");
            jSONObject.put("type", cVar.type + "");
            jSONObject.put("uid", cVar.uid);
            jSONObject.put("to_uid", cVar.avh);
            jSONObject.put(PushMessageHelper.MESSAGE_TYPE, cVar.avi + "");
            jSONObject.put("character", cVar.avj + "");
            jSONObject.put("vip", cVar.avl + "");
            jSONObject.put("name", cVar.name);
            jSONObject.put("character_name", cVar.avk);
            jSONObject.put("portrait", cVar.portrait);
            jSONObject.put("content", cVar.content);
            if (!TextUtils.isEmpty(cVar.avw)) {
                jSONObject.put("ext_params", new JSONObject(cVar.avw));
            }
            if (cVar.avm != null) {
                JSONObject jSONObject2 = new JSONObject();
                c.C0042c c0042c2 = cVar.avm;
                if (cVar.avm.avL != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("word", c0042c2.avL.word);
                    jSONObject2.put("txt", jSONObject3);
                }
                if (cVar.avm.avM != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("width", c0042c2.avM.avP.width);
                    jSONObject5.put("height", c0042c2.avM.avP.height);
                    jSONObject5.put("url", c0042c2.avM.avP.url);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("width", c0042c2.avM.avQ.width);
                    jSONObject6.put("height", c0042c2.avM.avQ.height);
                    jSONObject6.put("url", c0042c2.avM.avQ.url);
                    jSONObject4.put("origin", jSONObject5);
                    jSONObject4.put("thumbnail", jSONObject6);
                    jSONObject2.put("pic", jSONObject4);
                }
                if (cVar.avm.avN != null) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("url", c0042c2.avN.url);
                    jSONObject7.put("duration", c0042c2.avN.duration);
                    jSONObject2.put("voice", jSONObject7);
                }
                jSONObject.put("message_body", jSONObject2);
            }
            jSONObject.put("at_uid", cVar.avn);
            jSONObject.put("at_message_type", cVar.avo + "");
            jSONObject.put("at_name", cVar.avp);
            jSONObject.put("at_character_name", cVar.avs);
            jSONObject.put("at_vip", cVar.avq + "");
            jSONObject.put("at_character", cVar.avr + "");
            jSONObject.put("at_portrait", cVar.avt);
            if (cVar.avu != null) {
                JSONObject jSONObject8 = new JSONObject();
                c.C0042c c0042c3 = cVar.avu;
                JSONObject jSONObject9 = new JSONObject();
                if (c0042c3.avL != null) {
                    jSONObject9.put("word", c0042c3.avL.word);
                }
                jSONObject8.put("txt", jSONObject9);
                JSONObject jSONObject10 = new JSONObject();
                if (c0042c3.avM != null) {
                    if (c0042c3.avM.avP != null) {
                        JSONObject jSONObject11 = new JSONObject();
                        jSONObject11.put("width", c0042c3.avM.avP.width);
                        jSONObject11.put("height", c0042c3.avM.avP.height);
                        jSONObject11.put("url", c0042c3.avM.avP.url);
                        jSONObject10.put("origin", jSONObject11);
                    }
                    if (c0042c3.avM.avQ != null) {
                        JSONObject jSONObject12 = new JSONObject();
                        jSONObject12.put("width", c0042c3.avM.avQ.width);
                        jSONObject12.put("height", c0042c3.avM.avQ.height);
                        jSONObject12.put("url", c0042c3.avM.avQ.url);
                        jSONObject10.put("thumbnail", jSONObject12);
                    }
                    jSONObject8.put("pic", jSONObject10);
                }
                if (c0042c3.avN != null) {
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("url", c0042c3.avN.url);
                    jSONObject13.put("duration", c0042c3.avN.duration);
                    jSONObject8.put("voice", jSONObject13);
                }
                jSONObject.put("at_message_body", jSONObject8);
            }
            TextMsg textMsg = new TextMsg();
            try {
                textMsg.setCategory(4);
                textMsg.setText(jSONObject.toString());
                return textMsg;
            } catch (Exception e) {
                return textMsg;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
