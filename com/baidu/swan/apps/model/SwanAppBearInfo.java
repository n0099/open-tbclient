package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.swan.apps.process.SwanAppIPCData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    public String aXA;
    public String aXB;
    public String aXw;
    public String aXx;
    public String aXy;
    public String aXz;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Parcelable.Creator<SwanAppBearInfo> CREATOR = new Parcelable.Creator<SwanAppBearInfo>() { // from class: com.baidu.swan.apps.model.SwanAppBearInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: q */
        public SwanAppBearInfo createFromParcel(Parcel parcel) {
            return new SwanAppBearInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: dH */
        public SwanAppBearInfo[] newArray(int i) {
            return new SwanAppBearInfo[i];
        }
    };

    public SwanAppBearInfo() {
        this.aXw = "";
        this.aXx = "";
        this.aXy = "";
        this.aXz = "";
        this.aXA = "";
        this.aXB = "";
    }

    private SwanAppBearInfo(Parcel parcel) {
        this.aXw = "";
        this.aXx = "";
        this.aXy = "";
        this.aXz = "";
        this.aXA = "";
        this.aXB = "";
        this.aXw = parcel.readString();
        this.aXx = parcel.readString();
        this.aXy = parcel.readString();
        this.aXz = parcel.readString();
        this.aXA = parcel.readString();
        this.aXB = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        this.aXw = "";
        this.aXx = "";
        this.aXy = "";
        this.aXz = "";
        this.aXA = "";
        this.aXB = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aXw = jSONObject.optString("office_id");
                this.aXA = jSONObject.optString("sign");
                this.aXz = jSONObject.optString("url");
                this.aXy = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                this.aXx = jSONObject.optString("name");
                this.aXB = jSONObject.optString("v_type");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aXw);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aXw);
        parcel.writeString(this.aXx);
        parcel.writeString(this.aXy);
        parcel.writeString(this.aXz);
        parcel.writeString(this.aXA);
        parcel.writeString(this.aXB);
    }
}
