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
        /* renamed from: cA */
        public SubPackageAPSInfo[] newArray(int i) {
            return new SubPackageAPSInfo[i];
        }
    };
    public String asO;
    public int axq;
    public String axr;
    public String axs;
    public String axt;
    public String axu;
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
        this.axq = parcel.readInt();
        this.axr = parcel.readString();
        this.axs = parcel.readString();
        this.axt = parcel.readString();
        this.asO = parcel.readString();
        this.axu = parcel.readString();
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
        parcel.writeInt(this.axq);
        parcel.writeString(this.axr);
        parcel.writeString(this.axs);
        parcel.writeString(this.axt);
        parcel.writeString(this.asO);
        parcel.writeString(this.axu);
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mAppVersion:" + this.mAppVersion + ",mKey:" + this.mKey + ",mResultCode:" + this.mResultCode + ",mSwanAppProcessId:" + this.axq + ",mAppRootPath:" + this.axr + ",mSubPackageName:" + this.axs + ",mZipPath:" + this.axt + ",mWebViewId:" + this.asO + ",mCallbackKey:" + this.axu;
    }
}
