package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedReserveHeaderInfo implements Parcelable {
    public static final Parcelable.Creator<LiveFeedReserveHeaderInfo> CREATOR = new Parcelable.Creator<LiveFeedReserveHeaderInfo>() { // from class: com.baidu.live.business.model.data.LiveFeedReserveHeaderInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveFeedReserveHeaderInfo createFromParcel(Parcel parcel) {
            return new LiveFeedReserveHeaderInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveFeedReserveHeaderInfo[] newArray(int i) {
            return new LiveFeedReserveHeaderInfo[i];
        }
    };
    public String tip;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LiveFeedReserveHeaderInfo() {
    }

    public LiveFeedReserveHeaderInfo(Parcel parcel) {
        this.tip = parcel.readString();
    }

    public static LiveFeedReserveHeaderInfo parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LiveFeedReserveHeaderInfo liveFeedReserveHeaderInfo = new LiveFeedReserveHeaderInfo();
        liveFeedReserveHeaderInfo.tip = jSONObject.optString("show_msg");
        return liveFeedReserveHeaderInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.tip);
    }
}
