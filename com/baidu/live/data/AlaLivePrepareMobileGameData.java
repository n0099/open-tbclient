package com.baidu.live.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class AlaLivePrepareMobileGameData extends com.baidu.live.tieba.b.a.a implements Parcelable {
    public static final String ARG_GAME_DATA = "arg_game_data";
    public static final Parcelable.Creator<AlaLivePrepareMobileGameData> CREATOR = new Parcelable.Creator<AlaLivePrepareMobileGameData>() { // from class: com.baidu.live.data.AlaLivePrepareMobileGameData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: f */
        public AlaLivePrepareMobileGameData createFromParcel(Parcel parcel) {
            return new AlaLivePrepareMobileGameData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: bh */
        public AlaLivePrepareMobileGameData[] newArray(int i) {
            return new AlaLivePrepareMobileGameData[i];
        }
    };
    private static final String SUPPORT_SCREEN_RECORD_FALSE = "0";
    private static final String SUPPORT_SCREEN_RECORD_TRUE = "1";
    public String callPathAndroid;
    public String gameIcon;
    public String gameId;
    public String gameLabel;
    public boolean gameSupportScreenRecord;
    public int screenDirection;

    public AlaLivePrepareMobileGameData() {
    }

    protected AlaLivePrepareMobileGameData(Parcel parcel) {
        this.gameId = parcel.readString();
        this.gameLabel = parcel.readString();
        this.gameIcon = parcel.readString();
        this.callPathAndroid = parcel.readString();
        this.screenDirection = parcel.readInt();
        this.gameSupportScreenRecord = "1".equals(parcel.readString());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.gameId);
        parcel.writeString(this.gameLabel);
        parcel.writeString(this.gameIcon);
        parcel.writeString(this.callPathAndroid);
        parcel.writeInt(this.screenDirection);
        parcel.writeString(this.gameSupportScreenRecord ? "1" : "0");
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return null;
    }
}
