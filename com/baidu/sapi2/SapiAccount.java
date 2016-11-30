package com.baidu.sapi2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SapiAccount implements Parcelable, Cloneable {
    public static final Parcelable.Creator<SapiAccount> CREATOR;
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
    @Deprecated
    public String email;
    String k;
    @Deprecated
    String l;
    String m;
    @Deprecated
    private String n;
    @Deprecated
    private String o;
    @Deprecated
    public String phone;
    public String uid;
    public String username;

    static {
        com.baidu.sapi2.share.b.a(new com.baidu.sapi2.a());
        CREATOR = new Parcelable.Creator<SapiAccount>() { // from class: com.baidu.sapi2.SapiAccount.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SapiAccount createFromParcel(Parcel parcel) {
                return new SapiAccount(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SapiAccount[] newArray(int i2) {
                return new SapiAccount[i2];
            }
        };
    }

    public SapiAccount() {
    }

    SapiAccount(Parcel parcel) {
        this.uid = parcel.readString();
        this.displayname = parcel.readString();
        this.username = parcel.readString();
        this.email = parcel.readString();
        this.phone = parcel.readString();
        this.bduss = parcel.readString();
        this.app = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.o = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
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
            jSONObject.put(h, this.k);
            jSONObject.put(i, this.l);
            jSONObject.put(j, this.m);
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
        sapiAccount.k = jSONObject.optString(h);
        sapiAccount.l = jSONObject.optString(i);
        sapiAccount.m = jSONObject.optString(j);
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

    public String getPtoken() {
        return a() ? this.k : "";
    }

    public void setPtoken(String str) {
        if (a()) {
            this.k = str;
        }
    }

    public boolean isSocialAccount() {
        return a("is_social_account", false);
    }

    public SocialType getSocialType() {
        return SocialType.getSocialType(a("social_type", SocialType.UNKNOWN.getType()));
    }

    public AccountType getAccountType() {
        return AccountType.getAccountType(a(GiftTabActivityConfig.ACCOUNT_TYPE, AccountType.UNKNOWN.getType()));
    }

    public String getSocialPortrait() {
        return a("social_portrait", (String) null);
    }

    public Object clone() throws CloneNotSupportedException {
        super.clone();
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = this.uid;
        sapiAccount.displayname = this.displayname;
        sapiAccount.username = this.username;
        sapiAccount.email = this.email;
        sapiAccount.phone = this.phone;
        sapiAccount.bduss = this.bduss;
        sapiAccount.k = this.k;
        sapiAccount.l = this.l;
        sapiAccount.app = this.app;
        sapiAccount.m = this.m;
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
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.o);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
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
        return "SapiAccount{uid='" + this.uid + "', displayname='" + this.displayname + "', username='" + this.username + "', email='" + this.email + "', phone='" + this.phone + "', bduss='" + this.bduss + "', app='" + this.app + "', ptoken='" + this.k + "', stoken='" + this.l + "', extra='" + this.m + "'}";
    }

    public ReloginCredentials getReloginCredentials() {
        return c.a(SapiAccountManager.getInstance().getSapiConfiguration().context).d(this.uid);
    }

    /* loaded from: classes.dex */
    public static final class ReloginCredentials {
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
                jSONObject.put("account_type", this.accountType);
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
            reloginCredentials.accountType = jSONObject.optString("account_type");
            reloginCredentials.password = jSONObject.optString(c);
            reloginCredentials.ubi = jSONObject.optString(d);
            return reloginCredentials;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {
        static final String a = "stoken_list";
        Map<String, String> b = new HashMap();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(a, new JSONObject(this.b));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.b = b(jSONObject.optJSONObject(a));
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Map<String, String> b(JSONObject jSONObject) {
            HashMap hashMap = new HashMap();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    hashMap.put(obj, jSONObject.optString(obj));
                }
            }
            return hashMap;
        }
    }

    /* loaded from: classes.dex */
    static final class b {
        static final String a = "account_type";
        static final String b = "is_social_account";
        static final String c = "social_type";
        static final String d = "social_portrait";
        String e;
        String f;
        String g;
        String h;
        a i = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("account_type", this.e);
                jSONObject.put(b, this.f);
                jSONObject.put(c, this.g);
                jSONObject.put(d, this.h);
                jSONObject.put("stoken_list", new JSONObject(this.i.b));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.e = jSONObject.optString("account_type");
            bVar.f = jSONObject.optString(b);
            bVar.g = jSONObject.optString(c);
            bVar.h = jSONObject.optString(d);
            bVar.i = a.a(jSONObject);
            return bVar;
        }
    }

    boolean a(String str, boolean z) {
        if (!TextUtils.isEmpty(this.m)) {
            try {
                return new JSONObject(this.m).optBoolean(str, z);
            } catch (JSONException e2) {
                L.e(e2);
                return z;
            }
        }
        return z;
    }

    String a(String str, String str2) {
        if (!TextUtils.isEmpty(this.m)) {
            try {
                return new JSONObject(this.m).optString(str, str2);
            } catch (JSONException e2) {
                L.e(e2);
                return str2;
            }
        }
        return str2;
    }

    int a(String str, int i2) {
        if (!TextUtils.isEmpty(this.m)) {
            try {
                return new JSONObject(this.m).optInt(str, i2);
            } catch (JSONException e2) {
                L.e(e2);
                return i2;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (TextUtils.isEmpty(this.m)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, obj);
                    this.m = jSONObject.toString();
                    return;
                } catch (JSONException e2) {
                    L.e(e2);
                    return;
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject(this.m);
                jSONObject2.put(str, obj);
                this.m = jSONObject2.toString();
            } catch (JSONException e3) {
                L.e(e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SocialType socialType, String str) {
        a("is_social_account", (Object) true);
        a("social_type", Integer.valueOf(socialType.getType()));
        a("social_portrait", (Object) str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiAccount sapiAccount) {
        b bVar;
        if (SapiUtils.isValidAccount(sapiAccount) && this.uid.equals(sapiAccount.uid)) {
            this.bduss = sapiAccount.bduss;
            this.k = sapiAccount.k;
            if (!TextUtils.isEmpty(sapiAccount.m)) {
                try {
                    if (!TextUtils.isEmpty(this.m)) {
                        bVar = b.a(new JSONObject(this.m));
                    } else {
                        bVar = new b();
                    }
                    b a2 = b.a(new JSONObject(sapiAccount.m));
                    Map<String, String> map = bVar.i.b;
                    map.putAll(a2.i.b);
                    bVar.i.b = map;
                    bVar.h = a2.h;
                    bVar.e = a2.e;
                    if (AccountType.UNKNOWN == sapiAccount.getAccountType()) {
                        this.m = bVar.i.a().toString();
                    } else {
                        this.m = bVar.a().toString();
                    }
                } catch (JSONException e2) {
                    L.e(e2);
                }
            }
        }
    }

    private boolean a() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        for (String str : c.a(context).k().m()) {
            if (context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }
}
