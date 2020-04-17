package com.baidu.swan.apps.extcore.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import java.io.File;
/* loaded from: classes11.dex */
public class ExtensionCore extends SwanAppIPCData {
    public static final Parcelable.Creator<ExtensionCore> CREATOR = new Parcelable.Creator<ExtensionCore>() { // from class: com.baidu.swan.apps.extcore.model.ExtensionCore.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: q */
        public ExtensionCore createFromParcel(Parcel parcel) {
            return new ExtensionCore(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: eX */
        public ExtensionCore[] newArray(int i) {
            return new ExtensionCore[i];
        }
    };
    public static final int TYPE_DEBUG = 2;
    public static final int TYPE_PRESET = 0;
    public static final int TYPE_REMOTE = 1;
    public String extensionCorePath;
    public int extensionCoreType;
    public long extensionCoreVersionCode;
    public String extensionCoreVersionName;

    public ExtensionCore() {
    }

    private ExtensionCore(Parcel parcel) {
        this.extensionCoreType = parcel.readInt();
        this.extensionCoreVersionCode = parcel.readLong();
        this.extensionCoreVersionName = parcel.readString();
        this.extensionCorePath = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.extensionCoreType);
        parcel.writeLong(this.extensionCoreVersionCode);
        parcel.writeString(this.extensionCoreVersionName);
        parcel.writeString(this.extensionCorePath);
    }

    public String toString() {
        return "ExtensionCore{extensionCoreType=" + this.extensionCoreType + ", extensionCoreVersionCode=" + this.extensionCoreVersionCode + ", extensionCoreVersionName=" + this.extensionCoreVersionName + ", extensionCorePath='" + this.extensionCorePath + "', isAvailable='" + isAvailable() + "'}";
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.extensionCorePath) && new File(this.extensionCorePath).exists();
    }
}
