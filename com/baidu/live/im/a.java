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
    public static final BdUniqueId aeI = BdUniqueId.gen();
    public static final BdUniqueId aeJ = BdUniqueId.gen();
    public static final BdUniqueId aeK = BdUniqueId.gen();
    public static final BdUniqueId aeL = BdUniqueId.gen();
    public static final BdUniqueId aeM = BdUniqueId.gen();
    private String aeN;
    public SpannableStringBuilder aeO;

    public String sc() {
        return this.aeN;
    }

    public void cD(String str) {
        this.aeN = str;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        if (getMsgType() == 24) {
            return aeJ;
        }
        if (getMsgType() == 13) {
            return aeK;
        }
        if (getMsgType() == 26) {
            return aeK;
        }
        if (getMsgType() == 125) {
            return aeL;
        }
        if (getMsgType() == 27) {
            return aeK;
        }
        if (getMsgType() == 12) {
            return aeK;
        }
        if (getMsgType() == 28) {
            return aeM;
        }
        return aeI;
    }

    public boolean w(JSONObject jSONObject) {
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
            jSONObject.put("barrageId", ti());
            com.baidu.live.im.data.b tj = tj();
            if (tj != null) {
                jSONObject.put("barrageCard", tj.toJsonString());
            }
            if (tk() != null && tk().length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < tk().length; i++) {
                    jSONArray.put(tk()[i]);
                }
                jSONObject.put("imEffect", jSONArray);
            }
            new JSONObject();
            if (te() != null) {
                jSONObject.put("userInfo", te().toJsonObject());
            }
            jSONObject.put("createTime", getTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String sd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", getMsgId());
            jSONObject.put("msg_type", getMsgType());
            jSONObject.put("msgType", getMsgType());
            jSONObject.put("user_id", getUserId());
            jSONObject.put("content", getContent());
            jSONObject.put("live_enter_type", TbConfig.getLiveEnterFrom());
            jSONObject.put("barrageId", ti());
            com.baidu.live.im.data.b tj = tj();
            if (tj != null) {
                jSONObject.put("barrageCard", tj.toJsonString());
            }
            if (tk() != null && tk().length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < tk().length; i++) {
                    jSONArray.put(tk()[i]);
                }
                jSONObject.put("imEffect", jSONArray);
            }
            new JSONObject();
            if (te() != null) {
                jSONObject.put("user_info", te().toJsonObject());
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
