package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GameShareData implements Parcelable {
    public static final Parcelable.Creator<GameShareData> CREATOR = new Parcelable.Creator<GameShareData>() { // from class: com.baidu.tbadk.core.data.GameShareData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: v */
        public GameShareData createFromParcel(Parcel parcel) {
            return new GameShareData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gd */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String byQ;
    public String byR;
    public float byS;
    public float byT;
    public String byU;
    public String byV;
    public String byW;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.byQ = parcel.readString();
        this.gameName = parcel.readString();
        this.byR = parcel.readString();
        this.byS = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.byT = parcel.readFloat();
        this.byU = parcel.readString();
        this.byV = parcel.readString();
        this.byW = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.byQ);
        parcel.writeString(this.gameName);
        parcel.writeString(this.byR);
        parcel.writeFloat(this.byS);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.byT);
        parcel.writeString(this.byU);
        parcel.writeString(this.byV);
        parcel.writeString(this.byW);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.byQ = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.byR = jSONObject.optString("barDescribe");
            this.byS = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.byT = (float) jSONObject.optDouble("userScore");
            this.byU = jSONObject.optString("content");
            this.byV = jSONObject.optString("qrCodeUrl");
            this.byW = jSONObject.optString("headBgUrl");
        }
    }
}
