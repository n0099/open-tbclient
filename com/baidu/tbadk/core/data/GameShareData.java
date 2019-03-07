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
    public String byK;
    public String byL;
    public float byM;
    public float byN;
    public String byO;
    public String byP;
    public String byQ;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.byK = parcel.readString();
        this.gameName = parcel.readString();
        this.byL = parcel.readString();
        this.byM = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.byN = parcel.readFloat();
        this.byO = parcel.readString();
        this.byP = parcel.readString();
        this.byQ = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.byK);
        parcel.writeString(this.gameName);
        parcel.writeString(this.byL);
        parcel.writeFloat(this.byM);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.byN);
        parcel.writeString(this.byO);
        parcel.writeString(this.byP);
        parcel.writeString(this.byQ);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.byK = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.byL = jSONObject.optString("barDescribe");
            this.byM = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.byN = (float) jSONObject.optDouble("userScore");
            this.byO = jSONObject.optString("content");
            this.byP = jSONObject.optString("qrCodeUrl");
            this.byQ = jSONObject.optString("headBgUrl");
        }
    }
}
