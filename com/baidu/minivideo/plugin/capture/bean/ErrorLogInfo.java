package com.baidu.minivideo.plugin.capture.bean;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ErrorLogInfo implements Jsonable {
    public String code;
    public String data;
    public boolean doReport;
    public boolean isShowSpecialToast;
    public String msg;
    public String name;
    public String specialToast;
    public int type;

    public ErrorLogInfo() {
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.type = jSONObject.getInt("type");
            this.doReport = jSONObject.getBoolean("doReport");
            this.name = jSONObject.getString("name");
            this.msg = jSONObject.getString("msg");
            this.data = jSONObject.getString("data");
            this.isShowSpecialToast = jSONObject.getBoolean("isShowSpecialToast");
            this.specialToast = jSONObject.getString("specialToast");
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void set(int i, String str, String str2, String str3, String str4) {
        this.type = i;
        this.name = str;
        this.code = str2;
        this.msg = str3;
        this.data = str4;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject jSONObject;
        JSONException e2;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e3) {
            jSONObject = null;
            e2 = e3;
        }
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("doReport", this.doReport);
            jSONObject.put("name", this.name);
            jSONObject.put("code", this.code);
            jSONObject.put("msg", this.msg);
            jSONObject.put("data", this.data);
            jSONObject.put("isShowSpecialToast", this.isShowSpecialToast);
            jSONObject.put("specialToast", this.specialToast);
        } catch (JSONException e4) {
            e2 = e4;
            e2.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    public String toString() {
        return "type:" + this.type + "name:" + this.name + "code:" + this.code + "msg:" + this.msg + "data" + this.data + "doReport : " + this.doReport;
    }

    public ErrorLogInfo(int i, String str, String str2, String str3, String str4) {
        set(i, str, str2, str3, str4);
    }

    public void set(int i, String str, String str2, String str3, String str4, boolean z) {
        this.type = i;
        this.name = str;
        this.code = str2;
        this.msg = str3;
        this.data = str4;
        this.doReport = z;
    }
}
