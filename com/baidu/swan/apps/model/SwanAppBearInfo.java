package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    public String aDJ;
    public String aDK;
    public String aDL;
    public String aDM;
    public String aDN;
    public String aDO;
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
        /* renamed from: cL */
        public SwanAppBearInfo[] newArray(int i) {
            return new SwanAppBearInfo[i];
        }
    };

    public SwanAppBearInfo() {
        this.aDJ = "";
        this.aDK = "";
        this.aDL = "";
        this.aDM = "";
        this.aDN = "";
        this.aDO = "";
    }

    private SwanAppBearInfo(Parcel parcel) {
        this.aDJ = "";
        this.aDK = "";
        this.aDL = "";
        this.aDM = "";
        this.aDN = "";
        this.aDO = "";
        this.aDJ = parcel.readString();
        this.aDK = parcel.readString();
        this.aDL = parcel.readString();
        this.aDM = parcel.readString();
        this.aDN = parcel.readString();
        this.aDO = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        this.aDJ = "";
        this.aDK = "";
        this.aDL = "";
        this.aDM = "";
        this.aDN = "";
        this.aDO = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aDJ = jSONObject.optString("office_id");
                this.aDN = jSONObject.optString("sign");
                this.aDM = jSONObject.optString("url");
                this.aDL = jSONObject.optString("avatar");
                this.aDK = jSONObject.optString("name");
                this.aDO = jSONObject.optString("v_type");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aDJ);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aDJ);
        parcel.writeString(this.aDK);
        parcel.writeString(this.aDL);
        parcel.writeString(this.aDM);
        parcel.writeString(this.aDN);
        parcel.writeString(this.aDO);
    }
}
