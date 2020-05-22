package com.baidu.swan.pms.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public class PMSAppInfo implements Parcelable {
    public static final Parcelable.Creator<PMSAppInfo> CREATOR = new Parcelable.Creator<PMSAppInfo>() { // from class: com.baidu.swan.pms.model.PMSAppInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: B */
        public PMSAppInfo createFromParcel(Parcel parcel) {
            return new PMSAppInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: jb */
        public PMSAppInfo[] newArray(int i) {
            return new PMSAppInfo[i];
        }
    };
    private static final long DEFAULT_SWAN_APP_PKG_MAX_AGE = 432000;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 0;
    public static final int ORIENTATION_UNKNOWN = -1;
    public static final int STATUS_NO_ERROR = 0;
    public int appCategory;
    public String appId;
    public String appKey;
    public String appName;
    public long appSign;
    public int appStatus;
    public String bearInfo;
    public String brandsInfo;
    public long createTime;
    public int customerService;
    public String description;
    public String domains;
    public int globalNotice;
    public int globalPrivate;
    public String iconUrl;
    public long maxAge;
    public int orientation;
    public String paNumber;
    public int payProtected;
    public int pendingErrCode;
    public long pkgSize;
    public String pluginInfo;
    public String resumeDate;
    public String serverExt;
    public String serviceCategory;
    public String statusDesc;
    public String statusDetail;
    public String subjectInfo;
    public int type;
    public int versionCode;
    public String versionName;
    public String webAction;
    public String webViewDomains;

    public PMSAppInfo() {
        this.orientation = -1;
        this.maxAge = DEFAULT_SWAN_APP_PKG_MAX_AGE;
    }

    private PMSAppInfo(Parcel parcel) {
        this.orientation = -1;
        this.maxAge = DEFAULT_SWAN_APP_PKG_MAX_AGE;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.appSign = parcel.readLong();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.description = parcel.readString();
        this.appStatus = parcel.readInt();
        this.statusDetail = parcel.readString();
        this.statusDesc = parcel.readString();
        this.resumeDate = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appName = parcel.readString();
        this.serviceCategory = parcel.readString();
        this.subjectInfo = parcel.readString();
        this.type = parcel.readInt();
        this.pkgSize = parcel.readLong();
        this.pendingErrCode = parcel.readInt();
        this.appCategory = parcel.readInt();
        setOrientation(parcel.readInt());
        this.maxAge = parcel.readLong();
        this.createTime = parcel.readLong();
        this.webViewDomains = parcel.readString();
        this.webAction = parcel.readString();
        this.domains = parcel.readString();
        this.bearInfo = parcel.readString();
        this.serverExt = parcel.readString();
        this.payProtected = parcel.readInt();
        this.customerService = parcel.readInt();
        this.globalNotice = parcel.readInt();
        this.globalPrivate = parcel.readInt();
        this.paNumber = parcel.readString();
        this.pluginInfo = parcel.readString();
        this.brandsInfo = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeLong(this.appSign);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.description);
        parcel.writeInt(this.appStatus);
        parcel.writeString(this.statusDetail);
        parcel.writeString(this.statusDesc);
        parcel.writeString(this.resumeDate);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appName);
        parcel.writeString(this.serviceCategory);
        parcel.writeString(this.subjectInfo);
        parcel.writeInt(this.type);
        parcel.writeLong(this.pkgSize);
        parcel.writeInt(this.pendingErrCode);
        parcel.writeInt(this.appCategory);
        parcel.writeInt(getOrientation());
        parcel.writeLong(this.maxAge);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.webViewDomains);
        parcel.writeString(this.webAction);
        parcel.writeString(this.domains);
        parcel.writeString(this.bearInfo);
        parcel.writeString(this.serverExt);
        parcel.writeInt(this.payProtected);
        parcel.writeInt(this.customerService);
        parcel.writeInt(this.globalNotice);
        parcel.writeInt(this.globalPrivate);
        parcel.writeString(this.paNumber);
        parcel.writeString(this.pluginInfo);
        parcel.writeString(this.brandsInfo);
    }

    public void setOrientation(int i) {
        if (-1 < i) {
            this.orientation = i;
        }
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean aGh() {
        return this.pendingErrCode != 0;
    }

    public boolean aGi() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.maxAge;
    }

    public void h(f fVar) {
        if (fVar != null) {
            this.appId = fVar.dlx;
            this.versionCode = fVar.versionCode;
            this.versionName = fVar.versionName;
            this.type = fVar.dlH;
            this.pkgSize = fVar.size;
        }
    }

    public void l(g gVar) {
        if (gVar != null) {
            this.appId = gVar.appId;
            this.versionCode = gVar.versionCode;
            this.versionName = gVar.versionName;
            this.type = gVar.dlH;
            this.pkgSize = gVar.size;
        }
    }

    public void q(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null && TextUtils.equals(this.appId, pMSAppInfo.appId)) {
            this.versionCode = pMSAppInfo.versionCode;
            this.versionName = pMSAppInfo.versionName;
            this.type = pMSAppInfo.type;
            this.pkgSize = pMSAppInfo.pkgSize;
            this.createTime = pMSAppInfo.createTime;
            setOrientation(pMSAppInfo.getOrientation());
        }
    }

    public void aGj() {
        if (this.maxAge <= 0) {
            this.maxAge = DEFAULT_SWAN_APP_PKG_MAX_AGE;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean aaF() {
        return !TextUtils.isEmpty(this.appKey) && this.appSign > 0;
    }

    public String toString() {
        return "{appId=" + this.appId + ", appKey=" + this.appKey + ", appSign=" + this.appSign + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", description=" + this.description + ", appStatus=" + this.appStatus + ", statusDetail=" + this.statusDetail + ", statusDesc=" + this.statusDesc + ", resumeDate=" + this.resumeDate + ", iconUrl=" + this.iconUrl + ", appName=" + this.appName + ", serviceCategory=" + this.serviceCategory + ", subjectInfo=" + this.subjectInfo + ", type=" + this.type + ", pkgSize=" + this.pkgSize + ", pendingErrCode=" + this.pendingErrCode + ", appCategory=" + this.appCategory + ", orientation=" + this.orientation + ", maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", webViewDomains=" + this.webViewDomains + ", webAction=" + this.webAction + ", domains=" + this.domains + ", bearInfo=" + this.bearInfo + ", serverExt=" + this.serverExt + ", payProtected=" + this.payProtected + ", customerService=" + this.customerService + ", globalNotice=" + this.globalNotice + ", globalPrivate=" + this.globalPrivate + ", paNumber=" + this.paNumber + ", pluginInfo=" + this.pluginInfo + ", brandsInfo=" + this.brandsInfo + "}";
    }
}
