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
    public String fragmentId;
    public String iconUrl;
    public String imageUrl;
    public String scheme;
    public String title;
    public String type;
    public String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

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
        public SwanAppPageInfo[] newArray(int i) {
            return new SwanAppPageInfo[i];
        }
    }

    public SwanAppPageInfo(Parcel parcel) {
        this.appName = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appDesc = parcel.readString();
        this.title = parcel.readString();
        this.imageUrl = parcel.readString();
        this.type = parcel.readString();
        this.url = parcel.readString();
        this.scheme = parcel.readString();
        this.fragmentId = parcel.readString();
    }

    public SwanAppPageInfo(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        parsePageInfo(jSONObject);
    }

    public SwanAppPageInfo(JSONObject jSONObject) {
        parsePageInfo(jSONObject);
    }

    private void parsePageInfo(JSONObject jSONObject) {
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
        this.scheme = jSONObject.optString("scheme");
        this.fragmentId = jSONObject.optString("pageId");
    }

    public String toString() {
        return "SwanAppPageInfo{appName='" + this.appName + "', iconUrl='" + this.iconUrl + "', appDesc='" + this.appDesc + "', title='" + this.title + "', imageUrl='" + this.imageUrl + "', type='" + this.type + "', url='" + this.url + "', scheme='" + this.scheme + "', fragmentId='" + this.fragmentId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appName);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appDesc);
        parcel.writeString(this.title);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.type);
        parcel.writeString(this.url);
        parcel.writeString(this.scheme);
        parcel.writeString(this.fragmentId);
    }
}
