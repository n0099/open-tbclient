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
        /* renamed from: eJ */
        public SwanGameSubPackageAPSInfo[] newArray(int i) {
            return new SwanGameSubPackageAPSInfo[i];
        }
    };
    public String appId;
    public String appVersion;
    public int bfs;
    public String bft;
    public String bfu;
    public String bfv;
    public String bfw;
    public String bfx;
    public String key;
    public int resultCode;

    public SwanGameSubPackageAPSInfo() {
    }

    private SwanGameSubPackageAPSInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.appVersion = parcel.readString();
        this.key = parcel.readString();
        this.resultCode = parcel.readInt();
        this.bfs = parcel.readInt();
        this.bft = parcel.readString();
        this.bfu = parcel.readString();
        this.bfv = parcel.readString();
        this.bfw = parcel.readString();
        this.bfx = parcel.readString();
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
        parcel.writeInt(this.bfs);
        parcel.writeString(this.bft);
        parcel.writeString(this.bfu);
        parcel.writeString(this.bfv);
        parcel.writeString(this.bfw);
        parcel.writeString(this.bfx);
    }

    public String toString() {
        return "appId:" + this.appId + ",appVersion:" + this.appVersion + ",key:" + this.key + ",resultCode:" + this.resultCode + ",swanAppProcessId:" + this.bfs + ",appRootPath:" + this.bft + ",subPackageRoot:" + this.bfu + ",zipPath:" + this.bfv + ",callbackKey:" + this.bfw + ",subPackagePath:" + this.bfx;
    }
}
