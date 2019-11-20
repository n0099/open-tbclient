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
        /* renamed from: gC */
        public PMSAppInfo[] newArray(int i) {
            return new PMSAppInfo[i];
        }
    };
    public long aOB;
    public String aOo;
    public String aOr;
    public String aOs;
    public String aOt;
    public String appId;
    public String appKey;
    public String appName;
    public int appStatus;
    public long bKY;
    public String bKZ;
    public String bLa;
    public long bLb;
    public int bLc;
    public int bLd;
    public String bLe;
    public String bLf;
    public String bLg;
    public String bLh;
    public long createTime;
    public String description;
    public String iconUrl;
    public int orientation;
    public int type;
    public int versionCode;
    public String versionName;

    public PMSAppInfo() {
        this.aOB = 432000L;
    }

    private PMSAppInfo(Parcel parcel) {
        this.aOB = 432000L;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.bKY = parcel.readLong();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.description = parcel.readString();
        this.appStatus = parcel.readInt();
        this.bKZ = parcel.readString();
        this.bLa = parcel.readString();
        this.aOo = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appName = parcel.readString();
        this.aOr = parcel.readString();
        this.aOs = parcel.readString();
        this.type = parcel.readInt();
        this.bLb = parcel.readLong();
        this.bLc = parcel.readInt();
        this.bLd = parcel.readInt();
        this.orientation = parcel.readInt();
        this.aOB = parcel.readLong();
        this.createTime = parcel.readLong();
        this.bLe = parcel.readString();
        this.bLf = parcel.readString();
        this.bLg = parcel.readString();
        this.aOt = parcel.readString();
        this.bLh = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeLong(this.bKY);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.description);
        parcel.writeInt(this.appStatus);
        parcel.writeString(this.bKZ);
        parcel.writeString(this.bLa);
        parcel.writeString(this.aOo);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appName);
        parcel.writeString(this.aOr);
        parcel.writeString(this.aOs);
        parcel.writeInt(this.type);
        parcel.writeLong(this.bLb);
        parcel.writeInt(this.bLc);
        parcel.writeInt(this.bLd);
        parcel.writeInt(this.orientation);
        parcel.writeLong(this.aOB);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.bLe);
        parcel.writeString(this.bLf);
        parcel.writeString(this.bLg);
        parcel.writeString(this.aOt);
        parcel.writeString(this.bLh);
    }

    public boolean abd() {
        return this.bLc != 0;
    }

    public boolean Hs() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aOB;
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.appId = fVar.bLj;
            this.versionCode = fVar.versionCode;
            this.versionName = fVar.versionName;
            this.type = fVar.bLk;
            this.bLb = fVar.size;
        }
    }

    public void h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null && TextUtils.equals(this.appId, pMSAppInfo.appId)) {
            this.versionCode = pMSAppInfo.versionCode;
            this.versionName = pMSAppInfo.versionName;
            this.type = pMSAppInfo.type;
            this.bLb = pMSAppInfo.bLb;
            this.createTime = pMSAppInfo.createTime;
            this.orientation = pMSAppInfo.orientation;
        }
    }

    public void abe() {
        if (this.aOB <= 0) {
            this.aOB = 432000L;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean abf() {
        return !TextUtils.isEmpty(this.appKey) && this.bKY > 0;
    }
}
