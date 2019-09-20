package com.baidu.swan.games.subpackage.aps;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes2.dex */
public class SwanGameSubPackageAPSInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanGameSubPackageAPSInfo> CREATOR = new Parcelable.Creator<SwanGameSubPackageAPSInfo>() { // from class: com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: o */
        public SwanGameSubPackageAPSInfo createFromParcel(Parcel parcel) {
            return new SwanGameSubPackageAPSInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fh */
        public SwanGameSubPackageAPSInfo[] newArray(int i) {
            return new SwanGameSubPackageAPSInfo[i];
        }
    };
    public String appId;
    public String appVersion;
    public int blS;
    public String blT;
    public String blU;
    public String blV;
    public String blW;
    public String blX;
    public String key;
    public int resultCode;

    public SwanGameSubPackageAPSInfo() {
    }

    private SwanGameSubPackageAPSInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.appVersion = parcel.readString();
        this.key = parcel.readString();
        this.resultCode = parcel.readInt();
        this.blS = parcel.readInt();
        this.blT = parcel.readString();
        this.blU = parcel.readString();
        this.blV = parcel.readString();
        this.blW = parcel.readString();
        this.blX = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.key);
        parcel.writeInt(this.resultCode);
        parcel.writeInt(this.blS);
        parcel.writeString(this.blT);
        parcel.writeString(this.blU);
        parcel.writeString(this.blV);
        parcel.writeString(this.blW);
        parcel.writeString(this.blX);
    }

    public String toString() {
        return "appId:" + this.appId + ",appVersion:" + this.appVersion + ",key:" + this.key + ",resultCode:" + this.resultCode + ",swanAppProcessId:" + this.blS + ",appRootPath:" + this.blT + ",subPackageRoot:" + this.blU + ",zipPath:" + this.blV + ",callbackKey:" + this.blW + ",subPackagePath:" + this.blX;
    }
}
