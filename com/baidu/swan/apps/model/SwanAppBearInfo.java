package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    public String aBs;
    public String aBt;
    public String aBu;
    public String aBv;
    public String aBw;
    public String aBx;
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
        /* renamed from: cI */
        public SwanAppBearInfo[] newArray(int i) {
            return new SwanAppBearInfo[i];
        }
    };

    public SwanAppBearInfo() {
        this.aBs = "";
        this.aBt = "";
        this.aBu = "";
        this.aBv = "";
        this.aBw = "";
        this.aBx = "";
    }

    private SwanAppBearInfo(Parcel parcel) {
        this.aBs = "";
        this.aBt = "";
        this.aBu = "";
        this.aBv = "";
        this.aBw = "";
        this.aBx = "";
        this.aBs = parcel.readString();
        this.aBt = parcel.readString();
        this.aBu = parcel.readString();
        this.aBv = parcel.readString();
        this.aBw = parcel.readString();
        this.aBx = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        this.aBs = "";
        this.aBt = "";
        this.aBu = "";
        this.aBv = "";
        this.aBw = "";
        this.aBx = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aBs = jSONObject.optString("office_id");
                this.aBw = jSONObject.optString("sign");
                this.aBv = jSONObject.optString("url");
                this.aBu = jSONObject.optString("avatar");
                this.aBt = jSONObject.optString("name");
                this.aBx = jSONObject.optString("v_type");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBs);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aBs);
        parcel.writeString(this.aBt);
        parcel.writeString(this.aBu);
        parcel.writeString(this.aBv);
        parcel.writeString(this.aBw);
        parcel.writeString(this.aBx);
    }
}
