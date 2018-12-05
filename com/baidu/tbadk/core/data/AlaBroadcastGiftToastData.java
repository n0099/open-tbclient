package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaBroadcastGiftToastData extends i implements Parcelable {
    public static final Parcelable.Creator<AlaBroadcastGiftToastData> CREATOR = new Parcelable.Creator<AlaBroadcastGiftToastData>() { // from class: com.baidu.tbadk.core.data.AlaBroadcastGiftToastData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: e */
        public AlaBroadcastGiftToastData createFromParcel(Parcel parcel) {
            return new AlaBroadcastGiftToastData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cB */
        public AlaBroadcastGiftToastData[] newArray(int i) {
            return new AlaBroadcastGiftToastData[i];
        }
    };
    public String apX;
    public String apY;
    public long apZ;
    public long aqa;
    public String aqb;
    public String gift_name;
    public long live_id;
    public String thumbnail_url;

    public AlaBroadcastGiftToastData() {
    }

    public AlaBroadcastGiftToastData(Parcel parcel) {
        this.live_id = parcel.readLong();
        this.apX = parcel.readString();
        this.apY = parcel.readString();
        this.apZ = parcel.readLong();
        this.gift_name = parcel.readString();
        this.aqa = parcel.readLong();
        this.aqb = parcel.readString();
        this.thumbnail_url = parcel.readString();
    }

    @Override // com.baidu.tbadk.core.data.i
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.apX = jSONObject.optString("sender");
            this.aqb = jSONObject.optString("sender_portrait");
            this.apY = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.apZ = jSONObject.optLong("gift_id", 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.aqa = jSONObject.optLong("msg_id", 0L);
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
        parcel.writeString(this.apX);
        parcel.writeString(this.apY);
        parcel.writeLong(this.apZ);
        parcel.writeString(this.gift_name);
        parcel.writeLong(this.aqa);
        parcel.writeString(this.aqb);
        parcel.writeString(this.thumbnail_url);
    }
}
