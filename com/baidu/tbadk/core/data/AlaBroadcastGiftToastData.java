package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaBroadcastGiftToastData extends k implements Parcelable {
    public static final Parcelable.Creator<AlaBroadcastGiftToastData> CREATOR = new Parcelable.Creator<AlaBroadcastGiftToastData>() { // from class: com.baidu.tbadk.core.data.AlaBroadcastGiftToastData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: u */
        public AlaBroadcastGiftToastData createFromParcel(Parcel parcel) {
            return new AlaBroadcastGiftToastData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gd */
        public AlaBroadcastGiftToastData[] newArray(int i) {
            return new AlaBroadcastGiftToastData[i];
        }
    };
    public String bxq;
    public String bxr;
    public long bxs;
    public long bxt;
    public String bxu;
    public String gift_name;
    public long live_id;
    public String thumbnail_url;

    public AlaBroadcastGiftToastData() {
    }

    public AlaBroadcastGiftToastData(Parcel parcel) {
        this.live_id = parcel.readLong();
        this.bxq = parcel.readString();
        this.bxr = parcel.readString();
        this.bxs = parcel.readLong();
        this.gift_name = parcel.readString();
        this.bxt = parcel.readLong();
        this.bxu = parcel.readString();
        this.thumbnail_url = parcel.readString();
    }

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.bxq = jSONObject.optString("sender");
            this.bxu = jSONObject.optString("sender_portrait");
            this.bxr = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.bxs = jSONObject.optLong("gift_id", 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.bxt = jSONObject.optLong("msg_id", 0L);
            this.thumbnail_url = jSONObject.optString("gift_url");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.live_id);
        parcel.writeString(this.bxq);
        parcel.writeString(this.bxr);
        parcel.writeLong(this.bxs);
        parcel.writeString(this.gift_name);
        parcel.writeLong(this.bxt);
        parcel.writeString(this.bxu);
        parcel.writeString(this.thumbnail_url);
    }
}
