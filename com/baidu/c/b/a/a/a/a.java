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
    public static c P(JSONObject jSONObject) {
        JSONObject jSONObject2;
        c Q;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("content");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        jSONObject2 = new JSONObject(optString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Q = Q(jSONObject2);
                    if (Q != null) {
                        Q.msgId = jSONObject.optLong("msgid");
                        Q.time = jSONObject.optLong("create_time");
                    }
                }
                jSONObject2 = null;
                Q = Q(jSONObject2);
                if (Q != null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            Q = null;
        }
        return Q;
    }

    public static List<c> n(JSONArray jSONArray) {
        c P;
        ArrayList arrayList = null;
        if (jSONArray != null) {
            arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (P = P(optJSONObject)) != null) {
                    arrayList.add(P);
                }
            }
        }
        return arrayList;
    }

    public static c a(ChatMsg chatMsg) {
        try {
            c Q = Q(new JSONObject(chatMsg.getJsonContent()));
            if (f(Q)) {
                Q.msgId = chatMsg.getMsgId();
                Q.time = chatMsg.getMsgTime();
                return Q;
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
    private static c Q(JSONObject jSONObject) {
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
                        cVar.blr = jSONObject2.optString("room_id");
                        cVar.bls = jSONObject2.optString("to_uid");
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
                                        cVar.blG = c(optInt, new JSONObject(optString2));
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return cVar;
                            default:
                                cVar.uid = jSONObject2.optString("uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString(PushMessageHelper.MESSAGE_TYPE))) {
                                    cVar.blt = jSONObject2.optString(PushMessageHelper.MESSAGE_TYPE);
                                }
                                cVar.blv = jSONObject2.optString("character_name");
                                if (!TextUtils.isEmpty(jSONObject2.optString("character"))) {
                                    cVar.blu = jSONObject2.optString("character");
                                }
                                if (!TextUtils.isEmpty("vip")) {
                                    cVar.blw = jSONObject2.optString("vip");
                                }
                                cVar.name = jSONObject2.optString("name");
                                cVar.portrait = jSONObject2.optString("portrait");
                                cVar.content = jSONObject2.optString("content");
                                cVar.bly = jSONObject2.optString("at_uid");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_type"))) {
                                    cVar.blz = jSONObject2.optString("at_message_type");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_character"))) {
                                    cVar.blC = jSONObject2.optString("at_character");
                                }
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_vip"))) {
                                    cVar.blB = jSONObject2.optString("at_vip");
                                }
                                cVar.blA = jSONObject2.optString("at_name");
                                cVar.blD = jSONObject2.optString("at_character_name");
                                cVar.blE = jSONObject2.optString("at_portrait");
                                cVar.blx = R(jSONObject2);
                                cVar.content = jSONObject2.optString("content");
                                if (!TextUtils.isEmpty(jSONObject2.optString("at_message_body"))) {
                                    cVar.blF = S(jSONObject2);
                                }
                                JSONObject optJSONObject = jSONObject2.optJSONObject("ext_params");
                                if (optJSONObject != null) {
                                    cVar.blH = optJSONObject.toString();
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
                if (cVar.blx == null || (cVar.blx.blW == null && cVar.blx.blY == null && cVar.blx.blZ == null && cVar.blx.blX == null)) {
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
                aVar.blJ = jSONObject.optInt("totaluser");
                aVar.blI = jSONObject.optString("lastestuser");
                break;
            case 102:
                aVar.duration = jSONObject.optString("duration");
                aVar.blK = jSONObject.optString("total_users");
                aVar.blV = jSONObject.optString("close_ext");
                break;
            case 103:
                aVar.blL = jSONObject.optString("title");
                aVar.blM = jSONObject.optString("content");
                break;
            case 104:
                aVar.blN = jSONObject.optString("live_rtmp_url");
                aVar.blO = jSONObject.optString("live_flv_url");
                break;
            case 105:
                aVar.blP = jSONObject.optInt("mcast_id");
                aVar.blQ = jSONObject.optInt("operation");
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
                                aVar.blR = P(jSONObject2);
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
                aVar.blP = jSONObject.optInt("mcast_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("msgids");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    aVar.blS = new long[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        aVar.blS[i2] = optJSONArray.optLong(i2);
                    }
                    break;
                }
                break;
            case 107:
            case 108:
                aVar.blT = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
                JSONObject optJSONObject = jSONObject.optJSONObject("service_info");
                if (optJSONObject != null) {
                    aVar.blU = optJSONObject.toString();
                    break;
                }
                break;
        }
        return aVar;
    }

    private static c.C0095c R(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(jSONObject.optString("message_body"))) {
            return gc(jSONObject.optString("message_body"));
        }
        if (!TextUtils.isEmpty(jSONObject.optString("content"))) {
            String optString = jSONObject.optString("content");
            if (!TextUtils.isEmpty(optString)) {
                c.C0095c c0095c = new c.C0095c();
                c.e eVar = new c.e();
                eVar.word = optString;
                c0095c.blW = eVar;
                return c0095c;
            }
        }
        return null;
    }

    private static c.C0095c gc(String str) {
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
            c.C0095c c0095c = new c.C0095c();
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
                    c0095c.blW = eVar;
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
                    c0095c.blZ = bVar;
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
                    c0095c.blY = fVar;
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
                        dVar.bma = aVar;
                        c0095c.blX = dVar;
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
                        dVar.bmb = aVar2;
                        c0095c.blX = dVar;
                        return c0095c;
                    } catch (JSONException e7) {
                        e7.printStackTrace();
                        return c0095c;
                    }
                }
                return c0095c;
            }
            return c0095c;
        }
        return null;
    }

    private static c.C0095c S(JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("at_message_body"))) {
            return null;
        }
        return gc(jSONObject.optString("at_message_body"));
    }

    public static ChatMsg a(Context context, e eVar) {
        c cVar = new c();
        if (!TextUtils.isEmpty(eVar.blr)) {
            cVar.blr = eVar.blr;
        }
        if (!TextUtils.isEmpty(eVar.blu)) {
            cVar.blu = eVar.blu;
        }
        cVar.blv = eVar.blv;
        cVar.type = "0";
        com.baidu.c.a.b.a.a aVar = eVar.bmd;
        String str = eVar.msg;
        if (aVar == null) {
            cVar.blt = "0";
        } else if (TextUtils.isEmpty(str)) {
            if (aVar.getType() == 0) {
                cVar.blt = "1";
            } else {
                cVar.blt = "5";
            }
        } else if (aVar.getType() == 0) {
            cVar.blt = "2";
        }
        com.baidu.c.a.a.a JT = com.baidu.c.b.a.az(context).JT();
        b JL = JT != null ? JT.JL() : null;
        if (JL != null) {
            cVar.portrait = JL.JM();
            cVar.uid = JL.getUid();
            cVar.name = eVar.name;
        }
        c.C0095c c0095c = new c.C0095c();
        if (!TextUtils.isEmpty(str)) {
            c.e eVar2 = new c.e();
            eVar2.word = str;
            c0095c.blW = eVar2;
        }
        if (aVar != null && aVar.getType() == 0) {
            c.d dVar = new c.d();
            c.d.a aVar2 = new c.d.a();
            aVar2.url = aVar.getUrl();
            aVar2.width = aVar.getWidth();
            aVar2.height = aVar.JQ();
            c.d.a aVar3 = new c.d.a();
            aVar3.url = aVar.getThumbUrl();
            aVar3.width = aVar.JO();
            aVar3.height = aVar.JP();
            dVar.bma = aVar2;
            dVar.bmb = aVar3;
            c0095c.blX = dVar;
        } else if (aVar != null && aVar.getType() == 1) {
            c.f fVar = new c.f();
            fVar.url = aVar.getUrl();
            fVar.duration = aVar.JR() + "";
            c0095c.blY = fVar;
        }
        cVar.blx = c0095c;
        cVar.blH = eVar.blH;
        c cVar2 = eVar.bmc;
        if (cVar2 != null) {
            cVar.bly = cVar2.uid;
            cVar.blz = cVar2.blt;
            cVar.blA = cVar2.name;
            cVar.blB = cVar2.blw;
            cVar.blC = cVar2.blu;
            cVar.blE = cVar2.portrait;
            cVar.blF = cVar2.blx;
            cVar.blD = cVar2.blv;
            com.baidu.c.b.a.a.c.c(context, cVar);
        }
        cVar.content = com.baidu.c.b.a.a.c.a(context, cVar, true);
        if (JT == null || !JT.isLogin()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", cVar.blr + "");
            jSONObject.put("type", cVar.type + "");
            jSONObject.put("uid", cVar.uid);
            jSONObject.put("to_uid", cVar.bls);
            jSONObject.put(PushMessageHelper.MESSAGE_TYPE, cVar.blt + "");
            jSONObject.put("character", cVar.blu + "");
            jSONObject.put("vip", cVar.blw + "");
            jSONObject.put("name", cVar.name);
            jSONObject.put("character_name", cVar.blv);
            jSONObject.put("portrait", cVar.portrait);
            jSONObject.put("content", cVar.content);
            if (!TextUtils.isEmpty(cVar.blH)) {
                jSONObject.put("ext_params", new JSONObject(cVar.blH));
            }
            if (cVar.blx != null) {
                JSONObject jSONObject2 = new JSONObject();
                c.C0095c c0095c2 = cVar.blx;
                if (cVar.blx.blW != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("word", c0095c2.blW.word);
                    jSONObject2.put(DocumentOpenUtil.TXT, jSONObject3);
                }
                if (cVar.blx.blX != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("width", c0095c2.blX.bma.width);
                    jSONObject5.put("height", c0095c2.blX.bma.height);
                    jSONObject5.put("url", c0095c2.blX.bma.url);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("width", c0095c2.blX.bmb.width);
                    jSONObject6.put("height", c0095c2.blX.bmb.height);
                    jSONObject6.put("url", c0095c2.blX.bmb.url);
                    jSONObject4.put("origin", jSONObject5);
                    jSONObject4.put("thumbnail", jSONObject6);
                    jSONObject2.put(UgcUBCUtils.UGC_TYPE_PIC_BTN, jSONObject4);
                }
                if (cVar.blx.blY != null) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("url", c0095c2.blY.url);
                    jSONObject7.put("duration", c0095c2.blY.duration);
                    jSONObject2.put("voice", jSONObject7);
                }
                jSONObject.put("message_body", jSONObject2);
            }
            jSONObject.put("at_uid", cVar.bly);
            jSONObject.put("at_message_type", cVar.blz + "");
            jSONObject.put("at_name", cVar.blA);
            jSONObject.put("at_character_name", cVar.blD);
            jSONObject.put("at_vip", cVar.blB + "");
            jSONObject.put("at_character", cVar.blC + "");
            jSONObject.put("at_portrait", cVar.blE);
            if (cVar.blF != null) {
                JSONObject jSONObject8 = new JSONObject();
                c.C0095c c0095c3 = cVar.blF;
                JSONObject jSONObject9 = new JSONObject();
                if (c0095c3.blW != null) {
                    jSONObject9.put("word", c0095c3.blW.word);
                }
                jSONObject8.put(DocumentOpenUtil.TXT, jSONObject9);
                JSONObject jSONObject10 = new JSONObject();
                if (c0095c3.blX != null) {
                    if (c0095c3.blX.bma != null) {
                        JSONObject jSONObject11 = new JSONObject();
                        jSONObject11.put("width", c0095c3.blX.bma.width);
                        jSONObject11.put("height", c0095c3.blX.bma.height);
                        jSONObject11.put("url", c0095c3.blX.bma.url);
                        jSONObject10.put("origin", jSONObject11);
                    }
                    if (c0095c3.blX.bmb != null) {
                        JSONObject jSONObject12 = new JSONObject();
                        jSONObject12.put("width", c0095c3.blX.bmb.width);
                        jSONObject12.put("height", c0095c3.blX.bmb.height);
                        jSONObject12.put("url", c0095c3.blX.bmb.url);
                        jSONObject10.put("thumbnail", jSONObject12);
                    }
                    jSONObject8.put(UgcUBCUtils.UGC_TYPE_PIC_BTN, jSONObject10);
                }
                if (c0095c3.blY != null) {
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("url", c0095c3.blY.url);
                    jSONObject13.put("duration", c0095c3.blY.duration);
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
