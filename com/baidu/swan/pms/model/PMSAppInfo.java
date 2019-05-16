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
        /* renamed from: fD */
        public PMSAppInfo[] newArray(int i) {
            return new PMSAppInfo[i];
        }
    };
    public int appCategory;
    public String appId;
    public String appKey;
    public String appName;
    public int appStatus;
    public long auC;
    public String aup;
    public String aus;
    public String aut;
    public String auu;
    public long brS;
    public String brT;
    public String brU;
    public long brV;
    public int brW;
    public String brX;
    public String brY;
    public String brZ;
    public String bsa;
    public long createTime;
    public String description;
    public String iconUrl;
    public int orientation;
    public int type;
    public int versionCode;
    public String versionName;

    public PMSAppInfo() {
        this.auC = 432000L;
    }

    private PMSAppInfo(Parcel parcel) {
        this.auC = 432000L;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.brS = parcel.readLong();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.description = parcel.readString();
        this.appStatus = parcel.readInt();
        this.brT = parcel.readString();
        this.brU = parcel.readString();
        this.aup = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appName = parcel.readString();
        this.aus = parcel.readString();
        this.aut = parcel.readString();
        this.type = parcel.readInt();
        this.brV = parcel.readLong();
        this.brW = parcel.readInt();
        this.appCategory = parcel.readInt();
        this.orientation = parcel.readInt();
        this.auC = parcel.readLong();
        this.createTime = parcel.readLong();
        this.brX = parcel.readString();
        this.brY = parcel.readString();
        this.brZ = parcel.readString();
        this.auu = parcel.readString();
        this.bsa = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeLong(this.brS);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.description);
        parcel.writeInt(this.appStatus);
        parcel.writeString(this.brT);
        parcel.writeString(this.brU);
        parcel.writeString(this.aup);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appName);
        parcel.writeString(this.aus);
        parcel.writeString(this.aut);
        parcel.writeInt(this.type);
        parcel.writeLong(this.brV);
        parcel.writeInt(this.brW);
        parcel.writeInt(this.appCategory);
        parcel.writeInt(this.orientation);
        parcel.writeLong(this.auC);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.brX);
        parcel.writeString(this.brY);
        parcel.writeString(this.brZ);
        parcel.writeString(this.auu);
        parcel.writeString(this.bsa);
    }

    public boolean Vt() {
        return this.brW != 0;
    }

    public boolean BL() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.auC;
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.appId = fVar.bsc;
            this.versionCode = fVar.versionCode;
            this.versionName = fVar.versionName;
            this.type = fVar.bsd;
            this.brV = fVar.size;
        }
    }

    public void h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null && TextUtils.equals(this.appId, pMSAppInfo.appId)) {
            this.versionCode = pMSAppInfo.versionCode;
            this.versionName = pMSAppInfo.versionName;
            this.type = pMSAppInfo.type;
            this.brV = pMSAppInfo.brV;
            this.createTime = pMSAppInfo.createTime;
            this.orientation = pMSAppInfo.orientation;
        }
    }

    public void Vu() {
        if (this.auC <= 0) {
            this.auC = 432000L;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean Vv() {
        return !TextUtils.isEmpty(this.appKey) && this.brS > 0;
    }
}
