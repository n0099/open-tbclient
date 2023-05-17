package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RightLableInfo implements Parcelable {
    public static final Parcelable.Creator<RightLableInfo> CREATOR = new Parcelable.Creator<RightLableInfo>() { // from class: com.baidu.live.business.model.data.RightLableInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RightLableInfo createFromParcel(Parcel parcel) {
            return new RightLableInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RightLableInfo[] newArray(int i) {
            return new RightLableInfo[i];
        }
    };
    public String dot;
    public String iconUrl;
    public String isShow;
    public double wh;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RightLableInfo() {
    }

    public boolean canShowLabel() {
        if ("1".equals(this.isShow) && !TextUtils.isEmpty(this.iconUrl)) {
            return true;
        }
        return false;
    }

    public RightLableInfo(Parcel parcel) {
        this.iconUrl = parcel.readString();
        this.wh = parcel.readDouble();
        this.dot = parcel.readString();
        this.isShow = parcel.readString();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.iconUrl = jSONObject.optString("icon_url");
        this.wh = jSONObject.optDouble("wh");
        this.dot = jSONObject.optString("dot");
        this.isShow = jSONObject.optString("is_show");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.iconUrl);
        parcel.writeDouble(this.wh);
        parcel.writeString(this.dot);
        parcel.writeString(this.isShow);
    }
}
