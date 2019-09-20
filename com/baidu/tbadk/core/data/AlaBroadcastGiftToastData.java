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
        /* renamed from: gU */
        public AlaBroadcastGiftToastData[] newArray(int i) {
            return new AlaBroadcastGiftToastData[i];
        }
    };
    public String bGf;
    public String bGg;
    public long bGh;
    public long bGi;
    public String bGj;
    public String gift_name;
    public long live_id;
    public String thumbnail_url;

    public AlaBroadcastGiftToastData() {
    }

    public AlaBroadcastGiftToastData(Parcel parcel) {
        this.live_id = parcel.readLong();
        this.bGf = parcel.readString();
        this.bGg = parcel.readString();
        this.bGh = parcel.readLong();
        this.gift_name = parcel.readString();
        this.bGi = parcel.readLong();
        this.bGj = parcel.readString();
        this.thumbnail_url = parcel.readString();
    }

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.bGf = jSONObject.optString("sender");
            this.bGj = jSONObject.optString("sender_portrait");
            this.bGg = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.bGh = jSONObject.optLong("gift_id", 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.bGi = jSONObject.optLong("msg_id", 0L);
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
        parcel.writeString(this.bGf);
        parcel.writeString(this.bGg);
        parcel.writeLong(this.bGh);
        parcel.writeString(this.gift_name);
        parcel.writeLong(this.bGi);
        parcel.writeString(this.bGj);
        parcel.writeString(this.thumbnail_url);
    }
}
