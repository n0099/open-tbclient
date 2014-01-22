package com.baidu.sapi2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SapiAccount implements Parcelable, Cloneable {
    public static final Parcelable.Creator<SapiAccount> CREATOR = new a();
    static final String a = "http://wappass.bdimg.com/static/appsapi/img/default_portrait.jpg";
    static final String b = "uid";
    static final String c = "displayname";
    static final String d = "username";
    static final String e = "email";
    static final String f = "phone";
    static final String g = "bduss";
    static final String h = "app";
    static final String i = "ptoken";
    static final String j = "stoken";
    static final String k = "devicetoken";
    static final String l = "extra";
    static final String m = "portrait";
    public String app;
    public String bduss;
    public String displayname;
    public String email;
    public String extra;
    private String n;
    public String phone;
    public String portrait;
    public String ptoken;
    public String stoken;
    public String uid;
    public String username;

    public SapiAccount() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccount(Parcel parcel) {
        this.uid = parcel.readString();
        this.displayname = parcel.readString();
        this.username = parcel.readString();
        this.email = parcel.readString();
        this.phone = parcel.readString();
        this.bduss = parcel.readString();
        this.app = parcel.readString();
        this.ptoken = parcel.readString();
        this.stoken = parcel.readString();
        this.n = parcel.readString();
        this.extra = parcel.readString();
        this.portrait = parcel.readString();
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", this.uid);
            jSONObject.put("displayname", this.displayname);
            jSONObject.put(d, this.username);
            jSONObject.put(e, this.email);
            jSONObject.put(f, this.phone);
            jSONObject.put("bduss", this.bduss);
            jSONObject.put("app", this.app);
            jSONObject.put("ptoken", this.ptoken);
            jSONObject.put("stoken", this.stoken);
            jSONObject.put(k, this.n);
            jSONObject.put(l, this.extra);
            jSONObject.put(m, this.portrait);
            return jSONObject;
        } catch (JSONException e2) {
            L.e(e2);
            return null;
        }
    }

    public static JSONArray toJSONArray(List<SapiAccount> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (SapiAccount sapiAccount : list) {
            JSONObject jSONObject = sapiAccount.toJSONObject();
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public static SapiAccount fromJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.displayname = jSONObject.optString("displayname");
        sapiAccount.username = jSONObject.optString(d);
        sapiAccount.email = jSONObject.optString(e);
        sapiAccount.phone = jSONObject.optString(f);
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.app = jSONObject.optString("app");
        sapiAccount.ptoken = jSONObject.optString("ptoken");
        sapiAccount.stoken = jSONObject.optString("stoken");
        sapiAccount.n = jSONObject.optString(k);
        sapiAccount.extra = jSONObject.optString(l);
        sapiAccount.portrait = jSONObject.optString(m);
        return sapiAccount;
    }

    public static List<SapiAccount> fromJSONArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                SapiAccount fromJSONObject = fromJSONObject(jSONArray.getJSONObject(i2));
                if (fromJSONObject != null) {
                    arrayList.add(fromJSONObject);
                }
            } catch (JSONException e2) {
                L.e(e2);
            }
        }
        return arrayList;
    }

    public boolean isSocialAccount() {
        if (TextUtils.isEmpty(this.extra)) {
            return false;
        }
        try {
            return new JSONObject(this.extra).optBoolean(com.baidu.sapi2.utils.a.a, false);
        } catch (JSONException e2) {
            return false;
        }
    }

    public SocialType getSocialType() {
        if (TextUtils.isEmpty(this.extra)) {
            return null;
        }
        try {
            return SocialType.getSocialType(new JSONObject(this.extra).optInt(com.baidu.sapi2.utils.a.b, SocialType.UNKNOWN.getType()));
        } catch (JSONException e2) {
            return null;
        }
    }

    public String getSocialPortrait() {
        if (TextUtils.isEmpty(this.extra)) {
            return null;
        }
        try {
            return new JSONObject(this.extra).optString(com.baidu.sapi2.utils.a.c, null);
        } catch (JSONException e2) {
            return null;
        }
    }

    public Object clone() {
        super.clone();
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = this.uid;
        sapiAccount.displayname = this.displayname;
        sapiAccount.username = this.username;
        sapiAccount.email = this.email;
        sapiAccount.phone = this.phone;
        sapiAccount.bduss = this.bduss;
        sapiAccount.ptoken = this.ptoken;
        sapiAccount.stoken = this.stoken;
        sapiAccount.app = this.app;
        sapiAccount.n = this.n;
        sapiAccount.extra = this.extra;
        sapiAccount.portrait = this.portrait;
        return sapiAccount;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.uid);
        parcel.writeString(this.displayname);
        parcel.writeString(this.username);
        parcel.writeString(this.email);
        parcel.writeString(this.phone);
        parcel.writeString(this.bduss);
        parcel.writeString(this.app);
        parcel.writeString(this.ptoken);
        parcel.writeString(this.stoken);
        parcel.writeString(this.n);
        parcel.writeString(this.extra);
        parcel.writeString(this.portrait);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SapiAccount sapiAccount = (SapiAccount) obj;
        if (this.uid != null) {
            if (this.uid.equals(sapiAccount.uid)) {
                return true;
            }
        } else if (sapiAccount.uid == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.uid != null) {
            return this.uid.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SapiAccount{uid='" + this.uid + "', displayname='" + this.displayname + "', username='" + this.username + "', email='" + this.email + "', phone='" + this.phone + "', bduss='" + this.bduss + "', app='" + this.app + "', ptoken='" + this.ptoken + "', stoken='" + this.stoken + "', devicetoken='" + this.n + "', extra='" + this.extra + "', portrait='" + this.portrait + "'}";
    }
}
