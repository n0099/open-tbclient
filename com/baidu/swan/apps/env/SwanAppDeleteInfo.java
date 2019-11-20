package com.baidu.swan.apps.env;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes2.dex */
public class SwanAppDeleteInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppDeleteInfo> CREATOR = new Parcelable.Creator<SwanAppDeleteInfo>() { // from class: com.baidu.swan.apps.env.SwanAppDeleteInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: m */
        public SwanAppDeleteInfo createFromParcel(Parcel parcel) {
            return new SwanAppDeleteInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: dp */
        public SwanAppDeleteInfo[] newArray(int i) {
            return new SwanAppDeleteInfo[i];
        }
    };
    public int aPu;
    public String mAppId;

    public SwanAppDeleteInfo(String str) {
        this.mAppId = str;
        this.aPu = 0;
    }

    public SwanAppDeleteInfo(String str, int i) {
        this.mAppId = str;
        this.aPu = i;
    }

    private SwanAppDeleteInfo(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.aPu = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.aPu);
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mCheckHisAndFavor:" + this.aPu;
    }
}
