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
    public String arV;
    public String arW;
    public float arX;
    public float arY;
    public String arZ;
    public String asa;
    public String asb;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.arV = parcel.readString();
        this.gameName = parcel.readString();
        this.arW = parcel.readString();
        this.arX = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.arY = parcel.readFloat();
        this.arZ = parcel.readString();
        this.asa = parcel.readString();
        this.asb = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.arV);
        parcel.writeString(this.gameName);
        parcel.writeString(this.arW);
        parcel.writeFloat(this.arX);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.arY);
        parcel.writeString(this.arZ);
        parcel.writeString(this.asa);
        parcel.writeString(this.asb);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.arV = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.arW = jSONObject.optString("barDescribe");
            this.arX = (float) jSONObject.optDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.arY = (float) jSONObject.optDouble("userScore");
            this.arZ = jSONObject.optString("content");
            this.asa = jSONObject.optString("qrCodeUrl");
            this.asb = jSONObject.optString("headBgUrl");
        }
    }
}
