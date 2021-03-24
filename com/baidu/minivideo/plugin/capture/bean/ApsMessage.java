package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.bean.Jsonable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ApsMessage<T extends Jsonable> implements Jsonable {
    public static final String JN_K_DATA = "data";
    public static final String JN_K_MSG = "msg";
    public static final String JN_K_STATUS = "status";
    public static final String JN_K_TYPE = "type";
    public T data;
    public String msg;
    public int status;
    public int type;

    public T getData() {
        return this.data;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.type = jSONObject.optInt("type");
            parseData(jSONObject.optJSONObject("data"));
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public boolean parseData(JSONObject jSONObject) {
        return true;
    }

    public void setData(T t) {
        this.data = t;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject jSONObject;
        Exception e2;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e3) {
            jSONObject = null;
            e2 = e3;
        }
        try {
            jSONObject.put("status", this.status);
            jSONObject.put("msg", this.msg);
            jSONObject.put("type", this.type);
            T data = getData();
            if (data != null) {
                jSONObject.put("data", data.toJson());
            }
        } catch (Exception e4) {
            e2 = e4;
            e2.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }
}
