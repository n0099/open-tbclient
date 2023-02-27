package com.baidu.searchbox.account.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UserAccountActionItem implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<UserAccountActionItem> CREATOR = new Parcelable.Creator<UserAccountActionItem>() { // from class: com.baidu.searchbox.account.data.UserAccountActionItem.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserAccountActionItem createFromParcel(Parcel parcel) {
            return new UserAccountActionItem(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserAccountActionItem[] newArray(int i) {
            return new UserAccountActionItem[i];
        }
    };
    public static final String KEY_ACTION = "action";
    public static final String KEY_SRC = "src";
    public static final String KEY_SUB_SRC = "subSrc";
    public static final String KEY_TYPE = "type";
    public String mAction;
    public String mSrc;
    public String mSubSrc;
    public String mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String getSubSrc() {
        return this.mSubSrc;
    }

    public String getType() {
        return this.mType;
    }

    public String toString() {
        JSONObject jSONObject;
        try {
            jSONObject = buildUserStatInfo();
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        return "";
    }

    /* loaded from: classes2.dex */
    public enum UserAccountAction {
        LOGIN("login"),
        LOGOUT("logout"),
        BIND("bind");
        
        public String mName;

        UserAccountAction(String str) {
            this.mName = str;
        }

        public String getName() {
            return this.mName;
        }
    }

    /* loaded from: classes2.dex */
    public enum UserAccountType {
        NATIVE("native"),
        PLUGIN("plugin"),
        SHARE("share"),
        GUEST("guest"),
        WEBVIEW(AlbumActivityConfig.FROM_WEB_VIEW);
        
        public String mType;

        UserAccountType(String str) {
            this.mType = str;
        }

        public String getType() {
            return this.mType;
        }
    }

    public UserAccountActionItem(Parcel parcel) {
        this.mAction = parcel.readString();
        this.mType = parcel.readString();
        this.mSrc = parcel.readString();
        this.mSubSrc = parcel.readString();
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public UserAccountActionItem(UserAccountAction userAccountAction, UserAccountType userAccountType, String str) {
        this(userAccountAction.getName(), userAccountType.getType(), str);
    }

    public UserAccountActionItem(UserAccountAction userAccountAction, UserAccountType userAccountType, String str, String str2) {
        this(userAccountAction.getName(), userAccountType.getType(), str, str2);
    }

    public UserAccountActionItem(UserAccountAction userAccountAction, String str, String str2) {
        this(userAccountAction.getName(), str, str2);
    }

    public UserAccountActionItem(String str, String str2, String str3) {
        this.mAction = str;
        this.mType = str2;
        this.mSrc = str3;
    }

    public UserAccountActionItem(String str, String str2, String str3, String str4) {
        this.mAction = str;
        this.mType = str2;
        this.mSrc = str3;
        this.mSubSrc = str4;
    }

    public UserAccountActionItem(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (jSONObject.has("action")) {
                this.mAction = jSONObject.getString("action");
            }
            if (jSONObject.has("type")) {
                this.mType = jSONObject.getString("type");
            }
            if (jSONObject.has("src")) {
                this.mSrc = jSONObject.getString("src");
            }
            if (jSONObject.has(KEY_SUB_SRC)) {
                this.mSubSrc = jSONObject.getString(KEY_SUB_SRC);
                return;
            }
            return;
        }
        throw new JSONException("");
    }

    public JSONObject buildUserStatInfo() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.mAction;
        if (str != null) {
            jSONObject.put("action", str);
            if (!TextUtils.isEmpty(this.mType)) {
                jSONObject.put("type", this.mType);
            }
            if (!TextUtils.isEmpty(this.mSrc)) {
                if (!TextUtils.isEmpty(this.mSubSrc)) {
                    jSONObject.put("src", this.mSrc + "_" + this.mSubSrc);
                } else {
                    jSONObject.put("src", this.mSrc);
                }
            }
            return jSONObject;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAction);
        parcel.writeString(this.mType);
        parcel.writeString(this.mSrc);
        parcel.writeString(this.mSubSrc);
    }
}
