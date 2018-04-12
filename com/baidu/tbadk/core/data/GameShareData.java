package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GameShareData implements Parcelable {
    public static final Parcelable.Creator<GameShareData> CREATOR = new Parcelable.Creator<GameShareData>() { // from class: com.baidu.tbadk.core.data.GameShareData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: d */
        public GameShareData createFromParcel(Parcel parcel) {
            return new GameShareData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: bB */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String XY;
    public String XZ;
    public float Ya;
    public float Yb;
    public String Yc;
    public String Yd;
    public String Ye;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.XY = parcel.readString();
        this.gameName = parcel.readString();
        this.XZ = parcel.readString();
        this.Ya = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.Yb = parcel.readFloat();
        this.Yc = parcel.readString();
        this.Yd = parcel.readString();
        this.Ye = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.XY);
        parcel.writeString(this.gameName);
        parcel.writeString(this.XZ);
        parcel.writeFloat(this.Ya);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.Yb);
        parcel.writeString(this.Yc);
        parcel.writeString(this.Yd);
        parcel.writeString(this.Ye);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.XY = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.XZ = jSONObject.optString("barDescribe");
            this.Ya = (float) jSONObject.optDouble(WBConstants.GAME_PARAMS_SCORE);
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.Yb = (float) jSONObject.optDouble("userScore");
            this.Yc = jSONObject.optString("content");
            this.Yd = jSONObject.optString("qrCodeUrl");
            this.Ye = jSONObject.optString("headBgUrl");
        }
    }
}
