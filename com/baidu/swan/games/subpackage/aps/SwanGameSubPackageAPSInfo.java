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
        /* renamed from: fg */
        public SwanGameSubPackageAPSInfo[] newArray(int i) {
            return new SwanGameSubPackageAPSInfo[i];
        }
    };
    public String appId;
    public String appVersion;
    public int blu;
    public String blv;
    public String blw;
    public String blx;
    public String bly;
    public String blz;
    public String key;
    public int resultCode;

    public SwanGameSubPackageAPSInfo() {
    }

    private SwanGameSubPackageAPSInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.appVersion = parcel.readString();
        this.key = parcel.readString();
        this.resultCode = parcel.readInt();
        this.blu = parcel.readInt();
        this.blv = parcel.readString();
        this.blw = parcel.readString();
        this.blx = parcel.readString();
        this.bly = parcel.readString();
        this.blz = parcel.readString();
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
        parcel.writeInt(this.blu);
        parcel.writeString(this.blv);
        parcel.writeString(this.blw);
        parcel.writeString(this.blx);
        parcel.writeString(this.bly);
        parcel.writeString(this.blz);
    }

    public String toString() {
        return "appId:" + this.appId + ",appVersion:" + this.appVersion + ",key:" + this.key + ",resultCode:" + this.resultCode + ",swanAppProcessId:" + this.blu + ",appRootPath:" + this.blv + ",subPackageRoot:" + this.blw + ",zipPath:" + this.blx + ",callbackKey:" + this.bly + ",subPackagePath:" + this.blz;
    }
}
