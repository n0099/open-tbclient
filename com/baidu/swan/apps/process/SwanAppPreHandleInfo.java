package com.baidu.swan.apps.process;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class SwanAppPreHandleInfo extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppPreHandleInfo> CREATOR = new Parcelable.Creator<SwanAppPreHandleInfo>() { // from class: com.baidu.swan.apps.process.SwanAppPreHandleInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: j */
        public SwanAppPreHandleInfo createFromParcel(Parcel parcel) {
            return new SwanAppPreHandleInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cS */
        public SwanAppPreHandleInfo[] newArray(int i) {
            return new SwanAppPreHandleInfo[i];
        }
    };
    public String appId;
    public int avC;
    public String iconUrl;
    public String version;

    public SwanAppPreHandleInfo() {
    }

    private SwanAppPreHandleInfo(Parcel parcel) {
        this.iconUrl = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readString();
        this.avC = parcel.readInt();
    }

    public String toString() {
        return "SwanAppPreHandleInfo{iconUrl='" + this.iconUrl + "appId=" + this.appId + "version=" + this.version + "category" + this.avC + '}';
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
        parcel.writeInt(this.avC);
    }
}
