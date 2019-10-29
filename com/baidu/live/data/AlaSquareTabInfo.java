package com.baidu.live.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaSquareTabInfo implements Parcelable {
    public static final Parcelable.Creator<AlaSquareTabInfo> CREATOR = new Parcelable.Creator<AlaSquareTabInfo>() { // from class: com.baidu.live.data.AlaSquareTabInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: g */
        public AlaSquareTabInfo createFromParcel(Parcel parcel) {
            return new AlaSquareTabInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aX */
        public AlaSquareTabInfo[] newArray(int i) {
            return new AlaSquareTabInfo[i];
        }
    };
    public String bitmapWHRatio;
    public int iconType;
    public String iconUrl;
    public int id;
    public String name;
    public List<String> sortTypeList;

    public AlaSquareTabInfo() {
    }

    public AlaSquareTabInfo(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.iconUrl = parcel.readString();
        this.bitmapWHRatio = parcel.readString();
        this.iconType = parcel.readInt();
        this.sortTypeList = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.bitmapWHRatio);
        parcel.writeInt(this.iconType);
        parcel.writeStringList(this.sortTypeList);
    }
}
