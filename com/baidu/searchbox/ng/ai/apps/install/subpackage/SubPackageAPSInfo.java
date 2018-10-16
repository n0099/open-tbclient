package com.baidu.searchbox.ng.ai.apps.install.subpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsIPCData;
/* loaded from: classes2.dex */
public class SubPackageAPSInfo extends AiAppsIPCData {
    public static final Parcelable.Creator<SubPackageAPSInfo> CREATOR = new Parcelable.Creator<SubPackageAPSInfo>() { // from class: com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubPackageAPSInfo createFromParcel(Parcel parcel) {
            return new SubPackageAPSInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubPackageAPSInfo[] newArray(int i) {
            return new SubPackageAPSInfo[i];
        }
    };
    public static final int RESULT_APS_DOWNLOAD_ERROR = 2103;
    public static final int RESULT_APS_INFO_FAILED = 2101;
    public static final int RESULT_APS_NO_PACKAGE = 2102;
    public static final int RESULT_CODE_SUCCESS = 2100;
    public static final int RESULT_ZIP_CHECK_SIGN_ERROR = 2104;
    public static final int RESULT_ZIP_UNZIP_ERROR = 2105;
    public int mAiAppProcessId;
    public String mAppId;
    public String mAppRootPath;
    public String mAppVersion;
    public String mCallbackKey;
    public String mKey;
    public int mResultCode;
    public String mSubPackageName;
    public String mWebViewId;
    public String mZipPath;

    public SubPackageAPSInfo() {
    }

    private SubPackageAPSInfo(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.mAppVersion = parcel.readString();
        this.mKey = parcel.readString();
        this.mResultCode = parcel.readInt();
        this.mAiAppProcessId = parcel.readInt();
        this.mAppRootPath = parcel.readString();
        this.mSubPackageName = parcel.readString();
        this.mZipPath = parcel.readString();
        this.mWebViewId = parcel.readString();
        this.mCallbackKey = parcel.readString();
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
        parcel.writeInt(this.mAiAppProcessId);
        parcel.writeString(this.mAppRootPath);
        parcel.writeString(this.mSubPackageName);
        parcel.writeString(this.mZipPath);
        parcel.writeString(this.mWebViewId);
        parcel.writeString(this.mCallbackKey);
    }

    public String toString() {
        return "mAppId:" + this.mAppId + ",mAppVersion:" + this.mAppVersion + ",mKey:" + this.mKey + ",mResultCode:" + this.mResultCode + ",mAiAppProcessId:" + this.mAiAppProcessId + ",mAppRootPath:" + this.mAppRootPath + ",mSubPackageName:" + this.mSubPackageName + ",mZipPath:" + this.mZipPath + ",mWebViewId:" + this.mWebViewId + ",mCallbackKey:" + this.mCallbackKey;
    }
}
