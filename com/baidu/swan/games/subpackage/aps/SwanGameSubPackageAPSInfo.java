package com.baidu.swan.games.subpackage.aps;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes2.dex */
public class SwanGameSubPackageAPSInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanGameSubPackageAPSInfo> CREATOR = new Parcelable.Creator<SwanGameSubPackageAPSInfo>() { // from class: com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: w */
        public SwanGameSubPackageAPSInfo createFromParcel(Parcel parcel) {
            return new SwanGameSubPackageAPSInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gc */
        public SwanGameSubPackageAPSInfo[] newArray(int i) {
            return new SwanGameSubPackageAPSInfo[i];
        }
    };
    public String appId;
    public String awa;
    public int bEG;
    public String bEH;
    public String bEI;
    public String bEJ;
    public String bEK;
    public String callbackKey;
    public String key;
    public int resultCode;

    public SwanGameSubPackageAPSInfo() {
    }

    private SwanGameSubPackageAPSInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.awa = parcel.readString();
        this.key = parcel.readString();
        this.resultCode = parcel.readInt();
        this.bEG = parcel.readInt();
        this.bEH = parcel.readString();
        this.bEI = parcel.readString();
        this.bEJ = parcel.readString();
        this.callbackKey = parcel.readString();
        this.bEK = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.awa);
        parcel.writeString(this.key);
        parcel.writeInt(this.resultCode);
        parcel.writeInt(this.bEG);
        parcel.writeString(this.bEH);
        parcel.writeString(this.bEI);
        parcel.writeString(this.bEJ);
        parcel.writeString(this.callbackKey);
        parcel.writeString(this.bEK);
    }

    public String toString() {
        return "appId:" + this.appId + ",appVersion:" + this.awa + ",key:" + this.key + ",resultCode:" + this.resultCode + ",swanAppProcessId:" + this.bEG + ",appRootPath:" + this.bEH + ",subPackageRoot:" + this.bEI + ",zipPath:" + this.bEJ + ",callbackKey:" + this.callbackKey + ",subPackagePath:" + this.bEK;
    }
}
