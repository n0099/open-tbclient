package com.baidu.swan.pms.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.tieba.sg4;
import com.baidu.tieba.tg4;
/* loaded from: classes3.dex */
public class PMSAppInfo implements Parcelable {
    public static final Parcelable.Creator<PMSAppInfo> CREATOR = new a();
    public static final long DEFAULT_SWAN_APP_PKG_MAX_AGE = 432000;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 0;
    public static final int ORIENTATION_UNKNOWN = -1;
    public static final int STATUS_NO_ERROR = 0;
    public static final int UN_FORBIDDEN = 0;
    public static final int WEB_PERMIT_DOWNGRADE_ALLOW = 1;
    public int appCategory;
    public String appId;
    public String appKey;
    public String appName;
    public long appSign;
    public int appStatus;
    public String bearInfo;
    public String brandsInfo;
    public long createTime;
    public int csProtocolVersion;
    public int customerService;
    public String description;
    public String domainConfig;
    public String domains;
    public int globalNotice;
    public int globalPrivate;
    public String iconUrl;
    public int installSrc;
    public long lastLaunchTime;
    public int launchCount;
    public long maxAge;
    public int orientation;
    public String paNumber;
    public int payProtected;
    public int pendingErrCode;
    public long pkgSize;
    public String pluginInfo;
    public String quickAppKey;
    public int rank;
    public String resumeDate;
    public String serverExt;
    public String serviceCategory;
    public String statusDesc;
    public String statusDetail;
    public String subjectInfo;
    public int type;
    public String userActionApis;
    public long versionCode;
    public String versionName;
    public String webAction;
    public int webPermit;
    public String webUrl;
    public String webViewDomains;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PMSAppInfo() {
        this.orientation = -1;
        this.maxAge = DEFAULT_SWAN_APP_PKG_MAX_AGE;
        this.lastLaunchTime = 0L;
        this.launchCount = 0;
        this.installSrc = 0;
        this.webPermit = 0;
    }

    public boolean checkValid() {
        if (!TextUtils.isEmpty(this.appKey) && this.appSign > 0) {
            return true;
        }
        return false;
    }

    public int getInstallSrc() {
        return this.installSrc;
    }

    public long getLastLaunchTime() {
        return this.lastLaunchTime;
    }

