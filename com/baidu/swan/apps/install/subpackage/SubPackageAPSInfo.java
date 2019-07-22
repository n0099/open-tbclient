package com.baidu.swan.apps.install.subpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes2.dex */
public class SubPackageAPSInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SubPackageAPSInfo> CREATOR = new Parcelable.Creator<SubPackageAPSInfo>() { // from class: com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: h */
        public SubPackageAPSInfo createFromParcel(Parcel parcel) {
            return new SubPackageAPSInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cB */
        public SubPackageAPSInfo[] newArray(int i) {
            return new SubPackageAPSInfo[i];
        }
    };
    public String atF;
    public int ayK;
    public String ayL;
    public String ayM;
    public String ayN;
    public String ayO;
    public boolean ayP;
    public String mAppId;
    public String mAppVersion;
    public String mKey;
    public int mResultCode;

    public SubPackageAPSInfo() {
    }

    private SubPackageAPSInfo(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.mAppVersion = parcel.readString();
        this.mKey = parcel.readString();
        this.mResultCode = parcel.readInt();
        this.ayK = parcel.readInt();
        this.ayL = parcel.readString();
        this.ayM = parcel.readString();
        this.ayN = parcel.readString();
        this.atF = parcel.readString();
        this.ayO = parcel.readString();
        this.ayP = parcel.readInt() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeString(this.mAppVersion);
        parcel.writeString(this.mKey);
        parcel.writeInt(this.mResultCode);
        parcel.writeInt(this.ayK);
        parcel.writeString(this.ayL);
        parcel.writeString(this.ayM);
        parcel.writeString(this.ayN);
        parcel.writeString(this.atF);
        parcel.writeString(this.ayO);
        parcel.writeInt(this.ayP ? 1 : 0);
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mAppVersion:" + this.mAppVersion + ",mKey:" + this.mKey + ",mResultCode:" + this.mResultCode + ",mSwanAppProcessId:" + this.ayK + ",mAppRootPath:" + this.ayL + ",mSubPackageName:" + this.ayM + ",mZipPath:" + this.ayN + ",mWebViewId:" + this.atF + ",mCallbackKey:" + this.ayO + ",mForceDownload:" + this.ayP;
    }
}
