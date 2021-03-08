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
/* loaded from: classes10.dex */
public class a extends com.baidu.live.im.data.b {
    public static final BdUniqueId blu = BdUniqueId.gen();
    public static final BdUniqueId blv = BdUniqueId.gen();
    public static final BdUniqueId blw = BdUniqueId.gen();
    public static final BdUniqueId blx = BdUniqueId.gen();
    public static final BdUniqueId bly = BdUniqueId.gen();
    public SpannableStringBuilder blA;
    private String blz;

    public String Js() {
        return this.blz;
    }

    public void hc(String str) {
        this.blz = str;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        if (getMsgType() == 24) {
            return blv;
        }
        if (getMsgType() == 13) {
            return blw;
        }
        if (getMsgType() == 26) {
            return blw;
        }
        if (getMsgType() == 125) {
            return blx;
        }
        if (getMsgType() == 27) {
            return blw;
        }
        if (getMsgType() == 12) {
            return blw;
        }
        if (getMsgType() == 28) {
            return bly;
        }
        return blu;
    }

    public boolean R(JSONObject jSONObject) {
        setMsgId(jSONObject.optLong("msgId"));
        setMsgType(jSONObject.optInt("msgType"));
        setUserId(jSONObject.optLong(TbEnum.SystemMessage.KEY_USER_ID));
        m(jSONObject.optJSONArray("toUid"));
        setContent(jSONObject.optString("content"));
        dD(jSONObject.optInt("barrageType"));
        hn(jSONObject.optString("barrageId"));
        String optString = jSONObject.optString("barrageCard");
        if (!TextUtils.isEmpty(optString)) {
            try {
                a(new com.baidu.live.im.data.d(new JSONObject(optString)));
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
            l(null);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("userInfo");
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (optJSONObject != null) {
            aVar.parserJson(optJSONObject);
        }
        e(aVar);
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
            jSONObject.put("barrageType", Lg());
            jSONObject.put("barrageId", Lh());
            com.baidu.live.im.data.d Li = Li();
            if (Li != null) {
                jSONObject.put("barrageCard", Li.toJsonString());
            }
            if (Lj() != null && Lj().length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Lj().length; i++) {
                    jSONArray.put(Lj()[i]);
                }
                jSONObject.put("imEffect", jSONArray);
            }
            new JSONObject();
            if (Lc() != null) {
                jSONObject.put("userInfo", Lc().toJsonObject());
            }
            jSONObject.put("createTime", getTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String Jt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", getMsgId());
            jSONObject.put("msg_type", getMsgType());
            jSONObject.put("msgType", getMsgType());
            jSONObject.put("user_id", getUserId());
            jSONObject.put("content", getContent());
            jSONObject.put("live_enter_type", TbConfig.getLiveEnterFrom());
            jSONObject.put("barrageType", Lg());
            jSONObject.put("barrageId", Lh());
            com.baidu.live.im.data.d Li = Li();
            if (Li != null) {
                jSONObject.put("barrageCard", Li.toJsonString());
            }
            if (Lj() != null && Lj().length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Lj().length; i++) {
                    jSONArray.put(Lj()[i]);
                }
                jSONObject.put("imEffect", jSONArray);
            }
            new JSONObject();
            if (Lc() != null) {
                jSONObject.put("user_info", Lc().toJsonObject());
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
