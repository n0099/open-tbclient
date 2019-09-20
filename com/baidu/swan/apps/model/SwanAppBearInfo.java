package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    public String aEh;
    public String aEi;
    public String aEj;
    public String aEk;
    public String aEl;
    public String aEm;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Parcelable.Creator<SwanAppBearInfo> CREATOR = new Parcelable.Creator<SwanAppBearInfo>() { // from class: com.baidu.swan.apps.model.SwanAppBearInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: i */
        public SwanAppBearInfo createFromParcel(Parcel parcel) {
            return new SwanAppBearInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cM */
        public SwanAppBearInfo[] newArray(int i) {
            return new SwanAppBearInfo[i];
        }
    };

    public SwanAppBearInfo() {
        this.aEh = "";
        this.aEi = "";
        this.aEj = "";
        this.aEk = "";
        this.aEl = "";
        this.aEm = "";
    }

    private SwanAppBearInfo(Parcel parcel) {
        this.aEh = "";
        this.aEi = "";
        this.aEj = "";
        this.aEk = "";
        this.aEl = "";
        this.aEm = "";
        this.aEh = parcel.readString();
        this.aEi = parcel.readString();
        this.aEj = parcel.readString();
        this.aEk = parcel.readString();
        this.aEl = parcel.readString();
        this.aEm = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        this.aEh = "";
        this.aEi = "";
        this.aEj = "";
        this.aEk = "";
        this.aEl = "";
        this.aEm = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aEh = jSONObject.optString("office_id");
                this.aEl = jSONObject.optString("sign");
                this.aEk = jSONObject.optString("url");
                this.aEj = jSONObject.optString("avatar");
                this.aEi = jSONObject.optString("name");
                this.aEm = jSONObject.optString("v_type");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aEh);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aEh);
        parcel.writeString(this.aEi);
        parcel.writeString(this.aEj);
        parcel.writeString(this.aEk);
        parcel.writeString(this.aEl);
        parcel.writeString(this.aEm);
    }
}
