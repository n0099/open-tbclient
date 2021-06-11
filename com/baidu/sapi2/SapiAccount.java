package com.baidu.sapi2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SapiAccount implements Parcelable, Cloneable {
    public static final Parcelable.Creator<SapiAccount> CREATOR;
    public static final String SAPI_ACCOUNT_APP = "app";
    public static final String SAPI_ACCOUNT_BDUSS = "bduss";
    public static final String SAPI_ACCOUNT_DISPLAYNAME = "displayname";
    public static final String SAPI_ACCOUNT_EMAIL = "email";
    public static final String SAPI_ACCOUNT_EXTRA = "extra";
    public static final String SAPI_ACCOUNT_FROMTYPE = "fromType";
    public static final String SAPI_ACCOUNT_PHONE = "phone";
    public static final String SAPI_ACCOUNT_PORTRAIT = "portrait";
    public static final String SAPI_ACCOUNT_PTOKEN = "ptoken";
    public static final String SAPI_ACCOUNT_STOKEN = "stoken";
    public static final String SAPI_ACCOUNT_UID = "uid";
    public static final String SAPI_ACCOUNT_USERNAME = "username";
    public String app;
    public String bduss;
    @Deprecated
    public String devicetoken;
    public String displayname;
    @Deprecated
    public String email;
    public String extra;
    public String fromType = FromType.LOGIN.getValue();
    @Deprecated
    public String phone;
    public String portrait;
    public String ptoken;
    @Deprecated
    public String stoken;
    public String uid;
    public String username;

    /* loaded from: classes2.dex */
    public static final class DispersionCertification implements NoProguard {
        public Map<String, String> tplStokenMap = new HashMap();

        public static DispersionCertification fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            DispersionCertification dispersionCertification = new DispersionCertification();
            dispersionCertification.tplStokenMap = getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
            return dispersionCertification;
        }

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

    /* loaded from: classes2.dex */
    public static final class ExtraProperty implements NoProguard {
        public static final String EXTRA_ACCOUNT_TYPE = "account_type";
        public static final String EXTRA_IS_GUEST_ACCOUNT = "is_guest_account";
        public static final String EXTRA_IS_SOCIAL_ACCOUNT = "is_social_account";
        public static final String EXTRA_PKG = "pkg";
        public static final String EXTRA_SOCIAL_NICKNAME = "social_nickname";
        public static final String EXTRA_SOCIAL_PORTRAIT = "social_portrait";
        public static final String EXTRA_SOCIAL_TYPE = "social_type";
        public static final String EXTRA_TPL = "tpl";
        public static final String EXTRA_TPL_STOKEN_LIST = "stoken_list";
        public DispersionCertification dispersionCertification = new DispersionCertification();
        public String extraAccountType;
        public String extraIsGuestAccount;
        public String extraIsSocialAccount;
        public String extraPkg;
        public String extraSocialPortrait;
        public String extraSocialType;
        public String extraTpl;

        public static ExtraProperty fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            ExtraProperty extraProperty = new ExtraProperty();
            extraProperty.extraAccountType = jSONObject.optString("account_type");
            extraProperty.extraIsSocialAccount = jSONObject.optString(EXTRA_IS_SOCIAL_ACCOUNT);
            extraProperty.extraSocialType = jSONObject.optString("social_type");
            extraProperty.extraSocialPortrait = jSONObject.optString(EXTRA_SOCIAL_PORTRAIT);
            extraProperty.dispersionCertification = DispersionCertification.fromJSONObject(jSONObject);
            extraProperty.extraIsGuestAccount = jSONObject.optString(EXTRA_IS_GUEST_ACCOUNT);
            extraProperty.extraTpl = jSONObject.optString("tpl");
            extraProperty.extraPkg = jSONObject.optString("pkg");
            return extraProperty;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("account_type", this.extraAccountType);
                jSONObject.put(EXTRA_IS_SOCIAL_ACCOUNT, this.extraIsSocialAccount);
                jSONObject.put("social_type", this.extraSocialType);
                jSONObject.put(EXTRA_SOCIAL_PORTRAIT, this.extraSocialPortrait);
                jSONObject.put("stoken_list", new JSONObject(this.dispersionCertification.tplStokenMap));
                jSONObject.put(EXTRA_IS_GUEST_ACCOUNT, this.extraIsGuestAccount);
                jSONObject.put("tpl", this.extraTpl);
                jSONObject.put("pkg", this.extraPkg);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    static {
        try {
            ShareAccountAccessor.setShareAccountAccessor(new SapiAccountAccessorImpl());
        } catch (Throwable th) {
            Log.e(th);
        }
        CREATOR = new Parcelable.Creator<SapiAccount>() { // from class: com.baidu.sapi2.SapiAccount.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SapiAccount createFromParcel(Parcel parcel) {
                return new SapiAccount(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SapiAccount[] newArray(int i2) {
                return new SapiAccount[i2];
            }
        };
    }

    public SapiAccount() {
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
        sapiAccount.ptoken = jSONObject.optString(SAPI_ACCOUNT_PTOKEN);
        sapiAccount.stoken = jSONObject.optString("stoken");
        sapiAccount.extra = jSONObject.optString("extra");
        sapiAccount.portrait = jSONObject.optString("portrait");
        sapiAccount.fromType = jSONObject.optString(SAPI_ACCOUNT_FROMTYPE, FromType.LOGIN.getValue());
        if (isValidAccount(sapiAccount)) {
            return sapiAccount;
        }
        return null;
    }

    public static boolean isValidAccount(SapiAccount sapiAccount) {
        return (sapiAccount == null || TextUtils.isEmpty(sapiAccount.bduss) || TextUtils.isEmpty(sapiAccount.ptoken) || TextUtils.isEmpty(sapiAccount.uid) || TextUtils.isEmpty(sapiAccount.displayname)) ? false : true;
    }

    private boolean isValidPackage() {
        Context context = ServiceManager.getInstance().getIsAccountManager().getConfignation().context;
        for (String str : SapiContext.getInstance().getSapiOptions().getAuthorizedPackagesForPtoken()) {
            if (context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
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

    public void addDispersionCertification(Map<String, String> map) {
        putExtra("stoken_list", new JSONObject(map));
    }

    public void addIsGuestAccount(String str) {
        putExtra(ExtraProperty.EXTRA_IS_GUEST_ACCOUNT, str);
    }

    public void addSocialInfo(SocialType socialType, String str, String str2) {
        putExtra(ExtraProperty.EXTRA_IS_SOCIAL_ACCOUNT, Boolean.TRUE);
        putExtra("social_type", Integer.valueOf(socialType.getType()));
        putExtra(ExtraProperty.EXTRA_SOCIAL_NICKNAME, str2);
        putExtra(ExtraProperty.EXTRA_SOCIAL_PORTRAIT, str);
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
        sapiAccount.fromType = this.fromType;
        return sapiAccount;
    }

    public void deleteStokens() {
        try {
            if (TextUtils.isEmpty(this.extra)) {
                return;
            }
            ExtraProperty fromJSONObject = ExtraProperty.fromJSONObject(new JSONObject(this.extra));
            fromJSONObject.dispersionCertification.tplStokenMap.clear();
            this.extra = fromJSONObject.toJSONObject().toString();
        } catch (JSONException e2) {
            Log.e(e2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SapiAccount.class != obj.getClass()) {
            return false;
        }
        String str = this.uid;
        String str2 = ((SapiAccount) obj).uid;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public AccountType getAccountType() {
        return AccountType.getAccountType(getIntExtra("account_type", AccountType.UNKNOWN.getType()));
    }

    public boolean getBooleanExtra(String str, boolean z) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optBoolean(str, z);
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return z;
    }

    public String getCompletePortrait() {
        return "https://himg.bdimg.com/sys/portrait/item/" + this.portrait + ".jpg";
    }

    public int getIntExtra(String str, int i2) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optInt(str, i2);
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return i2;
    }

    public String getPtoken() {
        return isValidPackage() ? this.ptoken : "";
    }

    public String getShareAccountPkg() {
        return getStringExtra("pkg", null);
    }

    public String getShareAccountTpl() {
        return getStringExtra("tpl", "");
    }

    public String getSocialNickname() {
        return getStringExtra(ExtraProperty.EXTRA_SOCIAL_NICKNAME, null);
    }

    public String getSocialPortrait() {
        return getStringExtra(ExtraProperty.EXTRA_SOCIAL_PORTRAIT, null);
    }

    public SocialType getSocialType() {
        return SocialType.getSocialType(getIntExtra("social_type", SocialType.UNKNOWN.getType()));
    }

    public String getStringExtra(String str, String str2) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optString(str, str2);
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return str2;
    }

    public int hashCode() {
        String str = this.uid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isGuestAccount() {
        return "1".equals(getStringExtra(ExtraProperty.EXTRA_IS_GUEST_ACCOUNT, "0"));
    }

    public boolean isSocialAccount() {
        return getBooleanExtra(ExtraProperty.EXTRA_IS_SOCIAL_ACCOUNT, false);
    }

    public void putExtra(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
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

    public void setAccountPkg(String str) {
        putExtra("pkg", str);
    }

    public void setPtoken(String str) {
        if (isValidPackage()) {
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
            jSONObject.put(SAPI_ACCOUNT_PTOKEN, this.ptoken);
            jSONObject.put("stoken", this.stoken);
            jSONObject.put("extra", this.extra);
            jSONObject.put("portrait", this.portrait);
            jSONObject.put(SAPI_ACCOUNT_FROMTYPE, this.fromType);
            return jSONObject;
        } catch (JSONException e2) {
            Log.e(e2);
            return null;
        }
    }

    public String toString() {
        return "SapiAccount{uid='" + this.uid + "', displayname='" + this.displayname + "', username='" + this.username + "', email='" + this.email + "', phone='" + this.phone + "', bduss='" + this.bduss + "', app='" + this.app + "', ptoken='" + this.ptoken + "', stoken='" + this.stoken + "', extra='" + this.extra + "', portrait='" + this.portrait + "', fromType='" + this.fromType + "'}";
    }

    public void updatePtoken() {
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

    public void updateSession(SapiAccount sapiAccount) {
        ExtraProperty extraProperty;
        if (isValidAccount(sapiAccount) && this.uid.equals(sapiAccount.uid)) {
            this.bduss = sapiAccount.bduss;
            this.ptoken = sapiAccount.ptoken;
            if (TextUtils.isEmpty(sapiAccount.extra)) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(this.extra)) {
                    extraProperty = ExtraProperty.fromJSONObject(new JSONObject(this.extra));
                } else {
                    extraProperty = new ExtraProperty();
                }
                ExtraProperty fromJSONObject = ExtraProperty.fromJSONObject(new JSONObject(sapiAccount.extra));
                extraProperty.dispersionCertification.tplStokenMap = fromJSONObject.dispersionCertification.tplStokenMap;
                extraProperty.extraSocialPortrait = fromJSONObject.extraSocialPortrait;
                extraProperty.extraAccountType = fromJSONObject.extraAccountType;
                extraProperty.extraIsGuestAccount = fromJSONObject.extraIsGuestAccount;
                this.extra = extraProperty.toJSONObject().toString();
            } catch (JSONException e2) {
                Log.e(e2);
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
        parcel.writeString(this.devicetoken);
        parcel.writeString(this.extra);
        parcel.writeString(this.portrait);
    }

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
        this.devicetoken = parcel.readString();
        this.extra = parcel.readString();
        this.portrait = parcel.readString();
    }
}
