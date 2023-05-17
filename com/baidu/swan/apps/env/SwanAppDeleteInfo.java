package com.baidu.swan.apps.env;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes4.dex */
public class SwanAppDeleteInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppDeleteInfo> CREATOR = new a();
    public static final int HIS_FAVOR_CHECK = 0;
    public static final int HIS_FAVOR_IGNORE = 1;
    public String mAppId;
    public int mCheckHisAndFavor;
    public int mPurgerScenes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPurgerScenes() {
        return this.mPurgerScenes;
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mCheckHisAndFavor:" + this.mCheckHisAndFavor + ",mPurgerScenes:" + this.mPurgerScenes;
    }

    /* loaded from: classes4.dex */
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
        public SwanAppDeleteInfo[] newArray(int i) {
            return new SwanAppDeleteInfo[i];
        }
    }

    public SwanAppDeleteInfo(Parcel parcel) {
        this.mPurgerScenes = 0;
        this.mAppId = parcel.readString();
        this.mCheckHisAndFavor = parcel.readInt();
        this.mPurgerScenes = parcel.readInt();
    }

    public SwanAppDeleteInfo setPurgerScenes(int i) {
        this.mPurgerScenes = i;
        return this;
    }

    public /* synthetic */ SwanAppDeleteInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.mCheckHisAndFavor);
        parcel.writeInt(this.mPurgerScenes);
    }

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
}
