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
        /* renamed from: cC */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String art;
    public String aru;
    public float arv;
    public float arw;
    public String arx;
    public String ary;
    public String arz;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.art = parcel.readString();
        this.gameName = parcel.readString();
        this.aru = parcel.readString();
        this.arv = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.arw = parcel.readFloat();
        this.arx = parcel.readString();
        this.ary = parcel.readString();
        this.arz = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.art);
        parcel.writeString(this.gameName);
        parcel.writeString(this.aru);
        parcel.writeFloat(this.arv);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.arw);
        parcel.writeString(this.arx);
        parcel.writeString(this.ary);
        parcel.writeString(this.arz);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.art = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.aru = jSONObject.optString("barDescribe");
            this.arv = (float) jSONObject.optDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.arw = (float) jSONObject.optDouble("userScore");
            this.arx = jSONObject.optString("content");
            this.ary = jSONObject.optString("qrCodeUrl");
            this.arz = jSONObject.optString("headBgUrl");
        }
    }
}
