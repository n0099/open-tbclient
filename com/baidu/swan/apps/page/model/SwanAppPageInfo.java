package com.baidu.swan.apps.page.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppPageInfo implements Parcelable {
    public static final Parcelable.Creator<SwanAppPageInfo> CREATOR = new a();
    public String appDesc;
    public String appName;
    public String iconUrl;
    public String imageUrl;
    public String title;
    public String type;
    public String url;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<SwanAppPageInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwanAppPageInfo createFromParcel(Parcel parcel) {
            return new SwanAppPageInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanAppPageInfo[] newArray(int i2) {
            return new SwanAppPageInfo[i2];
        }
    }

    public SwanAppPageInfo(JSONObject jSONObject) {
        a(jSONObject);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.type = jSONObject.optString("type");
        JSONObject optJSONObject = jSONObject.optJSONObject("pageInfo");
        if (optJSONObject != null) {
            this.title = optJSONObject.optString("title");
            this.imageUrl = optJSONObject.optString("img");
        }
        this.url = jSONObject.optString("url");
        this.appName = jSONObject.optString("appName");
        this.iconUrl = jSONObject.optString("iconUrl");
        this.appDesc = jSONObject.optString("appDesc");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SwanAppPageInfo{appName='" + this.appName + "', iconUrl='" + this.iconUrl + "', appDesc='" + this.appDesc + "', title='" + this.title + "', imageUrl='" + this.imageUrl + "', type='" + this.type + "', url='" + this.url + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.appName);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appDesc);
        parcel.writeString(this.title);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.type);
        parcel.writeString(this.url);
    }

    public SwanAppPageInfo(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        a(jSONObject);
    }

    public SwanAppPageInfo(Parcel parcel) {
        this.appName = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appDesc = parcel.readString();
        this.title = parcel.readString();
        this.imageUrl = parcel.readString();
        this.type = parcel.readString();
        this.url = parcel.readString();
    }
}
