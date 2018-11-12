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
        /* renamed from: co */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String anS;
    public String anT;
    public float anU;
    public float anV;
    public String anW;
    public String anX;
    public String anY;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.anS = parcel.readString();
        this.gameName = parcel.readString();
        this.anT = parcel.readString();
        this.anU = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.anV = parcel.readFloat();
        this.anW = parcel.readString();
        this.anX = parcel.readString();
        this.anY = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.anS);
        parcel.writeString(this.gameName);
        parcel.writeString(this.anT);
        parcel.writeFloat(this.anU);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.anV);
        parcel.writeString(this.anW);
        parcel.writeString(this.anX);
        parcel.writeString(this.anY);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anS = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.anT = jSONObject.optString("barDescribe");
            this.anU = (float) jSONObject.optDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.anV = (float) jSONObject.optDouble("userScore");
            this.anW = jSONObject.optString("content");
            this.anX = jSONObject.optString("qrCodeUrl");
            this.anY = jSONObject.optString("headBgUrl");
        }
    }
}
