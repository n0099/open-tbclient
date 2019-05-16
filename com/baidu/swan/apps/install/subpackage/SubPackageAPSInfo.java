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
    public String atc;
    public int ayd;
    public String aye;
    public String ayf;
    public String ayg;
    public String ayh;
    public boolean ayi;
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
        this.ayd = parcel.readInt();
        this.aye = parcel.readString();
        this.ayf = parcel.readString();
        this.ayg = parcel.readString();
        this.atc = parcel.readString();
        this.ayh = parcel.readString();
        this.ayi = parcel.readInt() == 1;
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
        parcel.writeInt(this.ayd);
        parcel.writeString(this.aye);
        parcel.writeString(this.ayf);
        parcel.writeString(this.ayg);
        parcel.writeString(this.atc);
        parcel.writeString(this.ayh);
        parcel.writeInt(this.ayi ? 1 : 0);
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mAppVersion:" + this.mAppVersion + ",mKey:" + this.mKey + ",mResultCode:" + this.mResultCode + ",mSwanAppProcessId:" + this.ayd + ",mAppRootPath:" + this.aye + ",mSubPackageName:" + this.ayf + ",mZipPath:" + this.ayg + ",mWebViewId:" + this.atc + ",mCallbackKey:" + this.ayh + ",mForceDownload:" + this.ayi;
    }
}
