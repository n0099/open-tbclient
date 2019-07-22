package com.baidu.swan.pms.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class PMSAppInfo implements Parcelable {
    public static final Parcelable.Creator<PMSAppInfo> CREATOR = new Parcelable.Creator<PMSAppInfo>() { // from class: com.baidu.swan.pms.model.PMSAppInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: q */
        public PMSAppInfo createFromParcel(Parcel parcel) {
            return new PMSAppInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fH */
        public PMSAppInfo[] newArray(int i) {
            return new PMSAppInfo[i];
        }
    };
    public String appId;
    public String appKey;
    public String appName;
    public int appStatus;
    public String auS;
    public String auV;
    public String auW;
    public String auX;
    public long avg;
    public long bsG;
    public String bsH;
    public String bsI;
    public long bsJ;
    public int bsK;
    public int bsL;
    public String bsM;
    public String bsN;
    public String bsO;
    public String bsP;
    public long createTime;
    public String description;
    public String iconUrl;
    public int orientation;
    public int type;
    public int versionCode;
    public String versionName;

    public PMSAppInfo() {
        this.avg = 432000L;
    }

    private PMSAppInfo(Parcel parcel) {
        this.avg = 432000L;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.bsG = parcel.readLong();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.description = parcel.readString();
        this.appStatus = parcel.readInt();
        this.bsH = parcel.readString();
        this.bsI = parcel.readString();
        this.auS = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appName = parcel.readString();
        this.auV = parcel.readString();
        this.auW = parcel.readString();
        this.type = parcel.readInt();
        this.bsJ = parcel.readLong();
        this.bsK = parcel.readInt();
        this.bsL = parcel.readInt();
        this.orientation = parcel.readInt();
        this.avg = parcel.readLong();
        this.createTime = parcel.readLong();
        this.bsM = parcel.readString();
        this.bsN = parcel.readString();
        this.bsO = parcel.readString();
        this.auX = parcel.readString();
        this.bsP = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeLong(this.bsG);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.description);
        parcel.writeInt(this.appStatus);
        parcel.writeString(this.bsH);
        parcel.writeString(this.bsI);
        parcel.writeString(this.auS);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appName);
        parcel.writeString(this.auV);
        parcel.writeString(this.auW);
        parcel.writeInt(this.type);
        parcel.writeLong(this.bsJ);
        parcel.writeInt(this.bsK);
        parcel.writeInt(this.bsL);
        parcel.writeInt(this.orientation);
        parcel.writeLong(this.avg);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.bsM);
        parcel.writeString(this.bsN);
        parcel.writeString(this.bsO);
        parcel.writeString(this.auX);
        parcel.writeString(this.bsP);
    }

    public boolean Wm() {
        return this.bsK != 0;
    }

    public boolean Ct() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.avg;
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.appId = fVar.bsR;
            this.versionCode = fVar.versionCode;
            this.versionName = fVar.versionName;
            this.type = fVar.bsS;
            this.bsJ = fVar.size;
        }
    }

    public void h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null && TextUtils.equals(this.appId, pMSAppInfo.appId)) {
            this.versionCode = pMSAppInfo.versionCode;
            this.versionName = pMSAppInfo.versionName;
            this.type = pMSAppInfo.type;
            this.bsJ = pMSAppInfo.bsJ;
            this.createTime = pMSAppInfo.createTime;
            this.orientation = pMSAppInfo.orientation;
        }
    }

    public void Wn() {
        if (this.avg <= 0) {
            this.avg = 432000L;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean Wo() {
        return !TextUtils.isEmpty(this.appKey) && this.bsG > 0;
    }
}