    public int getLaunchCount() {
        return this.launchCount;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean hasPendingErrCode() {
        if (this.pendingErrCode != 0) {
            return true;
        }
        return false;
    }

    public void initMaxAgeInfo() {
        if (this.maxAge <= 0) {
            this.maxAge = DEFAULT_SWAN_APP_PKG_MAX_AGE;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean isForbiddenApp() {
        if (this.appStatus != 0) {
            return true;
        }
        return false;
    }

    public boolean isMaxAgeExpires() {
        if ((System.currentTimeMillis() - this.createTime) / 1000 > this.maxAge) {
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<PMSAppInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PMSAppInfo createFromParcel(Parcel parcel) {
            return new PMSAppInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PMSAppInfo[] newArray(int i) {
            return new PMSAppInfo[i];
        }
    }

    public PMSAppInfo(Parcel parcel) {
        this.orientation = -1;
        this.maxAge = DEFAULT_SWAN_APP_PKG_MAX_AGE;
        this.lastLaunchTime = 0L;
        this.launchCount = 0;
        this.installSrc = 0;
        this.webPermit = 0;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.appSign = parcel.readLong();
        this.versionCode = parcel.readLong();
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
        this.lastLaunchTime = parcel.readLong();
        this.launchCount = parcel.readInt();
        this.installSrc = parcel.readInt();
        this.quickAppKey = parcel.readString();
        this.webUrl = parcel.readString();
        this.webPermit = parcel.readInt();
        this.csProtocolVersion = parcel.readInt();
        this.rank = parcel.readInt();
        this.userActionApis = parcel.readString();
    }

    public void copyLocalAppInfoData(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || !TextUtils.equals(this.appId, pMSAppInfo.appId)) {
            return;
        }
        this.versionCode = pMSAppInfo.versionCode;
        this.versionName = pMSAppInfo.versionName;
        this.type = pMSAppInfo.type;
        this.pkgSize = pMSAppInfo.pkgSize;
        this.createTime = pMSAppInfo.createTime;
        updateLastLaunchTime(this.lastLaunchTime);
        updateLaunchCount(this.launchCount);
        setOrientation(pMSAppInfo.getOrientation());
        updateInstallSrc(pMSAppInfo.getInstallSrc());
    }

    public void copyMainPkgInfo(sg4 sg4Var) {
        if (sg4Var == null) {
            return;
        }
        this.appId = sg4Var.g;
        this.versionCode = sg4Var.i;
        this.versionName = sg4Var.j;
        this.type = sg4Var.o;
        this.pkgSize = sg4Var.k;
    }

    public void copySubPkgInfo(tg4 tg4Var) {
        if (tg4Var == null) {
            return;
        }
        this.appId = tg4Var.o;
        this.versionCode = tg4Var.i;
        this.versionName = tg4Var.j;
        this.type = tg4Var.q;
        this.pkgSize = tg4Var.k;
    }

    public void countLaunch(long j) {
        if (0 >= j) {
            j = System.currentTimeMillis();
        }
        updateLastLaunchTime(j);
        this.launchCount++;
    }

    public void setOrientation(int i) {
        if (-1 < i) {
            this.orientation = i;
        }
    }

    public void updateInstallSrc(int i) {
        if (this.installSrc == 0 && i > 0) {
            this.installSrc = i;
        }
    }

    public void updateLastLaunchTime(long j) {
        this.lastLaunchTime = Math.max(j, this.lastLaunchTime);
    }

    public void updateLaunchCount(int i) {
        this.launchCount = Math.max(i, this.launchCount);
    }

    public String toString() {
        return "{appId=" + this.appId + ", appKey=" + this.appKey + ", appSign=" + this.appSign + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", description=" + this.description + ", appStatus=" + this.appStatus + ", statusDetail=" + this.statusDetail + ", statusDesc=" + this.statusDesc + ", resumeDate=" + this.resumeDate + ", iconUrl=" + this.iconUrl + ", appName=" + this.appName + ", serviceCategory=" + this.serviceCategory + ", subjectInfo=" + this.subjectInfo + ", type=" + this.type + ", pkgSize=" + this.pkgSize + ", pendingErrCode=" + this.pendingErrCode + ", appCategory=" + this.appCategory + ", orientation=" + this.orientation + ", maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", webViewDomains=" + this.webViewDomains + ", webAction=" + this.webAction + ", domains=" + this.domains + ", bearInfo=" + this.bearInfo + ", serverExt=" + this.serverExt + ", payProtected=" + this.payProtected + ", customerService=" + this.customerService + ", globalNotice=" + this.globalNotice + ", globalPrivate=" + this.globalPrivate + ", paNumber=" + this.paNumber + ", pluginInfo=" + this.pluginInfo + ", brandsInfo=" + this.brandsInfo + ", lastLaunchTime=" + this.lastLaunchTime + ", launchCount=" + this.launchCount + ", installSrc=" + this.installSrc + ", quickAppKey=" + this.quickAppKey + ", webUrl=" + this.webUrl + ", webPermit=" + this.webPermit + ", csProtocolVersion=" + this.csProtocolVersion + ", userActionApis=" + this.userActionApis + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeLong(this.appSign);
        parcel.writeLong(this.versionCode);
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
        parcel.writeLong(this.lastLaunchTime);
        parcel.writeInt(this.launchCount);
        parcel.writeInt(this.installSrc);
        parcel.writeString(this.quickAppKey);
        parcel.writeString(this.webUrl);
        parcel.writeInt(this.webPermit);
        parcel.writeInt(this.csProtocolVersion);
        parcel.writeInt(this.rank);
        parcel.writeString(this.userActionApis);
    }
}
