package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LeftLableInfo implements Parcelable {
    public static final Parcelable.Creator<LeftLableInfo> CREATOR = new Parcelable.Creator<LeftLableInfo>() { // from class: com.baidu.live.business.model.data.LeftLableInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LeftLableInfo createFromParcel(Parcel parcel) {
            return new LeftLableInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LeftLableInfo[] newArray(int i) {
            return new LeftLableInfo[i];
        }
    };
    public String cmd;
    public String dot;
    public String endColor;
    public String isShow;
    public String leftIcon;
    public String newText;
    public String prefix;
    public String rightIcon;
    public String startColor;
    public String text;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LeftLableInfo() {
    }

    public boolean canShowLabel() {
        if ("1".equals(this.isShow) && !TextUtils.isEmpty(this.text)) {
            return true;
        }
        return false;
    }

    public boolean isRankTopStyle() {
        if ("1".equals(this.isShow) && !TextUtils.isEmpty(this.prefix) && !TextUtils.isEmpty(this.newText)) {
            return true;
        }
        return false;
    }

    public LeftLableInfo(Parcel parcel) {
        this.text = parcel.readString();
        this.startColor = parcel.readString();
        this.endColor = parcel.readString();
        this.dot = parcel.readString();
        this.isShow = parcel.readString();
        this.leftIcon = parcel.readString();
        this.rightIcon = parcel.readString();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.text = jSONObject.optString("text");
        this.startColor = jSONObject.optString("start_color");
        this.endColor = jSONObject.optString("end_color");
        this.dot = jSONObject.optString("dot");
        this.isShow = jSONObject.optString("is_show");
        this.leftIcon = jSONObject.optString("left_icon");
        this.rightIcon = jSONObject.optString("right_icon");
        this.cmd = jSONObject.optString("url");
        this.prefix = jSONObject.optString("prefix");
        this.newText = jSONObject.optString("new_text");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
        parcel.writeString(this.startColor);
        parcel.writeString(this.endColor);
        parcel.writeString(this.dot);
        parcel.writeString(this.isShow);
        parcel.writeString(this.leftIcon);
        parcel.writeString(this.rightIcon);
        parcel.writeString(this.cmd);
    }
}
