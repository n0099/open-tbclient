package com.baidu.sapi2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.share.ShareAccountAccessor;
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
public class SapiAccount implements Parcelable, ISapiAccount, Cloneable {
    public static final Parcelable.Creator<SapiAccount> CREATOR;
    @Deprecated
    private String a;
    public String app;
    @Deprecated
    private String b;
    public String bduss;
    public String displayname;
    @Deprecated
    public String email;
    protected String extra;
    @Deprecated
    public String phone;
    protected String ptoken;
    @Deprecated
    protected String stoken;
    public String uid;
    public String username;

    static {
        ShareAccountAccessor.setShareAccountAccessor(new SapiAccountAccessorImpl());
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
            public SapiAccount[] newArray(int i) {
                return new SapiAccount[i];
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
        this.ptoken = parcel.readString();
        this.stoken = parcel.readString();
        this.b = parcel.readString();
        this.extra = parcel.readString();
        this.a = parcel.readString();
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount
    public String getSapiAccountInfo(String str) {
        if (str.equals("uid")) {
            return this.uid;
        }
        if (str.equals("displayname")) {
            return this.displayname;
        }
        if (str.equals(ISapiAccount.SAPI_ACCOUNT_USERNAME)) {
            return this.username;
        }
        if (str.equals(ISapiAccount.SAPI_ACCOUNT_EMAIL)) {
            return this.email;
        }
        if (str.equals(ISapiAccount.SAPI_ACCOUNT_PHONE)) {
            return this.phone;
        }
        if (str.equals("bduss")) {
            return this.bduss;
        }
        if (str.equals("app")) {
            return this.app;
        }
        if (str.equals(ISapiAccount.SAPI_ACCOUNT_PTOKEN)) {
            return "";
        }
        if (str.equals(ISapiAccount.SAPI_ACCOUNT_STOKEN)) {
            return this.stoken;
        }
        if (str.equals(ISapiAccount.SAPI_ACCOUNT_EXTRA)) {
            return this.extra;
        }
        return null;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", this.uid);
            jSONObject.put("displayname", this.displayname);
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_USERNAME, this.username);
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_EMAIL, this.email);
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, this.phone);
            jSONObject.put("bduss", this.bduss);
            jSONObject.put("app", this.app);
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, this.ptoken);
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.stoken);
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_EXTRA, this.extra);
            return jSONObject;
        } catch (JSONException e) {
            Log.e(e);
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
        sapiAccount.username = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_USERNAME);
        sapiAccount.email = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_EMAIL);
        sapiAccount.phone = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.app = jSONObject.optString("app");
        sapiAccount.ptoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
        sapiAccount.stoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_STOKEN);
        sapiAccount.extra = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_EXTRA);
        if (SapiUtils.isValidAccount(sapiAccount)) {
            return sapiAccount;
        }
        return null;
    }

    public static List<SapiAccount> fromJSONArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                SapiAccount fromJSONObject = fromJSONObject(jSONArray.getJSONObject(i));
                if (fromJSONObject != null) {
                    arrayList.add(fromJSONObject);
                }
            } catch (JSONException e) {
                Log.e(e);
            }
        }
        return arrayList;
    }

    public String getPtoken() {
        return b() ? this.ptoken : "";
    }

    public void setPtoken(String str) {
        if (b()) {
            this.ptoken = str;
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.displayname);
        parcel.writeString(this.username);
        parcel.writeString(this.email);
        parcel.writeString(this.phone);
        parcel.writeString(this.bduss);
        parcel.writeString(this.app);
        parcel.writeString(this.ptoken);
        parcel.writeString(this.stoken);
        parcel.writeString(this.b);
        parcel.writeString(this.extra);
        parcel.writeString(this.a);
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
        return SapiContext.getInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context).getReloginCredentials(this.uid);
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
                Log.e(e);
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
    public static final class DispersionCertification {
        protected static final String EXTRA_TPL_STOKEN_LIST = "stoken_list";
        protected Map<String, String> tplStokenMap = new HashMap();

        DispersionCertification() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(EXTRA_TPL_STOKEN_LIST, new JSONObject(this.tplStokenMap));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static DispersionCertification fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            DispersionCertification dispersionCertification = new DispersionCertification();
            dispersionCertification.tplStokenMap = getTplStokenMap(jSONObject.optJSONObject(EXTRA_TPL_STOKEN_LIST));
            return dispersionCertification;
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
    }

    /* loaded from: classes.dex */
    static final class ExtraProperty {
        protected static final String EXTRA_ACCOUNT_TYPE = "account_type";
        protected static final String EXTRA_IS_SOCIAL_ACCOUNT = "is_social_account";
        protected static final String EXTRA_SOCIAL_PORTRAIT = "social_portrait";
        protected static final String EXTRA_SOCIAL_TYPE = "social_type";
        String a;
        String b;
        String c;
        String d;
        protected DispersionCertification dispersionCertification = new DispersionCertification();

        /* JADX INFO: Access modifiers changed from: protected */
        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("account_type", this.a);
                jSONObject.put(EXTRA_IS_SOCIAL_ACCOUNT, this.b);
                jSONObject.put(EXTRA_SOCIAL_TYPE, this.c);
                jSONObject.put(EXTRA_SOCIAL_PORTRAIT, this.d);
                jSONObject.put("stoken_list", new JSONObject(this.dispersionCertification.tplStokenMap));
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
            extraProperty.a = jSONObject.optString("account_type");
            extraProperty.b = jSONObject.optString(EXTRA_IS_SOCIAL_ACCOUNT);
            extraProperty.c = jSONObject.optString(EXTRA_SOCIAL_TYPE);
            extraProperty.d = jSONObject.optString(EXTRA_SOCIAL_PORTRAIT);
            extraProperty.dispersionCertification = DispersionCertification.fromJSONObject(jSONObject);
            return extraProperty;
        }
    }

    boolean a(String str, boolean z) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optBoolean(str, z);
            } catch (JSONException e) {
                Log.e(e);
                return z;
            }
        }
        return z;
    }

    String a(String str, String str2) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optString(str, str2);
            } catch (JSONException e) {
                Log.e(e);
                return str2;
            }
        }
        return str2;
    }

    int a(String str, int i) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optInt(str, i);
            } catch (JSONException e) {
                Log.e(e);
                return i;
            }
        }
        return i;
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
                } catch (JSONException e) {
                    Log.e(e);
                    return;
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject(this.extra);
                jSONObject2.put(str, obj);
                this.extra = jSONObject2.toString();
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSocialInfo(SocialType socialType, String str) {
        putExtra("is_social_account", true);
        putExtra("social_type", Integer.valueOf(socialType.getType()));
        putExtra("social_portrait", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateSession(SapiAccount sapiAccount) {
        ExtraProperty extraProperty;
        if (SapiUtils.isValidAccount(sapiAccount) && this.uid.equals(sapiAccount.uid)) {
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
                    Map<String, String> map = extraProperty.dispersionCertification.tplStokenMap;
                    extraProperty.dispersionCertification.tplStokenMap = fromJSONObject.dispersionCertification.tplStokenMap;
                    extraProperty.d = fromJSONObject.d;
                    extraProperty.a = fromJSONObject.a;
                    if (SocialType.UNKNOWN == sapiAccount.getSocialType()) {
                        this.extra = extraProperty.dispersionCertification.toJSONObject().toString();
                    } else {
                        this.extra = extraProperty.toJSONObject().toString();
                    }
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteStokens() {
        try {
            if (!TextUtils.isEmpty(this.extra)) {
                ExtraProperty fromJSONObject = ExtraProperty.fromJSONObject(new JSONObject(this.extra));
                fromJSONObject.dispersionCertification.tplStokenMap.clear();
                if (SocialType.UNKNOWN == getSocialType()) {
                    this.extra = fromJSONObject.dispersionCertification.toJSONObject().toString();
                } else {
                    this.extra = fromJSONObject.toJSONObject().toString();
                }
            }
        } catch (JSONException e) {
            Log.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (TextUtils.isEmpty(this.bduss) || TextUtils.isEmpty(this.ptoken)) {
            SapiAccount accountFromBduss = SapiContext.getInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context).getAccountFromBduss(this.bduss);
            String cookiePtoken = SapiUtils.getCookiePtoken();
            String cookieBduss = SapiUtils.getCookieBduss();
            if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
                this.ptoken = accountFromBduss.ptoken;
            } else if (this.bduss.equals(cookieBduss) && !TextUtils.isEmpty(cookiePtoken)) {
                this.ptoken = cookiePtoken;
            }
        }
    }

    private boolean b() {
        Context context = ServiceManager.getInstance().getIsAccountManager().getConfignation().context;
        for (String str : SapiContext.getInstance(context).getSapiOptions().c()) {
            if (context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }
}
