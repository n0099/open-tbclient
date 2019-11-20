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
    public static c I(JSONObject jSONObject) {
        JSONObject jSONObject2;
        c J;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("content");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        jSONObject2 = new JSONObject(optString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    J = J(jSONObject2);
                    if (J != null) {
                        J.msgId = jSONObject.optLong("msgid");
                        J.time = jSONObject.optLong("create_time");
                    }
                }
                jSONObject2 = null;
                J = J(jSONObject2);
                if (J != null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            J = null;
        }
        return J;
    }

    public static List<c> m(JSONArray jSONArray) {
        c I;
        ArrayList arrayList = null;
        if (jSONArray != null) {
            arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (I = I(optJSONObject)) != null) {
                    arrayList.add(I);
                }
            }
        }
        return arrayList;
    }

    public static c a(ChatMsg chatMsg) {
        try {
            c J = J(new JSONObject(chatMsg.getJsonContent()));
            if (f(J)) {
                J.msgId = chatMsg.getMsgId();
                J.time = chatMsg.getMsgTime();
                return J;
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
    private static c J(JSONObject jSONObject) {
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
                        cVar.auO = jSONObject2.optString("room_id");
                        cVar.auP = jSONObject2.optString("to_uid");
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
                                        cVar.avd = c(optInt, new JSONObject(optString2));
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return cVar;
                            default:
                                cVar.uid = jSONObject2.optString("uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString(PushMessageHelper.MESSAGE_TYPE))) {
                                    cVar.auQ = jSONObject2.optString(PushMessageHelper.MESSAGE_TYPE);
                                }
                                cVar.auS = jSONObject2.optString("character_name");
                                if (!TextUtils.isEmpty(jSONObject2.optString("character"))) {
                                    cVar.auR = jSONObject2.optString("character");
                                }
                                if (!TextUtils.isEmpty("vip")) {
                                    cVar.auT = jSONObject2.optString("vip");
                                }
                                cVar.name = jSONObject2.optString("name");
                                cVar.portrait = jSONObject2.optString("portrait");
                                cVar.content = jSONObject2.optString("content");
                                cVar.auV = jSONObject2.optString("at_uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_type"))) {
                                    cVar.auW = jSONObject2.optString("at_message_type");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_character"))) {
                                    cVar.auZ = jSONObject2.optString("at_character");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_vip"))) {
                                    cVar.auY = jSONObject2.optString("at_vip");
                                }
                                cVar.auX = jSONObject2.optString("at_name");
                                cVar.ava = jSONObject2.optString("at_character_name");
                                cVar.avb = jSONObject2.optString("at_portrait");
                                cVar.auU = K(jSONObject2);
                                cVar.content = jSONObject2.optString("content");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_body"))) {
                                    cVar.avc = L(jSONObject2);
                                }
                                JSONObject optJSONObject = jSONObject2.optJSONObject("ext_params");
                                if (optJSONObject != null) {
                                    cVar.ave = optJSONObject.toString();
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
                if (cVar.auU == null || (cVar.auU.avt == null && cVar.auU.avv == null && cVar.auU.avw == null && cVar.auU.avu == null)) {
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
                aVar.avg = jSONObject.optInt("totaluser");
                aVar.avf = jSONObject.optString("lastestuser");
                break;
            case 102:
                aVar.duration = jSONObject.optString("duration");
                aVar.avh = jSONObject.optString("total_users");
                aVar.avs = jSONObject.optString("close_ext");
                break;
            case 103:
                aVar.avi = jSONObject.optString("title");
                aVar.avj = jSONObject.optString("content");
                break;
            case 104:
                aVar.avk = jSONObject.optString("live_rtmp_url");
                aVar.avl = jSONObject.optString("live_flv_url");
                break;
            case 105:
                aVar.avm = jSONObject.optInt("mcast_id");
                aVar.avn = jSONObject.optInt("operation");
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
                                aVar.avo = I(jSONObject2);
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
                aVar.avm = jSONObject.optInt("mcast_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("msgids");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    aVar.avp = new long[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        aVar.avp[i2] = optJSONArray.optLong(i2);
                    }
                    break;
                }
                break;
            case 107:
            case 108:
                aVar.avq = jSONObject.optInt("service_type");
                JSONObject optJSONObject = jSONObject.optJSONObject("service_info");
                if (optJSONObject != null) {
                    aVar.avr = optJSONObject.toString();
                    break;
                }
                break;
        }
        return aVar;
    }

    private static c.C0042c K(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(jSONObject.optString("message_body"))) {
            return dp(jSONObject.optString("message_body"));
        }
        if (!TextUtils.isEmpty(jSONObject.optString("content"))) {
            String optString = jSONObject.optString("content");
            if (!TextUtils.isEmpty(optString)) {
                c.C0042c c0042c = new c.C0042c();
                c.e eVar = new c.e();
                eVar.word = optString;
                c0042c.avt = eVar;
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
                    c0042c.avt = eVar;
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
                    c0042c.avw = bVar;
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
                    fVar.avz = optString6;
                    c0042c.avv = fVar;
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
                        aVar.avz = jSONObject6.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
                        dVar.avx = aVar;
                        c0042c.avu = dVar;
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
                        aVar2.avz = jSONObject7.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
                        dVar.avy = aVar2;
                        c0042c.avu = dVar;
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

    private static c.C0042c L(JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("at_message_body"))) {
            return null;
        }
        return dp(jSONObject.optString("at_message_body"));
    }

    public static ChatMsg a(Context context, e eVar) {
        c cVar = new c();
        if (!TextUtils.isEmpty(eVar.auO)) {
            cVar.auO = eVar.auO;
        }
        if (!TextUtils.isEmpty(eVar.auR)) {
            cVar.auR = eVar.auR;
        }
        cVar.auS = eVar.auS;
        cVar.type = "0";
        com.baidu.c.a.b.a.a aVar = eVar.avB;
        String str = eVar.msg;
        if (aVar == null) {
            cVar.auQ = "0";
        } else if (TextUtils.isEmpty(str)) {
            if (aVar.getType() == 0) {
                cVar.auQ = "1";
            } else {
                cVar.auQ = "5";
            }
        } else if (aVar.getType() == 0) {
            cVar.auQ = "2";
        }
        com.baidu.c.a.a.a xe = com.baidu.c.b.a.aB(context).xe();
        b wV = xe != null ? xe.wV() : null;
        if (wV != null) {
            cVar.portrait = wV.wX();
            cVar.uid = wV.getUid();
            cVar.name = eVar.name;
        }
        c.C0042c c0042c = new c.C0042c();
        if (!TextUtils.isEmpty(str)) {
            c.e eVar2 = new c.e();
            eVar2.word = str;
            c0042c.avt = eVar2;
        }
        if (aVar != null && aVar.getType() == 0) {
            c.d dVar = new c.d();
            c.d.a aVar2 = new c.d.a();
            aVar2.url = aVar.getUrl();
            aVar2.width = aVar.getWidth();
            aVar2.height = aVar.xb();
            c.d.a aVar3 = new c.d.a();
            aVar3.url = aVar.getThumbUrl();
            aVar3.width = aVar.wZ();
            aVar3.height = aVar.xa();
            dVar.avx = aVar2;
            dVar.avy = aVar3;
            c0042c.avu = dVar;
        } else if (aVar != null && aVar.getType() == 1) {
            c.f fVar = new c.f();
            fVar.url = aVar.getUrl();
            fVar.duration = aVar.xc() + "";
            c0042c.avv = fVar;
        }
        cVar.auU = c0042c;
        cVar.ave = eVar.ave;
        c cVar2 = eVar.avA;
        if (cVar2 != null) {
            cVar.auV = cVar2.uid;
            cVar.auW = cVar2.auQ;
            cVar.auX = cVar2.name;
            cVar.auY = cVar2.auT;
            cVar.auZ = cVar2.auR;
            cVar.avb = cVar2.portrait;
            cVar.avc = cVar2.auU;
            cVar.ava = cVar2.auS;
            com.baidu.c.b.a.a.c.c(context, cVar);
        }
        cVar.content = com.baidu.c.b.a.a.c.a(context, cVar, true);
        if (xe == null || !xe.isLogin()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", cVar.auO + "");
            jSONObject.put("type", cVar.type + "");
            jSONObject.put("uid", cVar.uid);
            jSONObject.put("to_uid", cVar.auP);
            jSONObject.put(PushMessageHelper.MESSAGE_TYPE, cVar.auQ + "");
            jSONObject.put("character", cVar.auR + "");
            jSONObject.put("vip", cVar.auT + "");
            jSONObject.put("name", cVar.name);
            jSONObject.put("character_name", cVar.auS);
            jSONObject.put("portrait", cVar.portrait);
            jSONObject.put("content", cVar.content);
            if (!TextUtils.isEmpty(cVar.ave)) {
                jSONObject.put("ext_params", new JSONObject(cVar.ave));
            }
            if (cVar.auU != null) {
                JSONObject jSONObject2 = new JSONObject();
                c.C0042c c0042c2 = cVar.auU;
                if (cVar.auU.avt != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("word", c0042c2.avt.word);
                    jSONObject2.put("txt", jSONObject3);
                }
                if (cVar.auU.avu != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("width", c0042c2.avu.avx.width);
                    jSONObject5.put("height", c0042c2.avu.avx.height);
                    jSONObject5.put("url", c0042c2.avu.avx.url);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("width", c0042c2.avu.avy.width);
                    jSONObject6.put("height", c0042c2.avu.avy.height);
                    jSONObject6.put("url", c0042c2.avu.avy.url);
                    jSONObject4.put("origin", jSONObject5);
                    jSONObject4.put("thumbnail", jSONObject6);
                    jSONObject2.put("pic", jSONObject4);
                }
                if (cVar.auU.avv != null) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("url", c0042c2.avv.url);
                    jSONObject7.put("duration", c0042c2.avv.duration);
                    jSONObject2.put("voice", jSONObject7);
                }
                jSONObject.put("message_body", jSONObject2);
            }
            jSONObject.put("at_uid", cVar.auV);
            jSONObject.put("at_message_type", cVar.auW + "");
            jSONObject.put("at_name", cVar.auX);
            jSONObject.put("at_character_name", cVar.ava);
            jSONObject.put("at_vip", cVar.auY + "");
            jSONObject.put("at_character", cVar.auZ + "");
            jSONObject.put("at_portrait", cVar.avb);
            if (cVar.avc != null) {
                JSONObject jSONObject8 = new JSONObject();
                c.C0042c c0042c3 = cVar.avc;
                JSONObject jSONObject9 = new JSONObject();
                if (c0042c3.avt != null) {
                    jSONObject9.put("word", c0042c3.avt.word);
                }
                jSONObject8.put("txt", jSONObject9);
                JSONObject jSONObject10 = new JSONObject();
                if (c0042c3.avu != null) {
                    if (c0042c3.avu.avx != null) {
                        JSONObject jSONObject11 = new JSONObject();
                        jSONObject11.put("width", c0042c3.avu.avx.width);
                        jSONObject11.put("height", c0042c3.avu.avx.height);
                        jSONObject11.put("url", c0042c3.avu.avx.url);
                        jSONObject10.put("origin", jSONObject11);
                    }
                    if (c0042c3.avu.avy != null) {
                        JSONObject jSONObject12 = new JSONObject();
                        jSONObject12.put("width", c0042c3.avu.avy.width);
                        jSONObject12.put("height", c0042c3.avu.avy.height);
                        jSONObject12.put("url", c0042c3.avu.avy.url);
                        jSONObject10.put("thumbnail", jSONObject12);
                    }
                    jSONObject8.put("pic", jSONObject10);
                }
                if (c0042c3.avv != null) {
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("url", c0042c3.avv.url);
                    jSONObject13.put("duration", c0042c3.avv.duration);
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
