package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GameShareData implements Parcelable {
    public static final Parcelable.Creator<GameShareData> CREATOR = new Parcelable.Creator<GameShareData>() { // from class: com.baidu.tbadk.core.data.GameShareData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: G */
        public GameShareData createFromParcel(Parcel parcel) {
            return new GameShareData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: hu */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String bZn;
    public String bZo;
    public float bZp;
    public float bZq;
    public String bZr;
    public String bZs;
    public String bZt;
    public String gameName;
    public String userName;
    public String userPortrait;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.bZn = parcel.readString();
        this.gameName = parcel.readString();
        this.bZo = parcel.readString();
        this.bZp = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.bZq = parcel.readFloat();
        this.bZr = parcel.readString();
        this.bZs = parcel.readString();
        this.bZt = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bZn);
        parcel.writeString(this.gameName);
        parcel.writeString(this.bZo);
        parcel.writeFloat(this.bZp);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.bZq);
        parcel.writeString(this.bZr);
        parcel.writeString(this.bZs);
        parcel.writeString(this.bZt);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bZn = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.bZo = jSONObject.optString("barDescribe");
            this.bZp = (float) jSONObject.optDouble("score");
            this.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
            this.userPortrait = jSONObject.optString("avastar");
            this.bZq = (float) jSONObject.optDouble("userScore");
            this.bZr = jSONObject.optString("content");
            this.bZs = jSONObject.optString("qrCodeUrl");
            this.bZt = jSONObject.optString("headBgUrl");
        }
    }
}
