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
        /* renamed from: bD */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String agq;
    public String agr;
    public float ags;
    public float agt;
    public String agu;
    public String agv;
    public String agw;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.agq = parcel.readString();
        this.gameName = parcel.readString();
        this.agr = parcel.readString();
        this.ags = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.agt = parcel.readFloat();
        this.agu = parcel.readString();
        this.agv = parcel.readString();
        this.agw = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.agq);
        parcel.writeString(this.gameName);
        parcel.writeString(this.agr);
        parcel.writeFloat(this.ags);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.agt);
        parcel.writeString(this.agu);
        parcel.writeString(this.agv);
        parcel.writeString(this.agw);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.agq = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.agr = jSONObject.optString("barDescribe");
            this.ags = (float) jSONObject.optDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.agt = (float) jSONObject.optDouble("userScore");
            this.agu = jSONObject.optString("content");
            this.agv = jSONObject.optString("qrCodeUrl");
            this.agw = jSONObject.optString("headBgUrl");
        }
    }
}
