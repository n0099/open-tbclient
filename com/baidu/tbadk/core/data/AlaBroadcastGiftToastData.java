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
        /* renamed from: bY */
        public AlaBroadcastGiftToastData[] newArray(int i) {
            return new AlaBroadcastGiftToastData[i];
        }
    };
    public String alJ;
    public String alK;
    public long alL;
    public long alM;
    public String alN;
    public String gift_name;
    public long live_id;

    public AlaBroadcastGiftToastData() {
    }

    public AlaBroadcastGiftToastData(Parcel parcel) {
        this.live_id = parcel.readLong();
        this.alJ = parcel.readString();
        this.alK = parcel.readString();
        this.alL = parcel.readLong();
        this.gift_name = parcel.readString();
        this.alM = parcel.readLong();
        this.alN = parcel.readString();
    }

    @Override // com.baidu.tbadk.core.data.i
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.alJ = jSONObject.optString("sender");
            this.alN = jSONObject.optString("sender_portrait");
            this.alK = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.alL = jSONObject.optLong("gift_id", 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.alM = jSONObject.optLong("msg_id", 0L);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.live_id);
        parcel.writeString(this.alJ);
        parcel.writeString(this.alK);
        parcel.writeLong(this.alL);
        parcel.writeString(this.gift_name);
        parcel.writeLong(this.alM);
        parcel.writeString(this.alN);
    }
}
