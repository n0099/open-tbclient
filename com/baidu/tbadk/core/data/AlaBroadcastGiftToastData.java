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
        /* renamed from: cn */
        public AlaBroadcastGiftToastData[] newArray(int i) {
            return new AlaBroadcastGiftToastData[i];
        }
    };
    public String amA;
    public String amw;
    public String amx;
    public long amy;
    public long amz;
    public String gift_name;
    public long live_id;

    public AlaBroadcastGiftToastData() {
    }

    public AlaBroadcastGiftToastData(Parcel parcel) {
        this.live_id = parcel.readLong();
        this.amw = parcel.readString();
        this.amx = parcel.readString();
        this.amy = parcel.readLong();
        this.gift_name = parcel.readString();
        this.amz = parcel.readLong();
        this.amA = parcel.readString();
    }

    @Override // com.baidu.tbadk.core.data.i
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.amw = jSONObject.optString("sender");
            this.amA = jSONObject.optString("sender_portrait");
            this.amx = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.amy = jSONObject.optLong("gift_id", 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.amz = jSONObject.optLong("msg_id", 0L);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.live_id);
        parcel.writeString(this.amw);
        parcel.writeString(this.amx);
        parcel.writeLong(this.amy);
        parcel.writeString(this.gift_name);
        parcel.writeLong(this.amz);
        parcel.writeString(this.amA);
    }
}
