package com.baidu.swan.pms.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class PMSAppInfo implements Parcelable {
    public static final Parcelable.Creator<PMSAppInfo> CREATOR = new Parcelable.Creator<PMSAppInfo>() { // from class: com.baidu.swan.pms.model.PMSAppInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public PMSAppInfo createFromParcel(Parcel parcel) {
            return new PMSAppInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gD */
        public PMSAppInfo[] newArray(int i) {
            return new PMSAppInfo[i];
        }
    };
    public String aOG;
    public String aOJ;
    public String aOK;
    public String aOL;
    public long aOT;
    public String appId;
    public String appKey;
    public String appName;
    public int appStatus;
    public long bLP;
    public String bLQ;
    public String bLR;
    public long bLS;
    public int bLT;
    public int bLU;
    public String bLV;
    public String bLW;
    public String bLX;
    public String bLY;
    public long createTime;
    public String description;
    public String iconUrl;
    public int orientation;
    public int type;
    public int versionCode;
    public String versionName;

    public PMSAppInfo() {
        this.aOT = 432000L;
    }

    private PMSAppInfo(Parcel parcel) {
        this.aOT = 432000L;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.bLP = parcel.readLong();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.description = parcel.readString();
        this.appStatus = parcel.readInt();
        this.bLQ = parcel.readString();
        this.bLR = parcel.readString();
        this.aOG = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appName = parcel.readString();
        this.aOJ = parcel.readString();
        this.aOK = parcel.readString();
        this.type = parcel.readInt();
        this.bLS = parcel.readLong();
        this.bLT = parcel.readInt();
        this.bLU = parcel.readInt();
        this.orientation = parcel.readInt();
        this.aOT = parcel.readLong();
        this.createTime = parcel.readLong();
        this.bLV = parcel.readString();
        this.bLW = parcel.readString();
        this.bLX = parcel.readString();
        this.aOL = parcel.readString();
        this.bLY = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeLong(this.bLP);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.description);
        parcel.writeInt(this.appStatus);
        parcel.writeString(this.bLQ);
        parcel.writeString(this.bLR);
        parcel.writeString(this.aOG);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appName);
        parcel.writeString(this.aOJ);
        parcel.writeString(this.aOK);
        parcel.writeInt(this.type);
        parcel.writeLong(this.bLS);
        parcel.writeInt(this.bLT);
        parcel.writeInt(this.bLU);
        parcel.writeInt(this.orientation);
        parcel.writeLong(this.aOT);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.bLV);
        parcel.writeString(this.bLW);
        parcel.writeString(this.bLX);
        parcel.writeString(this.aOL);
        parcel.writeString(this.bLY);
    }

    public boolean abf() {
        return this.bLT != 0;
    }

    public boolean Hr() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aOT;
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.appId = fVar.bMa;
            this.versionCode = fVar.versionCode;
            this.versionName = fVar.versionName;
            this.type = fVar.bMb;
            this.bLS = fVar.size;
        }
    }

    public void h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null && TextUtils.equals(this.appId, pMSAppInfo.appId)) {
            this.versionCode = pMSAppInfo.versionCode;
            this.versionName = pMSAppInfo.versionName;
            this.type = pMSAppInfo.type;
            this.bLS = pMSAppInfo.bLS;
            this.createTime = pMSAppInfo.createTime;
            this.orientation = pMSAppInfo.orientation;
        }
    }

    public void abg() {
        if (this.aOT <= 0) {
            this.aOT = 432000L;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean abh() {
        return !TextUtils.isEmpty(this.appKey) && this.bLP > 0;
    }
}
