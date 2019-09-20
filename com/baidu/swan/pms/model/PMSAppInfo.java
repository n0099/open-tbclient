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
        /* renamed from: fI */
        public PMSAppInfo[] newArray(int i) {
            return new PMSAppInfo[i];
        }
    };
    public String appId;
    public String appKey;
    public String appName;
    public int appStatus;
    public long avE;
    public String avq;
    public String avt;
    public String avu;
    public String avv;
    public long bte;
    public String btf;
    public String btg;
    public long bth;
    public int bti;
    public int btj;
    public String btk;
    public String btl;
    public String btm;
    public String btn;
    public long createTime;
    public String description;
    public String iconUrl;
    public int orientation;
    public int type;
    public int versionCode;
    public String versionName;

    public PMSAppInfo() {
        this.avE = 432000L;
    }

    private PMSAppInfo(Parcel parcel) {
        this.avE = 432000L;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.bte = parcel.readLong();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.description = parcel.readString();
        this.appStatus = parcel.readInt();
        this.btf = parcel.readString();
        this.btg = parcel.readString();
        this.avq = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appName = parcel.readString();
        this.avt = parcel.readString();
        this.avu = parcel.readString();
        this.type = parcel.readInt();
        this.bth = parcel.readLong();
        this.bti = parcel.readInt();
        this.btj = parcel.readInt();
        this.orientation = parcel.readInt();
        this.avE = parcel.readLong();
        this.createTime = parcel.readLong();
        this.btk = parcel.readString();
        this.btl = parcel.readString();
        this.btm = parcel.readString();
        this.avv = parcel.readString();
        this.btn = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeLong(this.bte);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.description);
        parcel.writeInt(this.appStatus);
        parcel.writeString(this.btf);
        parcel.writeString(this.btg);
        parcel.writeString(this.avq);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appName);
        parcel.writeString(this.avt);
        parcel.writeString(this.avu);
        parcel.writeInt(this.type);
        parcel.writeLong(this.bth);
        parcel.writeInt(this.bti);
        parcel.writeInt(this.btj);
        parcel.writeInt(this.orientation);
        parcel.writeLong(this.avE);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.btk);
        parcel.writeString(this.btl);
        parcel.writeString(this.btm);
        parcel.writeString(this.avv);
        parcel.writeString(this.btn);
    }

    public boolean Wq() {
        return this.bti != 0;
    }

    public boolean Cx() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.avE;
    }

    public void g(f fVar) {
        if (fVar != null) {
            this.appId = fVar.btp;
            this.versionCode = fVar.versionCode;
            this.versionName = fVar.versionName;
            this.type = fVar.btq;
            this.bth = fVar.size;
        }
    }

    public void h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null && TextUtils.equals(this.appId, pMSAppInfo.appId)) {
            this.versionCode = pMSAppInfo.versionCode;
            this.versionName = pMSAppInfo.versionName;
            this.type = pMSAppInfo.type;
            this.bth = pMSAppInfo.bth;
            this.createTime = pMSAppInfo.createTime;
            this.orientation = pMSAppInfo.orientation;
        }
    }

    public void Wr() {
        if (this.avE <= 0) {
            this.avE = 432000L;
        }
        this.createTime = System.currentTimeMillis();
    }

    public boolean Ws() {
        return !TextUtils.isEmpty(this.appKey) && this.bte > 0;
    }
}
