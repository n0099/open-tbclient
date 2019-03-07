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
    public String asI;
    public int axl;
    public String axm;
    public String axn;
    public String axo;
    public String axp;
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
        this.axl = parcel.readInt();
        this.axm = parcel.readString();
        this.axn = parcel.readString();
        this.axo = parcel.readString();
        this.asI = parcel.readString();
        this.axp = parcel.readString();
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
        parcel.writeInt(this.axl);
        parcel.writeString(this.axm);
        parcel.writeString(this.axn);
        parcel.writeString(this.axo);
        parcel.writeString(this.asI);
        parcel.writeString(this.axp);
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mAppVersion:" + this.mAppVersion + ",mKey:" + this.mKey + ",mResultCode:" + this.mResultCode + ",mSwanAppProcessId:" + this.axl + ",mAppRootPath:" + this.axm + ",mSubPackageName:" + this.axn + ",mZipPath:" + this.axo + ",mWebViewId:" + this.asI + ",mCallbackKey:" + this.axp;
    }
}
