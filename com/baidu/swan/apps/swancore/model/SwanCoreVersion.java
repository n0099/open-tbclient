package com.baidu.swan.apps.swancore.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import java.io.File;
/* loaded from: classes3.dex */
public class SwanCoreVersion extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanCoreVersion> CREATOR = new a();
    public static final int TYPE_DEBUG = 2;
    public static final int TYPE_PRESET = 0;
    public static final int TYPE_REMOTE = 1;
    public String swanCorePath;
    public int swanCoreType;
    public long swanCoreVersion;

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
        public SwanCoreVersion[] newArray(int i) {
            return new SwanCoreVersion[i];
        }
    }

    public /* synthetic */ SwanCoreVersion(Parcel parcel, a aVar) {
        this(parcel);
    }

    public boolean a() {
        String[] list;
        if (TextUtils.isEmpty(this.swanCorePath)) {
            return false;
        }
        File file = new File(this.swanCorePath);
        return file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SwanCoreVersion{swanCorePath='" + this.swanCorePath + "', swanCoreVersion=" + this.swanCoreVersion + ", swanCoreType=" + this.swanCoreType + ", isAvailable=" + a() + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.swanCoreType);
        parcel.writeLong(this.swanCoreVersion);
        parcel.writeString(this.swanCorePath);
    }

    public SwanCoreVersion() {
    }

    public SwanCoreVersion(Parcel parcel) {
        this.swanCoreType = parcel.readInt();
        this.swanCoreVersion = parcel.readLong();
        this.swanCorePath = parcel.readString();
    }
}
