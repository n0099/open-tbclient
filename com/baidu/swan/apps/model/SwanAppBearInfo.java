package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    private static final String BEAR_DESC = "sign";
    private static final String BEAR_ID = "office_id";
    private static final String BEAR_INFO = "bear_info";
    private static final String BEAR_LOGO = "avatar";
    private static final String BEAR_NAME = "name";
    private static final String BEAR_URL = "url";
    private static final String BEAR_VIP_TYPE = "v_type";
    public String bearDesc;
    public String bearHomeUrl;
    public String bearId;
    public String bearLogo;
    public String bearName;
    public String bearVipType;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Parcelable.Creator<SwanAppBearInfo> CREATOR = new Parcelable.Creator<SwanAppBearInfo>() { // from class: com.baidu.swan.apps.model.SwanAppBearInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: v */
        public SwanAppBearInfo createFromParcel(Parcel parcel) {
            return new SwanAppBearInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: iG */
        public SwanAppBearInfo[] newArray(int i) {
            return new SwanAppBearInfo[i];
        }
    };

    public SwanAppBearInfo() {
        this.bearId = "";
        this.bearName = "";
        this.bearLogo = "";
        this.bearHomeUrl = "";
        this.bearDesc = "";
        this.bearVipType = "";
    }

    private SwanAppBearInfo(Parcel parcel) {
        this.bearId = "";
        this.bearName = "";
        this.bearLogo = "";
        this.bearHomeUrl = "";
        this.bearDesc = "";
        this.bearVipType = "";
        this.bearId = parcel.readString();
        this.bearName = parcel.readString();
        this.bearLogo = parcel.readString();
        this.bearHomeUrl = parcel.readString();
        this.bearDesc = parcel.readString();
        this.bearVipType = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        this.bearId = "";
        this.bearName = "";
        this.bearLogo = "";
        this.bearHomeUrl = "";
        this.bearDesc = "";
        this.bearVipType = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bearId = jSONObject.optString(BEAR_ID);
                this.bearDesc = jSONObject.optString("sign");
                this.bearHomeUrl = jSONObject.optString("url");
                this.bearLogo = jSONObject.optString("avatar");
                this.bearName = jSONObject.optString("name");
                this.bearVipType = jSONObject.optString(BEAR_VIP_TYPE);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bearId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bearId);
        parcel.writeString(this.bearName);
        parcel.writeString(this.bearLogo);
        parcel.writeString(this.bearHomeUrl);
        parcel.writeString(this.bearDesc);
        parcel.writeString(this.bearVipType);
    }
}
