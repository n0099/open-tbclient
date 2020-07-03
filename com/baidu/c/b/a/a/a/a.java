package com.baidu.c.b.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.c.a.a.b;
import com.baidu.c.a.b.a.c;
import com.baidu.c.a.b.a.e;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
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
    public static c U(JSONObject jSONObject) {
        JSONObject jSONObject2;
        c V;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("content");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        jSONObject2 = new JSONObject(optString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    V = V(jSONObject2);
                    if (V != null) {
                        V.msgId = jSONObject.optLong("msgid");
                        V.time = jSONObject.optLong("create_time");
                    }
                }
                jSONObject2 = null;
                V = V(jSONObject2);
                if (V != null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            V = null;
        }
        return V;
    }

    public static List<c> n(JSONArray jSONArray) {
        c U;
        ArrayList arrayList = null;
        if (jSONArray != null) {
            arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (U = U(optJSONObject)) != null) {
                    arrayList.add(U);
                }
            }
        }
        return arrayList;
    }

    public static c a(ChatMsg chatMsg) {
        try {
            c V = V(new JSONObject(chatMsg.getJsonContent()));
            if (f(V)) {
                V.msgId = chatMsg.getMsgId();
                V.time = chatMsg.getMsgTime();
                return V;
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
    private static c V(JSONObject jSONObject) {
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
                        cVar.bqs = jSONObject2.optString("room_id");
                        cVar.bqt = jSONObject2.optString("to_uid");
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
                                        cVar.bqH = c(optInt, new JSONObject(optString2));
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return cVar;
                            default:
                                cVar.uid = jSONObject2.optString("uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString(PushMessageHelper.MESSAGE_TYPE))) {
                                    cVar.bqu = jSONObject2.optString(PushMessageHelper.MESSAGE_TYPE);
                                }
                                cVar.bqw = jSONObject2.optString("character_name");
                                if (!TextUtils.isEmpty(jSONObject2.optString("character"))) {
                                    cVar.bqv = jSONObject2.optString("character");
                                }
                                if (!TextUtils.isEmpty("vip")) {
                                    cVar.bqx = jSONObject2.optString("vip");
                                }
                                cVar.name = jSONObject2.optString("name");
                                cVar.portrait = jSONObject2.optString("portrait");
                                cVar.content = jSONObject2.optString("content");
                                cVar.bqz = jSONObject2.optString("at_uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_type"))) {
                                    cVar.bqA = jSONObject2.optString("at_message_type");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_character"))) {
                                    cVar.bqD = jSONObject2.optString("at_character");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_vip"))) {
                                    cVar.bqC = jSONObject2.optString("at_vip");
                                }
                                cVar.bqB = jSONObject2.optString("at_name");
                                cVar.bqE = jSONObject2.optString("at_character_name");
                                cVar.bqF = jSONObject2.optString("at_portrait");
                                cVar.bqy = W(jSONObject2);
                                cVar.content = jSONObject2.optString("content");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_body"))) {
                                    cVar.bqG = X(jSONObject2);
                                }
                                JSONObject optJSONObject = jSONObject2.optJSONObject("ext_params");
                                if (optJSONObject != null) {
                                    cVar.bqI = optJSONObject.toString();
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
                if (cVar.bqy == null || (cVar.bqy.bqX == null && cVar.bqy.bqZ == null && cVar.bqy.bra == null && cVar.bqy.bqY == null)) {
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
                aVar.bqK = jSONObject.optInt("totaluser");
                aVar.bqJ = jSONObject.optString("lastestuser");
                break;
            case 102:
                aVar.duration = jSONObject.optString("duration");
                aVar.bqL = jSONObject.optString("total_users");
                aVar.bqW = jSONObject.optString("close_ext");
                break;
            case 103:
                aVar.bqM = jSONObject.optString("title");
                aVar.bqN = jSONObject.optString("content");
                break;
            case 104:
                aVar.bqO = jSONObject.optString("live_rtmp_url");
                aVar.bqP = jSONObject.optString("live_flv_url");
                break;
            case 105:
                aVar.bqQ = jSONObject.optInt("mcast_id");
                aVar.bqR = jSONObject.optInt("operation");
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
                                aVar.bqS = U(jSONObject2);
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
                aVar.bqQ = jSONObject.optInt("mcast_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("msgids");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    aVar.bqT = new long[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        aVar.bqT[i2] = optJSONArray.optLong(i2);
                    }
                    break;
                }
                break;
            case 107:
            case 108:
                aVar.bqU = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
                JSONObject optJSONObject = jSONObject.optJSONObject("service_info");
                if (optJSONObject != null) {
                    aVar.bqV = optJSONObject.toString();
                    break;
                }
                break;
        }
        return aVar;
    }

    private static c.C0096c W(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(jSONObject.optString("message_body"))) {
            return gk(jSONObject.optString("message_body"));
        }
        if (!TextUtils.isEmpty(jSONObject.optString("content"))) {
            String optString = jSONObject.optString("content");
            if (!TextUtils.isEmpty(optString)) {
                c.C0096c c0096c = new c.C0096c();
                c.e eVar = new c.e();
                eVar.word = optString;
                c0096c.bqX = eVar;
                return c0096c;
            }
        }
        return null;
    }

    private static c.C0096c gk(String str) {
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
            c.C0096c c0096c = new c.C0096c();
            if (!TextUtils.isEmpty(jSONObject.optString(DocumentOpenUtil.TXT))) {
                try {
                    jSONObject4 = new JSONObject(jSONObject.optString(DocumentOpenUtil.TXT));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    jSONObject4 = null;
                }
                if (jSONObject4 != null) {
                    String optString = jSONObject4.optString("word");
                    c.e eVar = new c.e();
                    eVar.word = optString;
                    c0096c.bqX = eVar;
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
                    c0096c.bra = bVar;
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
                    fVar.format = optString6;
                    c0096c.bqZ = fVar;
                }
            }
            if (!TextUtils.isEmpty(jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN))) {
                try {
                    jSONObject5 = new JSONObject(jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN));
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
                        aVar.format = jSONObject6.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
                        dVar.brb = aVar;
                        c0096c.bqY = dVar;
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
                        aVar2.format = jSONObject7.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
                        dVar.brc = aVar2;
                        c0096c.bqY = dVar;
                        return c0096c;
                    } catch (JSONException e7) {
                        e7.printStackTrace();
                        return c0096c;
                    }
                }
                return c0096c;
            }
            return c0096c;
        }
        return null;
    }

    private static c.C0096c X(JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("at_message_body"))) {
            return null;
        }
        return gk(jSONObject.optString("at_message_body"));
    }

    public static ChatMsg a(Context context, e eVar) {
        c cVar = new c();
        if (!TextUtils.isEmpty(eVar.bqs)) {
            cVar.bqs = eVar.bqs;
        }
        if (!TextUtils.isEmpty(eVar.bqv)) {
            cVar.bqv = eVar.bqv;
        }
        cVar.bqw = eVar.bqw;
        cVar.type = "0";
        com.baidu.c.a.b.a.a aVar = eVar.bre;
        String str = eVar.msg;
        if (aVar == null) {
            cVar.bqu = "0";
        } else if (TextUtils.isEmpty(str)) {
            if (aVar.getType() == 0) {
                cVar.bqu = "1";
            } else {
                cVar.bqu = "5";
            }
        } else if (aVar.getType() == 0) {
            cVar.bqu = "2";
        }
        com.baidu.c.a.a.a Lc = com.baidu.c.b.a.aA(context).Lc();
        b KU = Lc != null ? Lc.KU() : null;
        if (KU != null) {
            cVar.portrait = KU.KV();
            cVar.uid = KU.getUid();
            cVar.name = eVar.name;
        }
        c.C0096c c0096c = new c.C0096c();
        if (!TextUtils.isEmpty(str)) {
            c.e eVar2 = new c.e();
            eVar2.word = str;
            c0096c.bqX = eVar2;
        }
        if (aVar != null && aVar.getType() == 0) {
            c.d dVar = new c.d();
            c.d.a aVar2 = new c.d.a();
            aVar2.url = aVar.getUrl();
            aVar2.width = aVar.getWidth();
            aVar2.height = aVar.KZ();
            c.d.a aVar3 = new c.d.a();
            aVar3.url = aVar.getThumbUrl();
            aVar3.width = aVar.KX();
            aVar3.height = aVar.KY();
            dVar.brb = aVar2;
            dVar.brc = aVar3;
            c0096c.bqY = dVar;
        } else if (aVar != null && aVar.getType() == 1) {
            c.f fVar = new c.f();
            fVar.url = aVar.getUrl();
            fVar.duration = aVar.La() + "";
            c0096c.bqZ = fVar;
        }
        cVar.bqy = c0096c;
        cVar.bqI = eVar.bqI;
        c cVar2 = eVar.brd;
        if (cVar2 != null) {
            cVar.bqz = cVar2.uid;
            cVar.bqA = cVar2.bqu;
            cVar.bqB = cVar2.name;
            cVar.bqC = cVar2.bqx;
            cVar.bqD = cVar2.bqv;
            cVar.bqF = cVar2.portrait;
            cVar.bqG = cVar2.bqy;
            cVar.bqE = cVar2.bqw;
            com.baidu.c.b.a.a.c.c(context, cVar);
        }
        cVar.content = com.baidu.c.b.a.a.c.a(context, cVar, true);
        if (Lc == null || !Lc.isLogin()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", cVar.bqs + "");
            jSONObject.put("type", cVar.type + "");
            jSONObject.put("uid", cVar.uid);
            jSONObject.put("to_uid", cVar.bqt);
            jSONObject.put(PushMessageHelper.MESSAGE_TYPE, cVar.bqu + "");
            jSONObject.put("character", cVar.bqv + "");
            jSONObject.put("vip", cVar.bqx + "");
            jSONObject.put("name", cVar.name);
            jSONObject.put("character_name", cVar.bqw);
            jSONObject.put("portrait", cVar.portrait);
            jSONObject.put("content", cVar.content);
            if (!TextUtils.isEmpty(cVar.bqI)) {
                jSONObject.put("ext_params", new JSONObject(cVar.bqI));
            }
            if (cVar.bqy != null) {
                JSONObject jSONObject2 = new JSONObject();
                c.C0096c c0096c2 = cVar.bqy;
                if (cVar.bqy.bqX != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("word", c0096c2.bqX.word);
                    jSONObject2.put(DocumentOpenUtil.TXT, jSONObject3);
                }
                if (cVar.bqy.bqY != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("width", c0096c2.bqY.brb.width);
                    jSONObject5.put("height", c0096c2.bqY.brb.height);
                    jSONObject5.put("url", c0096c2.bqY.brb.url);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("width", c0096c2.bqY.brc.width);
                    jSONObject6.put("height", c0096c2.bqY.brc.height);
                    jSONObject6.put("url", c0096c2.bqY.brc.url);
                    jSONObject4.put("origin", jSONObject5);
                    jSONObject4.put("thumbnail", jSONObject6);
                    jSONObject2.put(UgcUBCUtils.UGC_TYPE_PIC_BTN, jSONObject4);
                }
                if (cVar.bqy.bqZ != null) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("url", c0096c2.bqZ.url);
                    jSONObject7.put("duration", c0096c2.bqZ.duration);
                    jSONObject2.put("voice", jSONObject7);
                }
                jSONObject.put("message_body", jSONObject2);
            }
            jSONObject.put("at_uid", cVar.bqz);
            jSONObject.put("at_message_type", cVar.bqA + "");
            jSONObject.put("at_name", cVar.bqB);
            jSONObject.put("at_character_name", cVar.bqE);
            jSONObject.put("at_vip", cVar.bqC + "");
            jSONObject.put("at_character", cVar.bqD + "");
            jSONObject.put("at_portrait", cVar.bqF);
            if (cVar.bqG != null) {
                JSONObject jSONObject8 = new JSONObject();
                c.C0096c c0096c3 = cVar.bqG;
                JSONObject jSONObject9 = new JSONObject();
                if (c0096c3.bqX != null) {
                    jSONObject9.put("word", c0096c3.bqX.word);
                }
                jSONObject8.put(DocumentOpenUtil.TXT, jSONObject9);
                JSONObject jSONObject10 = new JSONObject();
                if (c0096c3.bqY != null) {
                    if (c0096c3.bqY.brb != null) {
                        JSONObject jSONObject11 = new JSONObject();
                        jSONObject11.put("width", c0096c3.bqY.brb.width);
                        jSONObject11.put("height", c0096c3.bqY.brb.height);
                        jSONObject11.put("url", c0096c3.bqY.brb.url);
                        jSONObject10.put("origin", jSONObject11);
                    }
                    if (c0096c3.bqY.brc != null) {
                        JSONObject jSONObject12 = new JSONObject();
                        jSONObject12.put("width", c0096c3.bqY.brc.width);
                        jSONObject12.put("height", c0096c3.bqY.brc.height);
                        jSONObject12.put("url", c0096c3.bqY.brc.url);
                        jSONObject10.put("thumbnail", jSONObject12);
                    }
                    jSONObject8.put(UgcUBCUtils.UGC_TYPE_PIC_BTN, jSONObject10);
                }
                if (c0096c3.bqZ != null) {
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("url", c0096c3.bqZ.url);
                    jSONObject13.put("duration", c0096c3.bqZ.duration);
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
