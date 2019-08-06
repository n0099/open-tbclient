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
    public String bHe;
    public String bHf;
    public float bHg;
    public float bHh;
    public String bHi;
    public String bHj;
    public String bHk;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.bHe = parcel.readString();
        this.gameName = parcel.readString();
        this.bHf = parcel.readString();
        this.bHg = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.bHh = parcel.readFloat();
        this.bHi = parcel.readString();
        this.bHj = parcel.readString();
        this.bHk = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bHe);
        parcel.writeString(this.gameName);
        parcel.writeString(this.bHf);
        parcel.writeFloat(this.bHg);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.bHh);
        parcel.writeString(this.bHi);
        parcel.writeString(this.bHj);
        parcel.writeString(this.bHk);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bHe = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.bHf = jSONObject.optString("barDescribe");
            this.bHg = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.bHh = (float) jSONObject.optDouble("userScore");
            this.bHi = jSONObject.optString("content");
            this.bHj = jSONObject.optString("qrCodeUrl");
            this.bHk = jSONObject.optString("headBgUrl");
        }
    }
}
