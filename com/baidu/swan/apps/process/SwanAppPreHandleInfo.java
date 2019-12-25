package com.baidu.swan.apps.process;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class SwanAppPreHandleInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppPreHandleInfo> CREATOR = new Parcelable.Creator<SwanAppPreHandleInfo>() { // from class: com.baidu.swan.apps.process.SwanAppPreHandleInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: B */
        public SwanAppPreHandleInfo createFromParcel(Parcel parcel) {
            return new SwanAppPreHandleInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fo */
        public SwanAppPreHandleInfo[] newArray(int i) {
            return new SwanAppPreHandleInfo[i];
        }
    };
    public String appId;
    public int category;
    public String iconUrl;
    public boolean independent;
    public String page;
    public String subPkgName;
    public String version;

    public SwanAppPreHandleInfo() {
    }

    private SwanAppPreHandleInfo(Parcel parcel) {
        this.iconUrl = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readString();
        this.category = parcel.readInt();
        this.page = parcel.readString();
        this.independent = parcel.readInt() == 1;
        this.subPkgName = parcel.readString();
    }

    public String toString() {
        return "SwanAppPreHandleInfo{iconUrl='" + this.iconUrl + "appId=" + this.appId + "version=" + this.version + "category=" + this.category + "page=" + this.page + "independent=" + this.independent + "subPkgName=" + this.subPkgName + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appId);
        parcel.writeString(this.version);
        parcel.writeInt(this.category);
        parcel.writeString(this.page);
        parcel.writeInt(this.independent ? 1 : 0);
        parcel.writeString(this.subPkgName);
    }
}
