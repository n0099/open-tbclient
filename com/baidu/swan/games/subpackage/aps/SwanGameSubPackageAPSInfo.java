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
    public String bfB;
    public int bfw;
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
        this.bfw = parcel.readInt();
        this.bfx = parcel.readString();
        this.bfy = parcel.readString();
        this.bfz = parcel.readString();
        this.bfA = parcel.readString();
        this.bfB = parcel.readString();
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
        parcel.writeInt(this.bfw);
        parcel.writeString(this.bfx);
        parcel.writeString(this.bfy);
        parcel.writeString(this.bfz);
        parcel.writeString(this.bfA);
        parcel.writeString(this.bfB);
    }

    public String toString() {
        return "appId:" + this.appId + ",appVersion:" + this.appVersion + ",key:" + this.key + ",resultCode:" + this.resultCode + ",swanAppProcessId:" + this.bfw + ",appRootPath:" + this.bfx + ",subPackageRoot:" + this.bfy + ",zipPath:" + this.bfz + ",callbackKey:" + this.bfA + ",subPackagePath:" + this.bfB;
    }
}
