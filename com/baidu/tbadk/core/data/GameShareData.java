package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GameShareData implements Parcelable {
    public static final Parcelable.Creator<GameShareData> CREATOR = new Parcelable.Creator<GameShareData>() { // from class: com.baidu.tbadk.core.data.GameShareData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: f */
        public GameShareData createFromParcel(Parcel parcel) {
            return new GameShareData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: bD */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String aga;
    public String agb;
    public float agc;
    public float agd;
    public String agf;
    public String agg;
    public String agh;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.aga = parcel.readString();
        this.gameName = parcel.readString();
        this.agb = parcel.readString();
        this.agc = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.agd = parcel.readFloat();
        this.agf = parcel.readString();
        this.agg = parcel.readString();
        this.agh = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aga);
        parcel.writeString(this.gameName);
        parcel.writeString(this.agb);
        parcel.writeFloat(this.agc);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.agd);
        parcel.writeString(this.agf);
        parcel.writeString(this.agg);
        parcel.writeString(this.agh);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aga = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.agb = jSONObject.optString("barDescribe");
            this.agc = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.agd = (float) jSONObject.optDouble("userScore");
            this.agf = jSONObject.optString("content");
            this.agg = jSONObject.optString("qrCodeUrl");
            this.agh = jSONObject.optString("headBgUrl");
        }
    }
}
