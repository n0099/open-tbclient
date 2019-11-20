package com.baidu.live.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes6.dex */
public class AlaGameEntryData implements Parcelable, IAdapterData {
    public int Or;
    public String Os;
    public String icon;
    public int id;
    public String name;
    public static final BdUniqueId Oq = BdUniqueId.gen();
    public static final Parcelable.Creator<AlaGameEntryData> CREATOR = new Parcelable.Creator<AlaGameEntryData>() { // from class: com.baidu.live.data.AlaGameEntryData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: e */
        public AlaGameEntryData createFromParcel(Parcel parcel) {
            return new AlaGameEntryData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aV */
        public AlaGameEntryData[] newArray(int i) {
            return new AlaGameEntryData[i];
        }
    };

    private AlaGameEntryData(Parcel parcel) {
        this.id = parcel.readInt();
        this.icon = parcel.readString();
        this.name = parcel.readString();
        this.Or = parcel.readInt();
        this.Os = parcel.readString();
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return Oq;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 31047;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.icon);
        parcel.writeString(this.name);
        parcel.writeInt(this.Or);
        parcel.writeString(this.Os);
    }
}
