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
        /* renamed from: bZ */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String anf;
    public String ang;
    public float anh;
    public float ani;
    public String anj;
    public String ank;
    public String anl;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.anf = parcel.readString();
        this.gameName = parcel.readString();
        this.ang = parcel.readString();
        this.anh = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.ani = parcel.readFloat();
        this.anj = parcel.readString();
        this.ank = parcel.readString();
        this.anl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.anf);
        parcel.writeString(this.gameName);
        parcel.writeString(this.ang);
        parcel.writeFloat(this.anh);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.ani);
        parcel.writeString(this.anj);
        parcel.writeString(this.ank);
        parcel.writeString(this.anl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anf = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.ang = jSONObject.optString("barDescribe");
            this.anh = (float) jSONObject.optDouble(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.ani = (float) jSONObject.optDouble("userScore");
            this.anj = jSONObject.optString("content");
            this.ank = jSONObject.optString("qrCodeUrl");
            this.anl = jSONObject.optString("headBgUrl");
        }
    }
}
