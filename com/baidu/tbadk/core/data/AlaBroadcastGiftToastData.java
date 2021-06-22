package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.SocialConstants;
import d.a.n0.r.q.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaBroadcastGiftToastData extends o implements Parcelable {
    public static final Parcelable.Creator<AlaBroadcastGiftToastData> CREATOR = new a();
    public long gift_id;
    public String gift_name;
    public long live_id;
    public long msg_id;
    public String receiver;
    public String sender;
    public String sender_portrait;
    public String thumbnail_url;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<AlaBroadcastGiftToastData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AlaBroadcastGiftToastData createFromParcel(Parcel parcel) {
            return new AlaBroadcastGiftToastData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AlaBroadcastGiftToastData[] newArray(int i2) {
            return new AlaBroadcastGiftToastData[i2];
        }
    }

    public AlaBroadcastGiftToastData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // d.a.n0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.live_id = jSONObject.optLong("live_id", 0L);
        this.sender = jSONObject.optString("sender");
        this.sender_portrait = jSONObject.optString("sender_portrait");
        this.receiver = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
        this.gift_id = jSONObject.optLong("gift_id", 0L);
        this.gift_name = jSONObject.optString("gift_name");
        this.msg_id = jSONObject.optLong("msg_id", 0L);
        this.thumbnail_url = jSONObject.optString("gift_url");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.live_id);
        parcel.writeString(this.sender);
        parcel.writeString(this.receiver);
        parcel.writeLong(this.gift_id);
        parcel.writeString(this.gift_name);
        parcel.writeLong(this.msg_id);
        parcel.writeString(this.sender_portrait);
        parcel.writeString(this.thumbnail_url);
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
}
