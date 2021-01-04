package com.baidu.sapi2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SapiAccount implements Parcelable, Cloneable {
    public static final Parcelable.Creator<SapiAccount> CREATOR;
    public static final String SAPI_ACCOUNT_APP = "app";
    public static final String SAPI_ACCOUNT_EXTRA = "extra";
    public static final String SAPI_ACCOUNT_PORTRAIT = "portrait";

    /* renamed from: b  reason: collision with root package name */
    private static final String f4829b = "uid";
    private static final String c = "displayname";
    private static final String d = "username";
    private static final String e = "email";
    private static final String f = "phone";
    private static final String g = "bduss";
    private static final String h = "ptoken";
    private static final String i = "stoken";
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    private String f4830a;
    public String app;
    public String bduss;
    public String displayname;
    @Deprecated
    public String email;
    protected String extra;
    @Deprecated
    public String phone;
    protected String portrait;
    protected String ptoken;
    @Deprecated
    protected String stoken;
    public String uid;
    public String username;

    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<SapiAccount> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SapiAccount createFromParcel(Parcel parcel) {
            return new SapiAccount(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SapiAccount[] newArray(int i) {
            return new SapiAccount[i];
        }
    }

    static {
        try {
            com.baidu.sapi2.share.a.a(new b());
        } catch (Throwable th) {
            Log.e(th);
        }
        CREATOR = new a();
    }

    public SapiAccount() {
    }

    private boolean b() {
        Context context = ServiceManager.getInstance().getIsAccountManager().getConfignation().context;
        for (String str : SapiContext.getInstance().getSapiOptions().c()) {
            if (context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    public static List<SapiAccount> fromJSONArray(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    SapiAccount fromJSONObject = fromJSONObject(jSONArray.getJSONObject(i2));
                    if (fromJSONObject != null) {
                        arrayList.add(fromJSONObject);
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static boolean isValidAccount(SapiAccount sapiAccount) {
        return (sapiAccount == null || TextUtils.isEmpty(sapiAccount.bduss) || TextUtils.isEmpty(sapiAccount.ptoken) || TextUtils.isEmpty(sapiAccount.uid) || TextUtils.isEmpty(sapiAccount.displayname)) ? false : true;
    }

    boolean a(String str, boolean z) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optBoolean(str, z);
            } catch (JSONException e2) {
                Log.e(e2);
                return z;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addDispersionCertification(Map<String, String> map) {
        putExtra("stoken_list", new JSONObject(map));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addIsGuestAccount(String str) {
        putExtra("is_guest_account", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSocialInfo(SocialType socialType, String str) {
        putExtra("is_social_account", true);
        putExtra(LoginActivityConfig.SOCIAL_TYPE, Integer.valueOf(socialType.getType()));
        putExtra("social_portrait", str);
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
        sapiAccount.ptoken = this.ptoken;
        sapiAccount.stoken = this.stoken;
        sapiAccount.app = this.app;
        sapiAccount.extra = this.extra;
        sapiAccount.portrait = this.portrait;
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteStokens() {
        try {
            if (!TextUtils.isEmpty(this.extra)) {
                ExtraProperty fromJSONObject = ExtraProperty.fromJSONObject(new JSONObject(this.extra));
                fromJSONObject.dispersionCertification.tplStokenMap.clear();
                this.extra = fromJSONObject.toJSONObject().toString();
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AccountType getAccountType() {
        return AccountType.getAccountType(a("account_type", AccountType.UNKNOWN.getType()));
    }

    public String getCompletePortrait() {
        return "https://himg.bdimg.com/sys/portrait/item/" + this.portrait + ".jpg";
    }

    public String getPtoken() {
        return b() ? this.ptoken : "";
    }

    public String getShareAccountPkg() {
        return a(Config.INPUT_DEF_PKG, (String) null);
    }

    public String getShareAccountTpl() {
        return a("tpl", "");
    }

    public String getSocialPortrait() {
        return a("social_portrait", (String) null);
    }

    public SocialType getSocialType() {
        return SocialType.getSocialType(a(LoginActivityConfig.SOCIAL_TYPE, SocialType.UNKNOWN.getType()));
    }

    public int hashCode() {
        String str = this.uid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isGuestAccount() {
        return "1".equals(a("is_guest_account", "0"));
    }

    public boolean isSocialAccount() {
        return a("is_social_account", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (TextUtils.isEmpty(this.extra)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, obj);
                    this.extra = jSONObject.toString();
                    return;
                } catch (JSONException e2) {
                    Log.e(e2);
                    return;
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject(this.extra);
                jSONObject2.put(str, obj);
                this.extra = jSONObject2.toString();
            } catch (JSONException e3) {
                Log.e(e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAccountPkg(String str) {
        putExtra(Config.INPUT_DEF_PKG, str);
    }

    public void setPtoken(String str) {
        if (b()) {
            this.ptoken = str;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", this.uid);
            jSONObject.put("displayname", this.displayname);
            jSONObject.put("username", this.username);
            jSONObject.put("email", this.email);
            jSONObject.put("phone", this.phone);
            jSONObject.put("bduss", this.bduss);
            jSONObject.put("app", this.app);
            jSONObject.put(h, this.ptoken);
            jSONObject.put("stoken", this.stoken);
            jSONObject.put("extra", this.extra);
            jSONObject.put("portrait", this.portrait);
            return jSONObject;
        } catch (JSONException e2) {
            Log.e(e2);
            return null;
        }
    }

    public String toString() {
        return "SapiAccount{uid='" + this.uid + "', displayname='" + this.displayname + "', username='" + this.username + "', email='" + this.email + "', phone='" + this.phone + "', bduss='" + this.bduss + "', app='" + this.app + "', ptoken='" + this.ptoken + "', stoken='" + this.stoken + "', extra='" + this.extra + "', portrait='" + this.portrait + "'}";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateSession(SapiAccount sapiAccount) {
        ExtraProperty extraProperty;
        if (isValidAccount(sapiAccount) && this.uid.equals(sapiAccount.uid)) {
            this.bduss = sapiAccount.bduss;
            this.ptoken = sapiAccount.ptoken;
            if (!TextUtils.isEmpty(sapiAccount.extra)) {
                try {
                    if (!TextUtils.isEmpty(this.extra)) {
                        extraProperty = ExtraProperty.fromJSONObject(new JSONObject(this.extra));
                    } else {
                        extraProperty = new ExtraProperty();
                    }
                    ExtraProperty fromJSONObject = ExtraProperty.fromJSONObject(new JSONObject(sapiAccount.extra));
                    extraProperty.dispersionCertification.tplStokenMap = fromJSONObject.dispersionCertification.tplStokenMap;
                    extraProperty.d = fromJSONObject.d;
                    extraProperty.f4831a = fromJSONObject.f4831a;
                    extraProperty.e = fromJSONObject.e;
                    this.extra = extraProperty.toJSONObject().toString();
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
        }
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
        parcel.writeString(this.f4830a);
        parcel.writeString(this.extra);
        parcel.writeString(this.portrait);
    }

    SapiAccount(Parcel parcel) {
        this.uid = parcel.readString();
        this.displayname = parcel.readString();
        this.username = parcel.readString();
        this.email = parcel.readString();
        this.phone = parcel.readString();
        this.bduss = parcel.readString();
        this.app = parcel.readString();
        this.ptoken = parcel.readString();
        this.stoken = parcel.readString();
        this.f4830a = parcel.readString();
        this.extra = parcel.readString();
        this.portrait = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class DispersionCertification implements NoProguard {
        protected Map<String, String> tplStokenMap = new HashMap();

        DispersionCertification() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Map<String, String> getTplStokenMap(JSONObject jSONObject) {
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

        /* JADX INFO: Access modifiers changed from: protected */
        public static DispersionCertification fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            DispersionCertification dispersionCertification = new DispersionCertification();
            dispersionCertification.tplStokenMap = getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
            return dispersionCertification;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SapiAccount.class != obj.getClass()) {
            return false;
        }
        SapiAccount sapiAccount = (SapiAccount) obj;
        String str = this.uid;
        if (str != null) {
            if (str.equals(sapiAccount.uid)) {
                return true;
            }
        } else if (sapiAccount.uid == null) {
            return true;
        }
        return false;
    }

    String a(String str, String str2) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optString(str, str2);
            } catch (JSONException e2) {
                Log.e(e2);
                return str2;
            }
        }
        return str2;
    }

    /* loaded from: classes3.dex */
    static final class ExtraProperty implements NoProguard {
        protected static final String EXTRA_ACCOUNT_TYPE = "account_type";
        protected static final String EXTRA_IS_GUEST_ACCOUNT = "is_guest_account";
        protected static final String EXTRA_IS_SOCIAL_ACCOUNT = "is_social_account";
        protected static final String EXTRA_PKG = "pkg";
        protected static final String EXTRA_SOCIAL_PORTRAIT = "social_portrait";
        protected static final String EXTRA_SOCIAL_TYPE = "social_type";
        protected static final String EXTRA_TPL = "tpl";
        protected static final String EXTRA_TPL_STOKEN_LIST = "stoken_list";

        /* renamed from: a  reason: collision with root package name */
        String f4831a;

        /* renamed from: b  reason: collision with root package name */
        String f4832b;
        String c;
        String d;
        protected DispersionCertification dispersionCertification = new DispersionCertification();
        String e;
        String f;
        String g;

        /* JADX INFO: Access modifiers changed from: protected */
        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("account_type", this.f4831a);
                jSONObject.put(EXTRA_IS_SOCIAL_ACCOUNT, this.f4832b);
                jSONObject.put("social_type", this.c);
                jSONObject.put(EXTRA_SOCIAL_PORTRAIT, this.d);
                jSONObject.put(EXTRA_TPL_STOKEN_LIST, new JSONObject(this.dispersionCertification.tplStokenMap));
                jSONObject.put(EXTRA_IS_GUEST_ACCOUNT, this.e);
                jSONObject.put("tpl", this.f);
                jSONObject.put("pkg", this.g);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static ExtraProperty fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            ExtraProperty extraProperty = new ExtraProperty();
            extraProperty.f4831a = jSONObject.optString("account_type");
            extraProperty.f4832b = jSONObject.optString(EXTRA_IS_SOCIAL_ACCOUNT);
            extraProperty.c = jSONObject.optString("social_type");
            extraProperty.d = jSONObject.optString(EXTRA_SOCIAL_PORTRAIT);
            extraProperty.dispersionCertification = DispersionCertification.fromJSONObject(jSONObject);
            extraProperty.e = jSONObject.optString(EXTRA_IS_GUEST_ACCOUNT);
            extraProperty.f = jSONObject.optString("tpl");
            extraProperty.g = jSONObject.optString("pkg");
            return extraProperty;
        }
    }

    int a(String str, int i2) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optInt(str, i2);
            } catch (JSONException e2) {
                Log.e(e2);
                return i2;
            }
        }
        return i2;
    }

    public static SapiAccount fromJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.displayname = jSONObject.optString("displayname");
        sapiAccount.username = jSONObject.optString("username");
        sapiAccount.email = jSONObject.optString("email");
        sapiAccount.phone = jSONObject.optString("phone");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.app = jSONObject.optString("app");
        sapiAccount.ptoken = jSONObject.optString(h);
        sapiAccount.stoken = jSONObject.optString("stoken");
        sapiAccount.extra = jSONObject.optString("extra");
        sapiAccount.portrait = jSONObject.optString("portrait");
        if (isValidAccount(sapiAccount)) {
            return sapiAccount;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (TextUtils.isEmpty(this.bduss) || TextUtils.isEmpty(this.ptoken)) {
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(this.bduss);
            String cookiePtoken = SapiUtils.getCookiePtoken();
            String cookieBduss = SapiUtils.getCookieBduss();
            if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
                this.ptoken = accountFromBduss.ptoken;
            } else if (!this.bduss.equals(cookieBduss) || TextUtils.isEmpty(cookiePtoken)) {
            } else {
                this.ptoken = cookiePtoken;
            }
        }
    }
}
