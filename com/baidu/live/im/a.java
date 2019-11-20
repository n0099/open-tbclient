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
/* loaded from: classes6.dex */
public class a extends com.baidu.live.im.data.a {
    public static final BdUniqueId aeq = BdUniqueId.gen();
    public static final BdUniqueId aer = BdUniqueId.gen();
    public static final BdUniqueId aes = BdUniqueId.gen();
    public static final BdUniqueId aet = BdUniqueId.gen();
    public static final BdUniqueId aeu = BdUniqueId.gen();
    private String aev;
    public SpannableStringBuilder aew;

    public String sd() {
        return this.aev;
    }

    public void cD(String str) {
        this.aev = str;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        if (getMsgType() == 24) {
            return aer;
        }
        if (getMsgType() == 13) {
            return aes;
        }
        if (getMsgType() == 26) {
            return aes;
        }
        if (getMsgType() == 125) {
            return aet;
        }
        if (getMsgType() == 27) {
            return aes;
        }
        if (getMsgType() == 12) {
            return aes;
        }
        if (getMsgType() == 28) {
            return aeu;
        }
        return aeq;
    }

    public boolean x(JSONObject jSONObject) {
        setMsgId(jSONObject.optLong("msgId"));
        setMsgType(jSONObject.optInt("msgType"));
        setUserId(jSONObject.optInt(TbEnum.SystemMessage.KEY_USER_ID));
        l(jSONObject.optJSONArray("toUid"));
        setContent(jSONObject.optString("content"));
        cJ(jSONObject.optString("barrageId"));
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
                k(strArr);
            }
        } catch (Exception e2) {
            k(null);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("userInfo");
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (optJSONObject != null) {
            aVar.parserJson(optJSONObject);
        }
        b(aVar);
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
            jSONObject.put("barrageId", tj());
            com.baidu.live.im.data.b tk = tk();
            if (tk != null) {
                jSONObject.put("barrageCard", tk.toJsonString());
            }
            if (tl() != null && tl().length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < tl().length; i++) {
                    jSONArray.put(tl()[i]);
                }
                jSONObject.put("imEffect", jSONArray);
            }
            new JSONObject();
            if (tf() != null) {
                jSONObject.put("userInfo", tf().toJsonObject());
            }
            jSONObject.put("createTime", getTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String se() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", getMsgId());
            jSONObject.put("msg_type", getMsgType());
            jSONObject.put("msgType", getMsgType());
            jSONObject.put("user_id", getUserId());
            jSONObject.put("content", getContent());
            jSONObject.put("live_enter_type", TbConfig.getLiveEnterFrom());
            jSONObject.put("barrageId", tj());
            com.baidu.live.im.data.b tk = tk();
            if (tk != null) {
                jSONObject.put("barrageCard", tk.toJsonString());
            }
            if (tl() != null && tl().length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < tl().length; i++) {
                    jSONArray.put(tl()[i]);
                }
                jSONObject.put("imEffect", jSONArray);
            }
            new JSONObject();
            if (tf() != null) {
                jSONObject.put("user_info", tf().toJsonObject());
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
