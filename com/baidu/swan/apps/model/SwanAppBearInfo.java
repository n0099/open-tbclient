package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    public String aBA;
    public String aBB;
    public String aBw;
    public String aBx;
    public String aBy;
    public String aBz;
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
        /* renamed from: cH */
        public SwanAppBearInfo[] newArray(int i) {
            return new SwanAppBearInfo[i];
        }
    };

    public SwanAppBearInfo() {
        this.aBw = "";
        this.aBx = "";
        this.aBy = "";
        this.aBz = "";
        this.aBA = "";
        this.aBB = "";
    }

    private SwanAppBearInfo(Parcel parcel) {
        this.aBw = "";
        this.aBx = "";
        this.aBy = "";
        this.aBz = "";
        this.aBA = "";
        this.aBB = "";
        this.aBw = parcel.readString();
        this.aBx = parcel.readString();
        this.aBy = parcel.readString();
        this.aBz = parcel.readString();
        this.aBA = parcel.readString();
        this.aBB = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        this.aBw = "";
        this.aBx = "";
        this.aBy = "";
        this.aBz = "";
        this.aBA = "";
        this.aBB = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aBw = jSONObject.optString("office_id");
                this.aBA = jSONObject.optString("sign");
                this.aBz = jSONObject.optString("url");
                this.aBy = jSONObject.optString("avatar");
                this.aBx = jSONObject.optString("name");
                this.aBB = jSONObject.optString("v_type");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBw);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aBw);
        parcel.writeString(this.aBx);
        parcel.writeString(this.aBy);
        parcel.writeString(this.aBz);
        parcel.writeString(this.aBA);
        parcel.writeString(this.aBB);
    }
}
