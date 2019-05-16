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
    public String bGb;
    public String bGc;
    public float bGd;
    public float bGe;
    public String bGf;
    public String bGg;
    public String bGh;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.bGb = parcel.readString();
        this.gameName = parcel.readString();
        this.bGc = parcel.readString();
        this.bGd = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.bGe = parcel.readFloat();
        this.bGf = parcel.readString();
        this.bGg = parcel.readString();
        this.bGh = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bGb);
        parcel.writeString(this.gameName);
        parcel.writeString(this.bGc);
        parcel.writeFloat(this.bGd);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.bGe);
        parcel.writeString(this.bGf);
        parcel.writeString(this.bGg);
        parcel.writeString(this.bGh);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bGb = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.bGc = jSONObject.optString("barDescribe");
            this.bGd = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.bGe = (float) jSONObject.optDouble("userScore");
            this.bGf = jSONObject.optString("content");
            this.bGg = jSONObject.optString("qrCodeUrl");
            this.bGh = jSONObject.optString("headBgUrl");
        }
    }
}
