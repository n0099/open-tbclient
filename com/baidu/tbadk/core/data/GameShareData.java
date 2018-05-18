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
        /* renamed from: e */
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
    public String XZ;
    public String Ya;
    public float Yb;
    public float Yc;
    public String Yd;
    public String Ye;
    public String Yf;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.XZ = parcel.readString();
        this.gameName = parcel.readString();
        this.Ya = parcel.readString();
        this.Yb = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.Yc = parcel.readFloat();
        this.Yd = parcel.readString();
        this.Ye = parcel.readString();
        this.Yf = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.XZ);
        parcel.writeString(this.gameName);
        parcel.writeString(this.Ya);
        parcel.writeFloat(this.Yb);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.Yc);
        parcel.writeString(this.Yd);
        parcel.writeString(this.Ye);
        parcel.writeString(this.Yf);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.XZ = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.Ya = jSONObject.optString("barDescribe");
            this.Yb = (float) jSONObject.optDouble(WBConstants.GAME_PARAMS_SCORE);
            this.userName = jSONObject.optString("userName");
            this.userPortrait = jSONObject.optString("avastar");
            this.Yc = (float) jSONObject.optDouble("userScore");
            this.Yd = jSONObject.optString("content");
            this.Ye = jSONObject.optString("qrCodeUrl");
            this.Yf = jSONObject.optString("headBgUrl");
        }
    }
}
