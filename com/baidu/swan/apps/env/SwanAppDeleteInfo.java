package com.baidu.swan.apps.env;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes9.dex */
public class SwanAppDeleteInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppDeleteInfo> CREATOR = new Parcelable.Creator<SwanAppDeleteInfo>() { // from class: com.baidu.swan.apps.env.SwanAppDeleteInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: r */
        public SwanAppDeleteInfo createFromParcel(Parcel parcel) {
            return new SwanAppDeleteInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: hg */
        public SwanAppDeleteInfo[] newArray(int i) {
            return new SwanAppDeleteInfo[i];
        }
    };
    public static final int HIS_FAVOR_CHECK = 0;
    public static final int HIS_FAVOR_IGNORE = 1;
    public String mAppId;
    public int mCheckHisAndFavor;
    private int mPurgerScenes;

    public SwanAppDeleteInfo(String str) {
        this.mPurgerScenes = 0;
        this.mAppId = str;
        this.mCheckHisAndFavor = 0;
    }

    public SwanAppDeleteInfo(String str, int i) {
        this.mPurgerScenes = 0;
        this.mAppId = str;
        this.mCheckHisAndFavor = i;
    }

    private SwanAppDeleteInfo(Parcel parcel) {
        this.mPurgerScenes = 0;
        this.mAppId = parcel.readString();
        this.mCheckHisAndFavor = parcel.readInt();
        this.mPurgerScenes = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.mCheckHisAndFavor);
        parcel.writeInt(this.mPurgerScenes);
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mCheckHisAndFavor:" + this.mCheckHisAndFavor + ",mPurgerScenes:" + this.mPurgerScenes;
    }

    public SwanAppDeleteInfo hf(int i) {
        this.mPurgerScenes = i;
        return this;
    }

    public int atE() {
        return this.mPurgerScenes;
    }
}
