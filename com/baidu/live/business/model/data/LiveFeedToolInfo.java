package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.tieba.pic;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveFeedToolInfo implements Parcelable {
    public static final Parcelable.Creator<LiveFeedToolInfo> CREATOR = new Parcelable.Creator<LiveFeedToolInfo>() { // from class: com.baidu.live.business.model.data.LiveFeedToolInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveFeedToolInfo createFromParcel(Parcel parcel) {
            return new LiveFeedToolInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveFeedToolInfo[] newArray(int i) {
            return new LiveFeedToolInfo[i];
        }
    };
    public String cmd;
    public String icon;
    public String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LiveFeedToolInfo() {
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.icon) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.cmd)) {
            return true;
        }
        return false;
    }

    public LiveFeedToolInfo(Parcel parcel) {
        this.icon = parcel.readString();
        this.name = parcel.readString();
        this.cmd = parcel.readString();
    }

    public static LiveFeedToolInfo parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LiveFeedToolInfo liveFeedToolInfo = new LiveFeedToolInfo();
        liveFeedToolInfo.icon = jSONObject.optString(pic.f);
        liveFeedToolInfo.name = jSONObject.optString("name");
        JSONObject optJSONObject = jSONObject.optJSONObject("cmd");
        if (optJSONObject != null) {
            liveFeedToolInfo.cmd = optJSONObject.optString("action");
        }
        return liveFeedToolInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.icon);
        parcel.writeString(this.name);
        parcel.writeString(this.cmd);
    }
}
