package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    public static final String BEAR_DESC = "sign";
    public static final String BEAR_ID = "office_id";
    public static final String BEAR_INFO = "bear_info";
    public static final String BEAR_LOGO = "avatar";
    public static final String BEAR_NAME = "name";
    public static final String BEAR_URL = "url";
    public static final String BEAR_VIP_TYPE = "v_type";
    public String bearDesc;
    public String bearHomeUrl;
    public String bearId;
    public String bearLogo;
    public String bearName;
    public String bearVipType;
    public static final boolean DEBUG = k.f45051a;
    public static final Parcelable.Creator<SwanAppBearInfo> CREATOR = new a();

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<SwanAppBearInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwanAppBearInfo createFromParcel(Parcel parcel) {
            return new SwanAppBearInfo(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanAppBearInfo[] newArray(int i) {
            return new SwanAppBearInfo[i];
        }
    }

    public /* synthetic */ SwanAppBearInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public boolean a() {
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

    public SwanAppBearInfo() {
        this.bearId = "";
        this.bearName = "";
        this.bearLogo = "";
        this.bearHomeUrl = "";
        this.bearDesc = "";
        this.bearVipType = "";
    }

    public SwanAppBearInfo(Parcel parcel) {
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
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.bearId = jSONObject.optString(BEAR_ID);
            this.bearDesc = jSONObject.optString("sign");
            this.bearHomeUrl = jSONObject.optString("url");
            this.bearLogo = jSONObject.optString("avatar");
            this.bearName = jSONObject.optString("name");
            this.bearVipType = jSONObject.optString(BEAR_VIP_TYPE);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }
}
