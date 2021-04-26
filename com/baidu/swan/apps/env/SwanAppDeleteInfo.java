package com.baidu.swan.apps.env;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes2.dex */
public class SwanAppDeleteInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppDeleteInfo> CREATOR = new a();
    public static final int HIS_FAVOR_CHECK = 0;
    public static final int HIS_FAVOR_IGNORE = 1;
    public String mAppId;
    public int mCheckHisAndFavor;
    public int mPurgerScenes;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<SwanAppDeleteInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwanAppDeleteInfo createFromParcel(Parcel parcel) {
            return new SwanAppDeleteInfo(parcel, (a) null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanAppDeleteInfo[] newArray(int i2) {
            return new SwanAppDeleteInfo[i2];
        }
    }

    public /* synthetic */ SwanAppDeleteInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int a() {
        return this.mPurgerScenes;
    }

    public SwanAppDeleteInfo b(int i2) {
        this.mPurgerScenes = i2;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mCheckHisAndFavor:" + this.mCheckHisAndFavor + ",mPurgerScenes:" + this.mPurgerScenes;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.mCheckHisAndFavor);
        parcel.writeInt(this.mPurgerScenes);
    }

    public SwanAppDeleteInfo(String str) {
        this.mPurgerScenes = 0;
        this.mAppId = str;
        this.mCheckHisAndFavor = 0;
    }

    public SwanAppDeleteInfo(String str, int i2) {
        this.mPurgerScenes = 0;
        this.mAppId = str;
        this.mCheckHisAndFavor = i2;
    }

    public SwanAppDeleteInfo(Parcel parcel) {
        this.mPurgerScenes = 0;
        this.mAppId = parcel.readString();
        this.mCheckHisAndFavor = parcel.readInt();
        this.mPurgerScenes = parcel.readInt();
    }
}
