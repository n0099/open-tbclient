package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.live.tbadk.log.LogConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaBroadcastGiftToastData extends m implements Parcelable {
    public static final Parcelable.Creator<AlaBroadcastGiftToastData> CREATOR = new Parcelable.Creator<AlaBroadcastGiftToastData>() { // from class: com.baidu.tbadk.core.data.AlaBroadcastGiftToastData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: L */
        public AlaBroadcastGiftToastData createFromParcel(Parcel parcel) {
            return new AlaBroadcastGiftToastData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: nx */
        public AlaBroadcastGiftToastData[] newArray(int i) {
            return new AlaBroadcastGiftToastData[i];
        }
    };
    public long gift_id;
    public String gift_name;
    public long live_id;
    public long msg_id;
    public String receiver;
    public String sender;
    public String sender_portrait;
    public String thumbnail_url;

    public AlaBroadcastGiftToastData() {
    }

    public AlaBroadcastGiftToastData(Parcel parcel) {
        this.live_id = parcel.readLong();
        this.sender = parcel.readString();
        this.receiver = parcel.readString();
        this.gift_id = parcel.readLong();
        this.gift_name = parcel.readString();
        this.msg_id = parcel.readLong();
        this.sender_portrait = parcel.readString();
        this.thumbnail_url = parcel.readString();
    }

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.sender = jSONObject.optString("sender");
            this.sender_portrait = jSONObject.optString("sender_portrait");
            this.receiver = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.gift_id = jSONObject.optLong(LogConfig.LOG_GIFT_ID, 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.msg_id = jSONObject.optLong("msg_id", 0L);
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
        parcel.writeString(this.sender);
        parcel.writeString(this.receiver);
        parcel.writeLong(this.gift_id);
        parcel.writeString(this.gift_name);
        parcel.writeLong(this.msg_id);
        parcel.writeString(this.sender_portrait);
        parcel.writeString(this.thumbnail_url);
    }
}
