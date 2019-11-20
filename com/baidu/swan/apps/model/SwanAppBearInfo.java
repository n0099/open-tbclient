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
    public String aXe;
    public String aXf;
    public String aXg;
    public String aXh;
    public String aXi;
    public String aXj;
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
        this.aXe = "";
        this.aXf = "";
        this.aXg = "";
        this.aXh = "";
        this.aXi = "";
        this.aXj = "";
    }

    private SwanAppBearInfo(Parcel parcel) {
        this.aXe = "";
        this.aXf = "";
        this.aXg = "";
        this.aXh = "";
        this.aXi = "";
        this.aXj = "";
        this.aXe = parcel.readString();
        this.aXf = parcel.readString();
        this.aXg = parcel.readString();
        this.aXh = parcel.readString();
        this.aXi = parcel.readString();
        this.aXj = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        this.aXe = "";
        this.aXf = "";
        this.aXg = "";
        this.aXh = "";
        this.aXi = "";
        this.aXj = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aXe = jSONObject.optString("office_id");
                this.aXi = jSONObject.optString("sign");
                this.aXh = jSONObject.optString("url");
                this.aXg = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                this.aXf = jSONObject.optString("name");
                this.aXj = jSONObject.optString("v_type");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aXe);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aXe);
        parcel.writeString(this.aXf);
        parcel.writeString(this.aXg);
        parcel.writeString(this.aXh);
        parcel.writeString(this.aXi);
        parcel.writeString(this.aXj);
    }
}
