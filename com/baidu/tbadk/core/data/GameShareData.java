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
        /* renamed from: gP */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String bGc;
    public String bGd;
    public float bGe;
    public float bGf;
    public String bGg;
    public String bGh;
    public String bGi;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.bGc = parcel.readString();
        this.gameName = parcel.readString();
        this.bGd = parcel.readString();
        this.bGe = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.bGf = parcel.readFloat();
        this.bGg = parcel.readString();
        this.bGh = parcel.readString();
        this.bGi = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bGc);
        parcel.writeString(this.gameName);
        parcel.writeString(this.bGd);
        parcel.writeFloat(this.bGe);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.bGf);
        parcel.writeString(this.bGg);
        parcel.writeString(this.bGh);
        parcel.writeString(this.bGi);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bGc = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.bGd = jSONObject.optString("barDescribe");
            this.bGe = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.bGf = (float) jSONObject.optDouble("userScore");
            this.bGg = jSONObject.optString("content");
            this.bGh = jSONObject.optString("qrCodeUrl");
            this.bGi = jSONObject.optString("headBgUrl");
        }
    }
}
