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
        /* renamed from: o */
        public ExtensionCore createFromParcel(Parcel parcel) {
            return new ExtensionCore(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ds */
        public ExtensionCore[] newArray(int i) {
            return new ExtensionCore[i];
        }
    };
    public int aQD;
    public long aQE;
    public String aQF;
    public String aQG;

    public ExtensionCore() {
    }

    private ExtensionCore(Parcel parcel) {
        this.aQD = parcel.readInt();
        this.aQE = parcel.readLong();
        this.aQF = parcel.readString();
        this.aQG = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aQD);
        parcel.writeLong(this.aQE);
        parcel.writeString(this.aQF);
        parcel.writeString(this.aQG);
    }

    public String toString() {
        return "ExtensionCore{extensionCoreType=" + this.aQD + ", extensionCoreVersionCode=" + this.aQE + ", extensionCoreVersionName=" + this.aQF + ", extensionCorePath='" + this.aQG + "', isAvailable='" + isAvailable() + "'}";
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.aQG) && new File(this.aQG).exists();
    }
}
