package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveHostInfo implements Parcelable {
    public static final Parcelable.Creator<LiveHostInfo> CREATOR = new Parcelable.Creator<LiveHostInfo>() { // from class: com.baidu.live.business.model.data.LiveHostInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveHostInfo createFromParcel(Parcel parcel) {
            return new LiveHostInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveHostInfo[] newArray(int i) {
            return new LiveHostInfo[i];
        }
    };
    public String avatar;
    public String name;
    public String uk;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LiveHostInfo() {
    }

    public LiveHostInfo(Parcel parcel) {
        this.uk = parcel.readString();
        this.name = parcel.readString();
        this.avatar = parcel.readString();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.uk = jSONObject.optString("uk");
        this.name = jSONObject.optString("name");
        this.avatar = jSONObject.optString("avatar");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uk);
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
    }
}
