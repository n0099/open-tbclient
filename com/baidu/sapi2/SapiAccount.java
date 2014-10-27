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
    static final String a = "uid";
    static final String b = "displayname";
    static final String c = "username";
    static final String d = "email";
    static final String e = "phone";
    static final String f = "bduss";
    static final String g = "app";
    static final String h = "ptoken";
    static final String i = "stoken";
    static final String j = "extra";
    public String app;
    public String bduss;
    public String displayname;
    public String email;
    public String extra;
    private String k;
    private String l;
    public String phone;
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
        this.l = parcel.readString();
        this.extra = parcel.readString();
        this.k = parcel.readString();
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", this.uid);
            jSONObject.put("displayname", this.displayname);
            jSONObject.put(c, this.username);
            jSONObject.put(d, this.email);
            jSONObject.put(e, this.phone);
            jSONObject.put("bduss", this.bduss);
            jSONObject.put("app", this.app);
            jSONObject.put("ptoken", this.ptoken);
            jSONObject.put("stoken", this.stoken);
            jSONObject.put(j, this.extra);
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
        sapiAccount.username = jSONObject.optString(c);
        sapiAccount.email = jSONObject.optString(d);
        sapiAccount.phone = jSONObject.optString(e);
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.app = jSONObject.optString("app");
        sapiAccount.ptoken = jSONObject.optString("ptoken");
        sapiAccount.stoken = jSONObject.optString("stoken");
        sapiAccount.extra = jSONObject.optString(j);
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
            return SocialType.UNKNOWN;
        }
        try {
            return SocialType.getSocialType(new JSONObject(this.extra).optInt(com.baidu.sapi2.utils.a.b, SocialType.UNKNOWN.getType()));
        } catch (JSONException e2) {
            return SocialType.UNKNOWN;
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
        sapiAccount.extra = this.extra;
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
        parcel.writeString(this.l);
        parcel.writeString(this.extra);
        parcel.writeString(this.k);
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
        return "SapiAccount{uid='" + this.uid + "', displayname='" + this.displayname + "', username='" + this.username + "', email='" + this.email + "', phone='" + this.phone + "', bduss='" + this.bduss + "', app='" + this.app + "', ptoken='" + this.ptoken + "', stoken='" + this.stoken + "', extra='" + this.extra + "'}";
    }

    public ReloginCredentials getReloginCredentials() {
        return c.a(SapiAccountManager.getInstance().getSapiConfiguration().context).c(this.uid);
    }

    /* loaded from: classes.dex */
    public final class ReloginCredentials {
        static final String a = "account";
        static final String b = "account_type";
        static final String c = "password";
        static final String d = "ubi";
        public String account;
        public String accountType;
        public String password;
        public String ubi;

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("account", this.account);
                jSONObject.put(b, this.accountType);
                jSONObject.put(c, this.password);
                jSONObject.put(d, this.ubi);
                return jSONObject;
            } catch (JSONException e) {
                L.e(e);
                return null;
            }
        }

        public static ReloginCredentials fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            ReloginCredentials reloginCredentials = new ReloginCredentials();
            reloginCredentials.account = jSONObject.optString("account");
            reloginCredentials.accountType = jSONObject.optString(b);
            reloginCredentials.password = jSONObject.optString(c);
            reloginCredentials.ubi = jSONObject.optString(d);
            return reloginCredentials;
        }
    }
}
