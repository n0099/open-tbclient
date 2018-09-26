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
        /* renamed from: bO */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String aik;
    public String ail;
    public float aim;
    public float ain;
    public String aio;
    public String aip;
    public String aiq;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.aik = parcel.readString();
        this.gameName = parcel.readString();
        this.ail = parcel.readString();
        this.aim = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.ain = parcel.readFloat();
        this.aio = parcel.readString();
        this.aip = parcel.readString();
        this.aiq = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aik);
        parcel.writeString(this.gameName);
        parcel.writeString(this.ail);
        parcel.writeFloat(this.aim);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.ain);
        parcel.writeString(this.aio);
        parcel.writeString(this.aip);
        parcel.writeString(this.aiq);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aik = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.ail = jSONObject.optString("barDescribe");
            this.aim = (float) jSONObject.optDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.ain = (float) jSONObject.optDouble("userScore");
            this.aio = jSONObject.optString("content");
            this.aip = jSONObject.optString("qrCodeUrl");
            this.aiq = jSONObject.optString("headBgUrl");
        }
    }
}
