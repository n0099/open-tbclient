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
        /* renamed from: ge */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String byM;
    public String byN;
    public float byO;
    public float byP;
    public String byQ;
    public String byR;
    public String byS;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.byM = parcel.readString();
        this.gameName = parcel.readString();
        this.byN = parcel.readString();
        this.byO = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.byP = parcel.readFloat();
        this.byQ = parcel.readString();
        this.byR = parcel.readString();
        this.byS = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.byM);
        parcel.writeString(this.gameName);
        parcel.writeString(this.byN);
        parcel.writeFloat(this.byO);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.byP);
        parcel.writeString(this.byQ);
        parcel.writeString(this.byR);
        parcel.writeString(this.byS);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.byM = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.byN = jSONObject.optString("barDescribe");
            this.byO = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.byP = (float) jSONObject.optDouble("userScore");
            this.byQ = jSONObject.optString("content");
            this.byR = jSONObject.optString("qrCodeUrl");
            this.byS = jSONObject.optString("headBgUrl");
        }
    }
}
