package com.baidu.swan.games.subpackage.aps;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes2.dex */
public class SwanGameSubPackageAPSInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanGameSubPackageAPSInfo> CREATOR = new Parcelable.Creator<SwanGameSubPackageAPSInfo>() { // from class: com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: m */
        public SwanGameSubPackageAPSInfo createFromParcel(Parcel parcel) {
            return new SwanGameSubPackageAPSInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: eI */
        public SwanGameSubPackageAPSInfo[] newArray(int i) {
            return new SwanGameSubPackageAPSInfo[i];
        }
    };
    public String appId;
    public String appVersion;
    public String bfA;
    public int bfv;
    public String bfw;
    public String bfx;
    public String bfy;
    public String bfz;
    public String key;
    public int resultCode;

    public SwanGameSubPackageAPSInfo() {
    }

    private SwanGameSubPackageAPSInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.appVersion = parcel.readString();
        this.key = parcel.readString();
        this.resultCode = parcel.readInt();
        this.bfv = parcel.readInt();
        this.bfw = parcel.readString();
        this.bfx = parcel.readString();
        this.bfy = parcel.readString();
        this.bfz = parcel.readString();
        this.bfA = parcel.readString();
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
        parcel.writeInt(this.bfv);
        parcel.writeString(this.bfw);
        parcel.writeString(this.bfx);
        parcel.writeString(this.bfy);
        parcel.writeString(this.bfz);
        parcel.writeString(this.bfA);
    }

    public String toString() {
        return "appId:" + this.appId + ",appVersion:" + this.appVersion + ",key:" + this.key + ",resultCode:" + this.resultCode + ",swanAppProcessId:" + this.bfv + ",appRootPath:" + this.bfw + ",subPackageRoot:" + this.bfx + ",zipPath:" + this.bfy + ",callbackKey:" + this.bfz + ",subPackagePath:" + this.bfA;
    }
}
