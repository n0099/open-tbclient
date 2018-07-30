package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.ar.paddle.PaddleController;
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
        /* renamed from: bF */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String afJ;
    public String afK;
    public float afL;
    public float afM;
    public String afN;
    public String afO;
    public String afP;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.afJ = parcel.readString();
        this.gameName = parcel.readString();
        this.afK = parcel.readString();
        this.afL = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.afM = parcel.readFloat();
        this.afN = parcel.readString();
        this.afO = parcel.readString();
        this.afP = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.afJ);
        parcel.writeString(this.gameName);
        parcel.writeString(this.afK);
        parcel.writeFloat(this.afL);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.afM);
        parcel.writeString(this.afN);
        parcel.writeString(this.afO);
        parcel.writeString(this.afP);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.afJ = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.afK = jSONObject.optString("barDescribe");
            this.afL = (float) jSONObject.optDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.afM = (float) jSONObject.optDouble("userScore");
            this.afN = jSONObject.optString("content");
            this.afO = jSONObject.optString("qrCodeUrl");
            this.afP = jSONObject.optString("headBgUrl");
        }
    }
}
