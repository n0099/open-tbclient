package com.baidu.live.business.view.banner;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.live.business.model.data.LiveBannerEntity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BannerEntity implements Parcelable {
    public static final Parcelable.Creator<BannerEntity> CREATOR = new a();
    public String bannerId;
    public List<LiveBannerEntity> mBannerList;
    public double mBannerWH;
    public int mBroadcastInterval;
    public String mLogExt;
    public int mSelected;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BannerEntity() {
        this.mSelected = 0;
        this.mBannerList = new ArrayList();
        this.mBroadcastInterval = 1000;
    }

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<BannerEntity> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BannerEntity createFromParcel(Parcel parcel) {
            return new BannerEntity(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BannerEntity[] newArray(int i) {
            return new BannerEntity[i];
        }
    }

    public BannerEntity(Parcel parcel) {
        this.mSelected = 0;
        this.mBannerList = new ArrayList();
        this.mBroadcastInterval = 1000;
        this.mSelected = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.mBannerList = arrayList;
        parcel.readList(arrayList, LiveBannerEntity.class.getClassLoader());
        this.mBroadcastInterval = parcel.readInt();
        this.mLogExt = parcel.readString();
        this.bannerId = parcel.readString();
        this.mBannerWH = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSelected);
        parcel.writeList(this.mBannerList);
        parcel.writeInt(this.mBroadcastInterval);
        parcel.writeString(this.mLogExt);
        parcel.writeString(this.bannerId);
        parcel.writeDouble(this.mBannerWH);
    }
}
