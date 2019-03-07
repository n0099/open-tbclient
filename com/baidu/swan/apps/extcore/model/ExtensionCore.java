package com.baidu.swan.apps.extcore.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import java.io.File;
/* loaded from: classes2.dex */
public class ExtensionCore extends SwanAppIPCData {
    public static final Parcelable.Creator<ExtensionCore> CREATOR = new Parcelable.Creator<ExtensionCore>() { // from class: com.baidu.swan.apps.extcore.model.ExtensionCore.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: g */
        public ExtensionCore createFromParcel(Parcel parcel) {
            return new ExtensionCore(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cw */
        public ExtensionCore[] newArray(int i) {
            return new ExtensionCore[i];
        }
    };
    public int avJ;
    public long avK;
    public String avL;
    public String avM;

    public ExtensionCore() {
    }

    private ExtensionCore(Parcel parcel) {
        this.avJ = parcel.readInt();
        this.avK = parcel.readLong();
        this.avL = parcel.readString();
        this.avM = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.avJ);
        parcel.writeLong(this.avK);
        parcel.writeString(this.avL);
        parcel.writeString(this.avM);
    }

    public String toString() {
        return "ExtensionCore{extensionCoreType=" + this.avJ + ", extensionCoreVersionCode=" + this.avK + ", extensionCoreVersionName=" + this.avL + ", extensionCorePath='" + this.avM + "', isAvailable='" + isAvailable() + "'}";
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.avM) && new File(this.avM).exists();
    }
}
