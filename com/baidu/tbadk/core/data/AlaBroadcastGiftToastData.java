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
        /* renamed from: bC */
        public AlaBroadcastGiftToastData[] newArray(int i) {
            return new AlaBroadcastGiftToastData[i];
        }
    };
    public String aeu;
    public String aev;
    public long aew;
    public long aex;
    public String aey;
    public String gift_name;
    public long live_id;

    public AlaBroadcastGiftToastData() {
    }

    public AlaBroadcastGiftToastData(Parcel parcel) {
        this.live_id = parcel.readLong();
        this.aeu = parcel.readString();
        this.aev = parcel.readString();
        this.aew = parcel.readLong();
        this.gift_name = parcel.readString();
        this.aex = parcel.readLong();
        this.aey = parcel.readString();
    }

    @Override // com.baidu.tbadk.core.data.i
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.aeu = jSONObject.optString("sender");
            this.aey = jSONObject.optString("sender_portrait");
            this.aev = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.aew = jSONObject.optLong("gift_id", 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.aex = jSONObject.optLong("msg_id", 0L);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.live_id);
        parcel.writeString(this.aeu);
        parcel.writeString(this.aev);
        parcel.writeLong(this.aew);
        parcel.writeString(this.gift_name);
        parcel.writeLong(this.aex);
        parcel.writeString(this.aey);
    }
}
