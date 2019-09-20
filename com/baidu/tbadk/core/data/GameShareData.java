package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GameShareData implements Parcelable {
    public static final Parcelable.Creator<GameShareData> CREATOR = new Parcelable.Creator<GameShareData>() { // from class: com.baidu.tbadk.core.data.GameShareData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public GameShareData createFromParcel(Parcel parcel) {
            return new GameShareData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gV */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String bHC;
    public String bHD;
    public float bHE;
    public float bHF;
    public String bHG;
    public String bHH;
    public String bHI;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.bHC = parcel.readString();
        this.gameName = parcel.readString();
        this.bHD = parcel.readString();
        this.bHE = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.bHF = parcel.readFloat();
        this.bHG = parcel.readString();
        this.bHH = parcel.readString();
        this.bHI = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bHC);
        parcel.writeString(this.gameName);
        parcel.writeString(this.bHD);
        parcel.writeFloat(this.bHE);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.bHF);
        parcel.writeString(this.bHG);
        parcel.writeString(this.bHH);
        parcel.writeString(this.bHI);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bHC = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.bHD = jSONObject.optString("barDescribe");
            this.bHE = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.bHF = (float) jSONObject.optDouble("userScore");
            this.bHG = jSONObject.optString("content");
            this.bHH = jSONObject.optString("qrCodeUrl");
            this.bHI = jSONObject.optString("headBgUrl");
        }
    }
}
