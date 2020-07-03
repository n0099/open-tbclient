package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GameShareData implements Parcelable {
    public static final Parcelable.Creator<GameShareData> CREATOR = new Parcelable.Creator<GameShareData>() { // from class: com.baidu.tbadk.core.data.GameShareData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: J */
        public GameShareData createFromParcel(Parcel parcel) {
            return new GameShareData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: kr */
        public GameShareData[] newArray(int i) {
            return new GameShareData[i];
        }
    };
    public String gameComment;
    public String gameDescription;
    public String gameIconUrl;
    public String gameName;
    public float gameScore;
    public String headBgUrl;
    public String shareQRCodeUrl;
    public String userName;
    public String userPortrait;
    public float userScore;

    public GameShareData() {
    }

    protected GameShareData(Parcel parcel) {
        this.gameIconUrl = parcel.readString();
        this.gameName = parcel.readString();
        this.gameDescription = parcel.readString();
        this.gameScore = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.userScore = parcel.readFloat();
        this.gameComment = parcel.readString();
        this.shareQRCodeUrl = parcel.readString();
        this.headBgUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.gameIconUrl);
        parcel.writeString(this.gameName);
        parcel.writeString(this.gameDescription);
        parcel.writeFloat(this.gameScore);
        parcel.writeString(this.userName);
        parcel.writeString(this.userPortrait);
        parcel.writeFloat(this.userScore);
        parcel.writeString(this.gameComment);
        parcel.writeString(this.shareQRCodeUrl);
        parcel.writeString(this.headBgUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gameIconUrl = jSONObject.optString("barIconUrl");
            this.gameName = jSONObject.optString("barName");
            this.gameDescription = jSONObject.optString("barDescribe");
            this.gameScore = (float) jSONObject.optDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            this.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
            this.userPortrait = jSONObject.optString("avastar");
            this.userScore = (float) jSONObject.optDouble("userScore");
            this.gameComment = jSONObject.optString("content");
            this.shareQRCodeUrl = jSONObject.optString("qrCodeUrl");
            this.headBgUrl = jSONObject.optString("headBgUrl");
        }
    }
}
