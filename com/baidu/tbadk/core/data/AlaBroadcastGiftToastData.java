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
        /* renamed from: x */
        public AlaBroadcastGiftToastData createFromParcel(Parcel parcel) {
            return new AlaBroadcastGiftToastData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gO */
        public AlaBroadcastGiftToastData[] newArray(int i) {
            return new AlaBroadcastGiftToastData[i];
        }
    };
    public String bEG;
    public String bEH;
    public long bEI;
    public long bEJ;
    public String bEK;
    public String gift_name;
    public long live_id;
    public String thumbnail_url;

    public AlaBroadcastGiftToastData() {
    }

    public AlaBroadcastGiftToastData(Parcel parcel) {
        this.live_id = parcel.readLong();
        this.bEG = parcel.readString();
        this.bEH = parcel.readString();
        this.bEI = parcel.readLong();
        this.gift_name = parcel.readString();
        this.bEJ = parcel.readLong();
        this.bEK = parcel.readString();
        this.thumbnail_url = parcel.readString();
    }

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.bEG = jSONObject.optString("sender");
            this.bEK = jSONObject.optString("sender_portrait");
            this.bEH = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.bEI = jSONObject.optLong("gift_id", 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.bEJ = jSONObject.optLong("msg_id", 0L);
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
        parcel.writeString(this.bEG);
        parcel.writeString(this.bEH);
        parcel.writeLong(this.bEI);
        parcel.writeString(this.gift_name);
        parcel.writeLong(this.bEJ);
        parcel.writeString(this.bEK);
        parcel.writeString(this.thumbnail_url);
    }
}
