package com.baidu.live.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class AlaLivePrepareMobileGameData extends com.baidu.live.tieba.b.a.a implements Parcelable {
    public static final Parcelable.Creator<AlaLivePrepareMobileGameData> CREATOR = new Parcelable.Creator<AlaLivePrepareMobileGameData>() { // from class: com.baidu.live.data.AlaLivePrepareMobileGameData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: f */
        public AlaLivePrepareMobileGameData createFromParcel(Parcel parcel) {
            return new AlaLivePrepareMobileGameData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aW */
        public AlaLivePrepareMobileGameData[] newArray(int i) {
            return new AlaLivePrepareMobileGameData[i];
        }
    };
    public String OZ;
    public String Pa;
    public String Pb;
    public boolean Pc;
    public String gameId;
    public int screenDirection;

    public AlaLivePrepareMobileGameData() {
    }

    protected AlaLivePrepareMobileGameData(Parcel parcel) {
        this.gameId = parcel.readString();
        this.OZ = parcel.readString();
        this.Pa = parcel.readString();
        this.Pb = parcel.readString();
        this.screenDirection = parcel.readInt();
        this.Pc = "1".equals(parcel.readString());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.gameId);
        parcel.writeString(this.OZ);
        parcel.writeString(this.Pa);
        parcel.writeString(this.Pb);
        parcel.writeInt(this.screenDirection);
        parcel.writeString(this.Pc ? "1" : "0");
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return null;
    }
}
