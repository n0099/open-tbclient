package com.baidu.searchbox.account.result;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BoxUserPhoneBean {
    public static final String KEY_CONTACTS_USER_DISPLAYNAME = "displayname";
    public static final String KEY_CONTACTS_USER_ENC_PHONE = "enc_phone";
    public static final String KEY_CONTACTS_USER_NAME = "name";
    public static final String KEY_CONTACTS_USER_PHONE = "phone";
    public static final String KEY_CONTACTS_USER_PHONES = "phones";
    public static final String KEY_CONTACTS_USER_TAG = "tag";
    public static final String KEY_CONTACTS_USER_UID = "uid";
    public String name;
    public List<Phone> phones;

    /* loaded from: classes3.dex */
    public static class Phone {
        public String displayname;
        public String encryptPhone;
        public String phone;
        public String tag;
        public String uid;

        public Phone() {
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            setJsonValue("uid", this.uid, jSONObject);
            setJsonValue("tag", this.tag, jSONObject);
            setJsonValue("displayname", this.displayname, jSONObject);
            setJsonValue(BoxUserPhoneBean.KEY_CONTACTS_USER_ENC_PHONE, this.encryptPhone, jSONObject);
            setJsonValue("phone", this.phone, jSONObject);
            return jSONObject;
        }

        public Phone(String str, String str2) {
            this.tag = str;
            this.phone = str2;
        }

        public Phone(String str, String str2, String str3, String str4) {
            this.uid = str;
            this.displayname = str2;
            this.tag = str3;
            this.encryptPhone = str4;
        }

        public static Phone fromJSON(JSONObject jSONObject) {
            Phone phone = new Phone();
            phone.uid = jSONObject.optString("uid");
            phone.tag = jSONObject.optString("tag");
            phone.displayname = jSONObject.optString("displayname");
            phone.encryptPhone = jSONObject.optString(BoxUserPhoneBean.KEY_CONTACTS_USER_ENC_PHONE);
            phone.phone = jSONObject.optString("phone");
            return phone;
        }

        private void setJsonValue(String str, String str2, JSONObject jSONObject) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONObject.put(str, str2);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public BoxUserPhoneBean() {
        this.phones = new ArrayList();
    }

    public BoxUserPhoneBean(String str, ArrayList<Phone> arrayList) {
        this.phones = new ArrayList();
        this.name = str;
        this.phones = arrayList;
    }

    public static BoxUserPhoneBean fromJson(JSONObject jSONObject) {
        String optString = jSONObject.optString("name");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_CONTACTS_USER_PHONES);
        if (optJSONArray == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(Phone.fromJSON(optJSONArray.optJSONObject(i)));
        }
        return new BoxUserPhoneBean(optString, arrayList);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            JSONArray jSONArray = new JSONArray();
            for (Phone phone : this.phones) {
                jSONArray.put(phone.toJSON());
            }
            jSONObject.put(KEY_CONTACTS_USER_PHONES, jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
