package com.baidu.live.im;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.live.im.data.a {
    public static final BdUniqueId aJv = BdUniqueId.gen();
    public static final BdUniqueId aJw = BdUniqueId.gen();
    public static final BdUniqueId aJx = BdUniqueId.gen();
    public static final BdUniqueId aJy = BdUniqueId.gen();
    public static final BdUniqueId aJz = BdUniqueId.gen();
    private String aJA;
    public SpannableStringBuilder aJB;

    public String Az() {
        return this.aJA;
    }

    public void eA(String str) {
        this.aJA = str;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        if (getMsgType() == 24) {
            return aJw;
        }
        if (getMsgType() == 13) {
            return aJx;
        }
        if (getMsgType() == 26) {
            return aJx;
        }
        if (getMsgType() == 125) {
            return aJy;
        }
        if (getMsgType() == 27) {
            return aJx;
        }
        if (getMsgType() == 12) {
            return aJx;
        }
        if (getMsgType() == 28) {
            return aJz;
        }
        return aJv;
    }

    public boolean z(JSONObject jSONObject) {
        setMsgId(jSONObject.optLong("msgId"));
        setMsgType(jSONObject.optInt("msgType"));
        setUserId(jSONObject.optInt(TbEnum.SystemMessage.KEY_USER_ID));
        l(jSONObject.optJSONArray("toUid"));
        setContent(jSONObject.optString("content"));
        cm(jSONObject.optInt("barrageType"));
        eF(jSONObject.optString("barrageId"));
        String optString = jSONObject.optString("barrageCard");
        if (!TextUtils.isEmpty(optString)) {
            try {
                a(new com.baidu.live.im.data.b(new JSONObject(optString)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("imEffect");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                String[] strArr = new String[optJSONArray.length()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    strArr[i2] = (String) optJSONArray.get(i2);
                    i = i2 + 1;
                }
                l(strArr);
            }
        } catch (Exception e2) {
            l((String[]) null);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("userInfo");
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (optJSONObject != null) {
            aVar.parserJson(optJSONObject);
        }
        d(aVar);
        if (getUserId() <= 0 && aVar != null && !TextUtils.isEmpty(aVar.userId)) {
            setUserId(JavaTypesHelper.toLong(aVar.userId, -1L));
        }
        setTime(jSONObject.optLong("createTime"));
        setRecordId(getMsgId());
        return true;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", getMsgId());
            jSONObject.put("msgType", getMsgType());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, getUserId());
            jSONObject.put("content", getContent());
            jSONObject.put("barrageType", Ci());
            jSONObject.put("barrageId", Cj());
            com.baidu.live.im.data.b Ck = Ck();
            if (Ck != null) {
                jSONObject.put("barrageCard", Ck.toJsonString());
            }
            if (Cl() != null && Cl().length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Cl().length; i++) {
                    jSONArray.put(Cl()[i]);
                }
                jSONObject.put("imEffect", jSONArray);
            }
            new JSONObject();
            if (Ce() != null) {
                jSONObject.put("userInfo", Ce().toJsonObject());
            }
            jSONObject.put("createTime", getTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String AA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", getMsgId());
            jSONObject.put("msg_type", getMsgType());
            jSONObject.put("msgType", getMsgType());
            jSONObject.put("user_id", getUserId());
            jSONObject.put("content", getContent());
            jSONObject.put("live_enter_type", TbConfig.getLiveEnterFrom());
            jSONObject.put("barrageType", Ci());
            jSONObject.put("barrageId", Cj());
            com.baidu.live.im.data.b Ck = Ck();
            if (Ck != null) {
                jSONObject.put("barrageCard", Ck.toJsonString());
            }
            if (Cl() != null && Cl().length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Cl().length; i++) {
                    jSONArray.put(Cl()[i]);
                }
                jSONObject.put("imEffect", jSONArray);
            }
            new JSONObject();
            if (Ce() != null) {
                jSONObject.put("user_info", Ce().toJsonObject());
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(toJsonObject());
            jSONObject.put("msg_info_list", jSONArray2);
            jSONObject.put("createTime", getTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
