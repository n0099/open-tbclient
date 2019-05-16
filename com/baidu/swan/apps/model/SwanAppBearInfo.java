package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    public String aDb;
    public String aDc;
    public String aDd;
    public String aDe;
    public String aDf;
    public String aDg;
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
        /* renamed from: cK */
        public SwanAppBearInfo[] newArray(int i) {
            return new SwanAppBearInfo[i];
        }
    };

    public SwanAppBearInfo() {
        this.aDb = "";
        this.aDc = "";
        this.aDd = "";
        this.aDe = "";
        this.aDf = "";
        this.aDg = "";
    }

    private SwanAppBearInfo(Parcel parcel) {
        this.aDb = "";
        this.aDc = "";
        this.aDd = "";
        this.aDe = "";
        this.aDf = "";
        this.aDg = "";
        this.aDb = parcel.readString();
        this.aDc = parcel.readString();
        this.aDd = parcel.readString();
        this.aDe = parcel.readString();
        this.aDf = parcel.readString();
        this.aDg = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        this.aDb = "";
        this.aDc = "";
        this.aDd = "";
        this.aDe = "";
        this.aDf = "";
        this.aDg = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aDb = jSONObject.optString("office_id");
                this.aDf = jSONObject.optString("sign");
                this.aDe = jSONObject.optString("url");
                this.aDd = jSONObject.optString("avatar");
                this.aDc = jSONObject.optString("name");
                this.aDg = jSONObject.optString("v_type");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aDb);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aDb);
        parcel.writeString(this.aDc);
        parcel.writeString(this.aDd);
        parcel.writeString(this.aDe);
        parcel.writeString(this.aDf);
        parcel.writeString(this.aDg);
    }
}
