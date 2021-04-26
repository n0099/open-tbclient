package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.util.TbEnum;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GameShareData implements Parcelable {
    public static final Parcelable.Creator<GameShareData> CREATOR = new a();
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

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<GameShareData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GameShareData createFromParcel(Parcel parcel) {
            return new GameShareData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GameShareData[] newArray(int i2) {
            return new GameShareData[i2];
        }
    }

    public GameShareData() {
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.gameIconUrl = jSONObject.optString("barIconUrl");
        this.gameName = jSONObject.optString("barName");
        this.gameDescription = jSONObject.optString("barDescribe");
        this.gameScore = (float) jSONObject.optDouble("score");
        this.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
        this.userPortrait = jSONObject.optString("avastar");
        this.userScore = (float) jSONObject.optDouble("userScore");
        this.gameComment = jSONObject.optString("content");
        this.shareQRCodeUrl = jSONObject.optString("qrCodeUrl");
        this.headBgUrl = jSONObject.optString("headBgUrl");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
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

    public GameShareData(Parcel parcel) {
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
}
