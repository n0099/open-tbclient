package com.baidu.swan.apps.swancore.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
import d.a.l0.a.v2.l0;
/* loaded from: classes3.dex */
public class SwanCoreVersion extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanCoreVersion> CREATOR = new a();
    public static final int TYPE_DEBUG = 2;
    public static final int TYPE_PRESET = 0;
    public static final int TYPE_REMOTE = 1;
    public String swanCorePath;
    public int swanCoreType;
    public long swanCoreVersionCode;
    public String swanCoreVersionName;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<SwanCoreVersion> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwanCoreVersion createFromParcel(Parcel parcel) {
            return new SwanCoreVersion(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanCoreVersion[] newArray(int i2) {
            return new SwanCoreVersion[i2];
        }
    }

    public /* synthetic */ SwanCoreVersion(Parcel parcel, a aVar) {
        this(parcel);
    }

    public boolean a() {
        return l0.e(this.swanCorePath);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SwanCoreVersion{swanCorePath='" + this.swanCorePath + "', swanCoreVersionName=" + this.swanCoreVersionName + ", swanCoreVersionCode=" + this.swanCoreVersionCode + ", swanCoreType=" + this.swanCoreType + ", isAvailable=" + a() + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.swanCoreType);
        parcel.writeLong(this.swanCoreVersionCode);
        parcel.writeString(this.swanCoreVersionName);
        parcel.writeString(this.swanCorePath);
    }

    public SwanCoreVersion() {
    }

    public SwanCoreVersion(Parcel parcel) {
        this.swanCoreType = parcel.readInt();
        this.swanCoreVersionCode = parcel.readLong();
        this.swanCoreVersionName = parcel.readString();
        this.swanCorePath = parcel.readString();
    }
}
