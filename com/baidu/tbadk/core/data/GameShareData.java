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
        /* renamed from: gU */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String bHd;
    public String bHe;
    public float bHf;
    public float bHg;
    public String bHh;
    public String bHi;
    public String bHj;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.bHd = parcel.readString();
        this.gameName = parcel.readString();
        this.bHe = parcel.readString();
        this.bHf = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.bHg = parcel.readFloat();
        this.bHh = parcel.readString();
        this.bHi = parcel.readString();
        this.bHj = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bHd);
        parcel.writeString(this.gameName);
        parcel.writeString(this.bHe);
        parcel.writeFloat(this.bHf);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.bHg);
        parcel.writeString(this.bHh);
        parcel.writeString(this.bHi);
        parcel.writeString(this.bHj);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bHd = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.bHe = jSONObject.optString("barDescribe");
            this.bHf = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.bHg = (float) jSONObject.optDouble("userScore");
            this.bHh = jSONObject.optString("content");
            this.bHi = jSONObject.optString("qrCodeUrl");
            this.bHj = jSONObject.optString("headBgUrl");
        }
    }
}
