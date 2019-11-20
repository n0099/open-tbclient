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
        /* renamed from: gb */
        public SwanGameSubPackageAPSInfo[] newArray(int i) {
            return new SwanGameSubPackageAPSInfo[i];
        }
    };
    public String appId;
    public String avI;
    public int bDP;
    public String bDQ;
    public String bDR;
    public String bDS;
    public String bDT;
    public String callbackKey;
    public String key;
    public int resultCode;

    public SwanGameSubPackageAPSInfo() {
    }

    private SwanGameSubPackageAPSInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.avI = parcel.readString();
        this.key = parcel.readString();
        this.resultCode = parcel.readInt();
        this.bDP = parcel.readInt();
        this.bDQ = parcel.readString();
        this.bDR = parcel.readString();
        this.bDS = parcel.readString();
        this.callbackKey = parcel.readString();
        this.bDT = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.avI);
        parcel.writeString(this.key);
        parcel.writeInt(this.resultCode);
        parcel.writeInt(this.bDP);
        parcel.writeString(this.bDQ);
        parcel.writeString(this.bDR);
        parcel.writeString(this.bDS);
        parcel.writeString(this.callbackKey);
        parcel.writeString(this.bDT);
    }

    public String toString() {
        return "appId:" + this.appId + ",appVersion:" + this.avI + ",key:" + this.key + ",resultCode:" + this.resultCode + ",swanAppProcessId:" + this.bDP + ",appRootPath:" + this.bDQ + ",subPackageRoot:" + this.bDR + ",zipPath:" + this.bDS + ",callbackKey:" + this.callbackKey + ",subPackagePath:" + this.bDT;
    }
}
