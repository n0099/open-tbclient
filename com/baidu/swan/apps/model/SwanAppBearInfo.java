package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    public String aBr;
    public String aBs;
    public String aBt;
    public String aBu;
    public String aBv;
    public String aBw;
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public static final Parcelable.Creator<SwanAppBearInfo> CREATOR = new Parcelable.Creator<SwanAppBearInfo>() { // from class: com.baidu.swan.apps.model.SwanAppBearInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: i */
        public SwanAppBearInfo createFromParcel(Parcel parcel) {
            return new SwanAppBearInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cI */
        public SwanAppBearInfo[] newArray(int i) {
            return new SwanAppBearInfo[i];
        }
    };

    public SwanAppBearInfo() {
        this.aBr = "";
        this.aBs = "";
        this.aBt = "";
        this.aBu = "";
        this.aBv = "";
        this.aBw = "";
    }

    private SwanAppBearInfo(Parcel parcel) {
        this.aBr = "";
        this.aBs = "";
        this.aBt = "";
        this.aBu = "";
        this.aBv = "";
        this.aBw = "";
        this.aBr = parcel.readString();
        this.aBs = parcel.readString();
        this.aBt = parcel.readString();
        this.aBu = parcel.readString();
        this.aBv = parcel.readString();
        this.aBw = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        this.aBr = "";
        this.aBs = "";
        this.aBt = "";
        this.aBu = "";
        this.aBv = "";
        this.aBw = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aBr = jSONObject.optString("office_id");
                this.aBv = jSONObject.optString(SapiUtils.KEY_QR_LOGIN_SIGN);
                this.aBu = jSONObject.optString("url");
                this.aBt = jSONObject.optString("avatar");
                this.aBs = jSONObject.optString("name");
                this.aBw = jSONObject.optString("v_type");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aBr);
        parcel.writeString(this.aBs);
        parcel.writeString(this.aBt);
        parcel.writeString(this.aBu);
        parcel.writeString(this.aBv);
        parcel.writeString(this.aBw);
    }
}
