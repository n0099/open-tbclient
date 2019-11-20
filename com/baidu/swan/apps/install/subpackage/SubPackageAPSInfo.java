package com.baidu.swan.apps.install.subpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes2.dex */
public class SubPackageAPSInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SubPackageAPSInfo> CREATOR = new Parcelable.Creator<SubPackageAPSInfo>() { // from class: com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: p */
        public SubPackageAPSInfo createFromParcel(Parcel parcel) {
            return new SubPackageAPSInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: dx */
        public SubPackageAPSInfo[] newArray(int i) {
            return new SubPackageAPSInfo[i];
        }
    };
    public String aNc;
    public int aSg;
    public String aSh;
    public String aSi;
    public String aSj;
    public boolean aSk;
    public String mAppId;
    public String mAppVersion;
    public String mCallbackKey;
    public String mKey;
    public int mResultCode;

    public SubPackageAPSInfo() {
    }

    private SubPackageAPSInfo(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.mAppVersion = parcel.readString();
        this.mKey = parcel.readString();
        this.mResultCode = parcel.readInt();
        this.aSg = parcel.readInt();
        this.aSh = parcel.readString();
        this.aSi = parcel.readString();
        this.aSj = parcel.readString();
        this.aNc = parcel.readString();
        this.mCallbackKey = parcel.readString();
        this.aSk = parcel.readInt() == 1;
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
        parcel.writeInt(this.aSg);
        parcel.writeString(this.aSh);
        parcel.writeString(this.aSi);
        parcel.writeString(this.aSj);
        parcel.writeString(this.aNc);
        parcel.writeString(this.mCallbackKey);
        parcel.writeInt(this.aSk ? 1 : 0);
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mAppVersion:" + this.mAppVersion + ",mKey:" + this.mKey + ",mResultCode:" + this.mResultCode + ",mSwanAppProcessId:" + this.aSg + ",mAppRootPath:" + this.aSh + ",mSubPackageName:" + this.aSi + ",mZipPath:" + this.aSj + ",mWebViewId:" + this.aNc + ",mCallbackKey:" + this.mCallbackKey + ",mForceDownload:" + this.aSk;
    }
}
