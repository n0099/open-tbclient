package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ThirdLabelInfo implements Parcelable {
    public static final Parcelable.Creator<ThirdLabelInfo> CREATOR = new Parcelable.Creator<ThirdLabelInfo>() { // from class: com.baidu.live.business.model.data.ThirdLabelInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThirdLabelInfo createFromParcel(Parcel parcel) {
            return new ThirdLabelInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThirdLabelInfo[] newArray(int i) {
            return new ThirdLabelInfo[i];
        }
    };
    public String dot;
    public String endColor;
    public String iconUrl;
    public String isShow;
    public String startColor;
    public String text;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ThirdLabelInfo() {
    }

    public boolean canShowLabel() {
        if ("1".equals(this.isShow) && (!TextUtils.isEmpty(this.text) || !TextUtils.isEmpty(this.iconUrl))) {
            return true;
        }
        return false;
    }

    public ThirdLabelInfo(Parcel parcel) {
        this.text = parcel.readString();
        this.iconUrl = parcel.readString();
        this.startColor = parcel.readString();
        this.endColor = parcel.readString();
        this.dot = parcel.readString();
        this.isShow = parcel.readString();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.text = jSONObject.optString("text");
        this.iconUrl = jSONObject.optString("icon_url");
        this.startColor = jSONObject.optString("start_color");
        this.endColor = jSONObject.optString("end_color");
        this.dot = jSONObject.optString("dot");
        this.isShow = jSONObject.optString("is_show");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.startColor);
        parcel.writeString(this.endColor);
        parcel.writeString(this.dot);
        parcel.writeString(this.isShow);
    }
}
