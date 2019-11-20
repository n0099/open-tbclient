package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GameShareData implements Parcelable {
    public static final Parcelable.Creator<GameShareData> CREATOR = new Parcelable.Creator<GameShareData>() { // from class: com.baidu.tbadk.core.data.GameShareData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: G */
        public GameShareData createFromParcel(Parcel parcel) {
            return new GameShareData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ht */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String bYA;
    public String bYB;
    public String bYC;
    public String bYw;
    public String bYx;
    public float bYy;
    public float bYz;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.bYw = parcel.readString();
        this.gameName = parcel.readString();
        this.bYx = parcel.readString();
        this.bYy = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.bYz = parcel.readFloat();
        this.bYA = parcel.readString();
        this.bYB = parcel.readString();
        this.bYC = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bYw);
        parcel.writeString(this.gameName);
        parcel.writeString(this.bYx);
        parcel.writeFloat(this.bYy);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.bYz);
        parcel.writeString(this.bYA);
        parcel.writeString(this.bYB);
        parcel.writeString(this.bYC);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bYw = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.bYx = jSONObject.optString("barDescribe");
            this.bYy = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
            this.userPortrait = jSONObject.optString("avastar");
            this.bYz = (float) jSONObject.optDouble("userScore");
            this.bYA = jSONObject.optString("content");
            this.bYB = jSONObject.optString("qrCodeUrl");
            this.bYC = jSONObject.optString("headBgUrl");
        }
    }
}
