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
    public String byP;
    public String byQ;
    public float byR;
    public float byS;
    public String byT;
    public String byU;
    public String byV;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.byP = parcel.readString();
        this.gameName = parcel.readString();
        this.byQ = parcel.readString();
        this.byR = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.byS = parcel.readFloat();
        this.byT = parcel.readString();
        this.byU = parcel.readString();
        this.byV = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.byP);
        parcel.writeString(this.gameName);
        parcel.writeString(this.byQ);
        parcel.writeFloat(this.byR);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.byS);
        parcel.writeString(this.byT);
        parcel.writeString(this.byU);
        parcel.writeString(this.byV);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.byP = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.byQ = jSONObject.optString("barDescribe");
            this.byR = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.byS = (float) jSONObject.optDouble("userScore");
            this.byT = jSONObject.optString("content");
            this.byU = jSONObject.optString("qrCodeUrl");
            this.byV = jSONObject.optString("headBgUrl");
        }
    }
}
