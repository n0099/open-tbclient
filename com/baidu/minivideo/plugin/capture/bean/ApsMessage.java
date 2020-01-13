package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.bean.Jsonable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class ApsMessage<T extends Jsonable> implements Jsonable {
    public static final String JN_K_DATA = "data";
    public static final String JN_K_MSG = "msg";
    public static final String JN_K_STATUS = "status";
    public static final String JN_K_TYPE = "type";
    private T data;
    private String msg;
    private int status;
    private int type;

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject jSONObject;
        Exception e;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("status", this.status);
            jSONObject.put("msg", this.msg);
            jSONObject.put("type", this.type);
            T data = getData();
            if (data != null) {
                jSONObject.put("data", data.toJson());
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    protected boolean parseData(JSONObject jSONObject) {
        return true;
    }

    public void setData(T t) {
        this.data = t;
    }

    public T getData() {
        return this.data;
    }
}
